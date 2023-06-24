package entidade;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class CadastrarEletronico {

	public static void cadastrar(ArrayList<Eletronico> produtos, Scanner sc) {
		try {
			System.out.print("Digite o nome do produto: ");
			String nome = sc.nextLine();
			System.out.print("Marca: ");
			String marca = sc.nextLine();

			System.out.print("Preço: ");
			Double preco;
			while (true) {
				try {
					String input = sc.nextLine().replaceAll("\\s+", ""); // Remove os espaços em branco

					preco = Double.parseDouble(input);
					if (preco > 0) {
						break; // Sai do loop se o número for válido
					} else {
						System.out.println("Preço inválido.");
						System.out.print("Preço: ");
					}
				} catch (NumberFormatException e) {
					System.out.println("Preço inválido.");
					System.out.print("Preço: ");
				}
			}

			System.out.print("Quantidade em estoque: ");
			Integer quantidade;
			while (true) {
				try {
					String input = sc.nextLine().replaceAll("\\s+", ""); // Remove os espaços em branco

					quantidade = Integer.parseInt(input);
					if (quantidade > 0) {
						break; // Sai do loop se o número for válido
					} else {
						System.out.println("Quantidade inválida.");
						System.out.print("Quantidade: ");
					}
				} catch (NumberFormatException e) {
					System.out.println("Quantidade inválida.");
					System.out.print("Quantidade: ");
				}
			}

			System.out.print("Código: ");
			Integer codigo;
			while (true) {
				try {
					String input = sc.nextLine().replaceAll("\\s+", ""); // Remove os espaços em branco

					codigo = Integer.parseInt(input);
					if (codigo > 0) {
						// Verifica se o código já está sendo usado
						if (existeProdutoComCodigo(produtos, codigo)) {
							System.out.println(
									"Já existe um produto cadastrado com esse código. Digite um código diferente.");
							System.out.print("Código: ");
						} else {
							break; // Sai do loop se o código for válido e não estiver sendo usado
						}
					} else {
						System.out.println("Código inválido.");
						System.out.print("Código: ");
					}
				} catch (NumberFormatException e) {
					System.out.println("Código inválido.");
					System.out.print("Código: ");
				}
			}

			DecimalFormat decimalFormat = new DecimalFormat("#0.00");
			String precoFormatado = decimalFormat.format(preco);

			// Cadastro específico para cada tipo de produto
			Eletronico novoProduto = null;
			if (nome.equalsIgnoreCase("Lavadora")) {
				System.out.print("Capacidade: ");
				String capacidade = sc.nextLine();
				novoProduto = new Lavadora(nome, Double.parseDouble(precoFormatado), quantidade, marca, codigo,
						capacidade);
			} else if (nome.equalsIgnoreCase("Notebook")) {
				System.out.print("Memória: ");
				String memoria = sc.nextLine();

				while (memoria.contains("-") || Double.parseDouble(memoria) <= 0) {
					System.out.println("Memória inválida. Digite um valor válido e maior que zero.");
					System.out.print("Memória: ");
					memoria = sc.nextLine();
				}
				System.out.print("Sistema: ");
				String sistema = sc.nextLine();

				while (sistema.contains("-") || Double.parseDouble(sistema) <= 0) {
					System.out.println("Sistema inválido. Digite um valor válido e maior que zero.");
					System.out.print("Sistema: ");
					sistema = sc.nextLine();
				}
			} else if (nome.equalsIgnoreCase("Televisão") || nome.equalsIgnoreCase("Televisao")
					|| nome.equalsIgnoreCase("Tv")) {
				System.out.print("Polegadas: ");
				Integer polegadas = sc.nextInt();
				sc.nextLine();
				System.out.print("Tipo de monitor: ");
				String monitor = sc.nextLine();
				novoProduto = new Televisao(nome, Double.parseDouble(precoFormatado), quantidade, marca, codigo,
						polegadas, monitor);
			} else {
				novoProduto = new Eletronico(nome, Double.parseDouble(precoFormatado), quantidade, marca, codigo);
			}

			produtos.add(novoProduto);

			System.out.println("Produto cadastrado com sucesso!\n");
		} catch (Exception e) {
			System.out.println("Ocorreu um erro ao cadastrar o produto.");
		}
	}

	@SuppressWarnings("unused")
	private static Double validarDouble(Scanner sc) {
		while (true) {
			try {
				return sc.nextDouble();
			} catch (InputMismatchException e) {
				System.out.println("Valor inválido. Digite um número válido.");
				sc.next(); // Descarta a entrada inválida
			}
		}

	}

	private static boolean existeProdutoComCodigo(ArrayList<Eletronico> produtos, Integer codigo) {
		for (Eletronico produto : produtos) {
			if (produto.getCodigo().equals(codigo)) {
				return true;
			}
		}
		return false;

	}

}