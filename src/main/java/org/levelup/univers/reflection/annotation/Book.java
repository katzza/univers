package org.levelup.univers.reflection.annotation;

public class Book {

    @RandomInt()
    private int bookNumber;

    @RandomInt(min = 10, max = 2000)
    private int pagesCount;
}
