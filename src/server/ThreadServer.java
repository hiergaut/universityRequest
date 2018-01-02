/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import function.Function;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import network.Request;
import static network.Request.recvRequest;
import network.RequestName;

/**
 *
 * @author gauthier
 */
public class ThreadServer implements Runnable {
	private Server server;
	private Socket socket;

	private String tag =Function.color(this);
	
	public ThreadServer(Server server, Socket socket) {
		this.server =server;
		this.socket =socket;
	}

	public void sendRequest(RequestName requestName, Object... params) {
		Request.sendRequest(socket, requestName, params);
	}
	
	@Override
	public void run() {
		Bdd bdd =server.getBdd();
		
		boolean stay =true;
		while (stay) {
//			Request request = Request.recv(socket);
			Request request = recvRequest(socket);
			System.out.println("[ThreadServer]" +tag +"Request :" +request);
			
			if (request != null) {
				ArrayList<Object> params = request.getParams();
				switch (request.getRequestName()) {
					case IDENTIFICATION:
						String login =(String)params.get(0);
						String passwd =(String)params.get(1);

						if (bdd.identification(login, passwd)) {
							sendRequest(RequestName.IDENTIFICATION_OK, login);
							sendRequest(RequestName.INIT_HOME, bdd.getMessages(login));
						}
						else {
							sendRequest(RequestName.IDENTIFICATION_FAILED, login);
						}
						break;
						
					case NEW_USER:
						login =(String)params.get(0);
						passwd =(String)params.get(1);
						String firstName =(String)params.get(2);
						String name =(String)params.get(3);
						String status =(String)params.get(4);

						bdd.newUser(login, passwd, firstName, name, status);
//						Request.sendRequest(socket, RequestName.INIT_HOME, bdd.getMessages(name));
						break;

					case ALL_GROUP:
						sendRequest(RequestName.ALL_GROUP_RESPONSE, bdd.allGroups());
						break;
				}
			}
			else {
//				System.out.println("[ThreadServer] null request");
				stay =false;
			}
		}

//		System.out.println("[ThreadServer] end of thread");
	}
}