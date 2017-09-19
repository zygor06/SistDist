package Model;

public class Contato {

	private String telefone;
	private String nome;
	
	public Contato() {
		
	}
	
	public Contato(String telefone, String nome) {
		this.telefone = telefone;
		this.nome = nome;
	}
	
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}	
}
