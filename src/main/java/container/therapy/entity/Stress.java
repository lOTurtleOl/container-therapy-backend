/**
 * 
 */
package container.therapy.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * 
 */
@Entity
@Data
public class Stress {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long stressId;
	
	private String stressValue;
	
	private String stressDate; // When did the event / trauma occur
	
	private String stressCreatedBy;
	
	private Date stressCreatedAt;
	
	@EqualsAndHashCode.Exclude
	@ToString.Exclude
	@ManyToMany(cascade = CascadeType.PERSIST)
	@JoinTable(
			name = "container_stress", // name of the join table
			joinColumns = @JoinColumn(name = "stress_id"), // foreign key to PetStore
			inverseJoinColumns = @JoinColumn(name = "container_id")
	)
	private Set<Container> containers = new HashSet<>();
}
