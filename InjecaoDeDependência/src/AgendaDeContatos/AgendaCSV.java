package AgendaDeContatos;

import java.io.BufferedWriter;
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
	
	public String formatarCSV(Contato contato) {

	return contato.getNome() + "," + contato.getDatanascimento().toString() + "," + contato.getTelefone() + "," + contato.getEmail();
	}
	public void gravarContatos() {
	 try {
         FileWriter fileWriter = new FileWriter("agenda.csv");
         BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

         for (Contato contato : lista_contato) {
             bufferedWriter.write(formatarCSV(contato));

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
		// TODO Auto-generated method stub
		
	}

	public void removerContato(Contato contato) {
		// TODO Auto-generated method stub
		
	}

	public void alterarContato(Contato contato) {
		// TODO Auto-generated method stub
		
	}
}
