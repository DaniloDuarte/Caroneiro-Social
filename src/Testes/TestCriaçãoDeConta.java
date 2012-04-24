package Testes;
import junit.framework.Assert;

import org.junit.Test;

import Logica.Usuario;


public class TestCriaçãoDeConta {

	@Test
	public void testaGetESet() throws Exception{
		Usuario p = null;	
			p = new Usuario("guiguianha", "guigaooo00", "Guisalhearm", "gyuigraa112@hotmail.com", "rasio brancoo");
		
			
			p.cadastrarCarona("Jp", "Jp1", "122", "J12", "tres");
			p.cadastrarCarona("souza", "cg", "122442", "J2", "quatro");
	}
}
