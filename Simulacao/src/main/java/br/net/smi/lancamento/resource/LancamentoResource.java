package br.net.smi.lancamento.resource;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import br.net.smi.lancamento.model.Lancamento;
import br.net.smi.lancamento.model.LancamentoDTO;
import br.net.smi.lancamento.service.LancamentoService;

@RestController
@RequestMapping("/lancamentos")
public class LancamentoResource {
	@Autowired
	private LancamentoService lancamentoService;


	@GetMapping
	public ResponseEntity<List<Lancamento>> listarVencimento(
			@RequestParam("dataInicio") @DateTimeFormat(pattern = "dd-MM-yyyy") LocalDate dataInicial,
			@RequestParam("dataFim") @DateTimeFormat(pattern = "dd-MM-yyyy") LocalDate dataFinal) {
		return new ResponseEntity<>(lancamentoService.listarPorData(dataInicial, dataFinal), HttpStatus.OK);

	}

	@PutMapping
	public ResponseEntity<Lancamento> atualizar(@RequestBody Lancamento lancamento) {
		return new ResponseEntity<>(lancamentoService.atualizar(lancamento), HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> remover(@PathVariable Long id) {
		lancamentoService.remover(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<Lancamento> cadastrar(@RequestBody LancamentoDTO lancamentoDTO) {
		return new ResponseEntity<>(lancamentoService.cadastrar(lancamentoDTO), HttpStatus.CREATED);
	}
}
