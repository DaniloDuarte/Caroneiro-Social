package Logica;

import java.io.Serializable;

import easyaccept.EasyAcceptException;

public class Sistema implements Serializable{
	private FachadaDados fachadaDados = new FachadaDados();
	
	protected void idSessaoCadastrado(String idSessao) throws Exception {
		fachadaDados.idSessaoCadastrado(idSessao);
	}

	/*protected static int getIdSessao(){
		return idSessao;
	}*/
}