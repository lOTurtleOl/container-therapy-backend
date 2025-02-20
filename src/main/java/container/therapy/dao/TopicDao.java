/**
 * 
 */
package container.therapy.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import container.therapy.entity.Topic;

/**
 * 
 */
public interface TopicDao extends JpaRepository<Topic, Long>  {

}
