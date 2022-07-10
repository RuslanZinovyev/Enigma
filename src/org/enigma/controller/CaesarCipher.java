package org.enigma.controller;

import org.enigma.enumerator.ErrorCode;
import org.enigma.exception.ApplicationException;
import org.enigma.service.Operation;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class CaesarCipher {

    private final File inputFile;
    private final File outputFile;

    public CaesarCipher(File inputFile, File outputFile) throws FileNotFoundException {
        if (inputFile.exists()) {
            this.inputFile = inputFile;
            this.outputFile = outputFile;
        } else {
            throw new FileNotFoundException("Couldn't initialize the input file for encryption, please specify the correct path or filename");
        }
    }

    public void executeAndSaveToFile(Operation operation) {
        StringBuilder stringBuilder = new StringBuilder();
        try (FileInputStream fis = new FileInputStream(inputFile);
             InputStreamReader isw = new InputStreamReader(fis, StandardCharsets.UTF_8);
             BufferedReader reader = new BufferedReader(isw)
        ) {
            while (reader.ready()) {
                String line = reader.readLine();
                for (char ch : line.toCharArray()) {
                    stringBuilder.append(operation.execute(ch));
                }
                stringBuilder.append('\n');
            }
            writeToFile(stringBuilder);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void writeToFile(StringBuilder builder) {
        if (!getFileExtension(outputFile).equals(".txt")) {
            throw new ApplicationException("Please specify the text file with .txt extension", ErrorCode.INVALID_FILE_EXTENSION);
        }
        try (FileOutputStream fos = new FileOutputStream(outputFile);
             OutputStreamWriter osw = new OutputStreamWriter(fos, StandardCharsets.UTF_8);
             BufferedWriter writer = new BufferedWriter(osw)
        ) {
            writer.write(builder.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String getFileExtension(File file) {
        String name = file.getName();
        int lastIndexOf = name.lastIndexOf(".");
        return name.substring(lastIndexOf);
    }
}

