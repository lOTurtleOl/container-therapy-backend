/**
 * 
 */
package container.therapy.controller.model;

import java.util.Date;
import java.util.Set;

import container.therapy.entity.ContainerObject;
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
	
	private Set<ContainerObject> containerObjects;
}
