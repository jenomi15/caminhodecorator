import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        ArrayList<Jogador> jogadores;
        int j;

        do {
            jogadores = new ArrayList<>();  
            System.out.println("BEM VINDO AO JOGO DE TABULEIRO\nDigite quantos jogadores você quer criar: ");
            j = teclado.nextInt();

            
            while (j < 1 || j > 6) {
                System.out.println("Número de jogadores inválido. Por favor, selecione um número de jogadores entre 1 e 6.");
                j = teclado.nextInt();
            }

            teclado.nextLine();  

           
            for (int i = 0; i < j; i++) {
                System.out.println("Digite a cor do " + (i + 1) + "º jogador: ");
                String cor = teclado.nextLine();

                String tipo = "";
                boolean tipoValido = false;

                while (!tipoValido) {
                    System.out.println("Digite o tipo do jogador (azarado, normal, sortudo): ");
                    tipo = teclado.nextLine().toLowerCase();

                    if (tipo.equals("azarado") || tipo.equals("normal") || tipo.equals("sortudo")) {
                        tipoValido = true;  
                    } else {
                        System.out.println("Tipo inválido. Escolha entre azarado, normal, ou sortudo.");
                    }
                }

                Jogador jogador = JogadorFactory.criarJogador(tipo, cor, 0, 0, 0, 0, false, false, false);
                jogadores.add(jogador);
            }

         
            if (!verificarDiversidadeTipos(jogadores)) {
                System.out.println("Não há diversidade suficiente de tipos de jogadores.");
                System.out.println("Reiniciando a criação de jogadores para garantir diversidade...");
            }
        } while (!verificarDiversidadeTipos(jogadores));

        
        for (int i = 0; i < jogadores.size(); i++) {
            Jogador jogador = jogadores.get(i);
            System.out.println("Jogador " + (i + 1) + " - Cor: " + jogador.getCor() + " - Tipo: " + jogador.getClass().getSimpleName());
        }

      
        Tabuleiro tabuleiro = Tabuleiro.getInstancia(jogadores);
        tabuleiro.criacaoDoTabuleiro();

        
        for (int l = 0; l < j; l++) {
            tabuleiro.adicionarCorCasa(0, jogadores.get(l).getCor());
        }

        
        tabuleiro.imprimirTabuleiro();

       
        System.out.println("Selecione o modo de jogo: ");
        System.out.println("1 - Modo Normal");
        System.out.println("2 - Modo Debug");
        int opcao = teclado.nextInt();

       
        if (opcao == 1) {
            System.out.println("Iniciando o jogo no modo normal...");
            tabuleiro.TurnoDoJogo();
        } else if (opcao == 2) {
            System.out.println("Iniciando o jogo no modo debug...");
            tabuleiro.TurnoDoJogoDebug();
        } else {
            System.out.println("Opção inválida. Iniciando no modo normal por padrão...");
            tabuleiro.TurnoDoJogo();
        }

        teclado.close();
    }

    
    private static boolean verificarDiversidadeTipos(ArrayList<Jogador> jogadores) {
        Set<String> tipos = new HashSet<>();
        for (Jogador jogador : jogadores) {
            tipos.add(jogador.getClass().getSimpleName());
        }
        return tipos.size() > 1;
    }
}
