package org.levelup.univers.reflection.annotation.homework;

import java.lang.reflect.InvocationTargetException;

public class homeworkApp {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
        ScanningFiles s = new ScanningFiles();
        String targetPackageName = "ru\\levelup\\lessons";
        s.scanProjectAndCreateClass(targetPackageName);
    }
}
