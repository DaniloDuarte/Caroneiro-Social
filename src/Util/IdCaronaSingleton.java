package Util;

public class IdCaronaSingleton {
	
	private static IdCaronaSingleton singleton = null;
	private static int idCarona;
	
	private IdCaronaSingleton(){
		idCarona = 1;
	}

	public static int getId(){
		if (singleton == null){
			singleton = new IdCaronaSingleton();
		}else{
			idCarona++;
		}
		
		return idCarona;
	}
}
