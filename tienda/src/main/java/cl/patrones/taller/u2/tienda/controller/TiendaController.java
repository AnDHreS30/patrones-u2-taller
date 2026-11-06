
package cl.patrones.taller.u2.tienda.controller;

import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import cl.patrones.taller.u2.catalogo.domain.Categoria;
import cl.patrones.taller.u2.tienda.service.TiendaFacade;

@Controller
public class TiendaController {
	
	private TiendaFacade tiendaFacade;

    public TiendaController(TiendaFacade tiendaFacade) {
        this.tiendaFacade = tiendaFacade;
    }
	
	@GetMapping("/")
	public String inicio(Model model) {
		model.addAttribute("avisos", tiendaFacade.getAvisos());
		return "inicio";
	}
		
	@GetMapping("/categoria/{categoriaId}/{slug}")
	public String categoria(
			@PathVariable(name = "categoriaId") Long categoriaId,
			@PathVariable(name = "slug") String slug,
			Model model
	) {
		Optional<Categoria> categoria = tiendaFacade.getCategoria(categoriaId);
		if (categoria.isEmpty()) {
			return "redirect:/";
		}
		model.addAttribute("avisos", tiendaFacade.getAvisosPorCategoria(categoriaId));
		model.addAttribute("categoria", categoria.get());
		return "categoria";
	}
	
	@GetMapping("/ingresar")
	public String login() {
		return "login";
	}
	
	@GetMapping("/ubicacion")
	public String ubicacion() {
		return "ubicacion";
	}
	
	@GetMapping("/contacto")
	public String contacto() {
		return "contacto";
	}
}
