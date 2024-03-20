package javabanco;

import java.util.Scanner;

class Cliente {
	private String nome;
	private String sobrenome;
	private String cpf;
	private double saldo;

	public Cliente(String nome, String sobrenome, String cpf) {
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.cpf = cpf;
		this.saldo = 0.0;
	}

	public void consultarSaldo() {
		System.out.println("\nSeu saldo é de R$ " + saldo);
	}

	public void depositar(double valor) {
		if (valor > 0) {
			saldo += valor;
			System.out.println("\nDepósito de R$ " + valor + " realizado com sucesso.");
		} else {
			System.out.println("\nValor de depósito inválido.");
		}
	}
	public void sacar (double valor) {
		if(valor <= saldo) {
			saldo -= valor;
			System.out.println("\nSaque de R$ "+ valor + " realizado com sucesso.");
		}else {
			System.out.println("\nSaldo insuficiente para saque.");
		}
	}
}



public class Banco {
	public static void main(String[] args) {
		Scanner scanner = new Scanner (System.in);
		
		System.out.println("Informe seu nome: ");
		String nome = scanner.nextLine();
		System.out.println("Informe seu sobrenome: ");
		String sobrenome = scanner.nextLine();
		System.out.println("Informe seu CPF: ");
		String cpf = scanner.nextLine();
		
		Cliente cliente = new Cliente (nome, sobrenome, cpf);
		
		System.out.println("\nOlá, "+ nome + " "+ sobrenome + " CPF:  " + cpf +  ". Seja bem vindo!");
		
		boolean continuar = true;
		while (continuar) {
			System.out.println("\n Selecione a opção desejada: ");
			System.out.println("1 - Consultar saldo");
			System.out.println("2 - Fazer depósito");
			System.out.println("3 - Realizar saque");
			System.out.println("4 - Fechar banco ");
			
			int escolha = scanner.nextInt();
			switch (escolha) {
			case 1:
				cliente.consultarSaldo();
				break;
			case 2 : 
				System.out.println("Informe o valor que será depositado: ");
				double valorDeposito = scanner.nextDouble();
				cliente.depositar(valorDeposito);
				break;
			case 3:
				System.out.println("Informe o valor de saque: ");
				double valorSaque = scanner.nextDouble();
				cliente.sacar(valorSaque);
				break;
			case 4:
				continuar = false;
				System.out.println("Encerrando aplicação.");
				break;
			default:
				System.out.println("Opção inválida, tente novamente!");
				break;
				
			}
		}
		scanner.close();
	}

}
