package code;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class FileToStringReader {

    public static String readStringFromFile(String fileName) {
        String text = null;
        try {
            text = new Scanner( new FileReader(fileName) ).useDelimiter("\\A").next();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return text;
    }
 }
