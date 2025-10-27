# Comparação de Algoritmos de Ordenação em Java (TDE 3)

## Identificação
**Aluna:** Natália Moritani Trevisol  
**Disciplina:** Resolução de Problemas Estruturados em Computação  
**Turma:** B - manhã  
**Curso:** Ciência da Computação  
**Universidade:** Pontifícia Universidade Católica do Paraná (PUCPR)  
**Professor:** Andrey Cabral Meira  

---

## Objetivo

O objetivo deste projeto é implementar e comparar o desempenho de diferentes algoritmos de ordenação em Java, sem utilizar funções prontas da linguagem.

Os algoritmos comparados são:

- **Bubble Sort com Flag de Parada**
- **Selection Sort**
- **Cocktail Sort**
- **Gnome Sort**
- **Comb Sort**
- **Bucket (Counting) Sort**

O sistema mede e compara:
- **Trocas:** quantidade de vezes que dois elementos foram trocados. Contadas toda vez que dois elementos são efetivamente trocados (ou, no caso do Bucket Sort, cada escrita no vetor final é considerada uma troca conceitual).
- **Iterações:** número de comparações ou laços executados pelos algoritmos.

- Todo o controle de iteração e troca foi feito **manualmente**, com variáveis e loops básicos.

---

## Estrutura do Código

tde3-ordenacao
src/
│
├── Comparador.java # Classe principal: executa e compara todos os algoritmos
├── BubbleSortFlag.java # Implementação do Bubble Sort com flag de parada
├── SelectionSort.java # Implementação do Selection Sort 
├── CocktailSort.java # Implementação do Cocktail Sort
├── GnomeSort.java # Implementação do Gnome Sort
├── CombSort.java # Implementação do Comb Sort
├── BucketSort.java # Implementação do Bucket (Counting) Sort
└── README.md # Documentação do projeto

---

## Instruções para Execução

### Pré-requisitos
- **JDK 17** ou superior
- **IDE** (IntelliJ, Eclipse, NetBeans) ou terminal com `javac` e `java`

### Execução via Terminal

1. Baixar os arquivos do diretório src/:
  - Comparador.java
  - BubbleSortFlag.java 
  - SelectionSort.java  
  - CocktailSort.java
  - GnomeSort.java 
  - CombSort.java 
  - BucketSort.java 

2. Compilar os arquivos:
  ```bash
  javac *.java
  ```

3. Executar o programa:
  ```bash
  java Main
  ```

### Execução via IDE

1. Instalar e abrir algum IDE que suporte Java:
Por exemplo: InteliJIdea, NetBeans.

2. Baixar os arquivos do diretório src/:
  - Comparador.java
  - BubbleSortFlag.java 
  - SelectionSort.java  
  - CocktailSort.java
  - GnomeSort.java 
  - CombSort.java 
  - BucketSort.java
    
3. Abrir o diretório src/ no IDE e executar o arquivo "Comparador.java":
Geralmente existe um botão "RUN" para compilar e executar o programa.

---

## Resultados dos Testes

### Vetores utilizados:
```bash
int[] vetor1 = {12, 18, 9, 25, 17, 31, 22, 27, 16, 13, 19, 23, 20, 30, 14, 11, 15, 24, 26, 28}; // Aleatório
int[] vetor2 = {5, 7, 9, 10, 12, 14, 15, 17, 19, 21, 22, 23, 24, 25, 27, 28, 29, 30, 31, 32};   // Crescente
int[] vetor3 = {99, 85, 73, 60, 50, 40, 35, 30, 25, 20, 15, 14, 13, 12, 11, 10, 9, 8, 7, 6};   // Decrescente
```

### Saída esperada do Programa
```bash
=== Comparacao de algoritmos: trocas e iteracoes ===

VETOR 1 ORIGINAL:

12, 18, 9, 25, 17, 31, 22, 27, 16, 13, 19, 23, 20, 30, 14, 11, 15, 24, 26, 28

Vetor ordenado por BubbleSortFlag:
9, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 22, 23, 24, 25, 26, 27, 28, 30, 31
Vetor ordenado por SelectionSort:
9, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 22, 23, 24, 25, 26, 27, 28, 30, 31
Vetor ordenado por CocktailSort:
9, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 22, 23, 24, 25, 26, 27, 28, 30, 31
Vetor ordenado por GnomeSort:
9, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 22, 23, 24, 25, 26, 27, 28, 30, 31
Vetor ordenado por CombSort:
9, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 22, 23, 24, 25, 26, 27, 28, 30, 31
Vetor ordenado por BucketSort:
9, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 22, 23, 24, 25, 26, 27, 28, 30, 31

===================== RESULTADOS =====================

VETOR 1 - ALEATORIO
Algoritmo        Trocas   Iteracoes 
-----------------------------------
BubbleFlag       78       180       
SelectionSort    18       190       
CocktailSort     78       154       
GnomeSort        78       174       
CombSort         22       129       
BucketSort       20       23        

Rank por Trocas (menor -> maior):
1. SelectionSort (18 trocas)
2. BucketSort (20 trocas)
3. CombSort (22 trocas)
4. GnomeSort (78 trocas)
5. CocktailSort (78 trocas)
6. BubbleFlag (78 trocas)

Rank por Iteracoes (menor -> maior):
1. BucketSort (23 iteracoes)
2. CombSort (129 iteracoes)
3. CocktailSort (154 iteracoes)
4. GnomeSort (174 iteracoes)
5. BubbleFlag (180 iteracoes)
6. SelectionSort (190 iteracoes)
-------------------------------------------------------

VETOR 2 ORIGINAL:

5, 7, 9, 10, 12, 14, 15, 17, 19, 21, 22, 23, 24, 25, 27, 28, 29, 30, 31, 32

Vetor ordenado por BubbleSortFlag:
5, 7, 9, 10, 12, 14, 15, 17, 19, 21, 22, 23, 24, 25, 27, 28, 29, 30, 31, 32
Vetor ordenado por SelectionSort:
5, 7, 9, 10, 12, 14, 15, 17, 19, 21, 22, 23, 24, 25, 27, 28, 29, 30, 31, 32
Vetor ordenado por CocktailSort:
5, 7, 9, 10, 12, 14, 15, 17, 19, 21, 22, 23, 24, 25, 27, 28, 29, 30, 31, 32
Vetor ordenado por GnomeSort:
5, 7, 9, 10, 12, 14, 15, 17, 19, 21, 22, 23, 24, 25, 27, 28, 29, 30, 31, 32
Vetor ordenado por CombSort:
5, 7, 9, 10, 12, 14, 15, 17, 19, 21, 22, 23, 24, 25, 27, 28, 29, 30, 31, 32
Vetor ordenado por BucketSort:
5, 7, 9, 10, 12, 14, 15, 17, 19, 21, 22, 23, 24, 25, 27, 28, 29, 30, 31, 32

===================== RESULTADOS =====================

VETOR 2 - CRESCENTE (praticamente ordenado)
Algoritmo        Trocas   Iteracoes 
-----------------------------------
BubbleFlag       0        19        
SelectionSort    0        190       
CocktailSort     0        19        
GnomeSort        0        19        
CombSort         0        110       
BucketSort       20       28        

Rank por Trocas (menor -> maior):
1. BubbleFlag (0 trocas)
2. SelectionSort (0 trocas)
3. CocktailSort (0 trocas)
4. GnomeSort (0 trocas)
5. CombSort (0 trocas)
6. BucketSort (20 trocas)

Rank por Iteracoes (menor -> maior):
1. BubbleFlag (19 iteracoes)
2. CocktailSort (19 iteracoes)
3. GnomeSort (19 iteracoes)
4. BucketSort (28 iteracoes)
5. CombSort (110 iteracoes)
6. SelectionSort (190 iteracoes)
-------------------------------------------------------

VETOR 3 ORIGINAL:

99, 85, 73, 60, 50, 40, 35, 30, 25, 20, 15, 14, 13, 12, 11, 10, 9, 8, 7, 6

Vetor ordenado por BubbleSortFlag:
6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 20, 25, 30, 35, 40, 50, 60, 73, 85, 99
Vetor ordenado por SelectionSort:
6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 20, 25, 30, 35, 40, 50, 60, 73, 85, 99
Vetor ordenado por CocktailSort:
6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 20, 25, 30, 35, 40, 50, 60, 73, 85, 99
Vetor ordenado por GnomeSort:
6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 20, 25, 30, 35, 40, 50, 60, 73, 85, 99
Vetor ordenado por CombSort:
6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 20, 25, 30, 35, 40, 50, 60, 73, 85, 99
Vetor ordenado por BucketSort:
6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 20, 25, 30, 35, 40, 50, 60, 73, 85, 99

===================== RESULTADOS =====================

VETOR 3 - DECRESCENTE (inverso)
Algoritmo        Trocas   Iteracoes 
-----------------------------------
BubbleFlag       190      190       
SelectionSort    10       190       
CocktailSort     190      190       
GnomeSort        190      380       
CombSort         18       129       
BucketSort       20       94        

Rank por Trocas (menor -> maior):
1. SelectionSort (10 trocas)
2. CombSort (18 trocas)
3. BucketSort (20 trocas)
4. GnomeSort (190 trocas)
5. BubbleFlag (190 trocas)
6. CocktailSort (190 trocas)

Rank por Iteracoes (menor -> maior):
1. BucketSort (94 iteracoes)
2. CombSort (129 iteracoes)
3. CocktailSort (190 iteracoes)
4. SelectionSort (190 iteracoes)
5. BubbleFlag (190 iteracoes)
6. GnomeSort (380 iteracoes)
-------------------------------------------------------

Fim da comparacao.

Process finished with exit code 0
```

--- 

## Análise dos Resultados
### **Vetor 1 (Aleatório):**
- Todos os algoritmos ordenaram corretamente.
- SelectionSort fez poucas trocas (18) — esperado, pois troca apenas uma vez por passagem.
- Bubble, Cocktail e Gnome tiveram muitas trocas (~78), comportamento esperado.

- CombSort e BucketSort foram os mais eficientes em iterações.
- Melhores: BucketSort e CombSort.

### **Vetor 2 (Crescente):**
- Vetor já ordenado → algoritmos com “flag” pararam rapidamente.
- BubbleFlag, Cocktail e Gnome detectaram a ordenação cedo.
- SelectionSort percorreu tudo (sem otimização).

- BucketSort teve trocas artificiais (redistribuição de baldes).
- Melhores: BubbleFlag, Cocktail e GnomeSort.

### **Vetor 3 (Decrescente):**
- Pior caso para a maioria dos algoritmos.
- SelectionSort teve poucas trocas (10), mesmo percorrendo tudo.
- CombSort e BucketSort mantiveram boa eficiência.
- Melhores: CombSort e BucketSort.

--- 

## Conclusão Final
| Situação          | Melhor Algoritmo                  | Justificativa                       |
| ----------------- | --------------------------------- | ----------------------------------- |
| Vetor Aleatório   | **BucketSort / CombSort**         | Menos iterações e trocas médias     |
| Vetor Crescente   | **BubbleFlag / Cocktail / Gnome** | Parada antecipada eficiente         |
| Vetor Decrescente | **CombSort / BucketSort**         | Boa eficiência mesmo em casos ruins |


## Referências do Estudo
- Comb Sort

Dobosiewicz, W. (1980). An Efficient Variation of Bubble Sort. PDF – comb_sort.pdf

Explica o conceito de "gap" e como o algoritmo melhora o desempenho do Bubble Sort reduzindo o número de comparações.

- Gnome Sort

Stalin, H. (2000). Gnome Sort – The Simplest Sort Algorithm.

Disponível em: https://www.geeksforgeeks.org/gnome-sort-a-stupid-one/

Descreve o algoritmo de forma didática, destacando sua simplicidade e funcionamento semelhante ao Insertion Sort.

- Bucket Sort

Baeza-Yates, R. (1991). Handbook of Algorithms and Data Structures.

Disponível em: http://www.dcc.uchile.cl/~rbaeza/handbook/algs/4/423.sort.c.html

Explica a abordagem de distribuição por intervalos (buckets) e sua eficiência em dados uniformemente distribuídos.

- Bubble Sort (com flag)

Knuth, D. E. (1998). The Art of Computer Programming, Volume 3: Sorting and Searching. Addison-Wesley.

Aborda o algoritmo clássico e variações com otimizações, como o uso de uma flag para evitar passagens desnecessárias.

- Selection Sort

Cormen, T. H., Leiserson, C. E., Rivest, R. L., & Stein, C. (2009). Introduction to Algorithms (3rd ed.). MIT Press.

Descreve o funcionamento do Selection Sort, sua complexidade e aplicação em conjuntos pequenos.

- Cocktail Sort (Shaker Sort)
  
Weiss, M. A. (2012). Data Structures and Algorithm Analysis in Java (3rd ed.). Pearson.

Apresenta o Cocktail Sort como uma extensão bidirecional do Bubble Sort, reduzindo o número de iterações.
