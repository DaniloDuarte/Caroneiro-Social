package Logica;

import java.io.Serializable;

public class FachadaLogica implements Serializable{
	private Usuario pessoa;
	private FachadaDados fachadaDados = new FachadaDados();
	private Sistema sistema = new Sistema();

	public Usuario criarUsuario(String login, String senha, String nome,
			String endereco, String email) throws Exception {

		pessoa = new Usuario(login, senha, nome, endereco, email);
		return pessoa;
	}

	public void zerarSistema() {
		fachadaDados.zerarSistema();

	}

	public String getAtributoUsuario(String login, String atributo)
			throws Exception {
		return fachadaDados.getAtributoUsuario(login, atributo);
	}

	public String getAtributoCarona(String idCarona, String atributo) throws Exception {
		return fachadaDados.getAtributoCarona(idCarona, atributo);
	}

	public boolean isSenhaValida(String login, String senha) throws Exception {
		return fachadaDados.isSenhaValida(login, senha);
	}

	public String localizarCarona(String idSessao, String origem, String destino) throws Exception {
		return fachadaDados.localizarCarona(idSessao, origem, destino);
	}

	public int cadastrarCarona(String idSessao,String localOrigem, String localDestino, String data, String horaDaSaida, String vagasDisponiveis) throws Exception {
		return pessoa.cadastrarCarona(idSessao,localOrigem, localDestino, data, horaDaSaida, vagasDisponiveis);
	}

	public int getLinhasArquivo() throws Exception {
		return fachadaDados.getLinhasArquivo();
	}

	public String getTrajeto(String idCarona) throws Exception {
		return fachadaDados.getTrajeto(idCarona);
	}

/*	public int abrirSessao(String login, String senha) throws Exception {
		return sistema.abrirSessao(login, senha);
	}*/

	public String getCarona(String idCarona) throws Exception {
		return fachadaDados.getCarona(idCarona);
	}

/*	public void encerrarSessao(String login) {
		sistema.encerrarSessao(login);
	}*/

	public String sugerirPontoEncontro(String idSessao, String idCarona,
			String pontos) {
		return null;
	}

}