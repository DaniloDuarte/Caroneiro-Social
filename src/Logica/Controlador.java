package Logica;

import java.util.Collection;
import java.util.List;
import java.util.Set;

import easyaccept.EasyAcceptException;
import easyaccept.Facade;

public class Controlador {
	private FachadaLogica fachadaLogica = new FachadaLogica();
	private boolean sistemaAberto = false;
	
	public void criarUsuario(String login, String senha, String nome, String endereco, String email) throws Exception{
		fachadaLogica.criarUsuario(login, senha, nome, endereco, email);
		
	}
	
	public void criarUsuario(String login, String nome, String endereco, String email) throws Exception{
		fachadaLogica.criarUsuario(login, nome, endereco, email);
		
	}
	
	public void zerarSistema(){
		fachadaLogica.zerarSistema();
	}
	
	public void abrirSessao(String login, String senha) throws Exception{
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
	}
	
	public String getAtributoUsuario(String login, String atributo) throws Exception{
		return fachadaLogica.getAtributoUsuario(login, atributo);
	}
	
	public void encerrarSistema(){
		sistemaAberto = false;
	}
	
	public List<Integer> localizarCarona(String idSessao, String origem, String destino){
		return fachadaLogica.localizarCarona(idSessao, origem, destino);
	}
}
