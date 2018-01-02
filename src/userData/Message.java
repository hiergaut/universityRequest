/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userData;

import java.io.Serializable;
import java.util.Date;

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
	private Date create;

	public Message(Integer id, String group, String ticket, String author, String body, Date create) {
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
	
	
}
