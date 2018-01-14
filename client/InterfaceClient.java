/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import function.Function;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Window;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.file.Path;
import java.sql.Date;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTree;
import javax.swing.border.Border;
import javax.swing.plaf.metal.MetalScrollBarUI;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeCellRenderer;
import javax.swing.tree.TreePath;
import network.Request;
import network.ClientRequest;
import userData.Message;
import userData.StatusMessage;

/**
 *
 * @author gauthier
 */
public class InterfaceClient extends javax.swing.JFrame {

	private static final long serialVersionUID = 1L;
	private Client client;
	private boolean retry;
	private CardLayout cview;
	private CardLayout cview2;
	private CardLayout cview3;

	// login user actually connected
	private String actualUser;

	private String tag = Function.color(this);

	boolean identification_clic_login = true;
	boolean identification_clic_passwd = true;

	boolean newUser_clic_name = true;
	boolean newUser_clic_firstname = true;
	boolean newUser_clic_email = true;
	boolean newUser_clic_login = true;
	boolean newUser_clic_passwd = true;
        boolean first_clic_newMessage_input = true;

	/**
	 * Creates new form Interface
	 */
	public InterfaceClient() {
		initComponents();

		this.setTitle("UniversityRequest - Client");
		this.setSize(1600, 900);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setResizable(false);

		this.setVisible(true);

		new Thread() {
			@Override
			public void run() {
				serverConnect();
			}
		}.start();
	}

	public void show(String tag) {
		cview.show(view, tag);
	}

	public void show2(String tag) {
		cview2.show(view2, tag);
	}

	public void show3(String tag) {
		cview3.show(identification_footer, tag);
	}

	public void serverConnect() {
		InterfaceClient ihm = this;
		show("connect");

		new Thread() {
			public void run() {
				temporize();
				try {
					String ip = serverNotFound_ip.getText();
					int port = Integer.parseInt(serverNotFound_port.getText());
					client = new Client(ip, port, ihm);

					show("identification");
				} catch (IOException ex) {
					Logger.getLogger(InterfaceClient.class.getName()).log(Level.SEVERE, null, ex);

					show("serverNotFound");
					serverNotFound_console.setText(ex.getMessage());
				}
			}
		}.start();
	}

	private void temporize() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException ex) {
			Logger.getLogger(InterfaceClient.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

//		boolean connected =false;
//		while (! connected) {
//			try {
//				try {
//					Thread.sleep(1000);
//				} catch (InterruptedException ex) {
//					Logger.getLogger(InterfaceClient.class.getName()).log(Level.SEVERE, null, ex);
//				}
//
//				client = new Client("127.0.0.1", 5000, this);
//				connected =true;
//
//
//			} catch (IOException ex) {
//				Logger.getLogger(InterfaceClient.class.getName()).log(Level.SEVERE, null, ex);
//				f_serverNotFound.setVisible(true);
//				serverConnect.setVisible(false);
//
//				retry =false;
//				while (! retry) {
//					try {
//						Thread.sleep(1000);
//					} catch (InterruptedException ex1) {
//						Logger.getLogger(InterfaceClient.class.getName()).log(Level.SEVERE, null, ex1);
//					}
//				}
//				serverConnect.setVisible(true);
//				f_serverNotFound.setVisible(false);
//			}
//		}
//
//		f_identification.setVisible(true);
//		serverConnect.setVisible(false);
//
//
	/**
	 * This method is called from within the constructor to initialize the
	 * form. WARNING: Do NOT modify this code. The content of this method is
	 * always regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
        // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
        private void initComponents() {

                view = new javax.swing.JPanel();
                view_loading = new javax.swing.JPanel();
                loading = new javax.swing.JLabel();
                view_serverNotFound = new javax.swing.JPanel();
                identification_logo1 = new javax.swing.JLabel();
                _serverNotFound = new javax.swing.JPanel();
                body_ServerNotFound = new javax.swing.JPanel();
                _retry = new javax.swing.JPanel();
                jSeparator3 = new javax.swing.JSeparator();
                jSeparator4 = new javax.swing.JSeparator();
                jButton1 = new javax.swing.JButton();
                jLabel1 = new javax.swing.JLabel();
                jLabel2 = new javax.swing.JLabel();
                serverNotFound_ip = new javax.swing.JTextField();
                serverNotFound_port = new javax.swing.JTextField();
                serverNotFound_icon = new javax.swing.JLabel();
                panel_consoleServerNotFound = new javax.swing.JPanel();
                serverNotFound_console = new javax.swing.JTextPane();
                serverNotFound_localhost = new javax.swing.JButton();
                view_identification = new javax.swing.JPanel();
                identification_logo = new javax.swing.JLabel();
                _identification = new javax.swing.JPanel();
                body_connexion = new javax.swing.JPanel();
                identification_login = new javax.swing.JTextField();
                passwdInput = new javax.swing.JPasswordField();
                identification_connection = new javax.swing.JButton();
                jSeparator1 = new javax.swing.JSeparator();
                jSeparator2 = new javax.swing.JSeparator();
                not_registered = new javax.swing.JLabel();
                icon_user = new javax.swing.JLabel();
                icon_user1 = new javax.swing.JLabel();
                connexion_logoOpacity5 = new javax.swing.JLabel();
                identification_footer = new javax.swing.JPanel();
                footer_empty = new javax.swing.JPanel();
                footer_incorrect = new javax.swing.JPanel();
                identification_errorLogin = new javax.swing.JPanel();
                not_registered1 = new javax.swing.JLabel();
                jLabel16 = new javax.swing.JLabel();
                footer_loading = new javax.swing.JPanel();
                identification_loadingInterface = new javax.swing.JPanel();
                not_registered2 = new javax.swing.JLabel();
                jLabel17 = new javax.swing.JLabel();
                view_newUser = new javax.swing.JPanel();
                newUser_logo = new javax.swing.JLabel();
                zone_newUser = new javax.swing.JPanel();
                zone_inscription = new javax.swing.JPanel();
                newUser_iconName = new javax.swing.JLabel();
                newUser_iconFirstname = new javax.swing.JLabel();
                newUser_iconEmail = new javax.swing.JLabel();
                newUser_iconLogin = new javax.swing.JLabel();
                newUser_iconPasswd = new javax.swing.JLabel();
                newUser_iconStatus = new javax.swing.JLabel();
                newUser_name = new javax.swing.JTextField();
                newUser_firstName = new javax.swing.JTextField();
                newUser_email = new javax.swing.JTextField();
                newUser_login = new javax.swing.JTextField();
                newUser_passwrd = new javax.swing.JPasswordField();
                newUser_status = new javax.swing.JComboBox<>();
                newUser_separatorName = new javax.swing.JSeparator();
                newUser_separatorFirstname = new javax.swing.JSeparator();
                newUser_sepearatorEmail = new javax.swing.JSeparator();
                newUser_seperatorLogin = new javax.swing.JSeparator();
                newUser_separatorPasswd = new javax.swing.JSeparator();
                newUser_join = new javax.swing.JButton();
                back = new javax.swing.JLabel();
                logo_opacity6 = new javax.swing.JLabel();
                footer_newUser = new javax.swing.JPanel();
                newUser_print = new javax.swing.JPanel();
                newUser_error = new javax.swing.JPanel();
                newUser_logMessage = new javax.swing.JLabel();
                newUser_logIcon = new javax.swing.JLabel();
                newUser_errorFields = new javax.swing.JPanel();
                newUser_logMessage2 = new javax.swing.JLabel();
                newUser_logIcon2 = new javax.swing.JLabel();
                newUser_okEmail = new javax.swing.JPanel();
                newUser_logMessage1 = new javax.swing.JLabel();
                newUser_logIcon1 = new javax.swing.JLabel();
                newUser_errorDomain = new javax.swing.JPanel();
                newUser_logMessage3 = new javax.swing.JLabel();
                newUser_logIcon3 = new javax.swing.JLabel();
                view_home = new javax.swing.JPanel();
                home_menu = new javax.swing.JPanel();
                logo_client = new javax.swing.JLabel();
                footer_left = new javax.swing.JPanel();
                about = new javax.swing.JLabel();
                home_tickets = new javax.swing.JScrollPane();
                tree = new javax.swing.JTree();
                jLabel3 = new javax.swing.JLabel();
                home_userName = new javax.swing.JLabel();
                jPanel1 = new javax.swing.JPanel();
                home_newTicket = new javax.swing.JButton();
                home_group = new javax.swing.JButton();
                home_right = new javax.swing.JPanel();
                header_home = new javax.swing.JPanel();
                home_leave = new javax.swing.JButton();
                home_ticket = new javax.swing.JLabel();
                view2 = new javax.swing.JPanel();
                view_welcome = new javax.swing.JPanel();
                welcome = new javax.swing.JLabel();
                to_interface_admin = new javax.swing.JLabel();
                need_help = new javax.swing.JLabel();
                help_email = new javax.swing.JLabel();
                icon_logo_opacity10 = new javax.swing.JLabel();
                message_box = new javax.swing.JPanel();
                right_messagesScroll = new javax.swing.JScrollPane();
                right_messages = new javax.swing.JPanel();
                messages_box1 = new javax.swing.JPanel();
                box1_allName = new javax.swing.JLabel();
                box1_date = new javax.swing.JLabel();
                box1_scroll_body = new javax.swing.JScrollPane();
                box1_body = new javax.swing.JTextPane();
                right_newMessage = new javax.swing.JPanel();
                jScrollPane2 = new javax.swing.JScrollPane();
                newMessage_input = new javax.swing.JTextArea();
                log_message = new javax.swing.JLabel();
                newMessage_send = new javax.swing.JButton();
                view_group = new javax.swing.JPanel();
                group_sown = new javax.swing.JScrollPane();
                group_own = new javax.swing.JTable();
                group_swap = new javax.swing.JButton();
                group_sother = new javax.swing.JScrollPane();
                group_other = new javax.swing.JTable();
                view_newTicket = new javax.swing.JPanel();
                jPanel2 = new javax.swing.JPanel();
                newTicket_send = new javax.swing.JButton();
                jScrollPane4 = new javax.swing.JScrollPane();
                new_ticketBody = new javax.swing.JTextArea();
                jLabel13 = new javax.swing.JLabel();
                jLabel14 = new javax.swing.JLabel();
                newTicket_group = new javax.swing.JComboBox<>();
                newTicket_title = new javax.swing.JTextField();
                jLabel11 = new javax.swing.JLabel();
                view_about = new javax.swing.JPanel();
                universityRequest = new javax.swing.JLabel();
                version = new javax.swing.JLabel();
                staff_dev = new javax.swing.JLabel();
                staff_design = new javax.swing.JLabel();
                staff_network = new javax.swing.JLabel();
                staff_dev1 = new javax.swing.JLabel();
                staff_design1 = new javax.swing.JLabel();
                staff_network1 = new javax.swing.JLabel();
                staff_dev2 = new javax.swing.JLabel();
                staff_design2 = new javax.swing.JLabel();
                staff_network3 = new javax.swing.JLabel();
                icon_logo_server = new javax.swing.JLabel();
                about_contactUs = new javax.swing.JLabel();
                about_email = new javax.swing.JLabel();

                setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
                getContentPane().setLayout(new java.awt.CardLayout());

                view.setLayout(new java.awt.CardLayout());

                view_loading.setBackground(new java.awt.Color(188, 7, 46));

                loading.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/loading.gif"))); // NOI18N

                javax.swing.GroupLayout view_loadingLayout = new javax.swing.GroupLayout(view_loading);
                view_loading.setLayout(view_loadingLayout);
                view_loadingLayout.setHorizontalGroup(
                        view_loadingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(view_loadingLayout.createSequentialGroup()
                                .addContainerGap(763, Short.MAX_VALUE)
                                .addComponent(loading)
                                .addContainerGap(785, Short.MAX_VALUE))
                );
                view_loadingLayout.setVerticalGroup(
                        view_loadingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(view_loadingLayout.createSequentialGroup()
                                .addContainerGap(418, Short.MAX_VALUE)
                                .addComponent(loading)
                                .addContainerGap(418, Short.MAX_VALUE))
                );

                view.add(view_loading, "card10");

                view_serverNotFound.setBackground(new java.awt.Color(188, 7, 46));
                view_serverNotFound.setPreferredSize(new java.awt.Dimension(0, 0));
                view_serverNotFound.setLayout(new java.awt.BorderLayout());

                identification_logo1.setBackground(new java.awt.Color(188, 7, 46));
                identification_logo1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                identification_logo1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/logo_connexion.png"))); // NOI18N
                identification_logo1.setPreferredSize(new java.awt.Dimension(0, 250));
                view_serverNotFound.add(identification_logo1, java.awt.BorderLayout.NORTH);

                _serverNotFound.setBackground(new java.awt.Color(188, 7, 46));
                _serverNotFound.setLayout(new javax.swing.BoxLayout(_serverNotFound, javax.swing.BoxLayout.PAGE_AXIS));

                body_ServerNotFound.setBackground(new java.awt.Color(188, 7, 46));

                _retry.setBackground(new java.awt.Color(188, 7, 46));

                jSeparator3.setForeground(new java.awt.Color(255, 255, 255));

                jSeparator4.setForeground(new java.awt.Color(255, 255, 255));

                jButton1.setBackground(new java.awt.Color(255, 0, 102));
                jButton1.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
                jButton1.setForeground(new java.awt.Color(255, 255, 255));
                jButton1.setText("retry");
                jButton1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
                jButton1.setContentAreaFilled(false);
                jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
                jButton1.setMinimumSize(new java.awt.Dimension(0, 0));
                jButton1.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                jButton1ActionPerformed(evt);
                        }
                });

                jLabel1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
                jLabel1.setForeground(new java.awt.Color(255, 255, 255));
                jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
                jLabel1.setText("IP");

                jLabel2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
                jLabel2.setForeground(new java.awt.Color(255, 255, 255));
                jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
                jLabel2.setText("PORT");

                serverNotFound_ip.setBackground(new java.awt.Color(188, 7, 46));
                serverNotFound_ip.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
                serverNotFound_ip.setForeground(new java.awt.Color(255, 255, 255));
                serverNotFound_ip.setBorder(null);

                serverNotFound_port.setBackground(new java.awt.Color(188, 7, 46));
                serverNotFound_port.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
                serverNotFound_port.setForeground(new java.awt.Color(255, 255, 255));
                serverNotFound_port.setBorder(null);

                serverNotFound_icon.setBackground(new java.awt.Color(188, 7, 46));
                serverNotFound_icon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                serverNotFound_icon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/notFound_opacity5.png"))); // NOI18N
                serverNotFound_icon.setMinimumSize(new java.awt.Dimension(0, 0));

                javax.swing.GroupLayout _retryLayout = new javax.swing.GroupLayout(_retry);
                _retry.setLayout(_retryLayout);
                _retryLayout.setHorizontalGroup(
                        _retryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(_retryLayout.createSequentialGroup()
                                .addGap(300, 300, 300)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(serverNotFound_ip, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(_retryLayout.createSequentialGroup()
                                .addGap(300, 300, 300)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(serverNotFound_port, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(_retryLayout.createSequentialGroup()
                                .addGap(420, 420, 420)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(_retryLayout.createSequentialGroup()
                                .addGap(360, 360, 360)
                                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(_retryLayout.createSequentialGroup()
                                .addGap(360, 360, 360)
                                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(serverNotFound_icon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                );
                _retryLayout.setVerticalGroup(
                        _retryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(_retryLayout.createSequentialGroup()
                                .addGap(190, 190, 190)
                                .addGroup(_retryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel1)
                                        .addComponent(serverNotFound_ip, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(21, 21, 21)
                                .addGroup(_retryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel2)
                                        .addComponent(serverNotFound_port, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(41, 41, 41)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(_retryLayout.createSequentialGroup()
                                .addGap(250, 250, 250)
                                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(_retryLayout.createSequentialGroup()
                                .addGap(210, 210, 210)
                                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(_retryLayout.createSequentialGroup()
                                .addGap(60, 60, 60)
                                .addComponent(serverNotFound_icon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                );

                serverNotFound_ip.setText("127.0.0.1");
                //serverNotFound_ip.setText("77.141.121.226");
                serverNotFound_port.setText("5000");

                javax.swing.GroupLayout body_ServerNotFoundLayout = new javax.swing.GroupLayout(body_ServerNotFound);
                body_ServerNotFound.setLayout(body_ServerNotFoundLayout);
                body_ServerNotFoundLayout.setHorizontalGroup(
                        body_ServerNotFoundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(body_ServerNotFoundLayout.createSequentialGroup()
                                .addContainerGap(391, Short.MAX_VALUE)
                                .addComponent(_retry, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(711, Short.MAX_VALUE))
                );
                body_ServerNotFoundLayout.setVerticalGroup(
                        body_ServerNotFoundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(body_ServerNotFoundLayout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(_retry, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                );

                _serverNotFound.add(body_ServerNotFound);

                panel_consoleServerNotFound.setBackground(new java.awt.Color(188, 7, 46));

                serverNotFound_console.setBackground(new java.awt.Color(188, 7, 46));
                serverNotFound_console.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
                serverNotFound_console.setForeground(new java.awt.Color(188, 7, 46));
                panel_consoleServerNotFound.add(serverNotFound_console);

                serverNotFound_localhost.setText("remote server");
                serverNotFound_localhost.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                serverNotFound_localhostActionPerformed(evt);
                        }
                });
                panel_consoleServerNotFound.add(serverNotFound_localhost);

                _serverNotFound.add(panel_consoleServerNotFound);

                view_serverNotFound.add(_serverNotFound, java.awt.BorderLayout.CENTER);

                view.add(view_serverNotFound, "serverNotFound");

                view_identification.setBackground(new java.awt.Color(188, 7, 46));
                view_identification.setPreferredSize(new java.awt.Dimension(0, 0));
                view_identification.setLayout(new java.awt.BorderLayout());

                identification_logo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                identification_logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/logo_connexion.png"))); // NOI18N
                identification_logo.setPreferredSize(new java.awt.Dimension(0, 250));
                view_identification.add(identification_logo, java.awt.BorderLayout.NORTH);

                _identification.setBackground(new java.awt.Color(188, 7, 46));

                body_connexion.setBackground(new java.awt.Color(188, 7, 46));

                identification_login.setBackground(new java.awt.Color(188, 7, 46));
                identification_login.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
                identification_login.setForeground(new java.awt.Color(255, 255, 255));
                identification_login.setText("login");
                identification_login.setBorder(null);
                identification_login.addFocusListener(new java.awt.event.FocusAdapter() {
                        public void focusGained(java.awt.event.FocusEvent evt) {
                                identification_loginFocusGained(evt);
                        }
                });
                identification_login.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                identification_loginActionPerformed(evt);
                        }
                });

                passwdInput.setBackground(new java.awt.Color(188, 7, 46));
                passwdInput.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
                passwdInput.setForeground(new java.awt.Color(255, 255, 255));
                passwdInput.setText("password");
                passwdInput.setBorder(null);
                passwdInput.addFocusListener(new java.awt.event.FocusAdapter() {
                        public void focusGained(java.awt.event.FocusEvent evt) {
                                passwdInputFocusGained(evt);
                        }
                });
                passwdInput.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                passwdInputActionPerformed(evt);
                        }
                });

                identification_connection.setBackground(new java.awt.Color(255, 255, 255));
                identification_connection.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
                identification_connection.setForeground(new java.awt.Color(255, 255, 255));
                identification_connection.setText("Sign in");
                identification_connection.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
                identification_connection.setContentAreaFilled(false);
                identification_connection.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
                identification_connection.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                identification_connectionActionPerformed(evt);
                        }
                });

                jSeparator1.setForeground(new java.awt.Color(255, 255, 255));

                jSeparator2.setForeground(new java.awt.Color(255, 255, 255));

                not_registered.setBackground(new java.awt.Color(255, 255, 255));
                not_registered.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
                not_registered.setForeground(new java.awt.Color(255, 255, 255));
                not_registered.setText("Not registered ?");
                not_registered.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
                not_registered.addMouseListener(new java.awt.event.MouseAdapter() {
                        public void mouseClicked(java.awt.event.MouseEvent evt) {
                                not_registeredMouseClicked(evt);
                        }
                });

                icon_user.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/password.png"))); // NOI18N

                icon_user1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/user.png"))); // NOI18N

                connexion_logoOpacity5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/logo_opacity5.png"))); // NOI18N

                javax.swing.GroupLayout body_connexionLayout = new javax.swing.GroupLayout(body_connexion);
                body_connexion.setLayout(body_connexionLayout);
                body_connexionLayout.setHorizontalGroup(
                        body_connexionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(body_connexionLayout.createSequentialGroup()
                                .addGroup(body_connexionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(body_connexionLayout.createSequentialGroup()
                                                .addGap(240, 240, 240)
                                                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 355, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(body_connexionLayout.createSequentialGroup()
                                                .addGap(240, 240, 240)
                                                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 355, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(body_connexionLayout.createSequentialGroup()
                                                .addGap(240, 240, 240)
                                                .addComponent(passwdInput, javax.swing.GroupLayout.PREFERRED_SIZE, 355, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(body_connexionLayout.createSequentialGroup()
                                                .addGap(210, 210, 210)
                                                .addComponent(icon_user1))
                                        .addGroup(body_connexionLayout.createSequentialGroup()
                                                .addGap(210, 210, 210)
                                                .addComponent(icon_user))
                                        .addGroup(body_connexionLayout.createSequentialGroup()
                                                .addGap(240, 240, 240)
                                                .addComponent(identification_login, javax.swing.GroupLayout.PREFERRED_SIZE, 355, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(body_connexionLayout.createSequentialGroup()
                                                .addGap(10, 10, 10)
                                                .addGroup(body_connexionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(not_registered, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(connexion_logoOpacity5, javax.swing.GroupLayout.PREFERRED_SIZE, 390, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(110, 110, 110)
                                                .addComponent(identification_connection, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(214, Short.MAX_VALUE))
                );
                body_connexionLayout.setVerticalGroup(
                        body_connexionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(body_connexionLayout.createSequentialGroup()
                                .addGap(120, 120, 120)
                                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(body_connexionLayout.createSequentialGroup()
                                .addGap(80, 80, 80)
                                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(body_connexionLayout.createSequentialGroup()
                                .addGap(100, 100, 100)
                                .addComponent(passwdInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(body_connexionLayout.createSequentialGroup()
                                .addGap(60, 60, 60)
                                .addComponent(icon_user1))
                        .addGroup(body_connexionLayout.createSequentialGroup()
                                .addGap(100, 100, 100)
                                .addComponent(icon_user))
                        .addGroup(body_connexionLayout.createSequentialGroup()
                                .addGap(140, 140, 140)
                                .addComponent(identification_connection, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(body_connexionLayout.createSequentialGroup()
                                .addGap(150, 150, 150)
                                .addComponent(not_registered))
                        .addGroup(body_connexionLayout.createSequentialGroup()
                                .addGap(60, 60, 60)
                                .addComponent(identification_login, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(body_connexionLayout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(connexion_logoOpacity5, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE))
                );

                identification_login.setText("gauthier");
                passwdInput.setText("passwd");

                _identification.add(body_connexion);

                view_identification.add(_identification, java.awt.BorderLayout.CENTER);

                identification_footer.setBackground(new java.awt.Color(188, 7, 46));
                identification_footer.setLayout(new java.awt.CardLayout());

                footer_empty.setBackground(new java.awt.Color(188, 7, 46));

                javax.swing.GroupLayout footer_emptyLayout = new javax.swing.GroupLayout(footer_empty);
                footer_empty.setLayout(footer_emptyLayout);
                footer_emptyLayout.setHorizontalGroup(
                        footer_emptyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 1612, Short.MAX_VALUE)
                );
                footer_emptyLayout.setVerticalGroup(
                        footer_emptyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 100, Short.MAX_VALUE)
                );

                identification_footer.add(footer_empty, "empty");

                footer_incorrect.setBackground(new java.awt.Color(188, 7, 46));
                footer_incorrect.setPreferredSize(new java.awt.Dimension(1160, 100));

                identification_errorLogin.setBackground(new java.awt.Color(255, 255, 255));
                identification_errorLogin.setPreferredSize(new java.awt.Dimension(133, 83));

                not_registered1.setBackground(new java.awt.Color(255, 255, 255));
                not_registered1.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
                not_registered1.setForeground(new java.awt.Color(188, 7, 46));
                not_registered1.setText("Login/password incorrect !");
                not_registered1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
                not_registered1.addMouseListener(new java.awt.event.MouseAdapter() {
                        public void mouseClicked(java.awt.event.MouseEvent evt) {
                                not_registered1MouseClicked(evt);
                        }
                });

                jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/error.png"))); // NOI18N

                javax.swing.GroupLayout identification_errorLoginLayout = new javax.swing.GroupLayout(identification_errorLogin);
                identification_errorLogin.setLayout(identification_errorLoginLayout);
                identification_errorLoginLayout.setHorizontalGroup(
                        identification_errorLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(identification_errorLoginLayout.createSequentialGroup()
                                .addGap(13, 13, 13)
                                .addComponent(jLabel16)
                                .addGap(18, 18, 18)
                                .addComponent(not_registered1, javax.swing.GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE)
                                .addContainerGap())
                );
                identification_errorLoginLayout.setVerticalGroup(
                        identification_errorLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(identification_errorLoginLayout.createSequentialGroup()
                                .addGroup(identification_errorLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(identification_errorLoginLayout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(not_registered1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap())
                );

                javax.swing.GroupLayout footer_incorrectLayout = new javax.swing.GroupLayout(footer_incorrect);
                footer_incorrect.setLayout(footer_incorrectLayout);
                footer_incorrectLayout.setHorizontalGroup(
                        footer_incorrectLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, footer_incorrectLayout.createSequentialGroup()
                                .addContainerGap(676, Short.MAX_VALUE)
                                .addComponent(identification_errorLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(677, Short.MAX_VALUE))
                );
                footer_incorrectLayout.setVerticalGroup(
                        footer_incorrectLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(footer_incorrectLayout.createSequentialGroup()
                                .addGap(0, 28, Short.MAX_VALUE)
                                .addComponent(identification_errorLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 28, Short.MAX_VALUE))
                );

                //identification_errorLoginPasswd.setVisible(false);

                identification_footer.add(footer_incorrect, "incorrect");
                //identification_errorLogin.setVisible(false);

                footer_loading.setBackground(new java.awt.Color(188, 7, 46));
                footer_loading.setPreferredSize(new java.awt.Dimension(1160, 100));

                identification_loadingInterface.setBackground(new java.awt.Color(255, 255, 255));
                identification_loadingInterface.setPreferredSize(new java.awt.Dimension(133, 83));

                not_registered2.setBackground(new java.awt.Color(255, 255, 255));
                not_registered2.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
                not_registered2.setForeground(new java.awt.Color(188, 7, 46));
                not_registered2.setText("Interface loading...");
                not_registered2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
                not_registered2.addMouseListener(new java.awt.event.MouseAdapter() {
                        public void mouseClicked(java.awt.event.MouseEvent evt) {
                                not_registered2MouseClicked(evt);
                        }
                });

                jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/loading-little.gif"))); // NOI18N

                javax.swing.GroupLayout identification_loadingInterfaceLayout = new javax.swing.GroupLayout(identification_loadingInterface);
                identification_loadingInterface.setLayout(identification_loadingInterfaceLayout);
                identification_loadingInterfaceLayout.setHorizontalGroup(
                        identification_loadingInterfaceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(identification_loadingInterfaceLayout.createSequentialGroup()
                                .addGap(13, 13, 13)
                                .addComponent(jLabel17)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(not_registered2, javax.swing.GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE))
                );
                identification_loadingInterfaceLayout.setVerticalGroup(
                        identification_loadingInterfaceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(identification_loadingInterfaceLayout.createSequentialGroup()
                                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(identification_loadingInterfaceLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(not_registered2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())
                );

                javax.swing.GroupLayout footer_loadingLayout = new javax.swing.GroupLayout(footer_loading);
                footer_loading.setLayout(footer_loadingLayout);
                footer_loadingLayout.setHorizontalGroup(
                        footer_loadingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, footer_loadingLayout.createSequentialGroup()
                                .addContainerGap(715, Short.MAX_VALUE)
                                .addComponent(identification_loadingInterface, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(715, Short.MAX_VALUE))
                );
                footer_loadingLayout.setVerticalGroup(
                        footer_loadingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(footer_loadingLayout.createSequentialGroup()
                                .addGap(0, 28, Short.MAX_VALUE)
                                .addComponent(identification_loadingInterface, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 28, Short.MAX_VALUE))
                );

                //identification_errorLogin.setVisible(false);

                identification_footer.add(footer_loading, "loading");
                //identification_errorLoginPasswd.setVisible(false);

                view_identification.add(identification_footer, java.awt.BorderLayout.SOUTH);
                cview3 =(CardLayout)identification_footer.getLayout();

                view.add(view_identification, "identification");

                view_newUser.setBackground(new java.awt.Color(188, 7, 46));
                view_newUser.setPreferredSize(new java.awt.Dimension(0, 0));
                view_newUser.setLayout(new java.awt.BorderLayout());

                newUser_logo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                newUser_logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/logo_connexion.png"))); // NOI18N
                newUser_logo.setPreferredSize(new java.awt.Dimension(0, 250));
                view_newUser.add(newUser_logo, java.awt.BorderLayout.NORTH);

                zone_newUser.setBackground(new java.awt.Color(188, 7, 46));

                zone_inscription.setBackground(new java.awt.Color(188, 7, 46));

                newUser_iconName.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/name-icon.png"))); // NOI18N

                newUser_iconFirstname.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/name-icon.png"))); // NOI18N

                newUser_iconEmail.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/email.png"))); // NOI18N

                newUser_iconLogin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/user.png"))); // NOI18N

                newUser_iconPasswd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/password.png"))); // NOI18N

                newUser_iconStatus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/status.png"))); // NOI18N

                newUser_name.setBackground(new java.awt.Color(188, 7, 46));
                newUser_name.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
                newUser_name.setForeground(new java.awt.Color(255, 255, 255));
                newUser_name.setText("name");
                newUser_name.setBorder(null);
                newUser_name.addFocusListener(new java.awt.event.FocusAdapter() {
                        public void focusGained(java.awt.event.FocusEvent evt) {
                                newUser_nameFocusGained(evt);
                        }
                });

                newUser_firstName.setBackground(new java.awt.Color(188, 7, 46));
                newUser_firstName.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
                newUser_firstName.setForeground(new java.awt.Color(255, 255, 255));
                newUser_firstName.setText("firstname");
                newUser_firstName.setBorder(null);
                newUser_firstName.addFocusListener(new java.awt.event.FocusAdapter() {
                        public void focusGained(java.awt.event.FocusEvent evt) {
                                newUser_firstNameFocusGained(evt);
                        }
                });

                newUser_email.setBackground(new java.awt.Color(188, 7, 46));
                newUser_email.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
                newUser_email.setForeground(new java.awt.Color(255, 255, 255));
                newUser_email.setText("email");
                newUser_email.setBorder(null);
                newUser_email.addFocusListener(new java.awt.event.FocusAdapter() {
                        public void focusGained(java.awt.event.FocusEvent evt) {
                                newUser_emailFocusGained(evt);
                        }
                });

                newUser_login.setBackground(new java.awt.Color(188, 7, 46));
                newUser_login.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
                newUser_login.setForeground(new java.awt.Color(255, 255, 255));
                newUser_login.setText("login");
                newUser_login.setBorder(null);
                newUser_login.addFocusListener(new java.awt.event.FocusAdapter() {
                        public void focusGained(java.awt.event.FocusEvent evt) {
                                newUser_loginFocusGained(evt);
                        }
                });

                newUser_passwrd.setBackground(new java.awt.Color(188, 7, 46));
                newUser_passwrd.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
                newUser_passwrd.setForeground(new java.awt.Color(255, 255, 255));
                newUser_passwrd.setText("password");
                newUser_passwrd.setBorder(null);
                newUser_passwrd.addFocusListener(new java.awt.event.FocusAdapter() {
                        public void focusGained(java.awt.event.FocusEvent evt) {
                                newUser_passwrdFocusGained(evt);
                        }
                });

                newUser_status.setBackground(new java.awt.Color(188, 7, 46));
                newUser_status.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
                newUser_status.setForeground(new java.awt.Color(255, 255, 255));
                newUser_status.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "student", "professor", "service" }));
                newUser_status.setToolTipText("");
                newUser_status.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
                newUser_status.setDoubleBuffered(true);
                newUser_status.setName(""); // NOI18N
                newUser_status.setNextFocusableComponent(newUser_join);
                newUser_status.setOpaque(false);

                newUser_separatorName.setForeground(new java.awt.Color(255, 255, 255));

                newUser_separatorFirstname.setForeground(new java.awt.Color(255, 255, 255));

                newUser_sepearatorEmail.setForeground(new java.awt.Color(255, 255, 255));

                newUser_seperatorLogin.setForeground(new java.awt.Color(255, 255, 255));

                newUser_separatorPasswd.setForeground(new java.awt.Color(255, 255, 255));

                newUser_join.setBackground(new java.awt.Color(255, 255, 255));
                newUser_join.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
                newUser_join.setForeground(new java.awt.Color(255, 255, 255));
                newUser_join.setText("Join");
                newUser_join.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
                newUser_join.setContentAreaFilled(false);
                newUser_join.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
                newUser_join.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                newUser_joinActionPerformed(evt);
                        }
                });

                back.setBackground(new java.awt.Color(255, 255, 255));
                back.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
                back.setForeground(new java.awt.Color(255, 255, 255));
                back.setText("Go back ?");
                back.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
                back.addMouseListener(new java.awt.event.MouseAdapter() {
                        public void mouseClicked(java.awt.event.MouseEvent evt) {
                                backMouseClicked(evt);
                        }
                });

                logo_opacity6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/newUser_opacity5.png"))); // NOI18N
                logo_opacity6.setName(""); // NOI18N

                javax.swing.GroupLayout zone_inscriptionLayout = new javax.swing.GroupLayout(zone_inscription);
                zone_inscription.setLayout(zone_inscriptionLayout);
                zone_inscriptionLayout.setHorizontalGroup(
                        zone_inscriptionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(zone_inscriptionLayout.createSequentialGroup()
                                .addGap(292, 292, 292)
                                .addGroup(zone_inscriptionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(newUser_iconName)
                                        .addComponent(newUser_iconFirstname)
                                        .addComponent(newUser_iconEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(newUser_iconLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(newUser_iconPasswd, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(newUser_iconStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(zone_inscriptionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(newUser_name, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(newUser_separatorName, javax.swing.GroupLayout.PREFERRED_SIZE, 355, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(newUser_firstName, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(newUser_separatorFirstname, javax.swing.GroupLayout.PREFERRED_SIZE, 355, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(newUser_email, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(newUser_sepearatorEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 355, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(newUser_login, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(newUser_seperatorLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 355, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(newUser_passwrd, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(newUser_separatorPasswd, javax.swing.GroupLayout.PREFERRED_SIZE, 355, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(newUser_status, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(zone_inscriptionLayout.createSequentialGroup()
                                                .addComponent(back, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGroup(zone_inscriptionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(zone_inscriptionLayout.createSequentialGroup()
                                                                .addGap(118, 118, 118)
                                                                .addComponent(newUser_join, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(zone_inscriptionLayout.createSequentialGroup()
                                                                .addGap(20, 20, 20)
                                                                .addComponent(logo_opacity6, javax.swing.GroupLayout.PREFERRED_SIZE, 480, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                );
                zone_inscriptionLayout.setVerticalGroup(
                        zone_inscriptionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(zone_inscriptionLayout.createSequentialGroup()
                                .addGap(50, 50, 50)
                                .addComponent(newUser_iconName, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(newUser_iconFirstname, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(newUser_iconEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(14, 14, 14)
                                .addComponent(newUser_iconLogin)
                                .addGap(4, 4, 4)
                                .addComponent(newUser_iconPasswd, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(newUser_iconStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(zone_inscriptionLayout.createSequentialGroup()
                                .addGap(60, 60, 60)
                                .addComponent(newUser_name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(1, 1, 1)
                                .addComponent(newUser_separatorName, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(newUser_firstName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(1, 1, 1)
                                .addComponent(newUser_separatorFirstname, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(newUser_email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(1, 1, 1)
                                .addComponent(newUser_sepearatorEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(newUser_login, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(1, 1, 1)
                                .addComponent(newUser_seperatorLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(newUser_passwrd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(1, 1, 1)
                                .addComponent(newUser_separatorPasswd, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(newUser_status, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(22, 22, 22)
                                .addGroup(zone_inscriptionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(zone_inscriptionLayout.createSequentialGroup()
                                                .addGap(10, 10, 10)
                                                .addComponent(back))
                                        .addComponent(newUser_join, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addComponent(logo_opacity6, javax.swing.GroupLayout.PREFERRED_SIZE, 480, javax.swing.GroupLayout.PREFERRED_SIZE)
                );

                zone_newUser.add(zone_inscription);

                view_newUser.add(zone_newUser, java.awt.BorderLayout.CENTER);

                footer_newUser.setBackground(new java.awt.Color(188, 7, 46));
                footer_newUser.setLayout(new java.awt.CardLayout());

                newUser_print.setBackground(new java.awt.Color(188, 7, 46));

                newUser_error.setBackground(new java.awt.Color(255, 255, 255));
                newUser_error.setPreferredSize(new java.awt.Dimension(133, 83));

                newUser_logMessage.setBackground(new java.awt.Color(255, 255, 255));
                newUser_logMessage.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
                newUser_logMessage.setForeground(new java.awt.Color(188, 7, 46));
                newUser_logMessage.setText("Error ! Contact us (admin@university-request.fr)");
                newUser_logMessage.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
                newUser_logMessage.addMouseListener(new java.awt.event.MouseAdapter() {
                        public void mouseClicked(java.awt.event.MouseEvent evt) {
                                newUser_logMessageMouseClicked(evt);
                        }
                });

                newUser_logIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/error.png"))); // NOI18N

                javax.swing.GroupLayout newUser_errorLayout = new javax.swing.GroupLayout(newUser_error);
                newUser_error.setLayout(newUser_errorLayout);
                newUser_errorLayout.setHorizontalGroup(
                        newUser_errorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(newUser_errorLayout.createSequentialGroup()
                                .addGap(13, 13, 13)
                                .addComponent(newUser_logIcon)
                                .addGap(18, 18, 18)
                                .addComponent(newUser_logMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 348, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                );
                newUser_errorLayout.setVerticalGroup(
                        newUser_errorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(newUser_errorLayout.createSequentialGroup()
                                .addGroup(newUser_errorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(newUser_logIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(newUser_errorLayout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(newUser_logMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap())
                );

                newUser_errorFields.setBackground(new java.awt.Color(255, 255, 255));
                newUser_errorFields.setPreferredSize(new java.awt.Dimension(133, 83));

                newUser_logMessage2.setBackground(new java.awt.Color(255, 255, 255));
                newUser_logMessage2.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
                newUser_logMessage2.setForeground(new java.awt.Color(188, 7, 46));
                newUser_logMessage2.setText("Please complete all fields ! ");
                newUser_logMessage2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
                newUser_logMessage2.addMouseListener(new java.awt.event.MouseAdapter() {
                        public void mouseClicked(java.awt.event.MouseEvent evt) {
                                newUser_logMessage2MouseClicked(evt);
                        }
                });

                newUser_logIcon2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/error.png"))); // NOI18N

                javax.swing.GroupLayout newUser_errorFieldsLayout = new javax.swing.GroupLayout(newUser_errorFields);
                newUser_errorFields.setLayout(newUser_errorFieldsLayout);
                newUser_errorFieldsLayout.setHorizontalGroup(
                        newUser_errorFieldsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(newUser_errorFieldsLayout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(newUser_logIcon2)
                                .addGap(18, 18, 18)
                                .addComponent(newUser_logMessage2, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE))
                );
                newUser_errorFieldsLayout.setVerticalGroup(
                        newUser_errorFieldsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(newUser_errorFieldsLayout.createSequentialGroup()
                                .addGroup(newUser_errorFieldsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(newUser_logIcon2, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(newUser_errorFieldsLayout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(newUser_logMessage2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap())
                );

                newUser_okEmail.setBackground(new java.awt.Color(255, 255, 255));
                newUser_okEmail.setPreferredSize(new java.awt.Dimension(133, 83));

                newUser_logMessage1.setBackground(new java.awt.Color(255, 255, 255));
                newUser_logMessage1.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
                newUser_logMessage1.setForeground(new java.awt.Color(188, 7, 46));
                newUser_logMessage1.setText("Check your emails !");
                newUser_logMessage1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
                newUser_logMessage1.addMouseListener(new java.awt.event.MouseAdapter() {
                        public void mouseClicked(java.awt.event.MouseEvent evt) {
                                newUser_logMessage1MouseClicked(evt);
                        }
                });

                newUser_logIcon1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/check-ok.png"))); // NOI18N

                javax.swing.GroupLayout newUser_okEmailLayout = new javax.swing.GroupLayout(newUser_okEmail);
                newUser_okEmail.setLayout(newUser_okEmailLayout);
                newUser_okEmailLayout.setHorizontalGroup(
                        newUser_okEmailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(newUser_okEmailLayout.createSequentialGroup()
                                .addGap(13, 13, 13)
                                .addComponent(newUser_logIcon1)
                                .addGap(18, 18, 18)
                                .addComponent(newUser_logMessage1, javax.swing.GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE))
                );
                newUser_okEmailLayout.setVerticalGroup(
                        newUser_okEmailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(newUser_okEmailLayout.createSequentialGroup()
                                .addGroup(newUser_okEmailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(newUser_logIcon1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(newUser_okEmailLayout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(newUser_logMessage1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap())
                );

                newUser_errorDomain.setBackground(new java.awt.Color(255, 255, 255));
                newUser_errorDomain.setPreferredSize(new java.awt.Dimension(133, 83));

                newUser_logMessage3.setBackground(new java.awt.Color(255, 255, 255));
                newUser_logMessage3.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
                newUser_logMessage3.setForeground(new java.awt.Color(188, 7, 46));
                newUser_logMessage3.setText("Please use your professional email (@univ-tlse3.fr or @irit.fr)");
                newUser_logMessage3.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
                newUser_logMessage3.addMouseListener(new java.awt.event.MouseAdapter() {
                        public void mouseClicked(java.awt.event.MouseEvent evt) {
                                newUser_logMessage3MouseClicked(evt);
                        }
                });

                newUser_logIcon3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/error.png"))); // NOI18N

                javax.swing.GroupLayout newUser_errorDomainLayout = new javax.swing.GroupLayout(newUser_errorDomain);
                newUser_errorDomain.setLayout(newUser_errorDomainLayout);
                newUser_errorDomainLayout.setHorizontalGroup(
                        newUser_errorDomainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(newUser_errorDomainLayout.createSequentialGroup()
                                .addGap(13, 13, 13)
                                .addComponent(newUser_logIcon3)
                                .addGap(18, 18, 18)
                                .addComponent(newUser_logMessage3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())
                );
                newUser_errorDomainLayout.setVerticalGroup(
                        newUser_errorDomainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(newUser_errorDomainLayout.createSequentialGroup()
                                .addGroup(newUser_errorDomainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(newUser_logIcon3, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(newUser_errorDomainLayout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(newUser_logMessage3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap())
                );

                javax.swing.GroupLayout newUser_printLayout = new javax.swing.GroupLayout(newUser_print);
                newUser_print.setLayout(newUser_printLayout);
                newUser_printLayout.setHorizontalGroup(
                        newUser_printLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 1612, Short.MAX_VALUE)
                        .addGroup(newUser_printLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, newUser_printLayout.createSequentialGroup()
                                        .addContainerGap(619, Short.MAX_VALUE)
                                        .addComponent(newUser_error, javax.swing.GroupLayout.PREFERRED_SIZE, 374, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addContainerGap(619, Short.MAX_VALUE)))
                        .addGroup(newUser_printLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, newUser_printLayout.createSequentialGroup()
                                        .addContainerGap(703, Short.MAX_VALUE)
                                        .addComponent(newUser_okEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addContainerGap(704, Short.MAX_VALUE)))
                        .addGroup(newUser_printLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, newUser_printLayout.createSequentialGroup()
                                        .addContainerGap(685, Short.MAX_VALUE)
                                        .addComponent(newUser_errorFields, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addContainerGap(686, Short.MAX_VALUE)))
                        .addGroup(newUser_printLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, newUser_printLayout.createSequentialGroup()
                                        .addContainerGap(579, Short.MAX_VALUE)
                                        .addComponent(newUser_errorDomain, javax.swing.GroupLayout.PREFERRED_SIZE, 454, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addContainerGap(579, Short.MAX_VALUE)))
                );
                newUser_printLayout.setVerticalGroup(
                        newUser_printLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 100, Short.MAX_VALUE)
                        .addGroup(newUser_printLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, newUser_printLayout.createSequentialGroup()
                                        .addContainerGap(28, Short.MAX_VALUE)
                                        .addComponent(newUser_error, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addContainerGap(28, Short.MAX_VALUE)))
                        .addGroup(newUser_printLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, newUser_printLayout.createSequentialGroup()
                                        .addContainerGap(28, Short.MAX_VALUE)
                                        .addComponent(newUser_okEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addContainerGap(28, Short.MAX_VALUE)))
                        .addGroup(newUser_printLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, newUser_printLayout.createSequentialGroup()
                                        .addContainerGap(28, Short.MAX_VALUE)
                                        .addComponent(newUser_errorFields, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addContainerGap(28, Short.MAX_VALUE)))
                        .addGroup(newUser_printLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, newUser_printLayout.createSequentialGroup()
                                        .addContainerGap(28, Short.MAX_VALUE)
                                        .addComponent(newUser_errorDomain, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addContainerGap(28, Short.MAX_VALUE)))
                );

                newUser_error.setVisible(false);
                newUser_errorFields.setVisible(false);
                newUser_okEmail.setVisible(false);
                newUser_errorDomain.setVisible(false);

                footer_newUser.add(newUser_print, "card2");
                newUser_error.setVisible(false);

                view_newUser.add(footer_newUser, java.awt.BorderLayout.SOUTH);

                view.add(view_newUser, "newUser");

                view_home.setMaximumSize(new java.awt.Dimension(10000, 10000));
                view_home.setMinimumSize(new java.awt.Dimension(0, 0));
                view_home.setLayout(new java.awt.BorderLayout());

                home_menu.setBackground(new java.awt.Color(188, 7, 46));
                home_menu.setMinimumSize(new java.awt.Dimension(0, 0));
                home_menu.setPreferredSize(new java.awt.Dimension(300, 900));

                logo_client.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/logo_server.png"))); // NOI18N
                logo_client.setText("jLabel26");

                footer_left.setBackground(new java.awt.Color(188, 7, 46));

                about.setFont(new java.awt.Font("Dialog", 2, 14)); // NOI18N
                about.setForeground(new java.awt.Color(188, 7, 46));
                about.setText("<html><font style=\"background-color : white\">&nbsp;&nbsp;about the project ?&nbsp;&nbsp;</font></html>");
                about.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
                about.addMouseListener(new java.awt.event.MouseAdapter() {
                        public void mouseClicked(java.awt.event.MouseEvent evt) {
                                aboutMouseClicked(evt);
                        }
                });

                javax.swing.GroupLayout footer_leftLayout = new javax.swing.GroupLayout(footer_left);
                footer_left.setLayout(footer_leftLayout);
                footer_leftLayout.setHorizontalGroup(
                        footer_leftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, footer_leftLayout.createSequentialGroup()
                                .addContainerGap(83, Short.MAX_VALUE)
                                .addComponent(about, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(83, Short.MAX_VALUE))
                );
                footer_leftLayout.setVerticalGroup(
                        footer_leftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, footer_leftLayout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(about, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(20, Short.MAX_VALUE))
                );

                home_tickets.setBackground(new java.awt.Color(255, 51, 51));
                home_tickets.setBorder(null);

                tree.setBackground(new java.awt.Color(188, 7, 46));
                tree.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
                tree.setForeground(new java.awt.Color(255, 255, 255));
                tree.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
                tree.setMaximumSize(new java.awt.Dimension(10000, 10000));
                tree.setMinimumSize(new java.awt.Dimension(300, 0));
                tree.setOpaque(false);
                tree.setPreferredSize(new java.awt.Dimension(300, 0));
                tree.setRootVisible(false);
                home_tickets.setViewportView(tree);

                jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/client-user.png"))); // NOI18N
                jLabel3.setToolTipText("");

                home_userName.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
                home_userName.setForeground(new java.awt.Color(255, 255, 255));
                home_userName.setText("login");
                home_userName.setToolTipText("qsd");

                jPanel1.setBackground(new java.awt.Color(188, 7, 46));

                home_newTicket.setBackground(new java.awt.Color(255, 255, 255));
                home_newTicket.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
                home_newTicket.setForeground(new java.awt.Color(255, 255, 255));
                home_newTicket.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/new_ticket.png"))); // NOI18N
                home_newTicket.setText("   new ticket              ");
                home_newTicket.setActionCommand("   new ticket       ");
                home_newTicket.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(151, 8, 39)));
                home_newTicket.setContentAreaFilled(false);
                home_newTicket.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
                home_newTicket.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                home_newTicketActionPerformed(evt);
                        }
                });

                home_group.setBackground(new java.awt.Color(255, 255, 255));
                home_group.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
                home_group.setForeground(new java.awt.Color(255, 255, 255));
                home_group.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/edit_group.png"))); // NOI18N
                home_group.setText("   add/remove  group");
                home_group.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(151, 8, 39)));
                home_group.setContentAreaFilled(false);
                home_group.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
                home_group.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                home_groupActionPerformed(evt);
                        }
                });

                javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
                jPanel1.setLayout(jPanel1Layout);
                jPanel1Layout.setHorizontalGroup(
                        jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(home_group, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(home_newTicket, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                );
                jPanel1Layout.setVerticalGroup(
                        jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(home_newTicket, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(home_group, javax.swing.GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE)
                                .addContainerGap())
                );

                javax.swing.GroupLayout home_menuLayout = new javax.swing.GroupLayout(home_menu);
                home_menu.setLayout(home_menuLayout);
                home_menuLayout.setHorizontalGroup(
                        home_menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, home_menuLayout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(home_menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                                        .addComponent(home_userName)
                                        .addComponent(jLabel3))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(home_menuLayout.createSequentialGroup()
                                .addGroup(home_menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(logo_client, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(footer_left, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(home_tickets, javax.swing.GroupLayout.Alignment.LEADING))
                                .addGap(0, 0, Short.MAX_VALUE))
                );
                home_menuLayout.setVerticalGroup(
                        home_menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(home_menuLayout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addComponent(logo_client, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(jLabel3)
                                .addGap(0, 0, 0)
                                .addComponent(home_userName)
                                .addGap(40, 40, 40)
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(48, 48, 48)
                                .addComponent(home_tickets, javax.swing.GroupLayout.PREFERRED_SIZE, 374, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(footer_left, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(42, Short.MAX_VALUE))
                );

                view_home.add(home_menu, java.awt.BorderLayout.WEST);

                home_right.setBackground(new java.awt.Color(255, 255, 255));
                home_right.setLayout(new java.awt.BorderLayout());

                header_home.setBackground(new java.awt.Color(255, 255, 255));
                header_home.setPreferredSize(new java.awt.Dimension(0, 50));

                home_leave.setBackground(new java.awt.Color(255, 255, 255));
                home_leave.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
                home_leave.setForeground(new java.awt.Color(188, 7, 46));
                home_leave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/logout.png"))); // NOI18N
                home_leave.setText("logout");
                home_leave.setBorder(null);
                home_leave.setBorderPainted(false);
                home_leave.setContentAreaFilled(false);
                home_leave.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
                home_leave.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                home_leaveActionPerformed(evt);
                        }
                });

                home_ticket.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
                home_ticket.setForeground(new java.awt.Color(188, 7, 46));

                javax.swing.GroupLayout header_homeLayout = new javax.swing.GroupLayout(header_home);
                header_home.setLayout(header_homeLayout);
                header_homeLayout.setHorizontalGroup(
                        header_homeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(header_homeLayout.createSequentialGroup()
                                .addGap(38, 38, 38)
                                .addComponent(home_ticket, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 807, Short.MAX_VALUE)
                                .addComponent(home_leave, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(33, 33, 33))
                );
                header_homeLayout.setVerticalGroup(
                        header_homeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(header_homeLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(header_homeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(header_homeLayout.createSequentialGroup()
                                                .addGap(4, 4, 4)
                                                .addComponent(home_ticket, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGroup(header_homeLayout.createSequentialGroup()
                                                .addComponent(home_leave, javax.swing.GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE)
                                                .addContainerGap())))
                );

                home_right.add(header_home, java.awt.BorderLayout.NORTH);

                view2.setBackground(new java.awt.Color(255, 255, 255));
                view2.setLayout(new java.awt.CardLayout(10, 10));

                view_welcome.setBackground(new java.awt.Color(255, 255, 255));

                welcome.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
                welcome.setForeground(new java.awt.Color(188, 7, 46));
                welcome.setText("Welcome");

                to_interface_admin.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
                to_interface_admin.setForeground(new java.awt.Color(188, 7, 46));
                to_interface_admin.setText("to user interface");

                need_help.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
                need_help.setForeground(new java.awt.Color(188, 7, 46));
                need_help.setText("Need help ?");

                help_email.setForeground(new java.awt.Color(188, 7, 46));
                help_email.setText("help@university-request.fr");

                icon_logo_opacity10.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
                icon_logo_opacity10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/logo_opacity10.png"))); // NOI18N

                javax.swing.GroupLayout view_welcomeLayout = new javax.swing.GroupLayout(view_welcome);
                view_welcome.setLayout(view_welcomeLayout);
                view_welcomeLayout.setHorizontalGroup(
                        view_welcomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(view_welcomeLayout.createSequentialGroup()
                                .addContainerGap(281, Short.MAX_VALUE)
                                .addGroup(view_welcomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(icon_logo_opacity10)
                                        .addGroup(view_welcomeLayout.createSequentialGroup()
                                                .addGap(330, 330, 330)
                                                .addComponent(to_interface_admin, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(view_welcomeLayout.createSequentialGroup()
                                                .addGap(310, 310, 310)
                                                .addComponent(welcome, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(view_welcomeLayout.createSequentialGroup()
                                                .addGap(355, 355, 355)
                                                .addComponent(need_help, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(view_welcomeLayout.createSequentialGroup()
                                                .addGap(309, 309, 309)
                                                .addComponent(help_email, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(481, Short.MAX_VALUE))
                );
                view_welcomeLayout.setVerticalGroup(
                        view_welcomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(view_welcomeLayout.createSequentialGroup()
                                .addGroup(view_welcomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(view_welcomeLayout.createSequentialGroup()
                                                .addGap(123, 123, 123)
                                                .addGroup(view_welcomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(icon_logo_opacity10, javax.swing.GroupLayout.PREFERRED_SIZE, 477, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGroup(view_welcomeLayout.createSequentialGroup()
                                                                .addGap(240, 240, 240)
                                                                .addComponent(to_interface_admin, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                        .addGroup(view_welcomeLayout.createSequentialGroup()
                                                .addGap(313, 313, 313)
                                                .addComponent(welcome)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(need_help)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(help_email)
                                .addContainerGap())
                );

                view2.add(view_welcome, "welcome");

                message_box.setBackground(new java.awt.Color(255, 255, 255));
                message_box.setLayout(new java.awt.BorderLayout());

                right_messagesScroll.setBorder(null);
                right_messagesScroll.setOpaque(false);

                right_messages.setBackground(new java.awt.Color(255, 255, 255));
                right_messages.setLayout(new java.awt.GridLayout(4, 1, 0, 5));

                messages_box1.setBackground(new java.awt.Color(188, 7, 46));
                messages_box1.setPreferredSize(new java.awt.Dimension(0, 50));
                messages_box1.addMouseListener(new java.awt.event.MouseAdapter() {
                        public void mouseClicked(java.awt.event.MouseEvent evt) {
                                messages_box1MouseClicked(evt);
                        }
                });

                box1_allName.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
                box1_allName.setText("NAME Firstname");

                box1_date.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
                box1_date.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
                box1_date.setText("YYYY-MM-DD HH:MM:SS");

                box1_scroll_body.setBackground(new java.awt.Color(255, 255, 255));
                box1_scroll_body.setBorder(null);
                box1_scroll_body.setOpaque(false);

                box1_body.setEditable(false);
                box1_body.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
                box1_body.setText("Haec dum oriens diu perferret, caeli reserato tepore Constantius consulatu suo septies et Caesaris ter egressus Arelate Valentiam petit, in Gundomadum et Vadomarium fratres Alamannorum reges arma moturus, quorum crebris excursibus vastabantur confines limitibus terrae Gallorum.  Haec dum oriens diu perferret, caeli reserato tepore Constantius consulatu suo septies et Caesaris ter egressus Arelate Valentiam petit, in Gundomadum et Vadomarium fratres Alamannorum reges arma moturus, quorum crebris excursibus vastabantur confines limitibus terrae Gallorum.  Haec dum oriens diu perferret, caeli reserato tepore Constantius consulatu suo septies et Caesaris ter egressus Arelate Valentiam petit, in Gundomadum et Vadomarium fratres Alamannorum reges arma moturus, quorum crebris excursibus vastabantur confines limitibus terrae Gallorum.");
                box1_body.setToolTipText("");
                box1_body.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
                box1_body.setMargin(new java.awt.Insets(10, 10, 10, 10));
                box1_scroll_body.setViewportView(box1_body);

                javax.swing.GroupLayout messages_box1Layout = new javax.swing.GroupLayout(messages_box1);
                messages_box1.setLayout(messages_box1Layout);
                messages_box1Layout.setHorizontalGroup(
                        messages_box1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(messages_box1Layout.createSequentialGroup()
                                .addContainerGap(29, Short.MAX_VALUE)
                                .addGroup(messages_box1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(box1_scroll_body, javax.swing.GroupLayout.PREFERRED_SIZE, 1233, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(messages_box1Layout.createSequentialGroup()
                                                .addComponent(box1_allName, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(835, 835, 835)
                                                .addComponent(box1_date, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(30, Short.MAX_VALUE))
                );
                messages_box1Layout.setVerticalGroup(
                        messages_box1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(messages_box1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(messages_box1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(box1_allName)
                                        .addComponent(box1_date))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(box1_scroll_body, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(43, 43, 43))
                );

                right_messages.add(messages_box1);

                right_messagesScroll.setViewportView(right_messages);

                message_box.add(right_messagesScroll, java.awt.BorderLayout.CENTER);

                right_newMessage.setBackground(new java.awt.Color(255, 255, 255));
                right_newMessage.setPreferredSize(new java.awt.Dimension(0, 200));

                newMessage_input.setColumns(20);
                newMessage_input.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
                newMessage_input.setLineWrap(true);
                newMessage_input.setRows(5);
                newMessage_input.setText("new message...");
                newMessage_input.setToolTipText("");
                newMessage_input.setBorder(null);
                newMessage_input.setOpaque(false);
                newMessage_input.addFocusListener(new java.awt.event.FocusAdapter() {
                        public void focusGained(java.awt.event.FocusEvent evt) {
                                newMessage_inputFocusGained(evt);
                        }
                });
                newMessage_input.addKeyListener(new java.awt.event.KeyAdapter() {
                        public void keyPressed(java.awt.event.KeyEvent evt) {
                                newMessage_inputKeyPressed(evt);
                        }
                });
                jScrollPane2.setViewportView(newMessage_input);

                log_message.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
                log_message.setForeground(new java.awt.Color(188, 7, 46));
                log_message.setText("0 /1000.");

                newMessage_send.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/send_message.png"))); // NOI18N
                newMessage_send.setToolTipText("send !");
                newMessage_send.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(188, 7, 46)));
                newMessage_send.setContentAreaFilled(false);
                newMessage_send.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                newMessage_sendActionPerformed(evt);
                        }
                });

                javax.swing.GroupLayout right_newMessageLayout = new javax.swing.GroupLayout(right_newMessage);
                right_newMessage.setLayout(right_newMessageLayout);
                right_newMessageLayout.setHorizontalGroup(
                        right_newMessageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(right_newMessageLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 1174, Short.MAX_VALUE)
                                .addGap(18, 18, 18)
                                .addComponent(newMessage_send, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
                        .addGroup(right_newMessageLayout.createSequentialGroup()
                                .addGap(23, 23, 23)
                                .addComponent(log_message, javax.swing.GroupLayout.PREFERRED_SIZE, 755, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                );
                right_newMessageLayout.setVerticalGroup(
                        right_newMessageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(right_newMessageLayout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(log_message)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(right_newMessageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(newMessage_send, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE))
                                .addContainerGap())
                );

                message_box.add(right_newMessage, java.awt.BorderLayout.PAGE_END);

                view2.add(message_box, "message");

                view_group.setBackground(new java.awt.Color(255, 255, 255));

                group_own.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
                group_own.setModel(new javax.swing.table.DefaultTableModel(
                        new Object [][] {
                                {null},
                                {null},
                                {null},
                                {null},
                                {null},
                                {null},
                                {null},
                                {null},
                                {null},
                                {null}
                        },
                        new String [] {
                                "own group"
                        }
                ) {
                        boolean[] canEdit = new boolean [] {
                                false
                        };

                        public boolean isCellEditable(int rowIndex, int columnIndex) {
                                return canEdit [columnIndex];
                        }
                });
                group_sown.setViewportView(group_own);

                group_swap.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
                group_swap.setForeground(new java.awt.Color(188, 7, 46));
                group_swap.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/group-swap-icon.png"))); // NOI18N
                group_swap.setText("swap");
                group_swap.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(188, 7, 46)));
                group_swap.setOpaque(false);
                group_swap.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                group_swapActionPerformed(evt);
                        }
                });

                group_other.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
                group_other.setModel(new javax.swing.table.DefaultTableModel(
                        new Object [][] {
                                {null},
                                {null},
                                {null},
                                {null},
                                {null},
                                {null},
                                {null},
                                {null},
                                {null},
                                {null},
                                {null},
                                {null},
                                {null},
                                {null},
                                {null},
                                {null},
                                {null},
                                {null},
                                {null},
                                {null},
                                {null},
                                {null}
                        },
                        new String [] {
                                "other group"
                        }
                ));
                group_sother.setViewportView(group_other);

                javax.swing.GroupLayout view_groupLayout = new javax.swing.GroupLayout(view_group);
                view_group.setLayout(view_groupLayout);
                view_groupLayout.setHorizontalGroup(
                        view_groupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(view_groupLayout.createSequentialGroup()
                                .addContainerGap(262, Short.MAX_VALUE)
                                .addComponent(group_sown, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(group_swap, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(group_sother, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(416, Short.MAX_VALUE))
                );
                view_groupLayout.setVerticalGroup(
                        view_groupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(view_groupLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(view_groupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(group_sown)
                                        .addComponent(group_sother)
                                        .addComponent(group_swap, javax.swing.GroupLayout.PREFERRED_SIZE, 422, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(396, Short.MAX_VALUE))
                );

                view2.add(view_group, "group");

                view_newTicket.setBackground(new java.awt.Color(255, 255, 255));

                jPanel2.setBackground(new java.awt.Color(255, 255, 255));

                newTicket_send.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
                newTicket_send.setForeground(new java.awt.Color(188, 7, 46));
                newTicket_send.setText("send");
                newTicket_send.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(188, 7, 46)));
                newTicket_send.setContentAreaFilled(false);
                newTicket_send.setOpaque(false);
                newTicket_send.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                newTicket_sendActionPerformed(evt);
                        }
                });

                jScrollPane4.setBorder(null);

                new_ticketBody.setBackground(new java.awt.Color(255, 255, 255));
                new_ticketBody.setColumns(20);
                new_ticketBody.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
                new_ticketBody.setForeground(new java.awt.Color(51, 51, 51));
                new_ticketBody.setLineWrap(true);
                new_ticketBody.setRows(5);
                new_ticketBody.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(188, 7, 46)));
                new_ticketBody.setMargin(new java.awt.Insets(10, 10, 10, 10));
                jScrollPane4.setViewportView(new_ticketBody);

                jLabel13.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
                jLabel13.setForeground(new java.awt.Color(188, 7, 46));
                jLabel13.setText("message");

                jLabel14.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
                jLabel14.setForeground(new java.awt.Color(188, 7, 46));
                jLabel14.setText("group");

                newTicket_group.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
                newTicket_group.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

                newTicket_title.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N

                jLabel11.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
                jLabel11.setForeground(new java.awt.Color(188, 7, 46));
                jLabel11.setText("title");

                javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
                jPanel2.setLayout(jPanel2Layout);
                jPanel2Layout.setHorizontalGroup(
                        jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(newTicket_send, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                                        .addComponent(jLabel11)
                                                                        .addComponent(jLabel13))
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                                                .addComponent(newTicket_title, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addGap(180, 180, 180))
                                                                        .addComponent(jScrollPane4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 433, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addGap(32, 32, 32)
                                                .addComponent(jLabel14)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(newTicket_group, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(29, Short.MAX_VALUE))
                );
                jPanel2Layout.setVerticalGroup(
                        jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(newTicket_title, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel11))
                                .addGap(29, 29, 29)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(newTicket_group, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel14))
                                .addGap(32, 32, 32)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addComponent(jLabel13)
                                                .addGap(168, 168, 168)
                                                .addComponent(newTicket_send, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(26, Short.MAX_VALUE))
                );

                javax.swing.GroupLayout view_newTicketLayout = new javax.swing.GroupLayout(view_newTicket);
                view_newTicket.setLayout(view_newTicketLayout);
                view_newTicketLayout.setHorizontalGroup(
                        view_newTicketLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(view_newTicketLayout.createSequentialGroup()
                                .addGap(302, 302, 302)
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(447, Short.MAX_VALUE))
                );
                view_newTicketLayout.setVerticalGroup(
                        view_newTicketLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(view_newTicketLayout.createSequentialGroup()
                                .addGap(119, 119, 119)
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(328, Short.MAX_VALUE))
                );

                view2.add(view_newTicket, "newTicket");

                view_about.setBackground(new java.awt.Color(255, 255, 255));

                universityRequest.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
                universityRequest.setForeground(new java.awt.Color(188, 7, 46));
                universityRequest.setText("UniversityRequest");
                universityRequest.setMaximumSize(new java.awt.Dimension(319, 47));
                universityRequest.setMinimumSize(new java.awt.Dimension(319, 47));
                universityRequest.setPreferredSize(new java.awt.Dimension(319, 47));

                version.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
                version.setForeground(new java.awt.Color(188, 7, 46));
                version.setText("version 1.0");

                staff_dev.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
                staff_dev.setForeground(new java.awt.Color(188, 7, 46));
                staff_dev.setText("Gauthier BOUYJOU");

                staff_design.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
                staff_design.setForeground(new java.awt.Color(188, 7, 46));
                staff_design.setText("Mohammed Amine BENZERGA");

                staff_network.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
                staff_network.setForeground(new java.awt.Color(188, 7, 46));
                staff_network.setText("Jonathan LAO-KAN");
                staff_network.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
                staff_network.setPreferredSize(new java.awt.Dimension(162, 19));

                staff_dev1.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
                staff_dev1.setForeground(new java.awt.Color(188, 7, 46));
                staff_dev1.setText("JAVA Development");

                staff_design1.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
                staff_design1.setForeground(new java.awt.Color(188, 7, 46));
                staff_design1.setText("DESIGN Interface");

                staff_network1.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
                staff_network1.setForeground(new java.awt.Color(188, 7, 46));
                staff_network1.setText("NETWORK Management");
                staff_network1.setPreferredSize(new java.awt.Dimension(186, 19));

                staff_dev2.setForeground(new java.awt.Color(188, 7, 46));
                staff_dev2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/staff_dev.png"))); // NOI18N

                staff_design2.setForeground(new java.awt.Color(188, 7, 46));
                staff_design2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/staff_design.png"))); // NOI18N

                staff_network3.setForeground(new java.awt.Color(188, 7, 46));
                staff_network3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/staff_network.png"))); // NOI18N

                icon_logo_server.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
                icon_logo_server.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/team_opacity5.png"))); // NOI18N

                about_contactUs.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
                about_contactUs.setForeground(new java.awt.Color(188, 7, 46));
                about_contactUs.setText("Contact us !");

                about_email.setForeground(new java.awt.Color(188, 7, 46));
                about_email.setText("team@university-request.fr");

                javax.swing.GroupLayout view_aboutLayout = new javax.swing.GroupLayout(view_about);
                view_about.setLayout(view_aboutLayout);
                view_aboutLayout.setHorizontalGroup(
                        view_aboutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(view_aboutLayout.createSequentialGroup()
                                .addGap(311, 311, 311)
                                .addComponent(staff_dev2)
                                .addGap(25, 25, 25)
                                .addGroup(view_aboutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(view_aboutLayout.createSequentialGroup()
                                                .addGap(180, 180, 180)
                                                .addComponent(version))
                                        .addGroup(view_aboutLayout.createSequentialGroup()
                                                .addGap(190, 190, 190)
                                                .addComponent(staff_design2))
                                        .addGroup(view_aboutLayout.createSequentialGroup()
                                                .addGap(70, 70, 70)
                                                .addComponent(universityRequest, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(icon_logo_server, javax.swing.GroupLayout.PREFERRED_SIZE, 430, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(40, 40, 40)
                                .addComponent(staff_network3))
                        .addGroup(view_aboutLayout.createSequentialGroup()
                                .addGap(609, 609, 609)
                                .addComponent(about_contactUs, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(view_aboutLayout.createSequentialGroup()
                                .addGap(570, 570, 570)
                                .addComponent(about_email, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(view_aboutLayout.createSequentialGroup()
                                .addGap(291, 291, 291)
                                .addGroup(view_aboutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(staff_dev1, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(staff_dev, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(view_aboutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(view_aboutLayout.createSequentialGroup()
                                                .addGap(136, 136, 136)
                                                .addComponent(staff_design1, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(103, 103, 103))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, view_aboutLayout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(staff_design, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(71, 71, 71)))
                                .addGroup(view_aboutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(staff_network1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(view_aboutLayout.createSequentialGroup()
                                                .addGap(13, 13, 13)
                                                .addComponent(staff_network, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                );
                view_aboutLayout.setVerticalGroup(
                        view_aboutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(view_aboutLayout.createSequentialGroup()
                                .addGap(80, 80, 80)
                                .addGroup(view_aboutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(view_aboutLayout.createSequentialGroup()
                                                .addGap(360, 360, 360)
                                                .addComponent(staff_dev2, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(view_aboutLayout.createSequentialGroup()
                                                .addGap(280, 280, 280)
                                                .addComponent(version, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(view_aboutLayout.createSequentialGroup()
                                                .addGap(360, 360, 360)
                                                .addComponent(staff_design2, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(view_aboutLayout.createSequentialGroup()
                                                .addGap(230, 230, 230)
                                                .addComponent(universityRequest, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(icon_logo_server, javax.swing.GroupLayout.PREFERRED_SIZE, 420, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(view_aboutLayout.createSequentialGroup()
                                                .addGap(360, 360, 360)
                                                .addComponent(staff_network3, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(view_aboutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(view_aboutLayout.createSequentialGroup()
                                                .addGap(10, 10, 10)
                                                .addGroup(view_aboutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(staff_dev)
                                                        .addComponent(staff_design)))
                                        .addGroup(view_aboutLayout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(staff_network, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(9, 9, 9)
                                .addGroup(view_aboutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(staff_dev1)
                                        .addComponent(staff_design1)
                                        .addComponent(staff_network1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(101, 101, 101)
                                .addComponent(about_contactUs)
                                .addGap(5, 5, 5)
                                .addComponent(about_email))
                );

                view2.add(view_about, "about");

                home_right.add(view2, java.awt.BorderLayout.CENTER);
                cview2 =(CardLayout)view2.getLayout();

                view_home.add(home_right, java.awt.BorderLayout.CENTER);

                view.add(view_home, "home");

                getContentPane().add(view, "card8");
                cview =(CardLayout)view.getLayout();

                pack();
        }// </editor-fold>//GEN-END:initComponents

        private void passwdInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passwdInputActionPerformed
		// TODO add your handling code here:
        }//GEN-LAST:event_passwdInputActionPerformed

        private void identification_connectionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_identification_connectionActionPerformed
		show3("loading");
//		identification_loadingInterface.setVisible(true);
		String login = identification_login.getText();
		char[] str = passwdInput.getPassword();
		String passwd = "";
		for (char c : str) {
			passwd += c;
		}

		client.sendRequest(ClientRequest.IDENTIFICATION, login, passwd);
        }//GEN-LAST:event_identification_connectionActionPerformed

        private void newUser_joinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newUser_joinActionPerformed
		String name = newUser_name.getText();
		String firstName = newUser_firstName.getText();
		String email = newUser_email.getText();
		String login = newUser_login.getText();
		char[] str = newUser_passwrd.getPassword();
		String passwd = "";
		for (char c : str) {
			passwd += c;
		}
		String status = newUser_status.getSelectedItem().toString();

		//client.sendRequest(ClientRequest.NEW_USER, login, passwd, firstName, name, status);
		if (name.isEmpty() || firstName.isEmpty() || email.isEmpty() || login.isEmpty() || passwd.isEmpty() || name.equals("name") || firstName.equals("firstname") || email.equals("email") || login.equals("login") || passwd.equals("password")) {
			newUser_errorFields.setVisible(true);
			new Thread() {
				@Override
				public void run() {
					try {
						Thread.sleep(3000);
					} catch (InterruptedException ex) {
						Logger.getLogger(InterfaceClient.class.getName()).log(Level.SEVERE, null, ex);
					}
					newUser_errorFields.setVisible(false);
				}
			}.start();
			return; // c'est mal de faire ça ? mdrrrrr
		}


		// Email verification 
                String email_regex = "^[\\w-\\+]+(\\.[\\w]+)*@[\\w-]+(\\.[\\w]+)*(\\.[a-z]{2,})$";
		Pattern p = Pattern.compile(email_regex, Pattern.CASE_INSENSITIVE);
		Matcher m = p.matcher(email);

		if (!m.matches()) {
			newUser_errorDomain.setVisible(true);
			new Thread() {
				@Override
				public void run() {
					try {
						Thread.sleep(3000);
					} catch (InterruptedException ex) {
						Logger.getLogger(InterfaceClient.class.getName()).log(Level.SEVERE, null, ex);
					}
					newUser_errorDomain.setVisible(false);
				}
			}.start();
			System.out.println("client.InterfaceClient.newUser_joinActionPerformed()");
			return; // c'est toujours mal de faire ça ?
		}

		// Domain verification
		String[] email_split = email.split("@");
		String domain = email_split[1];
		System.out.println(domain);

		if (!domain.equals("univ-tlse3.fr") && !domain.equals("irit.fr") && !domain.equals("enima.fr")) {
			newUser_errorDomain.setVisible(true);
			new Thread() {
				@Override
				public void run() {
					try {
						Thread.sleep(3000);
					} catch (InterruptedException ex) {
						Logger.getLogger(InterfaceClient.class.getName()).log(Level.SEVERE, null, ex);
					}
					newUser_errorDomain.setVisible(false);
				}
			}.start();
			System.out.println("client.InterfaceClient.newUser_joinActionPerformed()");
			return; // vraiment ?
		}

		// GET url
		String url = "https://join.university-request.fr/email/?email=" + email + "&login=" + login + "&pswd=" + passwd + "&fstnm=" + firstName + "&nm=" + name + "&status=" + status;

		String retour = "";

		try {
			retour = get(url);
		} catch (IOException ex) {
			Logger.getLogger(InterfaceClient.class.getName()).log(Level.SEVERE, null, ex);
		}

		// Vérification result
		switch (retour) {
			case "ok": // Email sent successfully
				newUser_okEmail.setVisible(true);
				new Thread() {
					@Override
					public void run() {
						try {
							Thread.sleep(3000);
						} catch (InterruptedException ex) {
							Logger.getLogger(InterfaceClient.class.getName()).log(Level.SEVERE, null, ex);
						}
						view_newUser.setVisible(false);
						view_identification.setVisible(true);
					}
				}.start();
				break;

			default: // Error
				newUser_error.setVisible(true);
				new Thread() {
					@Override
					public void run() {
						try {
							Thread.sleep(5000);
						} catch (InterruptedException ex) {
							Logger.getLogger(InterfaceClient.class.getName()).log(Level.SEVERE, null, ex);
						}
						newUser_error.setVisible(false);
					}
				}.start();
				break;
		}

        }//GEN-LAST:event_newUser_joinActionPerformed

        private void home_groupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_home_groupActionPerformed
		show2("group");
                home_ticket.setText("");
                home_newTicket.setFont(new java.awt.Font("Dialog", 0, 14));
                home_group.setFont(new java.awt.Font("Dialog", 1, 14));

//		client.sendRequest(ClientRequest.ALL_GROUP, identification_login.getText());
		client.sendRequest(ClientRequest.ALL_GROUP);
        }//GEN-LAST:event_home_groupActionPerformed

        private void group_swapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_group_swapActionPerformed

		int row = group_own.getSelectedRow();
		int column = group_own.getSelectedColumn();
		System.out.println(row + "" + column);
		if (row >= 0 && column >= 0) {
			String ownGroupSelected = (String) group_own.getValueAt(row, column);
			System.out.println("ownGroup " + ownGroupSelected);

			client.sendRequest(ClientRequest.DEL_GROUP, ownGroupSelected);
		} else {
			row = group_other.getSelectedRow();
			column = group_other.getSelectedColumn();
			System.out.println(row + "" + column);

			if (row >= 0 && column >= 0) {
				String otherGroupSelected = (String) group_other.getValueAt(row, column);
				System.out.println("otherGroup " + otherGroupSelected);

				client.sendRequest(ClientRequest.ADD_GROUP, otherGroupSelected);
			}
		}

        }//GEN-LAST:event_group_swapActionPerformed

        private void home_leaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_home_leaveActionPerformed
		show3("empty");
		show("identification");
		client.sendRequest(ClientRequest.LOGOUT, (Object)null);
        }//GEN-LAST:event_home_leaveActionPerformed

        private void newMessage_sendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newMessage_sendActionPerformed
		newMessage_input_sendMessage();
        }//GEN-LAST:event_newMessage_sendActionPerformed
        
        
        private void newMessage_inputKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_newMessage_inputKeyPressed
		// send message with tab input
		
                if(evt.getKeyCode()==KeyEvent.VK_ENTER && evt.getModifiers()==KeyEvent.SHIFT_MASK){
                        System.out.println("retour a la ligne demandé");
                        newMessage_input.append("\n");
                }
                
                
                
                if (evt.getKeyCode() == KeyEvent.VK_ENTER && evt.getModifiers()!=KeyEvent.SHIFT_MASK) {
			newMessage_input_sendMessage();
		}
                //int nbChar=newMessage_input.getText().length();
                log_message.setText(newMessage_input.getText().length()+" /1000.");
                
                
        }//GEN-LAST:event_newMessage_inputKeyPressed

        private void messages_box1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_messages_box1MouseClicked
		System.out.println("fuck");
        }//GEN-LAST:event_messages_box1MouseClicked

        private void home_newTicketActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_home_newTicketActionPerformed
		show2("newTicket");
                home_ticket.setText("");
                home_newTicket.setFont(new java.awt.Font("Dialog", 1, 14));
                home_group.setFont(new java.awt.Font("Dialog", 0, 14));


		client.sendRequest(ClientRequest.ALL_GROUP_FOR_TICKET);

        }//GEN-LAST:event_home_newTicketActionPerformed

        private void newTicket_sendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newTicket_sendActionPerformed
		String title = newTicket_title.getText();
		String author = actualUser;
		String group = newTicket_group.getSelectedItem().toString();
		String bodyMessage = new_ticketBody.getText();
		client.sendRequest(ClientRequest.NEW_TICKET, title, author, group, bodyMessage);
		show("home");
//		tree.setSelectionRow(indexOfAlreadyClicked);
        }//GEN-LAST:event_newTicket_sendActionPerformed

    private void identification_loginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_identification_loginActionPerformed
	    // TODO add your handling code here:
    }//GEN-LAST:event_identification_loginActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
	    serverConnect();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void not_registeredMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_not_registeredMouseClicked
	    newUser_clic_name = true;
	    newUser_clic_firstname = true;
	    newUser_clic_email = true;
	    newUser_clic_login = true;
	    newUser_clic_passwd = true;

	    newUser_name.setText("name");
	    newUser_firstName.setText("firstname");
	    newUser_email.setText("email");
	    newUser_login.setText("login");
	    newUser_passwrd.setText("password");

	    newUser_join.requestFocus();

	    view_newUser.setVisible(true);
	    view_identification.setVisible(false);
    }//GEN-LAST:event_not_registeredMouseClicked

    private void passwdInputFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_passwdInputFocusGained
	    if (identification_clic_passwd) {
		    passwdInput.setText("");
		    identification_clic_passwd = false;
	    }
    }//GEN-LAST:event_passwdInputFocusGained

    private void identification_loginFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_identification_loginFocusGained
	    if (identification_clic_login) {
		    identification_login.setText("");
		    identification_clic_login = false;
	    }
    }//GEN-LAST:event_identification_loginFocusGained

    private void backMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backMouseClicked
	    identification_clic_login = true;
	    identification_clic_passwd = true;
	    view_identification.setVisible(true);
	    view_newUser.setVisible(false);
    }//GEN-LAST:event_backMouseClicked

    private void newUser_logMessageMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_newUser_logMessageMouseClicked
	    // TODO add your handling code here:
    }//GEN-LAST:event_newUser_logMessageMouseClicked

    private void newUser_logMessage1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_newUser_logMessage1MouseClicked
	    // TODO add your handling code here:
    }//GEN-LAST:event_newUser_logMessage1MouseClicked

    private void not_registered1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_not_registered1MouseClicked
	    // TODO add your handling code here:
    }//GEN-LAST:event_not_registered1MouseClicked

    private void newUser_nameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_newUser_nameFocusGained
	    if (newUser_clic_name) {
		    newUser_name.setText("");
		    newUser_clic_name = false;
	    }
    }//GEN-LAST:event_newUser_nameFocusGained

    private void newUser_firstNameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_newUser_firstNameFocusGained
	    if (newUser_clic_firstname) {
		    newUser_firstName.setText("");
		    newUser_clic_firstname = false;
	    }
    }//GEN-LAST:event_newUser_firstNameFocusGained

    private void newUser_emailFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_newUser_emailFocusGained
	    if (newUser_clic_email) {
		    newUser_email.setText("");
		    newUser_clic_email = false;
	    }
    }//GEN-LAST:event_newUser_emailFocusGained

    private void newUser_loginFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_newUser_loginFocusGained
	    if (newUser_clic_login) {
		    newUser_login.setText("");
		    newUser_clic_login = false;
	    }
    }//GEN-LAST:event_newUser_loginFocusGained

    private void newUser_passwrdFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_newUser_passwrdFocusGained
	    if (newUser_clic_passwd) {
		    newUser_passwrd.setText("");
		    newUser_clic_passwd = false;
	    }
    }//GEN-LAST:event_newUser_passwrdFocusGained

    private void newUser_logMessage2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_newUser_logMessage2MouseClicked
	    // TODO add your handling code here:
    }//GEN-LAST:event_newUser_logMessage2MouseClicked

    private void newUser_logMessage3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_newUser_logMessage3MouseClicked
	    // TODO add your handling code here:
    }//GEN-LAST:event_newUser_logMessage3MouseClicked

        private void serverNotFound_localhostActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_serverNotFound_localhostActionPerformed
//		serverNotFound_ip.setText("127.0.0.1");
		serverNotFound_ip.setText("77.141.121.226");
		serverNotFound_localhost.setVisible(false);
        }//GEN-LAST:event_serverNotFound_localhostActionPerformed

        private void aboutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_aboutMouseClicked
                show2("about");
                home_newTicket.setFont(new java.awt.Font("Dialog", 0, 14));
                home_group.setFont(new java.awt.Font("Dialog", 0, 14));
        }//GEN-LAST:event_aboutMouseClicked

        private void not_registered2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_not_registered2MouseClicked
                // TODO add your handling code here:
        }//GEN-LAST:event_not_registered2MouseClicked

        private void newMessage_inputFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_newMessage_inputFocusGained
                if(first_clic_newMessage_input){
                        newMessage_input.setText("");
                        first_clic_newMessage_input=false;
                        
                }
        }//GEN-LAST:event_newMessage_inputFocusGained

	public void newTicketPrint(String[] ls) {
		show("newTicket");
		newTicket_group.setModel(new javax.swing.DefaultComboBoxModel<>(ls));
	}

	public void newMessage_input_sendMessage() {

		
		String body = newMessage_input.getText();
                if(body.length()<1000 && body.length()!=0){
                        int id = -1;
                        Timestamp create = new Timestamp(System.currentTimeMillis());
                        String author = identification_login.getText();
                        //String ticket =(String)tree.getLastSelectedPathComponent().toString();
                        String ticket = actualTicket();
                        String group = "";
                        String firstname = "";
                        String name = "";

                        Message m = new Message(id, body, create, author, firstname, name, ticket, group, StatusMessage.SERVER_NOT_RECEIVE, null);

                        client.addMessage(m);
                        buildMessagesPane(ticket);
                        client.delMessage(m);

                        new Thread() {
                                @Override
                                public void run() {
                                        try {
                                                Thread.sleep(1000);
                                        } catch (InterruptedException ex) {
                                                Logger.getLogger(InterfaceClient.class.getName()).log(Level.SEVERE, null, ex);
                                        }
                                        client.sendRequest(ClientRequest.NEW_MESSAGE, m);
                                        newMessage_input.setText("");
                                }
                        }.start();
                }
                else{
                        if(body.length()==0){
                                log_message.setText(newMessage_input.getText().length()+" /1000. (your message is empty)");
                        }
                        else{
                                log_message.setText(newMessage_input.getText().length()+" /1000. (your message is too long : 1000 characters max.)");
                        }
                }
	}

	/**
	 * @param args the command line arguments
	 */
	public static void main(String args[]) {
		/* Set the Nimbus look and feel */
		//<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
		/* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
		 */
		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException ex) {
			java.util.logging.Logger.getLogger(InterfaceClient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(InterfaceClient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(InterfaceClient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(InterfaceClient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		}
		//</editor-fold>
		//</editor-fold>

		/* Create and display the form */
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new InterfaceClient().setVisible(true);
			}
		});

//		InterfaceClient ihm = new InterfaceClient();
	}

        // Variables declaration - do not modify//GEN-BEGIN:variables
        private javax.swing.JPanel _identification;
        private javax.swing.JPanel _retry;
        private javax.swing.JPanel _serverNotFound;
        private javax.swing.JLabel about;
        private javax.swing.JLabel about_contactUs;
        private javax.swing.JLabel about_email;
        private javax.swing.JLabel back;
        private javax.swing.JPanel body_ServerNotFound;
        private javax.swing.JPanel body_connexion;
        private javax.swing.JLabel box1_allName;
        private javax.swing.JTextPane box1_body;
        private javax.swing.JLabel box1_date;
        private javax.swing.JScrollPane box1_scroll_body;
        private javax.swing.JLabel connexion_logoOpacity5;
        private javax.swing.JPanel footer_empty;
        private javax.swing.JPanel footer_incorrect;
        private javax.swing.JPanel footer_left;
        private javax.swing.JPanel footer_loading;
        private javax.swing.JPanel footer_newUser;
        private javax.swing.JTable group_other;
        private javax.swing.JTable group_own;
        private javax.swing.JScrollPane group_sother;
        private javax.swing.JScrollPane group_sown;
        private javax.swing.JButton group_swap;
        private javax.swing.JPanel header_home;
        private javax.swing.JLabel help_email;
        private javax.swing.JButton home_group;
        private javax.swing.JButton home_leave;
        private javax.swing.JPanel home_menu;
        private javax.swing.JButton home_newTicket;
        private javax.swing.JPanel home_right;
        private javax.swing.JLabel home_ticket;
        private javax.swing.JScrollPane home_tickets;
        private javax.swing.JLabel home_userName;
        private javax.swing.JLabel icon_logo_opacity10;
        private javax.swing.JLabel icon_logo_server;
        private javax.swing.JLabel icon_user;
        private javax.swing.JLabel icon_user1;
        private javax.swing.JButton identification_connection;
        private javax.swing.JPanel identification_errorLogin;
        private javax.swing.JPanel identification_footer;
        private javax.swing.JPanel identification_loadingInterface;
        private javax.swing.JTextField identification_login;
        private javax.swing.JLabel identification_logo;
        private javax.swing.JLabel identification_logo1;
        private javax.swing.JButton jButton1;
        private javax.swing.JLabel jLabel1;
        private javax.swing.JLabel jLabel11;
        private javax.swing.JLabel jLabel13;
        private javax.swing.JLabel jLabel14;
        private javax.swing.JLabel jLabel16;
        private javax.swing.JLabel jLabel17;
        private javax.swing.JLabel jLabel2;
        private javax.swing.JLabel jLabel3;
        private javax.swing.JPanel jPanel1;
        private javax.swing.JPanel jPanel2;
        private javax.swing.JScrollPane jScrollPane2;
        private javax.swing.JScrollPane jScrollPane4;
        private javax.swing.JSeparator jSeparator1;
        private javax.swing.JSeparator jSeparator2;
        private javax.swing.JSeparator jSeparator3;
        private javax.swing.JSeparator jSeparator4;
        private javax.swing.JLabel loading;
        private javax.swing.JLabel log_message;
        private javax.swing.JLabel logo_client;
        private javax.swing.JLabel logo_opacity6;
        private javax.swing.JPanel message_box;
        private javax.swing.JPanel messages_box1;
        private javax.swing.JLabel need_help;
        private javax.swing.JTextArea newMessage_input;
        private javax.swing.JButton newMessage_send;
        private javax.swing.JComboBox<String> newTicket_group;
        private javax.swing.JButton newTicket_send;
        private javax.swing.JTextField newTicket_title;
        private javax.swing.JTextField newUser_email;
        private javax.swing.JPanel newUser_error;
        private javax.swing.JPanel newUser_errorDomain;
        private javax.swing.JPanel newUser_errorFields;
        private javax.swing.JTextField newUser_firstName;
        private javax.swing.JLabel newUser_iconEmail;
        private javax.swing.JLabel newUser_iconFirstname;
        private javax.swing.JLabel newUser_iconLogin;
        private javax.swing.JLabel newUser_iconName;
        private javax.swing.JLabel newUser_iconPasswd;
        private javax.swing.JLabel newUser_iconStatus;
        private javax.swing.JButton newUser_join;
        private javax.swing.JLabel newUser_logIcon;
        private javax.swing.JLabel newUser_logIcon1;
        private javax.swing.JLabel newUser_logIcon2;
        private javax.swing.JLabel newUser_logIcon3;
        private javax.swing.JLabel newUser_logMessage;
        private javax.swing.JLabel newUser_logMessage1;
        private javax.swing.JLabel newUser_logMessage2;
        private javax.swing.JLabel newUser_logMessage3;
        private javax.swing.JTextField newUser_login;
        private javax.swing.JLabel newUser_logo;
        private javax.swing.JTextField newUser_name;
        private javax.swing.JPanel newUser_okEmail;
        private javax.swing.JPasswordField newUser_passwrd;
        private javax.swing.JPanel newUser_print;
        private javax.swing.JSeparator newUser_separatorFirstname;
        private javax.swing.JSeparator newUser_separatorName;
        private javax.swing.JSeparator newUser_separatorPasswd;
        private javax.swing.JSeparator newUser_sepearatorEmail;
        private javax.swing.JSeparator newUser_seperatorLogin;
        private javax.swing.JComboBox<String> newUser_status;
        private javax.swing.JTextArea new_ticketBody;
        private javax.swing.JLabel not_registered;
        private javax.swing.JLabel not_registered1;
        private javax.swing.JLabel not_registered2;
        private javax.swing.JPanel panel_consoleServerNotFound;
        private javax.swing.JPasswordField passwdInput;
        private javax.swing.JPanel right_messages;
        private javax.swing.JScrollPane right_messagesScroll;
        private javax.swing.JPanel right_newMessage;
        private javax.swing.JTextPane serverNotFound_console;
        private javax.swing.JLabel serverNotFound_icon;
        private javax.swing.JTextField serverNotFound_ip;
        private javax.swing.JButton serverNotFound_localhost;
        private javax.swing.JTextField serverNotFound_port;
        private javax.swing.JLabel staff_design;
        private javax.swing.JLabel staff_design1;
        private javax.swing.JLabel staff_design2;
        private javax.swing.JLabel staff_dev;
        private javax.swing.JLabel staff_dev1;
        private javax.swing.JLabel staff_dev2;
        private javax.swing.JLabel staff_network;
        private javax.swing.JLabel staff_network1;
        private javax.swing.JLabel staff_network3;
        private javax.swing.JLabel to_interface_admin;
        private javax.swing.JTree tree;
        private javax.swing.JLabel universityRequest;
        private javax.swing.JLabel version;
        private javax.swing.JPanel view;
        private javax.swing.JPanel view2;
        private javax.swing.JPanel view_about;
        private javax.swing.JPanel view_group;
        private javax.swing.JPanel view_home;
        private javax.swing.JPanel view_identification;
        private javax.swing.JPanel view_loading;
        private javax.swing.JPanel view_newTicket;
        private javax.swing.JPanel view_newUser;
        private javax.swing.JPanel view_serverNotFound;
        private javax.swing.JPanel view_welcome;
        private javax.swing.JLabel welcome;
        private javax.swing.JPanel zone_inscription;
        private javax.swing.JPanel zone_newUser;
        // End of variables declaration//GEN-END:variables

	// getters
	public JPanel getHome() {
		return view_home;
	}

	public JLabel getHome_userName() {
		return home_userName;
	}

	// ne fonctionne pas avec jpanel, à toi de voir Gauthier
	//public JPanel getHome_wrong() {
	public JPanel getIdentification() {
		return view_identification;
	}

	void majTree() {
		InterfaceClient ihm =this;
		// already click
		String ticketAlreadyClicked = actualTicket();
		int indexOfAlreadyClicked = 0;

		DefaultMutableTreeNode root = new DefaultMutableTreeNode("posts");
		int cpt = 1;
		for (String g : client.getGroups()) {
			DefaultMutableTreeNode group = new DefaultMutableTreeNode("" + g + " (" + client.nbNotReadMessageInGroup(g, actualUser) + ")");
			for (String t : client.getTicket(g)) {
				DefaultMutableTreeNode ticket = new DefaultMutableTreeNode(t + " (" + client.nbNotReadMessageOfTicket(t, actualUser) + ")");
				group.add(ticket);

				if (t.equals(ticketAlreadyClicked)) {
					indexOfAlreadyClicked = cpt;
				}

				cpt++;
			}
			root.add(group);
			cpt++;
		}

		tree = new JTree(root);
		tree.setRootVisible(false);
		tree.setBackground(new Color(188,7,46));
                tree.setForeground(new Color(255, 255, 255));


		
		tree.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent me) {
				ihm.show2("message");
                                home_newTicket.setFont(new java.awt.Font("Dialog", 0, 14));
                                home_group.setFont(new java.awt.Font("Dialog", 0, 14));
//				TreePath tp =tree.getPathForLocation(me.getX(), me.getY());
//				System.out.println(tp);
//				String ticket =(String)tree.getLastSelectedPathComponent().toString();
				String ticket = actualTicket();
				if (client.getAllTickets().contains(ticket)) {
					home_ticket.setText(ticket.toUpperCase());

					List<String> ls = client.getAllTickets();
					if (ls.contains(ticket)) {
						System.out.println(ticket);
						readMessagesOfTicket(ticket);
					}

//				right_messages =new JPanel();
//				right_messages.setLayout(null);
					buildMessagesPane(ticket);
				}
			}

		});
		expandAll(tree);
		tree.setCellRenderer(new DefaultTreeCellRenderer() {
			@Override
			public Component getTreeCellRendererComponent(JTree tree, Object value, boolean sel, boolean expanded, boolean leaf, int row, boolean hasFocus) {
				String text = value.toString();
				int len = text.length();
				StringBuffer html;
				if (text.substring(len - 3, len).equals("(0)")) {
//					html = new StringBuffer(text);
					html = new StringBuffer("<html><font color=\"white\">" + text + "</font></html>");
				} else {
//					html = new StringBuffer("<html><img src=\"picture/blue.png\" /> <font color=\"white\"><b>" + text + "</b></font></html>");
					html = new StringBuffer("<html><font color=\"white\"><b>" + text + "</b></font></html>");
				}
//				try {
//					URL picture =new URL("picture/blue.png");
//				} catch (MalformedURLException ex) {
//					Logger.getLogger(InterfaceClient.class.getName()).log(Level.SEVERE, null, ex);
//				}
//				this.setIcon(new URL("picture/blue.png"));
				return super.getTreeCellRendererComponent(tree, html.toString(), sel, expanded, leaf, row, hasFocus); //To change body of generated methods, choose Tools | Templates.
			}

//			public Component getTreeCellRendererComponent(JTree tree, Object value, boolean selected, boolean expanded,
//				boolean leaf, int row, boolean hasFocus) {
//				Object o = ((DefaultMutableTreeNode) value).getUserObject();
//				if (o instanceof Country) {
//					Country country = (Country) o;
//					URL imageUrl = getClass().getResource(country.getFlagIcon());
//					if (imageUrl != null) {
//						label.setIcon(new ImageIcon(imageUrl));
//					}
//					label.setText(country.getName());
//				} else {
//					label.setIcon(null);
//					label.setText("" + value);
//				}
//				return label;
//			}

		});

		DefaultTreeCellRenderer renderer = (DefaultTreeCellRenderer) tree.getCellRenderer();
//		ImageIcon closedIcon = new ImageIcon("picture/closed.png");
//		ImageIcon openIcon = new ImageIcon("picture/open.png");
//		ImageIcon leafIcon = new ImageIcon("picture/leaf.png");
//		ImageIcon closedIcon = new ImageIcon("picture/blue.png");
//		ImageIcon openIcon = new ImageIcon("picture/blue.png");
		ImageIcon leafIcon = new ImageIcon("picture/blue.png");
//		ImageIcon leafIcon =  createImageIcon("picture/blue.png");
//		renderer.setClosedIcon(closedIcon);
//		renderer.setOpenIcon(openIcon);

		right_messages.removeAll();
		right_messagesScroll.setViewportView(right_messages);
		right_newMessage.setVisible(false);

		home_tickets.setViewportView(tree);

		if (ticketAlreadyClicked != "") {
			buildMessagesPane(ticketAlreadyClicked);

			List<String> ls = client.getAllTickets();
			if (ls.contains(ticketAlreadyClicked)) {
				System.out.println(ticketAlreadyClicked);
				readMessagesOfTicket(ticketAlreadyClicked);
			}

//			System.out.println(indexOfAlreadyClicked);
			tree.setSelectionRow(indexOfAlreadyClicked);
		}


//		messageUsersStatus.setVisible(false);
//		jScrollPane1.removeAll();
//		jScrollPane1.add(tree)
//		jScrollPane1.revalidate();
	}

	protected static ImageIcon createImageIcon(String path) {
		java.net.URL imgURL = InterfaceClient.class.getResource(path);
		if (imgURL != null) {
			return new ImageIcon(imgURL);
		} else {
			System.err.println("Couldn't find file: " + path);
			return null;
		}
	}

	private void readMessagesOfTicket(String ticket) {
		List<Integer> idMessages = new ArrayList<>();

		for (Message m : client.getTicketMessages(ticket)) {
			if (!m.isAlreadyReadBy(actualUser)) {
				idMessages.add(m.getId());
			}
		}

//		if (idMessages.size() != 0)
			client.sendRequest(ClientRequest.READ_MESSAGES, actualUser, ticket, idMessages);
	}

	public void buildMessagesPane(String ticket) {
		int nbTickets = client.getTicketMessages(ticket).size();
		if (nbTickets < 5) {
			nbTickets = 5;
		}
		right_messages.setLayout(new java.awt.GridLayout(nbTickets, 1, 0, 20));

		right_messages.removeAll();
		for (Message m : client.getTicketMessages(ticket)) {
			right_messages.add(createBoxMessage(m));
		}

		right_newMessage.setVisible(true);
		right_messagesScroll.setViewportView(right_messages);

//		newMessage_input.setText("");
		newMessage_input.requestFocus();

		JScrollBar vertical = right_messagesScroll.getVerticalScrollBar();
		vertical.setValue(vertical.getMaximum());

		new Thread() {
			@Override
			public void run() {
				try {
					sleep(100);
				} catch (InterruptedException ex) {
					Logger.getLogger(InterfaceClient.class.getName()).log(Level.SEVERE, null, ex);
				}
				JScrollBar vertical = right_messagesScroll.getVerticalScrollBar();
				vertical.setValue(vertical.getMaximum());
			}
		}.start();
	}


	public JPanel createBoxMessage(Message m) {
		JPanel messages_box1 = new JPanel();
		JLabel box1_date = new JLabel();
		JTextArea box1_body = new JTextArea();
                box1_body.setEditable(false);
		JScrollPane box1_scroll_body = new JScrollPane();
                box1_body.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
		JLabel box1_allName =new JLabel();

		String name =m.getLastName().toUpperCase();
		String firstName =m.getFirstName().toLowerCase();
		Timestamp date =m.getCreate();
		String formatDate =new SimpleDateFormat("DD-MM-YYYY  HH:mm:ss").format(date);

//                box1_autor.setText(m.getAuthor());
		box1_body.setText(m.getBody());
		box1_date.setText(m.getCreate().toString().substring(0, 10));
		messages_box1.setBackground(m.stateColor());

                box1_allName.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
                box1_allName.setText(name +"  " +firstName);
		box1_allName.setForeground(Color.white);

                box1_date.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
                box1_date.setText(formatDate);
		box1_date.setForeground(Color.white);
                
                // test pour afficher l'etat des messages au passage de la souris :-) 
//                messages_box1.setToolTipText("<html> Lu : BOUYJOU Gauthier, BENZERGA Amine, <br> En attente : LAO-KAN Jonathan, LAMARQUE Nadège, <br> Reçu : CACHOT Johannes, MATHIEU Maxime, BAUDOIN Nicolas</html>");
                box1_body.setToolTipText(m.allUserStatusTipText());

		messages_box1.setPreferredSize(new java.awt.Dimension(0, 105));
		messages_box1.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				System.out.println(m.getId());
				majTableMessageUsersStatus(m);
			}
		});
		box1_scroll_body.setBorder(null);
		box1_scroll_body.setViewportView(box1_body);

                box1_body.setBorder(null);
                box1_body.setForeground(new java.awt.Color(51,51,51));
                box1_body.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
                box1_body.setOpaque(false);

		
                javax.swing.GroupLayout messages_box1Layout = new javax.swing.GroupLayout(messages_box1);
                messages_box1.setLayout(messages_box1Layout);
                messages_box1Layout.setHorizontalGroup(
                        messages_box1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(messages_box1Layout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addGroup(messages_box1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(box1_scroll_body)
                                        .addGroup(messages_box1Layout.createSequentialGroup()
                                                .addComponent(box1_allName, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 773, Short.MAX_VALUE)
                                                .addComponent(box1_date)))
                                .addContainerGap())
                );
                messages_box1Layout.setVerticalGroup(
                        messages_box1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(messages_box1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(messages_box1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(box1_allName, javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(box1_date, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(box1_scroll_body, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(105, Short.MAX_VALUE))
                );
		return messages_box1;
	}


	public void expandAll(JTree tree) {
		int row = 0;
		while (row < tree.getRowCount()) {
			tree.expandRow(row);
			row++;
		}
	}

	public JTable getGroup_own() {
		return group_own;
	}

	public JTable getGroup_other() {
		return group_other;
	}

	void majTableOneColumn(Set<String> l, String title, JTable table, JScrollPane sp) {
		Object data[][] = new Object[l.size()][1];
		int i = 0;
		for (String str : l) {
			data[i][0] = str;
			i++;
		}

		String title2[] = {title};
//		JScrollPane jp =(JScrollPane) table.getParent();
		table = new JTable(data, title2);
		if (title.equals("own groups")) {
			group_own = table;
		} else {
			group_other = table;
		}

//		group_sown.setViewportView(table);
		sp.setViewportView(table);
//		jScrollPane2.setViewportView(table);
	}

	void majTableMessageUsersStatus(Message m) {
		Object data[][] = m.getUsersStatus();
		String title[] = {"user", "status"};

//		messageUsersStatusTable = new JTable(data, title);
//		messageUsersStatus.setViewportView(messageUsersStatusTable);
	}

//	void majGroupTable(Set<String> myGroup, Set<String> other) {
//		Object data[][] =new Object[myGroup.size()][1];
//		int i =0;
//		for (String str : myGroup) {
//			data[i][0] =str;
//		}
////		i =0;
////		for (String str : other) {
////			data[i][0] =str;
////		}
//		String title[] ={"myGroup"};
//		group_own =new JTable(data, title);
//
//                jScrollPane2.setViewportView(group_own);
//	}
	public JScrollPane getGroup_sown() {
		return group_sown;
	}

	public JScrollPane getGroup_sother() {
		return group_sother;
	}

	public String actualTicket() {
		String ticket = "";
		if (tree.getLastSelectedPathComponent() != null) {
			ticket = (String) tree.getLastSelectedPathComponent().toString();
			while (ticket.charAt(ticket.length() - 1) != '(') {
				ticket = ticket.substring(0, ticket.length() - 1);
			}
			ticket = ticket.substring(0, ticket.length() - 2);
//			System.out.println("ticket ='" +ticket +"'");
		}
		return ticket;
	}

	void receiveMessagesFromServer(List<Message> lm) {
//		if (lm.size() == 1) {
//			Message m = lm.get(0);
//			String ticket = m.getTicket();
//
//			if (ticket.equals(actualTicket())) {
//				System.out.println("[InterfaceClient] buildPane");
//				buildMessagesPane(ticket);
//			} else {
//				System.out.println("[InterfaceClient] majTree");
//				majTree();
//			}
//		} else {
//			majTree();
//		}
//		if (lm.size() > 0)
		majTree();
	}

	public void setActualUser(String actualUser) {
		this.actualUser = actualUser;
	}

	public static String get(String url) throws IOException {

		String reponse = "";
		URL oracle = new URL(url);
		URLConnection yc = oracle.openConnection();
		try (BufferedReader in = new BufferedReader(
			new InputStreamReader(yc.getInputStream()))) {
			String inputLine;

			while ((inputLine = in.readLine()) != null) {
				reponse += inputLine;
			}
		}
		return reponse;
	}

	public JPanel getError_login_passwd() {
		return identification_errorLogin;
	}
        
}
