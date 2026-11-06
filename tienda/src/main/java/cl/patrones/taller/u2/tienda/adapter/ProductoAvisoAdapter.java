package cl.patrones.taller.u2.tienda.adapter;

import cl.patrones.taller.u2.bodegaje.domain.Producto;
import cl.patrones.taller.u2.bodegaje.domain.Stock;
import cl.patrones.taller.u2.catalogo.domain.Aviso;
import cl.patrones.taller.u2.catalogo.domain.Categoria;

public class ProductoAvisoAdapter extends Aviso {
	private Producto producto;
	private Categoria categoria;

	public ProductoAvisoAdapter(Producto producto, Categoria categoria) {
		super();
		this.producto = producto;
		this.categoria = categoria;
	}

	@Override
	public String getTitulo() {
		return producto.getNombre();
	}

	@Override
	public String getSku() {
		return producto.getSku();
	}

	@Override
	public String getImagen() {
		return producto.getImagen();
	}

	@Override
	public Categoria getCategoria() {
		return categoria;
	}

	@Override
	public Long getPrecio() {
		return Math.round(producto.getCosto() * 1.3);
	}

	@Override
	public int getStock() {
		int total = 0;
		for (Stock s : producto.getStocks()) {
			total = total + s.getCantidad();
		}
		return total;
	}
}
