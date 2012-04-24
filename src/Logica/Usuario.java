package Logica;
import java.util.ArrayList;
import java.util.Date;

import easyaccept.EasyAcceptException;

public class Usuario {
	
	private String login;
	private String senha;
	private String nome;
	private String email;
	private String endereco;
	private String telefone;
	private ArrayList<Carona> caronas;
	private FachadaDados fachadaDados;
	private Carona carona;
	private String idCarona;
	private int contador = 1;

	public Usuario(String login, String senha, String nome, String endereco, String email) throws Exception {
		fachadaDados = new FachadaDados();
		if (fachadaDados.isEmailCadastrado(email)) {
			throw new EasyAcceptException("Já existe um usuário com este email");
		}
		
//		 if (gd.isLoginCadastrado(login)){
//			 throw new Exception("Já existe um usuário com este login");
//		 }
		
		setLogin(login);
		setSenha(senha);
		setNome(nome);
		setEndereco(endereco);
		setEmail(email);
		
		fachadaDados.cadastraConta(this);
		this.caronas = new ArrayList<Carona>();
	}
	
	public Usuario(String login, String nome, String endereco, String email) throws Exception {
		fachadaDados = new FachadaDados();
		if (fachadaDados.isEmailCadastrado(email)) {
			throw new EasyAcceptException("Já existe um usuário com este email");
		}
		
//		 if (gd.isLoginCadastrado(login)){
//			 throw new Exception("Já existe um usuário com este login");
//		 }
		
		setLogin(login);
		setNome(nome);
		setEndereco(endereco);
		setEmail(email);
		
		fachadaDados.cadastraConta(this);
		this.caronas = new ArrayList<Carona>();
		caronas.add(carona);
	}

	public String cadastrarCarona(String localOrigem, String localDestino, String data, String horaDaSaida, String vagasDisponiveis) throws Exception{
		carona = new Carona(localOrigem, localDestino, data, horaDaSaida, vagasDisponiveis);
		caronas.add(carona);
		fachadaDados.cadastrarCarona(this, caronas);
		
		return idCarona;
	}
	
	public boolean zerarSistema(){
		caronas.clear();
		return caronas.isEmpty();
	}
	
	public String getLogin() {
		return login;
	}

	public void setLogin(String login) throws EasyAcceptException{
		if (login == null || login.equals("")){
			throw new EasyAcceptException("Login inválido");
		}
		this.login = login;
	}
	
	public String getSenha() {
		return senha;
	}
	
	public void setSenha(String senha) throws EasyAcceptException{
//		if (senha == null || senha.equals("")){
//			throw new EasyAcceptException("senha invalido!");
//		}
		this.senha = senha;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) throws Exception {
		if (nome == null || nome.equals("")){
			throw new Exception("Nome inválido");
		}
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) throws Exception {
		if (email == null || email.equals("")){
			throw new Exception("Email inválido");
		}
		this.email = email;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) throws Exception {
		if (endereco == null || endereco.equals("")){
			throw new Exception("Atributo inválido");
		}
		this.endereco = endereco;
	}

	public ArrayList<Carona> getCaronas() {
		return caronas;
	}

}
