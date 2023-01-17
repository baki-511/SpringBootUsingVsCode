package com.api.book.bootrestbook.dao;

import org.springframework.data.repository.CrudRepository;

import com.api.book.bootrestbook.Model.Book;

public interface BookRepository extends CrudRepository<Book,Integer> {
    public Book findById(int id);
}
