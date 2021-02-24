package com.rafaelferreira.exceptions;

public class HeadlessNotSupportedException extends IllegalStateException {

	private static final long serialVersionUID = 1L;

	public HeadlessNotSupportedException(String browser) {
		super(String.format("Healdess não suportado para este %s browser", browser));
	}
}
