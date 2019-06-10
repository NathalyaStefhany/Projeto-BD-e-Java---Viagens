package br.inatel.viagens.view;

/**
 * @author Nathalya
 * 
 */

import br.inatel.viagens.model.dao.LugaresDAO;
import java.util.TimeZone;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class TelaListaLugaresAdmin extends javax.swing.JFrame {
    //Creates new form TelaInicial
    public TelaListaLugaresAdmin() {
        initComponents();
        
        setSize(1000, 650);
        setResizable(false);
        setLocationRelativeTo(null);
        
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
        jPanelAmericaNorte = new javax.swing.JPanel();
        jScrollPaneAmericaNorte = new javax.swing.JScrollPane();
        jTableAmericaNorte = new javax.swing.JTable();
        jPanelAmericaSul = new javax.swing.JPanel();
        jScrollPaneAmericaSul = new javax.swing.JScrollPane();
        jTableAmericaSul = new javax.swing.JTable();
        jPanelEuropa = new javax.swing.JPanel();
        jScrollPaneEuropa = new javax.swing.JScrollPane();
        jTableEuropa = new javax.swing.JTable();
        jPanelAfrica = new javax.swing.JPanel();
        jScrollPaneAfrica = new javax.swing.JScrollPane();
        jTableAfrica = new javax.swing.JTable();
        jPanelOceania = new javax.swing.JPanel();
        jScrollPaneOceania = new javax.swing.JScrollPane();
        jTableOceania = new javax.swing.JTable();
        jPanelAsia = new javax.swing.JPanel();
        jScrollPaneAsia = new javax.swing.JScrollPane();
        jTableAsia = new javax.swing.JTable();
        jLabelAmericaNorte = new javax.swing.JLabel();
        jLabelAmericaSul = new javax.swing.JLabel();
        jLabelEuropa = new javax.swing.JLabel();
        jLabelAfrica = new javax.swing.JLabel();
        jLabelOceania = new javax.swing.JLabel();
        jLabelÁsia = new javax.swing.JLabel();
        jButtonVisuzalizar = new javax.swing.JButton();
        jButtonEditar = new javax.swing.JButton();
        jButtonExcluir = new javax.swing.JButton();
        jMenuBar = new javax.swing.JMenuBar();
        jMenuPaginaInicial = new javax.swing.JMenu();
        jMenuViagem = new javax.swing.JMenu();
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

        jPanelAmericaNorte.setMinimumSize(new java.awt.Dimension(350, 150));
        jPanelAmericaNorte.setPreferredSize(new java.awt.Dimension(300, 300));

        jTableAmericaNorte.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Destino"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableAmericaNorte.setRowHeight(30);
        jTableAmericaNorte.setSelectionBackground(new java.awt.Color(74, 39, 72));
        jTableAmericaNorte.getTableHeader().setReorderingAllowed(false);
        jScrollPaneAmericaNorte.setViewportView(jTableAmericaNorte);

        javax.swing.GroupLayout jPanelAmericaNorteLayout = new javax.swing.GroupLayout(jPanelAmericaNorte);
        jPanelAmericaNorte.setLayout(jPanelAmericaNorteLayout);
        jPanelAmericaNorteLayout.setHorizontalGroup(
            jPanelAmericaNorteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelAmericaNorteLayout.createSequentialGroup()
                .addComponent(jScrollPaneAmericaNorte, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 51, Short.MAX_VALUE))
        );
        jPanelAmericaNorteLayout.setVerticalGroup(
            jPanelAmericaNorteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelAmericaNorteLayout.createSequentialGroup()
                .addComponent(jScrollPaneAmericaNorte, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 1, Short.MAX_VALUE))
        );

        jPanel.add(jPanelAmericaNorte);
        jPanelAmericaNorte.setBounds(30, 80, 300, 150);

        jTableAmericaSul.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Destino"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableAmericaSul.setRowHeight(30);
        jTableAmericaSul.setSelectionBackground(new java.awt.Color(74, 39, 72));
        jTableAmericaSul.getTableHeader().setReorderingAllowed(false);
        jScrollPaneAmericaSul.setViewportView(jTableAmericaSul);

        javax.swing.GroupLayout jPanelAmericaSulLayout = new javax.swing.GroupLayout(jPanelAmericaSul);
        jPanelAmericaSul.setLayout(jPanelAmericaSulLayout);
        jPanelAmericaSulLayout.setHorizontalGroup(
            jPanelAmericaSulLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelAmericaSulLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jScrollPaneAmericaSul, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanelAmericaSulLayout.setVerticalGroup(
            jPanelAmericaSulLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelAmericaSulLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jScrollPaneAmericaSul, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel.add(jPanelAmericaSul);
        jPanelAmericaSul.setBounds(350, 80, 300, 150);

        jTableEuropa.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Destino"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableEuropa.setInheritsPopupMenu(true);
        jTableEuropa.setRowHeight(30);
        jTableEuropa.setSelectionBackground(new java.awt.Color(74, 39, 72));
        jTableEuropa.getTableHeader().setReorderingAllowed(false);
        jScrollPaneEuropa.setViewportView(jTableEuropa);

        javax.swing.GroupLayout jPanelEuropaLayout = new javax.swing.GroupLayout(jPanelEuropa);
        jPanelEuropa.setLayout(jPanelEuropaLayout);
        jPanelEuropaLayout.setHorizontalGroup(
            jPanelEuropaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelEuropaLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jScrollPaneEuropa, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanelEuropaLayout.setVerticalGroup(
            jPanelEuropaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelEuropaLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jScrollPaneEuropa, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel.add(jPanelEuropa);
        jPanelEuropa.setBounds(670, 80, 300, 150);

        jTableAfrica.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Destino"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableAfrica.setRowHeight(30);
        jTableAfrica.setSelectionBackground(new java.awt.Color(74, 39, 72));
        jTableAfrica.getTableHeader().setReorderingAllowed(false);
        jScrollPaneAfrica.setViewportView(jTableAfrica);

        javax.swing.GroupLayout jPanelAfricaLayout = new javax.swing.GroupLayout(jPanelAfrica);
        jPanelAfrica.setLayout(jPanelAfricaLayout);
        jPanelAfricaLayout.setHorizontalGroup(
            jPanelAfricaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPaneAfrica, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
        );
        jPanelAfricaLayout.setVerticalGroup(
            jPanelAfricaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPaneAfrica, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
        );

        jPanel.add(jPanelAfrica);
        jPanelAfrica.setBounds(30, 350, 300, 150);

        jTableOceania.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Destino"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableOceania.setRowHeight(30);
        jTableOceania.setSelectionBackground(new java.awt.Color(74, 39, 72));
        jTableOceania.getTableHeader().setReorderingAllowed(false);
        jScrollPaneOceania.setViewportView(jTableOceania);

        javax.swing.GroupLayout jPanelOceaniaLayout = new javax.swing.GroupLayout(jPanelOceania);
        jPanelOceania.setLayout(jPanelOceaniaLayout);
        jPanelOceaniaLayout.setHorizontalGroup(
            jPanelOceaniaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPaneOceania, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
        );
        jPanelOceaniaLayout.setVerticalGroup(
            jPanelOceaniaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPaneOceania, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
        );

        jPanel.add(jPanelOceania);
        jPanelOceania.setBounds(350, 350, 300, 150);

        jTableAsia.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Destino"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableAsia.setRowHeight(30);
        jTableAsia.setSelectionBackground(new java.awt.Color(74, 39, 72));
        jTableAsia.getTableHeader().setReorderingAllowed(false);
        jScrollPaneAsia.setViewportView(jTableAsia);

        javax.swing.GroupLayout jPanelAsiaLayout = new javax.swing.GroupLayout(jPanelAsia);
        jPanelAsia.setLayout(jPanelAsiaLayout);
        jPanelAsiaLayout.setHorizontalGroup(
            jPanelAsiaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPaneAsia, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
        );
        jPanelAsiaLayout.setVerticalGroup(
            jPanelAsiaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelAsiaLayout.createSequentialGroup()
                .addComponent(jScrollPaneAsia, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel.add(jPanelAsia);
        jPanelAsia.setBounds(670, 350, 300, 150);

        jLabelAmericaNorte.setFont(new java.awt.Font("Segoe Print", 1, 30)); // NOI18N
        jLabelAmericaNorte.setText("América do Norte");
        jPanel.add(jLabelAmericaNorte);
        jLabelAmericaNorte.setBounds(30, 20, 290, 54);

        jLabelAmericaSul.setFont(new java.awt.Font("Segoe Print", 1, 30)); // NOI18N
        jLabelAmericaSul.setText("América do Sul");
        jPanel.add(jLabelAmericaSul);
        jLabelAmericaSul.setBounds(350, 20, 290, 54);

        jLabelEuropa.setFont(new java.awt.Font("Segoe Print", 1, 30)); // NOI18N
        jLabelEuropa.setText("Europa");
        jPanel.add(jLabelEuropa);
        jLabelEuropa.setBounds(670, 20, 190, 54);

        jLabelAfrica.setFont(new java.awt.Font("Segoe Print", 1, 30)); // NOI18N
        jLabelAfrica.setText("África");
        jPanel.add(jLabelAfrica);
        jLabelAfrica.setBounds(30, 290, 130, 54);

        jLabelOceania.setFont(new java.awt.Font("Segoe Print", 1, 30)); // NOI18N
        jLabelOceania.setText("Oceania");
        jPanel.add(jLabelOceania);
        jLabelOceania.setBounds(350, 290, 120, 50);

        jLabelÁsia.setFont(new java.awt.Font("Segoe Print", 1, 30)); // NOI18N
        jLabelÁsia.setText("Ásia");
        jPanel.add(jLabelÁsia);
        jLabelÁsia.setBounds(670, 290, 63, 60);

        jButtonVisuzalizar.setIcon(new javax.swing.ImageIcon("C:\\Users\\natha\\OneDrive\\Documentos\\NetBeansProjects\\Viagens\\img\\view.png")); // NOI18N
        jButtonVisuzalizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonVisuzalizarActionPerformed(evt);
            }
        });
        jPanel.add(jButtonVisuzalizar);
        jButtonVisuzalizar.setBounds(400, 250, 30, 30);

        jButtonEditar.setIcon(new javax.swing.ImageIcon("C:\\Users\\natha\\OneDrive\\Documentos\\NetBeansProjects\\Viagens\\img\\edit.png")); // NOI18N
        jButtonEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEditarActionPerformed(evt);
            }
        });
        jPanel.add(jButtonEditar);
        jButtonEditar.setBounds(440, 250, 30, 30);

        jButtonExcluir.setIcon(new javax.swing.ImageIcon("C:\\Users\\natha\\OneDrive\\Documentos\\NetBeansProjects\\Viagens\\img\\delete.png")); // NOI18N
        jButtonExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonExcluirActionPerformed(evt);
            }
        });
        jPanel.add(jButtonExcluir);
        jButtonExcluir.setBounds(480, 250, 30, 30);

        jMenuBar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(74, 39, 72)));
        jMenuBar.setPreferredSize(new java.awt.Dimension(225, 35));

        jMenuPaginaInicial.setIcon(new javax.swing.ImageIcon("C:\\Users\\natha\\OneDrive\\Documentos\\NetBeansProjects\\Viagens\\img\\home.png")); // NOI18N
        jMenuPaginaInicial.setText("Página Inicial");
        jMenuBar.add(jMenuPaginaInicial);

        jMenuViagem.setIcon(new javax.swing.ImageIcon("C:\\Users\\natha\\OneDrive\\Documentos\\NetBeansProjects\\Viagens\\img\\travel.png")); // NOI18N
        jMenuViagem.setText("Para onde Viajar?");
        jMenuViagem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenuViagemMouseClicked(evt);
            }
        });
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

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        LugaresDAO dao = new LugaresDAO();
        
        jTableAmericaNorte.setModel(dao.buscarDestinos(1));
        
        jTableAmericaNorte.getColumnModel().getColumn(0).setMinWidth(0);
        jTableAmericaNorte.getColumnModel().getColumn(0).setMaxWidth(0);
        jTableAmericaNorte.getColumnModel().getColumn(0).setWidth(0);
        
        jTableAmericaSul.setModel(dao.buscarDestinos(2));
        
        jTableAmericaSul.getColumnModel().getColumn(0).setMinWidth(0);
        jTableAmericaSul.getColumnModel().getColumn(0).setMaxWidth(0);
        jTableAmericaSul.getColumnModel().getColumn(0).setWidth(0);
        
        jTableEuropa.setModel(dao.buscarDestinos(3));
        
        jTableEuropa.getColumnModel().getColumn(0).setMinWidth(0);
        jTableEuropa.getColumnModel().getColumn(0).setMaxWidth(0);
        jTableEuropa.getColumnModel().getColumn(0).setWidth(0);
        
        jTableAfrica.setModel(dao.buscarDestinos(4));
        
        jTableAfrica.getColumnModel().getColumn(0).setMinWidth(0);
        jTableAfrica.getColumnModel().getColumn(0).setMaxWidth(0);
        jTableAfrica.getColumnModel().getColumn(0).setWidth(0);
        
        jTableOceania.setModel(dao.buscarDestinos(5));
        
        jTableOceania.getColumnModel().getColumn(0).setMinWidth(0);
        jTableOceania.getColumnModel().getColumn(0).setMaxWidth(0);
        jTableOceania.getColumnModel().getColumn(0).setWidth(0);
        
        jTableAsia.setModel(dao.buscarDestinos(6));
        
        jTableAsia.getColumnModel().getColumn(0).setMinWidth(0);
        jTableAsia.getColumnModel().getColumn(0).setMaxWidth(0);
        jTableAsia.getColumnModel().getColumn(0).setWidth(0);
        
        this.setIconImage(new ImageIcon("C:/Users/natha/OneDrive/Documentos/NetBeansProjects/Viagens/img/travel.png").getImage());
    }//GEN-LAST:event_formWindowOpened

    private void jMenuViagemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuViagemMouseClicked
        new TelaCriarLugaresAdmin().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jMenuViagemMouseClicked

    private void jButtonVisuzalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonVisuzalizarActionPerformed
        if(jTableAmericaNorte.getSelectedRow() != -1){
            int linha = jTableAmericaNorte.getSelectedRow();
            
            String destino = String.valueOf(jTableAmericaNorte.getValueAt(linha, 1));
            int idDestino = Integer.parseInt(String.valueOf(jTableAmericaNorte.getValueAt(linha, 0)));
            String idContinente = "1";
            
            new TelaExibirLugar(destino, idDestino, idContinente, true).setVisible(true);
            this.dispose();
        }
        
        else if(jTableAmericaSul.getSelectedRow() != -1){
            int linha = jTableAmericaSul.getSelectedRow();
            
            String destino = String.valueOf(jTableAmericaSul.getValueAt(linha, 1));
            int idDestino = Integer.parseInt(String.valueOf(jTableAmericaSul.getValueAt(linha, 0)));
            String idContinente = "2";
            
            new TelaExibirLugar(destino, idDestino, idContinente, true).setVisible(true);
            this.dispose();
        }
        
        else if(jTableEuropa.getSelectedRow() != -1){
            int linha = jTableEuropa.getSelectedRow();
            
            String destino = String.valueOf(jTableEuropa.getValueAt(linha, 1));
            int idDestino = Integer.parseInt(String.valueOf(jTableEuropa.getValueAt(linha, 0)));
            String idContinente = "3";
            
            new TelaExibirLugar(destino, idDestino, idContinente, true).setVisible(true);
            this.dispose();
        }
        
        else if(jTableAfrica.getSelectedRow() != -1){
            int linha = jTableAfrica.getSelectedRow();
            
            String destino = String.valueOf(jTableAfrica.getValueAt(linha, 1));
            int idDestino = Integer.parseInt(String.valueOf(jTableAfrica.getValueAt(linha, 0)));
            String idContinente = "4";
            
            new TelaExibirLugar(destino, idDestino, idContinente, true).setVisible(true);
            this.dispose();
        }
        
        else if(jTableOceania.getSelectedRow() != -1){
            int linha = jTableOceania.getSelectedRow();
            
            String destino = String.valueOf(jTableOceania.getValueAt(linha, 1));
            int idDestino = Integer.parseInt(String.valueOf(jTableOceania.getValueAt(linha, 0)));
            String idContinente = "5";
            
            new TelaExibirLugar(destino, idDestino, idContinente, true).setVisible(true);
            this.dispose();
        }
        
        else if(jTableAsia.getSelectedRow() != -1){
            int linha = jTableAsia.getSelectedRow();
            
            String destino = String.valueOf(jTableAsia.getValueAt(linha, 1));
            int idDestino = Integer.parseInt(String.valueOf(jTableAsia.getValueAt(linha, 0)));
            String idContinente = "6";
            
            new TelaExibirLugar(destino, idDestino, idContinente, true).setVisible(true);
            this.dispose();
        }
        
        else{
            JOptionPane.showMessageDialog(null, "Selecione um destino!");
        }
    }//GEN-LAST:event_jButtonVisuzalizarActionPerformed

    private void jButtonEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEditarActionPerformed
        if(jTableAmericaNorte.getSelectedRow() != -1){
            int linha = jTableAmericaNorte.getSelectedRow();
            
            String idDestino = String.valueOf(jTableAmericaNorte.getValueAt(linha, 0));
            String destino = String.valueOf(jTableAmericaNorte.getValueAt(linha, 1));
            
            new TelaEditarLugaresAdmin(idDestino, destino).setVisible(true);
            this.dispose();
        }
        
        else if(jTableAmericaSul.getSelectedRow() != -1){
            int linha = jTableAmericaSul.getSelectedRow();
            
            String idDestino = String.valueOf(jTableAmericaSul.getValueAt(linha, 0));
            String destino = String.valueOf(jTableAmericaSul.getValueAt(linha, 1));
            
            new TelaEditarLugaresAdmin(idDestino, destino).setVisible(true);
            this.dispose();
        }
        
        else if(jTableEuropa.getSelectedRow() != -1){
            int linha = jTableEuropa.getSelectedRow();
            
            String idDestino = String.valueOf(jTableEuropa.getValueAt(linha, 0));
            String destino = String.valueOf(jTableEuropa.getValueAt(linha, 1));
            
            new TelaEditarLugaresAdmin(idDestino, destino).setVisible(true);
            this.dispose();
        }
        
        else if(jTableAfrica.getSelectedRow() != -1){
            int linha = jTableAfrica.getSelectedRow();
            
            String idDestino = String.valueOf(jTableAfrica.getValueAt(linha, 0));
            String destino = String.valueOf(jTableAfrica.getValueAt(linha, 1));
            
            new TelaEditarLugaresAdmin(idDestino, destino).setVisible(true);
            this.dispose();
        }
        
        else if(jTableOceania.getSelectedRow() != -1){
            int linha = jTableOceania.getSelectedRow();
            
            String idDestino = String.valueOf(jTableOceania.getValueAt(linha, 0));
            String destino = String.valueOf(jTableOceania.getValueAt(linha, 1));
            
            new TelaEditarLugaresAdmin(idDestino, destino).setVisible(true);
            this.dispose();
        }
        
        else if(jTableAsia.getSelectedRow() != -1){
            int linha = jTableAsia.getSelectedRow();
            
            String idDestino = String.valueOf(jTableAsia.getValueAt(linha, 0));
            String destino = String.valueOf(jTableAsia.getValueAt(linha, 1));
            
            new TelaEditarLugaresAdmin(idDestino, destino).setVisible(true);
            this.dispose();
        }
        
        else{
            JOptionPane.showMessageDialog(null, "Selecione um destino!");
        }
    }//GEN-LAST:event_jButtonEditarActionPerformed

    private void jButtonExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonExcluirActionPerformed
        LugaresDAO dao = new LugaresDAO();
        
        int id;
        int linha;
        
        if(jTableAmericaNorte.getSelectedRow() != -1){
            int i = JOptionPane.showConfirmDialog(null, "Deseja excluir o destino?", "Excluir", 0);
            
            if(i == 0){
                linha = jTableAmericaNorte.getSelectedRow();
                
                id = Integer.parseInt(jTableAmericaNorte.getValueAt(linha, 0).toString());

                if(dao.removerLugar(id)){
                    ((DefaultTableModel)jTableAmericaNorte.getModel()).removeRow(linha);
                    
                    JOptionPane.showMessageDialog(null, "Remoção realizada com sucesso!");
                }
                else{
                    JOptionPane.showMessageDialog(null, "Erro ao remover o roteiro!");
                }
            }
        }
        
        else if(jTableAmericaSul.getSelectedRow() != -1){
            int i = JOptionPane.showConfirmDialog(null, "Deseja excluir o destino?", "Excluir", 0);
            
            if(i == 0){
                linha = jTableAmericaSul.getSelectedRow();
                
                id = Integer.parseInt(jTableAmericaSul.getValueAt(linha, 0).toString());

                if(dao.removerLugar(id)){
                    ((DefaultTableModel)jTableAmericaSul.getModel()).removeRow(linha);
                    
                    JOptionPane.showMessageDialog(null, "Remoção realizada com sucesso!");
                }
                else{
                    JOptionPane.showMessageDialog(null, "Erro ao remover o roteiro!");
                }
            }
        }
        
        else if(jTableEuropa.getSelectedRow() != -1){
            int i = JOptionPane.showConfirmDialog(null, "Deseja excluir o destino?", "Excluir", 0);
            
            if(i == 0){
                linha = jTableEuropa.getSelectedRow();
                
                id = Integer.parseInt(jTableEuropa.getValueAt(linha, 0).toString());

                if(dao.removerLugar(id)){
                    ((DefaultTableModel)jTableEuropa.getModel()).removeRow(linha);
                    
                    JOptionPane.showMessageDialog(null, "Remoção realizada com sucesso!");
                }
                else{
                    JOptionPane.showMessageDialog(null, "Erro ao remover o roteiro!");
                }
            }
        }
        
        else if(jTableAfrica.getSelectedRow() != -1){
            int i = JOptionPane.showConfirmDialog(null, "Deseja excluir o destino?", "Excluir", 0);
            
            if(i == 0){
                linha = jTableAfrica.getSelectedRow();
                
                id = Integer.parseInt(jTableAfrica.getValueAt(linha, 0).toString());

                if(dao.removerLugar(id)){
                    ((DefaultTableModel)jTableAfrica.getModel()).removeRow(linha);
                    
                    JOptionPane.showMessageDialog(null, "Remoção realizada com sucesso!");
                }
                else{
                    JOptionPane.showMessageDialog(null, "Erro ao remover o roteiro!");
                }
            }
        }
        
        else if(jTableOceania.getSelectedRow() != -1){
            int i = JOptionPane.showConfirmDialog(null, "Deseja excluir o destino?", "Excluir", 0);
            
            if(i == 0){
                linha = jTableOceania.getSelectedRow();
                
                id = Integer.parseInt(jTableOceania.getValueAt(linha, 0).toString());

                if(dao.removerLugar(id)){
                    ((DefaultTableModel)jTableOceania.getModel()).removeRow(linha);
                    
                    JOptionPane.showMessageDialog(null, "Remoção realizada com sucesso!");
                }
                else{
                    JOptionPane.showMessageDialog(null, "Erro ao remover o roteiro!");
                }
            }
        }
        
        else if(jTableAsia.getSelectedRow() != -1){
            int i = JOptionPane.showConfirmDialog(null, "Deseja excluir o destino?", "Excluir", 0);
            
            if(i == 0){
                linha = jTableAsia.getSelectedRow();
                
                id = Integer.parseInt(jTableAsia.getValueAt(linha, 0).toString());

                if(dao.removerLugar(id)){
                    ((DefaultTableModel)jTableAsia.getModel()).removeRow(linha);
                    
                    JOptionPane.showMessageDialog(null, "Remoção realizada com sucesso!");
                }
                else{
                    JOptionPane.showMessageDialog(null, "Erro ao remover o roteiro!");
                }
            }
        }
        
        else{
            JOptionPane.showMessageDialog(null, "Selecione um destino!");
        }
    }//GEN-LAST:event_jButtonExcluirActionPerformed

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
            java.util.logging.Logger.getLogger(TelaListaLugaresAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaListaLugaresAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaListaLugaresAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaListaLugaresAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonEditar;
    private javax.swing.JButton jButtonExcluir;
    private javax.swing.JButton jButtonVisuzalizar;
    private javax.swing.JLabel jLabelAfrica;
    private javax.swing.JLabel jLabelAmericaNorte;
    private javax.swing.JLabel jLabelAmericaSul;
    private javax.swing.JLabel jLabelEuropa;
    private javax.swing.JLabel jLabelOceania;
    private javax.swing.JLabel jLabelÁsia;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar;
    private javax.swing.JMenu jMenuPaginaInicial;
    private javax.swing.JMenu jMenuViagem;
    private javax.swing.JPanel jPanel;
    private javax.swing.JPanel jPanelAfrica;
    private javax.swing.JPanel jPanelAmericaNorte;
    private javax.swing.JPanel jPanelAmericaSul;
    private javax.swing.JPanel jPanelAsia;
    private javax.swing.JPanel jPanelEuropa;
    private javax.swing.JPanel jPanelOceania;
    private javax.swing.JScrollPane jScrollPaneAfrica;
    private javax.swing.JScrollPane jScrollPaneAmericaNorte;
    private javax.swing.JScrollPane jScrollPaneAmericaSul;
    private javax.swing.JScrollPane jScrollPaneAsia;
    private javax.swing.JScrollPane jScrollPaneEuropa;
    private javax.swing.JScrollPane jScrollPaneOceania;
    private javax.swing.JTable jTableAfrica;
    private javax.swing.JTable jTableAmericaNorte;
    private javax.swing.JTable jTableAmericaSul;
    private javax.swing.JTable jTableAsia;
    private javax.swing.JTable jTableEuropa;
    private javax.swing.JTable jTableOceania;
    // End of variables declaration//GEN-END:variables
}