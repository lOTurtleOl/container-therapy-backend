/**
 * 
 */
package container.therapy.entity;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * 
 */
@Entity
@Data
public class Subtopic {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long subtopicId;

	private String subtopicName;

	private String subtopicDate;

	private String subtopicCreatedBy;

	private String subtopicCreatedAt;

	@EqualsAndHashCode.Exclude
	@ToString.Exclude
	@ManyToMany(mappedBy = "subtopics", cascade = CascadeType.PERSIST)
	private Set<Topic> topics = new HashSet<>();
}
