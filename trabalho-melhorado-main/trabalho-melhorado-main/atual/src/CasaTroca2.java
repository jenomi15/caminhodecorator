import java.util.Scanner;

public class CasaTroca2 extends Casa {

    public CasaTroca2(int numero) {
        super(numero);
    }

    @Override
    public void aplicarRegra(Jogador jogador) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Bem-vindo à Casa de Troca!");
        System.out.println("Escolha um acessório: 1 - Boné (1 moeda), 2 - Moletom (3 moedas), 3 - Óculos Escuros (6 moedas)");
        int escolha = scanner.nextInt();

        // Inicialmente não decorado
        JogadorBase jogadorDecorado = jogador;
        
        // Verifica se o jogador já possui os acessórios necessários antes de permitir a compra
        switch (escolha) {
            case 1:
                // Compra de Boné
                int precoBone = 1;
                if (jogador.getPontuacaoEmMoedas() >= precoBone) {
                    jogador.removerMoeda(precoBone);
                    jogador.setBoné(true); // Atualiza o estado do jogador
                    System.out.println("Você comprou um Boné por " + precoBone + " moedas.");
                } else {
                    System.out.println("Você não tem moedas suficientes para comprar um Boné.");
                }
                break;

            case 2:
                // Compra de Moletom
                if (jogador.temBoné()) {
                    int precoMoletom = 3;
                    if (jogador.getPontuacaoEmMoedas() >= precoMoletom) {
                        jogador.removerMoeda(precoMoletom);
                        jogador.setMoleton(true); // Atualiza o estado do jogador
                        System.out.println("Você comprou um Moletom por " + precoMoletom + " moedas.");
                    } else {
                        System.out.println("Você não tem moedas suficientes para comprar um Moletom.");
                    }
                } else {
                    System.out.println("Você precisa ter um Boné para comprar um Moletom.");
                }
                break;

            case 3:
                // Compra de Óculos Escuros
                if (jogador.temBoné() && jogador.temMoleton()) {
                    int precoOculosEscuros = 6;
                    if (jogador.getPontuacaoEmMoedas() >= precoOculosEscuros) {
                        jogador.removerMoeda(precoOculosEscuros);
                        jogador.setOculosEscuros(true); // Atualiza o estado do jogador
                        System.out.println("Você comprou Óculos Escuros por " + precoOculosEscuros + " moedas.");
                    } else {
                        System.out.println("Você não tem moedas suficientes para comprar Óculos Escuros.");
                    }
                } else {
                    System.out.println("Você precisa ter um Boné e um Moletom para comprar Óculos Escuros.");
                }
                break;

            default:
                System.out.println("Escolha inválida!");
                break;
        }
        
        // Atualiza a pontuação em moedas do jogador com base na decoração
        int moedasCasaSimples = jogador.getMoedasCasaSimples();
        jogador.adicionarMoedas(moedasCasaSimples);
        System.out.println("Moedas ao cair em Casa Simples: " + moedasCasaSimples);

        // Verificadores de Depuração
        System.out.println("Estado atual do jogador: " + jogador.getDescricao());
    }

    @Override
    public String toString() {
        return "Casa do tipo troca " + getNumero()  + " -> Cores: " + cores;
    }
}