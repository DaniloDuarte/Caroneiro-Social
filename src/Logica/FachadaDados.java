package Logica;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;

public class FachadaDados implements Serializable{
	GerenciaDadosTxt gerenciaDados = new GerenciaDadosTxt();

	public String getAtributoUsuario(String login, String atributo) throws Exception {
		return gerenciaDados.getAtributoUsuario(login, atributo);
	}

	public void cadastraConta(Usuario pessoa) throws FileNotFoundException, IOException {
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

	public String localizarCarona(String idSessao, String origem, String destino) throws Exception {
		return gerenciaDados.localizarCarona(idSessao, origem, destino);
	}

	public void cadastrarCarona(Usuario usuario, Carona carona) {
		gerenciaDados.cadastrarCarona(usuario, carona);
	}

	public int getLinhasArquivo() throws Exception {
		return gerenciaDados.getLinhasArquivo();
	}

	public String getAtributoCarona(String idCarona, String atributo) throws Exception {
		return gerenciaDados.getAtributoCarona(idCarona, atributo);
	}

	public String getTrajeto(String idCarona) throws Exception {
		return gerenciaDados.getTrajeto(idCarona);
	}

	public String getCarona(String idCarona) throws Exception {
		return gerenciaDados.getCarona(idCarona);
	}

	public void idSessaoCadastrado(String idSessao) throws Exception {
		gerenciaDados.idSessaoCadastrado(idSessao);
	}
}