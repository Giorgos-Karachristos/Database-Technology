package delete;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */


import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.*;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

/**
 *
 * @author USER
 */
public class delete_danismos extends javax.swing.JFrame {

    /**
     * Creates new form Danismos
     */
    public delete_danismos() {
        initComponents();
        addDataToJComboBoxIdDanismos();
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
        java.awt.GridBagConstraints gridBagConstraints;

        jLabelDanismos = new javax.swing.JLabel();
        jLabelID = new javax.swing.JLabel();
        jComboBoxId = new javax.swing.JComboBox<>();
        jButtonDiagrafi = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("ΔΙΑΓΡΑΦΗ ΔΑΝΕΙΣΜΟΥ");
        getContentPane().setLayout(new java.awt.GridBagLayout());

        jLabelDanismos.setText("ΔΙΑΓΡΑΦΗ ΔΑΝΕΙΣΜΟΥ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(50, 20, 20, 20);
        getContentPane().add(jLabelDanismos, gridBagConstraints);

        jLabelID.setText("ID:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new java.awt.Insets(20, 50, 20, 20);
        getContentPane().add(jLabelID, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new java.awt.Insets(20, 20, 20, 50);
        getContentPane().add(jComboBoxId, gridBagConstraints);

        jButtonDiagrafi.setText("Διαγραφή");
        jButtonDiagrafi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDiagrafiActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.insets = new java.awt.Insets(20, 20, 50, 20);
        getContentPane().add(jButtonDiagrafi, gridBagConstraints);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonDiagrafiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDiagrafiActionPerformed
        // TODO add your handling code here:
        try {
            deleteDanismos(Integer.parseInt((String)jComboBoxId.getSelectedItem()));
            JOptionPane.showMessageDialog(null, "Επιτυχής διαγραφη");
            jComboBoxId.setSelectedIndex(-1);
        } catch (Exception ex) {
            Logger.getLogger(delete_danismos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButtonDiagrafiActionPerformed

    public void deleteDanismos(int id) throws Exception {
        Class.forName(driverClassName);
        dbConnection = DriverManager.getConnection(url, username, passwd);

        pstatement = dbConnection.prepareStatement("BEGIN DELETE_DANISMOS(?); END;");
        pstatement.setInt(1, id);

        pstatement.executeUpdate();

        pstatement.close();
        dbConnection.close();
    }
    
    void addDataToJComboBoxIdDanismos() {
        DefaultComboBoxModel ComboBox = (DefaultComboBoxModel) jComboBoxId.getModel();

        Object rowData[] = new Object[50];

        int i = 0;
        try {
            dbConnection = DriverManager.getConnection(url, username, passwd);
            statement = dbConnection.createStatement();
            rs = statement.executeQuery("SELECT * FROM TABLE (EMFANISIDANISMOS)");
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
        jComboBoxId.addItem("");
        int j;
        for ( j= 0; j < i; j++) {
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
            java.util.logging.Logger.getLogger(delete_danismos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(delete_danismos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(delete_danismos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(delete_danismos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new delete_danismos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonDiagrafi;
    private javax.swing.JComboBox<String> jComboBoxId;
    private javax.swing.JLabel jLabelDanismos;
    private javax.swing.JLabel jLabelID;
    // End of variables declaration//GEN-END:variables
}
