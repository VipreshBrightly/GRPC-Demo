package org.acme;

import org.acme.Entity.BookEntity;

import java.util.ArrayList;

public class TempDB
{
    public static ArrayList<BookEntity> bookList= new ArrayList<>();
    {
        bookList.add(new org.acme.Entity.BookEntity(1,"oliver twist",100.0f,100,1));
        bookList.add(new org.acme.Entity.BookEntity(2,"oliver",200.0f,200,2));
    }
}
