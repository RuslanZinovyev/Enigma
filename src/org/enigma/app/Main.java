package org.enigma.app;

import org.enigma.controller.CaesarCipher;
import org.enigma.service.Decryptor;
import org.enigma.service.Encryptor;
import org.enigma.service.Operation;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private final static String HEADER = "Hello, this is the Caesar Cipher application \nPlease choose the operation: \n\n";
    private final static String TEXT_ENCRYPTION_WITH_KEY = "1: Encrypt file with the key \n";
    private final static String TEXT_DECRYPTION_WITH_KEY = "2: Decrypt file with the key \n";
    private final static String TEXT_DECRYPTION_BRUTE_FORCE = "3: Brute force analyzer \n";
    private final static String TEXT_DECRYPTION_STATIC_CODE_ANALYZER = "4: Static key analyzer \n";
    private final static String EXIT = "5: Exit application";

    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(
                        HEADER +
                        TEXT_ENCRYPTION_WITH_KEY +
                        TEXT_DECRYPTION_WITH_KEY +
                        TEXT_DECRYPTION_BRUTE_FORCE +
                        TEXT_DECRYPTION_STATIC_CODE_ANALYZER +
                        EXIT
        );
        try {
            String entry = reader.readLine();

            int key;
            switch (entry) {
                case "1", "2" -> {
                    System.out.println("Please specify the path and name for the source file");
                    String inputPath = reader.readLine();
                    System.out.println("Please specify where to save the result file");
                    String outputPath = reader.readLine();
                    File input = new File(inputPath);
                    File output = new File(outputPath);
                    CaesarCipher cipher = new CaesarCipher(input, output);
                    switch (entry) {
                        case "1" -> {
                            System.out.println("Please specify the security key number");
                            key = Integer.parseInt(reader.readLine());
                            Operation encryption = new Encryptor(key);
                            cipher.executeAndSaveToFile(encryption);
                            System.out.println("File is encrypted, please check the following location: \n" + output.toPath());
                        }
                        case "2" -> {
                            System.out.println("Please specify the security key number");
                            key = Integer.parseInt(reader.readLine());
                            Operation decryption = new Decryptor(key);
                            cipher.executeAndSaveToFile(decryption);
                            System.out.println("File is encrypted, please check the following location: \n" + output.toPath());
                        }
                    }
                }
                case "3", "4" -> {
                    System.out.println("Please specify the text for analyzing");
                    switch (entry) {
                        case "3" -> {}
                        case "4" -> {}
                    }
                }
                case "5" -> System.exit(0);
                default -> System.out.println("Please specify correct number");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
