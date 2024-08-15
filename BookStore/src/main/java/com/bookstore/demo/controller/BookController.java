package com.bookstore.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.bookstore.demo.entity.Book;
import com.bookstore.demo.entity.MyBookList;
import com.bookstore.demo.service.BookService;
import com.bookstore.demo.service.MBLService;

@Controller
public class BookController {
	
	@Autowired
	private BookService service;
	
	@Autowired
	private MBLService mbservice;
	
	@GetMapping("/")
	public String home() {
		return "home";
	}
	@GetMapping("/RegBook")
	public String RegBook() {
		return "RegBook";
	}
	@GetMapping("/BookAvaible")
	public ModelAndView BookAvaible() {
		List<Book> list=service.getAllBook();
		return new ModelAndView("BookAvaible","book",list);
	}
	
	@PostMapping("/save")
	public String addBook(@ModelAttribute Book b) {
		service.save(b);
		return "redirect:/BookAvaible";
	}
	
	@GetMapping("/mybook")
	public String myBook(Model model) {
		List<MyBookList> list=mbservice.getAllMyBooks();
		model.addAttribute("book",list);
		return "MyBook";
	}
	
	@RequestMapping("/mylist/{id}")
	public String getMyList(@PathVariable("id") int id) {
		Book b=service.getBookById(id);
		MyBookList mb=new MyBookList(b.getId(),b.getName(),b.getAuthor(),b.getPrice());
		mbservice.saveMyBook(mb);
		return "redirect:/mybook";
	}
	
	@RequestMapping("/editbook/{id}")
	
	public String BookEdit(@PathVariable("id") int id,Model model) {
		Book b=service.getBookById(id);
		model.addAttribute("book", b);
		return "EditBook";
	}
	
	@RequestMapping("/deletebook/{id}")
	
	public String deleteBook(@PathVariable("id") int id) {
		service.deletebyId(id);
		return "redirect:/BookAvaible";
	}
}
