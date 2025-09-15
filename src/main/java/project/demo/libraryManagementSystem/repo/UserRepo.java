package project.demo.libraryManagementSystem.repo;


import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import project.demo.libraryManagementSystem.entity.User;

import java.util.List;


@Repository
public interface UserRepo  extends JpaRepository<User, Integer> {


    User findUserById(int id);
    List<User> findByRole(String role);
}
