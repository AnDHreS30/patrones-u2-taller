package cl.patrones.taller.u2.tienda.controller;


import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import cl.patrones.taller.u2.catalogo.domain.Categoria;
import cl.patrones.taller.u2.catalogo.service.CategoriaService;
import cl.patrones.taller.u2.tienda.adapter.CategoriaItemMenu;
import cl.patrones.taller.u2.tienda.menu.EnlaceItemMenu;
import cl.patrones.taller.u2.tienda.menu.ItemMenu;

@ControllerAdvice

public class MenuControllerAdvice {
	private CategoriaService categoriaService;
	
	public MenuControllerAdvice(CategoriaService categoriaService) {
        this.categoriaService = categoriaService;
	}

	@ModelAttribute("menu")
	public List<ItemMenu> menu() {
		List<Categoria> todas = categoriaService.getCategorias();
		
		List<ItemMenu> raices = new ArrayList<>();
		for(Categoria c : todas) {
			if (c.getPadre() == null) {
				raices.add(new CategoriaItemMenu(c, todas));
			}
		}
		
		return List.of(
				new EnlaceItemMenu ("Inicio", "/"),
				new EnlaceItemMenu ("Categorías", "/categoria", raices),
				new EnlaceItemMenu ("Ubicación", "/ubicacion"),
				new EnlaceItemMenu ("Contacto", "/contacto")
		);
	}	
}
