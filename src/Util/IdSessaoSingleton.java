package Util;

public class IdSessaoSingleton {
	
	private static IdSessaoSingleton singleton = null;
	private static int idSessao;
	
	private IdSessaoSingleton(){
		idSessao = 1;
	}

	public static int getId(){
		if (singleton == null){
			singleton = new IdSessaoSingleton();
		}
		else if(idSessao == 28){
			idSessao++;
		}
		else{
			idSessao++;
		}
		
		return idSessao;
	}
}
