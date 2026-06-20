public class Movimento {
    public int Mover(int[][] matriz, int n, char movimento) {
        int linhaVazia = 0;
        int colunaVazia = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (matriz[i][j] == 0) {
                    linhaVazia = i;
                    colunaVazia = j;
                }
            }
        }

        int novaLinha = linhaVazia;
        int novaColuna = colunaVazia;

        switch (movimento) {
            case 'w':
            case 'W':
                novaLinha++;
                break;
            case 's':
            case 'S':
                novaLinha--;
                break;
            case 'a':
            case 'A':
                novaColuna++;
                break;
            case 'd':
            case 'D':
                novaColuna--;
                break;
            default:
                return 0;
        }

        if (novaLinha < 0 || novaLinha >= n || novaColuna < 0 || novaColuna >= n) {
            return 0;
        }

        int temp = matriz[novaLinha][novaColuna];
        matriz[novaLinha][novaColuna] = 0;
        matriz[linhaVazia][colunaVazia] = temp;

        return 1;
    }

    public boolean verificar(Tabuleiro tabuleiro, int peca) {
        return false;
    }
}