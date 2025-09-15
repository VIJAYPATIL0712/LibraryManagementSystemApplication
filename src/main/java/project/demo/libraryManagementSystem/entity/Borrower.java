package project.demo.libraryManagementSystem.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "borrowers")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Borrower {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(nullable = false , unique = false)
	private String name;
	@Column(nullable = false , unique = true)
	private String email;
	@Column(nullable = false , unique = true)
	private double mobile;
	@Column(nullable = false , unique = false)
	private String membership_status;
}
