package AgendaDeContatos;

import java.time.LocalDate;


public class Main {
    public static void main(String[] args) {
 
        Contato contato = new Contato("João", LocalDate.of(1990, 1, 15), "123456789", "joao@example.com\n");
        Contato contato2 = new Contato("Mateus", LocalDate.of(2003, 8, 28), "47988452010", "mateusmotorama03@gmail.com");
        Contato contato3 = new Contato("Filipe", LocalDate.of(2003, 8, 28), "47999286569", "filipefranciscof3@gmail.com");
        /*
        AgendaXML agendaXML = new AgendaXML();
        agendaXML.criarXML(contato);
        agendaXML.criarXML(contato2);
        */
        
        AgendaJSON agendaJSON = new AgendaJSON();
        
        agendaJSON.adicionarContato(contato);
        agendaJSON.adicionarContato(contato2);
        
        //agendaJSON.gravarJSON();
        
        AgendaMySQL agendamsql = new AgendaMySQL();
        
       // agendamsql.adicionarContato(contato);
        //agendamsql.adicionarContato(contato2);
       // agendamsql.adicionarContato(contato3);
        
        agendamsql.gravarMySQL();
        
        agendamsql.pesquisarTodos();
        contato3.setNome("felipe");
        contato3.setTelefone("3434343");
        
        agendamsql.alterar(contato3);
        
      //  agendamsql.excluir(contato3);
        
        /*
        AgendaCSV agendacsv = new AgendaCSV();
        
        agendacsv.adicionarContato(contato);    
        agendacsv.adicionarContato(contato2);
        
        agendacsv.gravarCSV();
        */
    }
}
