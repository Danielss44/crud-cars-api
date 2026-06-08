# CRUD Cars API

<<<<<<< HEAD
API REST para gerenciamento de veículos com autenticação JWT.

## Stack
- Java
- Spring Boot
- Spring Security
- JWT
- MySQL
- Swagger

## Funcionalidades
- Register/Login
- JWT Authentication
- CRUD de carros
- Controle de roles ADMIN/USER
=======
API REST desenvolvida com Spring Boot para gerenciamento de veículos, implementando autenticação JWT, autorização baseada em perfis e boas práticas de arquitetura em camadas.

O projeto foi criado com foco em aplicações backend corporativas utilizando Java, Spring Security, JPA e PostgreSQL.

---

## Tecnologias Utilizadas

* Java 21
* Spring Boot 3
* Spring Security
* JWT (JSON Web Token)
* Spring Data JPA
* PostgreSQL
* Maven
* Bean Validation
* Lombok

---

## Funcionalidades

### Autenticação e Segurança

* Cadastro de usuários
* Login com JWT
* Autenticação baseada em Token
* Controle de acesso por perfis
* Rotas protegidas pelo Spring Security

### Gerenciamento de Veículos

* Cadastro de veículos
* Consulta de veículos
* Atualização de veículos
* Exclusão de veículos
* Busca por ID

### Validações

* Validação de campos obrigatórios
* Validação de dados de entrada
* Tratamento de erros padronizado

### Tratamento de Exceções

* Exceções customizadas
* Tratamento global de erros
* Respostas padronizadas para falhas de validação e regras de negócio

---

## Arquitetura

O projeto segue o padrão de arquitetura em camadas:

```text
src/main/java

├── controller
├── service
├── repository
├── dto
├── entity
├── security
├── exception
└── config
```

### Responsabilidades

| Camada     | Responsabilidade           |
| ---------- | -------------------------- |
| Controller | Receber requisições HTTP   |
| Service    | Regras de negócio          |
| Repository | Acesso ao banco de dados   |
| DTO        | Transferência de dados     |
| Security   | Autenticação e autorização |
| Exception  | Tratamento de erros        |

---

## Fluxo de Autenticação

### 1. Registrar usuário

```http
POST /auth/register
```

### 2. Realizar login

```http
POST /auth/login
```

### 3. Receber JWT

Resposta:

```json
{
  "token": "eyJhbGciOiJIUzI1NiJ9..."
}
```

### 4. Enviar Token nas requisições protegidas

```http
Authorization: Bearer SEU_TOKEN
```

---

## Endpoints

### Autenticação

#### Registrar usuário

```http
POST /auth/register
```

#### Login

```http
POST /auth/login
```

---

### Veículos

#### Listar veículos

```http
GET /cars
```

#### Buscar veículo por ID

```http
GET /cars/{id}
```

#### Criar veículo

```http
POST /cars
```

#### Atualizar veículo

```http
PUT /cars/{id}
```

#### Excluir veículo

```http
DELETE /cars/{id}
```

---

## Exemplo de Cadastro de Veículo

### Requisição

```json
{
  "brand": "Toyota",
  "model": "Corolla",
  "year": 2025,
  "price": 150000.00
}
```

### Resposta

```json
{
  "id": 1,
  "brand": "Toyota",
  "model": "Corolla",
  "year": 2025,
  "price": 150000.00
}
```

---

## Tratamento de Erros

### Exemplo de recurso não encontrado

```json
{
  "timestamp": "2026-06-08T15:30:00",
  "status": 404,
  "error": "Veículo não encontrado"
}
```

### Exemplo de erro de validação

```json
{
  "timestamp": "2026-06-08T15:30:00",
  "status": 400,
  "error": "Dados inválidos",
  "details": [
    "brand não pode estar vazio",
    "price deve ser maior que zero"
  ]
}
```

---

## Como Executar o Projeto

### Clonar repositório

```bash
git clone https://github.com/Danielss44/crud-cars-api.git
```

### Entrar na pasta

```bash
cd crud-cars-api
```

### Configurar banco PostgreSQL

Crie um banco de dados:

```sql
CREATE DATABASE crud_cars;
```

Configure as credenciais no arquivo:

```properties
application.properties
```

### Compilar projeto

```bash
mvn clean install
```

### Executar aplicação

```bash
mvn spring-boot:run
```

---

## Melhorias Implementadas

* Utilização de DTOs para entrada e saída de dados
* Conversão centralizada de Entity para DTO
* Controllers desacoplados das entidades
* Exceções customizadas
* Tratamento global de exceções
* Padronização das respostas de erro
* Bean Validation
* Uso de BigDecimal para valores monetários
* Melhor separação de responsabilidades entre camadas

---

## Melhorias Futuras

* Testes unitários com JUnit e Mockito
* Swagger/OpenAPI
* Docker e Docker Compose
* Paginação
* Filtros de pesquisa
* Testes de integração
* Pipeline CI/CD com GitHub Actions

---

## Autor

Daniel Seabra

GitHub:
https://github.com/Danielss44
>>>>>>> 956ea41 (refactor: melhorar arquitetura e padronização da API)
