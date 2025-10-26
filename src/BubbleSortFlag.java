// BubbleSortFlag.java
// Implementação manual do algoritmo Bubble Sort com flag de parada.
// O Bubble Sort compara pares de elementos adjacentes e os troca se estiverem fora de ordem.
// O processo se repete até que nenhuma troca seja necessária (vetor ordenado).
// A "flag" serve para encerrar mais cedo quando o vetor já estiver ordenado.
// Retorna o número de trocas e o número total de comparações (iterações).

public class BubbleSortFlag {

    // Classe auxiliar para armazenar os resultados da execução
    public static class Resultado {
        public int trocas;      // total de trocas realizadas
        public int iteracoes;   // total de comparações entre elementos
        public Resultado(int t, int i) { trocas = t; iteracoes = i; }
    }

    // Metodo principal de ordenação
    // vetor: array a ser ordenado (modificado "in-place")
    // tamanho: número de elementos válidos
    public Resultado ordenar(int[] vetor, int tamanho) {
        int trocas = 0;        // contador de trocas
        int iteracoes = 0;     // contador de comparações

        boolean trocou = true; // indica se houve trocas na última passagem
        int pass = 0;          // contador de passagens pelo vetor

        // Executa enquanto houver trocas e ainda houver elementos a verificar
        while (trocou && pass < tamanho - 1) {
            trocou = false;

            // percorre o vetor até o elemento que já está ordenado (tamanho - 1 - pass)
            int j = 0;
            while (j < tamanho - 1 - pass) {
                iteracoes++;  // cada comparação conta uma iteração

                // se o elemento atual é maior que o próximo, realiza troca
                if (vetor[j] > vetor[j + 1]) {
                    int tmp = vetor[j];
                    vetor[j] = vetor[j + 1];
                    vetor[j + 1] = tmp;
                    trocas++;
                    trocou = true; // houve troca, então ainda há desordem
                }

                j = j + 1; // avança no vetor
            }

            pass = pass + 1; // incrementa a contagem de passagens
        }

        // retorna os contadores acumulados
        return new Resultado(trocas, iteracoes);
    }
}