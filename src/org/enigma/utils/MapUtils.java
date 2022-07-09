package org.enigma.utils;

import java.util.HashMap;
import java.util.Map;

public class MapUtils {

    private MapUtils() {
    }

    public static final Map<Character, Integer> encryptMap = new HashMap<>();
    public static final Map<Integer, Character> decryptMap = new HashMap<>();

    static {
        encryptMap.put('а', 0);
        encryptMap.put('б', 1);
        encryptMap.put('в', 2);
        encryptMap.put('г', 3);
        encryptMap.put('д', 4);
        encryptMap.put('е', 5);
        encryptMap.put('ё', 6);
        encryptMap.put('ж', 7);
        encryptMap.put('з', 8);
        encryptMap.put('и', 9);
        encryptMap.put('й', 10);
        encryptMap.put('к', 11);
        encryptMap.put('л', 12);
        encryptMap.put('м', 13);
        encryptMap.put('н', 14);
        encryptMap.put('о', 15);
        encryptMap.put('п', 16);
        encryptMap.put('р', 17);
        encryptMap.put('с', 18);
        encryptMap.put('т', 19);
        encryptMap.put('у', 20);
        encryptMap.put('ф', 21);
        encryptMap.put('х', 22);
        encryptMap.put('ц', 23);
        encryptMap.put('ч', 24);
        encryptMap.put('ш', 25);
        encryptMap.put('щ', 26);
        encryptMap.put('ъ', 27);
        encryptMap.put('ы', 28);
        encryptMap.put('ь', 29);
        encryptMap.put('э', 30);
        encryptMap.put('ю', 31);
        encryptMap.put('я', 32);

        decryptMap.put(0, 'а');
        decryptMap.put(1, 'б');
        decryptMap.put(2, 'в');
        decryptMap.put(3, 'г');
        decryptMap.put(4, 'д');
        decryptMap.put(5, 'е');
        decryptMap.put(6, 'ё');
        decryptMap.put(7, 'ж');
        decryptMap.put(8, 'з');
        decryptMap.put(9, 'и');
        decryptMap.put(10, 'й');
        decryptMap.put(11, 'к');
        decryptMap.put(12, 'л');
        decryptMap.put(13, 'м');
        decryptMap.put(14, 'н');
        decryptMap.put(15, 'о');
        decryptMap.put(16, 'п');
        decryptMap.put(17, 'р');
        decryptMap.put(18, 'с');
        decryptMap.put(19, 'т');
        decryptMap.put(20, 'у');
        decryptMap.put(21, 'ф');
        decryptMap.put(22, 'х');
        decryptMap.put(23, 'ц');
        decryptMap.put(24, 'ч');
        decryptMap.put(25, 'ш');
        decryptMap.put(26, 'щ');
        decryptMap.put(27, 'ъ');
        decryptMap.put(28, 'ы');
        decryptMap.put(29, 'ь');
        decryptMap.put(30, 'э');
        decryptMap.put(31, 'ю');
        decryptMap.put(32, 'я');
    }
}
