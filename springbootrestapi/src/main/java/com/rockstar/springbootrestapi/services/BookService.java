package com.rockstar.springbootrestapi.services;
// Interact with entities

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.rockstar.springbootrestapi.entities.Book;

@Service
public class BookService {
    
    //Fake Service : Data not coming from DB
    private static List<Book> list = new ArrayList<>();
    
    static {

        list.add(new Book(1, "Do epic shit", "Ankur Warikoo"));
        list.add(new Book(2, "Think and grow rich", "Nepolian Rich"));
        list.add(new Book(3, "5 AM Club", "Robin Sharma"));
    }

    //Get All Books
    public List<Book> getAllBooks(){
        return list;
    }
    
    //get Single Book By Id

    public Book getBookById(int id){

        Book book =list.stream().filter(e->e.getId()==id).findFirst().get();

        return book;
    }

}
