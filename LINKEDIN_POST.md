# 🗳️ Complete LinkedIn Publication Package: Online Voting System

All visual assets have been generated in high resolution and saved directly into your workspace folder:
📁 **[`assets/linkedin_images/`](file:///c:/Users/tejas/OneDrive/Desktop/OnlineVotingSystem-main/assets/linkedin_images)**

---

## 🖼️ Downloadable Visual Assets Guide

| # | Section | File Name | Direct File Link |
|---|---|---|---|
| **1** | **Title / Banner** | `01_title_cover_banner.jpg` | [01_title_cover_banner.jpg](file:///c:/Users/tejas/OneDrive/Desktop/OnlineVotingSystem-main/assets/linkedin_images/01_title_cover_banner.jpg) |
| **2** | **Architecture** | `02_system_architecture.jpg` | [02_system_architecture.jpg](file:///c:/Users/tejas/OneDrive/Desktop/OnlineVotingSystem-main/assets/linkedin_images/02_system_architecture.jpg) |
| **3** | **Workflow** | `03_election_workflow_lifecycle.jpg` | [03_election_workflow_lifecycle.jpg](file:///c:/Users/tejas/OneDrive/Desktop/OnlineVotingSystem-main/assets/linkedin_images/03_election_workflow_lifecycle.jpg) |
| **4** | **Output / Results** | `04_output_certified_results.jpg` | [04_output_certified_results.jpg](file:///c:/Users/tejas/OneDrive/Desktop/OnlineVotingSystem-main/assets/linkedin_images/04_output_certified_results.jpg) |
| **5** | **Voter Portal UI** | `05_voter_dashboard_ui.jpg` | [05_voter_dashboard_ui.jpg](file:///c:/Users/tejas/OneDrive/Desktop/OnlineVotingSystem-main/assets/linkedin_images/05_voter_dashboard_ui.jpg) |
| **6** | **API Explorer** | `06_api_swagger_explorer.jpg` | [06_api_swagger_explorer.jpg](file:///c:/Users/tejas/OneDrive/Desktop/OnlineVotingSystem-main/assets/linkedin_images/06_api_swagger_explorer.jpg) |

---

## 📝 Complete LinkedIn Article Content (with Image Placements)

### Article Title:
🗳️ Engineering Trust in Digital Democracy: Building an Enterprise-Grade Online Voting System with Java 21, Spring Boot 3, and React 19

*(Attach `01_title_cover_banner.jpg` as the main article cover image)*

---

### Introduction
Democratic integrity requires digital voting software to guarantee three core principles: **anonymity**, **integrity**, and **non-repudiation**. In an election system, "eventual consistency" or simple memory checks are not enough. A single race condition allowing double-voting can completely dismantle trust in an election.

To tackle these challenges, I engineered the **Online Voting System** — an enterprise digital balloting and election management engine built on **Java 21 LTS**, **Spring Boot 3.3.4**, **PostgreSQL 17**, and **React 19**.

Here is an architectural walkthrough of how this platform guarantees mathematical single-vote integrity, temporal lifecycle determinism, and immutable compliance.

---

### 1. System Architecture Blueprint
*(Insert Image: `02_system_architecture.jpg`)*

The system is decoupled into three resilient tiers:
1. **Client Tier (React 19 + TypeScript + Vite 8):** High-performance reactive interface, Zustand stores with local persistence, Axios request/response interceptors for automatic JWT injection, and role-guarded route architecture (`ProtectedRoute.tsx`).
2. **API Gateway & Security Tier (Spring Boot 3 + Spring Security 6):** Pure stateless architecture (`SessionCreationPolicy.STATELESS`), HMAC-SHA256 256-bit signed Bearer JWT token filter chain, and Role-Based Access Control (`ROLE_ADMIN`, `ROLE_VOTER`, `ROLE_CANDIDATE`).
3. **Persistence Tier (PostgreSQL 17 + Hibernate 6):** Relational schema with strict foreign key constraints, composite unique key constraints preventing double-voting, and an immutable audit trail table.

---

### 2. End-to-End Election Lifecycle & Workflow
*(Insert Image: `03_election_workflow_lifecycle.jpg`)*

The platform coordinates a 5-stage secure workflow:
1. **Voter Registration:** Citizens ($\ge 18$ years old) register and receive an auto-generated unique digital Voter ID (`V1`, `V2`...).
2. **Candidate Nomination & Manifesto Filing:** Enforces constitutional age eligibility ($\ge 25$ years old) and mandates linkage to an active voter identity.
3. **Temporal State Machine:** Dynamic election phases transition deterministically without manual administrator intervention:
   `UPCOMING` ➔ `REGISTRATION_OPEN` ➔ `VOTING_OPEN` ➔ `COMPLETED` ➔ `RESULTS_PUBLISHED`
4. **Atomic Balloting (Zero Double-Voting Guarantee):** In table `votes`, a database-level composite unique constraint `UNIQUE(election_id, voter_id)` guarantees single-vote integrity even under concurrent race conditions.
5. **Immutable Audit Ledger:** Every sensitive event is logged with actor IDs and UTC timestamps.

---

### 3. Interactive API Explorer & Security
*(Insert Image: `06_api_swagger_explorer.jpg`)*

The backend exposes a fully documented OpenAPI 3.0 specification via Swagger UI at `/swagger-ui/index.html`. It provides interactive endpoint testing with built-in Bearer JWT authorization for:
- Authentication (`/api/auth/*`)
- Election Management (`/api/elections/*`)
- Candidate Operations (`/api/candidates/*`)
- Balloting & Results (`/api/votes/*`)
- Compliance Audit Trails (`/api/audit-logs/*`)

---

### 4. Certified Output & Live Results
*(Insert Image: `04_output_certified_results.jpg` & `05_voter_dashboard_ui.jpg`)*

Once voting concludes, the results compilation pipeline aggregates tallies, computes certified percentage shares, and renders a public breakdown with digital verification stamps and winner certification.

---

### 🛠️ Technology Summary
- **Backend:** Java 21 LTS, Spring Boot 3.3.4, Spring Data JPA, Hibernate 6.5
- **Security:** Spring Security 6, Stateless HMAC-SHA256 JWT
- **Database:** PostgreSQL 17, HikariCP Connection Pool
- **Frontend:** React 19, TypeScript 5, Vite 8, Zustand 5, Axios, Lucide Icons
- **API Tooling:** Swagger UI / OpenAPI 3.0, Postman Collection

---

### 💡 Key Takeaways
1. **Push critical invariants to the database:** Concurrency guarantees must live at the relational schema layer.
2. **Stateless JWTs scale cleanly:** Decoupling session state creates horizontally scalable microservices.
3. **Interactive API discovery accelerates quality:** Embedding Swagger UI provided immediate verification across role boundaries.
