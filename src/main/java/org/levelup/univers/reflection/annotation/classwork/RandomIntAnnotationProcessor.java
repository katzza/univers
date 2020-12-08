package org.levelup.univers.reflection.annotation.classwork;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.Random;

public class RandomIntAnnotationProcessor {

    public <T> T createAndProcess(Class <T> tClass) {

        try {
            Constructor <T> constructor = tClass.getDeclaredConstructor();
            T instance = constructor.newInstance();
//find annotation -fields
            Field[] fields = tClass.getDeclaredFields();
            for (Field field : fields) {
                //check we have nnotations
                RandomInt annotation = field.getAnnotation(RandomInt.class);
                if (annotation != null) {
                    int randomInt = generateRandomInteger(annotation.min(), annotation.max());
                    //write in field
                    field.setAccessible(true);
                    field.set(instance, randomInt);
                }
            }
            return instance;
        } catch (Exception exc) {throw new RuntimeException(exc);}
    }

    private int generateRandomInteger(int min, int max) {
        return new Random().nextInt(max - min) + min;
    }

}
