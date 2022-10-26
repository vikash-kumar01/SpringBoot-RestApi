package com.rockstar.springbootrestapi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.rockstar.springbootrestapi.entities.Book;
import com.rockstar.springbootrestapi.services.BookService;

@RestController
public class BookController {
    
    // @RequestMapping(value="/books", method=RequestMethod.GET) // We have @GetMapping https method particulary for Get Method 
    // @ResponseBody // If we'll use RestController instead of Contoller, RsponseBody not required.
    @Autowired
    private BookService bookService;
    
    // Get All Books Handler
    @GetMapping("/books")
    public List<Book> getBooks(){
        

        return this.bookService.getAllBooks();
    }
    
    // Get Single Books Handler
    @GetMapping("/books/{id}")
    public Book getBookById(@PathVariable("id") int id){

        return bookService.getBookById(id);
    }

    // Add a new Books Handler
    @PostMapping("/books") // Handler
    public Book addBook(@RequestBody Book book){  // Convert Data into Book Object
        
        Book b=bookService.addBook(book);
        return b;
    }
 
     // Delete a Books Handler
    @DeleteMapping("/books/{id}")
    public void deleteBook(@PathVariable("id") int bookId){
       
       bookService.deleteBook(bookId);

    }
    // Update a new Books Handler so we'll Use PUT HTTPS METHOD

    @PutMapping("/books/{bookId}")
    public Book updateBook(@RequestBody Book book,@PathVariable("bookId") int bookId){
     
        // @PathVariable("bookId") int bookId : Mapping
       // Since new Book Data is Also coming to update so need ResponseBody to Convert Data into Book Object
        
        bookService.updateBook(book, bookId);
          
        return book;
    }

}
