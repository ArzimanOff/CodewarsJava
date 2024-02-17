/*
https://www.codewars.com/kata/5375f921003bf62192000746/train/java
 */

package com.codewars.arziman_off.kuy6;

import java.util.Arrays;

public class Abbreviator {
    public static String[] splitString(String line) {
        // Используем регулярное выражение для разделения строки
        // \\s+ - это пробел, \\- - это дефис
        return line.split("[\\-\\s]+");
    }

    public static String abbreviate(String string) {
        System.out.println(string);
        StringBuilder ansString = new StringBuilder();
        String updatedString = updateString(string);
        System.out.println(updatedString);
        String[] wordsList = splitString(updatedString);
        for (String word : wordsList){
            ansString.append(abbreviateWord(word)).append(" ");
        }
        return ansString.toString().trim();
    }

    public static String abbreviateWord(String word) {
        StringBuilder ansString = new StringBuilder();
        char[] charsArray = word.toCharArray();

        if (countLetters(word) >= 4){
            ansString.append(charsArray[0]); // первый символ
            ansString.append(charsArray.length - 2); // кол-во символов между 1-ым и последним символом
            ansString.append(charsArray[charsArray.length - 1]); // последний символ
        } else {
            ansString.append(new String(charsArray));
        }

        return ansString.toString();
    }

    public static String updateString(String string) {
        char[] charArr = string.toCharArray();
        StringBuilder newString = new StringBuilder();
        for (char ch : charArr){
            if (Character.getType(ch) == Character.OTHER_PUNCTUATION){
                newString.append(" ");
            }
            newString.append(ch);
        }
        return newString.toString();
    }

    public static int countLetters(String input) {
        int letterCount = 0;

        for (int i = 0; i < input.length(); i++) {
            if (Character.isLetter(input.charAt(i))) {
                letterCount++;
            }
        }

        return letterCount;
    }

    public static void main(String[] args) {
        System.out.println(abbreviate("elephant-rides are, really fun!"));
    }
}

