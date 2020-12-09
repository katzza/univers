package org.levelup.univers.reflection.hometaskClass;

public class App {
    public static void main(String[] args) {
        ClassFinder finder = new ClassFinder();
        finder.findAnnotatedClasses("org.hometask.reflect");
    }
}
