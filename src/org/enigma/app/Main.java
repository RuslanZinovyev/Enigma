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

    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Hello, this is the Caesar Cipher application \n" +
                "Please choose the operation: \n" +
                "1 - Encrypt file with the key \n" +
                "2 - Decrypt file with the key \n" +
                "3 - Brute force analyzer \n" +
                "4 - Static key analyzer \n" +
                "5 - Exit application");
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
