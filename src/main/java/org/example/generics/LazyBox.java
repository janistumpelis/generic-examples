package org.example.generics;

import java.util.function.Supplier;

public class LazyBox<T> {

    private T contents;

    private Supplier<T> functionToCreateContents; //izpildes plāns, jeb veids kā iegūt saturu

    public LazyBox(Supplier<T> functionToCreateContents) {
        this.functionToCreateContents = functionToCreateContents;
    }

    public T getContents() {
        if (contents == null) {
            contents = functionToCreateContents.get();
        }
        return contents;
    }
}
