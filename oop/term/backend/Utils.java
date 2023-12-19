package oop.term.backend;

import java.io.File;

public class Utils {
    public static boolean isFileOrDirectoryExists(String path) {
        File file = new File(path);
        return file.exists();
    }
}
