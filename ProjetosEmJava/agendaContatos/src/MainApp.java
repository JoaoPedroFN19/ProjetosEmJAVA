import java.util.List;
import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {
        AgendaContatos agenda = new AgendaContatos();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Adicionar Contato");
            System.out.println("2. Editar Contato");
            System.out.println("3. Excluir Contato");
            System.out.println("4. Buscar Contato");
            System.out.println("5. Listar Contatos");
            System.out.println("6. Sair");
            System.out.print("Escolha uma opção: ");
            int escolha = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer

            switch (escolha) {
                case 1:
                    System.out.print("Nome do contato: ");
                    String nome = scanner.nextLine();
                    System.out.print("Telefone do contato: ");
                    String telefone = scanner.nextLine();
                    agenda.adicionarContato(new Contato(nome, telefone));
                    break;
                case 2:
                    System.out.print("Nome do contato a ser editado: ");
                    nome = scanner.nextLine();
                    System.out.print("Novo telefone: ");
                    telefone = scanner.nextLine();
                    agenda.editarContato(nome, telefone);
                    break;
                case 3:
                    System.out.print("Nome do contato a ser excluído: ");
                    nome = scanner.nextLine();
                    agenda.excluirContato(nome);
                    break;
                case 4:
                    System.out.print("Nome do contato a ser buscado: ");
                    nome = scanner.nextLine();
                    Contato contatoEncontrado = agenda.buscarContato(nome);
                    if (contatoEncontrado != null) {
                        System.out.println("Contato encontrado: " + contatoEncontrado);
                    } else {
                        System.out.println("Contato não encontrado: " + nome);
                    }
                    break;
                case 5:
                    List<Contato> contatos = agenda.listarContatos();
                    if (!contatos.isEmpty()) {
                        System.out.println("Lista de contatos:");
                        for (Contato contato : contatos) {
                            System.out.println(contato);
                        }
                    } else {
                        System.out.println("Agenda de contatos vazia.");
                    }
                    break;
                case 6:
                    System.out.println("Saindo...");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Opção inválida.");
            }
        }
    }
}
