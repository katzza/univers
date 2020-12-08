package org.levelup.univers.reflection.annotation.classwork;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface RandomInt {
    int min() default 0;

    int max() default Integer.MAX_VALUE;

}
