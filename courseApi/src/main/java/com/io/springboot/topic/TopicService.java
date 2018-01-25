package com.io.springboot.topic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class TopicService {
	private List<Topic> topics = new ArrayList<>(Arrays.asList(
			new Topic("spring", "spring framework", "spring description"),
			new Topic("bootstrap", "bootstrap framework", "bootstrap description"),
			new Topic("javascript", "javascript framework", "javascript description")				
			));
	
	// Get all topics
	public List<Topic> getAllTopics(){
		return topics;
	}
	
	// Get topic by id
	public Topic getTopic(String id) {
		return topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();
	}
	
	// Post topic by body
	public void postTopic(Topic topic) {
		topics.add(topic);		
	}
	
	// Update a topic by id and body
	public void updateTopic(String id, Topic topic) {
		for(int i=0;i<topics.size();i++) {
			Topic t = topics.get(i);
			if(t.getId().equals(id)) {
				topics.set(i, topic);
				return;
			}
		}
	}
	
	// Delete a topic by id
	public void deleteTopic(String id) {
		for(int i=0;i<topics.size();i++) {
			Topic t = topics.get(i);
			if(t.getId().equals(id)) {
				topics.remove(i);
				return;
			}
		}
	}
}
