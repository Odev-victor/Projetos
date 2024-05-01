import java.util.Scanner;

public class GerenciamentoEstoque {
    String[] itens = new String[100]; // Capacidade para 100 itens
    int[] quantidades = new int[100];
    int contadorItens = 0;
    Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        GerenciamentoEstoque gerenciamentoEstoque = new GerenciamentoEstoque();
        gerenciamentoEstoque.executar();
    }

    public void executar() {
        boolean executando = true;

        while (executando) {
            System.out.println("\n### Gerenciamento de Estoque ###");
            System.out.println("1. Inserir Item");
            System.out.println("2. Remover Item");
            System.out.println("3. Editar Quantidade");
            System.out.println("4. Visualizar Estoque");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");

            int opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer do scanner

            switch (opcao) {
                case 1:
                    inserirItem();
                    break;
                case 2:
                    removerItem();
                    break;
                case 3:
                    editarQuantidade();
                    break;
                case 4:
                    visualizarEstoque();
                    break;
                case 5:
                    executando = false;
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        }
    }

    public void inserirItem() {
        if (contadorItens >= itens.length) {
            System.out.println("Limite de itens atingido!");
            return;
        }

        System.out.print("Nome do item: ");
        String nome = scanner.nextLine();
        System.out.print("Quantidade: ");
        int quantidade = scanner.nextInt();

        itens[contadorItens] = nome;
        quantidades[contadorItens] = quantidade;
        contadorItens++;

        System.out.println("Item inserido com sucesso!");
    }

    public void removerItem() {
        System.out.print("Nome do item a ser removido: ");
        String nome = scanner.nextLine();
        boolean encontrado = false;

        for (int i = 0; i < contadorItens; i++) {
            if (itens[i].equalsIgnoreCase(nome)) {
                for (int j = i; j < contadorItens - 1; j++) {
                    itens[j] = itens[j + 1];
                    quantidades[j] = quantidades[j + 1];
                }
                contadorItens--;
                encontrado = true;
                break;
            }
        }

        if (encontrado) {
            System.out.println("Item removido com sucesso!");
        } else {
            System.out.println("Item não encontrado no estoque!");
        }
    }

    public void editarQuantidade() {
        System.out.print("Nome do item a ser editado: ");
        String nome = scanner.nextLine();

        for (int i = 0; i < contadorItens; i++) {
            if (itens[i].equalsIgnoreCase(nome)) {
                System.out.print("Nova quantidade: ");
                int novaQuantidade = scanner.nextInt();
                quantidades[i] = novaQuantidade;
                System.out.println("Quantidade editada com sucesso!");
                return;
            }
        }

        System.out.println("Item não encontrado no estoque!");
    }

    public void visualizarEstoque() {
        System.out.println("\n### Estoque Atual ###");
        for (int i = 0; i < contadorItens; i++) {
            System.out.println(itens[i] + ": " + quantidades[i]);
        }
    }
}

