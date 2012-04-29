package Logica;

import Util.IdSessaoSingleton;
import easyaccept.EasyAcceptException;

public class Sistema {
	private FachadaDados fachadaDados = new FachadaDados();
	private boolean sistemaAberto = false;
	private static int idSessao = 0;

	public int abrirSessao(String login, String senha) throws Exception {
		if (login == null || login.equals("")) {
			throw new EasyAcceptException("Login inv�lido");
		}

		if (!fachadaDados.isLoginCadastrado(login)) {
			throw new EasyAcceptException("Usu�rio inexistente");
		}

		if (!fachadaDados.isSenhaValida(login, senha)) {
			throw new EasyAcceptException("Login inv�lido");
		}
		sistemaAberto = true;
		// idSessao = "sessao" + login.substring(0, 1).toUpperCase() +
		// login.substring(1, login.length());
		return ++idSessao;
		
		//TODO RESOLVER O PROBLEMA DO SINGLETON
		//this.idSessao = IdSessaoSingleton.getId();
		//return idSessao;
	}

	public boolean encerrarSistema() {
		if (sistemaAberto) {
			sistemaAberto = false;
			return true;
		}
		return false;
	}

	protected void idSessaoCadastrado(String idSessao) throws Exception {
		fachadaDados.idSessaoCadastrado(idSessao);
	}

	protected static int getIdSessao(){
		return idSessao;
	}
	
	public void encerrarSessao(String login){
		sistemaAberto = false;
	}
}
