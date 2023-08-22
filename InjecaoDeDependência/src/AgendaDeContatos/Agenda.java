package AgendaDeContatos;

import java.util.List;

public interface Agenda {
    List<Contato> getLista_contato();
    void adicionarContato(Contato contato);
    void mostrarLista();
    void gravarContatos();
    void removerContato(Contato contato);
    void alterarContato(Contato contato);
}
