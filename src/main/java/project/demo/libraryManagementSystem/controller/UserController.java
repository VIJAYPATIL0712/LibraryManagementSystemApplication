package project.demo.libraryManagementSystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import project.demo.libraryManagementSystem.entity.User;
import project.demo.libraryManagementSystem.service.UserService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;

	//Add User
	@PostMapping("/register")
	protected ResponseEntity<User> addUser(@RequestBody User user){
		User addedUser = userService.addUser(user);
		return  new ResponseEntity<User>(addedUser ,HttpStatus.CREATED);
	}


	//Find All User
	@GetMapping("/allUsers")
	protected ResponseEntity<List<User>> allUsers(){
		List<User> allUser = userService.allUsers();
		return new ResponseEntity<>(allUser , HttpStatus.OK);
	}

	//Find User By Id
	@GetMapping("/userById")
	protected ResponseEntity<User> findUserById(@RequestParam int id){
			User getUser = userService.findUserById(id);
			return new ResponseEntity<>(getUser , HttpStatus.OK);
	}

	//Delete User
	@DeleteMapping("/delete")
	protected ResponseEntity<String> deleteUser(@RequestParam int id){
		Boolean deleted = userService.deleteUser(id);
		if(deleted){
			return new ResponseEntity<>("Deleted" , HttpStatus.OK);
		}else{
			return new ResponseEntity<>("Deletion Failed" , HttpStatus.NOT_FOUND);
		}

	}

	//Update User
	@PutMapping("/update/{id}")
	protected ResponseEntity<User> updateUser(@PathVariable int id , @RequestBody User user){
		return  userService.updateUser(id , user)
				 .map(updatedUser->  new ResponseEntity<>(updatedUser , HttpStatus.OK))
				 .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));

	}

	//Find All Admins
	@GetMapping("/findByRole")
	protected ResponseEntity<List<User>> userByRole(@RequestParam String role){
		List<User> allUser = userService.userByRole(role);
		return new ResponseEntity<>(allUser , HttpStatus.OK);
	}

}
