
public class Contato {

	private int telefone;
	private String nome;
	
	public Contato() {
		
	}
	
	public Contato(int telefone, String nome) {
		this.telefone = telefone;
		this.nome = nome;
	}
	
	public int getTelefone() {
		return telefone;
	}
	public void setTelefone(int telefone) {
		this.telefone = telefone;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}	
}
