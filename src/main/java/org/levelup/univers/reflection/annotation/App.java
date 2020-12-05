package org.levelup.univers.reflection.annotation;

import java.util.Collection;

public class App {

    BookGenerator generator = new BookGenerator();

    Collection <Book> books = generator.generateBooks(10);

}
