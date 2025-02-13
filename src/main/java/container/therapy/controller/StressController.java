/**
 * 
 */
package container.therapy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import container.therapy.controller.model.StressData;
import container.therapy.entity.Stress;
import container.therapy.service.StressService;
import lombok.RequiredArgsConstructor;

/**
 * 
 */
@RestController
@RequestMapping("/stress")
@RequiredArgsConstructor
public class StressController {
	
	@Autowired
	StressService stressService;

	@PostMapping
	public ResponseEntity<StressData> createStress(Stress stress) {
		StressData newStressData = stressService.createStress(stress);
		return ResponseEntity.ok(newStressData);
	}
	
	@GetMapping
	public ResponseEntity<List<StressData>> getAllStress() {
		List<StressData> stressList = stressService.getAllStress();
		return ResponseEntity.ok(stressList);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<StressData> getStressById(@PathVariable Long id) {
		StressData stressData = stressService.getStressById(id);
		return ResponseEntity.ok(stressData);
	}
	
	@DeleteMapping("/{id}")
	public void deleteStress(@PathVariable Long id) {
		stressService.deleteStress(id);
	}
}
