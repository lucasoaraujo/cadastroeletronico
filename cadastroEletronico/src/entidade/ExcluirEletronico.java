package entidade;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ExcluirEletronico {

    public static void excluir(ArrayList<Eletronico> produtos, Scanner sc) {
    	Integer codigo = null;
		boolean codigoValido = false;
		while (!codigoValido) {
			System.out.print("Digite o código do produto a ser excluído: ");
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

            // Procura o produto com o código informado
            for (Eletronico produto : produtos) {
                if (produto.getCodigo().equals(codigo)) { // Alterado para utilizar o método equals() do Integer
                    System.out.print("Deseja realmente excluir o item " + produto.getNome() + "? (S/N): ");
                    String confirmacao = sc.next().toUpperCase();
                    sc.nextLine();
                    System.out.println();

                    while (!confirmacao.equals("S") && !confirmacao.equals("N")) {
                        System.out.print("Opção inválida! Digite S para confirmar ou N para cancelar: ");
                        confirmacao = sc.next().toUpperCase();
                    }

                    if (confirmacao.equals("S")) {
                        produtos.remove(produto);
                        System.out.println("Item removido com sucesso!\n");
                    } else {
                        System.out.println("Exclusão cancelada pelo usuário.\n");
                    }
                    return; // Sai do método assim que encontrar o produto
                }
            }

            System.out.println("Produto não encontrado.\n");
        } 
    }

