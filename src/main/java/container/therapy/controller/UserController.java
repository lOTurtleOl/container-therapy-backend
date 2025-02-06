/**
 * 
 */
package container.therapy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import container.therapy.controller.model.UserData;
import container.therapy.entity.User;
import container.therapy.service.UserService;
import lombok.RequiredArgsConstructor;

/**
 * 
 */
@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

	@Autowired
	private UserService userService;
	
	// How we could do this without a Data Transfer Object
//	@PostMapping
//	@ResponseStatus(code = HttpStatus.CREATED)
//	public ResponseEntity<User> createUser(@RequestBody User user) {
//		return ResponseEntity.ok(userService.createUser(user));
//	}
//	@GetMapping
//	public ResponseEntity<List<User>> getAllUsers() {
//		return ResponseEntity.ok(userService.getAllUsers());
//	}
	
	@PostMapping
	public ResponseEntity<UserData> createUser(@RequestBody User user) {
		User savedUser = userService.createUser(user);
		return ResponseEntity.ok(userService.convertToDto(savedUser));
	}
	
	// If we handled conversion of data in controller:
//	@GetMapping
//	public ResponseEntity<List<UserData>> getAllUsers() {
//		List<User> users = userService.getAllUsers();
//		
//		List<UserData> userData = users.stream()
//				.map(userService::convertToDto)
//				.toList();
//		
//		return ResponseEntity.ok(userData);
//	}
	
	// Clean code where conversion is handled in service layer
	@GetMapping
	public ResponseEntity<List<UserData>> getAllUsers() {
	    return ResponseEntity.ok(userService.getAllUsers());  // Already converted
	}

	
	
}
