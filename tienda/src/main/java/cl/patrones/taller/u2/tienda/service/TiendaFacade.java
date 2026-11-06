package cl.patrones.taller.u2.tienda.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import cl.patrones.taller.u2.bodegaje.domain.Producto;
import cl.patrones.taller.u2.bodegaje.service.BodegajeService;
import cl.patrones.taller.u2.catalogo.domain.Aviso;
import cl.patrones.taller.u2.catalogo.domain.Categoria;
import cl.patrones.taller.u2.catalogo.service.CategoriaService;
import cl.patrones.taller.u2.tienda.adapter.ProductoAvisoAdapter;

@Service
public class TiendaFacade {

	private BodegajeService bodegajeService;
	private CategoriaService categoriaService;

	public TiendaFacade(BodegajeService bodegajeService, CategoriaService categoriaService) {
		super();
		this.bodegajeService = bodegajeService;
		this.categoriaService = categoriaService;
	}

	public List<Aviso> getAvisos() {
		List<Aviso> avisos = new ArrayList<>();
		for (Producto p : bodegajeService.getProductos()) {
			Optional<Categoria> categoria = categoriaService.getCategoriaPorSku(p.getSku());
			if (categoria.isPresent()) {
				avisos.add(new ProductoAvisoAdapter(p, categoria.get()));
			}
		}
		return avisos;
	}

	public List<Aviso> getAvisosPorCategoria(Long categoriaId) {
		List<Aviso> resultado = new ArrayList<>();
		for (Aviso a : getAvisos()) {
			if (perteneceA(a.getCategoria(), categoriaId)) {
				resultado.add(a);
			}
		}
		return resultado;
	}

	public Optional<Categoria> getCategoria(Long id) {
		return categoriaService.getCategoriaPorId(id);
	}

	private boolean perteneceA(Categoria c, Long categoriaId) {
		while (c != null) {
			if (c.getId().equals(categoriaId)) {
				return true;
			}
			c = c.getPadre();
		}
		return false;
	}
}
