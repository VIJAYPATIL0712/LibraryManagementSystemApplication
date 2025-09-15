package project.demo.libraryManagementSystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import project.demo.libraryManagementSystem.entity.Role;
import project.demo.libraryManagementSystem.entity.User;
import project.demo.libraryManagementSystem.repo.RoleRepo;
import project.demo.libraryManagementSystem.repo.UserRepo;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

	@Autowired
	private UserRepo userRepo;
    private RoleRepo roleRepo;

    public User addUser(User user) {
        return userRepo.save(user);
    }

    public List<User> allUsers() {
        return userRepo.findAll();
    }

    public User findUserById(int id) {
        return userRepo.findUserById(id);
    }

    public Boolean deleteUser(int id) {
        if (userRepo.existsById(id)) {
            userRepo.deleteById(id);
            return true;
        }
        return false;
    }

    public Optional<User> updateUser(int id, User user) {
        return userRepo.findById(id)
                .map( existingUser ->{
                    existingUser.setName(user.getName());
                    existingUser.setEmail(user.getEmail());
                    existingUser.setPassword(user.getPassword());
                    existingUser.setRole(user.getRole());
                    return userRepo.save(existingUser);
                });
    }

    public List<User> userByRole(String roleName) {
        Role role = roleRepo.findByName(roleName); // Corrected method name
        if (role == null) {
            throw new RuntimeException("Role not found: " + roleName);
        }
        return userRepo.findByRole(String.valueOf(role)); // Fetch users by Role
    }

}

