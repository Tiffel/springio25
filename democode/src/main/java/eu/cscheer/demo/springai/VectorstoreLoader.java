package eu.cscheer.demo.springai;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.springframework.ai.document.Document;
import org.springframework.ai.reader.jsoup.JsoupDocumentReader;
import org.springframework.ai.reader.jsoup.config.JsoupDocumentReaderConfig;
import org.springframework.ai.reader.markdown.MarkdownDocumentReader;
import org.springframework.ai.reader.markdown.config.MarkdownDocumentReaderConfig;
import org.springframework.ai.vectorstore.VectorStore;
import org.springframework.context.ApplicationContext;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Service
public class VectorstoreLoader {

    private final ApplicationContext applicationContext;
    private final VectorStore vectorStore;

    @EventListener
    public void onApplicationEvent(ContextRefreshedEvent event) throws IOException {
        Resource[] markdownResources = applicationContext.getResources("classpath:/documents/*.md");
        loadMarkdown(markdownResources);

        Resource[] htmlResources = applicationContext.getResources("classpath:/documents/*.html");
        loadHtml(htmlResources);
    }

    private void loadMarkdown(Resource[] resources) {
        MarkdownDocumentReaderConfig config = MarkdownDocumentReaderConfig.builder()
                .withHorizontalRuleCreateDocument(true)
                .build();

        log.info("Found {} markdown ressources to read", resources.length);
        List<Document> documents = Arrays.stream(resources)
                .map(resource -> new MarkdownDocumentReader(resource, config))
                .map(MarkdownDocumentReader::read).flatMap(Collection::stream).toList();

        log.info("Found {} documents to add to vectorstore", documents.size());
        this.vectorStore.add(documents);
    }

    private void loadHtml(Resource[] resources) {
        JsoupDocumentReaderConfig config = JsoupDocumentReaderConfig.builder().build();

        log.info("Found {} html resources to read", resources.length);
        List<Document> documents = Arrays.stream(resources)
                .map(resource -> new JsoupDocumentReader(resource, config))
                .map(JsoupDocumentReader::read).flatMap(Collection::stream).toList();

        log.info("Found {} html to add to vectorstore", documents.size());
        this.vectorStore.add(documents);
    }
}
