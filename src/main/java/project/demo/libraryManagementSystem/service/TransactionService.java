package project.demo.libraryManagementSystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.demo.libraryManagementSystem.repo.TransactionRepo;

@Service
public class TransactionService {

	@Autowired
	private TransactionRepo transactionRepo;
}
