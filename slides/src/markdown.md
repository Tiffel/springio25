## Spring IO 2025 

<img src="PXL_20250522_141919984.jpg" width="800">
<img src="PXL_20250522_063343822.jpg" width="800">
<br>

#### Agenda
1. state of spring, current trends
1. talk recommendations (watch that later!)
1. Spring AI Demo

---
## State of spring
#### Now 
* Boot 3.5 just released.
* Uses Framework 6.2
* [OSS support until 2026-06-30](https://spring.io/projects/spring-boot#support)

#### Future
* Java 25 in september 2025
* Framework 7 + Boot 4 in november 2025
* Java 17 baseline stays, but it's optimized for Java 25
* If you are still on Java 17, skip 21, go straight to 25!

---
## Major updates for Framework 7
#### dependencies
* Jakarta EE 11 (Tomcat 11, Hibernate ORM 7, Hibernate Validator 9)
* Jackson 3, JUnit 6

#### internal efforts
* JSpecify for nullability
* Project Leyden support (optimization for Java 25)

#### features for us
* Rest API Versioning
* Spring Data 4: JPA overhaul
* HTTP Service Registry

---
## Behind the scenes - Talks with Broadcom employees 
* Licence Costs for ESXi etc. are "not that bad". LOL
* Finally, there is focus in the infrastructure part
<br>

* VMware Tanzu is a business unit inside Broadcom
* They are profitable and left alone
* commitment to spring and open source is ensured



---
## talk recommendations - must watch
youtube links will be added when available!

* [Keynote](https://www.youtube.com/watch?v=oUK1Np4OvnM)
  * Everything interesting starts from here
* Top 10 Rest API Design Pitfalls
  * Everybody has made or will make these errors. Helpful and a very fun presentation by [Victor](https://victorrentea.ro/)
* Virtual Threads, Structured Concurrency and Scoped Values: Putting it all together
  * This will change the style we write java. you will need this!

----
## talk recommendations - special interest
youtube links will be added when available!

* Code Once, Use Everywhere: Building Shared Libraries for Multiple Projects
  * If you have a large project, you probably want this
* Modern Authentication Demystified: A Deep Dive into Spring Security’s Latest Innovations
  * Oauth token exchange, OTP, Passkeys
* API Versioning In Spring Framework 7
  * Missleading title. this is for rest apis 
* Getting your application production-ready with Actuator
  * Nothing new or fancy, but if you do not know about actuator, watch this!
* Mastering Challenges of Cloud-Native Architectures With Spring
  * Spring Cloud live demo
* Spring for Apache Kafka the advanced features

----
## talk recommendations - entertainment
youtube links will be added when available!

* From Beans to Boot, Aspects to AI
  * Stories from the early days of spring with Rod Johnson, Jürgen Höller and Josh Long
* Bootiful GraalVM
  * Live coding with Josh Long is always fun
* Exposing the Interview Process
    * A crazy loud shouting american recruiter explains "how to land a job"

----
## talk recommendations - very special interest
youtube links will be added when available!

* Panta rhei: runtime configuration updates with Spring Boot
* Dependency Injection Revisited
  * If you need to unterstand this, you may have bigger problems in your software than spring
* A cloud cost saving journey: Strategies to balance CPU for containerized JAVA workloads in K8s

---
## Spring AI

>The moment I became interested in AI was when I realized I could access it through a REST API.


----
## Spring AI
Spring AI addresses the fundamental challenge of AI integration:
Connecting your enterprise Data and APIs with AI Models.
#### Features
  * Model integration
    * Chat, Embedding, Image, Audio
    * provider agnostic
  * Conversation memory
  * Structured output
  * Vector database integration (embedding, ingestion and retrieval)
  * Tool calling, including MCP Client integration
  * MCP Server
  * Pattern support (RAG, agentic-systems)

---
## AI gets useful
>Have you heard about the MCP Hype? It's like the new kubernetes

* Fast and cheap opensource LLMs
* Patterns for agentic systems have emerged
* MCP leads to standardization and reuse




---
## Spring AI
>Learning JPA without knowing SQL makes no sense!

Spring AI has a really [great documentation](https://docs.spring.io/spring-ai/reference/index.html), including a concepts section

### talk recommendations
* Modular RAG Architectures with Java and Spring AI
* From Single-Shot LLMs to Intelligent Agents: Building Scalable AI Systems with Spring AI and MCP


---
## demo time
❤️  

