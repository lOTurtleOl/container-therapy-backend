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

import container.therapy.controller.model.ContainerObjectData;
import container.therapy.entity.ContainerObject;
import container.therapy.service.ContainerObjectService;
import lombok.RequiredArgsConstructor;

/**
 * 
 */
@RestController
@RequestMapping("/containerObjects")
@RequiredArgsConstructor
public class ContainerObjectController {
	
	@Autowired
	ContainerObjectService containerObjectService;

	@PostMapping
	public ResponseEntity<ContainerObjectData> createContainerObject(ContainerObject containerObject) {
		ContainerObjectData newContainerObjectData = containerObjectService.createContainerObject(containerObject);
		return ResponseEntity.ok(newContainerObjectData);
	}
	
	@GetMapping
	public ResponseEntity<List<ContainerObjectData>> getAllContainerObjects() {
		List<ContainerObjectData> containerObjectList = containerObjectService.getAllContainerObjects();
		return ResponseEntity.ok(containerObjectList);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ContainerObjectData> getContainerObjectById(@PathVariable Long id) {
		ContainerObjectData containerObjectData = containerObjectService.getContainerObjectById(id);
		return ResponseEntity.ok(containerObjectData);
	}
	
	@DeleteMapping("/{id}")
	public void deleteContainerObject(@PathVariable Long id) {
		containerObjectService.deleteContainerObject(id);
	}
}
