package br.net.smi.lancamento.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.net.smi.lancamento.model.Categoria;
import br.net.smi.lancamento.repository.CategoriaRepository;

@Service

public class CategoriaService {
	@Autowired
	private CategoriaRepository categoriaRepository;

	public Categoria cadastrar(Categoria categoria) {
		return categoriaRepository.save(categoria);

	}

	public List<Categoria> listarCategorias() {
		return categoriaRepository.findAll();
	}

	public void remover(Long id) {
		categoriaRepository.deleteById(id);

	}

	public Categoria atualizar(Categoria categoria) {
		return categoriaRepository.save(categoria);
	}

}
