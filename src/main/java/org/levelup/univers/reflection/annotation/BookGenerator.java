package org.levelup.univers.reflection.annotation;

import java.util.ArrayList;
import java.util.Collection;

public class BookGenerator {
    private RandomIntAnnotationProcessor processor;

    public BookGenerator(){
        this.processor = new RandomIntAnnotationProcessor();
    }

    public Collection <Book> generateBooks(int count){
        Collection <Book> books = new ArrayList <>();
        for (int i = 0; i < count; i++) {
            processor.createAndProcess(Book.class);
            books.add(processor.createAndProcess(Book.class));
        }
        return books;
    }
}
