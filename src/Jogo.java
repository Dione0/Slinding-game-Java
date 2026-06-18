import java.util.scanner;

public class Jogo {
        private Jogador jogador;
        private Tabuleiro tabuleiro;
        private Movimento movimento;
        private Ranking ranking;
        private Scanner scanner;
        public Jogo(Ranking ranking){
            this.ranking = ranking;
            this.scanner = new Scanner(System.in);
            this.movimento = new Movimento();
        }
}
