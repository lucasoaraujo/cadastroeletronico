package aplicacao;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

import entidade.BuscarEletronicos;
import entidade.CadastrarEletronico;
import entidade.ExcluirEletronico;
import entidade.Lavadora;
import entidade.ListarEletronicos;
import entidade.ModificarEletronico;
import entidade.Notebook;
import entidade.Eletronico;
import entidade.Televisao;

public class Principal {

    private static ArrayList<Eletronico> produtos = new ArrayList<>();

    public static void main(String[] args) {

        produtos.add(new Lavadora("Lavadora", 1999.99, 10, "Brastemp", 15634, "12kg"));
        produtos.add(new Notebook("Notebook", 2999.99, 17, "Lenovo", 84596, "4GB", "Windows 10"));
        produtos.add(new Televisao("Televisão", 2499.99, 5, "LG", 98356, 55, "LED"));
        produtos.add(new Lavadora("Lavadora", 1599.99, 25, "Consul", 14659, "9kg"));
        produtos.add(new Televisao("Televisão", 3599.99, 1, "Philips", 92019, 49, "FULL HD"));
        produtos.add(new Notebook("Notebook", 2399.99, 1, "Dell", 43928, "8GB", "Linux"));
        produtos.add(new Notebook("Notebook", 3299.99, 19, "Samsung", 79018, "16GB", "Windows 11"));

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.println("Equipe: Douglas Eloi, Guilherme Aragão, João Torres, Lucas Araújo Verônica Castro.");
        System.out.println();
        Integer opcao = 0;
        /*a variavel cadastrarNovoProduto é do tipo boolean e é utilizada para controlar o loop do menu principal. 
        o loop só será interrompido se o usuário escolher a opção 6 no menu principal.*/
        boolean cadastrarNovoProduto = false;
        do {
            System.out.println("                                                                 EletroWorld LTDA                                 ");
            System.out.println();
            System.out.println("SELECIONE A OPÇÃO DESEJADA");
            System.out.println();
            System.out.println("1 - Cadastrar produto");
            System.out.println("2 - Listar cadastrados");
            System.out.println("3 - Buscar produtos");
            System.out.println("4 - Remover produto");
            System.out.println("5 - Editar produto");
            System.out.println("6 - Sair");
            System.out.println();

            /*O try-catch é utilizado para capturar e tratar possíveis erros durante a execução do programa.
            O bloco try envolve o trecho de código onde a opção escolhida pelo usuário é convertida de uma string para um número 
            inteiro (opcao = Integer.parseInt(opcaoStr)).
            O bloco catch captura as exceções NumberFormatException e InputMismatchException, que podem ocorrer quando o usuário 
            digita uma opção inválida que não pode ser convertida para um número inteiro.*/
            System.out.print("Opção: ");
            String opcaoStr = sc.nextLine().trim();
            try {
                opcao = Integer.parseInt(opcaoStr);
                switch (opcao) {
                    case 1:
                        CadastrarEletronico.cadastrar(produtos, sc);
                        cadastrarNovoProduto = true;
                        break;
                    case 2:
                        System.out.println("Deseja listar os produtos ordenados pelo código? (S/N): ");
                        String resposta1 = sc.nextLine().toUpperCase();
                        Boolean ordenarPorCodigo = resposta1.equals("S");
                        ListarEletronicos.listar(produtos, ordenarPorCodigo);
                        break;
                    case 3:
                        BuscarEletronicos.buscar(produtos, sc);
                        break;
                    case 4:
                        ExcluirEletronico.excluir(produtos, sc);
                        break;
                    case 5:
                        ModificarEletronico.modificar(produtos, sc);
                        break;
                    case 6:
                        System.out.println("Obrigado, a EletroWorld agradece, volte sempre!");
                        break;
                    default:
                        System.out.println();
                        System.out.println("Opção inválida, escolha novamente!");
                        break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Opção inválida! Por favor, digite um número correspondente à opção desejada.");
            } catch (InputMismatchException e) {
                System.out.println("Opção inválida! Por favor, digite um número correspondente à opção desejada.");
                sc.nextLine(); // Limpa o buffer do scanner
            }
            System.out.println();
        } while (opcao != 6 || cadastrarNovoProduto);

        sc.close();
    }
}
