package org.levelup.univers.reflection.annotation.classwork;

public class Book {

    @RandomInt()
    private int bookNumber;

    @RandomInt(min = 10, max = 2000)
    private int pagesCount;

    private int symbolCount;

    @Override
    public String toString() {
        return "Book{" +
                "bookNumber=" + bookNumber +
                ", pagesCount=" + pagesCount +
                ", symbolCount=" + symbolCount +
                '}';
    }
}
