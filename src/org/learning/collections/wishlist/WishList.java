package org.learning.collections.wishlist;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class WishList {
    public static void main(String[] args) {
        String filePath = "./resources/wishlist.txt";
        Scanner scanner = new Scanner(System.in);

        ArrayList<String> wishlist = fileReader(filePath);

        boolean stop = false;
        String addMore;
        while (!stop) {
            System.out.println("La tua lista contiene " + wishlist.size() + " regali.");
            System.out.print("Vuoi aggiungere un regalo? (y)/(n) ");
            addMore = scanner.nextLine().trim();
            switch (addMore) {
                case "y":
                    try {
                        System.out.print("Regalo da inserire: ");
                        String gift = scanner.nextLine().trim();
                        if (gift.trim().isEmpty()) {
                            throw new IllegalArgumentException("Invalid input. Please try again.");
                        }
                        wishlist.add(gift);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case "n":
                    stop = true;
                    break;

                default:
                    System.out.println("Invalid input. Please try again.");
            }
        }

        Collections.sort(wishlist);
        System.out.println("*******************************");
        System.out.println("La tua lista completa contiene " + wishlist.size() + " regali: " + wishlist);

        System.out.println(wishlist);

        fileWriter(wishlist, filePath);
        scanner.close();
    }

    // Reader
    public static ArrayList<String> fileReader(String filePath) {
        ArrayList<String> wishlist = new ArrayList<>();
        File file = new File(filePath);
        if (file.exists()) {
            try (Scanner fileScanner = new Scanner(file)) {
                while (fileScanner.hasNextLine()) {
                    String line = fileScanner.nextLine().trim();
                    wishlist.add(line);
                }
            } catch (FileNotFoundException e) {
                System.out.println("Errore nella lettura del file: " + filePath + ": " + e.getMessage());
            }
        }
        return wishlist;
    }

    // Writer
    public static void fileWriter(ArrayList<String> wishlist, String filePath){
        try (FileWriter writer = new FileWriter(filePath)) {
            for (String gift : wishlist) {
                writer.write(gift + System.lineSeparator());
            }
            System.out.println("Lista salvata.");
        } catch (IOException e) {
            System.out.println("Errore nel salvataggio della lista: " + e.getMessage());
        }
    }
}