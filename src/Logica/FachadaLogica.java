package Logica;

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

	public String localizarCarona(String idSessao, String origem, String destino) throws Exception {
		return fachadaDados.localizarCarona(idSessao, origem, destino);
	}

	public int cadastrarCarona(String idSessao,String localOrigem, String localDestino, String data, String horaDaSaida, Integer vagasDisponiveis) throws Exception {
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

	public String getCarona(int idCarona) throws Exception {
		return fachadaDados.getCarona(idCarona);
	}

	public boolean encerrarSistema() {
		return perfil.encerrarSistema();
	}

}
