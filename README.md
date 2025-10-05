# 🏝️ Java Survival

**Java Survival** é um jogo de sobrevivência em console desenvolvido em **Java**, onde o jogador deve explorar uma ilha deserta, coletar recursos, lutar contra animais selvagens e gerenciar sua vida, energia e fome para sobreviver.

O projeto foi desenvolvido como parte do **Trabalho Semestral Integrador – Projeto e Implementação em Java**, aplicando princípios de **POO**, **modularização**, **boas práticas de engenharia de software** e **testes automatizados**.

---

## 🎯 Objetivo do Projeto

Desenvolver uma aplicação Java **orientada a objetos** e **modularizada**, que demonstre o uso de:
- Herança e polimorfismo;
- Collections (`Map`, `List`);
- Exceções personalizadas;
- Persistência de dados (em arquivo texto);
- Testes unitários com JUnit;
- Estrutura MVC (Model-View-Controller);
- Gerenciamento de dependências via **Maven**.

---

## 🧱 Arquitetura (MVC)

O projeto segue o padrão **Model–View–Controller**, garantindo organização e escalabilidade:

📦 br.com.javasurvival
┣ 📂 controller → Controla o fluxo do jogo (menu, ações do jogador)
┣ 📂 model → Contém as classes do domínio (Jogador, Animal, Recurso, etc.)
┣ 📂 model.animais → Subclasses de Animal (Lobo, Urso, Cobra)
┣ 📂 service → Lógica de negócios (salvamento, combate, exploração)
┣ 📂 exception → Exceções personalizadas (ItemNaoEncontradoException)
┣ 📂 view → Interface via console
┣ 📜 Main.java → Ponto de entrada da aplicação
┗ 📜 pom.xml → Gerenciamento de dependências Maven

markdown
Copy code

---

## 🧩 Funcionalidades Principais

- 🌿 **Exploração:** o jogador pode explorar a ilha e encontrar recursos ou enfrentar inimigos.
- ⚔️ **Combate:** inimigos como Lobo, Urso e Cobra aparecem aleatoriamente.
- 🎒 **Inventário:** gerenciado via `HashMap`, armazena itens coletados.
- 💪 **Sistema de atributos:** vida, energia, fome, dano e experiência.
- 🍖 **Itens e recursos:** `Pedra`, `Comida`, `Madeira`, `Carne`, cada um com efeitos únicos.
- 💾 **Salvar e carregar progresso:** persistência em `save.txt`.
- 🧠 **Evolução do jogador:** ganha experiência, sobe de nível e aumenta o dano base.
- ❗ **Exceções personalizadas:** tratamento seguro para erros como uso de item inexistente.
- 🧪 **Testes unitários:** realizados com **JUnit 5**.

---

## ⚙️ Instalação e Execução

### 🧰 Pré-requisitos
- **Java 17+** (recomendado Java 21 ou 25)
- **Apache Maven 3.8+**

### 💻 Clonar o repositório

git clone https://github.com/seu-usuario/java-survival.git
cd java-survival
⚙️ Compilar o projeto
bash
Copy code
mvn clean install
▶️ Executar o jogo
bash
Copy code
mvn exec:java -Dexec.mainClass="br.com.javasurvival.Main"
🧪 Testes Automatizados (JUnit 5)
O projeto inclui testes unitários que garantem a integridade das principais funcionalidades.

Teste	Descrição
JogadorTest	Testa uso de itens e lançamento de exceções personalizadas.
PedraTest	Verifica o buff de dano ao usar o item Pedra.
SaveServiceTest	Valida a persistência e recuperação correta de dados.

Executar os testes:

bash
Copy code
mvn test
💾 Persistência de Dados
Os dados são salvos em src/main/resources/data/save.txt, armazenando:

ini
Copy code
nome=Leo
vida=85
energia=60
fome=35
nivel=2
experiencia=30
dano=15
inventario=Pedra:2,Carne:1,Coco:3
Ao reiniciar o jogo, o progresso é restaurado automaticamente.

🧠 Conceitos Aplicados
Herança: Jogador e Animal herdam de Personagem.

Polimorfismo: métodos usar() e atacar() com comportamentos diferentes.

Encapsulamento: atributos privados e métodos de acesso.

Tratamento de Exceções: ItemNaoEncontradoException.

Collections: uso de HashMap e ArrayList.

Persistência: gravação/leitura com FileWriter e BufferedReader.

Testes: JUnit 5 integrado via Maven.

📘 Tecnologias Utilizadas
Tecnologia	Função
☕ Java 25	Linguagem principal
🧩 Maven	Gerenciamento de dependências
🧪 JUnit 5	Testes unitários
🧠 Gson (Google)	Conversão de objetos (na versão inicial)
💾 Arquivo TXT	Persistência simples
🖥️ Console (CLI)	Interface com o usuário

🧭 Diagrama de Classes (Resumo UML)
markdown
Copy code
Personagem
 ├── Jogador
 │    └── Recurso
 │         ├── Pedra
 │         ├── Comida
 │         └── Madeira
 └── Animal
      ├── Lobo
      ├── Urso
      └── Cobra
👨‍💻 Autor
Desenvolvido por:
🧑‍💻 Leonardo Moretti Fernandes Nabarro
📅 Outubro de 2025
📘 Trabalho Semestral Integrador – Projeto e Implementação em Java

🏁 Licença
Este projeto é de uso acadêmico e educacional.
Sinta-se livre para estudar, modificar e evoluir o código conforme necessário.
