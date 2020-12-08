package org.levelup.univers.reflection.annotation.homework;

public class ReflectionClassAnnotationProcessor {

    public <T> void process(Class <T> tClass) {
        System.out.println(tClass.toString());
    }

}
