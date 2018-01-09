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
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.print.attribute.standard.RequestingUserName;
import network.Request;
//import static network.Request.recvRequest;
import network.ClientRequest;
import network.ServerRequest;
import userData.Message;
import userData.StatusMessage;

/**
 *
 * @author gauthier
 */
public class ThreadServer implements Runnable {

	private String tag = Function.color(this);

	private Server server;
	private Socket socket;
	private String actualConnectUser = "";

	public ThreadServer(Server server, Socket socket) {
		this.server = server;
		this.socket = socket;
	}

	public void sendRequest(ServerRequest requestName, Object... params) {
		new Request<>(requestName, params).sendRequest(socket);
	}

	@Override
	public void run() {
		Bdd bdd = server.getBdd();

		boolean stay = true;
		while (stay) {
//			Request request = Request.recv(socket);
//			Request<ClientRequest> request = recvRequest(socket);
			Request<ClientRequest> clientRequest = null;
			try {
				clientRequest = new Request<>(socket);
			} catch (IOException ex) {
				Logger.getLogger(ThreadServer.class.getName()).log(Level.SEVERE, null, ex);
			}
//			clientRequest.recvRequest(socket);
			System.out.println("[ThreadServer]" + tag + "Request :" + clientRequest);

			if (clientRequest != null) {
				ArrayList<Object> params = clientRequest.getParams();
				switch (clientRequest.getRequestName()) {
					case IDENTIFICATION:
						String login = (String) params.get(0);
						String passwd = (String) params.get(1);

						if (bdd.identification(login, passwd)) {
							sendRequest(ServerRequest.IDENTIFICATION_OK, login);
							sendRequest(ServerRequest.INIT_HOME, bdd.getMessages(login));
							actualConnectUser = login;
						} else {
							sendRequest(ServerRequest.IDENTIFICATION_FAILED, login);
						}
						break;

					case NEW_USER:
						login = (String) params.get(0);
						passwd = (String) params.get(1);
						String firstName = (String) params.get(2);
						String name = (String) params.get(3);
						String status = (String) params.get(4);

						String message = bdd.newUser(login, passwd, firstName, name, status);
						sendRequest(ServerRequest.NEW_USER_RESPONSE, message);
//						Request.sendRequest(socket, RequestName.INIT_HOME, bdd.getMessages(name));
						break;

					case ALL_GROUP:
//						sendRequest(ServerRequest.ALL_GROUP_RESPONSE, bdd.allGroups((String)params.get(0)));
						sendRequest(ServerRequest.ALL_GROUP_RESPONSE, bdd.allGroups(actualConnectUser));
						break;

					case NEW_MESSAGE:
						Message m = bdd.newMessage((Message) params.get(0));
						server.broadcast(m);
						break;

					case READ_MESSAGES:
						String user = (String) params.get(0);
						List<Integer> idMessages = (List) params.get(1);

						for (Integer idMessage : idMessages) {
							bdd.userReadMessage(user, idMessage);
						}

						List<Message> lm = new ArrayList<>();
						for (Integer idMessage : idMessages) {
							lm.add(bdd.getMessage(idMessage));
						}
						server.broadcast(lm);
						break;

					case ADD_GROUP:
						String group = (String) params.get(0);
						bdd.addUserInGroup(actualConnectUser, group);

						sendRequest(ServerRequest.ALL_GROUP_RESPONSE, bdd.allGroups(actualConnectUser));
						break;

					case DEL_GROUP:
						group = (String) params.get(0);
						bdd.delUserOfGroup(actualConnectUser, group);

						sendRequest(ServerRequest.ALL_GROUP_RESPONSE, bdd.allGroups(actualConnectUser));
						break;

					case ALL_GROUP_FOR_TICKET:
						sendRequest(ServerRequest.ALL_GROUP_FOR_TICKET_RESPONSE, bdd.allGroups());
						break;

					case NEW_TICKET:
						String title = (String) params.get(0);
						String author = (String) params.get(1);
						group = (String) params.get(2);

						String bodyMessage = (String) params.get(3);
						bdd.newTicket(title, author, group);

						int id = -1;
						String body = bodyMessage;
						Timestamp create = new Timestamp(System.currentTimeMillis());
						String ticket = title;
						String firstname = "";
						name = "";

						m = new Message(id, body, create, author, firstname, name, ticket, group, StatusMessage.SERVER_NOT_RECEIVE, null);
						m = bdd.newMessage(m);
						server.broadcast(m);
						break;
				}
			} else {
//				System.out.println("[ThreadServer] null request");
				stay = false;
				server.loseClient(this);
			}
		}

//		System.out.println("[ThreadServer] end of thread");
	}

	public Socket getSocket() {
		return socket;
	}

}
