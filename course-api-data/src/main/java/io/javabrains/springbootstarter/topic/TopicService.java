package io.javabrains.springbootstarter.topic;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TopicService {

	@Autowired
	private TopicRepository topicRepository;

	/**
	 * 查找所有的主题
	 * 
	 * @return 主题列表
	 */
	public List<Topic> getAllTopics() {
		List<Topic> topics = new ArrayList<>();
		topicRepository.findAll().forEach(topics::add);
		return topics;
	}

	/**
	 * 根据主题 id 查找某个主题
	 * 
	 * @param id
	 *            主题 id
	 * @return 主题
	 */
	public Topic getTopic(String id) {
		return topicRepository.findOne(id);
	}

	/**
	 * 新增一个主题
	 * 
	 * @param topic
	 *            主题
	 */
	public void addTopic(Topic topic) {
		topicRepository.save(topic);
	}

	/**
	 * 更新一个主题
	 * 
	 * @param id
	 *            主题 id
	 * @param topic
	 *            主题
	 */
	public void updateTopic(String id, Topic topic) {
		topicRepository.save(topic);
	}

	/**
	 * 删除一个主题
	 * 
	 * @param id
	 *            主题 id
	 */
	public void deleteTopic(String id) {
		topicRepository.delete(id);
	}
}
