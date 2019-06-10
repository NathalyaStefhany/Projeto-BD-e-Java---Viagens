package br.inatel.viagens.view;

/**
 * @author Nathalya
 * 
 */

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.TimeZone;
import javax.swing.ImageIcon;

public class TelaInicial extends javax.swing.JFrame {
    //Creates new form TelaInicial
    public TelaInicial() {
        initComponents();
        
        setSize(1000, 650);
        setResizable(false);
        setLocationRelativeTo(null);
        
        jPanel.setFocusable(true);
        
        TimeZone.getDefault();
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
        background = new javax.swing.JLabel();
        jPanelCotacao = new javax.swing.JPanel();
        jLabelEuro = new javax.swing.JLabel();
        jLabelDolar = new javax.swing.JLabel();
        jLabelLibra = new javax.swing.JLabel();
        jPanelSeguroViagem = new javax.swing.JPanel();
        jLabelSeguroViagem = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jButtonFazerCotacao = new javax.swing.JButton();
        jPanelHospedagem = new javax.swing.JPanel();
        jLabelAirbnb = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jButtonPesquisarAirbnb = new javax.swing.JButton();
        jPanelPassagemAerea = new javax.swing.JPanel();
        jLabelDecolar = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jButtonPesquisarDecolar = new javax.swing.JButton();
        jMenuBar = new javax.swing.JMenuBar();
        jMenuPaginaInicial = new javax.swing.JMenu();
        jMenuRoteiro = new javax.swing.JMenu();
        jMenuItemCriar = new javax.swing.JMenuItem();
        jMenuItemExibir = new javax.swing.JMenuItem();
        jMenuViagem = new javax.swing.JMenu();
        jMenuItemListaLugares = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Travel around the World");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel.setBackground(new java.awt.Color(255, 255, 255));
        jPanel.setLayout(null);

        background.setIcon(new javax.swing.ImageIcon("C:\\Users\\natha\\OneDrive\\Documentos\\NetBeansProjects\\Viagens\\img\\backgroundInicio.png")); // NOI18N
        jPanel.add(background);
        background.setBounds(0, 320, 1020, 270);

        jPanelCotacao.setBackground(new java.awt.Color(255, 255, 255));
        jPanelCotacao.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Cotação", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe Print", 1, 25))); // NOI18N

        jLabelEuro.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabelEuro.setText("EUR 1 = R$ 4,543371");

        jLabelDolar.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabelDolar.setText("US$ 1 = R$ 4,086690");

        jLabelLibra.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabelLibra.setText("£ 1 = R$ 5,264455");

        javax.swing.GroupLayout jPanelCotacaoLayout = new javax.swing.GroupLayout(jPanelCotacao);
        jPanelCotacao.setLayout(jPanelCotacaoLayout);
        jPanelCotacaoLayout.setHorizontalGroup(
            jPanelCotacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelCotacaoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelCotacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelEuro)
                    .addComponent(jLabelDolar)
                    .addComponent(jLabelLibra))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelCotacaoLayout.setVerticalGroup(
            jPanelCotacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelCotacaoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelEuro)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabelDolar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabelLibra)
                .addContainerGap(25, Short.MAX_VALUE))
        );

        jPanel.add(jPanelCotacao);
        jPanelCotacao.setBounds(810, 10, 155, 160);

        jPanelSeguroViagem.setBackground(new java.awt.Color(255, 255, 255));
        jPanelSeguroViagem.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Seguro Viagem", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe Print", 1, 25))); // NOI18N

        jLabelSeguroViagem.setIcon(new javax.swing.ImageIcon("C:\\Users\\natha\\OneDrive\\Documentos\\NetBeansProjects\\Viagens\\img\\realSeguroViagem.png")); // NOI18N

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel2.setText("A Real Seguro Viagem é uma em-");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel3.setText("presa comparadora de preços");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel4.setText("entre as melhores seguradoras e");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel5.setText("assistências de viagens. Ela tem ");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel6.setText("acordos comerciais com a Assist -");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel7.setText("Card, GTA, Travel Ace e mais.");

        jButtonFazerCotacao.setText("Fazer Cotação");
        jButtonFazerCotacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonFazerCotacaoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelSeguroViagemLayout = new javax.swing.GroupLayout(jPanelSeguroViagem);
        jPanelSeguroViagem.setLayout(jPanelSeguroViagemLayout);
        jPanelSeguroViagemLayout.setHorizontalGroup(
            jPanelSeguroViagemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelSeguroViagemLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelSeguroViagemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelSeguroViagem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanelSeguroViagemLayout.createSequentialGroup()
                        .addGroup(jPanelSeguroViagemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelSeguroViagemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7))
                        .addGap(0, 2, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jPanelSeguroViagemLayout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addComponent(jButtonFazerCotacao)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelSeguroViagemLayout.setVerticalGroup(
            jPanelSeguroViagemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelSeguroViagemLayout.createSequentialGroup()
                .addComponent(jLabelSeguroViagem, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addGap(11, 11, 11)
                .addComponent(jButtonFazerCotacao, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel.add(jPanelSeguroViagem);
        jPanelSeguroViagem.setBounds(30, 10, 230, 290);

        jPanelHospedagem.setBackground(new java.awt.Color(255, 255, 255));
        jPanelHospedagem.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Hospedagem", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe Print", 1, 25))); // NOI18N

        jLabelAirbnb.setIcon(new javax.swing.ImageIcon("C:\\Users\\natha\\OneDrive\\Documentos\\NetBeansProjects\\Viagens\\img\\airbnb.jpg")); // NOI18N

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel1.setText("O Airbnb é o site perfeito para ");

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel9.setText("quem quer viajar o mundo. Ele co-");

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel10.setText("necta hóspedes e afitriões que alu-");

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel11.setText("gam suas casas.");

        jButtonPesquisarAirbnb.setText("Pesquisar no Airbnb");
        jButtonPesquisarAirbnb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPesquisarAirbnbActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelHospedagemLayout = new javax.swing.GroupLayout(jPanelHospedagem);
        jPanelHospedagem.setLayout(jPanelHospedagemLayout);
        jPanelHospedagemLayout.setHorizontalGroup(
            jPanelHospedagemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelHospedagemLayout.createSequentialGroup()
                .addGroup(jPanelHospedagemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelHospedagemLayout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(jLabelAirbnb))
                    .addGroup(jPanelHospedagemLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1))
                    .addGroup(jPanelHospedagemLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel9))
                    .addGroup(jPanelHospedagemLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel10))
                    .addGroup(jPanelHospedagemLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel11))
                    .addGroup(jPanelHospedagemLayout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addComponent(jButtonPesquisarAirbnb)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelHospedagemLayout.setVerticalGroup(
            jPanelHospedagemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelHospedagemLayout.createSequentialGroup()
                .addComponent(jLabelAirbnb, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel11)
                .addGap(55, 55, 55)
                .addComponent(jButtonPesquisarAirbnb, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel.add(jPanelHospedagem);
        jPanelHospedagem.setBounds(290, 10, 230, 290);

        jPanelPassagemAerea.setBackground(new java.awt.Color(255, 255, 255));
        jPanelPassagemAerea.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Passagem Aérea", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe Print", 1, 25))); // NOI18N

        jLabelDecolar.setIcon(new javax.swing.ImageIcon("C:\\Users\\natha\\OneDrive\\Documentos\\NetBeansProjects\\Viagens\\img\\decolar.jpg")); // NOI18N

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel13.setText("Crie alertas de voos e encontre");

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel14.setText("preços legais de passagens e até");

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel15.setText("pacotes de viagens.");

        jButtonPesquisarDecolar.setText("Pesquisar na Decolar");
        jButtonPesquisarDecolar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPesquisarDecolarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelPassagemAereaLayout = new javax.swing.GroupLayout(jPanelPassagemAerea);
        jPanelPassagemAerea.setLayout(jPanelPassagemAereaLayout);
        jPanelPassagemAereaLayout.setHorizontalGroup(
            jPanelPassagemAereaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelPassagemAereaLayout.createSequentialGroup()
                .addGroup(jPanelPassagemAereaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelPassagemAereaLayout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(jLabelDecolar))
                    .addGroup(jPanelPassagemAereaLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel13))
                    .addGroup(jPanelPassagemAereaLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel14))
                    .addGroup(jPanelPassagemAereaLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel15))
                    .addGroup(jPanelPassagemAereaLayout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addComponent(jButtonPesquisarDecolar)))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        jPanelPassagemAereaLayout.setVerticalGroup(
            jPanelPassagemAereaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelPassagemAereaLayout.createSequentialGroup()
                .addComponent(jLabelDecolar, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 79, Short.MAX_VALUE)
                .addComponent(jButtonPesquisarDecolar, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel.add(jPanelPassagemAerea);
        jPanelPassagemAerea.setBounds(550, 10, 230, 290);

        jMenuBar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(74, 39, 72)));
        jMenuBar.setPreferredSize(new java.awt.Dimension(225, 35));

        jMenuPaginaInicial.setIcon(new javax.swing.ImageIcon("C:\\Users\\natha\\OneDrive\\Documentos\\NetBeansProjects\\Viagens\\img\\home.png")); // NOI18N
        jMenuPaginaInicial.setText("Página Inicial");
        jMenuBar.add(jMenuPaginaInicial);

        jMenuRoteiro.setIcon(new javax.swing.ImageIcon("C:\\Users\\natha\\OneDrive\\Documentos\\NetBeansProjects\\Viagens\\img\\script.png")); // NOI18N
        jMenuRoteiro.setText("Roteiro");

        jMenuItemCriar.setIcon(new javax.swing.ImageIcon("C:\\Users\\natha\\OneDrive\\Documentos\\NetBeansProjects\\Viagens\\img\\add.png")); // NOI18N
        jMenuItemCriar.setText("Criar");
        jMenuItemCriar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemCriarActionPerformed(evt);
            }
        });
        jMenuRoteiro.add(jMenuItemCriar);

        jMenuItemExibir.setIcon(new javax.swing.ImageIcon("C:\\Users\\natha\\OneDrive\\Documentos\\NetBeansProjects\\Viagens\\img\\view.png")); // NOI18N
        jMenuItemExibir.setText("Exibir");
        jMenuItemExibir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemExibirActionPerformed(evt);
            }
        });
        jMenuRoteiro.add(jMenuItemExibir);

        jMenuBar.add(jMenuRoteiro);

        jMenuViagem.setIcon(new javax.swing.ImageIcon("C:\\Users\\natha\\OneDrive\\Documentos\\NetBeansProjects\\Viagens\\img\\travel.png")); // NOI18N
        jMenuViagem.setText("Para onde Viajar?");

        jMenuItemListaLugares.setIcon(new javax.swing.ImageIcon("C:\\Users\\natha\\OneDrive\\Documentos\\NetBeansProjects\\Viagens\\img\\list.png")); // NOI18N
        jMenuItemListaLugares.setText("Lista de Lugares");
        jMenuItemListaLugares.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemListaLugaresActionPerformed(evt);
            }
        });
        jMenuViagem.add(jMenuItemListaLugares);

        jMenuBar.add(jMenuViagem);

        jMenu1.setIcon(new javax.swing.ImageIcon("C:\\Users\\natha\\OneDrive\\Documentos\\NetBeansProjects\\Viagens\\img\\logout.png")); // NOI18N
        jMenu1.setText("Sair");
        jMenu1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu1MouseClicked(evt);
            }
        });
        jMenuBar.add(jMenu1);

        setJMenuBar(jMenuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 1000, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 636, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItemCriarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemCriarActionPerformed
        new TelaCriarRoteiro().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jMenuItemCriarActionPerformed

    private void jMenuItemExibirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemExibirActionPerformed
        new TelaExibirTodosRoteiros().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jMenuItemExibirActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        this.setIconImage(new ImageIcon("C:/Users/natha/OneDrive/Documentos/NetBeansProjects/Viagens/img/travel.png").getImage());
    }//GEN-LAST:event_formWindowOpened

    private void jButtonFazerCotacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonFazerCotacaoActionPerformed
        //Cria um objeto Desktop vazio
        Desktop desktop = null;
        
        //Cria um objeto URI vazio
        URI uri = null;
        
        try{
            //Inicia a variável desktop, recebendo a area de trabalho do navegador
            desktop = Desktop.getDesktop();
            
            //Inicia a variável URI com uma endereço http
            uri = new URI("https://www.seguroviagem.srv.br/");

            //Manda o desktop abrir a url criada acima
            desktop.browse(uri);
        }catch(URISyntaxException erroUri){
            System.out.println("Erro ao criar a url!");
        }catch(IOException desktopErro){
            System.out.println("Erro ao abrir o navegador com o endereço informado!");
        }
    }//GEN-LAST:event_jButtonFazerCotacaoActionPerformed

    private void jButtonPesquisarAirbnbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPesquisarAirbnbActionPerformed
        Desktop desktop = null;
        
        URI uri = null;
        
        try{
            desktop = Desktop.getDesktop();
            
            uri = new URI("https://www.airbnb.com.br/");

            desktop.browse(uri);
        }catch(URISyntaxException erroUri){
            System.out.println("Erro ao criar a url!");
        }catch(IOException desktopErro){
            System.out.println("Erro ao abrir o navegador com o endereço informado!");
        }
    }//GEN-LAST:event_jButtonPesquisarAirbnbActionPerformed

    private void jButtonPesquisarDecolarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPesquisarDecolarActionPerformed
        Desktop desktop = null;
        
        URI uri = null;
        
        try{
            desktop = Desktop.getDesktop();
            
            uri = new URI("https://www.decolar.com/");

            desktop.browse(uri);
        }catch(URISyntaxException erroUri){
            System.out.println("Erro ao criar a url!");
        }catch(IOException desktopErro){
            System.out.println("Erro ao abrir o navegador com o endereço informado!");
        }
    }//GEN-LAST:event_jButtonPesquisarDecolarActionPerformed

    private void jMenuItemListaLugaresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemListaLugaresActionPerformed
        new TelaContinentes().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jMenuItemListaLugaresActionPerformed

    private void jMenu1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu1MouseClicked
        new TelaLogin().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jMenu1MouseClicked

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
            java.util.logging.Logger.getLogger(TelaInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaInicial().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel background;
    private javax.swing.JButton jButtonFazerCotacao;
    private javax.swing.JButton jButtonPesquisarAirbnb;
    private javax.swing.JButton jButtonPesquisarDecolar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelAirbnb;
    private javax.swing.JLabel jLabelDecolar;
    private javax.swing.JLabel jLabelDolar;
    private javax.swing.JLabel jLabelEuro;
    private javax.swing.JLabel jLabelLibra;
    private javax.swing.JLabel jLabelSeguroViagem;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar;
    private javax.swing.JMenuItem jMenuItemCriar;
    private javax.swing.JMenuItem jMenuItemExibir;
    private javax.swing.JMenuItem jMenuItemListaLugares;
    private javax.swing.JMenu jMenuPaginaInicial;
    private javax.swing.JMenu jMenuRoteiro;
    private javax.swing.JMenu jMenuViagem;
    private javax.swing.JPanel jPanel;
    private javax.swing.JPanel jPanelCotacao;
    private javax.swing.JPanel jPanelHospedagem;
    private javax.swing.JPanel jPanelPassagemAerea;
    private javax.swing.JPanel jPanelSeguroViagem;
    // End of variables declaration//GEN-END:variables
}
