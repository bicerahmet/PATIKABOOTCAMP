package Sorter.company;

public class Book implements Comparable<Book>{
    private String bookName;
    private int pageCount;
    private String authorName;
    private int releaseDate;

    public Book(String bookName, int pageCount, String authorName, int releaseDate) {
        this.bookName = bookName;
        this.pageCount = pageCount;
        this.authorName = authorName;
        this.releaseDate = releaseDate;
    }

    public String getBookName() {
        return bookName;
    }

    public int getPageCount() {
        return pageCount;
    }
    
    @Override
    public int compareTo(Book o) {
        return compareBookName(this,o);
    }

    public int compareBookName(Book o1, Book o2) {
        return o1.getBookName().compareTo(o2.getBookName());
    }

}
