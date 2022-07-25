package insert;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author USER
 */
public class insert_rafiera extends javax.swing.JFrame {

    /**
     * Creates new form rafiera
     */
    public insert_rafiera() {
        initComponents();
    }

    static String driverClassName = "oracle.jdbc.OracleDriver";
    static String url = "jdbc:oracle:thin:@192.168.6.21:1521:dblabs";
    static Connection dbConnection = null;
    static String username = "it185192";
    static String passwd = "giorgosgtav";
    static PreparedStatement pstatement = null;

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jLabelRafiera = new javax.swing.JLabel();
        jLabelId = new javax.swing.JLabel();
        jTextFieldId = new javax.swing.JTextField();
        jLabelDiadromos = new javax.swing.JLabel();
        jTextFieldDiadromos = new javax.swing.JTextField();
        jLabelOrofos = new javax.swing.JLabel();
        jTextFieldOrofos = new javax.swing.JTextField();
        jLabelEidos = new javax.swing.JLabel();
        jTextFieldEidos = new javax.swing.JTextField();
        jButtonIpoboli = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("ΕΙΣΑΓΩΓΗ ΡΑΦΙΕΡΑ");
        getContentPane().setLayout(new java.awt.GridBagLayout());

        jLabelRafiera.setText("ΕΙΣΑΓΩΓΗ ΡΑΦΙΕΡΑ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(20, 20, 20, 20);
        getContentPane().add(jLabelRafiera, gridBagConstraints);

        jLabelId.setText("ID:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new java.awt.Insets(20, 20, 20, 20);
        getContentPane().add(jLabelId, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.ipadx = 75;
        gridBagConstraints.insets = new java.awt.Insets(20, 20, 20, 20);
        getContentPane().add(jTextFieldId, gridBagConstraints);

        jLabelDiadromos.setText("Διάδρομος:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(20, 20, 20, 20);
        getContentPane().add(jLabelDiadromos, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.ipadx = 75;
        gridBagConstraints.insets = new java.awt.Insets(20, 20, 20, 20);
        getContentPane().add(jTextFieldDiadromos, gridBagConstraints);

        jLabelOrofos.setText("Όροφος:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.insets = new java.awt.Insets(20, 20, 20, 20);
        getContentPane().add(jLabelOrofos, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.ipadx = 75;
        gridBagConstraints.insets = new java.awt.Insets(20, 20, 20, 20);
        getContentPane().add(jTextFieldOrofos, gridBagConstraints);

        jLabelEidos.setText("Είδος βιβλίων:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.insets = new java.awt.Insets(20, 20, 20, 20);
        getContentPane().add(jLabelEidos, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.ipadx = 75;
        gridBagConstraints.insets = new java.awt.Insets(20, 20, 20, 20);
        getContentPane().add(jTextFieldEidos, gridBagConstraints);

        jButtonIpoboli.setText("Υποβολή");
        jButtonIpoboli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonIpoboliActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.insets = new java.awt.Insets(20, 20, 20, 20);
        getContentPane().add(jButtonIpoboli, gridBagConstraints);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonIpoboliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonIpoboliActionPerformed
        // TODO add your handling code here:
        try {
            if (!jTextFieldId.getText().isBlank()) {
                insertRafiera(Integer.parseInt(jTextFieldId.getText()),
                        Integer.parseInt(jTextFieldOrofos.getText()),
                        Integer.parseInt(jTextFieldDiadromos.getText()),
                        jTextFieldEidos.getText());
                JOptionPane.showMessageDialog(null, "Επιτυχής εισαγωγή");
                jTextFieldId.setText("");
                jTextFieldOrofos.setText("");
                jTextFieldDiadromos.setText("");
                jTextFieldEidos.setText("");
            } else {
                JOptionPane.showMessageDialog(null, "Το πεδίο ID είναι υποχρεωτικο");
            }
        } catch (Exception ex) {
            Logger.getLogger(insert_rafiera.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButtonIpoboliActionPerformed

    public void insertRafiera(int id, int orofos, int diadromos, String eidos) throws Exception {
        Class.forName(driverClassName);
        dbConnection = DriverManager.getConnection(url, username, passwd);

        pstatement = dbConnection.prepareStatement("BEGIN INSERT_RAFIERA(?,?,?,?); END;");
        pstatement.setInt(1, id);
        pstatement.setInt(2, orofos);
        pstatement.setInt(3, diadromos);
        pstatement.setString(4, eidos);

        pstatement.executeUpdate();

        pstatement.close();
        dbConnection.close();
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
            java.util.logging.Logger.getLogger(insert_rafiera.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(insert_rafiera.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(insert_rafiera.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(insert_rafiera.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new insert_rafiera().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonIpoboli;
    private javax.swing.JLabel jLabelDiadromos;
    private javax.swing.JLabel jLabelEidos;
    private javax.swing.JLabel jLabelId;
    private javax.swing.JLabel jLabelOrofos;
    private javax.swing.JLabel jLabelRafiera;
    private javax.swing.JTextField jTextFieldDiadromos;
    private javax.swing.JTextField jTextFieldEidos;
    private javax.swing.JTextField jTextFieldId;
    private javax.swing.JTextField jTextFieldOrofos;
    // End of variables declaration//GEN-END:variables
}
