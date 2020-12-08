package org.levelup.univers.reflection.annotation;

import java.util.Collection;

public class App {
    public static void main(String[] args) {

        BookGenerator generator = new BookGenerator();

        Collection <Book> books = generator.generateBooks(10);
        books.forEach(book -> System.out.println(book));

    }

}
