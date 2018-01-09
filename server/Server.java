/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import function.Function;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.PrintStream;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Stream;
import network.Request;
import network.ClientRequest;
import network.ServerRequest;
import userData.Message;

/**
 *
 * @author gauthier
 */
public class Server {

	private static final long serialVersionUID = 1L;
	private String tag = Function.color(this);

	private int listenPort;
	private int maxLog;
	private ServerSocket serverSocket;
//	private int nbThread;
	private Bdd bdd;
	private InterfaceServer ihm;
	private List<ThreadServer> threads;
//	private List<Socket> allSocketClient;

	public Server(int listenPort, int maxLog, Bdd bdd, InterfaceServer ihm) throws IOException {
		this.listenPort = listenPort;
		this.maxLog = maxLog;
//		this.nbThread =0;
		this.bdd = bdd;
		this.ihm = ihm;

		this.threads = new ArrayList<>();

//		allSocketClient =new ArrayList<>();
		openingCommunication();
	}

	public void openingCommunication() throws IOException {
		serverSocket = new ServerSocket(listenPort, maxLog);
		System.out.println("[Server]" + tag + serverSocket);
	}

	void waitClient() {
		Server server = this;
		new Thread() {
			@Override
			public void run() {
				try {
					Socket clientSocket;
					Thread thread;
					// close first client, not a really client
					clientSocket = serverSocket.accept();
					clientSocket.close();

					while (true) {
						// new client
						clientSocket = serverSocket.accept();
//						allSocketClient.add(clientSocket);

						ThreadServer ts = new ThreadServer(server, clientSocket);
						thread = new Thread(ts);
						System.out.println("[Server]" + tag + "new thread client : " + clientSocket);
						thread.start();

						threads.add(ts);
//						nbThread++;
//				thread.run();
					}
				} catch (IOException ex) {
					System.out.print("[Server] " + tag + "waitClient failed");
					Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
					System.exit(1);
				}
			}
		}.start();
	}

	public Bdd getBdd() {
		return bdd;
	}

	void broadcast(List<Message> lm) {
		for (ThreadServer ts : threads) {
//			sendRequest(ts.getSocket(), ServerRequest.MAJ_MESSAGES, lm);
			ts.sendRequest(ServerRequest.MAJ_MESSAGES, lm);
		}
	}

	void broadcast(Message m) {
		List<Message> lm = new ArrayList<>();
		lm.add(m);
		for (ThreadServer ts : threads) {
//			sendRequest(ts.getSocket(), ServerRequest.MAJ_MESSAGES, lm);
			ts.sendRequest(ServerRequest.MAJ_MESSAGES, lm);
		}
	}

	void loseClient(ThreadServer ts) {
		System.out.println("[Server] client " + ts.getSocket() + " definitely lost");
		threads.remove(ts);
//		allSocketClient.remove(socket);
//		thr
	}

	public Integer getNbThreads() {
		return threads.size();
	}
}
