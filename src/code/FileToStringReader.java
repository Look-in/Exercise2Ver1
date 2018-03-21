package code;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

/**
 * Reading the file as a whole string.
 * @author Serg Shankunas <shserg2012@gmail.com>
 * @version 1.0
 */
public class FileToStringReader {

    public static String readStringFromFile(String fileName) {
        String text;
        try (Scanner scanner = new Scanner(new FileReader(fileName))) {
            text = scanner.useDelimiter("\\A").next();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        return text;
    }
}
