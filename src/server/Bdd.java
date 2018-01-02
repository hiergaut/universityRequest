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
import java.util.Date;
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

				for(int i = 1; i <= resultMeta.getColumnCount(); i++)
					if (result.getObject(i) == null)
						l.add("null");
					else
						l.add(result.getObject(i).toString());
				
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
		return oneRow("select login, password from users where login = '" +login +"' and password = '" +passwd +"'");
	}

	public static void main(String[] args) {
		Bdd bdd =null;
		try {
			bdd = new Bdd("universityRequest", "127.0.0.1", "5432", "postgres", "postgres");
		} catch (ClassNotFoundException ex) {
			Logger.getLogger(Bdd.class.getName()).log(Level.SEVERE, null, ex);
		} catch (SQLException ex) {
			Logger.getLogger(Bdd.class.getName()).log(Level.SEVERE, null, ex);
		}
		bdd.request("select * from pg_tables where schemaname='public'");

	}

	void newUser(String login, String passwd, String firstName, String name, String status) {
		System.out.println("insert into users values ('"+ login +"', '" +passwd +"', '" +firstName +"', '" +name +"', '" +status +"')");
		execute("insert into users values ('"+ login +"', '" +passwd +"', '" +firstName +"', '" +name +"', '" +status +"')");
	}

	Object[] getMessages(String name) {
		List<Message> l = new ArrayList<>();
		l.add(new Message(1, "fuckGroup", "ticketBitch", "gauthier", "suck", new Date(1993, 6, 12)));
		return l.toArray();
	}

	Object[] allGroups() {
		request("select * from groups");
		List<String> l = new ArrayList<>();
		l =firstColumn(select("select * from groups"));
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
		execute("delete from groups where name ='"+ nameGroup +"'");
	}

}
