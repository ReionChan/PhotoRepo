package io.javabrains.springbootstarter.course;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface CourseRepository extends CrudRepository<Course, String>{
	/**
	 * Spring Data JPA 的约定 findBy[Property]
	 * 如果 [Property] 是一个对象，然而传入的又只是这个对象的一个属性，
	 * 那么 继续沿用约定，再接此对象的 [Property]
	 * 
	 * 拿本例来说：findByTopicId
	 * 意思就是 findBy {Course[Topic(id)]}
	 * 				     ↑      ↑    ↑
	 *                  对象    对象  属性
	 * 
	 * @param topicId
	 * @return
	 */
	public List<Course> findByTopicId(String topicId);
}
