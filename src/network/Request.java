/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package network;

import function.Function;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author gauthier
 */
public class Request<Enum> implements Serializable {
	private static final long serialVersionUID =1L;
	private static String tag = Function.color(Request.class);

	private Enum requestName;
	private ArrayList<Object> params;

	public Request(Enum requestName, Object... params) {
		this.requestName =requestName;
		this.params =new ArrayList<>();

		for (Object s : params) {
			this.params.add(s);
		}
	}

	public Request(Socket s) throws IOException {
		Request<Enum> request = recv(s);
		System.out.println("[Request]" +tag +"receive :" +request);

		if (request ==null)
			throw new IOException();

		this.requestName =request.getRequestName();
		this.params =request.getParams();

	}

	@Override
	public String toString() {
		return "requestName =" +requestName +", params =" +params.toString();
	}

	public Enum getRequestName() {
		return requestName;
	}

	public ArrayList<Object> getParams() {
		return params;
	}

	public void sendRequest(Socket s) {
//		socket = new Socket(ipServer, portServer);
//		Request request = new Request(requestName, params);
		System.out.println("[Request]" +tag +"send : "+ this);
//		String request = "fuck";
		send(s, this);
	}

//	public void sendRequest(Socket s, ServerRequest requestName, Object... params) {
////		socket = new Socket(ipServer, portServer);
//		Request request = new Request(requestName, params);
//		System.out.println("[Request]" +tag +"send : "+ request);
////		String request = "fuck";
//		send(s, request);
//	}

	private void send(Socket s, Request<Enum> r) {
		try {
			ObjectOutputStream out = new ObjectOutputStream(s.getOutputStream());
			out.writeObject(r);
			out.flush();
//			socket.close();
		} catch (IOException e) {
			e.printStackTrace();
//			System.exit(1);
		}
	}

	private Request<Enum> recv(Socket s) {

		ObjectInputStream in = null;
		Request r =null;
		try {
//			Socket s = serverSocket.accept();
//			InputStream stream = s.getInputStream();
//			BufferedReader in = new BufferedReader(new InputStreamReader (s.getInputStream()));
//			System.out.println("input stream : " +in);
//			System.out.println(in.readLine());
			in = new ObjectInputStream(s.getInputStream());
//			System.out.println(in);
			r = (Request)in.readObject();
//			in.close();
			//			serverSocket.close();
			return r;

		} catch (IOException ex) {
			System.out.println("[Request]" +tag +"ObjectInputStream() failed");
			Logger.getLogger(Request.class.getName()).log(Level.SEVERE, null, ex);
//			Thread.currentThread().interrupt();
//			System.exit(1);
		} catch (ClassNotFoundException ex) {
			System.out.println("[Request]" +tag +"(Request)in failed");
			Logger.getLogger(Request.class.getName()).log(Level.SEVERE, null, ex);
//			System.exit(2);
//			Thread.currentThread().interrupt();
		}

		return r;
	}
	
}
