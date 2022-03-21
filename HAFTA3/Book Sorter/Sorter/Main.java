package Sorter;

import Sorter.company.Book;

import java.util.Comparator;
import java.util.TreeSet;

public class Main {

    public static void main(String[] args) {

        TreeSet<Book> books = new TreeSet<>();

        books.add(new Book("Dorian Gray'in Portresi",252,"Oscar Wilde",1890));
        books.add(new Book("Yer Altından Notlar",150,"Dostoyevski",1864));
        books.add(new Book("Sefiller",533,"Victor Hugo",1862));
        books.add(new Book("Momo",290,"Michael Ende",1973));
        books.add(new Book("Semerkant",310, "Amin Maalouf", 1988));

        System.out.println("İsimlerine göre sıralı: ");

        for (Book book : books){
            System.out.println(book.getBookName()+ " kitabı " +book.getPageCount() + " sayfadır.");
        }

        System.out.println("------------------------------------------");

        TreeSet<Book> secondBooks = new TreeSet<>(new Comparator<Book>() {
            @Override
            public int compare(Book o1, Book o2) {
                return o1.getPageCount() - o2.getPageCount();
            }
        });


        secondBooks.add(new Book("Dorian Gray'in Portresi",252,"Oscar Wilde",1890));
        secondBooks.add(new Book("Yer Altından Notlar",150,"Dostoyevski",1864));
        secondBooks.add(new Book("Sefiller",533,"Victor Hugo",1862));
        secondBooks.add(new Book("Momo",290,"Michael Ende",1973));
        secondBooks.add(new Book("Semerkant",310, "Amin Maalouf", 1988));

        System.out.println("Sayfa sayılarına göre sıralı: ");

        for (Book book : secondBooks){
            System.out.println(book.getBookName()+ " kitabı " +book.getPageCount() + " sayfadır.");
        }


    }
}
