package Testes;

import junit.framework.Assert;

import org.junit.Test;

import Logica.Controlador;
import Logica.Usuario;
import Util.IdCaronaSingleton;

public class TestCriaçãoDeConta {

	@Test
	public void testaGetESet() throws Exception {
		Controlador controlador = new Controlador();

		controlador.zerarSistema();
		controlador.cadastrarCarona("1", "Campina Grande", "Joao Pessoa", "20/02/1992", "16:00", 3);
		//controlador.getAtributoCarona(idCarona, atributo)

		//p.cadastrarCarona("souza", "cg", "122442", "J2", 4);
	}
}
