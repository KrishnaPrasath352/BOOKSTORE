package com.bookstore.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bookstore.demo.entity.MyBookList;

@Repository
public interface MyBookListRepo extends JpaRepository<MyBookList,Integer>{
	
	
}
