import java.util.ArrayList;
import java.util.List;

public class AgendaContatos {
    private List<Contato> contatos;

    public AgendaContatos() {
        contatos = new ArrayList<>();
    }

    public void adicionarContato(Contato contato) {
        contatos.add(contato);
    }

    public void editarContato(String nome, String novoTelefone) {
        for (Contato contato : contatos) {
            if (contato.getNome().equalsIgnoreCase(nome)) {
                contato.setTelefone(novoTelefone);
                return;
            }
        }
    }

    public void excluirContato(String nome) {
        Contato contatoParaExcluir = null;
        for (Contato contato : contatos) {
            if (contato.getNome().equalsIgnoreCase(nome)) {
                contatoParaExcluir = contato;
                break;
            }
        }

        if (contatoParaExcluir != null) {
            contatos.remove(contatoParaExcluir);
        }
    }

    public Contato buscarContato(String nome) {
        for (Contato contato : contatos) {
            if (contato.getNome().equalsIgnoreCase(nome)) {
                return contato;
            }
        }
        return null;
    }

    public List<Contato> listarContatos() {
        return new ArrayList<>(contatos);
    }
}
