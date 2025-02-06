/**
 * 
 */
package container.therapy.controller.model;

import java.util.Date;

import lombok.Data;

/**
 * 
 */
@Data
public class UserData {

	private Long userId;
	private String userName;
	private String userEmail;
	private Date userCreatedAt;
}
