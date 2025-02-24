/**
 * 
 */
package container.therapy.controller.model;

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
	
	private String topicCreatedAt;
	
	public TopicData(Topic topic) {
		topicId = topic.getTopicId();
		topicValue = topic.getTopicValue();
		topicDate = topic.getTopicDate();
		topicCreatedBy = topic.getTopicCreatedBy();
		topicCreatedAt = topic.getTopicCreatedAt();
	}
}
