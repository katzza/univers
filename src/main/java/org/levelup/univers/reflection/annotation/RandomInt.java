package org.levelup.univers.reflection.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
public @interface RandomInt {
    int min() default 0;

    int max() default Integer.MAX_VALUE;

}
