# Avaliação 01 - Persistência de Dados com Spring Boot
## Objetivo
Implementar uma aplicação Spring Boot que utiliza MariaDB, Lombok, Web, DevTools e JPA para gerenciar um relacionamento entre duas entidades distintas, utilizando conceitos de persistência de dados e mapeamento.
## Extensões
Esse projeto foi desenvolvido no <a href="https://code.visualstudio.com/" target="_blank">Visual Studio Code</a>. Para desenvolvê-lo e testá-lo foi necessário instalar as seguintes extensões:
- Spring Boot Extension Pack
- Extension Pack for Java
- Lombok Annotations Support for VS Code
- Postman
## Dependências e início do projeto
Para começar o projeto entre no Visual Studio Code e pressione as teclas <code>Ctrl</code> + <code>Shift</code> + <code>P</code>, em seguida digite "Spring Initializr: Create a Maven Project" e pressione <code>Enter</code> para selecionar, em seguida selecione a versão Spring Boot (a utilizada foi: 3.4.5), selecione a linguagem Java, as duas opções seguintes podem ser alteradas ou mantidas pelo usuário (nesse projeto o "Group Id" foi mantido: "com.exemple", e o "Artifact Id" foi alterado para: "prova"), depois selecione Jar, selecione a versão Java instalada no seu Visual Studio Code (para saber a sua versão Java abra o terminal do Visual Studio Code e digite: java -version), e por fim selecione as dependências. As dependências utilizadas foram:
- Spring Data JPA
- Spring Web
- Lombok
- Spring Boot DevTools
##  Relacionamento entre as entidades
O projeto foi desenvolvido com base no relacionamento entre as entidades: Produto e Categoria. Este relacionamento é do tipo **muitos-para-um** (Many-to-One), onde:
- Uma **Categoria** pode ter vários **Produtos** associados a ela.
- Cada **Produto** pertence a uma única **Categoria**.
### Entidades
- Produto (Product):

  Representa um produto associado a uma categoria.
  
  Atributos: id, nome (name), preço (price), descrição (description), categoria (category).

- Categoria (Category):

  Representa uma categoria dentro da organização.

  Atributos: id, nome (name), descrição (description).

<img align="center" src="https://github.com/CarlosEOsawaC/Arquitetura-de-Aplicacoes-Web/blob/main/Img%20AAW%20README/ProdutoCategoria.png"/>

## Estrutura do projeto
```
prova
├── src
│   ├── main
│   │   ├── java
│   │   │   └── com
│   │   │       └── example
│   │   │           └── prova
│   │   │               ├── ProvaApplication.java
│   │   │               ├── controllers
│   │   │               │   ├── CategoryController.java
│   │   │               │   └── ProductController.java
│   │   │               ├── models
│   │   │               │   ├── Category.java
│   │   │               │   └── Product.java
│   │   │               ├── repositories
│   │   │               │   ├── CategoryRepository.java
│   │   │               │   └── ProductRepository.java
│   │   │               └── services
│   │   │                   ├── CategoryService.java
│   │   │                   └── ProductService.java
│   │   └── resources
│   │       └── application.yml
├── pom.xml
└── README.md
```
O projeto segue a estrutura padrão do Spring Boot:

- Controllers: Contém os controladores responsáveis por expor as APIs REST.
- Models: Contém as classes que representam as entidades do banco de dados.
- Repositories: Contém as interfaces para acesso ao banco de dados.
- Services: Contém a lógica de negócio da aplicação.
## Endpoints
### Produto (Product)
- Get /products: Lista todos os produtos.
- Get /products/{id}: Busca um produto por ID.
- Post /products: Adiciona um novo produto.
- Put /products/{id}: Atualiza um produto existente.
- Delete /products/{id}: Remove um produto por ID.
### Categoria (Category)
- Get /categories: Lista todos as categorias.
- Get /categories/{id}: Busca uma categoria por ID.
- Post /categories: Adiciona uma nova categoria.
- Put /categories/{id}: Atualiza uma categoria existente.
- Delete /categories/{id}: Remove uma categoria por ID.
## Configuração do Banco de Dados
O projeto utiliza o MariaDB como banco de dados. Para facilitar a configuração e execução do MariaDB, utilizamos o <a href="https://www.apachefriends.org/pt_br/index.html" target="_blank">XAMPP</a>, que fornece um ambiente integrado com MariaDB.

### Configurando o XAMPP
1. Baixe e instale o XAMPP a partir do <a href="https://www.apachefriends.org/pt_br/index.html" target="_blank">site oficial</a>.
2. Após a instalação, inicie o painel de controle do XAMPP.
3. Inicie o serviço do **MariaDB** clicando em "Start" no "MySQL" e no "Apache".
4. Em seguida clique em "Admin" para entrar no MariaDB.
5. Crie um novo banco de dados.
6. Configure as credenciais do banco de dados no arquivo <code>application.properties</code> ou <code>application.yml</code> do projeto:

```properties
spring.datasource.url=jdbc:mariadb://localhost:3306/seu_banco
spring.datasource.username=seu_usuario
spring.datasource.password=sua_senha
spring.jpa.hibernate.ddl-auto=update
```
## Executando o Projeto
1. Certifique-se de que o MariaDB está em execução no XAMPP.
2. Abra o projeto no **Visual Studio Code**.
3. Certifique-se de que a extensão **Spring Boot Extension Pack** está instalada no VS Code.
4. No painel do **Spring Boot Dashboard**, localize o projeto e clique no botão de "play" para iniciar a aplicação.
5. Acesse a aplicação no navegador ou via ferramentas como **Postman** em: `http://localhost:8080`.
