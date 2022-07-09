package org.enigma.app;

import org.enigma.io.Encryptor;

import java.io.File;

public class Main {

    public static final String INPUT_FILE = "/Users/ruslanzinovyev/Desktop/file.txt";
    public static final String OUTPUT_FILE = "/Users/ruslanzinovyev/Desktop/encrypt.txt";

    public static void main(String[] args) {
        File inputFile = new File(INPUT_FILE);
        File outputFile = new File(OUTPUT_FILE);

        Encryptor encryptor = new Encryptor(inputFile, outputFile);
        encryptor.encryptAndWriteToFile(15);
    }
}
