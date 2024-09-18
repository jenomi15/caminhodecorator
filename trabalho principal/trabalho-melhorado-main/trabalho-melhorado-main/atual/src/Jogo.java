import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Jogo {
    private Tabuleiro tabuleiro;

    public void config(int numJogadores) {
        ArrayList<Jogador> jogadores;
        Scanner teclado = new Scanner(System.in);

        do {
            jogadores = new ArrayList<>(); 
            for (int i = 0; i < numJogadores; i++) {
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
        tabuleiro = Tabuleiro.getInstancia(jogadores);
        tabuleiro.adicionarJogadores(jogadores);
    }

   
    private boolean verificarDiversidadeTipos(ArrayList<Jogador> jogadores) {
        Set<String> tipos = new HashSet<>();
        for (Jogador jogador : jogadores) {
            tipos.add(jogador.getClass().getSimpleName());
        }
        return tipos.size() > 1;
    }

    public void configTabuleiro(int numCasas) {
        tabuleiro.criacaoDoTabuleiro1(numCasas);
    }

    public void printTabuleiro() {
        tabuleiro.imprimirTabuleiro();
    }

    public void start() {
        Scanner teclado = new Scanner(System.in);
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
    }
}
