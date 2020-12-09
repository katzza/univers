package org.levelup.utils;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.levelup.univers.utils.StringUtils;

public class StringUtilsTest {
    @Test
    public void testIsBlank_whenValueIsNull_thenReturnTrue(){
        //given
        //when
        boolean result = StringUtils.isBlank(null);
        //then
        Assertions.assertTrue(result, "Method isBlank should return True when value is null");
    }

    @Test
    public void testIsBlank_whenValueIsEmpty_thenReturnTrue(){
        //given
        String value = "";
        //when
        boolean result = StringUtils.isBlank(value);
        //then
        Assertions.assertTrue(result, "Method isBlank should return True when value is null");
    }

    @Test
    public void testIsBlank_whenValueIsNotEmpty_thenReturnTrue(){
        //given
        String value = "some String";
        //when
        boolean result = StringUtils.isBlank(value);
        //then
        Assertions.assertFalse(result, "Method isBlank should return False when value is empty string");
    }
}