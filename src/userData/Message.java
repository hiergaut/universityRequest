/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userData;

import java.io.Serializable;

/**
 *
 * @author gauthier
 */
public class Message implements Serializable, Comparable<Message> {
	private static final long serialVersionUID =1L;

	private Integer id;
	private String group;
	private String ticket;
	private String author;
	private String body;
	private String create;

	public Message(Integer id, String body, String create,  String author, String ticket, String group) {
		this.id = id;
		this.group = group;
		this.ticket = ticket;
		this.author = author;
		this.body = body;
		this.create = create;
	}

	

	public int getId() {
		return id;
	}

	@Override
	public int compareTo(Message o) {
		return id.compareTo(o.id);
	}

	public String getGroup() {
		return group;
	}

	public String getTicket() {
		return ticket;
	}

	public String getAuthor() {
		return author;
	}

	public String getBody() {
		return body;
	}

	public String getCreate() {
		return create;
	}
	
	
	
	
}
