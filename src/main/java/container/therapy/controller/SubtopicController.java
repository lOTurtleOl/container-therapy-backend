/**
 * 
 */
package container.therapy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import container.therapy.controller.model.SubtopicData;
import container.therapy.entity.Subtopic;
import container.therapy.service.SubtopicService;
import lombok.RequiredArgsConstructor;

/**
 * 
 */
@RestController
@RequestMapping("subtopics")
@RequiredArgsConstructor
public class SubtopicController {

	@Autowired
	SubtopicService subtopicService;

	@PostMapping("/{id}")
	public ResponseEntity<SubtopicData> createSubtopic(@PathVariable("id") Long topicId,
			@RequestBody Subtopic subtopic) {
		SubtopicData newSubtopicData = subtopicService.createSubtopic(topicId, subtopic);
		return ResponseEntity.ok(newSubtopicData);
	}
}
