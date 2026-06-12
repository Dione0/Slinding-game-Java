# Sliding game Java

Este projeto é uma implementação do clássico jogo **Sliding Puzzle** desenvolvida em **Java**, utilizando os princípios de **Programação Orientada a Objetos (POO)**.

## Estrutura do Projeto

### Classe Jogador

Responsável por representar o jogador da partida, armazenando suas informações básicas.

**Retorna:**

* Nome
* Pontuação

### Classe Ranking

Responsável por carregar, organizar e exibir a classificação dos jogadores de acordo com suas pontuações.

**Retorna:**

* Lista de jogadores
* Ranking ordenado

### Classe Tabuleiro

Responsável por criar, armazenar e controlar o estado atual do Sliding Puzzle, além de verificar se o jogo foi concluído.

**Retorna:**

* Matriz do tabuleiro
* Vitória (boolean)

### Classe Movimento

Responsável por validar e executar os movimentos das peças dentro do tabuleiro.

**Retorna:**

* Validação do movimento (boolean)

### Classe Jogo

Responsável por controlar toda a lógica da partida, coordenando a interação entre jogador, tabuleiro, movimentos e ranking.

**Retorna:**

* Resultado da partida
* Pontuação

### Classe Menu

Responsável pela interação inicial com o usuário e pelo direcionamento das opções disponíveis no sistema.

**Retorna:**

* Opção selecionada no menu

### Classe Main

Responsável por iniciar a aplicação e criar os objetos necessários para a execução do programa.

**Retorno:**

* Não possui retorno

---

## Organização dos Módulos

A estrutura do sistema foi planejada da seguinte forma:

### Gerenciamento de Jogadores

* Jogador
* Ranking

### Estrutura do Jogo

* Tabuleiro
* Movimento

### Controle da Aplicação

* Jogo
* Menu
* Main

---

## Tecnologias Utilizadas

* Java
* Programação Orientada a Objetos (POO)
* Estruturas de Dados
* Manipulação de Arquivos (Ranking)
