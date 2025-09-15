package project.demo.libraryManagementSystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import project.demo.libraryManagementSystem.service.TransactionService;

@RestController
public class TransactionController {

	@Autowired
	private TransactionService transactionService;
}
