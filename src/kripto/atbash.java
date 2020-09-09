/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kripto;

import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author Radif
 */
class atbash {
    private static final int GROUP_SIZE = 5;
    private static final String PLAIN = "abcdefghijklmnopqrstuvwxyz";
    private static final String CIPHER = "zyxwvutsrqponmlkjihgfedcba";

    String encode(String input) {
        String encoded = stripInvalidCharacters(input).toLowerCase();
        StringBuilder cyphered = new StringBuilder(input.length());

        for (char c : encoded.toCharArray()) {
            cyphered.append(applyCipher(c));
        }

        return splitIntoFiveLetterWords(cyphered.toString());
    }

    String decode(String input) {
        String encoded = stripInvalidCharacters(input).toLowerCase();
        StringBuilder deciphered = new StringBuilder(input.length());

        for (char c : encoded.toCharArray()) {
            deciphered.append(applyCipher(c));
        }

        return deciphered.toString();
    }

    private String stripInvalidCharacters(String input) {
        return input.replaceAll("\\W", "");
    }

    private char applyCipher(char input) {
        int idx = PLAIN.indexOf(input);

        return idx >= 0 ? CIPHER.toCharArray()[idx] : input;
    }

    private String splitIntoFiveLetterWords(String value) {
        List<String> words = new ArrayList<>();

        for (int i = 0; i < value.length(); i += GROUP_SIZE) {
            words.add(value.substring(i, Math.min(value.length(), i + GROUP_SIZE)));
        }

        return String.join(" ", words);
}
}
