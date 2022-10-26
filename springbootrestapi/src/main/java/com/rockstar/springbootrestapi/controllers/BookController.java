package com.rockstar.springbootrestapi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rockstar.springbootrestapi.entities.Book;
import com.rockstar.springbootrestapi.services.BookService;

@RestController
public class BookController {
    
    // @RequestMapping(value="/books", method=RequestMethod.GET) // We have @GetMapping https method particulary for Get Method 
    // @ResponseBody // If we'll use RestController instead of Contoller, RsponseBody not required.
    @Autowired
    private BookService bookService;

    @GetMapping("/books")
    public List<Book> getBooks(){
        

        return this.bookService.getAllBooks();
    }
    
    @GetMapping("/books/{id}")
    public Book getBookById(@PathVariable("id") int id){

        return bookService.getBookById(id);
    }
}
