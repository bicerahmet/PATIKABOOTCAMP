import java.util.Date;

public class Book {

    String bookName;
    int numberOfPage;
    String authorName;
    String releaseDate;

    public Book(String bookName, int numberOfPage, String authorName, String releaseDate) {
        this.bookName = bookName;
        this.numberOfPage = numberOfPage;
        this.authorName = authorName;
        this.releaseDate = releaseDate;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public int getNumberOfPage() {
        return numberOfPage;
    }

    public void setNumberOfPage(int numberOfPage) {
        this.numberOfPage = numberOfPage;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getReleaseDate() { return releaseDate; }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }
}
