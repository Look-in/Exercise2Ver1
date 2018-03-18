package code;

/**
 * @author Serg Shankunas <shserg2012@gmail.com>
 * @version 1.0
 * Reading the file as a whole string.
 * This solution was used just for example. JVM can throws a Stackoverflow error
 */

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class FileToStringReader {

    public static String readStringFromFile(String fileName) {
        String text;
        try {
            text = new Scanner(new FileReader(fileName)).useDelimiter("\\A").next();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        return text;
    }
}
