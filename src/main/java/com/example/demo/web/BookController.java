package com.example.demo.web;

import com.example.demo.service.BookService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.bean.Book;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequestMapping(value = "/book")
public class BookController {
    @Autowired
    private BookService bookService;

    @RequestMapping("hello")
    public String hello(){
        return "Hello World";
    }

    @RequestMapping(value = "/addBook", method = RequestMethod.POST)
    public boolean addBook( Book book) {
        System.out.println("开始新增...");
        return bookService.addBook(book);
    }
    @RequestMapping(value = "/updateBook", method = RequestMethod.PUT)
    public boolean updateUser(Book book) {
        System.out.println("开始更新...");
        return bookService.updateBook(book);
    }

    @RequestMapping(value = "/deleteBook", method = RequestMethod.DELETE)
    public boolean delete(@RequestParam(value = "isbn", required = true) String isbn) {
        System.out.println("开始删除...");
        return bookService.deleteBook(isbn);
    }

    @RequestMapping(value = "/title", method = RequestMethod.GET)
    public Book findByBookTitle(@RequestParam(value = "title", required = true) String title) {
        System.out.println("开始查询...");
        return bookService.findBookByTitle(title);
    }

    @RequestMapping(value = "/isbn", method = RequestMethod.GET)
    public Book findByBookId(@RequestParam(value = "isbn", required = true) String isbn) {
        System.out.println("开始查询...");
        return bookService.findBookByIsbn(isbn);
    }



    ///查询所有书籍
    @RequestMapping(value = "/all",method = RequestMethod.GET)
    public ModelAndView getAllBook(Model model, @RequestParam(defaultValue = "1",value = "pageNum") Integer pageNum){
        PageHelper.startPage(pageNum,5);
        List<Book> list = bookService.getAllBook();
        PageInfo<Book> pageInfo = new PageInfo<Book>(list);
        model.addAttribute("pageInfo",pageInfo);
        return new ModelAndView ("list");
    }
}

