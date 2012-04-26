package Logica;

import java.sql.Time;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Set;

public class FachadaLogica {
	private Usuario pessoa;
	private FachadaDados fachadaDados = new FachadaDados();
	private Perfil perfil = new Perfil();
	
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
	
	public String getAtributoCarona(int idCarona, String atributo) throws Exception {
		return fachadaDados.getAtributoCarona(idCarona, atributo);
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

	public int cadastrarCarona(int idSessao,String localOrigem, String localDestino, String data, String horaDaSaida, int vagasDisponiveis) throws Exception {
		return pessoa.cadastrarCarona(idSessao,localOrigem, localDestino, data, horaDaSaida, vagasDisponiveis);
	}

	public int getLinhasArquivo() throws Exception {
		return fachadaDados.getLinhasArquivo();
	}

	public String getTrajeto(int idCarona) throws Exception {
		return fachadaDados.getTrajeto(idCarona);
	}

	public int abrirSessao(String login, String senha) throws Exception {
		return perfil.abrirSessao(login, senha);
	}

	
}
