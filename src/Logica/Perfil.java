package Logica;

import easyaccept.EasyAcceptException;

public class Perfil {
	private FachadaDados fachadaDados = new FachadaDados();
	private boolean sistemaAberto = false;
	private int idSessao = 0;

	public int abrirSessao(String login, String senha) throws Exception {
		if (login == null || login.equals("")){
			throw new EasyAcceptException("Login inválido");
		}
		
		if (!fachadaDados.isLoginCadastrado(login)){
			throw new EasyAcceptException("Usuário inexistente");
		}
		
		if (!fachadaDados.isSenhaValida(login, senha)){
			throw new EasyAcceptException("Login inválido");
		}
		sistemaAberto = true;
		//idSessao = "sessao" + login.substring(0, 1).toUpperCase() + login.substring(1, login.length());
		return idSessao++;
	}
	
	public void encerrarSistema(){
		sistemaAberto = false;
	}

}
