package avaliacao;
import java.sql.*;

import java.util.*;

public class Teste {

	static ArrayList<Produto> rep = new ArrayList<Produto>();
	static ArrayList<Usuario> repU = new ArrayList<Usuario>();
	static Connection conn;
	
	public static void main(String[] args) {
		int opcao = 0;
		Scanner s = new Scanner(System.in);
		
			String email,senha;
			
			
			System.out.println("\nBem vindo ao Controle de Estoque \n ");
			System.out.println("Faça seu cadastro\n ");
			System.out.println("Digite Seu email:");
			email = s.nextLine();
			System.out.println("Digite Sua Senha:");
			senha = s.nextLine();
		
			
			Usuario u = new Usuario(email,senha);
			if (repU.add(u))
				System.out.println("Conta Cadastrada com sucesso.\n");
			else
				System.out.println(
						"A conta não pôde ser inserida, o repositório pode estar cheio ou essa conta já existe no sistema");
			
			
			
			System.out.println("\nFaça seu login\n ");
			fazerLogin(email,senha);
			
			
			 
			String senhaCriptografada = Criptografia.encrypt(senha);
		
			System.out.println("Senha Criptografada: " + senhaCriptografada);
			
			
			
			
		
			
			

		while (opcao != 9) {
			System.out.println("\nControle de Estoque\n");
			System.out.println("Digite a sua opção:");
			System.out.println("1 - Cadastrar Produto");
			System.out.println("2 - Consultar Produto");
			System.out.println("3 - Alterar Produto");
			System.out.println("4 - Remover Produto");
			System.out.println("5 - Exibe todos os Produto");
			
			

			System.out.println("9 - Sair do sistema");
			System.out.print("Sua opção: ");
			opcao = s.nextInt();

			switch (opcao) {
			case 1: 
				inserirProduto();
				break;

			case 2: 
				consultarProduto();
				break;
			case 3: 
				alterarProduto();
				break;
			case 4: 
				removerProduto();
				break;
			case 5: 
				exibirTodosProdutos();
				break;
			}
			try {
				Thread.sleep(1000);
			}

			catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		System.out.println("Fim da Operação");
	}
		
	
	
	

	
	public static void fazerLogin(String email,String senha) {
		Scanner s = new Scanner(System.in);
		System.out.println("Digite o email da conta:");
		email = s.next();
		
		System.out.println("Digite a senha da conta:");
		 senha = s.next();
		 
		
			
		
		for (int i = 0; i < repU.size(); i++) {
			 Usuario u  = repU.get(i);
			if (!u.getEmail().equalsIgnoreCase(email) || !u.getSenha().equalsIgnoreCase(senha) ) {
				while(!u.getEmail().equalsIgnoreCase(email) || !u.getSenha().equals(senha) ) {
					System.out.println("Email ou senha ivalida tente novamente: ");
					System.out.println("Digite o email da conta:");
					email = s.next();
					
					System.out.println("Digite a senha da conta:");
					senha = s.next();
					
				}
				System.out.println("Login Efetuado com sucesso");
			
			}else {
				System.out.println("Login Efetuado com sucesso");
				
			
			}
			
			
			
		}
		
	
	}

	

	public static void consultarProduto() {
		String id;
		Scanner s = new Scanner(System.in);
		System.out.println("Digite o id do Produto:");
		id = s.nextLine();
		boolean encontrado = false;
		for (int i = 0; i < rep.size(); i++) {
			Produto p = rep.get(i);
			if (p.getId().equals(id)) {
				System.out.println("Dados do Produto: ");
				System.out.println("Id do Produto: " + p.getId());
				System.out.println("Nome do Produto: " + p.getNome());
				System.out.println("Quantidade Produto : " + p.getQuantidade());
				encontrado = true;
				break;
			}
			
		}
		if (!encontrado) {
			System.out.println("Produto não localizado");
		}

	}

	public static void inserirProduto() {
		String nome = "", id = "";
		double quantidade;
		Scanner s = new Scanner(System.in);
		System.out.println("Digite o Id do Produto:");
		id = s.nextLine();
		System.out.println("Digite o Nome do Produto:");
		nome = s.nextLine();
		System.out.println("Digite a Quantidade Inicial:");
		 quantidade = s.nextDouble();
		Produto p = new Produto(id, nome, quantidade);
		  try {
			  	conn = Conexao.abrir();
	            Statement stmt = conn.createStatement();
	            String query = "INSERT INTO Produto (id, nome, quantidade) VALUES(" + id + " , '" + nome + "' , " + quantidade + ")";
	            stmt.executeUpdate(query);
	            stmt.close();
	            conn.close();
	            System.out.println(" Produto Inserido.");
	        }
	        catch (Exception e) {
	            e.printStackTrace();
	        }
	    
		if (rep.add(p))
			System.out.println("Produto inserido com sucesso.");
		else
			System.out.println(
					"O produto não pode ser inserido");
		
	}

	public static void alterarProduto() {
		String nome = "", id = "";
		double quantidade;
		Scanner s = new Scanner(System.in);
		System.out.println("Digite o Id do Produto:");
		id = s.nextLine();
		System.out.println("Digite o nome do Produto:");
		nome = s.nextLine();
		System.out.println("Digite a Quantidade:");
		quantidade = s.nextDouble();
		Produto c = new Produto(id, nome, quantidade);
		boolean encontrado = false;
		for (int i = 0; i < rep.size(); i++) {
			Produto p = rep.get(i);
			if (p.getId().equals(id)) {
				rep.remove(i);
				rep.add(c);
				encontrado = true;
				break;
			}
			
		}
		if (!encontrado) {
			System.out.println("Produto não localizado");
		} else
			System.out.println(" Produto alterado.");
	}

	public static void removerProduto() {
		Scanner s = new Scanner(System.in);
		System.out.println("Digite o id do Produto:");
		String id = s.next();
		boolean encontrado = false;

		for (int i = 0; i < rep.size(); i++) {
			Produto p = rep.get(i);
			if (p.getId().equals(id)) {
				rep.remove(i);
				encontrado = true;
				break;
			}
		}
		if (!encontrado) {
			System.out.println("Produto não localizado");
		} else {
			System.out.println("Produto removido.");
		}
	
	}

	public static void exibirTodosProdutos() {

		System.out.println("Produtos armazenados: ");
		for (int i = 0; i < rep.size(); i++) {
			System.out.println("----------------------------------------------");
			Produto c = rep.get(i);
			System.out.println("Id do Produto: " + c.getId());
			System.out.println("Nome do produto: " + c.getNome());
			System.out.println("Quantidade do Produto : " + c.getQuantidade());

		}
		System.out.println("----------------------------------------------");
		System.out.println("total de Produtos Armazenados: " + rep.size());
	}
	

}
