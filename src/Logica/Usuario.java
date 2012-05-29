package Logica;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


import easyaccept.EasyAcceptException;

public class Usuario implements Serializable{

	private String login;
	private String senha;
	private String nome;
	private String email;
	private String endereco;
	private List<Carona> caronas;
	private FachadaDados fachadaDados;
	private Carona carona;
	private String UltimoIdSessao = "";
	
	private ArrayList<String> usuarios = new ArrayList<String>();
	
	public Usuario(){
		
	}
	public Usuario(String login, String senha, String nome, String endereco, String email) throws Exception {
		fachadaDados = new FachadaDados();
	/*	if (fachadaDados.isEmailCadastrado(email)) {
			throw new EasyAcceptException("Já existe um usuário com este email");
		}

		 if (fachadaDados.isLoginCadastrado(login)){
			 throw new Exception("Já existe um usuário com este login");
		 }
		 validaDadosUsuario(login, email);*/
		caronas = new ArrayList<Carona>(); 
		
		setLogin(login);
		setSenha(senha);
		setNome(nome);
		setEndereco(endereco);
		setEmail(email);
	}

	public String cadastrarCarona(String idSessao,String localOrigem, String localDestino, String data, String horaDaSaida, String vagasDisponiveis) throws Exception{
		carona = new Carona(idSessao,localOrigem, localDestino, data, horaDaSaida, vagasDisponiveis);
		//fachadaDados.cadastrarCarona(this, carona);
		caronas.add(carona);
		
		return carona.getIdCarona();
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
		if (senha == null || senha.equals("")){
			throw new EasyAcceptException("Senha inválida");
		}
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

	public List<Carona> getCaronas() {
		return caronas;
	}
	
	public ArrayList<String> getUsuarios(){
		return usuarios;
	}
	
	public String getUltimoIdSessao() {
		return UltimoIdSessao;
	}
	
	protected void setUltimoIdSessao(String ultimoIdSessao) {
		UltimoIdSessao = ultimoIdSessao;
	}

}