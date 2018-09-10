package br.net.smi.lancamento.config;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@SuppressWarnings("serial")
@ResponseStatus(HttpStatus.NOT_FOUND)
public class ExcecaoDeRecursoNaoEncontrado  extends RuntimeException{
	public ExcecaoDeRecursoNaoEncontrado(String message) {
			super(message);
	}

}
