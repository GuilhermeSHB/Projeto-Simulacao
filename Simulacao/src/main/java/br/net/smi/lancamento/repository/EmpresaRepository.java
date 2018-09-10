package br.net.smi.lancamento.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.net.smi.lancamento.model.Empresa;

@Repository
public interface EmpresaRepository extends JpaRepository< Empresa , Long >{
	
	List<Empresa> findByNomeOrCnpj(String nome , String cnpj);

}
