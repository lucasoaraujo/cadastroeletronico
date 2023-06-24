package entidade;

public class Lavadora extends Eletronico {
	/*"extends" em herança significa que uma classe está estendendo (herdando) os atributos e métodos de outra classe.*/

	private String capacidade;

	/*super em herança é uma referência à classe pai (superclasse) dentro de uma classe filha (subclasse). É usado para chamar 
	  os construtores, métodos ou acessar os membros da classe pai.*/
	public Lavadora() {
		super();
	}

	public Lavadora(String nome, Double preco, Integer quantidade, String marca, Integer codigo, String capacidade) {
		super(nome, preco, quantidade, marca, codigo);
		this.capacidade = capacidade;
	}

	public String getCapacidade() {
		return capacidade;
	}

	public void setCapacidade(String capacidade) {
		this.capacidade = capacidade;
	}

}
