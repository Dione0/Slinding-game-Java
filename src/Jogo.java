import java.util.Scanner;

public class Jogo {
        private Jogador jogador;
        private Tabuleiro tabuleiro;
        private Movimento movimento;
        private Ranking ranking;
        private Scanner scanner;

        public Jogo(Ranking ranking) {
        this.ranking = ranking;
        this.scanner = new Scanner(System.in);
        this.movimento = new Movimento();
    }

public void iniciarPartida() {
    System.out.print("Nome do jogador: ");
    String nome = scanner.nextLine();

    System.out.print("Tamanho do tabuleiro: ");
    int dimensao = scanner.nextInt();
    scanner.nextLine();

    this.jogador = new Jogador(nome);
    this.tabuleiro = new Tabuleiro(dimensao);
    int pontos = 0;
    boolean ganhou = false;

    while (ganhou == false) {
        tabuleiro.exibir();
        System.out.println("Pontos atuais: " + pontos);
        System.out.print("Escolha a peca para mover (ou 0 para sair): ");

        int peca = scanner.nextInt();
        scanner.nextLine();

        if (peca == 0) {
            System.out.println("Voce desistiu!");
            break;
        }

        if (movimento.verificar(tabuleiro, peca)) {
            pontos = pontos + 1;
        } else {
            System.out.println("Movimento invalido!");
        }

        ganhou = tabuleiro.verificarVitoria();
    }

    if (ganhou == true) {
        System.out.println("Voce ganhou o jogo!");
        jogador.setPontuacao(pontos);
        ranking.adicionar(jogador);
    }
}
}