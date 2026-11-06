package cl.patrones.taller.u2.tienda.menu;

import java.util.List;

import cl.patrones.taller.u2.tienda.menu.util.Slugger;

public class EnlaceItemMenu implements ItemMenu {
	private String texto;
	private String enlace;
	private List<ItemMenu> hijos;
	
	// Constructor 1: enlace SIN hijos
	public EnlaceItemMenu(String texto, String enlace) {
		this.texto = texto;
		this.enlace = enlace;
		this.hijos = List.of();
	}
	
	// Constructor 2 enlace CON hijos
	public EnlaceItemMenu(String texto, String enlace, List<ItemMenu> hijos) {
		this.texto = texto;
		this.enlace = enlace;
		this.hijos = hijos;		
	}
	
	@Override
	public String getTexto() {
		return texto;
	}

	@Override
	public String getSlug() {
		return Slugger.toSlug(texto);
	}

	@Override
	public String getEnlace() {
		return enlace;
	}

	@Override
	public boolean tieneHijos() {
		return !hijos.isEmpty();
	}

	@Override
	public List<? extends ItemMenu> getHijos() {
		return hijos;
	}

}
