package Logica;

import java.util.ArrayList;

public class FachadaDados {
	GerenciaDados gerenciaDados = new GerenciaDados();

	public String getAtributoUsuario(String login, String atributo) throws Exception {
		return gerenciaDados.getAtributoUsuario(login, atributo);
	}
	
	public String getAtributoCarona(String idSessao, String atributo) throws Exception {
		return gerenciaDados.getAtributoCarona(idSessao, atributo);
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

	public String localizarCarona(String idCarona, String origem, String destino) {
		return gerenciaDados.localizarCarona(idCarona, origem, destino);
	}

	public void cadastrarCarona(Usuario usuario, ArrayList<Carona> caronas) {
		gerenciaDados.cadastrarCarona(usuario, caronas);
	}

	public int getLinhasArquivo() throws Exception {
		return gerenciaDados.getLinhasArquivo();
	}
}
