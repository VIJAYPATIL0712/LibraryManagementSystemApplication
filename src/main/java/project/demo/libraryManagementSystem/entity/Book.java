package project.demo.libraryManagementSystem.entity;


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
@Table(name = "books")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Book {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private int id;
	@Column(nullable = false , unique = false)
	private String title;
	@Column(nullable = false , unique = false)
	private String author;
	@Column(nullable = false , unique = false)
	private int copyAvailable;
	@ManyToOne
	@JoinColumn(name= "categoryId" , nullable= false)
	private Category category;
	
}
