package project.demo.libraryManagementSystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import project.demo.libraryManagementSystem.entity.Category;
import project.demo.libraryManagementSystem.service.CategoryService;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {

	@Autowired
	private CategoryService categoryService;
	
	@PostMapping(path = "/insert")
	protected ResponseEntity<Category> addCategory(@RequestBody Category category) {
		Category catAdded = categoryService.addCategory(category);
		return new ResponseEntity<Category>(catAdded , HttpStatus.CREATED);
	}
	
	@PutMapping("/update/{id}") // Use PathVariable for ID
	protected ResponseEntity<Category> updateCategory(@PathVariable int id, @RequestBody Category category) {
	    return categoryService.updtCategory(id, category)
	        .map(updatedCategory -> new ResponseEntity<>(updatedCategory, HttpStatus.OK)) // Return 200 OK if updated
	        .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND)); // Return 404 if category not found
	}

	
	@DeleteMapping(path = "/delete")
	protected ResponseEntity<String> deleteCategory(@RequestParam int id) {
		boolean deleteCategory = categoryService.deleteCategory(id);
		if(deleteCategory) {
			return new ResponseEntity<String>("Deleted Successfully" , HttpStatus.OK);
		}else {
			return new ResponseEntity<String>("Deletion Failed" , HttpStatus.BAD_REQUEST);
		}
		
	}

	@GetMapping(path="/getAllCategory")
	protected ResponseEntity<Object> getAllCategory(){
		List<Category> allCategory =  categoryService.getAllCategory();
		return new ResponseEntity<>(allCategory, HttpStatus.OK);
	}
	
	
}
