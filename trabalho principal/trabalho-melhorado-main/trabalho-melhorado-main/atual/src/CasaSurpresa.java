import java.util.List;
import java.util.Random;
import java.util.ArrayList;

public class CasaSurpresa extends Casa {

    private String[] tiposDeJogador = {"Azarado", "Normal", "Sortudo"};
    private List<Jogador> jogadores;
    private List<Casa> tabuleiroJogado;

    public CasaSurpresa(int numero) {
        super(numero);
        this.cores = new ArrayList<>();
    }

    public CasaSurpresa(int numero, List<Jogador> jogadores, List<Casa> tabuleiroJogado) {
        super(numero);
        this.cores = new ArrayList<>();
        this.jogadores = jogadores;
        this.tabuleiroJogado = tabuleiroJogado;
    }

    @Override
    public void aplicarRegra(Jogador jogador) {
        System.out.println("o jogador "+jogador.getCor()+ "caiu na casa surpresa ");
        tirarCartaAleatoria(jogador);
    }

    private void tirarCartaAleatoria(Jogador jogador) {
        Random rand = new Random();
        int tipoAleatorio;

      
        do {
            tipoAleatorio = rand.nextInt(3) + 1;
        } while (jogador.getTipo() == tipoAleatorio);

        
        TrocaJogador(jogador, tipoAleatorio);
        System.out.println("O jogador " + jogador.getCor() + " agora é do tipo " + tiposDeJogador[tipoAleatorio - 1]);
    }

    private void TrocaJogador(Jogador jogador, int tipoJogador) {
        Jogador novoJogador;
    
       
        boolean temBoné = jogador.temBoné();
        boolean temMoleton = jogador.temMoleton();
        boolean temOculosEscuros = jogador.temOculosEscuros();
    
        // Cria o novo jogador com base no tipo 9 (  pode ser 1 ,2 ou 3)
        switch (tipoJogador) {
            case 1:
                novoJogador = new JogadorAzarado(jogador.getCor(), jogador.getNumeroCasa(), jogador.getPulaProximaRodada(), jogador.getNumeroDeJogadas(), jogador.getPontuacaoEmMoedas(), temBoné, temMoleton, temOculosEscuros);
                break;
            case 2:
                novoJogador = new JogadorNormal(jogador.getCor(), jogador.getNumeroCasa(), jogador.getPulaProximaRodada(), jogador.getNumeroDeJogadas(), jogador.getPontuacaoEmMoedas(), temBoné, temMoleton, temOculosEscuros);
                break;
            case 3:
                novoJogador = new JogadorSortudo(jogador.getCor(), jogador.getNumeroCasa(), jogador.getPulaProximaRodada(), jogador.getNumeroDeJogadas(), jogador.getPontuacaoEmMoedas(), temBoné, temMoleton, temOculosEscuros);
                break;
            default:
                System.out.println("Tipo de jogador inválido");
                return;
        }
    
        
        int index = jogadores.indexOf(jogador);
        if (index != -1) {
            jogadores.set(index, novoJogador);
        }
    }
    
    @Override
    public String toString() {
        return "Casa do tipo Surpresa " + getNumero() + " -> Cores: " + cores;
    }
}
