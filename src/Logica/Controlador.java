package Logica;

import java.sql.Time;
import java.util.Date;

import Util.IdCaronaSingleton;

import easyaccept.EasyAcceptException;
import easyaccept.Facade;

public class Controlador {
	private FachadaLogica fachadaLogica = new FachadaLogica();
	private boolean sistemaAberto = false;
	private int idSessao;
	
	public void criarUsuario(String login, String senha, String nome, String endereco, String email) throws Exception{
		fachadaLogica.criarUsuario(login, senha, nome, endereco, email);
		
	}
	
	public void criarUsuario(String login, String nome, String endereco, String email) throws Exception{
		fachadaLogica.criarUsuario(login, nome, endereco, email);
		
	}
	
	public int cadastrarCarona(int idSessao, String localOrigem, String localDestino, String data, String horaDaSaida, int vagasDisponiveis) throws Exception{
		return fachadaLogica.cadastrarCarona(idSessao,localOrigem, localDestino, data, horaDaSaida, vagasDisponiveis);
	}
	
	public void zerarSistema(){
		fachadaLogica.zerarSistema();
	}
	
	public int abrirSessao(String login, String senha) throws Exception{
		//TODO ESCOLHER ONDE ISSO VAI FICAR!
		if (login == null || login.equals("")){
			throw new EasyAcceptException("Login inválido");
		}
		
		if (!fachadaLogica.isLoginCadastrado(login)){
			throw new EasyAcceptException("Usuário inexistente");
		}
		
		if (!fachadaLogica.isSenhaValida(login, senha)){
			throw new EasyAcceptException("Login inválido");
		}
		sistemaAberto = true;
		//idSessao = "sessao" + login.substring(0, 1).toUpperCase() + login.substring(1, login.length());
		return idSessao;
	}
	
	public String getAtributoUsuario(String login, String atributo) throws Exception{
		return fachadaLogica.getAtributoUsuario(login, atributo);
	}
	
	public String getAtributoCarona(int idCarona, String atributo) throws Exception{
		return fachadaLogica.getAtributoCarona(idCarona, atributo);
	}
	
	public void encerrarSistema(){
		sistemaAberto = false;
	}
	
	public String localizarCarona(String idCarona, String origem, String destino){
		return fachadaLogica.localizarCarona(idCarona, origem, destino);
	}
	
	public int getLinhasArquivo() throws Exception {
		return fachadaLogica.getLinhasArquivo();
	}
	
	public String getTrajeto(int idCarona) throws Exception{
		return fachadaLogica.getTrajeto(idCarona);
		
	}
}
