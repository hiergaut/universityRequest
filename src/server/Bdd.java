/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import function.Function;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import userData.Message;

/**
 *
 * @author gauthier
 */
public class Bdd {
	private String baseName;
	private String ip;
	private String port;
	private String user;
	private String passwd;
	private Connection conn;

	private String tag =Function.color(this);
	
	public Bdd(String baseName, String ip, String port, String user, String passwd) throws ClassNotFoundException, SQLException {
		this.baseName = baseName;
		this.ip = ip;
		this.port = port;
		this.user = user;
		this.passwd = passwd;
		
		connect();
	}
	
	public void connect() throws ClassNotFoundException, SQLException {
		Class.forName("org.postgresql.Driver");
		System.out.println("[Bdd]" +tag +"Driver O.K.");
		String url = "jdbc:postgresql://" +ip +":" +port +"/" +baseName;
		
		conn = DriverManager.getConnection(url, user, passwd);
		System.out.println("[Bdd]"+ tag +"Connexion effective !");
	}
	
	public void request(String req) {
		try {
//			Class.forName("org.postgresql.Driver");
//			String url = "jdbc:postgresql://localhost:5432/Ecole";
//			String user = "postgres";
//			String passwd = "postgres";
//			Connection conn = DriverManager.getConnection(url, user, passwd);
			
			//Création d'un objet Statement
			Statement state = conn.createStatement();
			//L'objet ResultSet contient le résultat de la requête SQL
			ResultSet result = state.executeQuery(req);
			//On récupère les MetaData
			ResultSetMetaData resultMeta = result.getMetaData();
			System.out.println("\n**********************************");
			//On affiche le nom des colonnes
			for(int i = 1; i <= resultMeta.getColumnCount(); i++)
				System.out.print("\t" + resultMeta.getColumnName(i).toUpperCase() + "  *");
			System.out.println("\n**********************************");
			while(result.next()){
				for(int i = 1; i <= resultMeta.getColumnCount(); i++)
					if (result.getObject(i) == null)
						System.out.print("\tnull\t |");
					else
						System.out.print("\t" + result.getObject(i).toString() + "\t |");
				
				System.out.println("\n---------------------------------");
			}
			result.close();
			state.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String[][] select(String req) {
		try {
			//Création d'un objet Statement
			Statement state = conn.createStatement();
			//L'objet ResultSet contient le résultat de la requête SQL
			ResultSet result = state.executeQuery(req);
			//On récupère les MetaData
			ResultSetMetaData resultMeta = result.getMetaData();

			List<List<String>> m =new ArrayList<>();
			while(result.next()){
				List<String> l =new ArrayList<>();

				for(int i = 1; i <= resultMeta.getColumnCount(); i++) {
					if (result.getObject(i) == null) {
						l.add("null");
						System.out.print("null\t");
					}
					else {
						l.add(result.getObject(i).toString());
						System.out.print(result.getObject(i).toString() +"\t");
					}
				}
				System.out.println("");
				
				m.add(l);
			}
			result.close();
			state.close();

			String[][] r =new String[m.size()][m.get(0).size()];
			for (int i =0; i <m.size(); i++) {
				for (int j =0; j <m.get(0).size(); j++) {
					r[i][j] =m.get(i).get(j);
				}
			}

			return r;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public String uniq(String req) {
		String str ="";
		try {
//			Class.forName("org.postgresql.Driver");
//			String url = "jdbc:postgresql://localhost:5432/Ecole";
//			String user = "postgres";
//			String passwd = "postgres";
//			Connection conn = DriverManager.getConnection(url, user, passwd);
			
			//Création d'un objet Statement
			Statement state = conn.createStatement();
			//L'objet ResultSet contient le résultat de la requête SQL
			ResultSet result = state.executeQuery(req);
			//On récupère les MetaData
			ResultSetMetaData resultMeta = result.getMetaData();
//			System.out.println("\n**********************************");
			//On affiche le nom des colonnes
			for(int i = 1; i <= resultMeta.getColumnCount(); i++)
				str +=resultMeta.getColumnName(i).toUpperCase() + "\t";
//				System.out.print(resultMeta.getColumnName(i).toUpperCase() + "\t");
//			System.out.println("\n**********************************");
//			System.out.println("");
			str +="\n";
			while(result.next()){
				for(int i = 1; i <= resultMeta.getColumnCount(); i++)
					if (result.getObject(i) == null)
						str +="null\t";
//						System.out.print("null\t");
					else
						str +=result.getObject(i).toString() + "\t";
//						System.out.print(result.getObject(i).toString() + "\t");
				
//				System.out.println("\n---------------------------------");
			}
			result.close();
			state.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return str;
	}

	public void execute(String req) {
		System.out.println("[Bdd] execute(" +req +");");
		try {
//			Class.forName("org.postgresql.Driver");
//			String url = "jdbc:postgresql://localhost:5432/Ecole";
//			String user = "postgres";
//			String passwd = "postgres";
//			Connection conn = DriverManager.getConnection(url, user, passwd);
			
			//Création d'un objet Statement
			Statement state = conn.createStatement();
			//L'objet ResultSet contient le résultat de la requête SQL
//			ResultSet result = state.executeQuery(req);
			state.execute(req);
			//On récupère les MetaData
//			result.close();
			state.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public int nbLine(String req) {
		int nbLine =0;
		try {
			//Création d'un objet Statement
			Statement state = conn.createStatement();
			//L'objet ResultSet contient le résultat de la requête SQL
			ResultSet result = state.executeQuery(req);
			while (result.next()) nbLine++;
			result.close();
			state.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return nbLine;
	}

	public boolean oneRow(String select) {
		int nbLine =nbLine(select);
		return nbLine == 1;
	}

	boolean identification(String login, String passwd) {
		return oneRow("select u_login, u_password from users where u_login = '" +login +"' and u_password = '" +passwd +"'");
	}

//	public static void main(String[] args) {
//		Bdd bdd =null;
//		try {
//			bdd = new Bdd("universityRequest", "127.0.0.1", "5432", "postgres", "postgres");
//		} catch (ClassNotFoundException ex) {
//			Logger.getLogger(Bdd.class.getName()).log(Level.SEVERE, null, ex);
//		} catch (SQLException ex) {
//			Logger.getLogger(Bdd.class.getName()).log(Level.SEVERE, null, ex);
//		}
//		bdd.request("select * from pg_tables where schemaname='public'");
//
//	}

	void newUser(String login, String passwd, String firstName, String name, String status) {
		System.out.println("insert into users values ('"+ login +"', '" +passwd +"', '" +firstName +"', '" +name +"', '" +status +"')");
		execute("insert into users values ('"+ login +"', '" +passwd +"', '" +firstName +"', '" +name +"', '" +status +"')");
	}

	Object[] getMessages(String name) {
		List<Message> l = new ArrayList<>();
//		l.add(new Message(1, "fuckGroup", "ticketBitch", "name", "suck", new Date(1993, 6, 12)));
		String[][] m =select("select distinct m_idmessage, m_data, m_created, m_fk_users, t_title, g_name from messages,tickets,groups,belong where b_fk_users='" +name +"' and g_name=b_fk_groups and g_name=t_fk_groups and m_fk_tickets=t_idticket or t_fk_users='"+ name +"' and t_idticket=m_fk_tickets and t_fk_groups=g_name");
		for (int i =0; i <m.length; i++) {
			l.add(new Message(Integer.parseInt(m[i][0]), m[i][1], m[i][2], m[i][3], m[i][4], m[i][5]));
		}
		return l.toArray();
	}

	Object[] allGroups(String name) {
//		request("select * from groups");
		List<String> l = new ArrayList<>();
		l = firstColumn(select("select * from groups, belong where b_fk_users='" +name +"' and g_name=b_fk_groups"));
		Integer size =l.size();
		l.add(0, size.toString());
		l.addAll(firstColumn(select("select * from groups except select g_name from groups, belong where b_fk_users='" +name +"' and g_name=b_fk_groups")));

		return l.toArray();
	}

	Object[] allGroups() {
		List<String> l = new ArrayList<>();
		l = firstColumn(select("select * from groups"));

		return l.toArray();
	}

	private List<String> firstColumn(String[][] select) {
		List<String> r =new ArrayList<>();
		for (String[] l : select) {
			r.add(l[0]);
		}
		System.out.println("[Bdd]" +tag +r);
		return r;
	}

	void addGroup(String text) {
		execute("insert into groups values ('" +text +"')");
	}

	void removeGroup(String nameGroup) {
		execute("delete from groups where g_name ='"+ nameGroup +"'");
	}

	void newMessage(String author, String date, String body, String ticket) {
		int idMessage =nbLine("select * from messages") +1;
		int idTicket =Integer.parseInt(select("select t_idticket from tickets where t_title='" +ticket +"'")[0][0]);
		execute("insert into messages values (" +idMessage +", '" +body +"', '" +date +"', '" +author +"', " +idTicket +")");
	}

}
