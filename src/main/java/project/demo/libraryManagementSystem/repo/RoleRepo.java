package project.demo.libraryManagementSystem.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import project.demo.libraryManagementSystem.entity.Role;
//import project.demo.libraryManagementSystem.entity.User;

@Repository
public interface RoleRepo extends JpaRepository<Role, Integer> {
    Role findByName(String roleName);
}
