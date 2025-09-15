package project.demo.libraryManagementSystem.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import project.demo.libraryManagementSystem.entity.Book;

import java.util.List;

@Repository
public interface BookRepo extends JpaRepository<Book, Integer> {
    Book findBookById(int id);

    Book findBookByTitle(String title);


//    Book findBookByName(String name);
}
