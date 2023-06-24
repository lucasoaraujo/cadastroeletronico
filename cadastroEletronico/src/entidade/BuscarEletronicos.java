package entidade;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import entidade.Notebook;
import entidade.Lavadora;
import entidade.Televisao;

@SuppressWarnings("unused")
public class BuscarEletronicos {

    // Método para buscar um produto pelo código
	public static void buscar(ArrayList<Eletronico> produtos, Scanner sc) {
	    Integer codigo = null;
	    boolean codigoValido = false;
	    /*O bloco catch mencionado no código captura as exceções NumberFormatException e InputMismatchException, 
	      que ocorrem quando o usuário digita uma opção inválida que não pode ser convertida para um número inteiro.
	      O for é utilizado para percorrer a lista de produtos e encontrar o produto com o código informado pelo usuário.*/
	    while (!codigoValido) {
	        System.out.print("Informe o código do produto: ");
	        try {
	            codigo = sc.nextInt();
	            sc.nextLine();
	            for (Eletronico produto : produtos) {
	                if (produto.getCodigo().equals(codigo)) {
	                    codigoValido = true;
	                    break;
	                }
	            }
	            if (!codigoValido) {
	                System.out.println("Código inválido. Insira um código válido.");
	            }
	        } catch (InputMismatchException e) {
	            System.out.println("Código inválido. Insira um valor numérico.");
	            sc.nextLine(); // Limpa o buffer do scanner
	        }
	    }

	    boolean produtoEncontrado = false;
	    System.out.println();

	    for (Eletronico p : produtos) {
	        if (codigo.equals(p.getCodigo())) { 
	            System.out.println("*PRODUTO ENCONTRADO*");
	            System.out.println();
	            System.out.println("Nome: " + p.getNome()); 

	            DecimalFormat decimalFormat = new DecimalFormat("#0.00");
	            String precoFormatado = decimalFormat.format(p.getPreco()); 
	            System.out.println("Preço: R$ " + precoFormatado); 
	            System.out.println("Quantidade: " + p.getQuantidade()); 
	            System.out.println("Marca: " + p.getMarca());
	            System.out.println("Código: " + p.getCodigo());

	            /* Esses blocos if permitem tratar cada tipo de produto de forma específica, exibindo informações adicionais relevantes 
	            para cada tipo*/
	            if (p instanceof Notebook) {
	                Notebook notebook = (Notebook) p;
	                System.out.println("Memória: " + notebook.getMemoria());
	                System.out.println("Sistema: " + notebook.getSistema());
	            } else if (p instanceof Televisao) {
	                Televisao televisao = (Televisao) p;
	                System.out.println("Polegadas: " + televisao.getPolegadas());
	                System.out.println("Monitor: " + televisao.getMonitor());
	            } else if (p instanceof Lavadora) {
	                Lavadora lavadora = (Lavadora) p;
	                System.out.println("Capacidade: " + lavadora.getCapacidade());
	            }

	            produtoEncontrado = true;
	            break;
	        }
	    }

	    // Verifica se o produto foi encontrado
	    if (!produtoEncontrado) {
	        System.out.println("Produto não encontrado!");
	    }
	}
}
