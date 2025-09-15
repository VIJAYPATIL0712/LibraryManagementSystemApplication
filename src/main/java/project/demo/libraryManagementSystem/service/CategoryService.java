package project.demo.libraryManagementSystem.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import project.demo.libraryManagementSystem.entity.Category;
import project.demo.libraryManagementSystem.repo.CategoryRepo;

@Service
public class CategoryService {

	@Autowired
	private CategoryRepo categoryRepo;

	public Category addCategory(Category category) {
		Category catAdded = categoryRepo.save(category);
		return catAdded;		
	}

	public Optional<Category> updtCategory(int id, Category category) {
	    return categoryRepo.findById(id)
	        .map(existingCategory -> {
	            existingCategory.setName(category.getName()); // Update fields as needed
	            existingCategory.setDescription(category.getDescription());
	            return categoryRepo.save(existingCategory);
	        });
	}
  
	public boolean deleteCategory(int id) {		
	    if (categoryRepo.existsById(id)) {
	        categoryRepo.deleteById(id);
	        return true;
	    }
	    return false;
	}

    public List<Category> getAllCategory() {

		return categoryRepo.findAll();
    }
}
