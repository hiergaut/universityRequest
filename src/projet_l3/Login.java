/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet_l3;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Amine
 */
public class Login extends javax.swing.JFrame {

    /**
     * Creates new form Login
     */
    public Login() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        background_logged = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        logged = new javax.swing.JPanel();
        txt_welcome = new javax.swing.JLabel();
        background_login = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        login = new javax.swing.JPanel();
        img_logo = new javax.swing.JLabel();
        img_email = new javax.swing.JLabel();
        txt_email = new javax.swing.JTextField();
        line_email = new javax.swing.JSeparator();
        img_mdp = new javax.swing.JLabel();
        txt_mdp = new javax.swing.JPasswordField();
        line_mdp = new javax.swing.JSeparator();
        btn_connexion = new javax.swing.JButton();
        txt_erreur = new javax.swing.JLabel();
        load = new javax.swing.JPanel();
        load_img = new javax.swing.JLabel();
        load_txt = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("UniversityRequest");

        background_logged.setBackground(new java.awt.Color(255, 255, 255));
        background_logged.setForeground(new java.awt.Color(204, 0, 0));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setForeground(new java.awt.Color(204, 0, 255));
        jPanel2.setLayout(new java.awt.CardLayout());

        logged.setBackground(new java.awt.Color(255, 255, 255));
        logged.setForeground(new java.awt.Color(255, 255, 255));

        txt_welcome.setFont(new java.awt.Font("Titillium", 0, 48)); // NOI18N
        txt_welcome.setForeground(new java.awt.Color(51, 153, 0));
        txt_welcome.setText("Connexion réussie !");
        txt_welcome.setToolTipText("");

        javax.swing.GroupLayout loggedLayout = new javax.swing.GroupLayout(logged);
        logged.setLayout(loggedLayout);
        loggedLayout.setHorizontalGroup(
            loggedLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(loggedLayout.createSequentialGroup()
                .addGap(316, 316, 316)
                .addComponent(txt_welcome)
                .addContainerGap(323, Short.MAX_VALUE))
        );
        loggedLayout.setVerticalGroup(
            loggedLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(loggedLayout.createSequentialGroup()
                .addGap(325, 325, 325)
                .addComponent(txt_welcome)
                .addContainerGap(324, Short.MAX_VALUE))
        );

        jPanel2.add(logged, "card2");

        javax.swing.GroupLayout background_loggedLayout = new javax.swing.GroupLayout(background_logged);
        background_logged.setLayout(background_loggedLayout);
        background_loggedLayout.setHorizontalGroup(
            background_loggedLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(background_loggedLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        background_loggedLayout.setVerticalGroup(
            background_loggedLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(background_loggedLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        background_login.setBackground(new java.awt.Color(224, 11, 59));

        jPanel1.setLayout(new java.awt.CardLayout());

        login.setBackground(new java.awt.Color(224, 11, 59));

        img_logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/projet_l3/img/logo.png"))); // NOI18N

        img_email.setIcon(new javax.swing.ImageIcon(getClass().getResource("/projet_l3/img/user.png"))); // NOI18N

        txt_email.setBackground(new java.awt.Color(224, 11, 59));
        txt_email.setFont(new java.awt.Font("Titillium", 0, 14)); // NOI18N
        txt_email.setForeground(new java.awt.Color(255, 255, 255));
        txt_email.setText("prenom.nom@univ-tlse3.fr");
        txt_email.setBorder(null);
        txt_email.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_emailFocusGained(evt);
            }
        });

        line_email.setBackground(new java.awt.Color(255, 255, 255));
        line_email.setForeground(new java.awt.Color(255, 255, 255));

        img_mdp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/projet_l3/img/password.png"))); // NOI18N

        txt_mdp.setBackground(new java.awt.Color(224, 11, 59));
        txt_mdp.setForeground(new java.awt.Color(255, 255, 255));
        txt_mdp.setText("txt_mdpfgdfgfdgfd");
        txt_mdp.setBorder(null);
        txt_mdp.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_mdpFocusGained(evt);
            }
        });

        line_mdp.setBackground(new java.awt.Color(255, 255, 255));
        line_mdp.setForeground(new java.awt.Color(255, 255, 255));

        btn_connexion.setBackground(new java.awt.Color(255, 255, 255));
        btn_connexion.setForeground(new java.awt.Color(224, 11, 59));
        btn_connexion.setText("CONNEXION");
        btn_connexion.setActionCommand("");
        btn_connexion.setBorder(null);
        btn_connexion.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_connexion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_connexionActionPerformed(evt);
            }
        });

        txt_erreur.setFont(new java.awt.Font("Titillium", 0, 14)); // NOI18N
        txt_erreur.setForeground(new java.awt.Color(255, 255, 255));
        txt_erreur.setToolTipText("");

        javax.swing.GroupLayout loginLayout = new javax.swing.GroupLayout(login);
        login.setLayout(loginLayout);
        loginLayout.setHorizontalGroup(
            loginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, loginLayout.createSequentialGroup()
                .addContainerGap(264, Short.MAX_VALUE)
                .addGroup(loginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(img_logo)
                    .addGroup(loginLayout.createSequentialGroup()
                        .addGroup(loginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(img_mdp)
                            .addComponent(img_email))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(loginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(loginLayout.createSequentialGroup()
                                .addComponent(txt_erreur)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btn_connexion, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txt_email, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(line_email, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(line_mdp, javax.swing.GroupLayout.DEFAULT_SIZE, 460, Short.MAX_VALUE)
                            .addComponent(txt_mdp))))
                .addGap(289, 289, 289))
        );
        loginLayout.setVerticalGroup(
            loginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, loginLayout.createSequentialGroup()
                .addContainerGap(114, Short.MAX_VALUE)
                .addGroup(loginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, loginLayout.createSequentialGroup()
                        .addComponent(img_logo)
                        .addGap(126, 126, 126)
                        .addComponent(txt_email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(img_email, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(line_email, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addGroup(loginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(img_mdp)
                    .addComponent(txt_mdp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(line_mdp, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addGroup(loginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_connexion, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_erreur))
                .addGap(173, 173, 173))
        );

        jPanel1.add(login, "card2");

        load.setBackground(new java.awt.Color(224, 11, 59));

        load_img.setIcon(new javax.swing.ImageIcon(getClass().getResource("/projet_l3/img/load.gif"))); // NOI18N

        load_txt.setBackground(new java.awt.Color(255, 255, 255));
        load_txt.setFont(new java.awt.Font("Titillium", 0, 14)); // NOI18N
        load_txt.setForeground(new java.awt.Color(255, 255, 255));
        load_txt.setText("Connexion en cours...");

        javax.swing.GroupLayout loadLayout = new javax.swing.GroupLayout(load);
        load.setLayout(loadLayout);
        loadLayout.setHorizontalGroup(
            loadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(loadLayout.createSequentialGroup()
                .addGap(456, 456, 456)
                .addComponent(load_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(457, Short.MAX_VALUE))
            .addGroup(loadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(loadLayout.createSequentialGroup()
                    .addGap(493, 493, 493)
                    .addComponent(load_img)
                    .addContainerGap(494, Short.MAX_VALUE)))
        );
        loadLayout.setVerticalGroup(
            loadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, loadLayout.createSequentialGroup()
                .addContainerGap(432, Short.MAX_VALUE)
                .addComponent(load_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(239, 239, 239))
            .addGroup(loadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(loadLayout.createSequentialGroup()
                    .addGap(329, 329, 329)
                    .addComponent(load_img)
                    .addContainerGap(329, Short.MAX_VALUE)))
        );

        jPanel1.add(load, "card3");

        javax.swing.GroupLayout background_loginLayout = new javax.swing.GroupLayout(background_login);
        background_login.setLayout(background_loginLayout);
        background_loginLayout.setHorizontalGroup(
            background_loginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(background_loginLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        background_loginLayout.setVerticalGroup(
            background_loginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(background_loginLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(background_login, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(background_logged, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(background_login, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(background_logged, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_emailFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_emailFocusGained
        // TODO add your handling code here:
        txt_email.setText(""); 
    }//GEN-LAST:event_txt_emailFocusGained

    private void btn_connexionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_connexionActionPerformed
        // TODO add your handling code here:
        // après les vérifications de connexion
        // si incorrect : txt_erreur.setText("Les identifiants sont incorrects !");
        
        if(! txt_email.getText().equals("amine@univ-tlse3.fr") || ! txt_mdp.getText().equals("amine")){
            txt_erreur.setText("Les identifiants sont incorrects !");
        }else{
        
            load.show();
            login.hide();
            /*
            try {
                Thread.sleep(20);
            } catch (InterruptedException ex) {
                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            load.hide();
            logged.show();*/
            
            



            // timeout au cas où la connexion échoue, a mettre au début
            
            new Timer().schedule(new TimerTask(){
                @Override
                public void run() {
                    login.show();
                    load.hide();
                    txt_erreur.setText("Oups ! Le serveur ne répond pas...");
                }
            },1000*5);
        }
    }//GEN-LAST:event_btn_connexionActionPerformed

    private void txt_mdpFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_mdpFocusGained
        // TODO add your handling code here:
        txt_mdp.setText("");
    }//GEN-LAST:event_txt_mdpFocusGained

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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel background_logged;
    private javax.swing.JPanel background_login;
    private javax.swing.JButton btn_connexion;
    private javax.swing.JLabel img_email;
    private javax.swing.JLabel img_logo;
    private javax.swing.JLabel img_mdp;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSeparator line_email;
    private javax.swing.JSeparator line_mdp;
    private javax.swing.JPanel load;
    private javax.swing.JLabel load_img;
    private javax.swing.JLabel load_txt;
    private javax.swing.JPanel logged;
    private javax.swing.JPanel login;
    private javax.swing.JTextField txt_email;
    private javax.swing.JLabel txt_erreur;
    private javax.swing.JPasswordField txt_mdp;
    private javax.swing.JLabel txt_welcome;
    // End of variables declaration//GEN-END:variables
}
