package com.example.demo.bean;

public class Book {
    private String isbn;
    private String title;
    private String type;
    private double price;

    public Book() {
    }
    public String getIsbn() {
        return isbn;
    }

    public double getPrice() {
        return price;
    }

    public String getTitle() {
        return title;
    }

    public String getType() {
        return type;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Book(String isbn, String title, String type, double price){
        this.isbn=isbn;
        this.title=title;
        this.type=type;
        this.price=price;
    }
    public String toString(){
        return "isbn: "+isbn+"<br>"+
                "title: "+title+"<br>"+
                "type: "+type+"<br>"+
                "price: "+price+"<br><br>";
    }

}