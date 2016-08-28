package org.lucaszhang.javarest.messenger.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.lucaszhang.javarest.messenger.model.Profile;
import org.lucaszhang.javarest.messenger.service.ProfileService;

@Path("/profile")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ProfileResource {
	
	ProfileService profileService = new ProfileService();
	
	@GET
	public List<Profile> getAllProfiles() {
		return profileService.getAllProfiles();
	}
	
	@POST
	public Profile postProfile(Profile profile) {
		return profileService.addProfile(profile);
	}
	
	@PUT
	@Path("/{profileName}")
	public Profile putProfile(@PathParam("profileName")String profileName, Profile profile) {
		profile.setProfileName(profileName);
		return profileService.updateProfile(profile);
	}
	
	@DELETE
	@Path("/{profileName}")
	public void deleteProfile(@PathParam("profileName")String profileName) {
		profileService.removeProfile(profileName);
	}
	
	@GET
	@Path("/{profileName}")
	public Profile getProfileByName(@PathParam("profileName")String profileName) {
		return profileService.getProfile(profileName);
	}
}
