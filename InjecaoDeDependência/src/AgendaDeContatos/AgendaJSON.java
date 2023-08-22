package AgendaDeContatos;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

public class AgendaJSON implements Agenda {
	private List<Contato> lista_contato;

	public AgendaJSON() {
		lista_contato = new ArrayList<>();
	}
	
	public List<Contato> getLista_contato() {
		return lista_contato;
	}
	public void adicionarContato(Contato contato) {
		this.lista_contato.add(contato);
	}
	
	public void gravarJSON() {	
		StringBuilder jsonString = new StringBuilder("[");
	    for (Contato contato : lista_contato) {
	       jsonString.append("{");
	       jsonString.append("\"nome\":\"").append(contato.getNome()).append("\",");
	       jsonString.append("\"data_nascimento\":\"").append(contato.getDatanascimento()).append("\",");
	       jsonString.append("\"telefone\":\"").append(contato.getTelefone()).append("\",");
	       jsonString.append("\"email\":\"").append(contato.getEmail()).append("\"");
	       jsonString.append("},");
	    }
	    jsonString.deleteCharAt(jsonString.length() - 1);
	    jsonString.append("]");

	    try (Writer writer = new FileWriter("contatos.json")) {
            writer.write(jsonString.toString());
            System.out.println("Gravacao concluida em json.");
        } catch (IOException e) {
            e.printStackTrace();
        }
	}

	@Override
	public void mostrarLista() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void gravarContatos() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removerContato(Contato contato) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void alterarContato(Contato contato) {
		// TODO Auto-generated method stub
		
	}	

	
}
