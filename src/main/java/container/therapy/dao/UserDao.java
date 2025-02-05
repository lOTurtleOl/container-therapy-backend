/**
 * 
 */
package container.therapy.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import container.therapy.entity.User;

/**
 * 
 */
public interface UserDao extends JpaRepository<User, Long> {

}
