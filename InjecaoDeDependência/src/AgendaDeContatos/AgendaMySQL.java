package AgendaDeContatos;

import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;




public class AgendaMySQL extends Agenda {
	
	private List<Contato>lista_contato;
	
	public AgendaMySQL() {
		lista_contato = new ArrayList<>();
	}
	
	public List<Contato> getLista_contato() {
		return lista_contato;
	}
	public void adicionarContato(Contato contato) {
		this.lista_contato.add(contato);
	}


	public void gravarMySQL() {
		
		for(Contato contato : lista_contato) {
			if(contato != null)
			inserirContato(contato);
		}
	}
		
    
    public boolean inserirContato(Contato contato) {
		try {
			Connection conn = ConexaoMySQL.conectar();
		    String sql = "INSERT INTO " + "Contatos" + " (nome, data_nascimento, telefone, email) VALUES (?,?,?,?);";
		    PreparedStatement ps = conn.prepareStatement(sql);
		    ps.setString(1, contato.getNome());
		    ps.setString(2, contato.getDatanascimento().toString());
		    ps.setString(3, contato.getTelefone());
		    ps.setString(4,contato.getEmail());
		    ps.executeUpdate();
		    ps.close();
		    conn.close();
		    return true;
	    } catch (Exception e) {
	        e.printStackTrace();
	        return false;
	    }
	}
	
}
