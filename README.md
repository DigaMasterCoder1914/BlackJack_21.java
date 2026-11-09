# 🎰 Simulador de Cassino (BlackJack em Java)

Um simulador de jogos de cartas executado via terminal, desenvolvido inteiramente em **Java**. O foco principal deste projeto é a aplicação prática de **Programação Orientada a Objetos (POO)**, regras de negócio complexas e gerenciamento de estado. 

Atualmente o sistema conta com a implementação completa do **BlackJack (21)**, permitindo partidas de múltiplos jogadores contra a "Mesa" (Dealer), além da estrutura inicial para o jogo de Buraco.

---

## 🛠️ Tecnologias e Conceitos Aplicados

- **Java (Standard Edition)**
- **Programação Orientada a Objetos (POO):** Uso extensivo de Herança, Polimorfismo e Encapsulamento para separar as lógicas do baralho genérico das regras específicas do BlackJack.
- **Estruturas de Dados:** Manipulação de Arrays unidimensionais para gerenciar múltiplos jogadores, turnos e estados das cartas.
- **Geração Aleatória Segura:** Uso da classe `java.security.SecureRandom` para garantir imprevisibilidade na tiragem das cartas.
- **Tratamento de Exceções:** Uso de `try-catch` e lançamento de `IllegalArgumentException` para garantir a resiliência do menu principal.

---

## 🎲 Destaques Técnicos da Regra de Negócio

Este não é apenas um gerador de números aleatórios. O sistema emula um baralho real:
1. **Controle de Deck:** O baralho possui 52 cartas. Se o Rei de Copas for tirado, o sistema garante (através de arrays booleanos de naipes) que ele não aparecerá novamente até o baralho ser "resetado".
2. **Lógica Dinâmica do ÁS (1 ou 11):** Implementação de um algoritmo inteligente (`Logica_As()`) que atribui o valor 11 ao Ás, mas subtrai 10 pontos automaticamente caso a pontuação do jogador estoure o limite de 21.
3. **Mesa Automatizada:** A mesa (Dealer) segue a regra clássica de cassinos: puxar cartas obrigatoriamente até atingir um mínimo de 17 pontos (no código, enquanto `<= 16`).
4. **Resolução de Empates e Vitórias:** Comparação final de arrays verificando quem estourou 21, quem venceu a mesa e empates justos.

---

## 🚀 Como Executar

### Pré-requisitos
- **JDK** instalado na máquina.

### Executando no Terminal / CMD
1. Clone este repositório:
   
```bash
   git clone [https://github.com/DigaMasterCoder1914/SEU-REPOSITORIO.git](https://github.com/DigaMasterCoder1914/SEU-REPOSITORIO.git)

Navegue até a pasta raiz onde estão os pacotes (ou até a pasta src se estiver usando IDE).

Compile o projeto:

   javac principal/Main.java
   
Execute o programa:

   java principal.Main
   
Siga as instruções no console para escolher o jogo (digite BlackJack), inserir a quantidade de jogadores e decidir os turnos!
