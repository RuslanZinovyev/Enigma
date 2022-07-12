package org.enigma.service;

import static org.enigma.utils.MapUtils.decryptMap;
import static org.enigma.utils.MapUtils.encryptMap;

public class Encryptor implements Operation {
    private int securityKey;

    public Encryptor(int securityKey) {
        this.securityKey = securityKey;
    }

    @Override
    public char execute(char symbol) {
        if (encryptMap.get(Character.toLowerCase(symbol)) != null) {
            if (Character.isUpperCase(symbol)) {
                int index = encryptMap.get(Character.toLowerCase(symbol));
                int shift = (index + securityKey) % encryptMap.size();
                return Character.toUpperCase(decryptMap.get(shift));
            }
            int index = encryptMap.get(symbol);
            int shift = (index + securityKey) % encryptMap.size();
            return decryptMap.get(shift);
        }
        return symbol;
    }
}
