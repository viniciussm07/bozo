
# Bozó
Simples jogo mais conhecido como General.

## Quickstart

Na raiz do projeto digite os seguintes comando no terminal

```bash
javac -d bin src/main/*

java -cp bin main.Bozo
```

## Regras

- O Bozó é um jogo de dados. Tem vários outros nomes como:
Yam, Yahtzee, Kniffel, Jambem, Kocakapóker, General, entre outros.

- Cada jogador tem que tentar preencher 10 posições de um tabuleiro, 
como o mostrado abaixo.

![image](https://github.com/viniciussm07/bozo/assets/78987625/1361273a-1af2-4bac-b1fb-fb5ec0877e97)

- Em cada rodada, o jogador lança os 5 dados. Depois
pode escolher ficar com a pontuação que tirou ou
escolher entre 1 e 5 dados para lançar novamente.

- Em seguida pode, se quiser, escolher mais uma vez
alguns dos dados para lançar de novo. 

- Ao final da rodada, deve escolher qual a posição do tabuleiro
irá preencher. Uma posição já preenchida em rodada
anterior, não pode ser utilizada de novo. A pontuação
obtida depende da posição escolhida e da
configuração final dos dados.

- Nas posições externas (#1, #2, #3, #4, #5, #6) devem ser
colocadas as somas dos dados que apresentam os números 
correspondentes à posição escolhida. Por exeplo, se o 
jogado seleciona a posição “#3” e nos dados consguiu
tirar 4 dados com a pontuação 3, então o valor a ser colocado
é 12.

- Nas posições internas, o jogador recebe uma pontuação fixa, se
conseguir determina configuração dos dados e zero se os dados
não apresentarem tal configuração. A primeira posição é um “full
hand” ou seja, três dados de determinado número e dois de outro
(ou do mesmo) e vale 15 pontos. A segunda é uma sequência, ou
seja, os dados têm todos os números de 1 a 5 ou de 2 a 6, valendo
20 pontos. A terceira é a posição da quadra (30 pontos) e a última
é a quina, que vale 40 pontos.
