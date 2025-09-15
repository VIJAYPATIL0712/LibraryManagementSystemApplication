package project.demo.libraryManagementSystem.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import project.demo.libraryManagementSystem.entity.Transaction;


@Repository
public interface TransactionRepo extends JpaRepository<Transaction, Integer> {

}
