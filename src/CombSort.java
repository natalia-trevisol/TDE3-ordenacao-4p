// CombSort.java
// Implementação completa do algoritmo Comb Sort.
// É uma melhoria do Bubble Sort que compara elementos distantes entre si,
// diminuindo a distância ("gap") progressivamente até ficar igual a 1.
// Utiliza shrink factor ≈ 1.3 e evita números reais.
// Conta o total de trocas e comparações (iterações).

public class CombSort {

    // Classe auxiliar para armazenar o resultado (trocas e iterações)
    public static class Resultado {
        public int trocas;      // número total de trocas realizadas
        public int iteracoes;   // número total de comparações feitas
        public Resultado(int t, int i) { trocas = t; iteracoes = i; }
    }

    // Função auxiliar que reduz o "gap" a cada passada
    // Shrink factor ≈ 1.3 → fazemos (gap * 10) / 13 para evitar usar ponto flutuante
    private int reduzirGap(int gap) {
        int novo = (gap * 10) / 13; // reduzindo o tamanho do salto
        if (novo < 1) novo = 1;     // o menor gap permitido é 1
        return novo;
    }

    // Método principal de ordenação
    public Resultado ordenar(int[] vetor, int tamanho) {
        int trocas = 0;
        int iteracoes = 0;

        int gap = tamanho;   // distância inicial entre os elementos comparados
        boolean trocou = true; // controle para saber se houve trocas

        // Continua até o gap ser 1 E não houver trocas (vetor ordenado)
        while (gap != 1 || trocou) {
            gap = reduzirGap(gap); // diminui o gap
            trocou = false;

            int i = 0;
            while (i + gap < tamanho) {
                iteracoes++; // cada comparação conta como uma iteração
                if (vetor[i] > vetor[i + gap]) {
                    // troca os elementos fora de ordem
                    int tmp = vetor[i];
                    vetor[i] = vetor[i + gap];
                    vetor[i + gap] = tmp;
                    trocas++;
                    trocou = true; // houve troca, ainda pode haver desordem
                }
                i = i + 1;
            }
        }

        // retorna os contadores finais
        return new Resultado(trocas, iteracoes);
    }
}