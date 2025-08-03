# Projeto Integrador PubSub

Este é um projeto Java com arquitetura **multi-módulo**, desenvolvido com **Spring Boot**, **JPA**, **MongoDB** e **Apache Camel**, com o objetivo de integrar múltiplas fontes de dados (relacional e não relacional) e realizar integração com Redis e PubSub.

---

## 📁 Estrutura do Projeto

```

integrador/
├── module-orm/          → Módulo com persistência JPA (H2)
├── module-odm/          → Módulo com persistência MongoDB
├── module-integrador/   → Módulo principal de integração (Apache Camel, Redis)
└── pom.xml              → POM pai

````

---

## 📦 Módulos

### `module-orm`
- Responsável por interações com banco relacional (H2).
- Utiliza **Spring Data JPA**.
- Exemplo de tecnologias:
  - `spring-boot-starter-data-jpa`
  - `lombok`
  - `H2 Database`

### `module-odm`
- Responsável por interações com banco não relacional (MongoDB).
- Utiliza **Spring Data MongoDB**.

### `module-integrador`
- Módulo principal da aplicação.
- Orquestra o uso dos módulos `ORM` e `ODM`.
- Possui integração com **Apache Camel** e **Redis**.

---

## 🛠️ Como compilar

Na raiz do projeto (`integrador/`), execute:

```bash
mvn clean install
````

> 💡 Use o parâmetro `-U` se estiver enfrentando problemas de cache do Maven:

```bash
mvn clean install -U
```

---

## 🚀 Executando a aplicação

A aplicação principal está no módulo `module-integrador`. Após o build, você pode executá-la via:

```bash
cd module-integrador
mvn spring-boot:run
```

Ou, usando o JAR gerado:

```bash
java -jar target/module-integrador-1.0.0.jar
```

---

## 🧪 Testes

Cada módulo pode conter seus próprios testes. Para rodar os testes de todos os módulos:

```bash
mvn test
```

---

## 🔧 Requisitos

* Java 17
* Maven 3.8+

---

## ✅ Plugins utilizados

* `spring-boot-maven-plugin`
* `maven-compiler-plugin`
* `maven-surefire-plugin`

---

## 📄 Licença

Projeto acadêmico/desenvolvido para fins de estudo e demonstração de arquitetura modular.

---

```