package Logica;

import java.util.AbstractMap;
import java.util.TreeMap;

import easyaccept.EasyAcceptException;

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
		if (repositorioUsuario.containsKey(login)){
			throw new IllegalArgumentException("Já existe um usuário com este login");
		}
		
		for (Usuario user: repositorioUsuario.values()){
			if (user.getEmail().equals(usuario.getEmail())){
				throw new IllegalArgumentException("Já existe um usuário com este email");
			}
		}
		repositorioUsuario.put(login, usuario);
	}

	public AbstractMap<String, Usuario> getRepositorioUsuario() {
		return repositorioUsuario;
	}

}
