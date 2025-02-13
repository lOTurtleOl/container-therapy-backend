/**
 * 
 */
package container.therapy.service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import container.therapy.controller.model.StressData;
import container.therapy.dao.StressDao;
import container.therapy.entity.Stress;
import lombok.RequiredArgsConstructor;

/**
 * 
 */
@Service
@RequiredArgsConstructor
public class StressService {

	@Autowired
	private StressDao stressDao;
	
//	public StressData convertToDto(Stress stress) {
//		StressData stressData = new StressData(stress);
//		stressData.setStressId(stress.getStressId());
//		stressData.setStressValue(stress.getStressValue());
//		stressData.setStressDate(stress.getStressDate());
//		stressData.setStressCreatedBy(stress.getStressCreatedBy());
//		stressData.setStressCreatedAt(stress.getStressCreatedAt());
//		return stressData;
//	}
	
	public StressData createStress(Stress containerObject) {
		Stress savedStress = stressDao.save(containerObject);
		return new StressData(savedStress);
		}
	
	public List<StressData> getAllStress() {
		List<Stress> stressors = stressDao.findAll();
		List<StressData> result = new ArrayList<>();
		for (Stress stress : stressors) {
			StressData stressData = new StressData(stress);
			result.add(stressData);
		}
		return result;
	}
	
	public StressData getStressById(Long id) {
		Stress stressor = stressDao.findById(id)
				.orElseThrow(() -> new NoSuchElementException("No stress with ID " + id + " found."));
		return new StressData(stressor);
		
	}
	
	public void deleteStress(Long id) {
		Stress stressor = stressDao.findById(id)
				.orElseThrow(() -> new NoSuchElementException("Stress with ID " + id + " not found."));
		stressDao.delete(stressor);
	}
}
