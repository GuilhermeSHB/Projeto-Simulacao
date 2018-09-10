package br.net.smi.lancamento.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

import br.net.smi.lancamento.model.Empresa;
import br.net.smi.lancamento.service.EmpresaService;

@RestController
@RequestMapping("/empresas")
public class EmpresaResource {
	
	@Autowired
	private EmpresaService empresaService;
	
	@GetMapping
	public ResponseEntity<List<Empresa>> listarEmpresas(){
		return new ResponseEntity<>(empresaService.listarEmpresas() , HttpStatus.OK);
	}
	
	@GetMapping("/buscarPorNomeOuCnpj")
	public ResponseEntity<?> filtrarPorNomeOuCnpj(@RequestParam(name = "nome") String nome , @RequestParam(name = "cnpj") String cnpj){
		
		return new ResponseEntity<>(empresaService.listarPorCnpjOuNome(nome, cnpj) , HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Empresa> cadastrar(@RequestBody Empresa empresa){
		
		return new ResponseEntity<>(empresaService.cadastrar(empresa) , HttpStatus.CREATED);
	}
	
	@PutMapping
	public ResponseEntity<Empresa> atualizar(@RequestBody Empresa empresa){
		return new ResponseEntity<>(empresaService.atualizar(empresa) , HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> remover(@PathVariable Long id){
		empresaService.remover(id);
		return new ResponseEntity<>(HttpStatus.OK);
		
		
	}

}
