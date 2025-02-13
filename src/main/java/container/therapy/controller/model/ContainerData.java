/**
 * 
 */
package container.therapy.controller.model;

import java.util.Date;
import java.util.Set;

import container.therapy.entity.Container;
import container.therapy.entity.Stress;
import lombok.Data;


/**
 * DTO for Container entity
 */
@Data
public class ContainerData {

	private Long containerId;
	
	private String containerName;
	
	private Boolean containerIsPublic;
	
	private Date containerCreatedAt;
	
	private Long userId;
	
	private Set<StressData> stressors;
	
	public ContainerData(Container container) { // go through and map all petStoreData fields to their respective entity field values
		containerId = container.getContainerId();
		containerName = container.getContainerName();
		containerIsPublic = container.getContainerIsPublic();
		containerCreatedAt = container.getContainerCreatedAt();
		
			for (Stress stress : container.getStressors()) {
					stressors.add(new StressData(stress));
		}
				
	}
}
