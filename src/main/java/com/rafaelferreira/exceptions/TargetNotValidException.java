package com.rafaelferreira.exceptions;

public class TargetNotValidException extends IllegalStateException {

	private static final long serialVersionUID = 1L;

	public TargetNotValidException(String target) {
		super(String.format("Tipo de execução %s não suportado. Use local or gird", target));
	}

}
