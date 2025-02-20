/**
 * 
 */
package container.therapy.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * 
 */
@Entity
@Data
@Table(name = "container")
public class Container {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "container_id")
	private Long containerId;
	
	private String containerName;
	
	private Boolean containerIsPublic;
	
	private String containerCreatedAt;
	
	@EqualsAndHashCode.Exclude 
	@ToString.Exclude 
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "user_id", unique = true) // creates a foreign key column in container table / specifies the foreign key in the table
	private User user;
	
	@OneToMany(mappedBy = "container", cascade = CascadeType.ALL, orphanRemoval = true) 
	@EqualsAndHashCode.Exclude 
	@ToString.Exclude 
	private Set<Topic> topics = new HashSet<>();; 
}
