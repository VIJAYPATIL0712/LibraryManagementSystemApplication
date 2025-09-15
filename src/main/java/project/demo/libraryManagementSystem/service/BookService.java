package project.demo.libraryManagementSystem.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.demo.libraryManagementSystem.entity.Book;
import project.demo.libraryManagementSystem.repo.BookRepo;

@Service
public class BookService {

	@Autowired
	private BookRepo bookRepo;


	public Book addBook(Book book) {
        return bookRepo.save(book);
		
	}

	public Optional<Book> updateBook(int id,Book book) {
		 return bookRepo.findById(id)
			        .map(existingBook -> {
			        	existingBook.setTitle(book.getTitle()); // Update fields as needed
			        	existingBook.setAuthor(book.getAuthor());
			        	existingBook.setCopyAvailable(book.getCopyAvailable());
			            return bookRepo.save(existingBook);		
			        });
	}

	public boolean deleteBook(int id) {
		if (bookRepo.existsById(id)) {
			bookRepo.deleteById(id);
	        return true;
	    }
	    return false;
	}

	public Book findBookById(int id) {
		return bookRepo.findBookById(id);
	}

	public List<Book> findAll() {
		return bookRepo.findAll();
	}

	public Book findBookByTitle(String title) {
		return bookRepo.findBookByTitle(title);
	}
}
  