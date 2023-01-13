# Books

Projeto criado para o treinamento de Testes

## Etiquetas

![](https://img.shields.io/badge/Status-Em%20Desenvolvimento-orange)
![](https://img.shields.io/badge/Language-Java-brightgreen)
![](https://img.shields.io/badge/Framework-Spring%20Boot-brightgreen)
![](https://img.shields.io/badge/Arquitetura-Clean%20Arch-brightgreen)

## Tecnologias

* JDK 18
* Spring Boot
* Spring Data MongoDB
* Apache Kafka
* Open Feign
* Docker

## Rodando localmente

Clone o projeto:

```bash
  git clone git@github.com:danielwisky/books.git
```

Entre no diretório do projeto:

```bash
  cd books
```

Instale as dependências:

```bash
  mvn clean install
```

Inicie o servidor:

```bash
  mvn spring-boot:run
```

### Subindo o projeto com docker compose:

Gerar o pacote `jar` da reviseweb com o maven `mvn`:

```bash
mvn package
```

Subindo a aplicação usando o docker compose:

```bash
docker-compose up
```

## Rodando os testes

Para rodar os testes, rode o seguinte comando

```bash
  mvn clean test
```

## Documentação da API

- [Swagger](http://localhost:8080/swagger-ui.html)
- [API Docs](http://localhost:8080/v3/api-docs)

## Autores

- [@danielwisky](https://www.github.com/danielwisky)