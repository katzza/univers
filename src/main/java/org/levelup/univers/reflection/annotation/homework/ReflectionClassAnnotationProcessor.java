package org.levelup.univers.reflection.annotation.homework;

import java.lang.reflect.InvocationTargetException;

public class ReflectionClassAnnotationProcessor {

    public static <T> void create(Class <T> claz) throws NoSuchMethodException, IllegalAccessException,
            InvocationTargetException, InstantiationException {
        Object o = claz.getDeclaredConstructor().newInstance();
        System.out.println(o.toString());
    }

}
