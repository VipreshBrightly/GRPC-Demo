package org.acme;

import org.acme.Entity.Book;

import java.util.ArrayList;

public class TempDB
{
    public static ArrayList<Book> BookList= new ArrayList<>();
    {
        BookList.add(new org.acme.Entity.Book(1,"oliver twist",100.0f,100,1));
        BookList.add(new org.acme.Entity.Book(2,"oliver",200.0f,200,2));
    }
}
