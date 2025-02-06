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
		userData.setUserId(null);
		userData.setUserName(null);
		userData.setUserEmail(null);
		userData.setUserCreatedAt(null);
		return userData;
	}
	
	public User createUser(User user) {
		return userDao.save(user);
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

	
	public User getUserById(Long id) {
		return userDao.findById(id)
				.orElseThrow(() -> new NoSuchElementException("User not found"));
	}
	
	public void deleteUser(Long id) {
		userDao.deleteById(id);
	}
	
}
