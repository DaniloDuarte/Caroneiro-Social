package Logica;

import Util.IdSessaoSingleton;
import easyaccept.EasyAcceptException;

public class Perfil {
	private FachadaDados fachadaDados = new FachadaDados();
	private boolean sistemaAberto = false;
	private int idSessao = 0;

	public int abrirSessao(String login, String senha) throws Exception {
		if (login == null || login.equals("")) {
			throw new EasyAcceptException("Login inválido");
		}

		if (!fachadaDados.isLoginCadastrado(login)) {
			throw new EasyAcceptException("Usuário inexistente");
		}

		if (!fachadaDados.isSenhaValida(login, senha)) {
			throw new EasyAcceptException("Login inválido");
		}
		sistemaAberto = true;
		// idSessao = "sessao" + login.substring(0, 1).toUpperCase() +
		// login.substring(1, login.length());
		return idSessao++;
		
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

}
