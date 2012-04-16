package Logica;

import java.util.Collection;
import java.util.List;
import java.util.Set;

public class FachadaDados {
	GerenciaDados gerenciaDados = new GerenciaDados();

	public String getAtributoUsuario(String login, String atributo) throws Exception {
		return gerenciaDados.getAtributoUsuario(login, atributo);
	}

	public void cadastraConta(Usuario pessoa) {
		gerenciaDados.cadastraConta(pessoa);
	}

	public boolean isEmailCadastrado(String email) throws Exception {
		return gerenciaDados.isEmailCadastrado(email);
	}

	public void zerarSistema() {
		gerenciaDados.zerarSistema();
		
	}

	public boolean isLoginCadastrado(String login) throws Exception {
		return gerenciaDados.isLoginCadastrado(login);
	}

	public boolean isSenhaValida(String login, String senha) throws Exception {
		return gerenciaDados.isSenhaValida(login, senha);
	}

	public List<Integer> localizarCarona(String idSessao, String origem, String destino) {
		return gerenciaDados.localizarCarona(idSessao, origem, destino);
	}
}
