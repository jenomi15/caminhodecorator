
public class JogadorAzarado extends Jogador {

    public JogadorAzarado(String cor, int numeroCasa, int pulaProximaRodada, int numeroDeJogadas, int pontuacaoEmMoedas, boolean boné, boolean moleton, boolean oculosEscuros) {
        super(cor, pontuacaoEmMoedas, pontuacaoEmMoedas, pontuacaoEmMoedas, pontuacaoEmMoedas, oculosEscuros, oculosEscuros, oculosEscuros);
        this.cor = cor ;
        this.numeroCasa = numeroCasa;
        this.pulaProximaRodada = pulaProximaRodada;
        this.numeroDeJogadas = numeroDeJogadas;
        this.pontuacaoEmMoedas = pontuacaoEmMoedas;

       
        setBoné(boné);
        setMoleton(moleton);
        setOculosEscuros(oculosEscuros);

        setTipo(1); // Define o tipo como Azarado
    }

    @Override
    public ResultadoDados rolarDados() {
        int dado1, dado2, soma;
        
     
        do {
            dado1 = (int) (Math.random() * 6) + 1;
            dado2 = (int) (Math.random() * 6) + 1;
            soma = dado1 + dado2;
        } while (soma > 6);

        System.out.println("O dado 1 rolou: " + dado1);
        System.out.println("O dado 2 rolou: " + dado2);
        System.out.println("A soma dos dados: " + soma);

        boolean iguais = (dado1 == dado2); 
        return new ResultadoDados(soma, iguais);
    }

    @Override
    public String toString() {
        return "Jogador Azarado: cor = " + getCor() + ", número da casa = " + getNumeroCasa();
    }

    @Override
    public void adicionarMoedas(int quantidade) {
        super.adicionarMoeda(quantidade); 
    }
}






   






    



