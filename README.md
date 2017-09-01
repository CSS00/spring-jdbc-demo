# spring-jdbc-demo
Demo Project for Spring JDBC(with H2) 

## About
This is a simple demo project about using Spring JDBC. The project is using the embedded H2 database. But it can be easily configured to use MySQL by modifying the datasource configuration.

## API
* GET /contacts: get list of all contact instances  
  ```
  GET /contacts HTTP/1.1
  Host: localhost:8080
  Content-Type: application/json
  ```
* POST /contacts: create new contact
  ```
  POST /contacts HTTP/1.1
  Host: localhost:8080
  Content-Type: application/json

  {
    "name": "Alice",
    "email": "alice@123.com",
    "mobile": "1231231234"
  }
  ```
* GET /contacts/{id}: get contact by id
  ```
  GET /contacts/1 HTTP/1.1
  Host: localhost:8080
  Content-Type: application/json
  ```
* PUT /contacts/{id}: update contact
  ```
  PUT /contacts/1 HTTP/1.1
  Host: localhost:8080
  Content-Type: application/json

  {
    "name": "Alice",
    "email": "alice@gmail.com",
    "mobile": "1231231234"
  }
  ```
* DELETE /contacts/{id}: delete contact
  ```
  DELETE /contacts/1 HTTP/1.1
  Host: localhost:8080
  Content-Type: application/json
  ```
