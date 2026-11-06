package cl.patrones.taller.u2.catalogo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import cl.patrones.taller.u2.catalogo.domain.Categoria;
import cl.patrones.taller.u2.catalogo.domain.Clasificacion;
import cl.patrones.taller.u2.catalogo.repository.CategoriaRepository;
import cl.patrones.taller.u2.catalogo.repository.ClasificacionRepository;

@Service
public class CategoriaServiceImpl implements CategoriaService {

	private CategoriaRepository repository;
	private ClasificacionRepository clasificacionRepository;
	
	public CategoriaServiceImpl(CategoriaRepository repository, ClasificacionRepository clasificacionRepository) {
		super(); 
		this.repository = repository;
		this.clasificacionRepository = clasificacionRepository;
	}
	
	@Override
	public List<Categoria> getCategorias() {
		return repository.findAll();
	}

	@Override
	public Optional<Categoria> getCategoriaPorId(Long id) {
		return repository.findById(id);
	}
	
	@Override
	public Optional<Categoria> getCategoriaPorSku(String sku) {
		Optional<Clasificacion> clasificacion = clasificacionRepository.findFirstBySku(sku);
		if (clasificacion.isPresent()) {
			return Optional.of(clasificacion.get().getCategoria());
		}
		return Optional.empty();
	}
}
