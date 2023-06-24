package entidade;

public class Notebook extends Eletronico {
    private String memoria;
    private String sistema;
    
    public Notebook() {
    	super();
    }

    public Notebook(String nome, Double preco, Integer quantidade, String marca, Integer codigo, String memoria, String sistema) {
        super(nome, preco, quantidade, marca, codigo);
        this.memoria = memoria;
        this.sistema = sistema;
    }

	public String getMemoria() {
		return memoria;
	}

	public void setMemoria(String memoria) {
		this.memoria = memoria;
	}

	public String getSistema() {
		return sistema;
	}

	public void setSistema(String sistema) {
		this.sistema = sistema;
	}

    
}
