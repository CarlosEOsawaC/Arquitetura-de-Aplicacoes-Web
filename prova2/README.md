# Avaliação 02 - API de Autenticação e Autorização JWT (AV2)
## Objetivo
Este projeto é focado na implementação de autenticação JWT, segurança, testes, monitoramento e deploy da API.
## Extensões e outras tecnologias
### Extensões
Esse projeto foi desenvolvido no <a href="https://code.visualstudio.com/" target="_blank">Visual Studio Code</a>. Para desenvolvê-lo foi necessário instalar as seguintes extensões:
- Spring Boot Extension Pack
- Extension Pack for Java
- Lombok Annotations Support for VS Code
### Apache JMeter
O JMeter é essencial pra simular muitos usuários e requisições (testes de carga), avaliando o desempenho da API.

<a href="https://jmeter.apache.org/download_jmeter.cgi" target="_blank">Apache JMeter Downloads</a>
### Docker
O Docker é uma plataforma de contenção de software que permite empacotar uma aplicação e todas as suas dependências em um ambiente isolado chamado container. Isso garante que a aplicação rode de forma consistente em qualquer lugar, seja no seu computador, em um servidor ou na nuvem.

<a href="https://www.docker.com/" target="_blank">Docker</a>
## Dependências
🌐 <a href="" target="_blank">Spring Boot Starter Web</a> – Construção de APIs RESTful.

🔒 <a href="" target="_blank">Spring Boot Starter Security</a> – Autenticação e autorização.

🔑 <a href="" target="_blank">Spring Boot Starter OAuth2 Resource Server</a> – Validação de tokens JWT.

🗄️ <a href="" target="_blank">Spring Boot Starter Data JPA</a> – Persistência de dados.

💾 <a href="" target="_blank">H2 Database</a> – Banco de dados em memória para testes.

📚 <a href="" target="_blank">Springdoc OpenAPI</a> – Geração automática da documentação via Swagger UI.

🛠️ <a href="" target="_blank">Spring Boot DevTools</a> – Ferramentas para desenvolvimento ágil.

🍬 <a href="" target="_blank">Lombok</a> – Redução de código repetitivo.

✅ <a href="" target="_blank">Spring Boot Starter Test</a> – JUnit 5 e Mockito para testes unitários.

🩺 <a href="" target="_blank">Spring Boot Actuator</a> – Monitoramento e métricas da API.

📊 <a href="" target="_blank">Prometheus</a> – Coleta de métricas de uso da API em tempo real.
## Estrutura do Projeto
```
prova2
├── jmeter-tests
│   └── login_stress_test.jmx
├── src
│   ├── main
│   │   ├── java
│   │   │   └── com
│   │   │       └── example
│   │   │           └── prova2
│   │   │               ├── Prova2Application.java
│   │   │               ├── config
│   │   │               │   ├── SecurityConfig.java
│   │   │               │   └── SwaggerConfig.java
│   │   │               ├── controller
│   │   │               │   ├── AuthController.java
│   │   │               │   └── TestProtectedController.java
│   │   │               ├── dto
│   │   │               │   ├── AuthRequest.java
│   │   │               │   ├── AuthResponse.java
│   │   │               │   └── RegisterRequest.java
│   │   │               ├── model
│   │   │               │   ├── User.java
│   │   │               │   └── UserRole.java
│   │   │               ├── repository
│   │   │               │   └── UserRepository.java
│   │   │               └── service
│   │   │                   ├── AuthService.java
│   │   │                   └── JwtService.java
│   │   └── resources
│   │       ├── application.properties
│   │       ├── application.yml
│   │       └── prometheus.yml
│   └── test
│       └── java
│           └── com
│               └── example
│                   └── prova2
│                       ├── AuthIntegrationTests.java
│                       └── Prova2ApplicationTests.java
├── Dockerfile.spring
├── docker-compose.yml
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
## Swagger
É uma interface web interativa que roda localmente (no seu navegador) para visualizar e testar APIs REST.
  - Para acessar o Swagger:
    - Execute o projeto (o projeto precisa estar em execução): <code>mvn spring-boot:run</code>.
    - Acesse no navegador: http://localhost:8080/swagger-ui/index.html#/

<img align="center" src="https://github.com/CarlosEOsawaC/Arquitetura-de-Aplicacoes-Web/blob/main/Img%20AAW%20README/Swagger%20Local.png"/>

## Testes de carga com JMeter
Testes de carga com Apache JMeter servem para avaliar o desempenho de um sistema (como uma API, site ou aplicativo) quando vários usuários acessam ao mesmo tempo.
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
