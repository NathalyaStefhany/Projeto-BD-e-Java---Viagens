package br.inatel.viagens.view;

import br.inatel.viagens.model.entities.PontoTuristicoLugares;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

/**
 * @author Nathalya
 * 
 */
public class GoogleMaps extends javax.swing.JFrame {

    int zoom = 12;
    String tipo = "roadmap";
    
    public GoogleMaps() {
        super("Google Maps");
        
        setSize(670, 650);
        setResizable(false);
        setLocationRelativeTo(null);
        
        initComponents();
        atualizaMapa();
        
        //Quando eu abrir o google maps como uma janela sencudária preciso fazer isso para quando clicar para fechar só fechar a tela do google maps
        setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        radioSatelite = new javax.swing.JRadioButton();
        radioRuas = new javax.swing.JRadioButton();
        botaoZoomMenos = new javax.swing.JButton();
        botaoZoomMais = new javax.swing.JButton();
        mapaLable = new javax.swing.JLabel();
        radioHibrido = new javax.swing.JRadioButton();
        radioTerreno = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(670, 650));
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        buttonGroup1.add(radioSatelite);
        radioSatelite.setText("Satelite");
        radioSatelite.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioSateliteActionPerformed(evt);
            }
        });

        buttonGroup1.add(radioRuas);
        radioRuas.setSelected(true);
        radioRuas.setText("Ruas");
        radioRuas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioRuasActionPerformed(evt);
            }
        });

        botaoZoomMenos.setText("-");
        botaoZoomMenos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoZoomMenosActionPerformed(evt);
            }
        });

        botaoZoomMais.setText("+");
        botaoZoomMais.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoZoomMaisActionPerformed(evt);
            }
        });

        buttonGroup1.add(radioHibrido);
        radioHibrido.setText("Híbrido");
        radioHibrido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioHibridoActionPerformed(evt);
            }
        });

        buttonGroup1.add(radioTerreno);
        radioTerreno.setText("Terreno");
        radioTerreno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioTerrenoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(radioRuas)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(radioSatelite)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(radioHibrido)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(radioTerreno)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 284, Short.MAX_VALUE)
                        .addComponent(botaoZoomMais)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(botaoZoomMenos, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(4, 4, 4))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(mapaLable, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botaoZoomMenos)
                    .addComponent(botaoZoomMais)
                    .addComponent(radioSatelite)
                    .addComponent(radioRuas)
                    .addComponent(radioHibrido)
                    .addComponent(radioTerreno))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(mapaLable, javax.swing.GroupLayout.PREFERRED_SIZE, 640, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botaoZoomMenosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoZoomMenosActionPerformed
        zoom--;
        atualizaMapa();
    }//GEN-LAST:event_botaoZoomMenosActionPerformed

    private void botaoZoomMaisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoZoomMaisActionPerformed
        zoom++;
        atualizaMapa();
    }//GEN-LAST:event_botaoZoomMaisActionPerformed

    private void radioSateliteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioSateliteActionPerformed
        mudaTipo();
    }//GEN-LAST:event_radioSateliteActionPerformed

    private void radioRuasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioRuasActionPerformed
        mudaTipo();
    }//GEN-LAST:event_radioRuasActionPerformed

    private void radioHibridoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioHibridoActionPerformed
        mudaTipo();
    }//GEN-LAST:event_radioHibridoActionPerformed

    private void radioTerrenoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioTerrenoActionPerformed
        mudaTipo();
    }//GEN-LAST:event_radioTerrenoActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        this.setIconImage(new ImageIcon("C:/Users/natha/OneDrive/Documentos/NetBeansProjects/Viagens/img/googleMaps.png").getImage());
    }//GEN-LAST:event_formWindowOpened

    public static void main(String args[]) {
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
            java.util.logging.Logger.getLogger(GoogleMaps.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GoogleMaps.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GoogleMaps.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GoogleMaps.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoZoomMais;
    private javax.swing.JButton botaoZoomMenos;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel mapaLable;
    private javax.swing.JRadioButton radioHibrido;
    private javax.swing.JRadioButton radioRuas;
    private javax.swing.JRadioButton radioSatelite;
    private javax.swing.JRadioButton radioTerreno;
    // End of variables declaration//GEN-END:variables

    private void mudaTipo(){
        if(radioRuas.isSelected()){
            tipo="roadmap";
        }
        if(radioSatelite.isSelected()){
            tipo="satellite";
        }
        if(radioHibrido.isSelected()){
             tipo="hybrid";
        }
        if(radioTerreno.isSelected()){
             tipo="terrain";
        }
        atualizaMapa();
    }
    
    private void atualizaMapa() {
        String chave="AIzaSyDSIUTKlUxCcWyj0XPAiHJ2FWwZMtoCtkY";
        String endereco = "http://maps.googleapis.com/maps/api/staticmap?center=" + PontoTuristicoLugares.latitude + "," + PontoTuristicoLugares.longitude + "&zoom=" + zoom + "&size=640x640&maptype=" + tipo + "&key="+chave+"&sensor=false&format=jpg";
       
        BufferedImage img = null;

        try{
            URL url = new URL(endereco);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            img = ImageIO.read(con.getInputStream());
        }catch(MalformedURLException ex){
            Logger.getLogger(GoogleMaps.class.getName()).log(Level.SEVERE, null, ex);
        }catch(IOException ex){
            Logger.getLogger(GoogleMaps.class.getName()).log(Level.SEVERE, null, ex);
        }

        if(img != null){
            ImageIcon mapa = new ImageIcon(img);
            mapaLable.setIcon(mapa);
        }
    }
}
