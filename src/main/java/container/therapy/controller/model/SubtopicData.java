/**
 * 
 */
package container.therapy.controller.model;

import container.therapy.entity.Subtopic;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 */
@Data
@NoArgsConstructor
public class SubtopicData {
	
	private Long subtopicId;
	
	
	private String subtopicValue;
	
	private String subtopicDate;
	
	private String subtopicCreatedBy;
	
	private String subtopicCreatedAt;
	
	public SubtopicData(Subtopic subtopic) {
		subtopicId = subtopic.getSubtopicId();
		subtopicDate = subtopic.getSubtopicDate();
		subtopicValue = subtopic.getSubtopicValue();
		subtopicCreatedBy = subtopic.getSubtopicCreatedBy();
		subtopicCreatedAt = subtopic.getSubtopicCreatedAt();
	}
	
}
