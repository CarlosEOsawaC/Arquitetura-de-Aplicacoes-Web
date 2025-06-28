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

## Como clonar e executar o projeto
### Clonar
#### No github
- Copie a URL (exemplo: <code>https://github.com/usuario/repositorio.git</code>).
#### No terminal ou prompt de comando do computador
1. Vá até a pasta onde quer colocar o projeto:
```
cd Documents/meus-projetos
```
2. Cole o comando com a URL copiada do GitHub:
```
git clone https://github.com/usuario/repositorio.git
```
Lembre-se de certificar-se que todas as dependências necessárias para o projeto estão presentes no seu <code>pom.xml</code>.
### Executar
- No Maven execute o projeto com:
```
mvn spring-boot:run
```

## Testes de carga com JMeter
### Instalação do JMeter
  1. Baixar: acesse <a href="https://jmeter.apache.org/download_jmeter.cgi" target="_blank">Apache JMeter Downloads</a>
  2. Extrair: Descompacte o arquivo.
  3. Executar: No diretório <code>bin</code>, execute <code>jmeter.bat</code> (Windows) ou <code>jmeter.sh</code> (Linux/macOS).
### Criando um Plano de Teste de Carga para Login
  1. Novo Test Plan: No JMeter, vá em <code>File</code> > <code>New</code>.
  2. Adicionar Thread Group: Clique direito em <code>Test Plan</code> > <code>Add</code> > <code>Threads (Users)</code> > <code>Thread Group</code>.

     - <code>Number of Threads (users)</code>: Por exemplo, <code>200</code> (simular 200 usuários simultâneos).
     - <code>Ramp-up period (seconds)</code>: Por exemplo, <code>20</code> (os 200 usuários iniciarão ao longo de 20 segundos).
     - <code>Loop Count</code>: Por exemplo, <code>10</code> (cada usuário fará 10 requisições de login). Para um teste contínuo, selecione <code>Forever</code>.
  
  3. Adicionar HTTP Request (Login): Clique direito no <code>Thread Group</code> > <code>Add</code> > <code>Sampler</code> > <code>HTTP Request</code>.

     - <code>Name</code>: <code>Login Request</code>
     - <code>Protocol</code>: <code>http</code>
     - <code>Server Name or IP</code>: <code>localhost</code>
     - <code>Port Number</code>: <code>8080</code>
     - <code>Method</code>: <code>POST</code>
     - <code>Path</code>: <code>/auth/login</code>
     - Parameters: Na seção "Parameters", clique em "Add" e adicione:
       - <code>username</code>: <code>admin</code>
       - <code>password</code>: <code>123456</code>

  4. Adicionar Listeners (para Visualizar Resultados):

     - Clique direito no <code>Thread Group</code> > <code>Add</code> > <code>Listener</code> > <code>View Results Tree</code>.
     - Clique direito no <code>Thread Group</code> > <code>Add</code> > <code>Listener</code> > <code>Summary Report</code>.

  5. Executar o Teste: Clique no botão verde <code>Start</code> (ou <code>Ctrl + R</code>). Deixe o teste rodar até que as requisições sejam concluídas ou o tempo configurado expire.
  6. Analisar os Relatórios: Após a execução, verifique os Listeners que você adicionou.

     - No <code>Summary Report</code>, você verá métricas consolidadas como <code>Average</code> (Tempo Médio de Resposta), <code>Error %</code> (Porcentagem de Erros), <code>Throughput</code> (Requisições por segundo), etc. Isso te dá uma visão geral do desempenho.
     - No <code>View Results Tree</code>, você pode inspecionar cada requisição individualmente, vendo o tempo de resposta, o status HTTP, e até mesmo os dados de requisição e resposta para depuração detalhada.

  7. Salvar o Plano de Teste JMeter:

     - Para salvar seu plano de teste e os elementos que você configurou (incluindo as configurações de Thread Group e HTTP Request), vá em <code>File</code> > <code>Save</code> (ou <code>Ctrl + S</code>).
     - Escolha um nome significativo para o arquivo (ex: <code>login_stress_test.jmx</code>) e salve-o em um local acessível dentro do seu projeto (por exemplo, crie uma pasta <code>jmeter-tests</code> na raiz do seu repositório).
     - Este arquivo <code>.jmx</code> é o que você deverá versionar no GitHub.
