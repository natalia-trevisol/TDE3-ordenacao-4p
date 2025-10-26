// BucketSort.java
// Implementação simplificada do Bucket Sort (mais próxima do Counting Sort).
// Esse metodo é eficiente quando os valores estão dentro de um intervalo pequeno.
// A ideia é:
// 1. Descobrir o valor mínimo e máximo do vetor.
// 2. Criar um array de contadores (um "bucket" para cada valor).
// 3. Contar quantas vezes cada número aparece.
// 4. Reescrever o vetor ordenado, respeitando as contagens.
// As "trocas" aqui representam o número de inserções feitas no vetor final.
// As "iterações" representam o número de buckets percorridos.

public class BucketSort {

    // Classe auxiliar para registrar resultados (trocas e iterações)
    public static class Resultado {
        public int trocas;
        public int iteracoes;
        public Resultado(int t, int i) { trocas = t; iteracoes = i; }
    }

    // Metodo de ordenação
    public Resultado ordenar(int[] vetor, int tamanho) {
        // 1.Encontrar mínimo e máximo
        int i = 0;
        int minimo = vetor[0];
        int maximo = vetor[0];

        while (i < tamanho) {
            if (vetor[i] < minimo) minimo = vetor[i];
            if (vetor[i] > maximo) maximo = vetor[i];
            i = i + 1;
        }

        // 2.Criar array de contadores com tamanho baseado no intervalo
        int intervalo = maximo - minimo + 1;
        int[] cont = new int[intervalo];

        // Inicializar os contadores manualmente
        int k = 0;
        while (k < intervalo) {
            cont[k] = 0;
            k = k + 1;
        }

        // 3.Contar ocorrências de cada valor do vetor
        int j = 0;
        while (j < tamanho) {
            // o índice é ajustado pelo valor mínimo (offset)
            cont[vetor[j] - minimo] = cont[vetor[j] - minimo] + 1;
            j = j + 1;
        }

        // 4.Reescrever o vetor ordenado com base nas contagens
        int trocas = 0;      // cada escrita no vetor conta como "troca"
        int iteracoes = 0;   // cada bucket visitado conta uma iteração
        int pos = 0;         // posição atual de escrita no vetor final
        int b = 0;           // índice do bucket atual

        while (b < intervalo) {
            iteracoes++; // conta o bucket visitado

            // c = número de ocorrências do valor correspondente ao bucket
            int c = cont[b];
            while (c > 0) {
                vetor[pos] = b + minimo; // reconstrói o valor original
                pos = pos + 1;
                c = c - 1;
                trocas = trocas + 1;
            }

            b = b + 1;
        }

        // retorna os contadores
        return new Resultado(trocas, iteracoes);
    }
}