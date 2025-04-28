# Avaliação 01 - Persistência de Dados com Spring Boot
## Objetivo:
Implementar uma aplicação Spring Boot que utiliza MariaDB, Lombok, Web, DevTools e JPA para gerenciar um relacionamento entre duas entidades distintas, utilizando conceitos de persistência de dados e mapeamento.
## Extensões:
Esse projeto foi desenvolvido no <a href="https://code.visualstudio.com/" target="_blank">Visual Studio Code</a>. Para desenvolvê-lo e testá-lo foi necessário instalar as seguintes extensões:
- Spring Boot Extension Pack
- Extension Pack for Java
- Lombok Annotations Support for VS Code
- Postman
## Dependências e início do projeto:
Para começar o projeto entre no Visual Studio Code e pressione as teclas <code>Ctrl</code> + <code>Shift</code> + <code>P</code>, em seguida digite "Spring Initializr: Create a Maven Project" e pressione <code>Enter</code> para selecionar, em seguida selecione a versão Spring Boot (a utilizada foi: 3.4.5), selecione a linguagem Java, as duas opções seguintes podem ser alteradas ou mantidas pelo usuário (nesse projeto o "Group Id" foi mantido: "com.exemple", e o "Artifact Id" foi alterado para: "prova"), depois selecione Jar, selecione a versão Java instalada no seu Visual Studio Code (para saber a sua versão Java abra o terminal do Visual Studio Code e digite: java -version), e por fim selecione as dependências. As dependências utilizadas foram:
- Spring Data JPA
- Spring Web
- Lombok
- Spring Boot DevTools
## Estrutura do projeto e relacionamento entre as entidades:
O projeto foi desenvolvido com base no relacionamento entre as entidades: Produto e Categoria (Many-to-One).

<img align="center" src="https://github.com/CarlosEOsawaC/Arquitetura-de-Aplicacoes-Web/blob/main/Img%20AAW%20README/ProdutoCategoria.png"/>

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
