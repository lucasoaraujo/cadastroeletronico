package entidade;

import java.util.Objects;

public class Eletronico {
	private String nome;
	private Double preco;
	private Integer quantidade;
	private String marca;
	private Integer codigo;
	
	public Eletronico() {
		
	}

	// Construtor da classe Produto
	public Eletronico(String nome, Double preco, Integer quantidade, String marca, Integer codigo) {
		this.nome = nome;
		this.preco = preco;
		this.quantidade = quantidade;
		this.marca = marca;
		this.codigo = codigo;
	}

	/*Getters: Obter o valor de um atributo.
      Setters: Definir o valor de um atributo.*/
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public Integer getCodigo() {
		return codigo;
	}
	
	/*O método equals(Object o) compara se dois objetos são iguais com base no código,  enquanto o método hashCode() 
	  calcula um valor hash único com base no código para otimizar a busca em estruturas de dados como tabelas hash.*/
	/*A finalidade do @Override é fornecer uma verificação de tempo de compilação para garantir que o método esteja realmente substituindo um 
	  método da classe pai. Isso ajuda a evitar erros de digitação e inconsistências que poderiam ocorrer ao substituir um método.*/
	@Override
	public boolean equals(Object o) {
	    if (this == o) return true;
	    if (o == null || getClass() != o.getClass()) return false;
	    Eletronico that = (Eletronico) o;
	    return codigo.equals(that.codigo);
	}

	@Override
	public int hashCode() {
	    return Objects.hash(codigo);
	}


}
