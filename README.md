# ContextAI Lab

![ContextAI Lab - arquitetura e interface](docs/contextai-lab-overview.jpg)

Laboratório educacional para estudar, visualizar e demonstrar conceitos de IA moderna com foco em:

- Tokenização
- Embeddings
- Similaridade semântica
- PostgreSQL + pgvector
- RAG
- Tool Calling
- MCP
- Agentes de IA

## Sprint 1 entregue

A primeira versão implementa:

- Backend Java 21 + Spring Boot
- API REST `POST /api/analyze`
- Tokenização didática inicial
- IDs determinísticos para os tokens
- Frontend React + TypeScript
- Tela de análise visual
- Swagger/OpenAPI
- Health check
- Dockerfiles
- Docker Compose com PostgreSQL + pgvector já preparado para as próximas sprints

> Importante: os token IDs da Sprint 1 são didáticos. Eles ainda não são os IDs reais de um tokenizer de um LLM.

## Stack

### Backend
- Java 21
- Spring Boot 3.5.5
- Spring Web
- Bean Validation
- Actuator
- Springdoc OpenAPI
- JUnit 5

### Frontend
- React
- TypeScript
- Vite

### Infra
- Docker
- Docker Compose
- PostgreSQL 17
- pgvector

## Executar sem Docker

### Backend

```bash
cd backend
mvn spring-boot:run
```

API:

```text
http://localhost:8080
```

Swagger:

```text
http://localhost:8080/swagger-ui.html
```

### Frontend

```bash
cd frontend
npm install
npm run dev
```

Frontend:

```text
http://localhost:5173
```

## Executar com Docker

Na raiz do projeto:

```bash
docker compose up --build
```

Acessos:

```text
Frontend: http://localhost:3000
Backend:  http://localhost:8080
Swagger:  http://localhost:8080/swagger-ui.html
```

## Testar API

### Requisição

```http
POST /api/analyze
Content-Type: application/json
```

```json
{
  "text": "O banco aprovou o crédito"
}
```

### Exemplo de resposta

```json
{
  "originalText": "O banco aprovou o crédito",
  "tokenCount": 5,
  "tokens": [
    {
      "position": 0,
      "token": "O",
      "tokenId": 111
    }
  ],
  "explanation": "Nesta Sprint 1, os token IDs são didáticos e determinísticos."
}
```

## Roadmap

### Sprint 1
- [x] Estrutura inicial
- [x] API de análise textual
- [x] Visualização de tokens
- [x] React
- [x] Docker

### Sprint 2
- [ ] Spring AI
- [ ] Embeddings reais
- [ ] Visualização parcial do vetor
- [ ] Provider configurável

### Sprint 3
- [ ] Similaridade por cosseno
- [ ] Comparação entre frases
- [ ] Ranking semântico

### Sprint 4
- [ ] Persistência PostgreSQL
- [ ] pgvector
- [ ] Busca vetorial

### Sprint 5
- [ ] Upload de documentos
- [ ] Chunking
- [ ] RAG
- [ ] Recuperação Top-K

### Sprint 6
- [ ] Tool Calling
- [ ] Memória
- [ ] MCP
- [ ] Agentes

## Exemplo pedagógico

Compare:

```text
O banco aprovou o crédito.
```

com:

```text
Eu sentei no banco da praça.
```

O projeto será evoluído para demonstrar como embeddings e contexto diferenciam semanticamente os dois usos da palavra `banco`.

---
Projeto educacional e de portfólio: **ContextAI Lab**
