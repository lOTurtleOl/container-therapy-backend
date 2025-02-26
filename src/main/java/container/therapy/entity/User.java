/**
 * 
 */
package container.therapy.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * 
 */
@Entity
@Data
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long userId;

	private String userName;

	private String userPassword;

	private String userEmail;

	private String userCreatedAt;

	@EqualsAndHashCode.Exclude
	@ToString.Exclude
	@OneToOne(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)

	private Container container;
}
