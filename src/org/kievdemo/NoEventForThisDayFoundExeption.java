package org.kievdemo;

public class NoEventForThisDayFoundExeption extends Exception {
    public NoEventForThisDayFoundExeption(String message) {
        super("Oops, I did it again " + message);
    }
}
