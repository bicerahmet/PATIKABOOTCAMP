import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class main {

    public static void main(String[] args) {



        //Our arraylist that consist of 10 book and related informations.
        ArrayList<Book> Books = new ArrayList<>();

        Book b1 = new Book("Yeşil Zambaklar Ülkesi", 170, "George Olsenn", "10-05-1990");
        Book b2 = new Book("Alamut", 65, "Bartol", "05-09-1999");
        Book b3 = new Book("Palamut", 450, "Ziyarov", "14-05-1609");
        Book b4 = new Book("Fareler ve İnsanlar", 1230, "Heung Min Son", "08-08-1952");
        Book b5 = new Book("Fareler", 670, "Heung", "01-01-1892");
        Book b6 = new Book("İnsanlar", 4266, "Son", "10-12-1789");
        Book b7 = new Book("Sefils", 1200, "Victor Hugo", "16-02-1888");
        Book b8 = new Book("Milena", 310, "Franz Kafka", "30-08-1597");
        Book b9 = new Book("Dava", 700, "Franz Kafka", "22-02-1599");
        Book b10 = new Book("Selvi Boylum", 1400, "Cengiz Aytmatov", "11-11-1999");

        Books.add(b1);
        Books.add(b2);
        Books.add(b3);
        Books.add(b4);
        Books.add(b5);
        Books.add(b6);
        Books.add(b7);
        Books.add(b8);
        Books.add(b9);
        Books.add(b10);


        //Mapping the author names and book names so that someone who wants to reach the author of the book can find it easily by knowing the name of the book only
        Map<String, String> booksAndAuthors = new HashMap<>();
        Books.stream().forEach(book -> booksAndAuthors.put(book.getBookName(), book.getAuthorName()));

        //The Author of the "Dava" is the Franz Kafka, so rthat's the result
        System.out.println(booksAndAuthors.get("Dava"));


        List<Book> newBooks = new ArrayList<>();
        Books.stream().filter(book -> book.getNumberOfPage() > 100).forEach(book -> newBooks.add(book));

        //Only the number of the page of "Alamut" is less than 100, so result is 9.
        System.out.println(newBooks.size());

    }

}
