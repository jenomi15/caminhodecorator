import java.util.Scanner;

public class Facade {

    public static void main(String[] args) {
        Jogo jogo = new Jogo();
        Scanner teclado = new Scanner(System.in);
        System.out.println("Digite o número de casas no tabuleiro: ");
        int numCasas = teclado.nextInt();
        int numJogadores;
        do {
            System.out.println("Digite o número de jogadores (1 a 6): ");
            numJogadores = teclado.nextInt();
        } while (numJogadores < 1 || numJogadores > 6);
        jogo.config(numJogadores);
        jogo.configTabuleiro(numCasas);
        jogo.printTabuleiro();
        jogo.start();
        teclado.close();
    }
}
