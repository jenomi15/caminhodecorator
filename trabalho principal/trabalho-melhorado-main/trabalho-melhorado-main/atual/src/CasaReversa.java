import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class CasaReversa extends Casa {

    private List<Jogador> jogadores;
    private List<Casa> tabuleiroJogado;

    public CasaReversa(int numero) {
        super(numero);
        this.cores = new ArrayList<>();
        this.jogadores = new ArrayList<>();
        this.tabuleiroJogado = new ArrayList<>();
    }

    public CasaReversa(int numero, List<Jogador> jogadores, List<Casa> tabuleiroJogado) {
        super(numero);
        this.jogadores = jogadores;
        this.tabuleiroJogado = tabuleiroJogado;
    }

    @Override
    public void aplicarRegra(Jogador jogador) {
        System.out.println("o jogador "+ jogador.getCor()+" caiu na casa reversa");
        if (jogadores != null && tabuleiroJogado != null) {
            trocarDeLugarComUltimo(jogador);
        } else {
            System.out.println("CasaReversa não está completamente configurada.");
        }
    }

    private void trocarDeLugarComUltimo(Jogador jogador) {
        
        int menorNumeroCasa = jogadores.stream()
            .mapToInt(Jogador::getNumeroCasa)
            .min()
            .orElse(-1);
    
       
        List<Jogador> ultimosJogadores = jogadores.stream()
            .filter(j -> j.getNumeroCasa() == menorNumeroCasa)
            .collect(Collectors.toList());
    
        Jogador ultimoJogador;
    
        if (ultimosJogadores.size() > 1) {
            ultimoJogador = escolherAleatoriamente(ultimosJogadores);
        } else {
            ultimoJogador = ultimosJogadores.get(0);
        }
    
        if (jogador != ultimoJogador) {
            int posicaoAtual = jogador.getNumeroCasa();
            int novaPosicaoUltimo = ultimoJogador.getNumeroCasa();
    
            
            jogador.setNumeroCasa(novaPosicaoUltimo);
            ultimoJogador.setNumeroCasa(posicaoAtual);
    
            int indiceJogador = jogadores.indexOf(jogador);
             int indiceUltimoJogador = jogadores.indexOf(ultimoJogador);
             jogadores.set(indiceJogador, ultimoJogador);
             jogadores.set(indiceUltimoJogador, jogador);
        
    
            
            atualizarTabuleiro(jogador, ultimoJogador);
    
            System.out.println("O jogador " + jogador.getCor() + " trocou de posição com o jogador " + ultimoJogador.getCor());
        } else {
            System.out.println("O jogador já está na última posição e não pode trocar!");
        }
    }

    private void atualizarTabuleiro(Jogador jogador, Jogador ultimoJogador) {
        
        Casa casaJogador = tabuleiroJogado.get(jogador.getNumeroCasa());
        Casa casaUltimoJogador = tabuleiroJogado.get(ultimoJogador.getNumeroCasa());

        
        if (casaJogador != null) {
            casaJogador.removerCor(ultimoJogador.getCor());
            casaJogador.adicionarCor(jogador.getCor());
        }

        if (casaUltimoJogador != null) {
            casaUltimoJogador.removerCor(jogador.getCor());
            casaUltimoJogador.adicionarCor(ultimoJogador.getCor());
        }
    }
        // Caso especial para a casa 0, remover a cor antiga
       // if (jogador.getNumeroCasa() == 0) {
         //   tabuleiroJogado.get(0).removerCor(jogador.getCor());
       // } else if (ultimoJogador.getNumeroCasa() == 0) {
       //     tabuleiroJogado.get(0).removerCor(ultimoJogador.getCor());
      //  }
  //  }

    private Jogador escolherAleatoriamente(List<Jogador> jogadores) {
        Random rand = new Random();
        return jogadores.get(rand.nextInt(jogadores.size()));
    }

    @Override
    public String toString() {
        return "Casa do tipo reversa " + getNumero()  + " -> Cores: " + cores;
        // se quiser imprimir da casa 1 a 40 é só colocar (numero + 1)
    }
}
