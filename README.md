# PassGeneration API (Spring Boot)

Backend para sistema de autenticação de usuários com JWT e persistência MySQL.

## 🚀 Stack Tecnológico

- **Java 21**
- **Spring Boot 4.0.5**
- **Spring Security + JWT**
- **Spring Data JPA**
- **MySQL 8.0**
- **Maven**

## ⚙️ Ambiente

### ✅ Pré-requisitos
- **Java 21+**
- **Maven 3.8+**
- **MySQL 8.0+**

### ✅ Database Setup
```sql
CREATE DATABASE passgeneration;
```

### ✅ Configuração
**Arquivo:** `src/main/resources/application.properties`

```properties
spring.application.name=passgeneration

spring.datasource.url=jdbc:mysql://localhost:3306/passgeneration?createDatabaseIfNotExist=true&useSSL=false&serverTimezone=UTC
spring.datasource.username=root
spring.datasource.password=SUA_SENHA_AQUI

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true

jwt.secret=seuSegredoJwtCom32CaracteresNoMinimo123
```

## ▶️ Executar

### Terminal
```bash
./mvnw spring-boot:run
```

### IDE
1. Importar projeto Maven
2. Executar `PassgenerationApplication.java`

**Server:** http://localhost:8080

## � Autenticação JWT

**Flow:** signup → signin → token → acesso protegido

**Header:** `Authorization: Bearer TOKEN`

## 📡 API Endpoints

### 🔹 Signup
**POST** `/signup`

```json
{
  "nome": "João Silva",
  "email": "joao@email.com",
  "password": "senha123",
  "confirmPassword": "senha123"
}
```

### 🔹 Signin
**POST** `/signin`

```json
{
  "email": "joao@email.com",
  "password": "senha123"
}
```

**Response:**
```json
{
  "token": "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9..."
}
```

### � Signout
**GET** `/signout`

## 🏗️ Estrutura do Projeto

```
src/main/java/com/example/passgeneration/
├── Controller/
│   └── AuthController.java
├── Entity/
│   └── User.java
├── Repository/
│   └── UserRepository.java
├── Service/
│   └── AuthService.java
├── Config/
│   ├── SecurityConfig.java
│   └── CorsConfig.java
└── Utils/
    └── JwtUtil.java
```

## 📦 Dependências Maven

- `spring-boot-starter-web`
- `spring-boot-starter-security`
- `spring-boot-starter-data-jpa`
- `mysql-connector-j`
- `jjwt-api` `jjwt-impl` `jjwt-jackson`
- `spring-boot-starter-validation`

## 🔧 Comandos Maven

```bash
# Build
./mvnw clean compile

# Test
./mvnw test

# Package
./mvnw clean package

# Run JAR
java -jar target/passgeneration-0.0.1-SNAPSHOT.jar
```
