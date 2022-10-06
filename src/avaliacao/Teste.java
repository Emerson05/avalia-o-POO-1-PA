package avaliacao;

import java.util.*;

public class Teste {

	static ArrayList<Conta> rep = new ArrayList<Conta>();
	static ArrayList<Usuario> repU = new ArrayList<Usuario>();

	public static void main(String[] args) {
		int opcao = 0;
		Scanner s = new Scanner(System.in);

		
			System.out.println("\nBem vindo ao sistema Bancario tabajara\n ");
			System.out.println("Faça seu cadastro\n ");
			cadastrarUsuario(email, senha);
			
			
			
			System.out.println("\nFaça seu login\n ");
			fazerLogin(email,senha);
			
			
			Criptografia.encriptografar(senha);
			
		
			
			

		while (opcao != 9) {
			System.out.println("\nSistema Bancário Tabajara\n");
			System.out.println("Digite a sua opção:");
			System.out.println("1 - Cadastrar Conta");
			System.out.println("2 - Consultar Conta");
			System.out.println("3 - Alterar Conta");
			System.out.println("4 - Remover Conta");
			System.out.println("5 - Exibe todas as contas");

			System.out.println("9 - Sair do sistema");
			System.out.print("Sua opção: ");
			opcao = s.nextInt();

			switch (opcao) {
			case 1: 
				inserirConta();
				break;

			case 2: 
				consultarConta();
				break;
			case 3: 
				alterarConta();
				break;
			case 4: 
				removerConta();
				break;
			case 5: 
				exibirTodasAsContas();
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
		
	
	
	static String email;
	static String senha;
	
	public static void cadastrarUsuario(String email,String senha) {
	
		Scanner s = new Scanner(System.in);
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

	

	public static void consultarConta() {
		Scanner s = new Scanner(System.in);
		System.out.println("Digite o número da conta:");
		String numero = s.next();
		boolean encontrado = false;
		for (int i = 0; i < rep.size(); i++) {
			Conta c = rep.get(i);
			if (c.getNumero().equals(numero)) {
				System.out.println("Dados da conta: ");
				System.out.println("Numero da conta: " + c.getNumero());
				System.out.println("Nome do cliente: " + c.getNome());
				System.out.println("Saldo da conta : " + c.getSaldo());
				encontrado = true;
				break;
			}
			
		}
		if (!encontrado) {
			System.out.println("Conta não localizada");
		}

	}

	public static void inserirConta() {
		String numero = "", nome = "";
		Scanner s = new Scanner(System.in);
		System.out.println("Digite o número da conta:");
		numero = s.nextLine();
		System.out.println("Digite o nome do cliente dono da conta:");
		nome = s.nextLine();
		System.out.println("Digite o saldo inicial da conta:");
		double saldo = s.nextDouble();
		Conta c = new Conta(numero, nome, saldo);
		if (rep.add(c))
			System.out.println("conta inserida com sucesso.");
		else
			System.out.println(
					"A conta não pôde ser inserida, o repositório pode estar cheio ou essa conta já existe no sistema");
		
	}

	public static void alterarConta() {
		String numero = "", nome = "";
		Scanner s = new Scanner(System.in);
		System.out.println("Digite o número da conta:");
		numero = s.nextLine();
		System.out.println("Digite o nome do cliente dono da conta:");
		nome = s.nextLine();
		System.out.println("Digite o saldo inicial da conta:");
		double saldo = s.nextDouble();
		Conta c = new Conta(numero, nome, saldo);
		boolean encontrado = false;
		for (int i = 0; i < rep.size(); i++) {
			Conta c2 = rep.get(i);
			if (c2.getNumero().equals(numero)) {
				rep.remove(i);
				rep.add(c);
				encontrado = true;
				break;
			}
			
		}
		if (!encontrado) {
			System.out.println("Conta não localizada");
		} else
			System.out.println(" Conta alterada.");
	}

	public static void removerConta() {
		Scanner s = new Scanner(System.in);
		System.out.println("Digite o número da conta:");
		String numero = s.next();
		boolean encontrado = false;

		for (int i = 0; i < rep.size(); i++) {
			Conta c = rep.get(i);
			if (c.getNumero().equals(numero)) {
				rep.remove(i);
				encontrado = true;
				break;
			}
		}
		if (!encontrado) {
			System.out.println("Conta não localizada");
		} else {
			System.out.println("Conta removida.");
		}
	
	}

	public static void exibirTodasAsContas() {

		System.out.println("Contas armazenadas: ");
		for (int i = 0; i < rep.size(); i++) {
			System.out.println("----------------------------------------------");
			Conta c = rep.get(i);
			System.out.println("Numero da conta: " + c.getNumero());
			System.out.println("Nome do cliente: " + c.getNome());
			System.out.println("Saldo da conta : " + c.getSaldo());

		}
		System.out.println("----------------------------------------------");
		System.out.println("total de contas armazenadas: " + rep.size());
	}
	

}
