package br.inatel.viagens.view;

import br.inatel.viagens.model.entities.Lugares;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.ListCellRenderer;

/**
 * @author Nathalya
 * 
 */

public class LugaresRenderer extends JPanel implements ListCellRenderer<Lugares> { 
    private JLabel lbImagens = new JLabel();
    private JLabel lbDestino = new JLabel();
    private JLabel lbInfo = new JLabel();
    
    public LugaresRenderer() {
        setLayout(new BorderLayout(5, 5));
 
        JPanel panelText = new JPanel(new GridLayout(0, 1));
        
        panelText.setBackground(Color.white);
        
        panelText.add(lbDestino);
        panelText.add(lbInfo);
        
        add(lbImagens, BorderLayout.WEST);
        add(panelText, BorderLayout.CENTER);
        
        Font fonte = new Font("SansSerif", Font.BOLD, 25);
        lbDestino.setFont(fonte);
    }
 
    @Override
    public Component getListCellRendererComponent(JList<? extends Lugares> list,
        Lugares lugar, int index, boolean isSelected, boolean cellHasFocus) {

        lbImagens.setIcon(new ImageIcon(lugar.getCaminho()));
        lbDestino.setText(lugar.getDestino());
        lbInfo.setText("Clique aqui para mais informação!");
        lbInfo.setForeground(Color.black);
        
        //Setando Opaque para mudar a cor do fundo da label quando selecionada
        lbDestino.setOpaque(true);
        lbInfo.setOpaque(true);
        lbImagens.setOpaque(true);

        //Mudar cor quando selecionado
        if(isSelected){
            lbDestino.setBackground(list.getSelectionBackground());
            lbInfo.setBackground(list.getSelectionBackground());
            lbImagens.setBackground(list.getSelectionBackground());
            setBackground(list.getSelectionBackground());
            
            Lugares.campoSelecionado = list.getSelectedIndex();
        } 
        else{ 
            lbDestino.setBackground(list.getBackground());
            lbInfo.setBackground(list.getBackground());
            lbImagens.setBackground(list.getBackground());
            setBackground(list.getBackground());
        }
        
        return this;
    }
}
