package Logica;

import java.util.AbstractMap;
import java.util.TreeMap;

public class RepositorioDeUsuarios {
	private AbstractMap<String, Usuario> repositorioUsuario;
	private static RepositorioDeUsuarios Repositorio = null;
	
	private RepositorioDeUsuarios() {
		repositorioUsuario = new TreeMap<String, Usuario>();
	}
	
	public static RepositorioDeUsuarios getInstance() {
		if (Repositorio == null) {
			Repositorio = new RepositorioDeUsuarios();
		}
		return Repositorio;
	}
	
	public void addUsuario(String login, Usuario usuario){
		repositorioUsuario.put(login, usuario);
	}
	
}
