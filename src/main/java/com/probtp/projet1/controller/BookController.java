package com.probtp.projet1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.probtp.projet1.model.Book;
import com.probtp.projet1.service.BookService;


@RestController
@RequestMapping("/books")
public class BookController {

	@Autowired
	private BookService bookService;
	
	@GetMapping("")
	public List<Book> getAllBooks() {
		return bookService.getAllBooks();
	}
	
	@GetMapping("/{id}")
	public Book getBookById(@PathVariable int id) throws ResponseStatusException {
		Book b = bookService.getBookById(id);
		if(b == null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Ressource not found");
			//throw new ResponseStatusException(HttpStatusCode.valueOf(404), "Ressource not found");
		}
		return b; //ResponseEntity.ok(b)
	}
	
	
	@DeleteMapping("/{id}")
	public void deleteBook(@PathVariable int id) {
		bookService.deleteBook(id);
	}
	
	@PostMapping("")
	public ResponseEntity<Integer> insertBook(@RequestBody Book b) {
		Book bNew = bookService.insertBook(b);
		return ResponseEntity
				.status(HttpStatus.CREATED)
				.body(bNew.getId());
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Integer> updateBook(@PathVariable int id, @RequestBody Book b) {
		Book bUpdate = bookService.updateBook(b, id);
		return ResponseEntity
				.status(HttpStatus.NO_CONTENT)
				.body(bUpdate.getId());
	}
	
	
	
}
