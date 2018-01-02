/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import function.Function;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import network.Request;

/**
 *
 * @author gauthier
 */
public class ThreadClient implements Runnable {
	private Client client;

	private String tag =Function.color(this);

	public ThreadClient(Client client) {
		this.client = client;
	}

	@Override
	public void run() {
		InterfaceClient ihm =client.getIhm();
		
		while (true) {
			Request request = Request.recvRequest(client.getSocket());
			System.out.println("[ThreadClient]" +tag +"request :" +request);
			
			if (request != null) {
				ArrayList<Object> params = request.getParams();
				switch (request.getRequestName()) {
					case INIT_HOME:
						client.setMessages(params);
						ihm.majTree();
						break;

					case IDENTIFICATION_OK:
						String name =(String)params.get(0);
						ihm.getHome_userName().setText(name);

//						ihm.display(ihm.getHome());
						ihm.getHome().setVisible(true);
						ihm.getIdentification().setVisible(false);
						break;

					case IDENTIFICATION_FAILED:
						ihm.getHome_wrong().setVisible(true);
						break;

					case ALL_GROUP_RESPONSE:
						List<String> allGroup =new ArrayList<>();
						for (Object o : params) {
							allGroup.add((String)o);
						}

						int lenMyGroup =Integer.parseInt(allGroup.remove(0));
						Set<String> myGroup =new TreeSet<>();
						for (int i =0; i <lenMyGroup; i++) {
							myGroup.add(allGroup.remove(0));
						}

						Set<String> other =new TreeSet<>();
						other.addAll(allGroup);

						System.out.println(myGroup);
						System.out.println(other);

						ihm.majTableOneColumn(myGroup, "own groups", ihm.getGroup_own(), ihm.getGroup_sown());
						ihm.majTableOneColumn(other, "other groups", ihm.getGroup_other(), ihm.getGroup_sother());
//						ihm.majGroupTable(myGroup, other);
						break;
				}
			}
		}

	}
}
