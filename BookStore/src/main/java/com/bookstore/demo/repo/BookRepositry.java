package com.bookstore.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bookstore.demo.entity.Book;

@Repository
public interface BookRepositry extends JpaRepository<Book,Integer>{

}
