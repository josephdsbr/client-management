<h1 align="center">Gerenciador de Clientes</h1>
<p align="center">Projeto desenvolvido para ser utilizado como base para o processo de cadastramento,
consulta e gerenciamento de clientes.</p>

Tabela de Conteúdos
===================
<p align="center">
    <a href="#informacoes">Informações</a>
    <a href="#features">Features</a>
    <a href="#pre-requistos">Pré-requisitos</a>
    <a href="#como-usar">Como Usar</a>
    <a href="#testes">Testes</a>
    <a href="#tecnologias">Tecnologias</a>
    <a href="#author">Autor</a>
</p>

<h4 style="font-weight: 900" align="center">Em Desenvolvimento</h4>

### [Informações](#informacoes)

Você conseguiria visualizar os ``endpoints`` disponibilizados nesta API acessando a rota `/swagger-ui.html`.


### Features

- [x] Implementação do Cadastro de Cidade.
- [x] Implementação do Cadastro de Cliente.
- [x] Implementação do Cadastro de Usuário.
- [x] Implementação da Atualização do Cliente.
- [x] Implementação da Busca por Cidades pelo nome.
- [x] Implementação da Busca por Cidade pelo Estado.
- [x] Implementação da Busca por Clientes por nome.
- [x] Implementação de Busca do Cliente pelo ID.
- [x] Implementação de Remoção Lógica de Cliente.
- [x] Implementação do Layer de Segurança.
- [x] Implementação de Autenticação via JWT.
- [x] Implementação dos Testes Unitários.
- [x] Configuração do Swagger.
- [x] Implementação de Interceptadores para tratar Exceções.

### [Pré-requisitos](#pre-requisitos)

Antes de começar você irá precisar ter instalados em sua máquina:
- [Java 8](https://www.java.com/pt-BR/download/help/java8_pt-br.html)
- [Maven](https://maven.apache.org/), [Intellij](https://www.jetbrains.com/pt-br/idea/) ou [Eclipse](https://www.eclipse.org/downloads/).

Para acessar a API deverão ser realizados o **cadastro de um usuário** e a **geração do token**.

Caso você esteja utilizando o **Intellij** a própria IDE faz o processo de instalação dos pacotes.

Contudo, caso você queira realizar via CMD utilizando o Maven, recomendo ler o artigo do [Alex Girão](https://medium.com/@alex.girao/importar-um-projeto-maven-spring-boot-ea10078b2bde).


### [Como Usar](#como-usar)

Antes de startar o projeto, será necessário ter um banco de dados SQL ([Postgres](https://www.postgresql.org/), [MySQL](https://www.mysql.com/), etc) e uma *secret* para o JWT.

Essas informações deverão ser inseridas nos arquivos ``application-[profile].yml``.

Já existe um banco PostgreSQL configurado em ``src/main/resources/application-dev.yml``, contudo ele é uma instância gratutia do [ElephantSQL](https://www.elephantsql.com/) e não aceita multiplas conexões.

### Testes

Há uma cobertura de testes unitários, recomendamos a utilização de um IDE para lhe auxiliar a rodá-los. 

### Tecnologias

As seguintes ferramentes foram usadas na construção do projeto;


- [Spring Framework](https://spring.io/projects/spring-boot)
- [Hibernate](https://hibernate.org/)
- [JUnit](https://junit.org/junit5/)
- [JWT](https://jwt.io/)
- [Swagger](https://swagger.io/)

### Autor

<a href="https://github.com/josephdsbr">
 <img style="border-radius: 50%;" src="https://avatars1.githubusercontent.com/u/42288345?s=460&u=3173ac53eabc99366999615e7a2623bcb6b1560f&v=4" width="100px;" alt=""/>
 <br />
 <sub><b>José Vinícius Santos de Melo</b></sub></a> <a href="https://github.com/josephdsbr" title="Josephdsbr">🚀</a>

Feito com ❤️ por José Vinícius 👋🏽 Entre em contato!

* **Instagram** - [@pajebr](https://www.instagram.com/pajebr/)
* **Linkedin** -  [josephdsbr](https://www.linkedin.com/in/josephdsbr)
* **GitHub** - [josephdsbr](https://github.com/josephdsbr)