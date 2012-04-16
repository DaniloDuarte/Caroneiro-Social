package Testes;
import junit.framework.Assert;

import org.junit.Test;

import Logica.Usuario;


public class TestCriaçãoDeConta {

	@Test
	public void testaGetESet(){
		Usuario p = null;	
		try {
				p = new Usuario("guiga", "guigoso", "Guilherme", "guiga11@hotmail.com", "rio branco");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			try {
				p.setLogin(null);
				Assert.fail("Nao deveria puder");
			} catch (Exception e) {
				Assert.assertEquals("Login inválido", e.getMessage());
			}
	}
}
