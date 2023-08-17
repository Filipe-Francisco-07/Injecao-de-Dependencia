package AgendaDeContatos;

import java.util.ArrayList;
import java.util.List;

public class Agenda {
	private List<Contato> lista_contato;

	public Agenda() {
		this.lista_contato = new ArrayList<>();
	}
	public List<Contato> getLista_contato() {
		return lista_contato;
	}
	public void adicionarContato(Contato contato) {
		lista_contato.add(contato);
	}
	
	public void verLista() {
		for(Contato contato: lista_contato) {
			System.out.println(contato.getNome());
		}
	}
	
	
	
}
