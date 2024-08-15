package com.bookstore.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookstore.demo.entity.Book;
import com.bookstore.demo.repo.BookRepositry;

@Service
public class BookService {
	
	@Autowired
	private BookRepositry repo;
	public void save(Book b) {
		repo.save(b);
	}
	
	public List<Book> getAllBook(){
		return repo.findAll();
	}
	
	public Book getBookById(int id) {
		return repo.findById(id).get();
	}
	
	public void deletebyId(int id) {
		repo.deleteById(id);
	}
}
