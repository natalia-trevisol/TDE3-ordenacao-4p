// CocktailSort.java
// Implementação do Cocktail Shaker Sort (também conhecido como bidirectional bubble sort).
// O algoritmo percorre o vetor em duas direções alternadamente:
// → primeiro vai da esquerda para a direita (empurrando o maior para o final)
// ← depois volta da direita para a esquerda (empurrando o menor para o início).
// Esse processo é repetido até que não ocorram trocas.
// Conta trocas e iterações (comparações).

public class CocktailSort {

    // Classe auxiliar para registrar os contadores
    public static class Resultado {
        public int trocas;
        public int iteracoes;
        public Resultado(int t, int i) { trocas = t; iteracoes = i; }
    }

    // Método principal de ordenação
    public Resultado ordenar(int[] vetor, int tamanho) {
        int trocas = 0;
        int iteracoes = 0;

        int inicio = 0;          // limite inferior da parte não ordenada
        int fim = tamanho - 1;   // limite superior da parte não ordenada
        boolean trocou = true;   // flag para verificar se houve trocas

        // Continua enquanto houve trocas e o início ainda é menor que o fim
        while (trocou && inicio < fim) {
            trocou = false;

            // Passagem para frente (empurra o maior valor para o final)
            int i = inicio;
            while (i < fim) {
                iteracoes++;
                if (vetor[i] > vetor[i + 1]) {
                    int tmp = vetor[i];
                    vetor[i] = vetor[i + 1];
                    vetor[i + 1] = tmp;
                    trocas++;
                    trocou = true;
                }
                i = i + 1;
            }
            fim = fim - 1; // último elemento já está na posição correta

            // Se não houve trocas na passada anterior, o vetor está ordenado
            if (!trocou) break;

            // Passagem para trás (empurra o menor valor para o início)
            trocou = false;
            int j = fim;
            while (j > inicio) {
                iteracoes++;
                if (vetor[j - 1] > vetor[j]) {
                    int tmp = vetor[j - 1];
                    vetor[j - 1] = vetor[j];
                    vetor[j] = tmp;
                    trocas++;
                    trocou = true;
                }
                j = j - 1;
            }
            inicio = inicio + 1; // primeiro elemento já está na posição correta
        }

        // retorna as contagens
        return new Resultado(trocas, iteracoes);
    }
}