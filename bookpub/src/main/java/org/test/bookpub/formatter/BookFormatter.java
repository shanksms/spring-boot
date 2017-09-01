/**
 * 
 */
package org.test.bookpub.formatter;

import java.text.ParseException;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.test.bookpub.entity.Book;
import org.test.bookpub.repository.BookRespository;

/**
 * @author Shashank
 *
 */
public class BookFormatter implements Formatter<Book> {
	
	
	private BookRespository bookRepository;
	

	public BookFormatter(BookRespository bookRepository) {
		super();
		this.bookRepository = bookRepository;
	}


	@Override
	public String print(Book book, Locale locale) {
		// TODO Auto-generated method stub
		
		return book.getIsbn();
	}

	@Override
	public Book parse(String isbn, Locale locale) throws ParseException {
		System.out.println("in parse method");
		// TODO Auto-generated method stub
		return bookRepository.findBookByIsbn(isbn);
	
	}
	

}
