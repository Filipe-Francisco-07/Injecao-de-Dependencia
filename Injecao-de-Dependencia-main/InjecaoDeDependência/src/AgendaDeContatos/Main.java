package AgendaDeContatos;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Contato contato = new Contato("João", LocalDate.of(1990, 1, 15), "123456789", "joao@example.com\n");
        Contato contato2 = new Contato("Mateus", LocalDate.of(2003, 8, 28), "47988452010", "mateusmotorama03@gmail.com");
        AgendaXML agendaXML = new AgendaXML(contato);
        agendaXML.criarXML(contato);
        agendaXML.criarXML(contato2);
    }
}
