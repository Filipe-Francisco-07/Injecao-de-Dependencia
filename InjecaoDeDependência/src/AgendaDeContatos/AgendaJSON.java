package AgendaDeContatos;

import java.io.BufferedReader;
import java.io.FileReader;
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
	
	public void gravarContatos() {	
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
        	System.out.println("Erro ao gravar em json.");
            e.printStackTrace();
        }
	}

	public void mostrarLista() {
		System.out.println("Lista JSON: ");
	    try {
	        FileReader fileReader = new FileReader("contatos.json");
	        BufferedReader bufferedReader = new BufferedReader(fileReader);
	        String linha;

	        while ((linha = bufferedReader.readLine()) != null) {
	            System.out.println(linha);
	        }
	        
	        bufferedReader.close();
	    } catch (IOException e) {
	    System.out.println("Erro ao mostrar lista json.");
	        e.printStackTrace();
	    }
	}

	public void alterarContato(Contato contato) {
	    for (Contato c : lista_contato) {
	        if (c.getNome() == contato.getNome()) {
	            c.setDatanascimento(contato.getDatanascimento());
	            c.setTelefone(contato.getTelefone());
	            c.setEmail(contato.getEmail());
	            System.out.println("Contato do email "+contato.getEmail()+" alterado.");
	            break;
	        }
	    }
	    gravarContatos();
	}

	public void removerContato(Contato contato) {
	  for(Contato cont : lista_contato) {
		  	if(cont.getEmail() == contato.getEmail()) {
		  		lista_contato.remove(contato);  
		  		System.out.println("Contato do email "+contato.getEmail()+" removido.");
		  		break;
		  	}
	  }
	  gravarContatos();
	}
	

	



}
