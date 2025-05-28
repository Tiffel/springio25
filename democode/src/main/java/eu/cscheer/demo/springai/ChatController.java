package eu.cscheer.demo.springai;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.PromptChatMemoryAdvisor;
import org.springframework.ai.chat.client.advisor.SimpleLoggerAdvisor;
import org.springframework.ai.chat.memory.InMemoryChatMemoryRepository;
import org.springframework.ai.chat.memory.MessageWindowChatMemory;
import org.springframework.ai.rag.advisor.RetrievalAugmentationAdvisor;
import org.springframework.ai.rag.generation.augmentation.ContextualQueryAugmenter;
import org.springframework.ai.rag.retrieval.search.VectorStoreDocumentRetriever;
import org.springframework.ai.vectorstore.VectorStore;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ChatController {
    private final ChatClient chatClient;
    private final RetrievalAugmentationAdvisor retrievalAugmentationAdvisor;
    private final PromptChatMemoryAdvisor promptChatMemoryAdvisor;

    public ChatController(ChatClient.Builder chatClientBuilder, VectorStore vectorStore) {
        retrievalAugmentationAdvisor = RetrievalAugmentationAdvisor.builder()
                //without this, empty documents from vectorstore leads to ContextualQueryAugmenter.DEFAULT_EMPTY_CONTEXT_PROMPT_TEMPLATE
                .queryAugmenter(ContextualQueryAugmenter.builder().allowEmptyContext(true).build())
                .documentRetriever(VectorStoreDocumentRetriever.builder()
                        .similarityThreshold(0.60)
                        .vectorStore(vectorStore)
                        .build())
                .build();

        promptChatMemoryAdvisor = PromptChatMemoryAdvisor.builder(
                MessageWindowChatMemory.builder()
                        .chatMemoryRepository(new InMemoryChatMemoryRepository())
                        .build()
        ).build();

        this.chatClient = chatClientBuilder.defaultAdvisors(SIMPLE_LOGGER_ADVISOR).build();
    }

    @PostMapping("/")
    public String chat(@RequestBody String input) {
        return chatClient.prompt()
                .advisors(promptChatMemoryAdvisor, retrievalAugmentationAdvisor)
                .tools(new Tools())
                .system("You are an helpful Assistant and answer precise and short in one sentence."
                        + " If you do not know the answer, admit to it. do not lie. /no_think") //  /no_think
                .user(input)
                .call().content();
    }


    private static final SimpleLoggerAdvisor SIMPLE_LOGGER_ADVISOR = new SimpleLoggerAdvisor(
            request -> "\nSystem  : " + request.prompt().getSystemMessage().getText() + "\nRequest : " + request.prompt().getUserMessage().getText(),
            response -> "\nResponse: " + response.getResult().getOutput().getText(),
            0);
}
