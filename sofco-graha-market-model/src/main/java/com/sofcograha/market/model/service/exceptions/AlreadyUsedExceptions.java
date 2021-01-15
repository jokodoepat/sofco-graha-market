package com.sofcograha.market.model.service.exceptions;

public class AlreadyUsedExceptions extends RuntimeException {

    public AlreadyUsedExceptions() {
        super();
    }

    public AlreadyUsedExceptions(String message) {
        super (message);
    }

}
