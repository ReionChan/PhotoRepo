package io.javabrains.springbootstarter.topic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class TopicService {
	private List<Topic> topics = new ArrayList<Topic>(Arrays.asList(
					new Topic("spring", "Spring Framework", "Spring Framework Description"),
					new Topic("java", "Core java", "Core java Description"),
					new Topic("javascript", "Javascript", "Javascript Description")));
	
	/**
	 * 查找所有的主题
	 * 
	 * @return 主题列表
	 */
	public List<Topic> getAllTopics() {
		return topics;
	}

	/**
	 * 根据主题 id 查找某个主题
	 * 
	 * @param id 主题 id
	 * @return 主题
	 */
	public Topic getTopic(String id) {
		return topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();
	}

	/**
	 * 新增一个主题
	 * 
	 * @param topic 主题
	 */
	public void addTopic(Topic topic) {
		if (!topics.contains(topic)) {
			topics.add(topic);
		}
	}
	
	/**
	 * 更新一个主题
	 * 
	 * @param id 主题 id
	 * @param topic 主题
	 */
	public void updateTopic(String id, Topic topic) {
		int index = topics.indexOf(topic);
		if (index < 0) return;
		topics.set(index, topic);
	}
	
	/**
	 * 删除一个主题
	 * 
	 * @param id 主题 id
	 */
	public void deleteTopic(String id) {
		for(int i=0; i<topics.size(); i++) {
			if (topics.get(i).getId().equals(id)) {
				topics.remove(i);
			}
		}
	}
}
