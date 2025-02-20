/**
 * 
 */
package container.therapy.controller.model;

import container.therapy.entity.User;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 */
@Data
@NoArgsConstructor
public class UserData {

	private Long userId;
	private String userName;
	private String userEmail;
	private String userCreatedAt;
	
	public UserData(User user) {
		userId = user.getUserId();
		userName = user.getUserName();
		userEmail = user.getUserEmail();
		userCreatedAt = user.getUserCreatedAt();
	}
}
