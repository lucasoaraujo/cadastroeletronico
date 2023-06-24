package entidade;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ListarEletronicos {

    // Método para listar os produtos
    public static void listar(ArrayList<Eletronico> produtos, boolean ordenarPorCodigo) {
        System.out.println();
        System.out.println("========================== LISTA DE PRODUTOS ==========================");
        System.out.printf("%-15s | %-10s | %-10s | %-15s | %-15s%n", "      NOME", "   PREÇO", "QUANTIDADE", "     MARCA", "CÓDIGO");
        System.out.println("-----------------------------------------------------------------------");

        ArrayList<Eletronico> listaExibicao = new ArrayList<>(produtos);

        if (ordenarPorCodigo) {
            Collections.sort(listaExibicao, new Comparator<Eletronico>() {
                public int compare(Eletronico p1, Eletronico p2) {
                    return Integer.compare(p1.getCodigo(), p2.getCodigo());
                }
            });
        }

        // Percorre a lista de produtos e exibe as informações de cada produto
        for (Eletronico produto : listaExibicao) {
            System.out.printf("%-15s | R$ %-7.2f | %-10d | %-15s | %-15d%n", produto.getNome(), produto.getPreco(), produto.getQuantidade(), produto.getMarca(), produto.getCodigo());
        }

        System.out.println();
    }
}
