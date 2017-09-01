/**
 * 
 */
package org.test.bookpub.repository;


import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.test.bookpub.entity.Book;
import org.test.bookpub.entity.Reviewer;

/**
 * @author Shashank
 *
 */
public interface BookRespository extends CrudRepository<Book, Long>{
	
	
	
	Book findBookByIsbn(String isbn);

}
