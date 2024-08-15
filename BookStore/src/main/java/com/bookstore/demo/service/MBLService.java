package com.bookstore.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookstore.demo.entity.MyBookList;
import com.bookstore.demo.repo.MyBookListRepo;

@Service
public class MBLService {
	
	@Autowired
	private MyBookListRepo mbrepo;
	
	public void saveMyBook(MyBookList mbl) {
		mbrepo.save(mbl);
	}
	
	public List<MyBookList> getAllMyBooks(){
		List<MyBookList> list=mbrepo.findAll();
		return list;
	}
	
	public void deleteList(int id) {
		mbrepo.deleteById(id);
	}
}
