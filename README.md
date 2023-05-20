# 2022-2_TPA_TRABALHO_GRAFOS

# Objetivos:

- Representar grafos computacionalmente;
- Implementar algoritmos de caminhamento em grafos.

# Especificações do programa

# 1. Arquivo de entrada

Seu programa deverá receber como entrada arquivos gerados pelo programa de geração de arquivos disponibilizado como parte deste trabalho.

O programa gera um arquivo com uma lista de cidades e uma matriz indicando as distâncias entre as cidades:

       i.     a primeira linha do arquivo tem apenas um número n inteiro indicando a quantidade de cidades;

       ii.     Depois vem n linhas (onde n é exatamente o valor lido na primeira linha do arquivo), cada uma trazendo o código (número inteiro) e o nome de uma cidade;

       iii.     Depois, teremos outras n linhas, sendo que cada uma dessas linhas traz n valores float, cada um indicando a distância entre duas cidades: o primeiro valor da primeira linha traz o valor da distancia entre a primeira cidade e ela mesma (ou seja, zero), o segundo valor da primeira linha traz a distância da primeira cidade para a segunda, o terceiro valor é a distância da primeira cidade para a terceira e assim sucessivamente. Quando não há ligação direta entre duas cidades o valor da distância será zero.

# 2.  Representação Computacional de Grafos

Você deve criar classes que conterão as estruturas utilizadas para representar grafos. A representação de grafos pode ser feita utilizando lista de arestas, listas de adjacências ou matriz de adjacências, à sua escolha. 

Utilize os códigos dos slides apresentados nas aulas como ponto de partida.

# 3. Funcionamento do programa

Seu programa deve ler o arquivo entrada.txt gerando uma representação do “mapa” (um grafo) em memória, constando as distâncias (“estradas”) entre as cidades. Você deve representar esses mapas como grafos ponderados e está livre para escolher a forma de representação desse gráfico (matriz de adjacência, lista de adjacência, etc.).

Depois de ler o arquivo e gerar a representação do grafo em memória seu programa deve mostrar um menu com 3 opções:
               
       i.  Obter cidades vizinhas: ao escolher essa opção o usuário deverá informar o código de uma cidade e então o programa deve exibir os códigos e nomes de todas as cidades vizinhas da cidade informada (vértices adjacentes) bem como a distância da cidade escolhida para cada uma das vizinhas.

       ii.  Obter todos os caminhos a partir de uma cidade: o usuário deverá informar o código de uma cidade e o programa deverá exibir todas as cidades (código e nome) às quais é possível chegar saindo da cidade dada (seria um caminhamento em largura no grafo usando a cidade dada como vértice de origem do caminhamento).

       iii.  Sair: o programa é encerrado.
