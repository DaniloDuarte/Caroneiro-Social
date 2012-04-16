package Logica;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

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

	public void cadastraCarona(Usuario pessoa) {
		// SE PESSOA JA TIVER CARONA CADASTRADA

		// SE PESSOA NAO TIVER CARONA CADASTRADA

	}

	public String getAtributoUsuario(String login, String atributo)
			throws Exception {
		if (login == null || login.equals("")){
			throw new EasyAcceptException("Login inválido");
		}
		
		if (atributo == null || atributo.equals("")){
			throw new EasyAcceptException("Atributo inválido");
		}
		
		if (!this.isLoginCadastrado(login)){
			throw new EasyAcceptException("Usuário inexistente");
		}
		
		if (!atributo.equals("nome") && !atributo.equals("endereco")){
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
	
	
	public void abrirSessao(String login, String senha) throws EasyAcceptException{
		//TODO ESCOLHER ONDE ISSO VAI FICAR!
		if (login == null || login.equals("")){
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
						if (linha.split(";")[1].trim().equals(senha)){
						resposta = true;
						break;
						}
					}else{
						break;
					}
				}					
			}
		return resposta;

	}

 	public List<Integer> localizarCarona(String idSessao, String origem, String destino) {
		return new ArrayList<Integer>();
		
	}
	
	
	
	
	
	
}
