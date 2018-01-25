package com.io.springboot.topic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TopicService {
	
	@Autowired
	private TopicRepository topicRepository;
	

	// Get all topics
	public List<Topic> getAllTopics(){
		List<Topic> topics = new ArrayList<>(); 
		topicRepository.findAll().forEach(topics::add);
		return topics;
	}
	
	// Get topic by id
	public Topic getTopic(String id) {
		return topicRepository.findOne(id);
	}
	
	// Post topic by body
	public void postTopic(Topic topic) {
		topicRepository.save(topic);		
	}
	
	// Update a topic by id and body
	public void updateTopic(String id, Topic topic) {
		topicRepository.save(topic);
	}
	
	// Delete a topic by id
	public void deleteTopic(String id) {
		topicRepository.delete(id);
	}
}
