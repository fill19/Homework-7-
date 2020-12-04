package com.Cursor.java;


import java.util.HashMap;

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Write down some text: ");
        String someText = scan.nextLine();

        firstTask letters = new firstTask(someText);
        HashMap texts = letters.getOccurrenceOfText();
        System.out.println(texts);
        System.out.println("\nAll letters: " + letters.allLetters());
        System.out.println("\nDigit numbers: " + letters.digitOfNumbers() );
        System.out.println("\nPunctuation marks: " + letters.punctuationMark());
    }
}

class firstTask {
    private String someText;
    private HashMap<String, Integer> letters = new HashMap<>();

    public firstTask(String someText) {
        this.someText = someText;
        occurrenceOfText();
    }

    private void occurrenceOfText() {
        for (int i = 0; i < someText.length(); i++) {
            char occurrence = someText.toLowerCase().charAt(i);
            String words = Character.toString(occurrence);
            if (letters.containsKey(words)) {
                int counter = letters.get(words);
                counter++;
                letters.replace(words, counter);
            } else {
                letters.put(words, 1);
            }
        }
    }

    public HashMap getOccurrenceOfText() {
        return letters;
    }

    public int allLetters() {
        int counter = 0;
        for (int i = 0; i < someText.length(); i++) {
            if (Character.isLetter(someText.charAt(i)))
                counter++;
        }
        return counter;
    }

    public int digitOfNumbers() {
        int counter = 0;
        for (int i = 0; i < someText.length(); i++) {
            if (Character.isDigit(someText.charAt(i)))
                counter++;
        }
        return counter;
    }

    public int punctuationMark() {
        int counter = 0;
        String marks = ".,;:!?";
        for (int i = 0; i < marks.length(); i++) {
            String temp = String.valueOf(marks.charAt(i));
            if (letters.containsKey(temp)) {
                counter ++;
            }
        }
        return counter;
    }
}





