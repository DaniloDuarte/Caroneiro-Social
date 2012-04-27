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
		controlador.criarUsuario("guiga", "aaa", "Guilherme", "rio branco", "guiga11@gmail.com");
		controlador.abrirSessao("guiga", "aaa");
	//	controlador.cadastrarCarona(1, "Campina Grande", "Joao Pessoa", "20/02/1992", "16:00", 3);
		System.out.println(controlador.getAtributoCarona(1, "origem"));
		//controlador.getAtributoCarona(idCarona, atributo)

		//p.cadastrarCarona("souza", "cg", "122442", "J2", 4);
	}
}
