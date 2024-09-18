import java.util.ArrayList;
import java.util.List;

public abstract class Casa {
    protected String cor;
    protected int numero;
    protected List<String> cores;

    public Casa(int numero  ) {
        this.numero = numero;
        this.cores = new ArrayList<>();
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public List<String> getCores() {
        return cores;
    }

    public void setCores(List<String> cores) {
        this.cores = cores;
    }

    public void adicionarCor(String cor) {
        cores.add(cor);
    }
   

    public void removerCor(String cor) {
        cores.remove(cor);
    }
    public boolean temCor() {
        return cor != null && !cor.isEmpty();
    }
    public void aplicarRegra(Jogador jogador ){
       System.out.println("regra aplicada");
    }

  
  


@Override
public String toString() {
    return "Casa " +  numero   + " -> Cores: " + cores;
    
    
}
}
