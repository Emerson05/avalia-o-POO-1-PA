package avaliacao;

class Produto {
	private String nome;
	private String id;
	private double quantidade;

	public Produto(String id, String nome, double quantidade) {
		this.nome = nome;
		this.id = id;
		this.quantidade = quantidade;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public double getQuantidade() {
		return quantidade;
	}

	
	
	

}
