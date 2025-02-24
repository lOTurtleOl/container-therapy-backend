/**
 * 
 */
package container.therapy.service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import container.therapy.controller.model.ContainerData;
import container.therapy.dao.ContainerDao;
import container.therapy.dao.UserDao;
import container.therapy.entity.Container;
import container.therapy.entity.User;
import lombok.RequiredArgsConstructor;

/**
 * 
 */
@Service
@RequiredArgsConstructor
public class ContainerService {
	
	@Autowired
	private ContainerDao containerDao;
	private UserDao userDao;
	
//	public ContainerData createContainer(Container container) {
//		User user = userDao.findById(userId)
//				.orElseThrow(() -> elementNotFound("User", userId));
//		Container savedContainer = containerDao.save(container);;
//		return new ContainerData(savedContainer);
//	}
	public ContainerData createContainer(ContainerData containerData) {
		User user = userDao.findById(containerData.getUserId())
				.orElseThrow(() -> elementNotFound("User", containerData.getUserId()));
		Container container = new Container();
		container.setContainerName(containerData.getContainerName());
		container.setContainerIsPublic(containerData.getContainerIsPublic());
		container.setContainerCreatedAt(containerData.getContainerCreatedAt());
		container.setUser(user);
		
		Container savedContainer = containerDao.save(container);
		return new ContainerData(savedContainer);
	}
	
	public ContainerData updateContainer(Long id, ContainerData updatedData) {
		Container container = containerDao.findById(id)
				.orElseThrow(() -> elementNotFound("Container", id));
		
		container.setContainerName(updatedData.getContainerName());
		container.setContainerIsPublic(updatedData.getContainerIsPublic());
		container.setContainerCreatedAt(updatedData.getContainerCreatedAt());
		
		containerDao.save(container);
		return new ContainerData(container);
	}
	
	public List<ContainerData> getAllContainers() {
		List<Container> containers = containerDao.findAll();
		List<ContainerData> result = new ArrayList<>();
		for (Container container : containers) {
			ContainerData containerData = new ContainerData(container);
			result.add(containerData);
		}
		return result;
	}
	
	public ContainerData getContainerById(Long id) {
		Container foundContainer = containerDao.findById(id)
				.orElseThrow(() -> new NoSuchElementException("Container not found."));
		return new ContainerData(foundContainer);
	}
	
	public void deleteContainer(Long id) {
		Container container = containerDao.findById(id)
				.orElseThrow(() -> new NoSuchElementException("Container with ID " + id + " not found."));
		containerDao.delete(container);
	}
	
	private static NoSuchElementException elementNotFound(String entityName, Long id) {
		return new NoSuchElementException(entityName + " with ID of " + id + " not found.");
	}
}
