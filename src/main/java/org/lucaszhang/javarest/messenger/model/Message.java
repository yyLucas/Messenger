package org.lucaszhang.javarest.messenger.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;


@XmlRootElement
public class Message {

	private long id;
	private String message;
	private Date createDate;
	private String author;
	private Map<Long, Comment> comments = new HashMap<>();
	private List<Link> links = new ArrayList<Link>();
	
	public Message(){
		
	}
	
	public Message(long id, String message, String aauthor) {
		this.id = id;
		this.message = message;
		this.createDate = new Date();
		this.author = aauthor;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}

	@XmlTransient
	public Map<Long, Comment> getComments() {
		return comments;
	}

	public void setComments(Map<Long, Comment> comments) {
		this.comments = comments;
	}

	public List<Link> getLink() {
		return links;
	}

	public void setLink(List<Link> link) {
		this.links = link;
	}
	
	public void addLink(String url, String relation){
		Link link = new Link();
		link.setLink(url);
		link.setRelation(relation);
		links.add(link);	
	}
	
}
