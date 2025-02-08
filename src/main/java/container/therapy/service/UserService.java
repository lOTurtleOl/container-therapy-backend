/**
 * 
 */
package container.therapy.service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import container.therapy.controller.model.UserData;
import container.therapy.dao.UserDao;
import container.therapy.entity.User;
import lombok.RequiredArgsConstructor;

/**
 * 
 */
@Service
@RequiredArgsConstructor
public class UserService {
	
	@Autowired
	private UserDao userDao;
	
	public UserData convertToDto(User user) {
		UserData userData = new UserData();
		userData.setUserId(user.getUserId());
		userData.setUserName(user.getUserName());
		userData.setUserEmail(user.getUserEmail());
		userData.setUserCreatedAt(user.getUserCreatedAt());
		return userData;
	}
	
	public UserData createUser(User user) {
		User savedUser = userDao.save(user);
		return convertToDto(savedUser);
	}
	
	// If we handled conversion in controller
//	public List<User> getAllUsers() {
//		return userDao.findAll();
//	}
	
	// Business logic stays in service layer
	public List<UserData> getAllUsers() {
	    List<User> users = userDao.findAll();
	    return users.stream()
	        .map(this::convertToDto)  // Conversion happens here
	        .toList();
	}

	
	public UserData getUserById(Long id) {
		User foundUser = userDao.findById(id)
				.orElseThrow(() -> new NoSuchElementException("User not found"));
		return convertToDto(foundUser);
	}
	
	public void deleteUser(Long id) {
		User user = userDao.findById(id)
				.orElseThrow(() -> new NoSuchElementException("User with ID " + id + " not found."));
		userDao.delete(user);
	}
	
}
