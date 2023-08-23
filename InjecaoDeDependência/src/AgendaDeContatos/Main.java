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
     
       /* 
        agendaXML.adicionarContato(contato);    
        agendaXML.adicionarContato(contato2);
        agendaXML.adicionarContato(contato3);
        
       // agendaXML.gravarContatos();
        
        //agendaXML.mostrarLista();
        
       contato3.setNome("roberto");  
        agendaXML.alterarContato(contato3);
        agendaXML.mostrarLista();
        
        agendaXML.removerContato(contato);
        agendaXML.mostrarLista();
        */
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
       
        
       // agendaJSON.gravarJSON();
*/
       /* 
        agendaCSV.adicionarContato(contato);    
        agendaCSV.adicionarContato(contato2);
        agendaCSV.adicionarContato(contato3);
        
        agendaCSV.gravarContatos();
        
        agendaCSV.mostrarLista();
        
        contato3.setNome("roberto");  
        agendaCSV.alterarContato(contato3);
        agendaCSV.mostrarLista();
        
        agendaCSV.removerContato(contato);
        agendaCSV.mostrarLista();
         */
        agendaMySQL.adicionarContato(contato);
        agendaMySQL.adicionarContato(contato2);
        agendaMySQL.adicionarContato(contato3);
      
        agendaMySQL.gravarContatos();
      
        agendaMySQL.mostrarLista();;
        contato3.setNome("felipe");
        contato3.setTelefone("3434343");
      
        agendaMySQL.alterarContato(contato3);

        agendaMySQL.removerContato(contato);
    }
}
