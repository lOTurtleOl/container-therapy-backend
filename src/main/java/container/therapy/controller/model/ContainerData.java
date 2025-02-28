/**
 * 
 */
package container.therapy.controller.model;

import java.util.HashSet;
import java.util.Set;

import container.therapy.entity.Container;
import container.therapy.entity.Topic;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * DTO for Container entity
 */
@Data
@NoArgsConstructor
public class ContainerData {

	private Long containerId;

	private String containerName;

	private Boolean containerIsPublic;

	private String containerCreatedAt;

	private Set<TopicData> topics;

	private Long userId;

	public ContainerData(Container container) { // go through and map all petStoreData fields to their respective entity
												// field values
		containerId = container.getContainerId();
		containerName = container.getContainerName();
		containerIsPublic = container.getContainerIsPublic();
		containerCreatedAt = container.getContainerCreatedAt();
		userId = (container.getUser() != null) ? container.getUser().getUserId() : null; // if else

		topics = new HashSet<>();

		if (container.getTopics() != null) { // Avoid null pointer exception
			for (Topic topic : container.getTopics()) {
				topics.add(new TopicData(topic));
			}
		}

	}
}
