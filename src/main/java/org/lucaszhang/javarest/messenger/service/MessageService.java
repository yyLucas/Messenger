package org.lucaszhang.javarest.messenger.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import org.lucaszhang.javarest.messenger.database.DatabaseClass;
import org.lucaszhang.javarest.messenger.exception.DataNotFoundException;
import org.lucaszhang.javarest.messenger.model.Message;

public class MessageService {
	
	private Map<Long, Message> messages;
	
	public MessageService(){
		this.messages = DatabaseClass.getMessages();
	}
	
	public List<Message> getAllMessages(){
		return new ArrayList<Message>(messages.values());	
	}
	
	public List<Message> getAllMessages(int year){
		List<Message> messageForYear = new ArrayList<Message>(); 
		Calendar calendar = Calendar.getInstance();
		for(Message message : messages.values()){
			calendar.setTime(message.getCreateDate());
			if(calendar.get(Calendar.YEAR) == year){
				messageForYear.add(message);
			}
		}
		return messageForYear;	
	}
	
	public Message getMessages(long id){
		Message newMessage = messages.get(id);
		if(newMessage == null){
			throw new DataNotFoundException("Message with id " + id +" not found");
		}
		return newMessage;
	}
	
	public Message addMessages(Message message){
		message.setId(messages.size() +1);
		messages.put(message.getId(), message);
		return message;
	}
	
	public Message updateMessages(Message message){
		if(message.getId() <= 0){
			return null;
		}
		messages.put(message.getId(), message);
		return message;
	}
	
	public Message removeMessages(long id){
		return messages.remove(id);
	}

}
