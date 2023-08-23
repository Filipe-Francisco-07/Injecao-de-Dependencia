package AgendaDeContatos;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AgendaCSV implements Agenda {

	private List<Contato>lista_contato;
	
	public AgendaCSV() {
		lista_contato = new ArrayList<>();
	}
	
	public List<Contato> getLista_contato() {
		return lista_contato;
	}
	public void adicionarContato(Contato contato) {
		this.lista_contato.add(contato);
	}
	
	public String formatarParaCSV(Contato contato) {

	return contato.getNome() + "," + contato.getDatanascimento().toString() + "," + contato.getTelefone() + "," + contato.getEmail();
	}
	public void gravarContatos() {
	 try {
         FileWriter fileWriter = new FileWriter("agenda.csv");
         BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

         for (Contato contato : lista_contato) {
             bufferedWriter.write(formatarParaCSV(contato));

             bufferedWriter.newLine();
         }

         bufferedWriter.close();
         System.out.println("Contatos salvos no arquivo agenda.csv");
     } catch (IOException e) {
    	 System.out.println("Erro ao tentar salver em CSV.");
         e.printStackTrace();
     }
	 }
	public void mostrarLista() {
		System.out.println("Lista CSV: ");
		 try {
		        FileReader fileReader = new FileReader("agenda.csv");
		        BufferedReader bufferedReader = new BufferedReader(fileReader);
		        String linha;

		        while ((linha = bufferedReader.readLine()) != null) {
		            System.out.println(linha);
		        }
		        
		        bufferedReader.close();
		    } catch (IOException e) {
		    System.out.println("Erro ao mostrar lista csv.");
		        e.printStackTrace();
		    }
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
}
