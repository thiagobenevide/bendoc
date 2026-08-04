# 📖 bendoc

**A plataforma de documentação que vive dentro do seu código.**

O **bendoc** é uma plataforma de documentação *Local-First* e *Open Source* projetada para unir dois mundos que geralmente estão separados: a **Documentação Técnica (APIs)** e o **Levantamento de Requisitos de Software**.

Diferente de plataformas SaaS que exigem que você suba seus dados para uma nuvem de terceiros, o bendoc foca na integração profunda. Ele oferece uma experiência estilo "Documentação como Código" (Doc-as-Code) com um visual fluido de conexões (inspirado no Obsidian), permitindo que as regras de negócio e as rotas de API conversem no mesmo lugar.

---

## 🚀 Por que o bendoc?

Atualmente, as equipes enfrentam o problema da "Documentação Fragmentada":
- **Requisitos** ficam no Jira, Notion ou planilhas (difícis de manter sincronizados).
- **APIs** ficam no Swagger/OpenAPI (ótimos para devs, mas ruins para o PO).
- **READMEs** ficam gigantes e obsoletos rapidamente.

**O bendoc resolve isso unificando tudo:**
- 🔗 **Conexões Reais:** Visualize como um requisito de negócio se conecta a uma rota de API específica.
- 🛠️ **Integração Sem Atrito:** Instale um "Starter" na sua stack atual (Spring Boot, Node.js, Go, Python, etc.) e ele fará o trabalho pesado de extração.
- 🔒 **Privacidade Total:** Seus dados não saem do seu servidor. O motor de processamento roda localmente.
- 💰 **Custo Zero:** Sendo Open Source, você tem controle total sobre a infraestrutura.

---

## 🏗️ Arquitetura

O bendoc utiliza uma arquitetura de **Hub & Spokes**:

1.  **Starters (Os Spokes):** Pequenas bibliotecas/dependências para diferentes linguagens. Elas leem seu código, arquivos Markdown e arquivos Swagger, transformando tudo em um contrato JSON unificado.
2.  **Core Platform (O Hub):** Um motor de alto desempenho em **Go** que processa esses dados, constrói o grafo de conexões e serve a documentação.
3.  **Dashboard:** Uma interface visual moderna (Node.js + TypeScript) que permite navegar pelos requisitos, visualizar o grafo de conexões e ler a documentação técnica de forma integrada.

---

## 🛠️ Tecnologias Utilizadas

- **Core Engine:** [Go](https://go.dev/) (Alta performance e concorrência).
- **Dashboard:** [Node.js](https://nodejs.org/) + [TypeScript](https://www.typescriptlang.org/).
- **Starters:** Java (Spring Boot), Python, Node.js, Ruby, Go, etc.
- **Formato de Conteúdo:** [Markdown](https://en.wikipedia.org/wiki/Markdown).
- **Documentação Técnica:** [OpenAPI / Swagger](https://swagger.io/).

---

## 🚀 Como começar

*(Em breve: Instruções detalhadas de instalação e configuração)*

### Exemplo de uso com Spring Boot:
1. Adicione o starter ao seu `pom.xml`.
2. Crie uma pasta `/requirements` e coloque seus arquivos `.md`.
3. O bendoc fará o resto: lerá os arquivos, capturará o Swagger e disponibilizará o painel interno automaticamente.

---

## 🤝 Contribuição

Como um projeto Open Source, sua contribuição é bem-vinda!
- **Sugira melhorias** no design do grafo de conexões.
- **Crie novos Starters** para linguagens que ainda não temos suporte.
- **Ajude no Core** para tornar a extração de metadados ainda mais inteligente.

---

*Desenvolvido com paixão por documentação e engenharia de software.*
