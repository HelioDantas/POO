package main;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.ArrayList;

public class Main {
	static Main main = new Main();
	static String bus;
	static String rm;
	String lis;
	static PessoaFisica pf = main.new PessoaFisica();
	static PessoaJuridica pj = main.new PessoaJuridica();
	private static Scanner scanner2 = new Scanner(System.in);

	public static void main(String[] args) {

		
		boolean controle = true;
		do {
			try {
				controle = false;
				int opcao = menuOpcoes();
				if (opcao == 0)
					MenuFisica();
				else if (opcao == 1)
					MenuJuridica();
				else
					controle = false;

			} catch (java.util.InputMismatchException e) {
				System.out.println("Aviso de Excecao: Opcao Invalida! Sao permitidos apenas numeros!");
				System.out.println("Por favor, escolha uma opcao valida.");
				controle = false;
				// scanner.next();// limpar o buffer
			}
		} while (!controle);
		// scanner.close();
	}

	public static int menuOpcoes() {
		boolean controle = false;
		int opçao = 0;
		do {
			try {
				System.out.println("Escolha o tipo do cadastro:");
				System.out.println("0 - Pessoa fisica");
				System.out.println("1 - Pessoa juridica");
				System.out.println("3 - Sair");
				controle = true; // deve concluir o loop

				opçao = scanner2.nextInt();
				if (opçao == 0)
					controle = true;
				else if (opçao == 1)
					controle = true;
				else if (opçao == 3)
					controle = true;
				else
					throw new InputMismatchException();
				// ------------------------------------------------------
			} catch (InputMismatchException e) {
				System.out.println("Opcao Invalida! Sao permitidos apenas 0 ou 1!");
				System.out.println("Por favor, escolha uma opcao válida.");
				controle = false;// ainda NAO deve concluir o loop
				scanner2.next();// limpar o buffer
			}
		} while (!controle);
		// scanner.close();
		return opçao;

	}

	public static void MenuFisica() {

		
		boolean controle = false;
		do {

			System.out.println("\t menu");
			System.out.println("0. Fim");
			System.out.println("1. Cadastrar");
			System.out.println("2. Buscar");
			System.out.println("3. Remover");
			System.out.println("4. Listar");
			System.out.println("Opcao:");

			int key = scanner2.nextInt();

			switch (key) {
			case 0:
				controle = true;
				break;
			case 1:

				Scanner c = new Scanner(System.in);
				System.out.println("BEM VINDO AO SISTEMA DE CADASTRO");
				System.out.println("Digite o seu nome: ");
				String nome = c.nextLine();
				System.out.println("Endereço: ");
				String endereco = c.nextLine();
				System.out.println("CPF: ");
				String cpf = c.nextLine();
				pf.setNome(nome);
				pf.setEndereco(endereco);
				pf.setCpf(cpf);
				pf.cadastrar();
				controle = false;
				break;

			case 2:

				System.out.println("Digite o CPF para a busca");
				scanner2.next();
				bus = scanner2.nextLine();
				if (bus != " " && bus != null && bus.length() == 11) {
					PessoaFisica pff = pf.buscar(bus);
					System.out.println(pff.getCpf());
					System.out.println(pff.getNome());
					System.out.println(pff.getEndereco());
					System.out.println("--------------------");
					controle = false;
					break;
				} else if (bus == " " || bus == null || bus.length() < 11) {
					System.out.println("Consulta inválida. Digite um CPF.");
					controle = false;
					break;

				}
			case 3:

				System.out.println("Digite o CPF para remover o cadastro.");
				scanner2.next();
				rm = scanner2.nextLine();
				if (rm != " " && rm != null && rm.length() == 11) {
					pf.remover(rm);
					controle = false;
					break;

				} else if (rm == " " || rm == null || rm.length() < 11) {
					System.out.println("Informação inválida. Digite um CPF.");
					controle = false;
					break;
				}

			case 4:

				pf.listar();
				controle = false;
				break;
			}
		} while (!controle);

	}

	static public void MenuJuridica() {
		Scanner scanner2 = null;
		boolean controle = false;
		do {

			System.out.println("\t menu");
			System.out.println("0. Fim");
			System.out.println("1. Cadastrar");
			System.out.println("2. Buscar");
			System.out.println("3. Remover");
			System.out.println("4. Listar");
			System.out.println("Opcao:");

			int key = scanner2.nextInt();

			Scanner c = null;
			switch (key) {
			case 0:
				controle = true;
				break;
			case 1:

				System.out.println("BEM VINDO AO SISTEMA DE CADASTRO");
				System.out.println("Digite o seu nome: ");
				String nome = c.nextLine();
				System.out.println("Endereço da Empresa: ");
				String endereco = c.nextLine();
				System.out.println("CNPJ: ");
				String cnpj = c.nextLine();
				pj.setNome(nome);
				pj.setEndereco(endereco);
				pj.setCnpj(cnpj);
				pj.cadastrar();
				controle = false;
				break;

			case 2:

				System.out.println("Digite o CNPJ para a busca");
				scanner2.next();
				bus = scanner2.nextLine();
				if (bus != " " && bus != null && bus.length() == 11) {
					PessoaJuridica pjj = pj.buscar(bus);
					System.out.println(pjj.getCnpj());
					System.out.println(pjj.getNome());
					System.out.println(pjj.getEndereco());
					System.out.println("--------------------");
					controle = false;
					break;
				} else if (bus == " " || bus == null || bus.length() < 14) {
					System.out.println("Consulta inválida. Digite um CPF.");
					controle = false;
					break;
				}
			case 3:

				System.out.println("Digite o CNPJ para remover o cadastro.");
				scanner2.next();
				rm = scanner2.nextLine();
				if (rm != " " && rm != null && rm.length() == 14) {
					pj.remover(rm);

				} else if (rm == " " || rm == null || rm.length() < 14) {
					System.out.println("Informação inválida. Digite um CNPJ.");
					controle = false;
					break;

				}

			case 4:

				pj.listar();
				controle = false;
				break;
			}
		} while (!controle);

	}

	interface IPessoa {

		public boolean cadastrar();

		public Pessoa buscar(String id);

		public boolean remover(String id);

		public void listar();

	}

	abstract class Pessoa implements IPessoa {

		private String nome;
		private String endereco;

		public String getNome() {
			return nome;
		}

		public void setNome(String nome) {
			this.nome = nome;
		}

		public String getEndereco() {
			return endereco;
		}

		public void setEndereco(String endereco) {
			this.endereco = endereco;
		}

	}

	class PessoaFisica extends Pessoa {

		protected ArrayList<PessoaFisica> PessoaRepository = new ArrayList<PessoaFisica>();;
		private String cpf;

		public String getCpf() {
			return cpf;
		}

		public void setCpf(String cpf) {
			this.cpf = cpf;
		}

		@Override
		public boolean remover(String cpf) {

			PessoaFisica PF = this.buscar(cpf);
			if (PF == null)
				return false;

			PessoaRepository.remove(PF);
			return true;

		}

		@Override
		public void listar() {

			for (PessoaFisica pessoaFisica : this.PessoaRepository) {
				System.out.println(pessoaFisica.getCpf());
				System.out.println(pessoaFisica.getNome());
				System.out.println(pessoaFisica.getEndereco());

			}

		}

		@Override
		public boolean cadastrar() {
			PessoaFisica pf = new PessoaFisica();
			pf.setCpf(this.getCpf());
			pf.setEndereco(this.getEndereco());
			pf.setNome(this.getNome());

			this.PessoaRepository.add((PessoaFisica) pf);
			return true;
		}

		@Override
		public PessoaFisica buscar(String id) {

			for (PessoaFisica pessoa : PessoaRepository) {

				if (id == pessoa.cpf)
					return pessoa;

			}

			return null;

		}

	}

	class PessoaJuridica extends Pessoa {

		private ArrayList<PessoaJuridica> PessoaRepository = new ArrayList<PessoaJuridica>();
		private String cnpj;

		public String getCnpj() {
			return cnpj;
		}

		public void setCnpj(String cnpj) {
			this.cnpj = cnpj;
		}

		@Override
		public boolean remover(String cnpj) {

			PessoaJuridica PJ = this.buscar(cnpj);
			if (PJ == null)
				return false;

			this.PessoaRepository.remove(PJ);
			return true;

		}

		@Override
		public void listar() {

			for (PessoaJuridica pessoaJuridica : this.PessoaRepository) {
				System.out.println(pessoaJuridica.getCnpj());
				System.out.println(pessoaJuridica.getNome());
				System.out.println(pessoaJuridica.getEndereco());

			}

		}

		@Override
		public boolean cadastrar() {
			PessoaJuridica pj = new PessoaJuridica();
			pj.setCnpj(this.getCnpj());
			pj.setNome(this.getNome());
			pj.setEndereco(this.getEndereco());

			this.PessoaRepository.add(pj);
			return true;
		}

		@Override
		public PessoaJuridica buscar(String id) {

			for (PessoaJuridica pessoa : PessoaRepository) {

				if (id == pessoa.getCnpj())
					return pessoa;

			}

			return null;

		}
	}
}
