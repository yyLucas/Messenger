package org.lucaszhang.javarest.messenger.model;

public class Link {
	
	private String link;
	private String relation;
	
	public Link(){
		
	}
	
	public Link(String link, String relation) {
		this.link = link;
		this.relation = relation;
	}
	
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	public String getRelation() {
		return relation;
	}
	public void setRelation(String relation) {
		this.relation = relation;
	}

}
