package AgendaDeContatos;

import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;




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
		    Date dataNascimento = Date.valueOf(contato.getDatanascimento());
		    ps.setString(1, contato.getNome());
		    ps.setDate(2, dataNascimento);
		    ps.setString(3, contato.getTelefone());
		    ps.setString(4,contato.getEmail());
		    ps.executeUpdate();
		    ps.close();
		    conn.close();
		    return true;
	    } catch (Exception e) {
	    	System.out.println("erro ao inserir");
	   
	        return false;
	    }
	}
    
    public void pesquisarTodos() {
        try {
            Connection conn = ConexaoMySQL.conectar();
            String sql = "SELECT * FROM agenda.contatos;";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            List<Contato> listObj = montarLista(rs);
            mostrarLista(listObj);
        } catch (Exception e) {
            //System.err.println("Erro: " + e.toString());
            //e.printStackTrace();
            return;
        }	  
    }
    
    private void  mostrarLista(List<Contato> lista) {
    	for(Contato contato : lista) {
    		System.out.println(contato.getNome()+" "+contato.getDatanascimento()+" "+contato.getTelefone()+" "+contato.getEmail());
    	}
    }
    
    public boolean alterar(Contato contato) {
        try {
            Connection conn = ConexaoMySQL.conectar();
            String sql = "UPDATE " + "contatos" + " SET nome = ?,data_nascimento = ?,telefone = ? WHERE email = ?;";
            PreparedStatement ps = conn.prepareStatement(sql);
            Date dataNascimento = Date.valueOf(contato.getDatanascimento());
            ps.setString(1, contato.getNome());
		    ps.setDate(2, dataNascimento);
		    ps.setString(3, contato.getTelefone());
		    ps.setString(4,contato.getEmail());
            ps.executeUpdate();
            ps.close();
            conn.close();
            System.out.println("Contato de email "+contato.getEmail()+" foi alterado.");
            return true;
        } catch (Exception e) {
        	 e.printStackTrace();
             return false;
        }
    }
   public boolean excluir(Contato contato) {
        try {
            Connection conn = ConexaoMySQL.conectar();
            String sql = "DELETE FROM " + "contatos"+ " WHERE nome = ?;";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, contato.getNome());
            ps.executeUpdate();
            ps.close();
            conn.close();
            System.out.println("Contato de email "+contato.getEmail()+" foi excluido.");
            return true;
        } catch (Exception e) {
        	 e.printStackTrace();
             return false;
        }
    }
   
   private List<Contato> montarLista(ResultSet rs) {
       List<Contato> listObj = new ArrayList<Contato>();
       try {
           while (rs.next()) {
        	   Contato obj = new Contato();
               obj.setNome(rs.getString(2));
               obj.setDatanascimento(rs.getDate(3).toLocalDate());
               obj.setTelefone(rs.getString(4));
               obj.setEmail(rs.getString(5));
               listObj.add(obj);
           }
           return listObj;
       } catch (Exception e) {
           System.err.println("Erro: " + e.toString());
           //e.printStackTrace();
           return null;
       }
   }
	
}
