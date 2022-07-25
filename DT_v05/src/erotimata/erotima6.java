/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package erotimata;

import java.awt.Toolkit;
import java.awt.event.ItemEvent;
import java.awt.event.WindowEvent;
import java.sql.*;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author vtsan
 */
public class erotima6 extends javax.swing.JFrame {

    /**
     * Creates new form erotima6
     */
    public erotima6() {
        initComponents();
        addDataToJComboBoxRafiera();
    }

    static String driverClassName = "oracle.jdbc.OracleDriver";
    static String url = "jdbc:oracle:thin:@192.168.6.21:1521:dblabs";
    static Connection dbConnection = null;
    static String username = "it185192";
    static String passwd = "giorgosgtav";

    static PreparedStatement pstatement = null;

    static Statement statement = null;
    static ResultSet rs = null;

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")


    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jComboBoxRafiera = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Αναζήτηση βιβλίων με βάση την ραφιέρα");

        jComboBoxRafiera.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBoxRafieraItemStateChanged(evt);
            }
        });
        jComboBoxRafiera.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxRafieraActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Τίτλος"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jLabel2.setText("Βιβλία απο την ραφιέρα με ID");

        jButton1.setText("Πίσω");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton1)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel2)
                            .addGap(33, 33, 33)
                            .addComponent(jLabel1)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jComboBoxRafiera, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(15, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBoxRafiera, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBoxRafieraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxRafieraActionPerformed

        DefaultTableModel table = (DefaultTableModel) jTable1.getModel();
        Object row[] = new Object[1];
        try {
            dbConnection = DriverManager.getConnection(url, username, passwd);
            pstatement = dbConnection.prepareStatement("SELECT * FROM table (EROTIMA6(?))");
            pstatement.setString(1, (String) jComboBoxRafiera.getSelectedItem());
            rs = pstatement.executeQuery();
            while (rs.next()) {
                row[0] = rs.getString(1); //edo

                table.addRow(row);
            }
            pstatement.close();

        } catch (SQLException ex) {
            System.out.println("\n -- SQL Exception --- \n");
            while (ex != null) {
                System.out.println("Message: " + ex.getMessage());
                ex = ex.getNextException();
            }
        }

    }//GEN-LAST:event_jComboBoxRafieraActionPerformed

    private void jComboBoxRafieraItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBoxRafieraItemStateChanged
        DefaultTableModel table = (DefaultTableModel) jTable1.getModel();
        if (evt.getStateChange() == ItemEvent.SELECTED)
            table.setRowCount(0);
    }//GEN-LAST:event_jComboBoxRafieraItemStateChanged

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        close();

    }//GEN-LAST:event_jButton1ActionPerformed

    public void close() {
        WindowEvent closeWindow = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
        Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(closeWindow);
    }

    void addDataToJComboBoxRafiera() {
        DefaultComboBoxModel ComboBox = (DefaultComboBoxModel) jComboBoxRafiera.getModel();

        Object rowData[] = new Object[50];
        int i = 0;
        try {
            dbConnection = DriverManager.getConnection(url, username, passwd);
            statement = dbConnection.createStatement();
            rs = statement.executeQuery("SELECT * FROM TABLE (EMFANISIRAFIERA)");
            while (rs.next()) {
                rowData[i] = rs.getString(1);
                i++;
            }
        } catch (SQLException ex) {
            System.out.println("\n -- SQL Exception --- \n");
            while (ex != null) {
                System.out.println("Message: " + ex.getMessage());
                ex = ex.getNextException();
            }
        }
        jComboBoxRafiera.addItem("");
        int j;
        for (j = 0; j < i; j++) {
            ComboBox.addElement(rowData[j]);
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
            java.util.logging.Logger.getLogger(erotima6.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(erotima6.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(erotima6.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(erotima6.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new erotima6().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<String> jComboBoxRafiera;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
