package entidade;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ModificarEletronico {

    public static void modificar(ArrayList<Eletronico> produtos, Scanner sc) {
        System.out.println();

        Integer codigo = null;
        boolean codigoValido = false;
        while (!codigoValido) {
            System.out.print("Digite o código do produto a ser modificado: ");
            try {
                codigo = sc.nextInt();
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

        boolean encontrou = false;
        for (Eletronico produto : produtos) {
            if (produto.getCodigo().equals(codigo)) {
                System.out.println();
                System.out.println("Produto encontrado:");
                System.out.println("Nome: " + produto.getNome());
                System.out.println("Preço: R$" + produto.getPreco());
                System.out.println("Quantidade: " + produto.getQuantidade());
                System.out.println("Marca: " + produto.getMarca());
                System.out.println("Código: " + produto.getCodigo());

                if (produto instanceof Notebook) {
                    Notebook notebook = (Notebook) produto;
                    System.out.println("Memória: " + notebook.getMemoria());
                    System.out.println("Sistema: " + notebook.getSistema());
                } else if (produto instanceof Televisao) {
                    Televisao televisao = (Televisao) produto;
                    System.out.println("Polegadas: " + televisao.getPolegadas());
                    System.out.println("Monitor: " + televisao.getMonitor());
                } else if (produto instanceof Lavadora) {
                    Lavadora lavadora = (Lavadora) produto;
                    System.out.println("Capacidade: " + lavadora.getCapacidade());
                }

                System.out.println();

                int opcao;
                do {
                    System.out.println("Escolha a informação que deseja modificar:");
                    System.out.println("1. Nome");
                    System.out.println("2. Preço");
                    System.out.println("3. Quantidade");
                    System.out.println("4. Marca");

                    if (produto instanceof Notebook) {
                        System.out.println("5. Memória");
                        System.out.println("6. Sistema");
                    } else if (produto instanceof Televisao) {
                        System.out.println("5. Polegadas");
                        System.out.println("6. Monitor");
                    } else if (produto instanceof Lavadora) {
                        System.out.println("5. Capacidade");
                    }

                    System.out.println("7. Cancelar");
                    System.out.print("Opção: ");
                    try {
                        opcao = sc.nextInt();
                        if (opcao < 1 || opcao > 7) {
                            System.out.println("Opção inválida. Tente novamente.");
                        }
                    } catch (InputMismatchException e) {
                        System.out.println("Opção inválida. Tente novamente.");
                        sc.nextLine(); // Limpa o buffer do scanner
                        opcao = -1; // Definir um valor inválido para continuar o loop
                    }

                } while (opcao < 1 || opcao > 7);

                switch (opcao) {
                    case 1:
                        System.out.print("Novo nome: ");
                        sc.nextLine();
                        String novoNome = sc.nextLine();
                        produto.setNome(novoNome);
                        System.out.println("Produto modificado com sucesso!");
                        break;
                    case 2:
                        System.out.print("Novo preço: ");
                        double novoPreco = sc.nextDouble();
                        produto.setPreco(novoPreco);
                        System.out.println("Produto modificado com sucesso!");
                        break;
                    case 3:
                        System.out.print("Nova quantidade: ");
                        int novaQuantidade = sc.nextInt();
                        produto.setQuantidade(novaQuantidade);
                        System.out.println("Produto modificado com sucesso!");
                        break;
                    case 4:
                        System.out.print("Nova marca: ");
                        sc.nextLine();
                        String novaMarca = sc.nextLine();
                        produto.setMarca(novaMarca);
                        System.out.println("Produto modificado com sucesso!");
                        break;
                    case 5:
                        if (produto instanceof Notebook) {
                            Notebook notebook = (Notebook) produto;
                            System.out.print("Nova memória: ");
                            sc.nextLine();
                            String novaMemoria = sc.nextLine();
                            notebook.setMemoria(novaMemoria);

                            System.out.print("Novo sistema: ");
                            String novoSistema = sc.nextLine();
                            notebook.setSistema(novoSistema);

                            System.out.println("Notebook modificado com sucesso!");
                        } else if (produto instanceof Televisao) {
                            Televisao televisao = (Televisao) produto;
                            System.out.print("Nova quantidade de polegadas: ");
                            Integer novasPolegadas = sc.nextInt();
                            televisao.setPolegadas(novasPolegadas);

                            System.out.print("Novo tipo de monitor: ");
                            sc.nextLine();
                            String novoMonitor = sc.nextLine();
                            televisao.setMonitor(novoMonitor);

                            System.out.println("Televisão modificada com sucesso!");
                        } else if (produto instanceof Lavadora) {
                            Lavadora lavadora = (Lavadora) produto;
                            System.out.print("Nova capacidade: ");
                            sc.nextLine();
                            String novaCapacidade = sc.nextLine();
                            lavadora.setCapacidade(novaCapacidade);

                            System.out.println("Lavadora modificada com sucesso!");
                        }
                        break;
                    case 6:
                        if (produto instanceof Notebook) {
                            Notebook notebook = (Notebook) produto;
                            System.out.print("Novo sistema: ");
                            sc.nextLine();
                            String novoSistema = sc.nextLine();
                            notebook.setSistema(novoSistema);

                            System.out.println("Notebook modificado com sucesso!");
                        } else if (produto instanceof Televisao) {
                            Televisao televisao = (Televisao) produto;
                            System.out.print("Novo tipo de monitor: ");
                            sc.nextLine();
                            String novoMonitor = sc.nextLine();
                            televisao.setMonitor(novoMonitor);

                            System.out.println("Televisão modificada com sucesso!");
                        }
                        break;
                    case 7:
                        System.out.println("Operação cancelada.");
                        break;
                }

                encontrou = true;
                break;
            }
        }

        if (!encontrou) {
            System.out.println("Produto não encontrado.");
        }

        System.out.println();
    }
}
