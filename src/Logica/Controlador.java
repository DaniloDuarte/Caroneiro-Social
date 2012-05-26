package Logica;

import java.io.Serializable;

import easyaccept.EasyAcceptException;


public class Controlador implements Serializable{
	private FachadaLogica fachadaLogica = new FachadaLogica();
	private RepositorioDeUsuarios repositorioDeUsuarios;
	private boolean sistemaAberto = false;
	private static int idSessao = 0;

	public Controlador() {
		repositorioDeUsuarios = RepositorioDeUsuarios.getInstance();
	}

	public void criarUsuario(String login, String senha, String nome, String endereco, String email) throws Exception{
		Usuario usuario = fachadaLogica.criarUsuario(login, senha, nome, endereco, email);
		repositorioDeUsuarios.addUsuario(login, usuario);
	}

	public int cadastrarCarona(String idSessao, String localOrigem, String localDestino, String data, String horaDaSaida, String vagasDisponiveis) throws Exception{
		return fachadaLogica.cadastrarCarona(idSessao,localOrigem, localDestino, data, horaDaSaida, vagasDisponiveis);
	}

	public void zerarSistema(){
		fachadaLogica.zerarSistema();
	}

	public int abrirSessao(String login, String senha) throws Exception{
		if (login == null || login.equals("")) {
			throw new EasyAcceptException("Login inválido");
		}
		
		if (!repositorioDeUsuarios.getRepositorioUsuario().containsKey(login)) {
			throw new EasyAcceptException("Usuário inexistente");
		}

		validaSenha(login, senha);
		
		sistemaAberto = true;
		// idSessao = "sessao" + login.substring(0, 1).toUpperCase() +
		// login.substring(1, login.length());
		return ++idSessao;
	}

	private void validaSenha(String login, String senha) throws Exception {
		boolean valida = false;
		if (repositorioDeUsuarios.getRepositorioUsuario().containsKey(login)){
			for (Usuario usuario : repositorioDeUsuarios.getRepositorioUsuario().values()){
				if (usuario.getSenha().equals(senha)){
					valida = true;
					break;
				}
			}
		}

		if (!valida){
			throw new Exception("Login inválido");
		}
		
	}

	public void encerrarSessao(String login){
		sistemaAberto = false;
	}

	public String getAtributoUsuario(String login, String atributo) throws Exception{
	//	return fachadaLogica.getAtributoUsuario(login, atributo);
		String resposta = "";
		
		if (login == null || login.equals("")) {
			throw new Exception("Login inválido");
		}

		if (atributo == null || atributo.equals("")) {
			throw new Exception("Atributo inválido");
		}

		if (!repositorioDeUsuarios.getRepositorioUsuario().containsKey(login)) {
			throw new Exception("Usuário inexistente");
		}

		if (!atributo.equals("nome") && !atributo.equals("endereco")) {
			throw new Exception("Atributo inexistente");
		}
		
		for (Usuario usuario : repositorioDeUsuarios.getRepositorioUsuario().values()){
			if (usuario.getLogin().equals(login)){
				if (atributo.equals("nome")){
					resposta = usuario.getNome();
				}else{
					resposta = usuario.getEndereco();
				}
			}
		}
		return resposta;
	}

	public String getAtributoCarona(String idCarona, String atributo) throws Exception{
		return fachadaLogica.getAtributoCarona(idCarona, atributo);
	}

	public String localizarCarona(String idSessao, String origem, String destino) throws Exception{
		return fachadaLogica.localizarCarona(idSessao, origem, destino);
	}

	public int getLinhasArquivo() throws Exception {
		return fachadaLogica.getLinhasArquivo();
	}

	public String getTrajeto(String idCarona) throws Exception{
		return fachadaLogica.getTrajeto(idCarona);
	}

	public String getCarona(String idCarona) throws Exception{
		return fachadaLogica.getCarona(idCarona);
	}

	public boolean encerrarSistema(){
		if (sistemaAberto) {
			sistemaAberto = false;
			return true;
		}
		return false;
	}

	public String sugerirPontoEncontro(String idSessao, String idCarona, String pontos){
		return fachadaLogica.sugerirPontoEncontro(idSessao, idCarona, pontos);
	}
}