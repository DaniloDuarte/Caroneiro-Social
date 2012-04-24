package Logica;

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
	
	public void cadastrarCarona(String localOrigem, String localDestino, String data, String horaDaSaida, String vagasDisponiveis) throws Exception{
		fachadaLogica.cadastrarCarona(localOrigem, localDestino, data, horaDaSaida, vagasDisponiveis);
		
	}
	
	public void zerarSistema(){
		fachadaLogica.zerarSistema();
	}
	
	public String abrirSessao(String login, String senha) throws Exception{
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
		String idSessao = "sessao" + login.substring(0, 1).toUpperCase() + login.substring(1, login.length());
		return idSessao;
	}
	
	public String getAtributoUsuario(String login, String atributo) throws Exception{
		return fachadaLogica.getAtributoUsuario(login, atributo);
	}
	
	public String getAtributoCarona(String idCarona, String atributo) throws Exception{
		return fachadaLogica.getAtributoCarona(idCarona, atributo);
	}
	
	public void encerrarSistema(){
		sistemaAberto = false;
	}
	
	public String localizarCarona(String idCarona, String origem, String destino){
		return fachadaLogica.localizarCarona(idCarona, origem, destino);
	}
	
	
	
	
	
	
	
}
