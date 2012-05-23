package Logica;

import java.io.Serializable;

public class Controlador implements Serializable{
	private FachadaLogica fachadaLogica = new FachadaLogica();
	private RepositorioDeUsuarios repositorioDeUsuarios;

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
		return fachadaLogica.abrirSessao(login, senha);
	}

	public void encerrarSessao(String login){
		fachadaLogica.encerrarSessao(login);
	}

	public String getAtributoUsuario(String login, String atributo) throws Exception{
		return fachadaLogica.getAtributoUsuario(login, atributo);
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
		return fachadaLogica.encerrarSistema();
	}

	public String sugerirPontoEncontro(String idSessao, String idCarona, String pontos){
		return fachadaLogica.sugerirPontoEncontro(idSessao, idCarona, pontos);
	}
}