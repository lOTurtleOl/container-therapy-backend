/**
 * 
 */
package container.therapy.controller.model;

import java.util.Date;

import container.therapy.entity.Stress;
import lombok.Data;

/**
 * 
 */
@Data
public class StressData {

	private Long stressId;
	
	private String stressValue;
	
	private String stressDate; 
	
	private String stressCreatedBy;
	
	private Date stressCreatedAt;
	
	public StressData(Stress stress) {
		stressId = stress.getStressId();
		stressValue = stress.getStressValue();
		stressDate = stress.getStressDate();
		stressCreatedBy = stress.getStressCreatedBy();
		stressCreatedAt = stress.getStressCreatedAt();
	}
}
