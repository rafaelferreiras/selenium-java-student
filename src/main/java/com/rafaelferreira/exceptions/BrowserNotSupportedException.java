package com.rafaelferreira.exceptions;

@SuppressWarnings("serial")
public class BrowserNotSupportedException extends IllegalStateException {

    public BrowserNotSupportedException(String browser) {
        super(String.format("Browser não suportado: %s", browser));
    }
}
