/**
 * 
 */
package container.therapy.entity;

import java.util.Date;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * 
 */
@Entity
@Data
public class Container {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long containerId;
	
	private String containerName;
	
	private Boolean containerIsPublic;
	
	private Date containerCreatedAt;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "user_id", nullable = false) // creates a foreign key column in container table / specifies the foreign key in the table
	private User user;
	
	@ManyToMany(mappedBy = "containers", cascade = CascadeType.PERSIST) // defines relationship to PetStore / mappedBy says that this side is not the Owning side, which is defined by the PetStore entity instead / when a customer is saved, any associated PetStore entities are also persisted
	@EqualsAndHashCode.Exclude // prevents recursion when comparing objects with circular relationships
	@ToString.Exclude // Exclude this field from the toString method to avoid infinite loops caused by bidirectional relationships
	private Set<Object> objects; // customer can be associated with multiple pet stores, this represents that collection
}
