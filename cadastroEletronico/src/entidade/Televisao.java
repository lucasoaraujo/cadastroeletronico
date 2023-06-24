package entidade;

public class Televisao extends Eletronico {

	private Integer polegadas;
	private String monitor;

	public Televisao() {
		super();
	}

	public Televisao(String nome, Double preco, Integer quantidade, String marca, Integer codigo, Integer polegadas,
			String monitor) {
		super(nome, preco, quantidade, marca, codigo);
		this.polegadas = polegadas;
		this.monitor = monitor;
	}



	public Integer getPolegadas() {
		return polegadas;
	}

	public void setPolegadas(Integer polegadas) {
		this.polegadas = polegadas;
	}

	public String getMonitor() {
		return monitor;
	}

	public void setMonitor(String monitor) {
		this.monitor = monitor;
	}
	

}
