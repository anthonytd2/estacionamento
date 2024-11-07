package principal;

public class Vaga {
    private int numero;
    private String tamanho;
    private boolean disponivel;
    private Veiculo veiculo;

    public Vaga(int numero, String tamanho) {
        this.numero = numero;
        this.tamanho = tamanho;
        this.disponivel = true;
    }

    public int getNumero() {
        return numero;
    }

    public String getTamanho() {
        return tamanho;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void ocupar(Veiculo veiculo) {
        this.veiculo = veiculo;
        this.disponivel = false;
    }

    public void liberar() {
        this.veiculo = null;
        this.disponivel = true;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }
}
