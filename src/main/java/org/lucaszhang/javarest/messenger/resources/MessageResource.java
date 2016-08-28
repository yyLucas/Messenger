package org.lucaszhang.javarest.messenger.resources;

import java.net.URI;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import org.lucaszhang.javarest.messenger.model.Message;
import org.lucaszhang.javarest.messenger.service.MessageService;

@Path("/message")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class MessageResource {

	MessageService messageService = new MessageService();
	
	@GET
	public List<Message> getAllMessages(@QueryParam("year") int year) {
		if(year>0){
			return messageService.getAllMessages(year);
		}
		return messageService.getAllMessages();
	}
	
	@POST
	public Response postMessage(Message message, @Context UriInfo uriInfo){
		Message newMessage = messageService.addMessages(message);
		URI uri = getUriForSelf(uriInfo, newMessage);
		//URI uri = uriInfo.getAbsolutePathBuilder().path(String.valueOf(newMessage.getId())).build();
		return Response.created(uri).entity(newMessage).build();	
	}
	
	@PUT
	@Path("/{messageId}")
	public Message putMessage(@PathParam("messageId")long messageId, Message message) {
		message.setId(messageId);
		return messageService.updateMessages(message);
	}
	
	@DELETE
	@Path("/{messageId}")
	public void deleteMessage(@PathParam("messageId")long messageId) {
		messageService.removeMessages(messageId);
		//return "message deleted";
	}
	
	@GET
	@Path("/{messageId}")
	public Message getMessageById(@PathParam("messageId")long messageId, @Context UriInfo uriInfo) {
		Message newMessage = messageService.getMessages(messageId);
		newMessage.addLink(getUriForSelf(uriInfo, newMessage).toString(), "self");
		newMessage.addLink(getUriForProfile(uriInfo, newMessage).toString(), "profile");
		newMessage.addLink(getUriForComment(uriInfo, newMessage).toString(), "comments");
		return newMessage;
	}
	
	private URI getUriForComment(UriInfo uriInfo, Message message) {
		URI uri = uriInfo.getBaseUriBuilder()
							.path(MessageResource.class)
							.path(MessageResource.class, "getCommentResource")
							.resolveTemplate("messageId", message.getId())
							.build();
		return uri;
	}

	private URI getUriForSelf(UriInfo uriInfo, Message message) {
		URI uri = uriInfo.getBaseUriBuilder()
							.path(MessageResource.class)
							.path(Long.toString(message.getId()))
							.build();
		return uri;
	}
	
	private URI getUriForProfile(UriInfo uriInfo, Message message) {
		URI uri = uriInfo.getBaseUriBuilder()
							.path(ProfileResource.class)
							.path(message.getAuthor())
							.build();
		return uri;
	}
	
	@Path("/{messageId}/comment")
	public CommentResource getCommentResource(){
		return new CommentResource();
	}
}
