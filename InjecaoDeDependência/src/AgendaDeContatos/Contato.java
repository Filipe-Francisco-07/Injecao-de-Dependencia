package AgendaDeContatos;

import java.time.LocalDate;

public class Contato {
	private String nome;
	private LocalDate datanascimento;
	private int telefone;
	private String email;
	
	public Contato(String nome, LocalDate data, int telefone, String email) {
		this.nome = nome;
		this.datanascimento = data;
		this.telefone = telefone;
		this.email = email;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public LocalDate getDatanascimento() {
		return datanascimento;
	}

	public void setDatanascimento(LocalDate datanascimento) {
		this.datanascimento = datanascimento;
	}

	public int getTelefone() {
		return telefone;
	}

	public void setTelefone(int telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
}


