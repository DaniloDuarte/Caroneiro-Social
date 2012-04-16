package Logica;

import java.util.Collection;
import java.util.List;
import java.util.Set;

public class FachadaLogica {
	private Usuario pessoa;
	private FachadaDados fachadaDados = new FachadaDados();
	private Carona carona;

	public void criarUsuario(String login, String senha, String nome,
			String endereco, String email) throws Exception {

		pessoa = new Usuario(login, senha, nome, endereco, email);
	}

	public void criarUsuario(String login, String nome, String endereco,
			String email) throws Exception {
		
		pessoa = new Usuario(login, nome, endereco, email);

	}

	public void zerarSistema() {
		fachadaDados.zerarSistema();

	}

	public String getAtributoUsuario(String login, String atributo)
			throws Exception {
		// TODO Auto-generated method stub
		return fachadaDados.getAtributoUsuario(login, atributo);
	}
	
	public boolean isLoginCadastrado(String login) throws Exception {
		return fachadaDados.isLoginCadastrado(login);
	}

	public boolean isSenhaValida(String login, String senha) throws Exception {
		return fachadaDados.isSenhaValida(login, senha);
	}

	public List<Integer> localizarCarona(String idSessao, String origem, String destino) {
		return fachadaDados.localizarCarona(idSessao, origem, destino);
	}
}
