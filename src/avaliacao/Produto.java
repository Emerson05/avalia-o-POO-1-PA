package avaliacao;

class Produto {
	private String nome;
	private int id;
	private double quantidade;

	public Produto(int id, String nome, double quantidade) {
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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getQuantidade() {
		return quantidade;
	}

	
	
	

}
