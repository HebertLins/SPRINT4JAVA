package program;

import java.util.Scanner;

public class Cadastro {

	Scanner ler = new Scanner(System.in);
	
	private String nome;
	private int numTel;
	private String email;
	private int id;
	private Avatar avatar;
	private Login social;
	private String senha;
	private String cSenha;
	private String cep;
	int opDif;
	int saldoM;

	
	
	


	public int getOpDif() {
		return opDif;
	}

	public void setOpDif(int opDif) {
		this.opDif = opDif;
	}

	public int getSaldoM() {
		return saldoM;
	}

	public void setSaldoM(int saldoM) {
		this.saldoM = saldoM;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getcSenha() {
		return cSenha;
	}

	public void setcSenha(String cSenha) {
		this.cSenha = cSenha;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getNumTel() {
		return numTel;
	}

	public void setNumTel(int numTel) {
		this.numTel = numTel;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Avatar getAvatar() {
		return avatar;
	}

	public void setAvatar(Avatar avatar) {
		this.avatar = avatar;
	}

	public Login getSocial() {
		return social;
	}

	public void setSocial(Login social) {
		this.social = social;
	}

	public Cadastro(){}
	
	Cadastro(String nome, int numTel, String email, int id, Avatar avatar, Login social){
		this.nome = nome;
		this.numTel = numTel;
		this.email = email;
		this.id = id;
		this.avatar = avatar;
		this.social = social;
	};

	public String Cadastrar (){
		System.out.println("MENU - CADASTRO\n"
				+ "Informe os dados abaixo:");
		System.out.println("Nome: ");
		nome = ler.next();
		this.setNome(nome);
		System.out.println("Email: ");
		email = ler.next();
		this.setEmail(email);
		System.out.println("Numero de Telefone: ");
		numTel = ler.nextInt();
		this.setNumTel(numTel);
		System.out.println("CEP: ");
		cep = ler.next();
		this.setCep(cep);
		System.out.println("Senha: ");
		senha = ler.next();
		this.setSenha(senha);
		System.out.println("Confirme sua senha: ");
		cSenha = ler.next();
		this.setcSenha(cSenha);
		
		if(! this.getSenha().equals(this.getcSenha())){
			do {
				System.out.println("As senhas não conferem! Tente outra vez.");
				System.out.println("Senha: ");
				senha = ler.next();
				this.setSenha(senha);
				System.out.println("Confirme sua senha: ");
				cSenha = ler.next();
				this.setcSenha(cSenha);
				
			}while(! this.getSenha().equals(this.getcSenha()));
		}
		
		id = id + 1;
		this.setId(id);
		
		return ("Parabéns! Seu cadastro foi realizado com sucesso.");
	}
	
	
}
