package project.demo.libraryManagementSystem.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import project.demo.libraryManagementSystem.entity.Fine;

@Repository
public interface FineRepo extends JpaRepository<Fine, Integer> {

}
