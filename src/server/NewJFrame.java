/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import java.awt.CardLayout;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author gauthier
 */
public class NewJFrame extends javax.swing.JFrame {

	/**
	 * Creates new form NewJFrame
	 */
	public NewJFrame() {
		initComponents();
	}

	/**
	 * This method is called from within the constructor to initialize the
	 * form. WARNING: Do NOT modify this code. The content of this method is
	 * always regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
        // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
        private void initComponents() {

                jPanel1 = new javax.swing.JPanel();
                jPanel2 = new javax.swing.JPanel();
                jButton1 = new javax.swing.JButton();
                jButton2 = new javax.swing.JButton();
                jPanel3 = new javax.swing.JPanel();
                jPanel4 = new javax.swing.JPanel();
                jLabel2 = new javax.swing.JLabel();
                jPanel5 = new javax.swing.JPanel();
                jLabel3 = new javax.swing.JLabel();
                jPanel6 = new javax.swing.JPanel();
                jLabel1 = new javax.swing.JLabel();

                setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
                getContentPane().setLayout(new java.awt.CardLayout());

                jPanel1.setLayout(new java.awt.BorderLayout());

                jButton1.setText("jButton1");
                jButton1.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                jButton1ActionPerformed(evt);
                        }
                });

                jButton2.setText("jButton2");
                jButton2.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                jButton2ActionPerformed(evt);
                        }
                });

                javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
                jPanel2.setLayout(jPanel2Layout);
                jPanel2Layout.setHorizontalGroup(
                        jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(82, 82, 82)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jButton2)
                                        .addComponent(jButton1))
                                .addContainerGap(86, Short.MAX_VALUE))
                );
                jPanel2Layout.setVerticalGroup(
                        jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(125, 125, 125)
                                .addComponent(jButton1)
                                .addGap(56, 56, 56)
                                .addComponent(jButton2)
                                .addContainerGap(249, Short.MAX_VALUE))
                );

                jPanel1.add(jPanel2, java.awt.BorderLayout.WEST);

                jPanel3.setLayout(new java.awt.CardLayout());

                jLabel2.setText("1");

                javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
                jPanel4.setLayout(jPanel4Layout);
                jPanel4Layout.setHorizontalGroup(
                        jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(200, 200, 200)
                                .addComponent(jLabel2)
                                .addContainerGap(416, Short.MAX_VALUE))
                );
                jPanel4Layout.setVerticalGroup(
                        jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(166, 166, 166)
                                .addComponent(jLabel2)
                                .addContainerGap(299, Short.MAX_VALUE))
                );

                jPanel3.add(jPanel4, "card2");

                jLabel3.setText("2");

                javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
                jPanel5.setLayout(jPanel5Layout);
                jPanel5Layout.setHorizontalGroup(
                        jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(132, 132, 132)
                                .addComponent(jLabel3)
                                .addContainerGap(484, Short.MAX_VALUE))
                );
                jPanel5Layout.setVerticalGroup(
                        jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(187, 187, 187)
                                .addComponent(jLabel3)
                                .addContainerGap(278, Short.MAX_VALUE))
                );

                jPanel3.add(jPanel5, "card3");

                jLabel1.setText("wait");

                javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
                jPanel6.setLayout(jPanel6Layout);
                jPanel6Layout.setHorizontalGroup(
                        jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGap(98, 98, 98)
                                .addComponent(jLabel1)
                                .addContainerGap(495, Short.MAX_VALUE))
                );
                jPanel6Layout.setVerticalGroup(
                        jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGap(204, 204, 204)
                                .addComponent(jLabel1)
                                .addContainerGap(261, Short.MAX_VALUE))
                );

                jPanel3.add(jPanel6, "card4");

                jPanel1.add(jPanel3, java.awt.BorderLayout.CENTER);

                getContentPane().add(jPanel1, "card2");

                pack();
        }// </editor-fold>//GEN-END:initComponents

        private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
                // TODO add your handling code here:
		CardLayout cl = (CardLayout) jPanel3.getLayout();
		cl.show(jPanel3, "card4");
		
		new Thread() {
			public void run() {
				try {
					sleep(1000);
				} catch (InterruptedException ex) {
					Logger.getLogger(NewJFrame.class.getName()).log(Level.SEVERE, null, ex);
				}
				cl.show(jPanel3, "card2");
			}
		}.start();

//		jPanel6.setVisible(true);
//		try {
//			Thread.sleep(1000);
//		} catch (InterruptedException ex) {
//			Logger.getLogger(NewJFrame.class.getName()).log(Level.SEVERE, null, ex);
//		}
//		jPanel4.setVisible(true);
//		cl.show(jPanel3, "card2");
        }//GEN-LAST:event_jButton1ActionPerformed

        private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
                // TODO add your handling code here:
//		jPanel6.setVisible(true);
		CardLayout cl = (CardLayout) jPanel3.getLayout();
		cl.show(jPanel3, "card4");
//		try {
//			Thread.sleep(1000);
//		} catch (InterruptedException ex) {
//			Logger.getLogger(NewJFrame.class.getName()).log(Level.SEVERE, null, ex);
//		}
//		jPanel5.setVisible(true);
		cl.show(jPanel3, "card3");
        }//GEN-LAST:event_jButton2ActionPerformed

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
			java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		}
		//</editor-fold>

		/* Create and display the form */
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new NewJFrame().setVisible(true);
			}
		});
	}

        // Variables declaration - do not modify//GEN-BEGIN:variables
        private javax.swing.JButton jButton1;
        private javax.swing.JButton jButton2;
        private javax.swing.JLabel jLabel1;
        private javax.swing.JLabel jLabel2;
        private javax.swing.JLabel jLabel3;
        private javax.swing.JPanel jPanel1;
        private javax.swing.JPanel jPanel2;
        private javax.swing.JPanel jPanel3;
        private javax.swing.JPanel jPanel4;
        private javax.swing.JPanel jPanel5;
        private javax.swing.JPanel jPanel6;
        // End of variables declaration//GEN-END:variables
}
