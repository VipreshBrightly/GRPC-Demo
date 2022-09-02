package org.acme.Entity;

public class Book
{
    int bookId;
    String title;
    float price;
    int pages;
    int authorId;

    public Book(){}
    public Book(int bookId, String title, float price, int pages, int authorId) {
        this.bookId = bookId;
        this.title = title;
        this.price = price;
        this.pages = pages;
        this.authorId = authorId;
    }

    public int getBookId() {
        return bookId;
    }

    public String getTitle() {
        return title;
    }

    public float getPrice() {
        return price;
    }

    public int getPages() {
        return pages;
    }

    public int getAuthorId() {
        return authorId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookId=" + bookId +
                ", title='" + title + '\'' +
                ", price=" + price +
                ", pages=" + pages +
                ", authorId=" + authorId +
                '}';
    }
}
