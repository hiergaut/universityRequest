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
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Stream;
import network.Request;

/**
 *
 * @author gauthier
 */
public class Server {
	private static final long serialVersionUID =1L;
	private int listenPort;
	private int maxLog;
	private ServerSocket serverSocket;
	private int nbThread;
	private Bdd bdd;
	private InterfaceServer ihm;

	private String tag =Function.color(this);

	public Server(int listenPort, int maxLog, Bdd bdd, InterfaceServer ihm) throws IOException {
		this.listenPort = listenPort;
		this.maxLog = maxLog;
		this.nbThread =0;
		this.bdd = bdd;
		this.ihm = ihm;

		openingCommunication();
	}

	public void openingCommunication() throws IOException {
		serverSocket =new ServerSocket(listenPort, maxLog);
		System.out.println("[Server]" +tag + serverSocket);
	}
	
	void waitClient() {
		Socket clientSocket;
		Thread thread;

		try {
			// close first client, not a really client
			clientSocket = serverSocket.accept();
			clientSocket.close();

			while (true) {
				clientSocket = serverSocket.accept();

				thread = new Thread(new ThreadServer(this, clientSocket));
				System.out.println("[Server]" +tag +"new thread client : "+ clientSocket);
				thread.start();
				nbThread++;
//				thread.run();
			}
		} catch (IOException ex) {
			System.out.print("[Server] "+ tag +"waitClient failed");
			Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
			System.exit(1);
		}
	}

	public Bdd getBdd() {
		return bdd;
	}
}
