package com.example.demo.dao;

import org.apache.ibatis.annotations.*;
import org.springframework.data.repository.query.Param;
import com.example.demo.bean.Book;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
    @Repository
    public interface BookDao {

            /**
         *  图书数据新增
         */
        @Insert("insert into bookta(isbn,title,type,price) values (#{isbn},#{title},#{type},#{price})")
        void addBook(Book book);

        /**
         * 图书数据修改
         */
        @Update("update bookta set title=#{title},type=#{type},price=#{price} where isbn=#{isbn}")
        void updateBook(Book book);

        /**
         * 图书数据删除
         */
        @Delete("delete from bookta where isbn=#{isbn}")
        void deleteBook(String isbn);

        /**
         * 根据图书名称查询用户信息
         *
         */
        @Select("SELECT isbn,title,type,price FROM bookta where title=#{title}")
        Book findByTitle(@Param("title") String title);

        /**
         * 根据图书书号查询用户信息
         *
         */
        @Select("SELECT isbn,title,type,price FROM bookta where isbn=#{isbn}")
        Book findByIsbn(@Param("isbn") String isbn);



        //查询所有书籍
         @Select("select * from bookta")
         public List<Book> getAllBook();
    }

