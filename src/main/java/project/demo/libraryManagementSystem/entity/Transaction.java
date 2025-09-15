package project.demo.libraryManagementSystem.entity;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "transactions")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Transaction {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(nullable = false)
	private LocalDate issueDate;
	@Column(nullable = false)
	private LocalDate dueDate;
	@Column(nullable = false)
	private LocalDate returnDate;
	@Column(nullable = true)
	private double fineAmount;
	
	@ManyToOne
	@JoinColumn(name = "bookId")
	private Book book;
	
	@ManyToOne
	@JoinColumn(name = "borrowerId")
	private User borrower;
	
}
