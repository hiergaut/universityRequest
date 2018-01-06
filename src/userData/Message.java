/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userData;

import java.awt.Color;
import java.io.Serializable;
import java.sql.Timestamp;

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
	private String firstName;
	private String lastName;
	private String body;
	private Timestamp create;
	private StatusMessage status;
	private String[][] usersStatus;

	public Message(Integer id, String body, Timestamp create, String author, String firstName, String lastName, String ticket, String group, StatusMessage status, String[][] userStatus) {
		this.id = id;
		this.group = group;
		this.ticket = ticket;
		this.author =author;
		this.firstName =firstName;
		this.lastName =lastName;
		this.body = body;
		this.create = create;
		this.status =status;
		this.usersStatus =userStatus;
	}
	

	public int getId() {
		return id;
	}

	@Override
	public int compareTo(Message o) {
		return id.compareTo(o.id);
	}

	@Override
	public boolean equals(Object obj) {
		Message cast =(Message)obj;
		return cast.getId() == id;
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

	public Timestamp getCreate() {
		return create;
	}

	@Override
	public String toString() {
		return "\nid =" +id +", ticket=" +ticket +", created=" +create;
	}

	public StatusMessage getStatus() {
		return status;
	}
	
	public Color stateColor() {
		switch (status) {
			case SERVER_NOT_RECEIVE:
				return Color.GRAY;

			case GROUP_NOT_RECEIVE:
				return Color.RED;

			case GROUP_NOT_READ:
				return Color.ORANGE;

			case GROUP_READ:
				return Color.GREEN;
		}
		return null;
	}

	public String[][] getUsersStatus() {
		return usersStatus;
	}

	public boolean isAlreadyReadBy(String actualUser) {
		for (String[] ls : usersStatus) {
			if (ls[0].equals(actualUser))
				return ls[1].equals("lu");
		}
		return false;
	}
	
}
