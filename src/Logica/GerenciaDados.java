package Logica;

import java.awt.image.DataBuffer;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import easyaccept.EasyAcceptException;

public class GerenciaDados {

	public void cadastraConta(Usuario pessoa) {
		// Gravando no arquivo
		File arquivo;

		arquivo = new File("contas.txt");
		FileOutputStream fos;
		String texto;
		try {
			fos = new FileOutputStream(arquivo, true);
			texto = pessoa.getLogin() + ";" + pessoa.getSenha() + ";"
					+ pessoa.getNome() + ";" + pessoa.getEndereco() + ";"
					+ pessoa.getEmail() + "\n";
			fos.write(texto.getBytes());
			fos.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void cadastrarCarona(Usuario usuario, Carona carona) {
		File arquivo;
		arquivo = new File("caronas.txt");
		FileOutputStream fos;
		String texto;

		try {
			fos = new FileOutputStream(arquivo, true);
			// BufferedReader arq = new BufferedReader(
			// new FileReader("caronas.txt"));
			// String linha = arq.readLine();
			// if (linha.split(";")[0].trim().equals(usuario.getLogin())){
			// //TODO Se usuario cadastrado fazer algo.
			// }
			texto = usuario.getIdSessao() + ";" + usuario.getLogin() + ";"
					+ carona.getIdCarona() + ";" + carona.getLocalOrigem()
					+ ";" + carona.getLocalDestino() + ";" + carona.getData()
					+ ";" + carona.getHoraDaSaida() + ";"
					+ carona.getVagasDisponiveis() + "\n";
			fos.write(texto.getBytes());

			fos.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public String getAtributoUsuario(String login, String atributo)
			throws Exception {
		if (login == null || login.equals("")) {
			throw new EasyAcceptException("Login inválido");
		}

		if (atributo == null || atributo.equals("")) {
			throw new EasyAcceptException("Atributo inválido");
		}

		if (!this.isLoginCadastrado(login)) {
			throw new EasyAcceptException("Usuário inexistente");
		}

		if (!atributo.equals("nome") && !atributo.equals("endereco")) {
			throw new EasyAcceptException("Atributo inexistente");
		}

		String resposta = "";
		BufferedReader arquivo = new BufferedReader(
				new FileReader("contas.txt"));

		while (arquivo.ready()) {
			// pega a linha
			String linha = arquivo.readLine();
			if (linha.split(";")[0].trim().equals(login)) {
				if (atributo.equals("nome")) {
					resposta = linha.split(";")[2];
				} else {
					resposta = linha.split(";")[3];
				}
				break;
			}
		}
		return resposta;
	}

	public String getAtributoCarona(int idCarona, String atributo)
			throws Exception {
		if (atributo == null || atributo.equals("")) {
			throw new EasyAcceptException("Atributo inválido");
		}
		if (!atributo.equals("origem") && !atributo.equals("destino")
				&& !atributo.equals("data") && !atributo.equals("vagas")) {
			throw new EasyAcceptException("Atributo inexistente");
		}

		String resposta = "";
		BufferedReader arquivo = new BufferedReader(new FileReader(
				"caronas.txt"));
		String linha = "";

		while (arquivo.ready()) {
			// pega a linha
			linha = arquivo.readLine();
			if (Integer.parseInt(linha.split(";")[2]) == idCarona) {
				if (atributo.equals("origem")) {
					resposta = linha.split(";")[3];
				} else if (atributo.equals("destino")) {
					resposta = linha.split(";")[4];
				} else if (atributo.equals("data")) {
					resposta = linha.split(";")[5];
				} else if (atributo.equals("vagas")) {
					resposta = linha.split(";")[7];
				}
				break;
			}
		}
		return resposta;

	}

	public boolean isEmailCadastrado(String email) throws Exception {
		boolean resposta = false;
		BufferedReader arquivo = new BufferedReader(
				new FileReader("contas.txt"));

		while (arquivo.ready()) {
			String linha = arquivo.readLine();
			if (linha.split(";").length == 5) {
				if (linha.split(";")[4].trim().equals(email)) {
					resposta = true;
				}
			} else {
				if (linha.split(";")[3].trim().equals(email)) {
					resposta = true;
				}
			}
		}
		return resposta;
	}

	public void zerarSistema() {
		File arquivo;

		arquivo = new File("contas.txt");
		FileOutputStream fos;
		try {
			fos = new FileOutputStream(arquivo, false);
			fos.write("".getBytes());
			fos.close();

		} catch (Exception e) {
			e.getMessage();
		}

		arquivo = new File("caronas.txt");
		try {
			fos = new FileOutputStream(arquivo, false);
			fos.write("".getBytes());
			fos.close();

		} catch (Exception e) {
			e.getMessage();
		}
	}

	public boolean isLoginCadastrado(String login) throws Exception {
		boolean resposta = false;
		BufferedReader arquivo = new BufferedReader(
				new FileReader("contas.txt"));

		while (arquivo.ready()) {
			String linha = arquivo.readLine();
			if (linha.split(";")[0].trim().equals(login)) {
				resposta = true;
			}
		}
		return resposta;
	}

	public void abrirSessao(String login, String senha)
			throws EasyAcceptException {
		// TODO ESCOLHER ONDE ISSO VAI FICAR!
		if (login == null || login.equals("")) {
			throw new EasyAcceptException("Login inválido");
		}

	}

	public boolean isSenhaValida(String login, String senha) throws Exception {
		boolean resposta = false;
		BufferedReader arquivo = new BufferedReader(
				new FileReader("contas.txt"));
		while (arquivo.ready()) {
			String linha = arquivo.readLine();
			if (linha.split(";")[0].trim().equals(login)) {
				if (linha.split(";").length == 5) {
					if (linha.split(";")[1].trim().equals(senha)) {
						resposta = true;
						break;
					}
				} else {
					break;
				}
			}
		}
		return resposta;

	}

	public String localizarCarona(int idSessao, String origem, String destino)
			throws Exception {
		String texto = "{";
		BufferedReader arquivo = new BufferedReader(new FileReader(
				"caronas.txt"));

		while (arquivo.ready()) {
			String linha = arquivo.readLine();
			Date data = new Date();
			SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");
			formatador.format(data);
			Date minhaData = formatador.parse(linha.split(";")[5].trim()
					.toString());
			if (Integer.parseInt(linha.split(";")[0]) == idSessao) {
				if (origem.equals("")) {
					if (destino.equals("")) {
						if (minhaData.after(data)) {
							texto += linha.split(";")[2] + ",";
						}
					} else {
						if(linha.split(";")[4].trim().equals(destino)){
							texto += linha.split(";")[2] + ",";
						}
					}
				} else {
					if(destino.equals("")){
						if(linha.split(";")[3].trim().equals(origem)){
							texto += linha.split(";")[2] + ",";
						}
					} else {
						if(linha.split(";")[3].trim().equals(origem) && linha.split(";")[4].trim().equals(destino)){
							texto += linha.split(";")[2] + ",";
						}
					}
				}
			}
		}
		if (texto != "{") texto = texto.substring(0, texto.length() - 1);
		texto += "}";
		return texto;
	}

	public int getLinhasArquivo() throws Exception {
		int contador = 1;
		BufferedReader arquivo = new BufferedReader(new FileReader(
				"caronas.txt"));

		while (arquivo.ready()) {
			String a = arquivo.readLine();
			contador++;
		}
		return contador;
	}

	public String getTrajeto(int idCarona) throws Exception {
		String resposta = "";
		BufferedReader arquivo = new BufferedReader(new FileReader(
				"caronas.txt"));
		String linha = "";

		while (arquivo.ready()) {
			// pega a linha
			linha = arquivo.readLine();
			if (Integer.parseInt(linha.split(";")[2]) == idCarona) {
				resposta = linha.split(";")[3] + " - " + linha.split(";")[4];
				break;
			}
		}
		return resposta;
	}

	public String getCarona(int idCarona) throws Exception {
		BufferedReader arquivo = new BufferedReader(new FileReader(
				"caronas.txt"));
		String resposta = "";
		while (arquivo.ready()) {
			String linha = arquivo.readLine();
			if (Integer.parseInt(linha.split(";")[2]) == idCarona) {
				resposta = (linha.split(";")[3].trim().toString()) + " para "
						+ (linha.split(";")[4].trim().toString()) + ", no dia "
						+ (linha.split(";")[5].trim().toString()) + ", as "
						+ (linha.split(";")[6].trim().toString());
			}
		}
		return resposta;
	}

}
