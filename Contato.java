package poo;

public abstract class Contato {

	private String nome;
	private String numero;
	private String email;
	
	public Contato(String nome, String numero, String email) {
		setNome(nome);
		setNumero(numero);
		setEmail(email);
	}
	
	public String toString() { //exibe para o usuario as informações de contato 
	    return "Nome: " + nome + "\nNumero: " + numero + "\nEmail: " + email;
	}

	public abstract TipoContato getTipo();
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getNumero() {
		return numero;
	}
	
	public void setNumero(String numero) {
		this.numero = numero;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
}


