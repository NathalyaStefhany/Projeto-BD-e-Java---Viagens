package br.inatel.viagens.view;

import br.inatel.viagens.model.dao.ContaDAO;
import br.inatel.viagens.model.entities.Conta;
import java.awt.Color;
import java.util.Arrays;
import javax.swing.ImageIcon;

/**
 * @author Nathalya
 * 
 */

public class TelaLogin extends javax.swing.JFrame {
    //Creates new form TelaLogin    
    public TelaLogin() {
        initComponents();
        
        setSize(1000, 650);
        setResizable(false);
        setLocationRelativeTo(null);
        
        //Para não começar com um jText selecionado
        jPanel.setFocusable(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel = new javax.swing.JPanel();
        jLabelBackground = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabelLogin = new javax.swing.JLabel();
        jTextFieldEntradaEmail = new javax.swing.JTextField();
        jPasswordFieldEntradaSenha = new javax.swing.JPasswordField();
        jCheckBoxMostrarSenha = new javax.swing.JCheckBox();
        jButtonEntrar = new javax.swing.JButton();
        jSeparator = new javax.swing.JSeparator();
        jLabelTextoCadastrar = new javax.swing.JLabel();
        jLabelCadastrar = new javax.swing.JLabel();
        jLabelTransparencia = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Travel around the World - Login");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel.setBackground(new java.awt.Color(74, 39, 72));
        jPanel.setForeground(new java.awt.Color(74, 39, 72));
        jPanel.setLayout(null);

        jLabelBackground.setIcon(new javax.swing.ImageIcon("C:\\Users\\natha\\OneDrive\\Documentos\\NetBeansProjects\\Viagens\\img\\background.png")); // NOI18N
        jPanel.add(jLabelBackground);
        jLabelBackground.setBounds(-6, -6, 650, 660);

        jLabel1.setFont(new java.awt.Font("Segoe Print", 1, 35)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Travel around the");
        jPanel.add(jLabel1);
        jLabel1.setBounds(660, 20, 330, 63);

        jLabel2.setFont(new java.awt.Font("Segoe Print", 1, 35)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("World");
        jPanel.add(jLabel2);
        jLabel2.setBounds(770, 70, 110, 63);

        jLabelLogin.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabelLogin.setText("Login");
        jPanel.add(jLabelLogin);
        jLabelLogin.setBounds(790, 200, 66, 30);

        jTextFieldEntradaEmail.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jTextFieldEntradaEmail.setForeground(new java.awt.Color(102, 102, 102));
        jTextFieldEntradaEmail.setText("E-mail");
        jTextFieldEntradaEmail.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextFieldEntradaEmailFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextFieldEntradaEmailFocusLost(evt);
            }
        });
        jPanel.add(jTextFieldEntradaEmail);
        jTextFieldEntradaEmail.setBounds(710, 260, 230, 30);

        jPasswordFieldEntradaSenha.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jPasswordFieldEntradaSenha.setForeground(new java.awt.Color(102, 102, 102));
        jPasswordFieldEntradaSenha.setText("Senha");
        jPasswordFieldEntradaSenha.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jPasswordFieldEntradaSenhaFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jPasswordFieldEntradaSenhaFocusLost(evt);
            }
        });
        jPanel.add(jPasswordFieldEntradaSenha);
        jPasswordFieldEntradaSenha.setBounds(710, 300, 230, 30);

        jCheckBoxMostrarSenha.setText("Mostrar senha");
        jCheckBoxMostrarSenha.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jCheckBoxMostrarSenha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxMostrarSenhaActionPerformed(evt);
            }
        });
        jPanel.add(jCheckBoxMostrarSenha);
        jCheckBoxMostrarSenha.setBounds(710, 340, 120, 23);

        jButtonEntrar.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jButtonEntrar.setText("Entrar");
        jButtonEntrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonEntrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEntrarActionPerformed(evt);
            }
        });
        jPanel.add(jButtonEntrar);
        jButtonEntrar.setBounds(710, 370, 230, 30);

        jSeparator.setBackground(new java.awt.Color(204, 204, 204));
        jSeparator.setForeground(new java.awt.Color(204, 204, 204));
        jPanel.add(jSeparator);
        jSeparator.setBounds(790, 410, 80, 10);

        jLabelTextoCadastrar.setText("Não tem uma conta? ");
        jPanel.add(jLabelTextoCadastrar);
        jLabelTextoCadastrar.setBounds(710, 420, 120, 14);

        jLabelCadastrar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabelCadastrar.setForeground(new java.awt.Color(33, 33, 33));
        jLabelCadastrar.setText("<html><u>Cadastre-se agora!</u>");
        jLabelCadastrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelCadastrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelCadastrarMouseClicked(evt);
            }
        });
        jPanel.add(jLabelCadastrar);
        jLabelCadastrar.setBounds(830, 420, 120, 14);

        jLabelTransparencia.setIcon(new javax.swing.ImageIcon("C:\\Users\\natha\\OneDrive\\Documentos\\NetBeansProjects\\Viagens\\img\\transparencia.png")); // NOI18N
        jPanel.add(jLabelTransparencia);
        jLabelTransparencia.setBounds(690, 180, 270, 280);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 1000, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 650, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextFieldEntradaEmailFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldEntradaEmailFocusGained
        //Desaparece o texto "E-mail" quando a pessoa clicar para digitar
        if(jTextFieldEntradaEmail.getText().trim().equals("E-mail")){
            jTextFieldEntradaEmail.setText("");
            
            //Cor da fonte
            jTextFieldEntradaEmail.setForeground(Color.black);
        }
    }//GEN-LAST:event_jTextFieldEntradaEmailFocusGained

    private void jTextFieldEntradaEmailFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldEntradaEmailFocusLost
        //Mostra o texto "E-mail" enquanto a pessoa não clicar para digitar
        if(jTextFieldEntradaEmail.getText().trim().equals("")){
            jTextFieldEntradaEmail.setText("E-mail");
            
            //Cor da fonte
            jTextFieldEntradaEmail.setForeground(new Color(102,102,102));
        }
    }//GEN-LAST:event_jTextFieldEntradaEmailFocusLost

    private void jCheckBoxMostrarSenhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxMostrarSenhaActionPerformed
        if(jCheckBoxMostrarSenha.isSelected()){
            //Muda para caracter a senha
            jPasswordFieldEntradaSenha.setEchoChar((char)0); 
        }
        else{
            //Muda para * a senha
            jPasswordFieldEntradaSenha.setEchoChar('*');
        }
    }//GEN-LAST:event_jCheckBoxMostrarSenhaActionPerformed

    private void jPasswordFieldEntradaSenhaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jPasswordFieldEntradaSenhaFocusLost
        //Mostra o texto "Senha" enquanto a pessoa não clicar para digitar
        char[] senha = jPasswordFieldEntradaSenha.getPassword();    //O password retorna um char
        
        if(senha.length == 0){
            jPasswordFieldEntradaSenha.setText("Senha");

            //Cor da fonte
            jPasswordFieldEntradaSenha.setForeground(new Color(102,102,102));
        }
    }//GEN-LAST:event_jPasswordFieldEntradaSenhaFocusLost

    private void jPasswordFieldEntradaSenhaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jPasswordFieldEntradaSenhaFocusGained
        //Desaparece o texto "Senha" quando a pessoa clicar para digitar
        char[] senha = jPasswordFieldEntradaSenha.getPassword();
        char[] palavra = {'S', 'e', 'n', 'h', 'a'};
        
        if(Arrays.equals(senha, palavra)){
            jPasswordFieldEntradaSenha.setText("");
            
            //Cor da fonte
            jPasswordFieldEntradaSenha.setForeground(Color.black);
        }
    }//GEN-LAST:event_jPasswordFieldEntradaSenhaFocusGained

    private void jLabelCadastrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelCadastrarMouseClicked
        new TelaCadastro().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabelCadastrarMouseClicked

    private void jButtonEntrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEntrarActionPerformed
        Conta conta = new Conta();
        
        conta.setEmail(jTextFieldEntradaEmail.getText());
        conta.setSenha(String.valueOf(jPasswordFieldEntradaSenha.getPassword()));
        
        ContaDAO dao = new ContaDAO();
        
        if(dao.loginUsuario(conta)){
            if(!conta.getEmail().equals("admin")){
                new TelaInicial().setVisible(true);

                //Fechara a janela e saíra da memória. Se utilizasse o setVisible a janela ainda estaria aberta porém inivisivel
                this.dispose();
            }
            else{
                new TelaListaLugaresAdmin().setVisible(true);
                
                this.dispose();
            }
        }
    }//GEN-LAST:event_jButtonEntrarActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        this.setIconImage(new ImageIcon("C:/Users/natha/OneDrive/Documentos/NetBeansProjects/Viagens/img/travel.png").getImage());
    }//GEN-LAST:event_formWindowOpened

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
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaLogin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonEntrar;
    private javax.swing.JCheckBox jCheckBoxMostrarSenha;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabelBackground;
    private javax.swing.JLabel jLabelCadastrar;
    private javax.swing.JLabel jLabelLogin;
    private javax.swing.JLabel jLabelTextoCadastrar;
    private javax.swing.JLabel jLabelTransparencia;
    private javax.swing.JPanel jPanel;
    private javax.swing.JPasswordField jPasswordFieldEntradaSenha;
    private javax.swing.JSeparator jSeparator;
    private javax.swing.JTextField jTextFieldEntradaEmail;
    // End of variables declaration//GEN-END:variables
}
