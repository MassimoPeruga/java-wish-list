package org.learning.collections.bonus;

import java.util.HashMap;
import java.util.Scanner;

public class CharCounter {
    public static void main(String[] args) {
        System.out.print("Insersisci una parola: ");
        Scanner scanner = new Scanner(System.in);
        String word = scanner.nextLine().trim().toLowerCase();
        char[] characters = word.toCharArray();

        HashMap<Character, Integer> counter = new HashMap<>();
        for (char c : characters){
            counter.put(c, counter.containsKey(c) ? counter.get(c) + 1 : 1);
        }
        System.out.println(word + ": " + counter);

        scanner.close();
    }
}