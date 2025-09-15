package project.demo.libraryManagementSystem.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Optional;

@Entity
@Table(name = "users")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(nullable= false , unique = false)
	private String name;
	
	@Column(nullable= false , unique = true)
	private String email;
	
	@Column(nullable= false , unique = false)
	private String password;
	
	@Column(nullable= false , unique = true)
	private double mobile;
	
	@Enumerated(EnumType.STRING)
	@Column(nullable= false , unique = false)
	private Role role;


}
