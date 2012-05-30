package Logica;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import easyaccept.EasyAcceptException;

public class Controlador implements Serializable {
	private FachadaLogica fachadaLogica = new FachadaLogica();
	private RepositorioDeUsuarios repositorioDeUsuarios;
	private boolean sistemaAberto = false;
	protected static int idSessao = 0;
	protected static int idSugestao = 0;
	protected static int idSolicitacao = 0;
	protected static int idRespostaSugestao = 0;

	public Controlador() {
		repositorioDeUsuarios = RepositorioDeUsuarios.getInstance();
	}

	public void criarUsuario(String login, String senha, String nome,
			String endereco, String email) throws Exception {
		Usuario usuario = fachadaLogica.criarUsuario(login, senha, nome,
				endereco, email);
		repositorioDeUsuarios.addUsuario(login, usuario);
	}

	public String cadastrarCarona(String idSessao, String localOrigem,
			String localDestino, String data, String horaDaSaida,
			String vagasDisponiveis) throws Exception {

		String idCarona = fachadaLogica.cadastrarCarona(idSessao, localOrigem,
				localDestino, data, horaDaSaida, vagasDisponiveis);

		isSessaoExistente(idSessao);

		return idCarona;

	}

	private void isSessaoExistente(String idSessao) throws Exception {
		boolean idExiste = false;
		for (Usuario usuario : repositorioDeUsuarios.getRepositorioUsuario()
				.values()) {
			if (usuario.getUltimoIdSessao().equals(idSessao)) {
				idExiste = true;
				break;
			}
		}

		if (!idExiste) {
			throw new Exception("Sessão inexistente");
		}

	}

	public void zerarSistema() {
		fachadaLogica.zerarSistema();
		repositorioDeUsuarios.zerarSistema();
	}

	public int abrirSessao(String login, String senha) throws Exception {
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
		idSessao++;
		for (Usuario usuario : repositorioDeUsuarios.getRepositorioUsuario()
				.values()) {
			if (usuario.getLogin().equals(login)) {
				usuario.setUltimoIdSessao(Integer.toString(idSessao));
			}
		}
		return idSessao;
	}

	private void validaSenha(String login, String senha) throws Exception {
		boolean valida = false;
		if (repositorioDeUsuarios.getRepositorioUsuario().containsKey(login)) {
			for (Usuario usuario : repositorioDeUsuarios
					.getRepositorioUsuario().values()) {
				if (usuario.getSenha().equals(senha)) {
					valida = true;
					break;
				}
			}
		}

		if (!valida) {
			throw new Exception("Login inválido");
		}

	}

	public void encerrarSessao(String login) {
		sistemaAberto = false;
	}

	public String getAtributoUsuario(String login, String atributo)
			throws Exception {
		// return fachadaLogica.getAtributoUsuario(login, atributo);
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

		for (Usuario usuario : repositorioDeUsuarios.getRepositorioUsuario()
				.values()) {
			if (usuario.getLogin().equals(login)) {
				if (atributo.equals("nome")) {
					resposta = usuario.getNome();
				} else {
					resposta = usuario.getEndereco();
				}
			}
		}
		return resposta;
	}

	private boolean idCaronaCadastrado(String idCarona) throws Exception {
		boolean resposta = false;
		for (Usuario usuario : repositorioDeUsuarios.getRepositorioUsuario()
				.values()) {
			for (Carona carona : usuario.getCaronas()) {
				if (carona.getIdCarona().equals(idCarona)) {
					resposta = true;
				}
			}
		}
		return resposta;
	}

	public String getAtributoCarona(String idCarona, String atributo)
			throws Exception {
		// return fachadaLogica.getAtributoCarona(idCarona, atributo);
		if (idCarona == null || idCarona.equals("")) {
			throw new EasyAcceptException("Identificador do carona é inválido");
		}
		try {
			if (!idCaronaCadastrado(idCarona)) {
				throw new EasyAcceptException("Item inexistente");
			}
		} catch (Exception e) {
			throw new EasyAcceptException("Item inexistente");
		}

		if (atributo == null || atributo.equals("")) {
			throw new EasyAcceptException("Atributo inválido");
		}

		if (!atributo.equals("origem") && !atributo.equals("destino")
				&& !atributo.equals("data") && !atributo.equals("vagas")) {
			throw new EasyAcceptException("Atributo inexistente");
		}

		String resposta = "";
		for (Usuario usuario : repositorioDeUsuarios.getRepositorioUsuario()
				.values()) {
			for (Carona carona : usuario.getCaronas()) {
				if (carona.getIdCarona().equals(idCarona)) {
					if (atributo.equals("origem")) {
						resposta = carona.getLocalOrigem();
					} else if (atributo.equals("destino")) {
						resposta = carona.getLocalDestino();
					} else if (atributo.equals("data")) {
						resposta = carona.getData();
					} else if (atributo.equals("vagas")) {
						resposta = carona.getVagasDisponiveis();
					}
				}
			}
		}
		return resposta;
	}

	public String localizarCarona(String idSessao, String origem, String destino)
			throws Exception {
		// return fachadaLogica.localizarCarona(idSessao, origem, destino);

		if (!destino.matches("^[ a-zA-Z ã á â é ê i í ó õ ô ú]*$")) {
			throw new EasyAcceptException("Destino inválido");
		}
		if (!origem.matches("^[ a-zA-Z ã á â é ê i í ó õ ô ú]*$")) {
			throw new EasyAcceptException("Origem inválida");
		}

		String texto = "{";
		Date data = new Date();
		DateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");
		formatador.format(data);

		for (Usuario usuario : repositorioDeUsuarios.getRepositorioUsuario()
				.values()) {
			if (usuario.getUltimoIdSessao().equals(idSessao)) {
				for (Carona carona : usuario.getCaronas()) {
					Date minhaData = formatador.parse(carona.getData()
							.toString());
					if (origem.equals("")) {
						if (destino.equals("")) {
							if (minhaData.after(data)) {
								texto += carona.getIdCarona() + ",";
							}
						} else {
							if (carona.getLocalDestino().equals(destino)) {
								texto += carona.getIdCarona() + ",";
							}
						}
					} else {
						if (destino.equals("")) {
							if (carona.getLocalOrigem().equals(origem)) {
								texto += carona.getIdCarona() + ",";
							}
						} else {
							if (carona.getLocalOrigem().equals(origem)
									&& carona.getLocalDestino().equals(destino)) {
								texto += carona.getIdCarona() + ",";
							}
						}
					}
				}
			}
		}

		if (!texto.equals("{")) {
			texto = texto.substring(0, texto.length() - 1);
		}
		texto += "}";
		return texto;

	}

	public int getLinhasArquivo() throws Exception {
		return fachadaLogica.getLinhasArquivo();
	}

	public String getTrajeto(String idCarona) throws Exception {
		// return fachadaLogica.getTrajeto(idCarona);
		if (idCarona == null) {
			throw new EasyAcceptException("Trajeto Inválido");
		}

		try {
			if (!idCaronaCadastrado(idCarona)) {
				throw new EasyAcceptException("Trajeto Inexistente");
			}
		} catch (Exception e) {
			throw new EasyAcceptException("Trajeto Inexistente");
		}

		String resposta = "";
		for (Usuario usuario : repositorioDeUsuarios.getRepositorioUsuario()
				.values()) {
			for (Carona carona : usuario.getCaronas()) {
				if (carona.getIdCarona().equals(idCarona)) {
					resposta = carona.getLocalOrigem() + " - "
							+ carona.getLocalDestino();
				}
			}
		}
		return resposta;
	}

	public String getCarona(String idCarona) throws Exception {
		// return fachadaLogica.getCarona(idCarona);
		if (idCarona == null) {
			throw new EasyAcceptException("Carona Inválida");
		}
		try {
			if (!idCaronaCadastrado(idCarona)) {
				throw new EasyAcceptException("Carona Inexistente");
			}
		} catch (Exception e) {
			throw new EasyAcceptException("Carona Inexistente");
		}

		String resposta = "";
		for (Usuario usuario : repositorioDeUsuarios.getRepositorioUsuario()
				.values()) {
			for (Carona carona : usuario.getCaronas()) {

				if (carona.getIdCarona().equals(idCarona)) {
					resposta = carona.getLocalOrigem() + " para "
							+ carona.getLocalDestino() + ", no dia "
							+ carona.getData() + ", as "
							+ carona.getHoraDaSaida();
				}
			}
		}

		return resposta;
	}

	public boolean encerrarSistema() {
		if (sistemaAberto) {
			sistemaAberto = false;
			return true;
		}
		return false;
	}

	public String sugerirPontoEncontro(String idSessao, String idCarona,
			String pontos) throws Exception {
		if (pontos.equals("")) {
			throw new EasyAcceptException("Ponto Inválido");
		}

		if (pontos.equals(null)) {
			throw new EasyAcceptException("Ponto Inválido");
		}

		if (pontoJaExistente(idSessao, idCarona, pontos)) {
			throw new EasyAcceptException("Ponto Inválido");
		}

		idSugestao++;
		for (Usuario usuario : repositorioDeUsuarios.getRepositorioUsuario()
				.values()) {
			for (Carona carona : usuario.getCaronas()) {
				if (carona.getIdCarona().equals(idCarona)) {
					carona.getSugestoesPontoEncontro().put(idSugestao, pontos);
				}
			}
		}
		return Integer.toString(idSugestao);
	}

	private boolean pontoJaExistente(String idSessao, String idCarona,
			String pontos) {
		boolean resposta = false;
		for (Usuario usuario : repositorioDeUsuarios.getRepositorioUsuario()
				.values()) {
			for (Carona carona : usuario.getCaronas()) {
				if (usuario.getUltimoIdSessao().equals(idSessao)
						&& carona.getIdCarona().equals(
								Integer.parseInt(idCarona))
						&& carona.getSugestoesPontoEncontro().containsValue(
								pontos)) {
					resposta = true;
				}
			}
		}
		return resposta;
	}

	public void responderSugestaoPontoEncontro(String idSessao,
			String idCarona, String idSugestao, String pontos) throws Exception {

		if (pontos.equals("")) {
			throw new EasyAcceptException("Ponto Inválido");
		}
		if (pontos.equals(null)) {
			throw new EasyAcceptException("Ponto Inválido");
		}
		if (pontoJaExistente(idSessao, idCarona, pontos)) {
			throw new EasyAcceptException("Ponto Inválido");
		}

		idRespostaSugestao++;
		for (Usuario usuario : repositorioDeUsuarios.getRepositorioUsuario()
				.values()) {
			for (Carona carona : usuario.getCaronas()) {
				if (carona.getIdCarona().equals(idCarona)
						&& carona.getSugestoesPontoEncontro().containsKey(
								Integer.parseInt(idSugestao))
						&& carona.getSugestoesPontoEncontro()
								.get(Integer.parseInt(idSugestao)).split(";")[0]
								.equals(pontos.split(";")[0])) {
					// add numa lista as aceitas e remover do mapa
					// sugestoesPontoEncontro.
					carona.getRespostasSugestoesPontoEncontro().add(pontos);
					carona.getSugestoesPontoEncontro().remove(Integer.parseInt(idSugestao));
				}

			}
		}
	}

	public String solicitarVagaPontoEncontro(String idSessao, String idCarona,
			String ponto) {
		String nome = "";
		idSolicitacao++;

		for (Usuario usuario : repositorioDeUsuarios.getRepositorioUsuario()
				.values()) {
			if (usuario.getUltimoIdSessao().equals(idSessao)) {
				nome = usuario.getNome();
			}
			for (Carona carona : usuario.getCaronas()) {
				if (carona.getIdCarona().equals(idCarona)) {
					for (int i = 0; i < carona
							.getRespostasSugestoesPontoEncontro().size(); i++) {
						if (carona.getRespostasSugestoesPontoEncontro().get(i).split(";")[0].equals(ponto)) {
							carona.setPonto(ponto);
							carona.getDonosSolicitacoesVagaPontoEncontro().put(idSolicitacao, nome);
							carona.getSolicitacaoVagaPontoEncontro().put(idSolicitacao, carona);
							carona.getHistoricoSolicitacao().put(idSolicitacao, carona);
						}
					}
				}
			}
		}
		return Integer.toString(idSolicitacao);
	}

	public void aceitarSolicitacaoPontoEncontro(String idSessao,
			String idSolicitacao) throws Exception {
		if (idSolicitacao == null || idSolicitacao == "") {
			throw new EasyAcceptException("ID inválido");
		}
		if (idSolicitacaoInexistente(idSolicitacao)) {
			throw new EasyAcceptException("Solicitação inexistente");
		}

		for (Usuario usuario : repositorioDeUsuarios.getRepositorioUsuario()
				.values()) {
			for (Carona carona : usuario.getCaronas()) {
				if (carona.getSolicitacaoVagaPontoEncontro().containsKey(
						Integer.parseInt(idSolicitacao))) {
					int novaQntVagas = Integer.parseInt(carona.getVagasDisponiveis()) - 1;
					carona.setVagasDisponiveis(Integer.toString(novaQntVagas));
					carona.getSolicitacoesPontoEncontroAceitas().put(Integer.parseInt(idSolicitacao),carona);
					carona.getSolicitacaoVagaPontoEncontro().remove(Integer.parseInt(idSolicitacao));
				}
			}
		}
	}

	public String getAtributoSolicitacao(String idSolicitacao, String atributo)
			throws Exception {
		String resposta = "";
		for (Usuario usuario : repositorioDeUsuarios.getRepositorioUsuario()
				.values()) {
			for (Carona carona : usuario.getCaronas()) {
				if (carona.getHistoricoSolicitacao().containsKey(Integer.parseInt(idSolicitacao))) {
					if (atributo.equals("origem")) {
						resposta = carona.getLocalOrigem();
					} else if (atributo.equals("destino")) {
						resposta = carona.getLocalDestino();
					} else if (atributo.equals("Dono da carona")) {
						resposta = usuario.getNome();
					} else if (atributo.equals("Dono da solicitacao")) {
						resposta = carona.getDonosSolicitacoesVagaPontoEncontro().get(Integer.parseInt(idSolicitacao));
					} else if (atributo.equals("Ponto de Encontro")) {
						//System.out.println(carona.getHistoricoSolicitacao().get(Integer.parseInt(idSolicitacao)).getPonto());
						//System.out.println();
						resposta = carona.getHistoricoSolicitacao().get(Integer.parseInt(idSolicitacao)).getPonto();
					}
				}
			}
		}
		return resposta;
	}

	public boolean idSolicitacaoInexistente(String idSolicitacao) {
		boolean resposta = true;
		for (Usuario usuario : repositorioDeUsuarios.getRepositorioUsuario()
				.values()) {
			for (Carona carona : usuario.getCaronas()) {
				if (carona.getSolicitacaoVagaPontoEncontro().containsKey(
						Integer.parseInt(idSolicitacao))) {
					resposta = false;
				}
			}
		}
		return resposta;
	}

	public void desistirRequisicao(String idSessao, String idCarona,
			String idSugestao) {
		for (Usuario usuario : repositorioDeUsuarios.getRepositorioUsuario()
				.values()) {
			for (Carona carona : usuario.getCaronas()) {
				if (usuario.getUltimoIdSessao().equals(idSessao)
						&& carona.getIdCarona().equals(
								Integer.parseInt(idCarona))
						&& carona.getSugestoesPontoEncontro().containsKey(
								Integer.parseInt(idSugestao))) {
					carona.getSugestoesPontoEncontro().remove(idSugestao);
				}
			}
		}
	}

	public String solicitarVaga(String idSessao, String idCarona)
			throws Exception {
		idSolicitacao++;
		for (Usuario usuario : repositorioDeUsuarios.getRepositorioUsuario()
				.values()) {
			for (Carona carona : usuario.getCaronas()) {
				if (carona.getIdCarona().equals(idCarona)) {
					int novaQntVagas = Integer.parseInt(carona.getVagasDisponiveis()) - 1;
					carona.setVagasDisponiveis(Integer.toString(novaQntVagas));
					carona.getSolicitacaoVagaPontoEncontro().put(idSolicitacao, carona);
				}
			}

		}
		return Integer.toString(idSolicitacao);
	}
	
	public void rejeitarRequisicao(String idSessao, String idSolicitacao){
		for (Usuario usuario : repositorioDeUsuarios.getRepositorioUsuario()
				.values()) {
			for (Carona carona : usuario.getCaronas()) {
				if (carona.getSolicitacaoVagaPontoEncontro().containsKey(Integer.parseInt(idSolicitacao))) {
					carona.getSugestoesPontoEncontro().remove(Integer.parseInt(idSolicitacao));
				}
			}
		}
	}

}