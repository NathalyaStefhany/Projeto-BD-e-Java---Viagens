package br.inatel.viagens.model.dao;

import br.inatel.viagens.controller.ConexaoBD;
import br.inatel.viagens.model.entities.Lugares;
import br.inatel.viagens.model.entities.PontoTuristicoLugares;
import br.inatel.viagens.model.entities.Viagens;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 * @author Nathalya
 * 
 */
public class LugaresDAO {
    ConexaoBD conexao = new ConexaoBD();
    
    public PreparedStatement pst;   
    public Statement st;            
    public ResultSet rs;
    
    DecimalFormat df = new DecimalFormat("0.00");
    
    public List<Lugares> adicionarLugares(){
        conexao.conectarBD();
        
        int idContinente = Lugares.continente;
        
        List<Lugares> lugares = new ArrayList<>();
        
        String sql, query;

        try{
            sql = "select viagens.destino, imagens.caminho from imagens, viagens, continente where viagens_id = viagens.id and continente_id = continente.id and continente.id = ?;";

            pst = conexao.con.prepareStatement(sql);
            
            pst.setInt(1, idContinente);
            
            String aux = pst.toString();
            query = aux.substring(aux.indexOf(": ") + 2, aux.length());
            
            st = conexao.con.createStatement();
            rs = st.executeQuery(query);
            
            while(rs.next()){
                Lugares lugar = new Lugares("", "");
                
                lugar.setDestino(rs.getString("destino"));
                lugar.setCaminho(rs.getString("caminho"));
               
                lugares.add(lugar);
            }
        }catch(SQLException ex){
            System.out.println("Erro: " + ex.getMessage());
        }finally{
            conexao.encerrarConexao(pst);  
        }
        return lugares;
    }
    
    public String buscarDestino(int id){
        conexao.conectarBD();
        
        String destino = "";
        
        String sql = "select destino from viagens where id = ?;";
        
        try{
            pst = conexao.con.prepareStatement(sql);
            
            pst.setInt(1, id);
            
            String aux = pst.toString();
            String query = aux.substring(aux.indexOf(": ") + 2, aux.length());
            
            st = conexao.con.createStatement();
            rs = st.executeQuery(query);
            
            rs.next();
            
            destino = rs.getString("destino");
        }catch(SQLException ex){
            System.out.println("Erro: " + ex.getMessage());
        }finally{
            conexao.encerrarConexao(pst);
        }
        
        return destino;
    }
    
    public Viagens buscarViagem(int id){
        conexao.conectarBD();

        Viagens viagem = new Viagens();
        
        String sql = "select alta_temporada, clima from viagens where id = ?;";
        
        try{
            pst = conexao.con.prepareStatement(sql);
            
            pst.setInt(1, id);
            
            String aux = pst.toString();
            String query = aux.substring(aux.indexOf(": ") + 2, aux.length());
            
            st = conexao.con.createStatement();
            rs = st.executeQuery(query);
            
            rs.next();
            
            viagem.setAltaTemporada(rs.getString("alta_temporada"));
            viagem.setClima(rs.getString("clima"));
        }catch(SQLException ex){
            System.out.println("Erro: " + ex.getMessage());
        }finally{
            conexao.encerrarConexao(pst);
        }
        
        return viagem;
    }
    
    public DefaultTableModel buscarPontoTuristico(int id){
        conexao.conectarBD();
        
        DefaultTableModel tabela = new DefaultTableModel();

        tabela.setColumnIdentifiers(new String[]{"ID", "Nome", "Endereço", "Preço", "Latitude", "Longitude"});
        
        int idLugar = id;

        String sql = "select * from ponto_turistico_viagem, viagem_has_ponto_turistico where viagem_id = ? and ponto_turistico_viagem_id = ponto_turistico_viagem.id order by nome asc";
        
        try{
            pst = conexao.con.prepareStatement(sql);

            pst.setInt(1, idLugar);

            pst.execute();

            String aux = pst.toString();
            String query = aux.substring(aux.indexOf(": ") + 2, aux.length());

            st = conexao.con.createStatement();
            rs = st.executeQuery(query);
            
            while(rs.next()){
                tabela.addRow(new String[]{
                    rs.getString("id"), rs.getString("nome"), rs.getString("endereco"), rs.getString("preco"),
                    df.format(Double.parseDouble(rs.getString("latitude"))), df.format(Double.parseDouble(rs.getString("longitude")))
                });
            }
        }catch(SQLException ex){
            System.out.println("Erro: " + ex.getMessage());
        }finally{
            conexao.encerrarConexao(pst);  
        }
        
        return tabela;
    }
    
    public DefaultTableModel buscarDestinos(int id){
        conexao.conectarBD();
        
        DefaultTableModel tabela = new DefaultTableModel();

        tabela.setColumnIdentifiers(new String[]{"ID", "Destino"});
        
        String sql = "select * from viagens where continente_id = ? order by destino asc";
        
        try{
            pst = conexao.con.prepareStatement(sql);
            
            pst.setInt(1, id);

            String aux = pst.toString();
            String query = aux.substring(aux.indexOf(": ") + 2, aux.length());

            st = conexao.con.createStatement();
            rs = st.executeQuery(query);
            
            while(rs.next()){
                tabela.addRow(new String[]{
                    rs.getString("id"), rs.getString("destino")
                });
            }
        }catch(SQLException ex){
            System.out.println("Erro: " + ex.getMessage());
        }finally{
            conexao.encerrarConexao(pst);  
        }
        
        return tabela;
    }
    
    public boolean registrarLugar(int continente, Lugares lugar, Viagens viagem, PontoTuristicoLugares pontoTuristico){
        boolean sucesso = true;
        
        conexao.conectarBD();
        
        //Verificação de campos vazios
        if(lugar.getDestino().equals("")){
            JOptionPane.showMessageDialog(null, "Preencha todos os campos!");
            
            sucesso = false;
        }
        
        else if(viagem.getAltaTemporada().equals("") || viagem.getClima().equals("")){
            JOptionPane.showMessageDialog(null, "Preencha todos os campos!");
            
            sucesso = false;
        }
        
        else if(pontoTuristico.getNome().equals("") || pontoTuristico.getEndereco().equals("")){
            JOptionPane.showMessageDialog(null, "Preencha todos os campos!");

            sucesso = false;
        }
    
        else{
            try{
                //Inserção dos dados
                String insercaoViagem = "insert into viagens(destino, alta_temporada, clima, continente_id) values(?, ?, ?, ?);";
                String insercaoPontoTuristico = "insert into ponto_turistico_viagem(nome, endereco, preco, latitude, longitude) values(?, ?, ?, ?, ?);";
                
                //Inserção dos dados da tabela M-N
                String insercaoViagemPontoTuristico = "insert into viagem_has_ponto_turistico(viagem_id, ponto_turistico_viagem_id) values(?, ?);";
               
                //******************************VIAGEM******************************
                
                pst = conexao.con.prepareStatement(insercaoViagem);
                
                pst.setString(1, lugar.getDestino());
                pst.setString(2, viagem.getAltaTemporada());
                pst.setString(3, viagem.getClima());
                pst.setInt(4, continente);
                
                pst.execute();
                
                //Pegando id da viagem
                String buscaViagem = "select max(id) as id from viagens;";
                
                st = conexao.con.createStatement();
                
                rs = st.executeQuery(buscaViagem);
                rs.next();
                
                int idViagem = rs.getInt("id");
                
                //******************************PONTO TURÍSTICO******************************
                
                pst = conexao.con.prepareStatement(insercaoPontoTuristico);
                
                pst.setString(1, pontoTuristico.getNome());
                pst.setString(2, pontoTuristico.getEndereco());
                pst.setDouble(3, pontoTuristico.getPreco());
                pst.setDouble(4, PontoTuristicoLugares.latitude);
                pst.setDouble(5, PontoTuristicoLugares.longitude);
                
                pst.execute();
                
                //Pegando id do ponto turistico
                String buscaPontoTuristico = "select max(id) as id from ponto_turistico_viagem;";
                
                st = conexao.con.createStatement();
                
                rs = st.executeQuery(buscaPontoTuristico);
                rs.next();
                
                int idPontoTuristico = rs.getInt("id");
                
                pst = conexao.con.prepareStatement(insercaoViagemPontoTuristico);
                
                pst.setInt(1, idViagem);
                pst.setInt(2, idPontoTuristico);
                
                pst.execute();
            }catch(SQLException ex){
                System.out.println("Erro: " + ex.getMessage());
                
                sucesso = false;
            }finally{
                conexao.encerrarConexao(pst);
            }
        }
        return sucesso;
    }
    
    public void adicionarImagem(String caminho){
        String insercaoImagem = "insert into imagens(caminho, viagens_id) values(?, ?);";
        String idViagem = "select max(id) as id from viagens;";
        
        conexao.conectarBD();
        
        try{
            pst = conexao.con.prepareStatement(idViagem);
            
            st = conexao.con.createStatement();
                
            rs = st.executeQuery(idViagem);
            rs.next();
            
            int id = rs.getInt("id");
            
            pst = conexao.con.prepareStatement(insercaoImagem);
            
            pst.setString(1, caminho);
            pst.setInt(2, id);
            
            pst.execute();
        }catch(SQLException ex){
            System.out.println("Erro: " + ex.getMessage());
        }finally{
            conexao.encerrarConexao(pst);
        }
    }
    
    public boolean registrarPontoTuristico(List<PontoTuristicoLugares> pontosTuristicos, List<Double> latitude, List<Double> longitude){
        boolean sucesso = true;
        
        conexao.conectarBD();
        
        String inserirPontoTuristico = "insert into ponto_turistico_viagem(nome, endereco, preco, latitude, longitude) values(?, ?, ?, ?, ?);";
        String insercaoViagemPontoTuristico = "insert into viagem_has_ponto_turistico(viagem_id, ponto_turistico_viagem_id) values(?, ?);";
        
        for(int i = 0; i < pontosTuristicos.size(); i++){
            if(pontosTuristicos.get(i).getNome().equals("") || pontosTuristicos.get(i).getEndereco().equals("") || latitude.size() != pontosTuristicos.size() || longitude.size() != pontosTuristicos.size()){
                JOptionPane.showMessageDialog(null, "Preencha todos os campos!");

                sucesso = false;
            }
        }
        
        if(sucesso){
            try{
                //Pegando id da viagem
                String buscaViagem = "select max(id) as id from viagens;";
                
                st = conexao.con.createStatement();
                
                rs = st.executeQuery(buscaViagem);
                rs.next();
                
                int idViagem = rs.getInt("id");
                
                
                
                for(int i = 0; i < pontosTuristicos.size(); i++){
                    pst = conexao.con.prepareStatement(inserirPontoTuristico);
                    
                    pst.setString(1, pontosTuristicos.get(i).getNome());
                    pst.setString(2, pontosTuristicos.get(i).getEndereco());
                    pst.setDouble(3, pontosTuristicos.get(i).getPreco());
                    pst.setDouble(4, latitude.get(i));
                    pst.setDouble(5, longitude.get(i));

                    pst.execute();
                
                    //Pegando id do ponto turistico
                    String buscaPontoTuristico = "select max(id) as id from ponto_turistico_viagem;";

                    st = conexao.con.createStatement();

                    rs = st.executeQuery(buscaPontoTuristico);
                    rs.next();

                    int idPontoTuristico = rs.getInt("id");

                    pst = conexao.con.prepareStatement(insercaoViagemPontoTuristico);

                    pst.setInt(1, idViagem);
                    pst.setInt(2, idPontoTuristico);

                    pst.execute();
                }
            }catch(SQLException ex){
                System.out.println("Erro: " + ex.getMessage());
                
                sucesso = false;
            }finally{
                conexao.encerrarConexao(pst);
            }
        }
        
        return sucesso;
    }

    public boolean removerLugar(int idDestino){
        boolean sucesso = true;
        
        conexao.conectarBD();
        
        sucesso = true;
        
        String idPontoTuristico = "select ponto_turistico_viagem.id as id from ponto_turistico_viagem, viagem_has_ponto_turistico where ponto_turistico_viagem.id = ponto_turistico_viagem_id and viagem_id = ?;";
        
        String remocao1 = "delete from ponto_turistico_viagem where id = ?;";
        String remocao2 = "delete from viagens where id = ?;";
        String remocao3 = "delete from viagem_has_ponto_turistico where viagem_id = ?;";
        
        try{
            pst = conexao.con.prepareStatement(idPontoTuristico);
            pst.setInt(1, idDestino);
            pst.execute();
            
            String aux = pst.toString();
            String query = aux.substring(aux.indexOf(": ") + 2, aux.length());
            
            st = conexao.con.createStatement();
            rs = st.executeQuery(query);
            
            while(rs.next()){
                pst = conexao.con.prepareStatement(remocao1);
            
                pst.setInt(1, rs.getInt("id"));

                pst.execute();
            }
            
            pst = conexao.con.prepareStatement(remocao2);
            
            pst.setInt(1, idDestino);
            
            pst.execute();
            
            pst = conexao.con.prepareStatement(remocao3);
            
            pst.setInt(1, idDestino);
            
            pst.execute();
        }catch(SQLException ex){
            System.out.println("Erro: " + ex.getMessage());
            
            sucesso = false;
        }finally{
            conexao.encerrarConexao(pst);  
        }
        
        return sucesso;
    }
    
    public boolean removerPontoTuristico(int id){
        boolean sucesso = true;
        
        conexao.conectarBD();
        
        sucesso = true;
        
        String remocao = "delete from ponto_turistico_viagem where id = ?;";
        
        try{
            pst = conexao.con.prepareStatement(remocao);
            
            pst.setInt(1, id);
            
            pst.execute();
        }catch(SQLException ex){
            System.out.println("Erro: " + ex.getMessage());
            
            sucesso = false;
        }finally{
            conexao.encerrarConexao(pst);  
        }
        
        return sucesso;
    }
    
    public boolean editarViagem(int idContinente, Lugares lugar, Viagens viagem, int idDestino){
        boolean sucesso = true;
        
        conexao.conectarBD();
        
        String update = "update viagens set destino = ?, alta_temporada = ?, clima = ?, continente_id = ? where id = ?;";
        
        try{
            pst = conexao.con.prepareStatement(update);
            
            pst.setString(1, lugar.getDestino());
            pst.setString(2, viagem.getAltaTemporada());
            pst.setString(3, viagem.getClima());
            pst.setInt(4, idContinente);
            pst.setInt(5, idDestino);
            
            pst.execute();
        }catch(SQLException ex){
            System.out.println("Erro: " + ex.getMessage());
        }finally{
            conexao.encerrarConexao(pst);
        }
        
        return sucesso;
    }
    
    public boolean editarPontoTuristico(PontoTuristicoLugares pontoTuristico){
        boolean sucesso = true;
        
        conexao.conectarBD();
        
        String update = "update ponto_turistico_viagem set nome = ?, endereco = ?, preco = ?, latitude = ?, longitude = ? where id = ?;";
        
        try{
            pst = conexao.con.prepareStatement(update);
            
            pst.setString(1, pontoTuristico.getNome());
            pst.setString(2, pontoTuristico.getEndereco());
            pst.setDouble(3, pontoTuristico.getPreco());
            pst.setDouble(4, PontoTuristicoLugares.latitude);
            pst.setDouble(5, PontoTuristicoLugares.longitude);
            pst.setInt(6, pontoTuristico.getId());
            
            pst.execute();
        }catch(SQLException ex){
            System.out.println("Erro: " + ex.getMessage());
        }finally{
            conexao.encerrarConexao(pst);
        }
        
        return sucesso;
    }
}
