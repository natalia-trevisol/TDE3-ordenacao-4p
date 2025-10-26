// Comparador.java
// Classe principal responsável por:
// - Configurar os vetores de teste;
// - Chamar todos os algoritmos de ordenação (Bubble, Selection, Cocktail, Gnome, Comb, Bucket);
// - Contar trocas e iterações;
// - Exibir resultados e gerar tabelas comparativas no console.

public class Comparador {

    // Estrutura simples para guardar resultados (nome, número de trocas e de iterações)
    public static class InfoAlg {
        public String nome;
        public int trocas;
        public int iteracoes;

        // Construtor da estrutura
        public InfoAlg(String n, int t, int i) {
            nome = n;
            trocas = t;
            iteracoes = i;
        }
    }

    // Função auxiliar que copia manualmente um vetor para outro
    private static void copiarVetor(int[] origem, int[] destino, int tamanho) {
        int i = 0;
        while (i < tamanho) {
            destino[i] = origem[i];
            i = i + 1;
        }
    }

    // Função que imprime o conteúdo de um vetor na tela (com título)
    private static void imprimirVetor(String titulo, int[] v, int tamanho) {
        System.out.println(titulo);
        int i = 0;
        while (i < tamanho) {
            System.out.print(v[i]);
            if (i < tamanho - 1) System.out.print(", ");
            i = i + 1;
        }
        System.out.println();
    }

    // Testa todos os algoritmos de ordenação em um mesmo vetor base
    private static InfoAlg[] testarTodos(int[] base, int tamanho) {

        // Cria cópias separadas para cada algoritmo (para não alterar o vetor original)
        int[] aBubble = new int[tamanho];
        int[] aSelection = new int[tamanho];
        int[] aCocktail = new int[tamanho];
        int[] aGnome = new int[tamanho];
        int[] aComb = new int[tamanho];
        int[] aBucket = new int[tamanho];

        copiarVetor(base, aBubble, tamanho);
        copiarVetor(base, aSelection, tamanho);
        copiarVetor(base, aCocktail, tamanho);
        copiarVetor(base, aGnome, tamanho);
        copiarVetor(base, aComb, tamanho);
        copiarVetor(base, aBucket, tamanho);

        // Executa cada algoritmo e coleta resultados
        BubbleSortFlag bs = new BubbleSortFlag();
        BubbleSortFlag.Resultado rb = bs.ordenar(aBubble, tamanho);

        SelectionSort ss = new SelectionSort();
        SelectionSort.Resultado rs = ss.ordenar(aSelection, tamanho);

        CocktailSort cs = new CocktailSort();
        CocktailSort.Resultado rc = cs.ordenar(aCocktail, tamanho);

        GnomeSort gs = new GnomeSort();
        GnomeSort.Resultado rg = gs.ordenar(aGnome, tamanho);

        CombSort comb = new CombSort();
        CombSort.Resultado rcomb = comb.ordenar(aComb, tamanho);

        BucketSort bskt = new BucketSort();
        BucketSort.Resultado rbkt = bskt.ordenar(aBucket, tamanho);

        // Imprime os vetores já ordenados por cada metodo
        System.out.println();
        imprimirVetor("Vetor ordenado por BubbleSortFlag:", aBubble, tamanho);
        imprimirVetor("Vetor ordenado por SelectionSort:", aSelection, tamanho);
        imprimirVetor("Vetor ordenado por CocktailSort:", aCocktail, tamanho);
        imprimirVetor("Vetor ordenado por GnomeSort:", aGnome, tamanho);
        imprimirVetor("Vetor ordenado por CombSort:", aComb, tamanho);
        imprimirVetor("Vetor ordenado por BucketSort:", aBucket, tamanho);
        System.out.println();

        // Guarda todos os resultados em um array InfoAlg
        InfoAlg[] infos = new InfoAlg[6];
        infos[0] = new InfoAlg("BubbleFlag", rb.trocas, rb.iteracoes);
        infos[1] = new InfoAlg("SelectionSort", rs.trocas, rs.iteracoes);
        infos[2] = new InfoAlg("CocktailSort", rc.trocas, rc.iteracoes);
        infos[3] = new InfoAlg("GnomeSort", rg.trocas, rg.iteracoes);
        infos[4] = new InfoAlg("CombSort", rcomb.trocas, rcomb.iteracoes);
        infos[5] = new InfoAlg("BucketSort", rbkt.trocas, rbkt.iteracoes);

        return infos;
    }

    // Imprime tabela de comparação dos algoritmos
    private static void imprimirTabela(String tituloVetor, InfoAlg[] infos) {
        int n = 6; // número fixo de algoritmos testados

        System.out.println("===================== RESULTADOS =====================");
        System.out.println();
        System.out.println(tituloVetor);
        System.out.printf("%-16s %-8s %-10s\n", "Algoritmo", "Trocas", "Iteracoes");
        System.out.println("-----------------------------------");

        // Exibe dados brutos (trocas e iterações)
        int i = 0;
        while (i < n) {
            System.out.printf("%-16s %-8d %-10d\n", infos[i].nome, infos[i].trocas, infos[i].iteracoes);
            i = i + 1;
        }

        // ---------- Ranking por trocas ----------
        int[] idxTrocas = new int[n];
        int k = 0;
        while (k < n) {
            idxTrocas[k] = k;
            k = k + 1;
        }

        // Ordena índices com base no número de trocas (metodo seleção)
        int a = 0;
        while (a < n - 1) {
            int minPos = a;
            int b = a + 1;
            while (b < n) {
                if (infos[idxTrocas[b]].trocas < infos[idxTrocas[minPos]].trocas) {
                    minPos = b;
                }
                b = b + 1;
            }
            int tmp = idxTrocas[a];
            idxTrocas[a] = idxTrocas[minPos];
            idxTrocas[minPos] = tmp;
            a = a + 1;
        }

        // ---------- Ranking por iterações ----------
        int[] idxIters = new int[n];
        int c = 0;
        while (c < n) { idxIters[c] = c; c = c + 1; }

        int d = 0;
        while (d < n - 1) {
            int minPos = d;
            int e = d + 1;
            while (e < n) {
                if (infos[idxIters[e]].iteracoes < infos[idxIters[minPos]].iteracoes) {
                    minPos = e;
                }
                e = e + 1;
            }
            int tmp = idxIters[d];
            idxIters[d] = idxIters[minPos];
            idxIters[minPos] = tmp;
            d = d + 1;
        }

        // ---------- Exibição dos rankings ----------
        System.out.println();
        System.out.println("Rank por Trocas (menor -> maior):");
        int f = 0;
        while (f < n) {
            System.out.printf("%d. %s (%d trocas)\n", f + 1, infos[idxTrocas[f]].nome, infos[idxTrocas[f]].trocas);
            f = f + 1;
        }

        System.out.println();
        System.out.println("Rank por Iteracoes (menor -> maior):");
        int g = 0;
        while (g < n) {
            System.out.printf("%d. %s (%d iteracoes)\n", g + 1, infos[idxIters[g]].nome, infos[idxIters[g]].iteracoes);
            g = g + 1;
        }

        System.out.println("-------------------------------------------------------");
    }

    // Metodo principal do programa
    public static void main(String[] args) {
        int tamanho = 20; // tamanho fixo dos vetores

        // -------- Vetores fornecidos pelo enunciado --------
        int[] vetor1 = new int[] {
                12, 18, 9, 25, 17, 31, 22, 27, 16, 13,
                19, 23, 20, 30, 14, 11, 15, 24, 26, 28
        };

        int[] vetor2 = new int[] {
                5, 7, 9, 10, 12, 14, 15, 17, 19, 21,
                22, 23, 24, 25, 27, 28, 29, 30, 31, 32
        };

        int[] vetor3 = new int[] {
                99, 85, 73, 60, 50, 40, 35, 30, 25, 20,
                15, 14, 13, 12, 11, 10, 9, 8, 7, 6
        };

        System.out.println("=== Comparacao de algoritmos: trocas e iteracoes ===\n");

        // Teste com vetor aleatório
        System.out.println("VETOR 1 ORIGINAL:");
        imprimirVetor("", vetor1, tamanho);
        InfoAlg[] result1 = testarTodos(vetor1, tamanho);
        imprimirTabela("VETOR 1 - ALEATORIO", result1);

        // Teste com vetor já ordenado
        System.out.println();
        System.out.println("VETOR 2 ORIGINAL:");
        imprimirVetor("", vetor2, tamanho);
        InfoAlg[] result2 = testarTodos(vetor2, tamanho);
        imprimirTabela("VETOR 2 - CRESCENTE (praticamente ordenado)", result2);

        // Teste com vetor em ordem inversa
        System.out.println();
        System.out.println("VETOR 3 ORIGINAL:");
        imprimirVetor("", vetor3, tamanho);
        InfoAlg[] result3 = testarTodos(vetor3, tamanho);
        imprimirTabela("VETOR 3 - DECRESCENTE (inverso)", result3);

        System.out.println("\nFim da comparacao.");
    }
}
