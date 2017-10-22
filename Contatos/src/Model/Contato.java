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
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		String n = (this.nome == null || this.nome.isEmpty()) ? "vazio" : this.nome;
		String t = (this.telefone == null || this.telefone.isEmpty()) ? "vazio" : this.telefone;
		sb.append("Nome:\t\t");
		sb.append(n);
		sb.append("\n");
		sb.append("Telefone:\t");
		sb.append(t);
		
		return sb.toString();
	}
}
