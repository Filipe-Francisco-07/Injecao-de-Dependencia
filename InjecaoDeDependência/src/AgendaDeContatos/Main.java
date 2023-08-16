package AgendaDeContatos;

import java.time.LocalDate;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		LocalDate nasc_robert = LocalDate.of(2003, 12, 31);
		Contato roberto = new Contato("roberto",nasc_robert,19,"robertin@ff.com");
		
		System.out.println(nasc_robert.getMonth());
		
		Agenda agenda = new Agenda();
		agenda.adicionarContato(roberto);		
		
		agenda.verLista();		
		
	}

}
