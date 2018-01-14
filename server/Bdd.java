/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
// ceci est un commentaire de Amine
// oui c'est bien amine
package server;

import function.Function;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextArea;
import userData.Message;
import userData.StatusMessage;

/**
 *
 * @author gauthier
 */
public class Bdd {

	private String tag = Function.color(this);

	private String baseName;
	private String ip;
	private String port;
	private String user;
	private String passwd;
	private Connection conn;
	private String sgbd;
	private Server server;

	public Bdd(String baseName, String ip, String port, String user, String passwd, String sgbd, Server server) throws ClassNotFoundException, SQLException {
		this.baseName = baseName;
		this.ip = ip;
		this.port = port;
		this.user = user;
		this.passwd = passwd;
		this.sgbd = sgbd;
		this.server =server;

		connect();
	}

	public void connect() throws ClassNotFoundException, SQLException {
		String url = "";
		switch (sgbd) {
			case "postgres":
				Class.forName("org.postgresql.Driver");
				System.out.println("[Bdd]" + tag + "Driver postgres O.K.");
				url = "jdbc:postgresql://" + ip + ":" + port + "/" + baseName;

				break;

			case "mysql":
				Class.forName("com.mysql.jdbc.Driver");
				System.out.println("[Bdd]" + tag + "Driver mysql O.K.");
				url = "jdbc:mysql://" + ip + ":" + port + "/" + baseName;

				break;
		}

		conn = DriverManager.getConnection(url, user, passwd);
		System.out.println("[Bdd]" + tag + "Connexion effective !");
	}

	public void executeSqlScript(File inputFile) {
		// Delimiter
		String delimiter = ";";

		// Create scanner
		Scanner scanner;
		try {
			scanner = new Scanner(inputFile).useDelimiter(delimiter);
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
			return;
		}
		System.out.println("[Bdd] execute sql file " + inputFile);

		// Loop through the SQL file statements
		Statement currentStatement = null;
		while (scanner.hasNext()) {

			// Get statement
			String rawStatement = scanner.next() + delimiter;
			try {
				// Execute statement
				currentStatement = conn.createStatement();
				System.out.println(rawStatement);
//				if (! rawStatement.equals(";\n"))
				if (rawStatement.length() > 5) {
					currentStatement.execute(rawStatement);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				// Release resources
				if (currentStatement != null) {
					try {
						currentStatement.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
				currentStatement = null;
			}
		}
		scanner.close();
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
			for (int i = 1; i <= resultMeta.getColumnCount(); i++) {
				System.out.print("\t" + resultMeta.getColumnName(i).toUpperCase() + "  *");
			}
			System.out.println("\n**********************************");
			while (result.next()) {
				for (int i = 1; i <= resultMeta.getColumnCount(); i++) {
					if (result.getObject(i) == null) {
						System.out.print("\tnull\t |");
					} else {
						System.out.print("\t" + result.getObject(i).toString() + "\t |");
					}
				}

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
			System.out.println("[Bdd] select(" + req + ");");
			//Création d'un objet Statement
			Statement state = conn.createStatement();
			//L'objet ResultSet contient le résultat de la requête SQL
			ResultSet result = state.executeQuery(req);
			//On récupère les MetaData
			ResultSetMetaData resultMeta = result.getMetaData();

			List<List<String>> m = new ArrayList<>();
			while (result.next()) {
				List<String> l = new ArrayList<>();

				for (int i = 1; i <= resultMeta.getColumnCount(); i++) {
					if (result.getObject(i) == null) {
						l.add("null");
						System.out.print("null\t");
					} else {
						l.add(result.getObject(i).toString());
						System.out.print(result.getObject(i).toString() + "\t");
					}
				}
				System.out.println("");

				m.add(l);
			}
			result.close();
			state.close();

			if (m.size() == 0 || m.get(0).size() == 0) {
				return null;
			}

			String[][] r = new String[m.size()][m.get(0).size()];
			for (int i = 0; i < m.size(); i++) {
				for (int j = 0; j < m.get(0).size(); j++) {
					r[i][j] = m.get(i).get(j);
				}
			}

			return r;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public String uniq(String req) {
		String str = "";
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
			for (int i = 1; i <= resultMeta.getColumnCount(); i++) {
				str += resultMeta.getColumnName(i).toUpperCase() + "\t";
			}
//				System.out.print(resultMeta.getColumnName(i).toUpperCase() + "\t");
//			System.out.println("\n**********************************");
//			System.out.println("");
			str += "\n";
			while (result.next()) {
				for (int i = 1; i <= resultMeta.getColumnCount(); i++) {
					if (result.getObject(i) == null) {
						str += "null\t";
					} //						System.out.print("null\t");
					else {
						str += result.getObject(i).toString() + "\t";
					}
				}
//						System.out.print(result.getObject(i).toString() + "\t");

//				System.out.println("\n---------------------------------");
				str += "\n";
			}
			result.close();
			state.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return str;
	}

	public String execute(String req) {
		System.out.println("[Bdd] execute(" + req + ");");
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
			return e.getMessage();
		}
		return "ok";
	}

	public int nbLine(String req) {
		int nbLine = 0;
		try {
			//Création d'un objet Statement
			Statement state = conn.createStatement();
			//L'objet ResultSet contient le résultat de la requête SQL
			ResultSet result = state.executeQuery(req);
			while (result.next()) {
				nbLine++;
			}
			result.close();
			state.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return nbLine;
	}

	public boolean oneRow(String select) {
		int nbLine = nbLine(select);
		System.out.println("nbLine =" + nbLine);
		return nbLine == 1;
	}

	boolean identification(String login, String passwd) {
		login = login.replace("'", "''");
		passwd = passwd.replace("'", "''");

		return oneRow("select u_login, u_password from users where u_login = '" + login + "' and u_password = '" + passwd + "'");
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
	String newUser(String login, String passwd, String firstName, String name, String status) {
		login = login.replace("'", "''");
		passwd = passwd.replace("'", "''");
		firstName = firstName.replace("'", "''");
		name = name.replace("'", "''");
		status = status.replace("'", "''");

		System.out.println("insert into users values ('" + login + "', '" + passwd + "', '" + firstName + "', '" + name + "', '" + status + "')");
		return execute("insert into users values ('" + login + "', '" + passwd + "', '" + firstName + "', '" + name + "', '" + status + "')");
	}

	Object[] getMessages(String name) {
		name = name.replace("'", "''");

		List<Message> l = new ArrayList<>();
		StatusMessage sm;
//		l.add(new Message(1, "fuckGroup", "ticketBitch", "name", "suck", new Date(1993, 6, 12)));
//		String[][] m =select("select distinct m_idmessage, m_data, m_created, m_fk_users, t_title, g_name from messages,tickets,groups,belong where b_fk_users='" +name +"' and g_name=b_fk_groups and g_name=t_fk_groups and m_fk_tickets=t_idticket or t_fk_users='"+ name +"' and t_idticket=m_fk_tickets and t_fk_groups=g_name");
		String[][] m = select("select distinct m_idmessage, m_data, m_created, m_fk_users, u_firstname, u_name, t_title, g_name from messages,tickets,groups,belong,users where b_fk_users='" + name + "' and g_name=b_fk_groups and g_name=t_fk_groups and m_fk_tickets=t_idticket and m_fk_users=u_login or t_fk_users='" + name + "' and t_idticket=m_fk_tickets and t_fk_groups=g_name and m_fk_users=u_login");

		if (m != null) {
			for (int i = 0; i < m.length; i++) {
				int idMessage = Integer.parseInt(m[i][0]);
				String[][] userStatus = allUserStatus(idMessage);
				sm = checkStatusMessage(userStatus);

				l.add(new Message(idMessage, m[i][1], Timestamp.valueOf(m[i][2]), m[i][3], m[i][4], m[i][5], m[i][6], m[i][7], sm, userStatus));
			}
		}
		return l.toArray();
	}

	Object[] allGroups(String name) {
		name = name.replace("'", "''");

//		request("select * from groups");
		List<String> l = new ArrayList<>();
		String[][] m = select("select * from groups, belong where b_fk_users='" + name + "' and g_name=b_fk_groups");
		if (m == null) {
			l.add(0, "0");
		} else {
			l = firstColumn(m);
			l.add(0, l.size() + "");
		}

//		m =select("select * from groups except select g_name from groups, belong where b_fk_users='" +name +"' and g_name=b_fk_groups");
		m = select("select g_name from groups where g_name not in ( select g_name from groups, belong where b_fk_users='" +name +"' and g_name=b_fk_groups)");
		if (m != null) {
			l.addAll(firstColumn(m));
		}

		return l.toArray();
	}

	Object[] allGroups() {
		List<String> l = new ArrayList<>();
		l = firstColumn(select("select * from groups"));

		return l.toArray();
	}

	String[][] allGroupsWithNbUser() {
		String[][] m = select("select *,0 from groups where g_name not in (select distinct g_name from groups,belong where g_name=b_fk_groups) union select g_name,count(b_fk_users) from belong,groups where b_fk_groups=g_name group by g_name");
		return m;
	}

	private List<String> firstColumn(String[][] select) {
		List<String> r = new ArrayList<>();
		for (String[] l : select) {
			r.add(l[0]);
		}
		System.out.println("[Bdd]" + tag + r);
		return r;
	}

	void addGroup(String text) {
		text = text.replace("'", "''");

		execute("insert into groups values ('" + text + "')");
	}

	void removeGroup(String nameGroup) {
		nameGroup = nameGroup.replace("'", "''");

		execute("delete from groups where g_name ='" + nameGroup + "'");
	}

	Message newMessage(Message m) {
		String ticket = m.getTicket();
		String body = m.getBody();
		String author = m.getAuthor();
		String date = m.getCreate().toString();

		body = body.replace("'", "''");
		author = author.replace("'", "''");

		String ticketForBdd = ticket.replace("'", "''");

		int idMessage = nbLine("select * from messages") + 1;
		int idTicket = Integer.parseInt(select("select t_idticket from tickets where t_title='" + ticketForBdd + "'")[0][0]);
		execute("insert into messages values (" + idMessage + ", '" + body + "', '" + date + "', '" + author + "', " + idTicket + ")");

		String group = select("select t_fk_groups from tickets where t_title='" + ticketForBdd + "'")[0][0];

		String[] sl = select("select u_firstname, u_name from users where u_login='" + author + "'")[0];
		String firstname = sl[0];
		String name = sl[1];

		userReadMessage(author, idMessage);

		body = body.replace("''", "'");
		author = author.replace("''", "'");

		return new Message(idMessage, body, m.getCreate(), author, firstname, name, ticket, group, StatusMessage.GROUP_NOT_RECEIVE, allUserStatus(idMessage));
	}

	private String[][] allUserStatus(int idMessage) {
		List<String> lUser = destineUsersMessage(idMessage);
		String[][] mStatus = new String[lUser.size()][2];

		int i = 0;
		for (String user : lUser) {
			mStatus[i][0] = user;

			mStatus[i][1] = checkUserMessageStatus(idMessage, user);
			i++;
		}

		return mStatus;
	}

	List<String> destineUsersMessage(int idMessage) {
		return firstColumn(select("select b_fk_users from messages,tickets,belong where m_idmessage=" + idMessage + " and m_fk_tickets=t_idticket and t_fk_groups=b_fk_groups union select t_fk_users from messages,tickets where m_idmessage=" + idMessage + " and m_fk_tickets=t_idTicket"));
	}

	private StatusMessage checkStatusMessage(String[][] userStatus) {
		for (String[] ls : userStatus) {
			if (ls[1].equals("en attente")) {
				return StatusMessage.GROUP_NOT_RECEIVE;
			}
		}

		for (String[] ls : userStatus) {
			if (ls[1].equals("reçu")) {
				return StatusMessage.GROUP_NOT_READ;
			}
		}

		return StatusMessage.GROUP_READ;
	}

	private String checkUserMessageStatus(int idMessage, String user) {
		user = user.replace("'", "''");

		if (select("select * from seen where seen_fk_users='" + user + "' and seen_fk_messages=" + idMessage) != null) {
			return "lu";
		}

		if (select("select * from receive where rcv_fk_users='" + user + "' and rcv_fk_messages=" + idMessage) != null) {
			return "reçu";
		}

		return "en attente";
	}

	void userReadMessage(String user, Integer idMessages) {
		execute("insert into seen values ('" + user + "', " + idMessages + ")");
	}

	Message getMessageFromId(Integer idMessage) {
		String[] ls = select("select * from messages where m_idmessage=" + idMessage)[0];
		String body = ls[1];
		Timestamp date = Timestamp.valueOf(ls[2]);
		String author = ls[3];
		String idTicket = ls[4];

		String group = select("select t_fk_groups from tickets where t_idticket='" + idTicket + "'")[0][0];

		ls = select("select u_firstname, u_name from users where u_login='" + author + "'")[0];
		String firstname = ls[0];
		String name = ls[1];

		String[][] userStatus = allUserStatus(idMessage);
		StatusMessage statusMessage = checkStatusMessage(userStatus);

		String ticket = select("select t_title from messages,tickets where m_idmessage=" + idMessage + " and m_fk_tickets=t_idticket")[0][0];

		return new Message(idMessage, body, date, author, firstname, name, ticket, group, statusMessage, allUserStatus(idMessage));
	}

	void addUserInGroup(String actualConnectUser, String group) {
		actualConnectUser = actualConnectUser.replace("'", "''");
		group = group.replace("'", "''");

		execute("insert into belong values ('" + actualConnectUser + "', '" + group + "')");
	}

	void delUserOfGroup(String actualConnectUser, String group) {
		actualConnectUser = actualConnectUser.replace("'", "''");
		group = group.replace("'", "''");

		execute("delete from belong where b_fk_groups='" + group + "' and b_fk_users='" + actualConnectUser + "'");
	}

	void newTicket(String title, String author, String group) {
		title = title.replace("'", "''");
		author = author.replace("'", "''");
		group = group.replace("'", "''");

		int idTicket = select("select * from tickets").length + 1;
		Timestamp date = new Timestamp(System.currentTimeMillis());
		execute("insert into tickets values (" + idTicket + ", '" + title + "', '" + date + "', '" + author + "', '" + group + "')");
	}

	void checkIntegrity(JTextArea console) throws SQLException {
		switch (sgbd) {
			case "postgres":
				if (select("select tablename from pg_tables where schemaname='public'").length != 7) {
					console.setText("database not conform, must have 7 row\nyou must init base !");
				}
				break;

			case "mysql":
				String[][] m =select("show tables");
				if (m == null || m.length != 7) {
					console.setText("database not conform, must have 7 row\nyou must init base !");
					throw new SQLException("not conform tables");
				}
				break;
		}
	}

	public void showTable(JTextArea console) {
		switch (sgbd) {
			case "postgres":
				console.setText(uniq("select tablename from pg_tables where schemaname='public'"));
				break;

			case "mysql":
				console.setText(uniq("show tables"));
				break;
		}
	}

	void clearTables() {
		switch (sgbd) {
			case "postgres":
				break;

			case "mysql":
				String[][] m = select("show tables");
				for (String s[] : m) {
					System.out.println(s[0]);
					execute("drop table " + s[0]);
				}
				break;
		}
	}

	String[][] allUsersOfGroup(String group) {
		group = group.replace("'", "''");

		String[][] m = select("select b_fk_users from belong where b_fk_groups='" + group + "'");
		return m;
	}

	void delUserInGroup(String user, String group) {
		user = user.replace("'", "''");
		group = group.replace("'", "''");

		execute("delete from belong where b_fk_users='" + user + "' and b_fk_groups='" + group + "'");
	}

	String[][] otherUsersOfGroup(String group) {
		group = group.replace("'", "''");
//		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
		return select("select u_login from users where u_login not in (select b_fk_users from belong where b_fk_groups='" + group + "')");
	}

	public String getNbUsers() {
		return select("select count(*) from users")[0][0];
	}

	public String getNbGroups() {
		return select("select count(*) from groups")[0][0];
	}
        
        public String getNbTickets() {
		return select("select count(*) from tickets")[0][0];
	}

	String[][] usersTable() {
		return select("select * from users");
	}

	void changeUserRow(String[] userRow) {
		String login =userRow[0];
		String passwd =userRow[1];
		String firstname =userRow[2];
		String name =userRow[3];
		String status =userRow[4];

		login = login.replace("'", "''");
		passwd = passwd.replace("'", "''");
		firstname = firstname.replace("'", "''");
		name = name.replace("'", "''");
		status = status.replace("'", "''");

		execute("update users set u_login='" +login +"', u_password='" +passwd +"', u_firstname='" +firstname +"', u_name='" +name +"', u_status='" +status +"' where u_login='" +login +"'");
	}

	void delUserInGroup(String login) {
		login = login.replace("'", "''");

		execute("delete from users where u_login='" +login +"'");
	}

	void majReceiveStatusMessagesOf(String login) {
		login = login.replace("'", "''");

		String[][] m = select("select distinct m_idmessage from messages,tickets,groups,belong,users where b_fk_users='" + login + "' and g_name=b_fk_groups and g_name=t_fk_groups and m_fk_tickets=t_idticket and m_fk_users=u_login or t_fk_users='" + login + "' and t_idticket=m_fk_tickets and t_fk_groups=g_name and m_fk_users=u_login");
		List<Message> lm =new ArrayList<>();
		
		if (m != null) {
			for (String[] ls : m) {
				String idMessage =ls[0];
				
				if (! oneRow("select * from receive where rcv_fk_users='" +login +"' and rcv_fk_messages=" +idMessage)) {
					execute("insert into receive values ('" +login +"', " +idMessage +")");
					lm.add(getMessageFromId(Integer.parseInt(idMessage)));
				}
			}
			
			System.out.println("server =" +server);
			if (lm.size() != 0)
				server.broadcast(lm);
		}
	}

	boolean messageAdressToUser(Message m, String login) {
		login = login.replace("'", "''");

		Integer m_idmessage =m.getId();
		return oneRow("select distinct m_idmessage from messages,tickets,groups,belong,users where b_fk_users='" + login + "' and g_name=b_fk_groups and g_name=t_fk_groups and m_fk_tickets=t_idticket and m_fk_users=u_login and m_idmessage=" +m_idmessage +" or t_fk_users='" + login + "' and t_idticket=m_fk_tickets and t_fk_groups=g_name and m_fk_users=u_login and m_idmessage=" +m_idmessage);
	}

	void setServer(Server server) {
		this.server =server;
	}

	boolean userAlreadyReceive(String actualUser, Message m) {
		actualUser = actualUser.replace("'", "''");

		Integer idMessage =m.getId();
		return oneRow("select * from receive where rcv_fk_users='" +actualUser +"' and rcv_fk_messages=" +idMessage);
	}

	void userReceiveMessage(String actualUser, Message m) {
		actualUser = actualUser.replace("'", "''");

		Integer idMessage =m.getId();
		execute("insert into receive values ('" +actualUser +"', " +idMessage +")");
	}

	boolean userAlreadyRead(String actualUser, Message m) {
		actualUser = actualUser.replace("'", "''");

		Integer idMessage =m.getId();
		return oneRow("select * from seen where seen_fk_users='" +actualUser +"' and seen_fk_messages=" +idMessage);
	}

	String export() {
		String str;
		// netbeans conf
		if (new File("src").exists()) {
			str =readFile(new File("src/bdd/build.sql"));
			str +=readFile(new File("src/bdd/insertData.sql"));
		}
		else {
			str =readFile(new File("bdd/build.sql"));
			str +=readFile(new File("bdd/insertData.sql"));
		}

		return str;
	}

	String readFile(File inputFile) {
		String str ="";

		// Delimiter
		String delimiter = ";";

		// Create scanner
		Scanner scanner;
		try {
			scanner = new Scanner(inputFile).useDelimiter(delimiter);
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
			return "";
		}
		System.out.println("[Bdd] export file " + inputFile);

		// Loop through the SQL file statements
		Statement currentStatement = null;
		while (scanner.hasNext()) {

			// Get statement
			String rawStatement = scanner.next() + delimiter;
			str +=rawStatement;
		}
		scanner.close();

		return str;
	}

}
