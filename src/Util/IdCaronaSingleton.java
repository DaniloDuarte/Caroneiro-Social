package Util;

public class IdCaronaSingleton {

	private static int idCarona = 0;

	public static int getId(){
		return ++idCarona;
	}
}
