package program;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Scanner;

import model.Endereco;
import dao.JogadorDAO;
import service.ViaCepService;

public class Programa {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub

		Scanner ler = new Scanner(System.in);
		HashMap<Integer, Cadastro> listaCadastro = new HashMap<Integer, Cadastro>();
		
		Fases f = new Fases();
		
		String nome;
		String email;
		String numTel;
		String senha;
		String cSenha;
		int id = 1;
		int op = 0;
		int cl = 0;
		
		do {
			JogadorDAO jd = new JogadorDAO();
			System.out.println(jd.contaLinha());
			System.out.println("=======================");
			System.out.println(" Bem-vindo ao Tec4All!");
			System.out.println("=======================");
			System.out.println("1- Cadastro\n"
					+ "2- Login\n"
					+ "3- Entrar sem Cadastro\n"
					+ "4- Sair\n");
			op = ler.nextInt();
			
			if (op == 1) {
					id = id - 1;
					Cadastro c = new Cadastro();
					c.Cadastrar();
					id = c.getId();
					listaCadastro.put(id, c);
					jd.insert(c);
				
			}else if (op == 2){
				if (id == 1) {
					System.out.println("Tente a opção de cadastro primeiro!");
				}else {
					System.out.println("MENU LOGIN");
					System.out.println("E-mail: ");
					String comparaE = ler.next();
					System.out.println("Senha: ");
					String testeSe = ler.next();
					
					listaCadastro.forEach((chave, valor) -> {
						if (valor.getEmail().equals(comparaE) && valor.getSenha().equals(testeSe)){
							System.out.println("Seu login foi realizado com sucesso!\n");
							System.out.println("\n MENU JOGOS");
							int opli;
							do {
							
								System.out.println("Escolha uma das opções abaixo:\n"
									+ "1 - Fases\n"
									+ "2 - Simulado\n"
									+ "3 - Barra de Progresso\n"
									+ "4 - Consultar CEP");
								opli = ler.nextInt();
								if (opli == 1) {
									f.Fases();
								}else if (opli == 2) {
									f.Simulado();
								}else if (opli == 3) {
									f.BarraProg();
								}else if (opli == 4) {
									ViaCepService viacepservice = new ViaCepService();

									try {
										Endereco endereco = viacepservice.getEndereco(valor.getCep());
									
										System.out.println(endereco.getLogradouro() + "\n");
										System.out.println(endereco.getBairro() + "\n");
										System.out.println(endereco.getLocalidade()  + "\n");
									
									} catch (IOException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}	
									
								}else {
									System.out.println("Valor inválido!");
								}
							}while(opli != 5);
							
						}else {
							System.out.println("Email e/ou senha são inválidos!");
						}
						
					});
				}
				
			}else if (op == 3) {
			
				System.out.println("Seu login foi realizado com sucesso!\n");
				System.out.println("\n MENU JOGOS");
				
				do {
					
					System.out.println("\nEscolha uma das opções abaixo:\n"
							+ "1 - Fases\n"
							+ "2 - Simulado\n"
							+ "3 - Barra de Progresso\n"
							+ "4 - Sair");
					op = ler.nextInt();
					if (op == 1) {
						f.Fases();
					}else if (op == 2) {
						f.Simulado();
					}else if (op == 3) {
						f.BarraProg();
					}else {
						System.out.println("Valor inválido!");
					}
				}while(op != 4);
					
				}else {
					System.out.println("Email e/ou senha são inválidos!");
				}
			
		}while(op != 3);
		
		}
	}



