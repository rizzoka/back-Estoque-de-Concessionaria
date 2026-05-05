# 🚗 Estoque de Concessionária — Back-end

API REST desenvolvida com **Spring Boot** para gerenciamento de carros, marcas e acessórios, com autenticação via JWT e controle de acesso por perfil.
> **Front-end:** [carros-front](https://github.com/rizzoka/Estoque-de-Concessionaria)

## 🛠️ Tecnologias

- Java 17+ / Spring Boot
- Spring Security + JWT (jjwt)
- Spring Data JPA + Hibernate
- MySQL
- Maven

## Configuração do Banco de Dados

Edite `src/main/resources/application.properties`:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/carros
spring.datasource.username=root
spring.datasource.password=sua_senha
```

O banco `carros` deve existir previamente. As tabelas são criadas/atualizadas automaticamente pelo Hibernate.

## 🚀 Como Rodar

```bash
./mvnw spring-boot:run
```

A API sobe em: **http://localhost:8080**

## 🔐 Autenticação e Controle de Acesso
 
O sistema utiliza **JWT (JSON Web Token)** para autenticação. Após o login bem-sucedido, o token é armazenado no `localStorage` e incluído automaticamente em todas as requisições via interceptor HTTP.

| Perfil | Permissões |
|--------|-----------|
| `ADMIN` | Acesso total — Carros, Marcas e Acessórios |
| `USER`  | Apenas Marcas e Acessórios |

## 🌐 Endpoints

**Auth**
| Método | Rota | Acesso |
|--------|------|--------|
| POST | `/api/login` | Público |

**Carros**
| Método | Rota | Acesso |
|--------|------|--------|
| GET | `/api/carro/findAll` | ADMIN |
| GET | `/api/carro/find/{id}` | Autenticado |
| GET | `/api/carro/findByNome?nome=` | Autenticado |
| POST | `/api/carro/save` | Autenticado |
| PUT | `/api/carro/update/{id}` | Autenticado |
| DELETE | `/api/carro/delete/{id}` | Autenticado |

**Marcas**
| Método | Rota | Acesso |
|--------|------|--------|
| GET | `/api/marca/findAll` | USER + ADMIN |
| GET | `/api/marca/find/{id}` | Autenticado |
| POST | `/api/marca/save` | Autenticado |
| PUT | `/api/marca/update/{id}` | Autenticado |
| DELETE | `/api/marca/delete/{id}` | Autenticado |

**Acessórios**
| Método | Rota | Acesso |
|--------|------|--------|
| GET | `/api/acessorio/findAll` | Autenticado |
| GET | `/api/acessorio/find/{id}` | Autenticado |
| POST | `/api/acessorio/save` | USER + ADMIN |
| PUT | `/api/acessorio/update/{id}` | USER + ADMIN |
| DELETE | `/api/acessorio/delete/{id}` | Autenticado |

## Estrutura do Projeto

```
src/main/java/com/carros/carros/
├── auth/          # Login, Usuario, JWT service
├── config/        # Security, filtros, exception handler
├── controller/    # Endpoints REST
├── entity/        # Entidades JPA (Carro, Marca, Acessorio)
├── repository/    # Interfaces JpaRepository
└── service/       # Regras de negócio
```

### Créditos

Projeto desenvolvido acompanhando o canal [Wellington de Oliveira](https://www.youtube.com/@wellfoz) no YouTube.
