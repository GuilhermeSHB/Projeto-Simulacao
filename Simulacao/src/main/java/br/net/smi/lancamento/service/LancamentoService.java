package br.net.smi.lancamento.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.net.smi.lancamento.model.Lancamento;
import br.net.smi.lancamento.model.LancamentoDTO;
import br.net.smi.lancamento.repository.LancamentoRepository;

@Service
public class LancamentoService {
	@Autowired
	private LancamentoRepository lancamentoRepository;

	
	
	public List<Lancamento> listarPorData(LocalDate dataInicial , LocalDate dataFinal) {
		return lancamentoRepository.findByVencimentoBetween(dataInicial, dataFinal);
	}

	public Lancamento cadastrar(LancamentoDTO lancamentoDTO) {
		Lancamento lancamento = new Lancamento();
		BeanUtils.copyProperties(lancamentoDTO, lancamento);
		return lancamentoRepository.save(lancamento);
	}
	
	public Lancamento atualizar(Lancamento lancamento) {
		return lancamentoRepository.save(lancamento);
	}
	
	public void remover(Long id) {
		lancamentoRepository.deleteById(id);
	}
}
