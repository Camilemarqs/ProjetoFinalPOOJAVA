package poo;

public class ContatoPessoal extends Contato{
	private String aniversario;
	private String notas;
	
	public ContatoPessoal(String nome, String numero, String email, String aniversario,String notas) {
		super(nome, numero, email);
		setAniversario(aniversario);
		setNotas(notas);
	}
	
	public TipoContato getTipo() {
		return TipoContato.PESSOAL;
	}
	
	public String toString() {
		String imprimir = super.toString();
		return imprimir + "\nAniversario: " + aniversario + "\nNotas: " + notas;
	}
	
	public String visualizarNotas() {
		return notas;
	}
	
	public String getAniversario() {
		return aniversario;
	}
	
	public void setAniversario(String aniversario) {
		this.aniversario = aniversario;
	}
	
	public String getNotas() {
		return notas;
	}
	
	public void setNotas(String notas) {
		this.notas = notas;
	}

}
