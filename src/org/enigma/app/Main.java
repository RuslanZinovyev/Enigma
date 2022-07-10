package org.enigma.app;

import org.enigma.io.CaesarCipher;
import org.enigma.options.Mode;

import java.io.*;

public class Main {

    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Hello, this is the Caesar Cipher application \n" +
                "Please choose the operation: \n" +
                "1 - Encrypt file with the key \n" +
                "2 - Decrypt file with the key");
        try {
            String entry = reader.readLine();
            System.out.println("Please specify the path and name for the source file");
            String inputPath = reader.readLine();
            System.out.println("Please specify where to save the result file");
            String outputPath = reader.readLine();
            File input = new File(inputPath);
            File output = new File(outputPath);
            CaesarCipher cipher = new CaesarCipher(input, output);
            int key;
            switch (entry) {
                case "1":
                    System.out.println("Please specify the security key number");
                    key = Integer.parseInt(reader.readLine());;
                    cipher.executeAndSaveToFile(Mode.ENCRYPT, key);
                    System.out.println("File is encrypted, please check the following location: \n" + output.toPath());
                    break;
                case "2":
                    System.out.println("Please specify the security key number");
                    key = Integer.parseInt(reader.readLine());
                    cipher.executeAndSaveToFile(Mode.DECRYPT, key);
                    System.out.println("File is encrypted, please check the following location: \n" + output.toPath());
                    break;
                default:
                    System.out.println("Please specify correct number");
                    break;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
