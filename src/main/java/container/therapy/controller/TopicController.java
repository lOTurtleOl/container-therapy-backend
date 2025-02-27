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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import container.therapy.controller.model.TopicData;
import container.therapy.entity.Topic;
import container.therapy.service.TopicService;
import lombok.RequiredArgsConstructor;

/**
 * 
 */
@RestController
@RequestMapping("/topics")
@RequiredArgsConstructor
public class TopicController {

	@Autowired
	TopicService topicService;

	@PostMapping("/{id}")
	public ResponseEntity<TopicData> createTopic(@PathVariable("id") Long containerId, @RequestBody Topic topic) {
		TopicData newTopicData = topicService.createTopic(containerId, topic);
		return ResponseEntity.ok(newTopicData);
	}

	@GetMapping
	public ResponseEntity<List<TopicData>> getAllTopics() {
		List<TopicData> topicList = topicService.getAllTopics();
		return ResponseEntity.ok(topicList);
	}

	@GetMapping("/{id}")
	public ResponseEntity<TopicData> getTopicById(@PathVariable Long id) {
		TopicData topicData = topicService.getTopicById(id);
		return ResponseEntity.ok(topicData);
	}

	@DeleteMapping("/{id}")
	public void deleteTopic(@PathVariable Long id) {
		topicService.deleteTopic(id);
	}
}
