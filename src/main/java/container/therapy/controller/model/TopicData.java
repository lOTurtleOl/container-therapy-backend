/**
 * 
 */
package container.therapy.controller.model;

import java.util.Date;

import container.therapy.entity.Topic;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 */
@Data
@NoArgsConstructor
public class TopicData {

	private Long topicId;
	
	private String topicValue;
	
	private String topicDate; 
	
	private String topicCreatedBy;
	
	private Date topicCreatedAt;
	
	public TopicData(Topic topic) {
		topicId = topic.getTopicId();
		topicValue = topic.getTopicValue();
		topicDate = topic.getTopicDate();
		topicCreatedBy = topic.getTopicCreatedBy();
		topicCreatedAt = topic.getTopicCreatedAt();
	}
}
