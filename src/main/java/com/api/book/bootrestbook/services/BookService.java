package com.api.book.bootrestbook.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.book.bootrestbook.Model.Book;
import com.api.book.bootrestbook.dao.BookRepository;
@Service
public class BookService {
	@Autowired
    private BookRepository bookRepository;
    // private static List<Book> list = new ArrayList<Book>();

    // static{
    //     list.add(new Book(23,"java complete reference","John Cena"));
    //     list.add(new Book(34,"Python frameworkd","Leena Arora"));
    //     list.add(new Book(59,"C language","Sir Arthur kanon"));
    //     list.add(new Book(75,"complete web developement","Surendra Pal"));
    // }
    //Get all books
    public List<Book> getAllBooks(){
       List<Book> list=(List<Book>) this.bookRepository.findAll();
        return list;
    }
    //Get particular book by Id
    public Book getBookById(int id){
        Book book=null;
        // list.stream().filter(e->e.getId()==id).findFirst().get();
        // for(Book b: list){
        //     if(b.getId()==id){
        //         return b;
        //     }
        // }
        try {
            book = this.bookRepository.findById(id);
        } catch (Exception e) {
            
            e.printStackTrace();
        }
        return book;
    }
    //add book in the list
    public Book addBook(Book b){
        Book result= bookRepository.save(b);
        return result;
    }
    //delete book by its id
    public void deleBook(int id){
        // list=list.stream().filter(book->book.getId()!=id).collect(Collectors.toList());
        bookRepository.deleteById(id);
    }
    //update book by its id
    public void updateBook(Book book, int bookId){
        // list=list.stream().map(b->{
        //    if(b.getId()==bookId){
        //         b.setTitle(book.getTitle());
        //         b.setAuthor(book.getAuthor());
        //    }
        //     return b;
        // }).collect(Collectors.toList());
        book.setId(bookId);
        bookRepository.save(book);
    }
    //delete all
    public void deleteAll(){
        bookRepository.deleteAll();
    }
}
