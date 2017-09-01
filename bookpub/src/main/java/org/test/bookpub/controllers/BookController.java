/**
 * 
 */
package org.test.bookpub.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.test.bookpub.entity.Book;
import org.test.bookpub.entity.Reviewer;
import org.test.bookpub.repository.BookRespository;

/**
 * @author Shashank
 *
 */
@RestController
@RequestMapping("/books")
public class BookController {
	
	@Autowired
	private BookRespository bookRespository;

	@RequestMapping(value="", method = RequestMethod.GET)
	public Iterable<Book> getAllBooks() {
		
		return bookRespository.findAll();
		
	}
	
	@RequestMapping(value="/{isbn}", method = RequestMethod.GET)
	public Book getBook(@PathVariable Isbn isbn) {
		
		return bookRespository.findBookByIsbn(isbn.getIsbn());
		
	}
	
	@RequestMapping(value="/{isbn}/reviewers", method = RequestMethod.GET)
	public List<Reviewer> getReviewers(@PathVariable("isbn") Book book) {
		System.out.println("In side getReviewers");
		return book.getReviewers();
	}
	
	@InitBinder
	public void initBinder(WebDataBinder webDataBinder) {
		webDataBinder.registerCustomEditor(Isbn.class, new IsbnEditor());
	}
	
}
