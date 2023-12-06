package poo;

public class ContatoProfissional extends Contato{

	private String empresa;
	private String cargo;
	
	public ContatoProfissional(String nome, String numero, String email, String empresa, String cargo) {
		super(nome, numero, email);
		setEmpresa(empresa);
		setCargo(cargo);
	}
	
	public TipoContato getTipo() {
		return TipoContato.PROFISSIONAL;
	}
	
	public String toString() {
	    String contatoString = super.toString();
	    return contatoString + "\nEmpresa: " + empresa + "\nCargo: " + cargo;
	}

	public String getEmpresa() {
		return empresa;
	}
	
	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}
	
	public String getCargo() {
		return cargo;
	}
	
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	

}
