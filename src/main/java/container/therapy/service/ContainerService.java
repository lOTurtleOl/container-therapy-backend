/**
 * 
 */
package container.therapy.service;

import java.util.HashSet;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import container.therapy.controller.model.ContainerData;
import container.therapy.dao.ContainerDao;
import container.therapy.dao.ContainerObjectDao;
import container.therapy.entity.Container;
import container.therapy.entity.ContainerObject;
import lombok.RequiredArgsConstructor;

/**
 * 
 */
@Service
@RequiredArgsConstructor
public class ContainerService {
	
	@Autowired
	private ContainerDao containerDao;
	private ContainerObjectDao containerObjectDao;
	
	public ContainerData convertToDto(Container container) {
		ContainerData containerData = new ContainerData();
		containerData.setContainerId(container.getContainerId());
		containerData.setContainerName(container.getContainerName());
		containerData.setContainerIsPublic(container.getContainerIsPublic());
		containerData.setContainerCreatedAt(container.getContainerCreatedAt());
		
		return containerData;
	}
	
	public ContainerData createContainer(Container container) {
		Container savedContainer = containerDao.save(container);;
		return convertToDto(savedContainer);
	}
	
	public ContainerData updateContainer(Long id, ContainerData updatedData) {
		Container container = containerDao.findById(id)
				.orElseThrow(() -> new NoSuchElementException("Container with ID " + id + " not found."));
		
		container.setContainerName(updatedData.getContainerName());
		container.setContainerIsPublic(updatedData.getContainerIsPublic());
		container.setContainerCreatedAt(updatedData.getContainerCreatedAt());
		
		if (updatedData.getContainerObjects() != null) {
			Set<ContainerObject> updatedObjects = new HashSet<>();
			for (ContainerObject obj : updatedData.getContainerObjects()) {
				//Fetch object from DB to avoid detached entities
				ContainerObject dbObject = containerObjectDao.findById(obj.getObjectId())
						.orElseThrow(() -> new NoSuchElementException("Object with ID " + obj.getObjectId() + " not found."));
						updatedObjects.add(dbObject);
			}
			container.setContainerObjects(updatedObjects);
		}
		
		containerDao.save(container);
		return convertToDto(container);
	}
	
	public List<ContainerData> getAllContainers() {
		List<Container> containers = containerDao.findAll();
		return containers.stream()
				.map(this::convertToDto)
				.toList();
	}
	
	public ContainerData getContainerById(Long id) {
		Container foundContainer = containerDao.findById(id)
				.orElseThrow(() -> new NoSuchElementException("Container not found."));
		return convertToDto(foundContainer);
	}
	
	public void deleteContainer(Long id) {
		Container container = containerDao.findById(id)
				.orElseThrow(() -> new NoSuchElementException("Container with ID " + id + " not found."));
		containerDao.delete(container);
	}
}
