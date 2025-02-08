/**
 * 
 */
package container.therapy.controller.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import container.therapy.entity.Container;
import lombok.Data;

/**
 * 
 */
@Data
public class ContainerObjectData {

	private Long objectId;
	
	private String objectValue;
	
	private String objectDate; 
	
	private String objectCreatedBy;
	
	private Date objectCreatedAt;
	
	private Set<Container> containers = new HashSet<>();
}
