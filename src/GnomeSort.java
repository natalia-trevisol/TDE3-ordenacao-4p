// GnomeSort.java
// Implementação manual do algoritmo Gnome Sort.
// Ele é semelhante ao Insertion Sort, mas move elementos
// para trás um a um (como um "gnomo" arrumando vasos em ordem).
// É intuitivo e simples, mas não muito eficiente para grandes vetores.
// Conta trocas e comparações (iterações).

public class GnomeSort {

    // Estrutura auxiliar para armazenar o resultado
    public static class Resultado {
        public int trocas;      // total de trocas feitas
        public int iteracoes;   // total de comparações realizadas
        public Resultado(int t, int i) { trocas = t; iteracoes = i; }
    }

    // Metodo principal de ordenação
    public Resultado ordenar(int[] vetor, int tamanho) {
        int trocas = 0;
        int iteracoes = 0;

        int index = 0; // posição atual no vetor

        // percorre o vetor até o final
        while (index < tamanho) {
            // se está no início, apenas avança
            if (index == 0) {
                index = index + 1;
            } else {
                iteracoes++; // cada comparação conta

                // se o elemento atual está na ordem correta, avança
                if (vetor[index] >= vetor[index - 1]) {
                    index = index + 1;
                }
                // se está fora de ordem, troca com o anterior e volta um passo
                else {
                    int tmp = vetor[index];
                    vetor[index] = vetor[index - 1];
                    vetor[index - 1] = tmp;
                    trocas++;
                    index = index - 1; // volta para verificar novamente
                }
            }
        }

        // retorna os resultados da ordenação
        return new Resultado(trocas, iteracoes);
    }
}