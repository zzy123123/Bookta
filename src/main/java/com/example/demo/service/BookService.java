package com.example.demo.service;

import com.example.demo.bean.Book;

import java.util.List;

public interface BookService {
    /**
     * 新增图书
     * @param book
     * @return
     */
    boolean addBook(Book book);

    /**
     * 修改图书
     * @param book
     * @return
     */
    boolean updateBook(Book book);


    /**
     * 删除图书
     * @param isbn
     * @return
     */
    boolean deleteBook(String isbn);

    /**
     * 根据图书名字查询图书信息
     * @param title
     */
    Book findBookByTitle(String title);

    /**
     * 根据图书书号查询用户信息
     * @param isbn
     */
    Book findBookByIsbn(String isbn);



    /**
     * 查询所有图书信息
     */
    public List<Book> getAllBook();


}
