package Logica;

import java.util.Collection;
import java.util.Date;
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
		return fachadaDados.getAtributoUsuario(login, atributo);
	}
	
	public String getAtributoCarona(String idSessao, String atributo) throws Exception {
		return fachadaDados.getAtributoCarona(idSessao, atributo);
	}
	
	public boolean isLoginCadastrado(String login) throws Exception {
		return fachadaDados.isLoginCadastrado(login);
	}

	public boolean isSenhaValida(String login, String senha) throws Exception {
		return fachadaDados.isSenhaValida(login, senha);
	}

	public String localizarCarona(String idCarona, String origem, String destino) {
		return fachadaDados.localizarCarona(idCarona, origem, destino);
	}

	public void cadastrarCarona(String localOrigem,
			String localDestino, String data, String horaDaSaida, String vagasDisponiveis) throws Exception {
		pessoa.cadastrarCarona(localOrigem, localDestino, data, horaDaSaida, vagasDisponiveis);
	}

	
}
