/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import function.Function;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.NavigableSet;
import java.util.Set;
import java.util.TreeSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import network.Request;
import network.ClientRequest;
import userData.Message;

/**
 *
 * @author gauthier
 */
public class Client {

	private String ipServer;
	private int portServer;
	private InterfaceClient ihm;
	private Set<Message> messages;

	private Socket socket;

	private String tag = Function.color(this);

	public Client(String ipServer, int portServer, InterfaceClient ihm) throws IOException {
		this.ipServer = ipServer;
		this.portServer = portServer;
		this.ihm = ihm;

		socket = new Socket(ipServer, portServer);

		Thread thread = new Thread(new ThreadClient(this));
		System.out.println("[Client]" + tag + "new thread client : " + socket);
		thread.start();
	}

	public void sendRequest(ClientRequest requestName, Object... params) {
//		Request.sendRequest(socket, requestName, params);
		new Request<>(requestName, params).sendRequest(socket);
	}

	public Socket getSocket() {
		return socket;
	}

	public InterfaceClient getIhm() {
		return ihm;
	}

	void setMessages(ArrayList<Object> params) {
		messages = new TreeSet<>();
		for (Object o : params) {
			messages.add((Message) o);
		}
	}

	Set<String> getGroups() {
		NavigableSet<String> set = new TreeSet<>();
		for (Message m : messages) {
			set.add(m.getGroup());
		}
		return set;
	}

	List<String> getTicket(String g) {
//		System.out.println(g);
		NavigableSet<Message> set = new TreeSet<>(new Comparator<Message>() {
			@Override
			// first element is the most recent, normaly in right side with default compareto of Timestamp
			public int compare(Message o1, Message o2) {
				return -o1.getCreate().compareTo(o2.getCreate());
			}
		});

		for (Message m : messages) {
			if (m.getGroup().equals(g)) {
				set.add(m);
			}
		}
//		System.out.println(set);

		List<String> l = new ArrayList<>();
		for (Message m : set) {
			if (!l.contains(m.getTicket())) {
				l.add(m.getTicket());
			}
		}
//		System.out.println(l);

		return l;
	}

	Set<Message> getTicketMessages(String ticket) {
		NavigableSet<Message> set = new TreeSet<>(new Comparator<Message>() {
			@Override
			// last element is the most recent message
			public int compare(Message o1, Message o2) {
				return o1.getCreate().compareTo(o2.getCreate());
			}
		});

		for (Message m : messages) {
			if (m.getTicket().equals(ticket)) {
				set.add(m);
			}
		}
		return set;
	}

	void addMessage(Message m) {
		messages.add(m);
	}

	void addMessages(List<Message> lm) {
		messages.removeAll(lm);
		messages.addAll(lm);
	}

	void delMessage(Message m) {
		messages.remove(m);
	}

	String nbNotReadMessageOfTicket(String t, String user) {
		int cpt = 0;
		for (Message m : getTicketMessages(t)) {
			if (!m.isAlreadyReadBy(user)) {
				cpt++;
			}
		}
		return cpt + "";
	}

	String nbNotReadMessageInGroup(String g, String actualUser) {
		int cpt = 0;
		for (String ticket : getTicket(g)) {
			cpt += Integer.parseInt(nbNotReadMessageOfTicket(ticket, actualUser));

		}
		return cpt + "";
	}

	List<String> getAllTickets() {
		List<String> ls = new ArrayList<>();
		for (Message m : messages) {
			String ticket = m.getTicket();
			if (!ls.contains(ticket)) {
				ls.add(ticket);
			}
		}
		return ls;
	}

}
