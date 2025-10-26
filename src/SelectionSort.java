// SelectionSort.java
// Implementação manual do algoritmo Selection Sort.
// A cada passo, procura o menor elemento da parte não ordenada
// e o coloca na posição correta, trocando com o elemento atual.
// Conta o número de trocas e de comparações (iterações).

public class SelectionSort {

    // Estrutura que guarda os resultados de desempenho
    public static class Resultado {
        public int trocas;      // número de trocas realizadas
        public int iteracoes;   // número de comparações
        public Resultado(int t, int i) { trocas = t; iteracoes = i; }
    }

    // Metodo principal de ordenação
    public Resultado ordenar(int[] vetor, int tamanho) {
        int trocas = 0;
        int iteracoes = 0;

        int i = 0;
        // Percorre o vetor até o penúltimo elemento
        while (i < tamanho - 1) {
            int indiceMin = i; // assume que o menor é o atual
            int j = i + 1;

            // Busca o menor elemento no restante do vetor
            while (j < tamanho) {
                iteracoes++;
                if (vetor[j] < vetor[indiceMin]) {
                    indiceMin = j; // encontrou um menor valor
                }
                j = j + 1;
            }

            // Troca o menor encontrado com o primeiro da parte não ordenada
            if (indiceMin != i) {
                int tmp = vetor[i];
                vetor[i] = vetor[indiceMin];
                vetor[indiceMin] = tmp;
                trocas++;
            }

            i = i + 1; // avança o início da parte não ordenada
        }

        // retorna os contadores finais
        return new Resultado(trocas, iteracoes);
    }
}