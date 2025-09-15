package project.demo.libraryManagementSystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.demo.libraryManagementSystem.repo.FineRepo;

@Service
public class FineService {

	@Autowired
	private FineRepo fineRepo;
}
