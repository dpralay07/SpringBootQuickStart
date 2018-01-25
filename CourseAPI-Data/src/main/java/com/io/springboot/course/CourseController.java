package com.io.springboot.course;

//import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.io.springboot.topic.Topic;

@RestController
public class CourseController {
	@Autowired
	private CourseService courseService;
	
	@RequestMapping("/topics/{id}/courses")
	public List<Course> getAllCourses(@PathVariable String id){
		return courseService.getAllCourses(id);
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/topics/{topicId}/courses/{id}")
	public Course getCourse(@PathVariable String id) {
		return courseService.getCourse(id);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/topics/{topicId}/courses")
	public String postCourse(@RequestBody Course course, @PathVariable String topicId) {
		course.setTopic(new Topic(topicId, "", ""));
		courseService.postCourse(course);
		return "Post Successful";
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="topics/{topicId}/courses/{id}")
	public String updateCourse(@PathVariable String id,@RequestBody Course course, @PathVariable String topicId) {
		course.setTopic(new Topic(topicId, "", ""));
		courseService.updateCourse(course);
		return "Update Successful";
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="topics//{topicId}/courses/{id}")
	public String deleteCourse(@PathVariable String id) {
		courseService.deleteCourse(id);
		return "Deletion Successful";
	}
}
