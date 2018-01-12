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
		String allStatus ="";
		if (usersStatus != null)
			for (String ls[] : usersStatus) {
				allStatus +="[" +ls[0] +", " +ls[1] +"] ";
			}
		return "id =" +id +", body =" +body +", ticket=" +ticket +", created=" +create +", status =" +status +" allStatus =" +allStatus +"\t";
	}

	public StatusMessage getStatus() {
		return status;
	}
	
	public Color stateColor() {
		switch (status) {
			case SERVER_NOT_RECEIVE: // gray
				return new java.awt.Color(236, 240, 241);

			case GROUP_NOT_RECEIVE: // red
				return new java.awt.Color(188,7,46);

			case GROUP_NOT_READ: // orange
				return new java.awt.Color(211, 84, 0);

			case GROUP_READ: // green
				return new java.awt.Color(39, 174, 96);
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

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}
	
	
}
