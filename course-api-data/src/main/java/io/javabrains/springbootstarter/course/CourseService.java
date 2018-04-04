package io.javabrains.springbootstarter.course;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseService {

	@Autowired
	private CourseRepository courseRepository;

	/**
	 * 查找所有的课程
	 * 
	 * @return 课程列表
	 */
	public List<Course> getAllCourses(String topicId) {
		return courseRepository.findByTopicId(topicId);
	}

	/**
	 * 根据课程 id 查找某个课程
	 * 
	 * @param id
	 *            课程 id
	 * @return 课程
	 */
	public Course getCourse(String id) {
		return courseRepository.findOne(id);
	}

	/**
	 * 新增一个课程
	 * 
	 * @param course
	 *            课程
	 */
	public void addCourse(Course course) {
		courseRepository.save(course);
	}

	/**
	 * 更新一个课程
	 * 
	 * @param course
	 *            课程
	 */
	public void updateCourse(Course course) {
		courseRepository.save(course);
	}

	/**
	 * 删除一个课程
	 * 
	 * @param id
	 *            课程 id
	 */
	public void deleteCourse(String id) {
		courseRepository.delete(id);
	}
}
