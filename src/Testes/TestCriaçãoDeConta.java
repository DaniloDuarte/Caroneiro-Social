package Testes;

import junit.framework.Assert;

import org.junit.Test;

import Logica.Controlador;
import Logica.Usuario;
import Util.IdCaronaSingleton;

public class TestCria��oDeConta {

	@Test
	public void testaGetESet() throws Exception {
		Controlador controlador = new Controlador();

		controlador.zerarSistema();
		controlador.criarUsuario("guiga", "aaa", "Guilherme", "rio branco", "guiga11@gmail.com");
		controlador.abrirSessao("guiga", "aaa");
		controlador.cadastrarCarona("1", "Campina Grande", "Jo�o Pessoa", "30/03/2013", "20:17", null);
		//controlador.getAtributoCarona(idCarona, atributo)

		//p.cadastrarCarona("souza", "cg", "122442", "J2", 4);
	}
}
