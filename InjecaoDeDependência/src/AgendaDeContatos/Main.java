package AgendaDeContatos;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
 
        Contato contato = new Contato("João", LocalDate.of(1990, 1, 15), "123456789", "joao@example.com\n");
        Contato contato2 = new Contato("Mateus", LocalDate.of(2003, 8, 28), "47988452010", "mateusmotorama03@gmail.com");
        
        /*
        AgendaXML agendaXML = new AgendaXML();
        agendaXML.criarXML(contato);
        agendaXML.criarXML(contato2);
        */
        
        AgendaJSON agendaJSON = new AgendaJSON();
        
        agendaJSON.adicionarContato(contato);
        agendaJSON.adicionarContato(contato2);
        
        //agendaJSON.gravarJSON();
        
        //AgendaMySQL agendamsql = new AgendaMySQL();
        
        //agendamsql.adicionarContato(contato);
        //agendamsql.adicionarContato(contato2);
        
        //agendamsql.gravarMySQL();
        
        AgendaCSV agendacsv = new AgendaCSV();
        
        agendacsv.adicionarContato(contato);    
        agendacsv.adicionarContato(contato2);
        
        agendacsv.gravarCSV();
        
    }
}
