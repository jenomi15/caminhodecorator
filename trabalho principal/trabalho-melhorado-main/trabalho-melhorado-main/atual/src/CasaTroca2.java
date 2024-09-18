import java.util.Scanner;

public class CasaTroca2 extends Casa {

    public CasaTroca2(int numero) {
        super(numero);
    }

    @Override
    public void aplicarRegra(Jogador jogador) {
        Scanner scanner = new Scanner(System.in);
         System.out.println(" o jogador "+ jogador.getCor()+" caiu na casa troca ");
      
        if (jogador.temBoné() && jogador.temMoleton() && jogador.temOculosEscuros()) {
            System.out.println("Você já possui todos os itens (Boné, Moletom e Óculos Escuros). Não há mais itens para comprar.");
            return; 
        }

        System.out.println("Bem-vindo à Casa de Troca!");
        System.out.println("Escolha um acessório: 1 - Boné (1 moeda), 2 - Moletom (3 moedas), 3 - Óculos Escuros (6 moedas)");
        int escolha = scanner.nextInt();

       
        JogadorBase jogadorDecorado = jogador;
        
       
        switch (escolha) {
            case 1:
                // Compra de Boné
                if (jogador.temBoné()) {
                    System.out.println("Você já possui um Boné. Escolha outro acessório.");
                } else {
                    int precoBone = 1;
                    if (jogador.getPontuacaoEmMoedas() >= precoBone) {
                        jogador.removerMoeda(precoBone);
                        jogador.setBoné(true);
                        System.out.println("Você comprou um Boné por " + precoBone + " moedas.");
                    } else {
                        System.out.println("Você não tem moedas suficientes para comprar um Boné.");
                    }
                }
                break;

            case 2:
               
                if (jogador.temMoleton()) {
                    System.out.println("Você já possui um Moletom. Escolha outro acessório.");
                } else if (!jogador.temBoné()) {
                    System.out.println("Você precisa ter um Boné para comprar um Moletom.");
                } else {
                    int precoMoletom = 3;
                    if (jogador.getPontuacaoEmMoedas() >= precoMoletom) {
                        jogador.removerMoeda(precoMoletom);
                        jogador.setMoleton(true); 
                        System.out.println("Você comprou um Moletom por " + precoMoletom + " moedas.");
                    } else {
                        System.out.println("Você não tem moedas suficientes para comprar um Moletom.");
                    }
                }
                break;

            case 3:
               
                if (jogador.temOculosEscuros()) {
                    System.out.println("Você já possui Óculos Escuros. Escolha outro acessório.");
                } else if (!jogador.temBoné() || !jogador.temMoleton()) {
                    System.out.println("Você precisa ter um Boné e um Moletom para comprar Óculos Escuros.");
                } else {
                    int precoOculosEscuros = 6;
                    if (jogador.getPontuacaoEmMoedas() >= precoOculosEscuros) {
                        jogador.removerMoeda(precoOculosEscuros);
                        jogador.setOculosEscuros(true);
                        System.out.println("Você comprou Óculos Escuros por " + precoOculosEscuros + " moedas.");
                    } else {
                        System.out.println("Você não tem moedas suficientes para comprar Óculos Escuros.");
                    }
                }
                break;

            default:
                System.out.println("Escolha inválida!");
                break;
        }
        
        // Atualiza a pontuação em moedas do jogador com base na decoração
      //  int moedasCasaSimples = jogador.getMoedasCasaSimples();
       // jogador.adicionarMoedas(moedasCasaSimples);
        //System.out.println("Moedas ao cair em Casa Simples: " + moedasCasaSimples);

        // Verificadores de Depuração
        System.out.println("Estado atual do jogador: " + jogador.getDescricao());
    }

    @Override
    public String toString() {
        return "Casa do tipo troca " + getNumero()  + " -> Cores: " + cores;
    }
}
