import java.util.Random;

public class Tabuleiro {
    private final int dimensao;
    private final int[][] matriz;
    private int linhaVazia;
    private int colunaVazia;

    // Construtor
    public Tabuleiro(int dimensao) {
        if (dimensao < 3 || dimensao > 10) {
            throw new IllegalArgumentException("O tamanho do tabuleiro deve ser entre 3 e 10.");
        }
        this.dimensao = dimensao;
        this.matriz = new int[dimensao][dimensao];
        
        inicializar();
        embaralhar();
    }

    // Inicializa o tabuleiro ordenado: 1 até N²-1, com o 0 no final
    private void inicializar() {
        int valor = 1;
        for (int i = 0; i < dimensao; i++) {
            for (int j = 0; j < dimensao; j++) {
                if (i == dimensao - 1 && j == dimensao - 1) {
                    matriz[i][j] = 0; // Célula vazia
                } else {
                    matriz[i][j] = valor++;
                }
            }
        }
        this.linhaVazia = dimensao - 1;
        this.colunaVazia = dimensao - 1;
    }

    // Embaralha o tabuleiro fazendo movimentos válidos para garantir resolubilidade
    private void embaralhar() {
        Random random = new Random();
        int totalMovimentos = dimensao * dimensao * 100; // Quantidade de trocas aleatórias

        for (int k = 0; k < totalMovimentos; k++) {
            // Vetores de direção: cima, baixo, esquerda, direita
            int[] dLinha = {-1, 1, 0, 0};
            int[] dColuna = {0, 0, -1, 1};

            int direcaoAleatoria = random.nextInt(4);
            int novaLinha = linhaVazia + dLinha[direcaoAleatoria];
            int novaColuna = colunaVazia + dColuna[direcaoAleatoria];

            // Se for uma posição de vizinho válida dentro do tabuleiro, faz o movimento
            if (novaLinha >= 0 && novaLinha < dimensao && novaColuna >= 0 && novaColuna < dimensao) {
                permutar(linhaVazia, colunaVazia, novaLinha, novaColuna);
            }
        }
    }

    // Troca dois elementos de posição e atualiza as coordenadas da célula vazia
    public void permutar(int l1, int c1, int l2, int c2) {
        int temp = matriz[l1][c1];
        matriz[l1][c1] = matriz[l2][c2];
        matriz[l2][c2] = temp;

        // Atualiza a posição do espaço vazio (0) se ele foi movido
        if (matriz[l1][c1] == 0) {
            linhaVazia = l1;
            colunaVazia = c1;
        } else if (matriz[l2][c2] == 0) {
            linhaVazia = l2;
            colunaVazia = c2;
        }
    }

    // Imprime o tabuleiro formatado no console
    public void exibir() {
        System.out.println();
        for (int i = 0; i < dimensao; i++) {
            for (int j = 0; j < dimensao; j++) {
                if (matriz[i][j] == 0) {
                    System.out.print("   "); // Espaço vazio em branco
                } else {
                    System.out.format("%3d", matriz[i][j]);
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    // Verifica se o tabuleiro está resolvido (ordenado)
    public boolean verificarVitoria() {
        int valorEsperado = 1;
        for (int i = 0; i < dimensao; i++) {
            for (int j = 0; j < dimensao; j++) {
                // A última posição precisa ser 0
                if (i == dimensao - 1 && j == dimensao - 1) {
                    return matriz[i][j] == 0;
                }
                if (matriz[i][j] != valorEsperado) {
                    return false;
                }
                valorEsperado++;
            }
        }
        return true;
    }

    // Métodos auxiliares para as outras classes do grupo (principalmente para Movimento)
    
    public int getDimensao() {
        return dimensao;
    }

    public int getCelula(int linha, int coluna) {
        return matriz[linha][coluna];
    }

    public int getLinhaVazia() {
        return linhaVazia;
    }

    public int getColunaVazia() {
        return colunaVazia;
    }

    // Encontra a linha e coluna de uma determinada peça numerada
    public int[] encontrarPeca(int peca) {
        for (int i = 0; i < dimensao; i++) {
            for (int j = 0; j < dimensao; j++) {
                if (matriz[i][j] == peca) {
                    return new int[]{i, j};
                }
            }
        }
        return null; // Não encontrada
    }
}
