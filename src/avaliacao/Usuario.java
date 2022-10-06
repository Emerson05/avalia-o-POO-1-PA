package avaliacao;

public class Usuario {
	private String email;
	String senha;
	
	
	public Usuario(String email, String senha) {
		this.senha = senha;
		this.email = email;
	}
	

	public String getEmail() {
		return email;
	}

	public String getSenha() {
		return senha;
	}
	
	public void setEmail( String email) {
		this.email = email;
	}
	
	
	
	
}
