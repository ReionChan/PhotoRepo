package io.javabrains.springbootstarter.topic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TopicController {
	
	@Autowired
	private TopicService topicService;
	
	/**
	 * GET /topics
	 * 
	 * @return 返回所有主题
	 */
	@RequestMapping(value="/topics", method=RequestMethod.GET)
	public List<Topic> getAllTopics() {
		return topicService.getAllTopics();
	}
	
	/**
	 * GET /topics/{id}
	 * 
	 * @param id 某个 id
	 * @return 返回某个 id 的主题
	 */
	@RequestMapping(value="/topics/{id}", method=RequestMethod.GET)
	public Topic getTopic(@PathVariable String id) {
		return topicService.getTopic(id);
	}
	
	/**
	 * POST /topics
	 * 
	 * @param topic 主题
	 */
	@RequestMapping(value="/topics", method=RequestMethod.POST)
	public void addTopic(@RequestBody Topic topic) {
		topicService.addTopic(topic);
	}
	
	/**
	 * PUT /topics/{id}
	 * 
	 * @param id 某个 id
	 */
	@RequestMapping(value="/topics/{id}", method=RequestMethod.PUT)
	public void updateTopic(@PathVariable String id, @RequestBody Topic topic) {
		topicService.updateTopic(id, topic);
	}
	
	/**
	 * DELETE /topics/{id}
	 * 
	 * @param id 某个 id
	 */
	@RequestMapping(value="/topics/{id}", method=RequestMethod.DELETE)
	public void deleteTopic(@PathVariable String id) {
		topicService.deleteTopic(id);
	}
}
