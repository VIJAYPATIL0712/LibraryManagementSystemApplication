package project.demo.libraryManagementSystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import project.demo.libraryManagementSystem.service.FineService;

@RestController
public class FineController {
  
	@Autowired
	private FineService fineService;
}
