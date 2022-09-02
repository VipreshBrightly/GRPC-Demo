package org.acme.Service;

import io.grpc.stub.StreamObserver;
import io.quarkus.grpc.GrpcService;
import org.acme.Book;
import org.acme.BookServiceGrpc;
import org.acme.TempDB;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
//import org.acme.BookServiceGrpc.BookServiceImplBase;

@GrpcService
public class BookService extends BookServiceGrpc.BookServiceImplBase
{
    @Override
    public void getBookById(Book request, StreamObserver<Book> responseObserver) {
      ArrayList<org.acme.Entity.Book> bookList= TempDB.BookList;
    List<org.acme.Entity.Book> b=bookList.stream().filter(book -> book.getBookId()== request.getBookId()).collect(Collectors.toList());
        super.getBookById(request, responseObserver);
    }

    @Override
    public void getAllBooks(Book request, StreamObserver<Book> responseObserver) {
        super.getAllBooks(request, responseObserver);
    }
    public org.acme.Entity.Book convert(Book book)
    {
        org.acme.Entity.Book newBook=new org.acme.Entity.Book();
        newBook.setBookId(book.getBookId());
        newBook.setAuthorId(book.getAuthorId());
        newBook.setPages(book.getPages());
        newBook.setTitle(book.getTitle());
        newBook.setPrice(book.getPrice());
        return newBook;
    }
}
