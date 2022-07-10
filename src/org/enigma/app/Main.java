package org.enigma.app;

import org.enigma.io.CaesarCipher;

import java.io.File;
import java.io.FileNotFoundException;

public class Main {

    public static final String INPUT_FILE = "/Users/ruslanzinovyev/Desktop/file.txt";
    public static final String OUTPUT_FILE = "/Users/ruslanzinovyev/Desktop/encrypt.txt";
    public static final String RESULT = "/Users/ruslanzinovyev/Desktop/result.txt";

    public static void main(String[] args) {
        System.out.println("Hello, this is the Caesar Cipher application");
        File input = new File(INPUT_FILE);
        File output = new File(OUTPUT_FILE);

        try {
            CaesarCipher cipher = new CaesarCipher(input, output);
            cipher.encryptAndWriteToFile(4);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
