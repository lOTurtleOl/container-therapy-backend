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
	
	@ManyToMany(mappedBy = "containers", cascade = CascadeType.PERSIST) 
	@EqualsAndHashCode.Exclude 
	@ToString.Exclude 
	private Set<ContainerObject> containerObjects; 
}
