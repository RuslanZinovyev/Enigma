package org.enigma.io;

import org.enigma.options.Mode;
import org.enigma.utils.EncryptUtils;

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

    public void executeAndSaveToFile(Mode mode, int securityKey) {
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
                        switch (mode) {
                            case ENCRYPT -> stringBuilder.append(EncryptUtils.encryptChar(ch, securityKey));
                            case DECRYPT -> stringBuilder.append(EncryptUtils.decryptChar(ch, securityKey));
                        }
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

