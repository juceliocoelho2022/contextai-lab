import React, { useState } from 'react'
import { createRoot } from 'react-dom/client'
import './styles.css'

type Token = {
  position: number
  token: string
  tokenId: number
}

type AnalyzeResponse = {
  originalText: string
  tokenCount: number
  tokens: Token[]
  explanation: string
}

function App() {
  const [text, setText] = useState('O banco aprovou o crédito')
  const [result, setResult] = useState<AnalyzeResponse | null>(null)
  const [loading, setLoading] = useState(false)
  const [error, setError] = useState('')

  async function analyze() {
    setLoading(true)
    setError('')

    try {
      const response = await fetch('http://localhost:8080/api/analyze', {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify({ text })
      })

      if (!response.ok) {
        throw new Error('Não foi possível analisar o texto.')
      }

      setResult(await response.json())
    } catch (e) {
      setError(e instanceof Error ? e.message : 'Erro inesperado')
    } finally {
      setLoading(false)
    }
  }

  return (
    <main className="page">
      <section className="hero">
        <span className="badge">SPRINT 1 • TOKENIZAÇÃO</span>
        <h1>ContextAI Lab</h1>
        <p>Laboratório educacional de NLP, Embeddings, RAG e Agentes com Java + Spring Boot.</p>
      </section>

      <section className="card">
        <label htmlFor="text">Digite uma frase</label>
        <textarea
          id="text"
          value={text}
          onChange={(e) => setText(e.target.value)}
          rows={4}
        />
        <button onClick={analyze} disabled={loading || !text.trim()}>
          {loading ? 'Analisando...' : 'Analisar'}
        </button>
        {error && <p className="error">{error}</p>}
      </section>

      {result && (
        <section className="card">
          <div className="section-title">
            <h2>Tokens</h2>
            <strong>{result.tokenCount}</strong>
          </div>

          <div className="tokens">
            {result.tokens.map((item) => (
              <article className="token" key={`${item.position}-${item.token}`}>
                <span>{item.token}</span>
                <small>ID {item.tokenId}</small>
              </article>
            ))}
          </div>

          <p className="note">{result.explanation}</p>
        </section>
      )}

      <section className="roadmap">
        <h2>Roadmap</h2>
        <div className="steps">
          <span className="done">1. Tokenização</span>
          <span>2. Embeddings</span>
          <span>3. Similaridade</span>
          <span>4. pgvector</span>
          <span>5. RAG</span>
          <span>6. Tool Calling</span>
          <span>7. MCP / Agentes</span>
        </div>
      </section>
    </main>
  )
}

createRoot(document.getElementById('root')!).render(
  <React.StrictMode>
    <App />
  </React.StrictMode>
)
