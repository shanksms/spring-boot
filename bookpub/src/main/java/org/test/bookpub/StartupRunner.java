/**
 * 
 */
package org.test.bookpub;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.test.bookpub.entity.Author;
import org.test.bookpub.entity.Book;
import org.test.bookpub.entity.Publisher;
import org.test.bookpub.repository.AuthorRespository;
import org.test.bookpub.repository.BookRespository;
import org.test.bookpub.repository.PublisherRepository;

/**
 * @author Shashank
 *
 */
public class StartupRunner implements CommandLineRunner{

	@Autowired
	private BookRespository bookRespository; 
	@Autowired
	private AuthorRespository authorRepository;
	@Autowired
	private PublisherRepository publisherRepository;
	
	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		Author author = new Author("Alex", "Antonov");
		author = authorRepository.save(author);
		
		Publisher publisher = new Publisher("Packt");
		publisherRepository.save(publisher);
		
		Book book = new Book("978-1-78528-415-1", "Spring Boot Recipies", null, author, publisher, null);
		bookRespository.save(book);
		
	}
	
	/*
	@Scheduled(initialDelay=1000, fixedRate=10000)
	public void run() {
		System.out.println("Number of Books " + bookRespository.count());

	}*/
}
