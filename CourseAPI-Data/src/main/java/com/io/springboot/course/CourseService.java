package com.io.springboot.course;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseService {
	
	@Autowired
	private CourseRepository courseRepository;
	
	
	// Get all topics
	public List<Course> getAllCourses(String topicId){
		List<Course> courses = new ArrayList<>(); 
		courseRepository.findByTopicId(topicId).forEach(courses::add);
		return courses;
	}
	
	// Get topic by id
	public Course getCourse(String id) {
		return courseRepository.findOne(id);
	}
	
	// Post topic by body
	public void postCourse(Course course) {
		courseRepository.save(course);		
	}
	
	// Update a topic by id and body
	public void updateCourse(Course course) {
		courseRepository.save(course);
	}
	
	// Delete a topic by id
	public void deleteCourse(String id) {
		courseRepository.delete(id);
	}
}
