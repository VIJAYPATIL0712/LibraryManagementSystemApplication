package project.demo.libraryManagementSystem.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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
@Table(name = "fines")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Fine {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private double amount;
	@Enumerated(EnumType.STRING)
	private FineStatus status;
	
	 @ManyToOne
	 @JoinColumn(name = "borrowerId", nullable = false)  
	 private User borrower;
	
}
