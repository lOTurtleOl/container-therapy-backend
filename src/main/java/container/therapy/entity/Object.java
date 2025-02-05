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
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * 
 */
@Entity
@Data
public class Object {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long objectId;
	
	private String objectValue;
	
	private String objectDate; // When did the event / trauma occur
	
	private String objectCreatedBy;
	
	private Date objectCreatedAt;
	
	@EqualsAndHashCode.Exclude
	@ToString.Exclude
	@ManyToMany(cascade = CascadeType.PERSIST)
	@JoinTable(
			name = "container_object", // name of the join table
			joinColumns = @JoinColumn(name = "container_id"), // foreign key to PetStore
			inverseJoinColumns = @JoinColumn(name = "object_id")
	)
	private Set<Container> containers = new HashSet<>();
}
