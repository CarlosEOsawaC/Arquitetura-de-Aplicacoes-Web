# API de Autenticação e Autorização JWT (Emissão e Validação Interna)
## Objetivo
Este projeto é sobre a construção de uma API Spring Boot que é o coração de uma autenticação. Ela é responsável por gerar tokens JWT para usuários que fizerem login e por validar esses mesmos tokens para proteger seus próprios recursos.
## Extensões e outras tecnologias
### Extensões
Esse projeto foi desenvolvido no <a href="https://code.visualstudio.com/" target="_blank">Visual Studio Code</a>. Para desenvolvê-lo foi necessário instalar as seguintes extensões:
- Spring Boot Extension Pack
- Extension Pack for Java
- Lombok Annotations Support for VS Code
### Apache JMeter
O JMeter é essencial pra simular muitos usuários e requisições (testes de carga), avaliando o desempenho da API.

<a href="https://jmeter.apache.org/download_jmeter.cgi" target="_blank">Apache JMeter Downloads</a>
## Dependências
Pra começar, adicione as dependências essenciais no seu <code>pom.xml</code>.
- <code>spring-boot-starter-web</code>: 🌐 Pra construir suas APIs RESTful.
  - <a href="https://docs.spring.io/spring-boot/reference/web/index.html" target="_blank">Documentação Oficial Spring Web</a>
- <code>spring-boot-starter-security</code>: 🔒 O core da segurança do Spring, pra autenticação e autorização.
  - <a href="https://docs.spring.io/spring-security/reference/index.html" target="_blank">Documentação Oficial Spring Security</a>
- <code>spring-boot-starter-oauth2-resource-server</code>: 🔑 Permite que sua API valide tokens JWT, agindo como um Servidor de Recursos.
  - <a href="https://docs.spring.io/spring-security/reference/servlet/oauth2/resource-server/jwt.html" target="_blank">Documentação Oficial Spring Security OAuth2 Resource Server</a>
- <code>spring-boot-starter-data-jpa</code>: 🗄️ Pra persistência de dados usando JPA.
  - <a href="https://docs.spring.io/spring-data/jpa/reference/#reference" target="_blank">Documentação Oficial Spring Data JPA</a>
- <code>com.h2database:h2</code>: 💾 Banco de dados em memória, perfeito pra desenvolvimento e testes.
  - <a href="https://www.h2database.com/html/main.html" target="_blank">Documentação Oficial H2 Database</a>
- <code>org.springdoc:springdoc-openapi-starter-webmvc-ui</code>: 📚 Gera a documentação automática da sua API com Swagger UI.
  - <a href="https://springdoc.org/" target="_blank">Documentação Oficial Springdoc OpenAPI</a>
- <code>org.springframework.boot:spring-boot-devtools</code>: 🛠️ Ferramentas que aceleram o desenvolvimento, como "hot reload".
  - <a href="https://docs.spring.io/spring-boot/index.html" target="_blank">Documentação Oficial Spring Boot DevTools</a>
- <code>org.projectlombok:lombok</code>: 🍬 Reduz aquele código repetitivo (getters, setters, etc.).
  - <a href="https://projectlombok.org/features/" target="_blank">Documentação Oficial Lombok</a>
- <code>org.springframework.boot:spring-boot-starter-test</code>: ✅ Inclui JUnit 5 e Mockito, essenciais pra testes.
  - <a href="https://docs.spring.io/spring-boot/reference/testing/index.html#testing" target="_blank">Documentação Oficial Spring Boot Testing</a>
## Estrutura do Projeto
```
authserver
├── jmeter-tests
│   └── login_stress_test.jmx
├── src
│   ├── main
│   │   ├── java
│   │   │   └── com
│   │   │       └── example
│   │   │           └── authserver
│   │   │               ├── AuthserverApplication.java
│   │   │               ├── config
│   │   │               │   ├── SecurityConfig.java
│   │   │               │   └── SwaggerConfig.java
│   │   │               ├── controller
│   │   │               │   ├── AuthController.java
│   │   │               │   └── TestProtectedController.java
│   │   │               ├── model
│   │   │               │   └── User.java
│   │   │               ├── repository
│   │   │               │   └── UserRepository.java
│   │   │               └── service
│   │   │                   ├── AuthService.java
│   │   │                   └── JwtService.java
│   │   └── resources
│   │       ├── application.properties
│   │       └── application.yml
│   └── test
│       └── java
│           └── com
│               └── example
│                   └── authserver
│                       ├── AuthIntegrationTests.java
│                       └── AuthserverApplicationTests.java
├── pom.xml
└── README.md
```
