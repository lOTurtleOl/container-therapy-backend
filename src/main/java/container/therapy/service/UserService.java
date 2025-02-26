/**
 * 
 */
package container.therapy.service;

import java.util.ArrayList;
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

//	public UserData convertToDto(User user) {
//		UserData userData = new UserData();
//		userData.setUserId(user.getUserId());
//		userData.setUserName(user.getUserName());
//		userData.setUserPassword(user.getUserPassword());
//		userData.setUserEmail(user.getUserEmail());
//		userData.setUserCreatedAt(user.getUserCreatedAt());
//		return userData;
//	}

//	public UserData createUser(User user) {
//		User savedUser = userDao.save(user);
//		return new UserData(savedUser);
//	}

	public UserData createUser(UserData userData, String password) {
		User user = new User();
		user.setUserName(userData.getUserName());
		user.setUserEmail(userData.getUserEmail());
		user.setUserCreatedAt(userData.getUserCreatedAt());
//		user.setUserPassword(passwordEncoder.encode(password));
		user.setUserPassword(password);

		User savedUser = userDao.save(user);
		return new UserData(savedUser);
	}

	// If we handled conversion in controller
//	public List<User> getAllUsers() {
//		return userDao.findAll();
//	}

	// Business logic stays in service layer
	public List<UserData> getAllUsers() {
		List<User> users = userDao.findAll();
		List<UserData> result = new ArrayList<>();
		for (User user : users) {
			UserData userData = new UserData(user);
			result.add(userData);
		}
		return result;
	}

	public UserData getUserById(Long id) {
		User foundUser = userDao.findById(id).orElseThrow(() -> new NoSuchElementException("User not found"));
		return new UserData(foundUser);
	}

	public void deleteUser(Long id) {
		User user = userDao.findById(id)
				.orElseThrow(() -> new NoSuchElementException("User with ID " + id + " not found."));
		userDao.delete(user);
	}

}
