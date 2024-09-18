import java.util.ArrayList;
import java.util.Scanner;

public class CasaPrisao extends Casa {

    private static final int TAXA = 2;
    private int rodadasPreso = 1;  // O jogador ficará preso por 2 rodadas se não pagar a taxa

    public CasaPrisao(int numero) {
        super(numero);
        this.cores = new ArrayList<>();
    }

    @Override
    public void aplicarRegra(Jogador jogador) {
        // Notifica que o jogador está preso e que pode pagar a taxa para sair
        System.out.println("Casa Prisão: O jogador " + jogador.getCor() + " está preso e não jogará na próxima rodada.");

        Scanner scanner = new Scanner(System.in);

        // Pergunta se o jogador deseja pagar a taxa para sair da prisão
        System.out.println("Deseja pagar uma taxa de " + TAXA + " moedas para sair da prisão imediatamente? (1 - Sim, 2 - Não)");
        int escolha = scanner.nextInt();

        // Se o jogador optar por pagar a taxa
        if (escolha == 1) {
            if (jogador.getPontuacaoEmMoedas() >= TAXA) {
                jogador.removerMoeda(TAXA);  // Subtrai as moedas do jogador
                jogador.setPulaProximaRodada(0);  // O jogador pode jogar imediatamente, saindo da prisão
                System.out.println("O jogador " + jogador.getCor() + " pagou a taxa e saiu da prisão.");
            } else {
                // Se o jogador não tiver moedas suficientes para pagar a taxa
                System.out.println("O jogador " + jogador.getCor() + " não tem moedas suficientes para pagar a taxa.");
                jogador.setPulaProximaRodada(rodadasPreso);  // Define que o jogador ficará preso por 2 rodadas
            }
        } else {
            // Se o jogador não quiser pagar a taxa, ele ficará preso por 2 rodadas
            jogador.setPulaProximaRodada(rodadasPreso);
            System.out.println("O jogador " + jogador.getCor() + " ficará preso por " + rodadasPreso + " rodadas.");
        }
    }

    @Override
    public String toString() {
        return "Casa do tipo Prisão " + getNumero() + " -> Cores: " + cores;
    }
}
