package Logica;

import java.util.List;

import java.sql.Time;
import java.util.Date;

import easyaccept.EasyAcceptException;


public class Carona {
	private String idCarona;
	private String localOrigem;
	private String localDestino;
	private String data;
	private String horaDaSaida;
	private String vagasDisponiveis; 
	private FachadaDados fachadaDados;
	
	public Carona(String localOrigem, String localDestino, String data, String horaDaSaida, String vagasDisponiveis) throws Exception{
		setLocalOrigem(localOrigem);
		setLocalDestino(localDestino);
		setData(data);
		setHoraDaSaida(horaDaSaida);
		setVagasDisponiveis(vagasDisponiveis);
		
		int contador = fachadaDados.getLinhasArquivo();
		idCarona = "Carona" + Integer.toString(contador) + "ID";
	}

	public String getLocalOrigem() {
		return localOrigem;
	}

	public void setLocalOrigem(String localOrigem) throws EasyAcceptException {
		if (localOrigem == null || localOrigem.equals("")){
			throw new EasyAcceptException("Origem inválida");
		}
		this.localOrigem = localOrigem;
	}

	public String getLocalDestino() {
		return localDestino;
	}

	public void setLocalDestino(String localDestino) throws EasyAcceptException {
		if (localDestino == null || localDestino.equals("")){
			throw new EasyAcceptException("Destino inválido");
		}
		this.localDestino = localDestino;
	}

	public String getData() {
		return data;
	}

	public void setData(String data2) throws EasyAcceptException {
		if (data2 == null || data2.equals("")){
			throw new EasyAcceptException("Data inválida");
		}
		this.data = data2;
	}

	public String getHoraDaSaida(){
		
		return horaDaSaida;
	}

	public void setHoraDaSaida(String horaDaSaida) throws EasyAcceptException {
		if (horaDaSaida == null || horaDaSaida.equals("")){
			throw new EasyAcceptException("Hora inválida");
		}
		this.horaDaSaida = horaDaSaida;
	}

	public String getVagasDisponiveis() {
		return vagasDisponiveis;
	}

	public void setVagasDisponiveis(String vagasDisponiveis2) throws EasyAcceptException {
		if (vagasDisponiveis2 == null || vagasDisponiveis2.equals("")){
			throw new EasyAcceptException("Vaga inválida");
		}
		this.vagasDisponiveis = vagasDisponiveis2;
	}
	
	public List<Integer> localizaCarona(String idSessao, String origem, String destino){
		return null;
		
		
		//TODO pesquisar no arquivo todas as caronas e depois mostrar as certas 
		//TODO com todos os dados de forma organizada
	}


	public String getIdCarona() {
		return idCarona;
	}
	
}
