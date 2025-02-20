/**
 * 
 */
package container.therapy.service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import container.therapy.controller.model.TopicData;
import container.therapy.dao.TopicDao;
import container.therapy.entity.Topic;
import lombok.RequiredArgsConstructor;

/**
 * 
 */
@Service
@RequiredArgsConstructor
public class TopicService {

	@Autowired
	private TopicDao topicDao;
	
//	public StressData convertToDto(Stress stress) {
//		StressData stressData = new StressData(stress);
//		stressData.setStressId(stress.getStressId());
//		stressData.setStressValue(stress.getStressValue());
//		stressData.setStressDate(stress.getStressDate());
//		stressData.setStressCreatedBy(stress.getStressCreatedBy());
//		stressData.setStressCreatedAt(stress.getStressCreatedAt());
//		return stressData;
//	}
	
	public TopicData createTopic(Topic containerObject) {
		Topic savedTopic = topicDao.save(containerObject);
		return new TopicData(savedTopic);
		}
	
	public List<TopicData> getAllTopics() {
		List<Topic> topics = topicDao.findAll();
		List<TopicData> result = new ArrayList<>();
		for (Topic topic : topics) {
			TopicData topicData = new TopicData(topic);
			result.add(topicData);
		}
		return result;
	}
	
	public TopicData getTopicById(Long id) {
		Topic topic = topicDao.findById(id)
				.orElseThrow(() -> new NoSuchElementException("No topic with ID " + id + " found."));
		return new TopicData(topic);
		
	}
	
	public void deleteTopic(Long id) {
		Topic topic = topicDao.findById(id)
				.orElseThrow(() -> new NoSuchElementException("Topic with ID " + id + " not found."));
		topicDao.delete(topic);
	}
}
