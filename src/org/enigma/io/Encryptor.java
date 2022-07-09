package org.enigma.io;

import org.enigma.utils.EncryptUtils;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class Encryptor {

    private final File inputFile;
    private final File outputFile;

    public Encryptor(File inputFile, File outputFile) {
        this.inputFile = inputFile;
        this.outputFile = outputFile;
    }

    public void encryptAndWriteToFile(int securityKey) {
        StringBuilder stringBuilder = new StringBuilder();
        try (FileInputStream fis = new FileInputStream(inputFile);
             InputStreamReader isw = new InputStreamReader(fis, StandardCharsets.UTF_8);
             BufferedReader reader = new BufferedReader(isw)
        ) {
            while (reader.ready()) {
                String line = reader.readLine();
                for (char ch : line.toCharArray()) {
                    if (ch == 32) {
                        stringBuilder.append(' ');
                    } else {
                        stringBuilder.append(EncryptUtils.encryptChar(ch, securityKey));
                    }
                }
                stringBuilder.append('\n');
            }
            writeToFile(stringBuilder);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void writeToFile(StringBuilder builder) {
        try (FileOutputStream fos = new FileOutputStream(outputFile);
             OutputStreamWriter osw = new OutputStreamWriter(fos, StandardCharsets.UTF_8);
             BufferedWriter writer = new BufferedWriter(osw)
        ) {
           writer.write(builder.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

