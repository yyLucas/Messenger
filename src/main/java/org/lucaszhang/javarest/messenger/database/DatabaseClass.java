package org.lucaszhang.javarest.messenger.database;

import java.util.HashMap;
import java.util.Map;

import org.lucaszhang.javarest.messenger.model.Message;
import org.lucaszhang.javarest.messenger.model.Profile;

public class DatabaseClass {

	private static Map<Long, Message> messages = new HashMap<>();
	private static Map<String, Profile> profiles = new HashMap<>();

	public static Map<Long, Message> getMessages() {
		messages.put(1L, new Message(1L, "first Message", "Lucas"));
		messages.put(2L, new Message(2L, "second Message", "Lucas"));
		return messages;
	}
	
	public static Map<String, Profile> getProfiles() {
		profiles.put("first", new Profile(1L, "first","lucas", "zhang"));
		return profiles;
	}
	
}
