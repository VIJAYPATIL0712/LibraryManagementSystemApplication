package project.demo.libraryManagementSystem.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import project.demo.libraryManagementSystem.entity.Category;

@Repository
public interface CategoryRepo extends JpaRepository<Category, Integer> {

}
