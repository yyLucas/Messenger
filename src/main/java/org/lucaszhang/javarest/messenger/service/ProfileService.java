package org.lucaszhang.javarest.messenger.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.lucaszhang.javarest.messenger.database.DatabaseClass;
import org.lucaszhang.javarest.messenger.model.Profile;

public class ProfileService {
	
	private Map<String, Profile> profiles;
	
	public ProfileService(){
		this.profiles = DatabaseClass.getProfiles();
	}
	
	public List<Profile> getAllProfiles(){
		return new ArrayList<Profile>(profiles.values());	
	}
	
	public Profile getProfile(String profileName){
		return profiles.get(profileName);
	}
	
	public Profile addProfile(Profile profile){
		profile.setId(profiles.size() +1);
		profiles.put(profile.getProfileName(), profile);
		return profile;
	}
	
	public Profile updateProfile(Profile profile){
		if(profile.getProfileName().isEmpty()){
			return null;
		}
		profiles.put(profile.getProfileName(), profile);
		return profile;
	}
	
	public Profile removeProfile(String profileName){
		return profiles.remove(profileName);
	}
}
