/**
 * 
 */
package container.therapy.service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	
	public User createUser(User user) {
		return userDao.save(user);
	}
	
	public List<User> getAllUsers() {
		return userDao.findAll();
	}
	
	public User getUserById(Long id) {
		return userDao.findById(id)
				.orElseThrow(() -> new NoSuchElementException("User not found"));
	}
	
	public void deleteUser(Long id) {
		userDao.deleteById(id);
	}
	
}
