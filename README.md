# MandaCaru Broker API

## Descrição
A Mandacaru Broker API é uma aplicação Spring Boot que fornece operações CRUD (Create, Read, Update, Delete) para gerenciar informações sobre ações (stocks).

## Recursos

### Listar Todas as Ações
Retorna uma lista de todas as ações disponíveis.

#### Endpoint:
```
GET /stocks
```

### Obter uma Ação por ID
Retorna os detalhes de uma ação específica com base no ID.

#### Endpoint:
```
GET /stocks/{id}
```

### Criar uma Nova Ação
Cria uma nova ação com base nos dados fornecidos.

#### Endpoint:
```
POST /stocks
```

#### Corpo da Solicitação (Request Body):
```json
{
  "symbol": "BBAS3",
  "companyName": "Banco do Brasil SA",
  "price": 56.97
}
```

### Atualizar uma Ação por ID
Atualiza os detalhes de uma ação específica com base no ID.

#### Endpoint:
```
PUT /stocks/{id}
```

#### Corpo da Solicitação (Request Body):
```json
{
  "symbol": "BBAS3",
  "companyName": "Banco do Brasil SA",
  "price": 59.97
}
```

### Excluir uma Ação por ID
Exclui uma ação específica com base no ID.

#### Endpoint:
```
DELETE /stocks/{id}
```

## Uso
1. Clone o repositório: `https://github.com/MenesesDani/MandacaruBroker.git`
2. Importe o projeto em sua IDE preferida.
3. Configure o banco de dados:
   
   - **PostgreSQL:**
     - Instale o PostgreSQL.
     - Crie um banco de dados com o nome `mandacarubroker`.
     - Atualize as configurações de banco de dados no arquivo `application.properties`.

   - **SqlServer:**
     - Instale o SqlServer.
     - Crie um banco de dados com o nome `mandacarubroker`.
     - Atualize as configurações de banco de dados no arquivo `application.properties`.

4. Execute o aplicativo Spring Boot.
5. Acesse a API em `http://localhost:8080`

## Requisitos
- Java 11 ou superior
- Maven
- Banco de dados

## Tecnologias Utilizadas
- Spring Boot
- Spring Data JPA
- Maven
- PostgreSQL

## Contribuições
Contribuições são bem-vindas!

## Licença
Este projeto está licenciado sob a Licença MIT.
