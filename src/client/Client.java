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
import java.util.List;
import java.util.NavigableSet;
import java.util.Set;
import java.util.TreeSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import network.Request;
import network.RequestName;
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

	private String tag =Function.color(this);

	public Client(String ipServer, int portServer, InterfaceClient ihm) throws IOException {
		this.ipServer = ipServer;
		this.portServer = portServer;
		this.ihm =ihm;

		socket = new Socket(ipServer, portServer);

		Thread thread = new Thread(new ThreadClient(this));
		System.out.println("[Client]" +tag +"new thread client : "+ socket);
		thread.start();
	}

	public void sendRequest(RequestName requestName, Object... params) {
		Request.sendRequest(socket, requestName, params);
	}

	public Socket getSocket() {
		return socket;
	}

	public InterfaceClient getIhm() {
		return ihm;
	}

	void setMessages(ArrayList<Object> params) {
		messages =new TreeSet<>();
		for (Object o : params) {
			messages.add((Message)o);
		}
	}

	Set<String> getGroups() {
		NavigableSet<String> set =new TreeSet<>();
		for (Message m : messages) {
			set.add(m.getGroup());
		}
		return set;
	}

	Set<String> getTicket(String g) {
		NavigableSet<String> set =new TreeSet<>();
		for (Message m : messages) {
			if (m.getGroup().equals(g)) {
				set.add(m.getTicket());
			}
		}
		return set;
	}
	
}
