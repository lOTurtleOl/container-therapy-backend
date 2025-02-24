/**
 * 
 */
package container.therapy.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import container.therapy.controller.model.ContainerData;
import container.therapy.service.ContainerService;
import lombok.RequiredArgsConstructor;

/**
 * 
 */
@RestController
@RequestMapping("/containers")
@RequiredArgsConstructor
public class ContainerController {
	
	private final ContainerService containerService;
	
//	@PostMapping
//	public ResponseEntity<ContainerData> createContainer(@RequestBody Container container) {
//		Container newContainer = containerService.createContainer(container);
//		return ResponseEntity.ok(newContainer);
//	}
	@PostMapping
	public ResponseEntity<ContainerData> createContainer(@RequestBody ContainerData containerData) {
		if (containerData.getContainerId() != null) {
			return ResponseEntity.badRequest().build();
		}
		
		if (containerData.getUserId() == null) {
			throw new IllegalArgumentException("User ID is required to create a container.");
		}
		
		ContainerData newContainer = containerService.createContainer(containerData);
		return ResponseEntity.ok(newContainer);
	}
	
	@GetMapping
	public ResponseEntity<List<ContainerData>> getAllContainers() {
		List<ContainerData> containerData = containerService.getAllContainers();
		return ResponseEntity.ok(containerData);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ContainerData> getContainerById(@PathVariable Long id) {
		ContainerData containerData = containerService.getContainerById(id);
		return ResponseEntity.ok(containerData);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<ContainerData> updateContainer(@PathVariable Long id, @RequestBody ContainerData updatedData) {
		ContainerData updatedContainer = containerService.updateContainer(id, updatedData);
		return ResponseEntity.ok(updatedContainer);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteContainer(@PathVariable Long id) {
		containerService.deleteContainer(id);
		return ResponseEntity.noContent().build();
	}
}
