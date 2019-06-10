package br.inatel.viagens.view;

import br.inatel.viagens.model.dao.LugaresDAO;
import br.inatel.viagens.model.entities.Lugares;
import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JInternalFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

/**
 * @author Nathalya
 * 
 */
public class JListCustomRenderer extends JInternalFrame{
    //Tamanho da tela
    private int width = 600;
    private int height = 460;
    
    private JList<Lugares> listaLugares;
    
    public JListCustomRenderer() {
        //Adicionando o painel principal
        add(criarPanel());
        //Titulo da tela
        setTitle("Dicas de Lugares para Viajar");
        //Definindo o tamanho
        setSize(width, height);
        //Mostrar a tela
        setVisible(true);
    }
    
    private JPanel criarPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(new EmptyBorder(10, 10, 10, 10));
        
        //Cria a lista e adiciona o scroll
        panel.add(new JScrollPane(listaLugares = criarListaLugares()), BorderLayout.CENTER);
        return panel;
    }
 
    private JList<Lugares> criarListaLugares() {
        DefaultListModel<Lugares> model = new DefaultListModel<>();
        
        //Adiciona os itens no model
        LugaresDAO dao = new LugaresDAO();
        
        List<Lugares> lugares = new ArrayList<>();
        
        lugares = dao.adicionarLugares();
        
        for(int i = 0; i < lugares.size(); i++){
            model.addElement(new Lugares(lugares.get(i).getDestino(), lugares.get(i).getCaminho()));
        }
        
        //Cria uma JList com as informações necessárias
        JList<Lugares> list = new JList<>(model);
        
        list.setCellRenderer(new LugaresRenderer());
        return list;
    }
}