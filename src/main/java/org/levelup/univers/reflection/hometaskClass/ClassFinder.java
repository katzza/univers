package org.levelup.univers.reflection.hometaskClass;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

public class ClassFinder {

    public void findAnnotatedClasses(String packagePath) { //toDo get from Git and check
        String roothPath = "src/main/java";

        File root = new File(roothPath + packagePath.replace(".", "/"));

        if (!root.exists()) {
            throw new RuntimeException("Package absent!");
        }
        Collection <File> files = findFilesInFolder(root);
        System.out.println("List files");
        files.forEach(file -> System.out.println(file.getAbsolutePath()));

        Collection <String> classNames = files.stream()
                                              .map(file -> file.getAbsolutePath())
                                              .filter(filepath -> filepath.contains(".java"))
                                              .map(filepath -> {
                                                       int startindex = filepath.indexOf("\\java\\") + 6;
                                                       int endindex = filepath.indexOf(".java");
                                                       return filepath.substring(startindex, endindex);
                                                   }
                                              )
                                              .map(filepath -> filepath.replace("/", "."))
                                              .collect(Collectors.toList());
        System.out.println("List of class names");
        classNames.forEach(className -> System.out.println(className));
    }

    private Collection <File> findFilesInFolder(File folder) {
        Collection <File> files = new ArrayList <>();
        File[] filesInFolder = folder.listFiles(); //list
        if (filesInFolder == null) {return files;}

        for (File file : filesInFolder) {
            if (file.isDirectory()) {
                //rekurse
                findFilesInFolder(file);
            } else { files.add(file); }
        }

        return files;
    }
}
