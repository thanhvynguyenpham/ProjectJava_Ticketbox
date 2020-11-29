/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.awt.Color;
import Controller.LoginController;
/**
 *
 * @author ngnth
 */
public class SignInView extends javax.swing.JFrame {

    /**
     * Creates new form SignInView
     */
    public SignInView() {
        initComponents();
        panel_left.setBackground(new Color(0, 0, 0, 200));
        setResizable(false);
        wrong_warning.setVisible(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jColorChooser1 = new javax.swing.JColorChooser();
        panel_right = new javax.swing.JPanel();
        jLab_Password = new javax.swing.JLabel();
        username = new javax.swing.JTextField();
        jSep_UserName = new javax.swing.JSeparator();
        jSep_Password = new javax.swing.JSeparator();
        password = new javax.swing.JPasswordField();
        jLabel4 = new javax.swing.JLabel();
        jLab_UserName = new javax.swing.JLabel();
        SignUpText = new javax.swing.JLabel();
        jBut_SignIn = new javax.swing.JButton();
        wrong_warning = new javax.swing.JLabel();
        panel_left = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        background = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setSize(new java.awt.Dimension(0, 0));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panel_right.setBackground(new java.awt.Color(32, 33, 35));
        panel_right.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLab_Password.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLab_Password.setForeground(new java.awt.Color(51, 52, 54));
        jLab_Password.setText("Password");
        panel_right.add(jLab_Password, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 260, -1, -1));

        username.setBackground(new java.awt.Color(32, 33, 35));
        username.setForeground(new java.awt.Color(255, 255, 255));
        username.setBorder(null);
        username.setCaretColor(new java.awt.Color(255, 255, 255));
        username.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                usernameFocusGained(evt);
            }
        });
        username.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usernameActionPerformed(evt);
            }
        });
        panel_right.add(username, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 180, 330, 30));
        panel_right.add(jSep_UserName, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 220, 330, 20));
        panel_right.add(jSep_Password, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 330, 330, 20));

        password.setBackground(new java.awt.Color(32, 33, 35));
        password.setForeground(new java.awt.Color(255, 255, 255));
        password.setBorder(null);
        password.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                passwordFocusGained(evt);
            }
        });
        panel_right.add(password, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 290, 330, 30));

        jLabel4.setForeground(new java.awt.Color(204, 204, 204));
        jLabel4.setText("Don't have an account?");
        panel_right.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 470, -1, 30));

        jLab_UserName.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLab_UserName.setForeground(new java.awt.Color(153, 153, 255));
        jLab_UserName.setText("UserName");
        panel_right.add(jLab_UserName, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 150, -1, -1));

        SignUpText.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        SignUpText.setForeground(new java.awt.Color(153, 153, 255));
        SignUpText.setText("Sign Up");
        SignUpText.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        SignUpText.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SignUpTextMouseClicked(evt);
            }
        });
        panel_right.add(SignUpText, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 470, -1, 30));

        jBut_SignIn.setBackground(new java.awt.Color(126, 87, 194));
        jBut_SignIn.setFont(new java.awt.Font("Segoe UI Semibold", 1, 16)); // NOI18N
        jBut_SignIn.setForeground(new java.awt.Color(255, 255, 255));
        jBut_SignIn.setText("Sign In");
        jBut_SignIn.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jBut_SignIn.setBorderPainted(false);
        jBut_SignIn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jBut_SignIn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBut_SignInActionPerformed(evt);
            }
        });
        panel_right.add(jBut_SignIn, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 390, 330, 40));
        jBut_SignIn.getAccessibleContext().setAccessibleName("JBut_SignUp");

        wrong_warning.setFont(new java.awt.Font("Segoe UI", 2, 16)); // NOI18N
        wrong_warning.setForeground(new java.awt.Color(255, 102, 0));
        wrong_warning.setText("Wrong username or password!");
        panel_right.add(wrong_warning, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 160, 230, -1));

        getContentPane().add(panel_right, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 0, 531, 560));

        panel_left.setBackground(new java.awt.Color(51, 51, 51));
        panel_left.setForeground(new java.awt.Color(204, 204, 255));
        panel_left.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setFont(new java.awt.Font("Segoe UI", 3, 16)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(204, 204, 204));
        jLabel5.setText("Book Now, Go Anytime");
        panel_left.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 300, 240, 30));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/logo.png"))); // NOI18N
        panel_left.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 120, -1, -1));

        getContentPane().add(panel_left, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 511, 560));

        background.setIcon(new javax.swing.ImageIcon("C:\\Users\\ngnth\\Downloads\\13813637.jpg")); // NOI18N
        background.setText("jLabel6");
        getContentPane().add(background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 520, 560));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void usernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_usernameActionPerformed

    private void passwordFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_passwordFocusGained
       jLab_Password.setForeground(new Color(153,153,255));
       jLab_UserName.setForeground(new Color(51,52,54));
    }//GEN-LAST:event_passwordFocusGained

    private void jBut_SignInActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBut_SignInActionPerformed
        // TODO add your handling code here:
        wrong_warning.setVisible(false);
        String user = username.getText();
        String pass = String.valueOf(password.getPassword());
        int check = LoginController.checkAnAccount(user, pass);
        if (check == 0){
            wrong_warning.setVisible(true);
        }
        else if (check == 1){
            //go to Customer Screen
            new CustomerView().setVisible(true);
            this.dispose();
        }
        else if (check == 2){
            //go to Admin Screen
            new AdminView().setVisible(true);
            this.dispose();
        }
        
    }//GEN-LAST:event_jBut_SignInActionPerformed

    private void usernameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_usernameFocusGained
        jLab_UserName.setForeground(new Color(153,153,255));
        jLab_Password.setForeground(new Color(51,52,54));
    }//GEN-LAST:event_usernameFocusGained

    private void SignUpTextMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SignUpTextMouseClicked
        // TODO add your handling code here:
        new SignUpView().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_SignUpTextMouseClicked

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
            java.util.logging.Logger.getLogger(SignInView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SignInView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SignInView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SignInView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SignInView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel SignUpText;
    private javax.swing.JLabel background;
    private javax.swing.JButton jBut_SignIn;
    private javax.swing.JColorChooser jColorChooser1;
    private javax.swing.JLabel jLab_Password;
    private javax.swing.JLabel jLab_UserName;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JSeparator jSep_Password;
    private javax.swing.JSeparator jSep_UserName;
    private javax.swing.JPanel panel_left;
    private javax.swing.JPanel panel_right;
    private javax.swing.JPasswordField password;
    private javax.swing.JTextField username;
    private javax.swing.JLabel wrong_warning;
    // End of variables declaration//GEN-END:variables
}