package cl.patrones.taller.u2.tienda.adapter;

import java.util.Collection;
import java.util.List;

import cl.patrones.taller.u2.clientes.Cliente;
import org.springframework.security.core.GrantedAuthority;

public class UsuarioAnonimo extends Usuario {

	private static final long serialVersionUID = -4093607868539453832L;

	public UsuarioAnonimo() {
		super(new Cliente("", "Anónimo", "", ""));
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return List.of();
	}
}
