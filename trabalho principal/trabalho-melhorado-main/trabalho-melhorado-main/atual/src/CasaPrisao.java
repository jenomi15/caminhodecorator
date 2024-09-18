import java.util.ArrayList;
import java.util.Scanner;

public class CasaPrisao extends Casa {

    private static final int TAXA = 2;
    private static final int RODADAS_PRESO = 2;

    public CasaPrisao(int numero) {
        super(numero);
        this.cores = new ArrayList<>();
    }

    @Override
    public void aplicarRegra(Jogador jogador) {
        System.out.println("o jogador"+jogador.getCor()+" caiu na casa prisão");
        if (jogador.getPulaProximaRodada() == 0) {
          
            jogador.setPulaProximaRodada(RODADAS_PRESO);
            System.out.println("O jogador " + jogador.getCor() + " foi preso e não jogará por " + RODADAS_PRESO + " rodadas.");
        } else if (jogador.getPulaProximaRodada() == 1) {
           
            Scanner scanner = new Scanner(System.in);
            System.out.println("Você está preso! Deseja pagar uma taxa de " + TAXA + " moedas para sair da prisão agora? (1 - Sim, 2 - Não)");
            int escolha = scanner.nextInt();

            if (escolha == 1) {
                if (jogador.getPontuacaoEmMoedas() >= TAXA) {
                    jogador.removerMoeda(TAXA);
                    jogador.setPulaProximaRodada(0); 
                    System.out.println("O jogador " + jogador.getCor() + " pagou a taxa e saiu da prisão.");
                } else {
                    System.out.println("O jogador " + jogador.getCor() + " não tem moedas suficientes para pagar a taxa.");
                    jogador.setPulaProximaRodada(jogador.getPulaProximaRodada() - 1); 
                }
            } else {
                
                jogador.setPulaProximaRodada(jogador.getPulaProximaRodada() - 1);
                System.out.println("O jogador " + jogador.getCor() + " escolheu não pagar. Ainda está preso por " + jogador.getPulaProximaRodada() + " rodadas.");
            }
        } else {
           
            jogador.setPulaProximaRodada(jogador.getPulaProximaRodada() - 1);
            System.out.println("O jogador " + jogador.getCor() + " ainda está preso por " + jogador.getPulaProximaRodada() + " rodadas.");
        }
    }

    @Override
    public String toString() {
        return "Casa do tipo Prisão " + getNumero() + " -> Cores: " + cores;
    }
}
