import java.util.ArrayList;
import java.util.List;

public class CasaSorte extends Casa {

    private List<Jogador> jogadores;
    private List<Casa> tabuleiroJogado; 

    public CasaSorte(int numero, List<Jogador> jogadores, List<Casa> tabuleiroJogado) {
        super(numero);
        this.jogadores = jogadores;
        this.tabuleiroJogado = tabuleiroJogado; 
        this.cores = new ArrayList<>();
    }

    @Override
    public void aplicarRegra(Jogador jogador) {
        System.out.println("o jogador "+ jogador.getCor()+" caiu na casa sorte ");
        if ((jogador instanceof JogadorSortudo) || (jogador instanceof JogadorNormal)) {
            int novaPosicao = jogador.getNumeroCasa() + 3;
            int totalDeCasas = tabuleiroJogado.size(); 

            if (novaPosicao >= totalDeCasas) {
                novaPosicao = totalDeCasas - 1; 
            }
            
            jogador.setNumeroCasa(jogador.getNumeroCasa()+3);
            
            System.out.println("O jogador " + jogador.getCor() + " andou 3 casas para frente e está agora na casa " + novaPosicao);
        } else {
            System.out.println("O jogador " + jogador.getCor() + " é um Jogador Azarado e não se move.");
        }
        
    }

    @Override
    public String toString() {
        return "Casa do tipo Sorte " + getNumero()  + " -> Cores: " + cores;
    }
}  