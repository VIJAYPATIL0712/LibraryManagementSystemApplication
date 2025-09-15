package project.demo.libraryManagementSystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import project.demo.libraryManagementSystem.entity.Book;
import project.demo.libraryManagementSystem.service.BookService;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {

	@Autowired
	private BookService bookService;

	
	//Book Insertion
	@PostMapping("/insert")
	protected ResponseEntity<Book> addBook(@RequestBody Book book) {
		Book bookAdded  = bookService.addBook(book);
		return new ResponseEntity<Book>(bookAdded  , HttpStatus.CREATED);
	}
	 
	//Book Updation
	@PutMapping("/update/{id}")
	protected ResponseEntity<Book> updateBook(@PathVariable int id, @RequestBody Book book) {
		return bookService.updateBook(id, book).map(updatedBook -> new ResponseEntity<>(updatedBook, HttpStatus.OK)) // Return 200 OK if updated
		        .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}

	//Book Deletion
	@DeleteMapping("/delete")
	protected ResponseEntity<String> deleteCategory(@RequestParam int id) {
		boolean deleteBook = bookService.deleteBook(id);
		if(deleteBook) {
			return new ResponseEntity<String>("Deleted Successfully" , HttpStatus.OK);
		}else {
			return new ResponseEntity<String>("Deletion Failed" , HttpStatus.OK);
		}
		
	}

	//Find By Id
	@GetMapping("/findById")
	protected Book findBookById(@RequestParam int id){
		return bookService.findBookById(id);
	}

	//Find By Title
	@GetMapping("/findByTitle")
	protected Book findBookByTitle(@RequestParam String title){
		return bookService.findBookByTitle(title);
	}

	//Find All
//	@GetMapping("/findAll")
//	protected ResponseEntity<List<Book>> findAll(){
//		List<Book> allBooks = bookService.findAll();
//		return new ResponseEntity<List<Book>>(allBooks , HttpStatus.OK);
//	}
}
 