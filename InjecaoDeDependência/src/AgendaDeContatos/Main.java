package AgendaDeContatos;

import java.time.LocalDate;


public class Main {
    public static void main(String[] args) {
    	
    	  Agenda agendaCSV = new AgendaCSV();
    	  Agenda agendaJSON = new AgendaJSON();
    	  Agenda agendaMySQL = new AgendaMySQL();
    	  Agenda agendaXML = new AgendaXML();

        Contato contato = new Contato("João", LocalDate.of(1990, 1, 15), "123456789", "joao@example.com\n");
        Contato contato2 = new Contato("Mateus", LocalDate.of(2003, 8, 28), "47988452010", "mateusmotorama03@gmail.com");
        Contato contato3 = new Contato("Filipe", LocalDate.of(2003, 8, 28), "47999286569", "filipefranciscof3@gmail.com");
      
      // agendaXML.criarXML(contato);
       // agendaXML.criarXML(contato2);
        
        
      /*  
        agendaJSON.adicionarContato(contato);
        agendaJSON.adicionarContato(contato2);
        agendaJSON.adicionarContato(contato3);
        
        agendaJSON.gravarContatos();
        
        agendaJSON.mostrarLista();
        agendaJSON.removerContato(contato3);
        agendaJSON.mostrarLista();
        
        contato.setNome("carla");
        
        agendaJSON.alterarContato(contato);
        agendaJSON.mostrarLista();
        */
        
        //agendaJSON.gravarJSON();
    /*    
        AgendaMySQL agendamsql = new AgendaMySQL();
        
       agendamsql.adicionarContato(contato);
        agendamsql.adicionarContato(contato2);
       agendamsql.adicionarContato(contato3);
        
        agendamsql.gravarContatos();
        
        agendamsql.mostrarLista();;
        contato3.setNome("felipe");
        contato3.setTelefone("3434343");
        
        agendamsql.alterarContato(contato3);
        
        agendamsql.removerContato(contato3);
        */
        AgendaCSV agendacsv = new AgendaCSV();
        
        agendacsv.adicionarContato(contato);    
        agendacsv.adicionarContato(contato2);
        
        agendacsv.gravarContatos();

    }
}
