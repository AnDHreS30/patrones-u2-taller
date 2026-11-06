package cl.patrones.taller.u2.tienda.adapter;

import java.util.ArrayList;
import java.util.List;

import cl.patrones.taller.u2.catalogo.domain.Categoria;
import cl.patrones.taller.u2.tienda.menu.ItemMenu;
import cl.patrones.taller.u2.tienda.menu.util.Slugger;

public class CategoriaItemMenu implements ItemMenu {
	private Categoria categoria;
	private List<ItemMenu> hijos;
	
	public CategoriaItemMenu (Categoria categoria, List<Categoria> todas) {
		this.categoria = categoria;
		this.hijos = new ArrayList<>();
		
		for (Categoria c : todas) {
			if (c.getPadre() != null
				&& c.getPadre().getId().equals(categoria.getId())) {
				hijos.add(new CategoriaItemMenu(c, todas));
			}	
		}
	}

	@Override
	public String getTexto() {
		return categoria.getNombre();
	}

	@Override
	public String getSlug() {
		return Slugger.toSlug(categoria.getNombre());
	}

	@Override
	public String getEnlace() {
		return "/categoria/" + categoria.getId() + "/" + getSlug();
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
