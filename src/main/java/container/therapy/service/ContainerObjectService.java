/**
 * 
 */
package container.therapy.service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import container.therapy.controller.model.ContainerObjectData;
import container.therapy.dao.ContainerObjectDao;
import container.therapy.entity.ContainerObject;
import lombok.RequiredArgsConstructor;

/**
 * 
 */
@Service
@RequiredArgsConstructor
public class ContainerObjectService {

	@Autowired
	private ContainerObjectDao containerObjectDao;
	
	public ContainerObjectData convertToDto(ContainerObject containerObject) {
		ContainerObjectData containerObjectData = new ContainerObjectData();
		containerObjectData.setObjectId(containerObject.getObjectId());
		containerObjectData.setObjectValue(containerObject.getObjectValue());
		containerObjectData.setObjectDate(containerObject.getObjectDate());
		containerObjectData.setObjectCreatedBy(containerObject.getObjectCreatedBy());
		containerObjectData.setObjectCreatedAt(containerObject.getObjectCreatedAt());
		return containerObjectData;
	}
	
	public ContainerObjectData createContainerObject(ContainerObject containerObject) {
		ContainerObject savedContainerObject = containerObjectDao.save(containerObject);
		return convertToDto(savedContainerObject);
	}
	
	public List<ContainerObjectData> getAllContainerObjects() {
		List<ContainerObject> containerObjects = containerObjectDao.findAll();
		return containerObjects.stream()
				.map(this::convertToDto)
				.toList();
	}
	
	public ContainerObjectData getContainerObjectById(Long id) {
		ContainerObject containerObject = containerObjectDao.findById(id)
				.orElseThrow(() -> new NoSuchElementException("No object with ID " + id + " found."));
		return convertToDto(containerObject);
		
	}
	
	public void deleteContainerObject(Long id) {
		ContainerObject containerObject = containerObjectDao.findById(id)
				.orElseThrow(() -> new NoSuchElementException("Object with ID " + id + " not found."));
		containerObjectDao.delete(containerObject);
	}
}
