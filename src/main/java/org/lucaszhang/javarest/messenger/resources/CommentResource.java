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

import org.lucaszhang.javarest.messenger.model.Comment;
import org.lucaszhang.javarest.messenger.service.CommentService;

@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class CommentResource {
	
	private CommentService commentService = new CommentService();

	@GET
	public List<Comment> getAllComments(@PathParam("messageId") long messageId){
		return commentService.getAllComment(messageId);
	}
	
	@GET
	@Path("/{commentId}")
	public Comment getComment(@PathParam("messageId") long messageId, @PathParam("commentId") long commentId){
		return commentService.getComment(messageId,commentId);
	}
	
	@PUT
	@Path("/{commentId}")
	public Comment putComment(@PathParam("messageId") long messageId, Comment comment){
		return commentService.updateComment(messageId,comment);
	}
	
	@POST
	public Comment postComment(@PathParam("messageId") long messageId, Comment comment){
		return commentService.addComment(messageId,comment);
	}
	
	@DELETE
	@Path("/{commentId}")
	public Comment deleteComment(@PathParam("messageId") long messageId, @PathParam("commentId") long commentId){
		return commentService.removeComment(messageId,commentId);
	}
}
