# Documentação de Testes de API

## Requisitos
* JDK

## Ferramentas e Bibliotecas
* <a href="https://mvnrepository.com/artifact/io.rest-assured/rest-assured/5.4.0">REST Assured</a>
* <a href="https://mvnrepository.com/artifact/com.google.code.gson/gson/2.10.1">Gson</a>
* <a href="https://mvnrepository.com/artifact/com.github.javafaker/javafaker/1.0.2">Java Faker</a>

## Execução dos testes

## Estratégia de testes

## Bugs identificados
> **1. POST /products/add - postProduct**
- Ao realizar a requisição para criar um produto recebemos o status code 200 Ok como resposta, mas segundo os padrões Rest uma requisição com o método POST deve retornar o status code 201 Created.
> **2. POST /auth/login - postLogin**
- Ao realizar a requisição para efetuar o login recebemos o status code 200 Ok como resposta, mas segundo os padrões Rest uma requisição com o método POST deve retornar o status code 201 Created. 

