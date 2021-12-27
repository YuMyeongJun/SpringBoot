package edu.dl.project01.exception;

public class NotEnoughStockException extends RuntimeException {
    public NotEnoughStockException(String s) {
        super(s);
    }
}
