package io.javabrains.springbootstarter.course;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.javabrains.springbootstarter.topic.Topic;

@RestController
public class CourseController {
	
	@Autowired
	private CourseService courseService;
	
	/**
	 * @return 返回所有主题
	 */
	@RequestMapping(value="/topics/{topicId}/courses", method=RequestMethod.GET)
	public List<Course> getAllCourses(@PathVariable String topicId) {
		return courseService.getAllCourses(topicId);
	}
	
	/**
	 * @param id 某个 id
	 * @return 返回某个 id 的主题
	 */
	@RequestMapping(value="/topics/{topicId}/courses/{id}", method=RequestMethod.GET)
	public Course getCourse(@PathVariable String id) {
		return courseService.getCourse(id);
	}
	
	/**
	 * @param topic 主题
	 */
	@RequestMapping(value="/topics/{topicId}/courses", method=RequestMethod.POST)
	public void addCourse(@PathVariable String topicId, @RequestBody Course course) {
		course.setTopic(new Topic(topicId, "", ""));
		courseService.addCourse(course);
	}
	
	/**
	 * @param id 某个 id
	 */
	@RequestMapping(value="/topics/{topicId}/courses/{id}", method=RequestMethod.PUT)
	public void updateCourse(@PathVariable String topicId, @RequestBody Course course) {
		course.setTopic(new Topic(topicId, "", ""));
		courseService.updateCourse(course);
	}
	
	/**
	 * @param id 某个 id
	 */
	@RequestMapping(value="/topics/{topicId}/courses/{id}", method=RequestMethod.DELETE)
	public void deleteCourse(@PathVariable String id) {
		courseService.deleteCourse(id);
	}
}
