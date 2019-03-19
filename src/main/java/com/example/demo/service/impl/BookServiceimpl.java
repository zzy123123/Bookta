package com.example.demo.service.impl;

import com.example.demo.bean.Book;
import com.example.demo.dao.BookDao;
import com.example.demo.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class BookServiceimpl implements BookService {

    @Autowired
    private BookDao bookDao;

    @Override
    public boolean addBook(Book book) {
        boolean flag=false;
        try{
            bookDao.addBook(book);
            flag=true;
        }catch(Exception e){
            e.printStackTrace();
        }
        return flag;
    }

    @Override
    public boolean updateBook(Book book) {
        boolean flag=false;
        try{
            bookDao.updateBook(book);
            flag=true;
        }catch(Exception e){
            e.printStackTrace();
        }
        return flag;
    }

    @Override
    public boolean deleteBook(String isbn) {
        boolean flag=false;
        try{
            bookDao.deleteBook(isbn);
            flag=true;
        }catch(Exception e){
            e.printStackTrace();
        }
        return flag;
    }

    @Override
    public Book findBookByTitle(String title) {
        return bookDao.findByTitle(title);
    }

    @Override
    public Book findBookByIsbn(String isbn) {
        return bookDao.findByIsbn(isbn);
    }

    @Override
    public List<Book> getAllBook() {
            return bookDao.getAllBook();
    }


}

