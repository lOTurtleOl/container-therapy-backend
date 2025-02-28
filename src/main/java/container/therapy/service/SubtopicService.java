/**
 * 
 */
package container.therapy.service;

import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import container.therapy.controller.model.SubtopicData;
import container.therapy.dao.SubtopicDao;
import container.therapy.dao.TopicDao;
import container.therapy.entity.Subtopic;
import container.therapy.entity.Topic;
import lombok.RequiredArgsConstructor;

/**
 * 
 */
@Service
@RequiredArgsConstructor
public class SubtopicService {

	@Autowired
	private TopicDao topicDao;

	@Autowired
	private SubtopicDao subtopicDao;

	@Transactional
	public SubtopicData createSubtopic(Long topicId, Subtopic subtopic) {
		Topic topic = topicDao.findById(topicId).orElseThrow(() -> elementNotFound("Topic", topicId));
		topic.getSubtopics().add(subtopic);
		subtopic.getTopics().add(topic);

		subtopic = subtopicDao.save(subtopic);
		topicDao.save(topic);
		return new SubtopicData(subtopic);
	}

	private static NoSuchElementException elementNotFound(String entityName, Long id) {
		return new NoSuchElementException(entityName + " with ID of " + id + " not found.");
	}
}
