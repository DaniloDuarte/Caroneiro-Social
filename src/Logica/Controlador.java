package Logica;

import java.sql.Time;
import java.util.Date;

import Util.IdCaronaSingleton;

import easyaccept.EasyAcceptException;
import easyaccept.Facade;

public class Controlador {
	private FachadaLogica fachadaLogica = new FachadaLogica();
	
	
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
		return fachadaLogica.abrirSessao(login, senha);
	}
	
	public String getAtributoUsuario(String login, String atributo) throws Exception{
		return fachadaLogica.getAtributoUsuario(login, atributo);
	}
	
	public String getAtributoCarona(int idCarona, String atributo) throws Exception{
		return fachadaLogica.getAtributoCarona(idCarona, atributo);
	}
	
	public String localizarCarona(int idCarona, String origem, String destino) throws Exception{
		return fachadaLogica.localizarCarona(idCarona, origem, destino);
	}
	
	public int getLinhasArquivo() throws Exception {
		return fachadaLogica.getLinhasArquivo();
	}
	
	public String getTrajeto(int idCarona) throws Exception{
		return fachadaLogica.getTrajeto(idCarona);
	}
	
	public String getCarona(int idCarona) throws Exception{
		return fachadaLogica.getCarona(idCarona);
	}
}
