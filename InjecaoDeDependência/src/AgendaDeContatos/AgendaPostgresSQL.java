package AgendaDeContatos;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class AgendaPostgresSQL implements Agenda{
    private List<Contato> lista_contato;

    public AgendaPostgresSQL() {
        lista_contato = new ArrayList<>();
    }

    public List<Contato> getLista_contato() {
        return lista_contato;
    }

    public void adicionarContato(Contato contato) {
        this.lista_contato.add(contato);
    }

    public void gravarContatos() {
        for (Contato contato : lista_contato) {
            if (contato != null)
                inserirContato(contato);
        }
    }

    public boolean inserirContato(Contato contato) {
        try {
        	
            Connection conn = ConexaoPostgreSQL.conectar();
            String sql = "INSERT INTO contatos (nome, data_nascimento, telefone, email) VALUES (?,?,?,?);";
            PreparedStatement ps = conn.prepareStatement(sql);
            Date dataNascimento = Date.valueOf(contato.getDatanascimento());
            ps.setString(1, contato.getNome());
            ps.setDate(2, dataNascimento);
            ps.setString(3, contato.getTelefone());
            ps.setString(4, contato.getEmail());
            ps.executeUpdate();
            ps.close();
            conn.close();
            return true;
        } catch (Exception e) {
            System.out.println("Erro ao inserir: " + e.getMessage());
            return false;
        }
    }

    public void mostrarLista() {
        try {
            Connection conn = ConexaoPostgreSQL.conectar();
            String sql = "SELECT * FROM contatos;";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            List<Contato> listObj = montarLista(rs);
            mostraLista(listObj);
        } catch (Exception e) {
            System.err.println("Erro: " + e.toString());
            return;
        }
    }

    private void mostraLista(List<Contato> lista) {
        for (Contato contato : lista) {
            System.out.println(contato.getNome() + " " + contato.getDatanascimento() + " " + contato.getTelefone() + " " + contato.getEmail());
        }
    }

    public void alterarContato(Contato contato) {
        try {
            Connection conn = ConexaoPostgreSQL.conectar();
            String sql = "UPDATE contatos SET nome = ?, data_nascimento = ?, telefone = ? WHERE email = ?;";
            PreparedStatement ps = conn.prepareStatement(sql);
            Date dataNascimento = Date.valueOf(contato.getDatanascimento());
            ps.setString(1, contato.getNome());
            ps.setDate(2, dataNascimento);
            ps.setString(3, contato.getTelefone());
            ps.setString(4, contato.getEmail());
            ps.executeUpdate();
            ps.close();
            conn.close();
            System.out.println("Contato de email " + contato.getEmail() + " foi alterado.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void removerContato(Contato contato) {
        try {
            Connection conn = ConexaoPostgreSQL.conectar();
            String sql = "DELETE FROM contatos WHERE nome = ?;";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, contato.getNome());
            ps.executeUpdate();
            ps.close();
            conn.close();
            System.out.println("Contato de email " + contato.getEmail() + " foi excluído.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private List<Contato> montarLista(ResultSet rs) {
        List<Contato> listObj = new ArrayList<Contato>();
        try {
            while (rs.next()) {
                Contato obj = new Contato();
                obj.setNome(rs.getString("nome"));
                obj.setDatanascimento(rs.getDate("data_nascimento").toLocalDate());
                obj.setTelefone(rs.getString("telefone"));
                obj.setEmail(rs.getString("email"));
                listObj.add(obj);
            }
            return listObj;
        } catch (Exception e) {
            System.err.println("Erro: " + e.toString());
            return null;
        }
    }
}
