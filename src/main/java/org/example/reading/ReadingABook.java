package org.example.reading;

import java.util.ArrayList;
import java.util.List;

public class ReadingABook {
    private static List<String> books = new ArrayList<>();

    public static void printBooks(){
        populateList();
        for (int i = 0; i < books.size(); i++) {
            System.out.println((i+1) + ": " + books.get(i));
        }
    }
    private static void populateList(){
        String book1 = "Brandon Sanderson - The well of Ascension";
        String book2 = "Louise Penny - Still Life";
        String book3 = "Diana Wynne Jones - Charmed Life";
        String book4 = "Diana Wynne Jones - Castle in the Air";
        String book5 = "Endou Tatsuya - Spy x Family";
        String book6 = "Kusanagi Mizuho - Yona of the Dawn";
        String book7 = "Noda Satoru - Golden Kamui";

        books.add(book1);
        books.add(book2);
        books.add(book3);
        books.add(book4);
        books.add(book5);
        books.add(book6);
        books.add(book6);
        books.add(book7);
    }

    public static int getSize(){
        populateList();
        return books.size();
    }

    public static List<String> getList(){
        populateList();
        return books;
    }

}
