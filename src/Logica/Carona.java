package Logica;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.TreeMap;

import Util.IdCaronaSingleton;
import easyaccept.EasyAcceptException;

public class Carona implements Serializable{
	private int idCarona = 0;
	private String localOrigem;
	private String localDestino;
	private String data;
	private String horaDaSaida;
	private String vagasDisponiveis; 
	private FachadaDados fachadaDados;
	private Sistema sistema = new Sistema();
	private AbstractMap<Integer, String> sugestoesPontoEncontro = new TreeMap<Integer, String>();
	private List<String> respostasSugestoesPontoEncontro = new ArrayList<String>();
	private AbstractMap<Integer, String> solicitacaoVagaPontoEncontro = new TreeMap<Integer, String>();
	private AbstractMap<Integer, String> solicitacoesPontoEncontroAceitas = new TreeMap<Integer, String>();
	private AbstractMap<Integer, String> donosSolicitacoesVagaPontoEncontro = new TreeMap<Integer, String>();

	public Carona(String idSessao,String localOrigem, String localDestino, String data, String horaDaSaida, String vagasDisponiveis) throws Exception{
		if (idSessao == null || idSessao.equals("")){
			throw new EasyAcceptException("Sessão inválida");
		}

		if (vagasDisponiveis == null){
			throw new EasyAcceptException("Vaga inválida");
		}

		try {
			Integer.parseInt(vagasDisponiveis);
		} catch (Exception e) {
			throw new EasyAcceptException("Vaga inválida");
		}

		validaData(data);


		if (!validaHora(horaDaSaida)){
			throw new EasyAcceptException("Hora inválida");
		}

		sistema.idSessaoCadastrado(idSessao);

		setLocalOrigem(localOrigem);
		setLocalDestino(localDestino);
		setData(data);
		setHoraDaSaida(horaDaSaida);
		setVagasDisponiveis(vagasDisponiveis);

		idCarona = IdCaronaSingleton.getId();
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

	public void setVagasDisponiveis(String vagasDisponiveis) throws EasyAcceptException {
		//if (vagasDisponiveis2 == null || vagasDisponiveis2.equals("")){
	//		throw new EasyAcceptException("Vaga inválida");
	//	}
		this.vagasDisponiveis = vagasDisponiveis;
	}

	public String getIdCarona() {
		return Integer.toString(idCarona);
	}

	public String getAtributoCarona(String idCarona, String atributo) throws Exception {
		return fachadaDados.getAtributoCarona(idCarona, atributo);
	}

	private boolean validaHora(String hora){  
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");  
        sdf.setLenient(false);  
        try{  
            sdf.parse(hora);  
        }catch(Exception e){  
            return false;  
        }  
        return true;  
    } 

	private void validaData(String data) throws Exception{
		DateFormat formatador = new SimpleDateFormat ("dd/MM/yyyy");  
		formatador.setLenient (false);


		try {  
			formatador.parse(data);  
		} catch (Exception ex) {  
		   throw new EasyAcceptException("Data inválida");
		}

		Date dtAgora = new Date();		
		formatador.format(dtAgora);
		Date minhaData = formatador.parse(data);

		if (dtAgora.after(minhaData)){
			throw new EasyAcceptException("Data inválida");
		}
	}
	
	public AbstractMap<Integer, String> getSugestoesPontoEncontro() {
		return sugestoesPontoEncontro;
	}
	
	public List<String> getRespostasSugestoesPontoEncontro() {
		return respostasSugestoesPontoEncontro;
	}

	public AbstractMap<Integer, String> getSolicitacaoVagaPontoEncontro() {
		return solicitacaoVagaPontoEncontro;
	}
	
	public AbstractMap<Integer, String> getSolicitacoesPontoEncontroAceitas() {
		return solicitacoesPontoEncontroAceitas;
	}

	public AbstractMap<Integer, String> getDonosSolicitacoesVagaPontoEncontro() {
		return donosSolicitacoesVagaPontoEncontro;
	}
}