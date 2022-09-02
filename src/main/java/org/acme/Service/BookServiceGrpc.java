package org.acme.Service;

import com.google.protobuf.Empty;
import com.google.protobuf.Int32Value;
import io.quarkus.grpc.GrpcService;
import io.smallrye.mutiny.Multi;
import io.smallrye.mutiny.Uni;
import org.acme.Book;
import org.acme.BookService;
import org.acme.Entity.BookEntity;
import org.acme.TempDB;

import java.util.List;
import java.util.stream.Collectors;
//import org.acme.BookServiceGrpc.BookServiceImplBase;

@GrpcService
public class BookServiceGrpc implements BookService
{
    @Override
    public Uni<Book> getBookById(Int32Value request)
    {
       List<BookEntity> bookList= TempDB.bookList.stream().filter(book -> book.getBookId()==request.getValue() ).collect(Collectors.toList());
       Uni<Book> resultBook= (Uni<Book>)(bookList.get(0));
       return resultBook;
    }

    @Override
    public Multi<Book> getAllBooks(Empty request)
    {
        return (Multi<Book>)TempDB.bookList;
    }

//    @Override
//    public void getBookById(Book request, StreamObserver<Book> responseObserver) {
//      ArrayList<org.acme.Entity.Book> bookList= TempDB.BookList;
//    List<org.acme.Entity.Book> b=bookList.stream().filter(book -> book.getBookId()== request.getBookId()).collect(Collectors.toList());
//        super.getBookById(request, responseObserver);
//    }
//
//    @Override
//    public void getAllBooks(Book request, StreamObserver<Book> responseObserver) {
//        super.getAllBooks(request, responseObserver);
//    }
    public org.acme.Entity.BookEntity convert(Book book)
    {
        org.acme.Entity.BookEntity newBook=new org.acme.Entity.BookEntity();
        newBook.setBookId(book.getBookId());
        newBook.setAuthorId(book.getAuthorId());
        newBook.setPages(book.getPages());
        newBook.setTitle(book.getTitle());
        newBook.setPrice(book.getPrice());
        return newBook;
    }

//To Do
//    public Book convertReverse(BookEntity entity)
//    {
//        Book newBook=new Book();
//        newBook.setBookId(entity.getBookId());
//        newBook.setAuthorId(entity.getAuthorId());
//        newBook.setPages(entity.getPages());
//        newBook.setTitle(entity.getTitle());
//        newBook.setPrice(entity.getPrice());
//        return newBook;
//    }
}
