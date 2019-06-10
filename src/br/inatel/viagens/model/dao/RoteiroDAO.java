package br.inatel.viagens.model.dao;

import br.inatel.viagens.controller.ConexaoBD;
import br.inatel.viagens.model.entities.Usuario;
import br.inatel.viagens.model.entities.Roteiro;
import br.inatel.viagens.model.entities.Transporte;
import br.inatel.viagens.model.entities.Hospedagem;
import br.inatel.viagens.model.entities.Restaurante;
import br.inatel.viagens.model.entities.PontoTuristico;
import br.inatel.viagens.util.ConverterTipos;
import br.inatel.viagens.util.Validador;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 * @author Nathalya
 * 
 */

public class RoteiroDAO {
    ConexaoBD conexao = new ConexaoBD();
    
    public PreparedStatement pst;   
    public Statement st;            
    public ResultSet rs;            
    
    public boolean sucesso;
    
    DecimalFormat df = new DecimalFormat("0.00");
    
    //Calcular preço total da viagem
    public void precoTotalViagem(int idRoteiro){
        conexao.conectarBD();
        
        double preco_total = 0;
        String aux, query;
        
        String insercaoPrecoTotal = "update roteiro set preco_total = ? where id = ?";
        
        //Pegando a soma dos preços pela view do banco de dados
        String view1 = "select * from preco_roteiro;";
        String view2 = "select * from preco_ponto_turistico;";
        
        try{
            pst = conexao.con.prepareStatement(view1);

            aux = pst.toString();
            query = aux.substring(aux.indexOf(": ") + 2, aux.length());
            
            st = conexao.con.createStatement();
            
            //Já retorna a tabela da busca feita
            rs = st.executeQuery(query);
           
            while(rs.next()){
                if(rs.getInt("id") == idRoteiro){
                    preco_total += rs.getDouble("preco_roteiro");
                    
                    break;
                }
            }
            
            pst = conexao.con.prepareStatement(view2);
            
            aux = pst.toString();
            query = aux.substring(aux.indexOf(": ") + 2, aux.length());
            
            st = conexao.con.createStatement();
            
            rs = st.executeQuery(query);
            
            while(rs.next()){
                if(rs.getInt("id") == idRoteiro){
                    preco_total += rs.getDouble("preco_ponto_turistico");
                    
                    break;
                }
            }

            pst = conexao.con.prepareStatement(insercaoPrecoTotal);

            pst.setDouble(1, preco_total);
            pst.setInt(2, idRoteiro);

            pst.execute();
        }catch(SQLException ex){
            System.out.println("Erro: " + ex.getMessage());
        }finally{
            conexao.encerrarConexao(pst);
        }
    }
    
    public void inserirTipoTransporte(JComboBox tipo){
        conexao.conectarBD();
        
        String tipos = "select nome from tipo_transporte;";
        
        try{
            pst = conexao.con.prepareStatement(tipos);
            
            st = conexao.con.createStatement();
            rs = st.executeQuery(tipos);
            
            while(rs.next()){
                tipo.addItem(rs.getString("nome"));
            }
            
        }catch(SQLException ex){
            System.out.println("Erro: " + ex.getMessage());
        }finally{
            conexao.encerrarConexao(pst);
        }
    }
    
    //**************************************************REGISTROS************************************************************

    public boolean registrarRoteiro(Roteiro novoRoteiro, Transporte novoTransporte, Hospedagem novaHospedagem, Restaurante novoRestaurante, PontoTuristico novoPontoTuristico){
        conexao.conectarBD();
    
        sucesso = true;
        
        //Mudar a variável preço que está em string para double e alterar o , por .
        double auxPreco;
        
        //Verificação de campos vazios e entradas inválidas
        if(novoRoteiro.getDestino().equals("") || novoRoteiro.getDataIda().trim().equals("/  /") || novoRoteiro.getDataVolta().trim().equals("/  /")){
            JOptionPane.showMessageDialog(null, "Preencha todos os campos de Informações da Viagem!");
            
            sucesso = false;
        }
        
        else if(!Validador.validarData(novoRoteiro.getDataIda())){
            JOptionPane.showMessageDialog(null, "Data de ida Inválida!");
            
            sucesso = false;
        }
        
        else if(!Validador.validarData(novoRoteiro.getDataVolta())){
            JOptionPane.showMessageDialog(null, "Data de volta Inválida!");
            
            sucesso = false;
        }
        
        else if(!Validador.ValidarDataIdaVolta(novoRoteiro.getDataIda(), novoRoteiro.getDataVolta())){
            JOptionPane.showMessageDialog(null, "Data Inválida!");
            
            sucesso = false;
        }
        
        else if(novoTransporte.getTipo().equals("") || novoTransporte.getHorarioIda().trim().equals(":") || novoTransporte.getHorarioVolta().trim().equals(":") || novoTransporte.getPreco().equals("")){
            JOptionPane.showMessageDialog(null, "Preencha todos os campos do Transporte!");
            
            sucesso = false;
        }
        
        else if(!Validador.validarHora(novoTransporte.getHorarioIda())){
            JOptionPane.showMessageDialog(null, "Horário de inda Inválido!");
            
            sucesso = false;
        }
        
        else if(!Validador.validarHora(novoTransporte.getHorarioVolta())){
            JOptionPane.showMessageDialog(null, "Horário de volta Inválido!");
            
            sucesso = false;
        }
        
        else if(novoRoteiro.getDataIda().equals(novoRoteiro.getDataVolta()) && !Validador.validarHoraIdaVoltaMesmoDia(novoTransporte.getHorarioIda(), novoTransporte.getHorarioVolta())){
            JOptionPane.showMessageDialog(null, "Horário Inválido!");

            sucesso = false;
        }
        
        else if(novaHospedagem.getNome().equals("") || novaHospedagem.getEndereco().equals("") || novaHospedagem.getCheckIn().trim().equals(":") || novaHospedagem.getCheckOut().trim().equals(":") || novaHospedagem.getPreco().equals("")){
            JOptionPane.showMessageDialog(null, "Preencha todos os campos da Hospedagem!");
            
            sucesso = false;
        }
        
        else if(!Validador.validarHora(novaHospedagem.getCheckIn())){
            JOptionPane.showMessageDialog(null, "Horário de check in Inválido!");
            
            sucesso = false;
        }
        
        else if(!Validador.validarHora(novaHospedagem.getCheckOut())){
            JOptionPane.showMessageDialog(null, "Horário de check out Inválido!");
            
            sucesso = false;
        }
     
        else if(novoRestaurante.getNome().equals("") || novoRestaurante.getEndereco().equals("")){
            JOptionPane.showMessageDialog(null, "Preencha todos os campos do Restaurante!");
            
            sucesso = false;
        }
        
        else if(novoPontoTuristico.getNome().equals("") || novoPontoTuristico.getEndereco().equals("")){
            JOptionPane.showMessageDialog(null, "Preencha todos os campos do Ponto Turístico!");
            
            sucesso = false;
        }
       
        else{
            //Email do usuário logado
            String usuario = Usuario.usuarioLogado;
            
            try{
                //Inserção dos dados
                String insercaoRoteiro = "insert into roteiro(destino, data_ida, data_volta, preco_total, usuario_conta_email) values(?, ?, ?, 0, ?);";
                String insercaoTransporte = "insert into transporte(horario_ida, horario_volta, preco, tipo_transporte_id, roteiro_id) values (?, ?, ?, ?, ?);";
                String insercaoHospedagem = "insert into hospedagem(nome, endereco, checkIn, checkOut, preco, roteiro_id) values(?, ?, ?, ?, ?, ?);";
                String insercaoRestaurante = "insert into restaurante(nome, endereco) values(?, ?);";
                String insercaoPontoTuristico = "insert into ponto_turistico(nome, endereco, preco) values(?, ?, ?);";
                
                //Inserção dos dados da tabela M-N
                String insercaoRoteiroRestaurante = "insert into roteiro_has_restaurante(roteiro_id, restaurante_id) values(?, ?);";
                String insercaoRoteiroPontoTuristico = "insert into roteiro_has_ponto_turistico(roteiro_id, ponto_turistico_id) values(?, ?);";
               
                //******************************ROTEIRO******************************
                
                pst = conexao.con.prepareStatement(insercaoRoteiro);
                
                pst.setString(1, novoRoteiro.getDestino());
                
                novoRoteiro.setDataIda(ConverterTipos.converterDataBD(novoRoteiro.getDataIda()));
                pst.setString(2, novoRoteiro.getDataIda());
                
                novoRoteiro.setDataVolta(ConverterTipos.converterDataBD(novoRoteiro.getDataVolta()));
                pst.setString(3, novoRoteiro.getDataVolta());
                pst.setString(4, usuario);
                
                pst.execute();
                
                //Pegando id do roteiro
                String buscaRoteiro = "select max(id) as id from roteiro;";
                
                st = conexao.con.createStatement();
                
                rs = st.executeQuery(buscaRoteiro);
                rs.next();
                
                int idRoteiro = rs.getInt("id");
                
                //******************************TRANSPORTE******************************
                
                pst = conexao.con.prepareStatement(insercaoTransporte);
                
                pst.setString(1, novoTransporte.getHorarioIda());
                pst.setString(2, novoTransporte.getHorarioVolta());
                
                //Mostrar erro de quanto digita uma letra no preço
                try{
                    auxPreco = Double.parseDouble(novoTransporte.getPreco().replace(',', '.'));
                    
                    pst.setDouble(3, auxPreco);
                }catch(NumberFormatException ex){
                    JOptionPane.showMessageDialog(null, "Preço Inválido!");
                }
                
                pst.setInt(4, Integer.parseInt(novoTransporte.getTipo()) + 1);
                pst.setInt(5, idRoteiro);

                pst.execute();
                
                //******************************HOSPEDAGEM******************************

                pst = conexao.con.prepareStatement(insercaoHospedagem);
                
                pst.setString(1, novaHospedagem.getNome());
                pst.setString(2, novaHospedagem.getEndereco());
                pst.setString(3, novaHospedagem.getCheckIn());
                pst.setString(4, novaHospedagem.getCheckOut());
                
                try{
                    auxPreco = Double.parseDouble(novaHospedagem.getPreco().replace(',', '.'));

                    pst.setDouble(5, auxPreco);
                }catch(NumberFormatException ex){
                    JOptionPane.showMessageDialog(null, "Preço Inválido!");
                    
                    sucesso = false;
                }
                
                pst.setInt(6, idRoteiro);
                
                pst.execute();
                
                //******************************RESTAURANTE******************************
                
                pst = conexao.con.prepareStatement(insercaoRestaurante);
                
                pst.setString(1, novoRestaurante.getNome());
                pst.setString(2, novoRestaurante.getEndereco());
                
                pst.execute();
                
                //Pegando id do restaurante
                String buscaRestaurante = "select max(id) as id from restaurante;";
                
                st = conexao.con.createStatement();
                
                rs = st.executeQuery(buscaRestaurante);
                rs.next();
                
                int idRestaurante = rs.getInt("id");
                
                pst = conexao.con.prepareStatement(insercaoPontoTuristico);
                
                pst.setString(1, novoPontoTuristico.getNome());
                pst.setString(2, novoPontoTuristico.getEndereco());
                
                try{
                    auxPreco = Double.parseDouble(novoPontoTuristico.getPreco().replace(',', '.'));

                    pst.setDouble(3, auxPreco);
                }catch(NumberFormatException ex){
                    JOptionPane.showMessageDialog(null, "Preço Inválido!");
                    
                    sucesso = false;
                }
                
                pst.execute();
         
                //Pegando id do ponto turistico
                String buscaPontoTuristico = "select max(id) as id from ponto_turistico;";
                
                st = conexao.con.createStatement();
                
                rs = st.executeQuery(buscaPontoTuristico);
                rs.next();
                
                int idPontoTuristico = rs.getInt("id");
                
                pst = conexao.con.prepareStatement(insercaoRoteiroRestaurante);
                
                pst.setInt(1, idRoteiro);
                pst.setInt(2, idRestaurante);
                
                pst.execute();
                
                pst = conexao.con.prepareStatement(insercaoRoteiroPontoTuristico);
                
                pst.setInt(1, idRoteiro);
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
    
    public boolean registrarRestaurante(int idRoteiro, List<Restaurante> restaurantes){
        sucesso = true;
        
        conexao.conectarBD();
        
        int id;
        
        for(int i = 0; i < restaurantes.size(); i++){
            if(restaurantes.get(i).getNome().equals("") || restaurantes.get(i).getEndereco().equals("")){
                JOptionPane.showMessageDialog(null, "Preencha todos os campos!");
                
                sucesso = false;
                
                break;
            }
        }
        
        if(sucesso){
            for(int i = 0; i < restaurantes.size(); i++){
                String insercaoRestaurante = "insert into restaurante(nome, endereco) values(?, ?);";
                
                try {
                    pst = conexao.con.prepareStatement(insercaoRestaurante);
                    
                    pst.setString(1, restaurantes.get(i).getNome());
                    pst.setString(2, restaurantes.get(i).getEndereco());

                    pst.execute();
                    
                    String insercaoRoteiroRestaurante = "insert into roteiro_has_restaurante(roteiro_id, restaurante_id) values(?, ?);";
                    
                    pst = conexao.con.prepareStatement(insercaoRoteiroRestaurante);
                    
                    if(idRoteiro == -1){
                        String buscaRoteiro = "select max(id) as id from roteiro;";

                        st = conexao.con.createStatement();

                        rs = st.executeQuery(buscaRoteiro);
                        rs.next();

                        id = rs.getInt("id");
                    }
                    else{
                        id = idRoteiro;
                    }
                    
                    String buscaRestaurante = "select max(id) as id from restaurante;";

                    st = conexao.con.createStatement();

                    rs = st.executeQuery(buscaRestaurante);
                    rs.next();

                    int idRestaurante = rs.getInt("id");
                
                    pst.setInt(1, id);
                    pst.setInt(2, idRestaurante);

                    pst.execute();
                } catch (SQLException ex) {
                    System.out.println("Erro: " + ex.getMessage());
                    
                    sucesso = false;
                }
            }
            conexao.encerrarConexao(pst);
        }
        return sucesso;
    }
    
    public boolean registrarPontoTuristico(int idRoteiro, List<PontoTuristico> pontosTuristicos){
        sucesso = true;
        
        conexao.conectarBD();
        
        int id;
        
        for(int i = 0; i < pontosTuristicos.size(); i++){
            if(pontosTuristicos.get(i).getNome().equals("") || pontosTuristicos.get(i).getEndereco().equals("") || pontosTuristicos.get(i).getPreco().equals("")){
                JOptionPane.showMessageDialog(null, "Preencha todos os campos!");
                
                sucesso = false;
                
                break;
            }
        }
        
        if(sucesso){
            for(int i = 0; i < pontosTuristicos.size(); i++){
                String insercaoPontoTuristico = "insert into ponto_turistico(nome, endereco, preco) values(?, ?, ?);";
                
                try{
                    pst = conexao.con.prepareStatement(insercaoPontoTuristico);
                    
                    pst.setString(1, pontosTuristicos.get(i).getNome());
                    pst.setString(2, pontosTuristicos.get(i).getEndereco());
                    
                    try{
                        double auxPreco = Double.parseDouble(pontosTuristicos.get(i).getPreco().replace(',', '.'));

                        pst.setDouble(3, auxPreco);
                    }catch(NumberFormatException ex){
                        JOptionPane.showMessageDialog(null, "Preço Inválido!");
                        
                        sucesso = false;
                    }

                    pst.execute();
                    
                    String insercaoRoteiroPontoTuristico = "insert into roteiro_has_ponto_turistico(roteiro_id, ponto_turistico_id) values(?, ?);";
                    
                    pst = conexao.con.prepareStatement(insercaoRoteiroPontoTuristico);
                    
                    if(idRoteiro == -1){
                        String buscaRoteiro = "select max(id) as id from roteiro;";

                        st = conexao.con.createStatement();

                        rs = st.executeQuery(buscaRoteiro);
                        rs.next();

                        id = rs.getInt("id");
                    }
                    else{
                        id = idRoteiro;
                    }

                    String buscaPontoTuristico = "select max(id) as id from ponto_turistico;";

                    st = conexao.con.createStatement();

                    rs = st.executeQuery(buscaPontoTuristico);
                    rs.next();

                    int idPontoTuristico = rs.getInt("id");
                
                    pst.setInt(1, id);
                    pst.setInt(2, idPontoTuristico);

                    pst.execute();
                }catch(SQLException ex){
                    System.out.println("Erro: " + ex.getMessage());
                    
                    sucesso = false;
                }
            }
            conexao.encerrarConexao(pst);
        }
        return sucesso;
    }
    
    //**************************************************PESQUISAS************************************************************
    
    //DefaultTableModel -> usa um vetor de vetores para guarda o objeto de valores das células da tabela
    public DefaultTableModel pesquisarRoteiros(String destino){
        conexao.conectarBD();
        
        DefaultTableModel tabela = new DefaultTableModel();

        //Adicionando o nome das colunas da tabela
        tabela.setColumnIdentifiers(new String[]{"ID", "Destino", "Data Ida", "Data Volta"});
        
        String usuario = Usuario.usuarioLogado;
        String query;

        try{
            String sql;
            
            if(destino.equals("")) {
                sql = "select * from roteiro where usuario_conta_email = ? order by destino asc";
                
                pst = conexao.con.prepareStatement(sql);
            
                pst.setString(1, usuario); 

                pst.execute();

                String aux = pst.toString();
                query = aux.substring(aux.indexOf(": ") + 2, aux.length());
            } 
            else{
                sql = "select * from roteiro where usuario_conta_email = ? and destino like ? order by destino asc";
                
                pst = conexao.con.prepareStatement(sql);
            
                pst.setString(1, usuario);
                pst.setString(2, "%" + destino + "%");

                pst.execute();

                String aux = pst.toString();
                query = aux.substring(aux.indexOf(": ") + 2, aux.length());
            }
            st = conexao.con.createStatement();
            rs = st.executeQuery(query);
            
            while (rs.next()) {
                //Adicionando as linhas da tabela
                tabela.addRow(new String[]{
                    String.valueOf(rs.getInt("id")), rs.getString("destino"), ConverterTipos.converterDataTela(rs.getString("data_ida")), ConverterTipos.converterDataTela(rs.getString("data_volta"))
                });
            }
        }catch(SQLException ex){
            System.out.println("Erro: " + ex.getMessage());
        }finally{
            conexao.encerrarConexao(pst);  
        }
        
        return tabela;
    }
    
    //**************************************************BUSCAS************************************************************
    
    public Roteiro buscarRoteiro(String id){
        conexao.conectarBD();
        
        Roteiro roteiro = new Roteiro();

        try{
            String sql = "select * from roteiro where id = ?";
            
            pst = conexao.con.prepareStatement(sql);

            pst.setInt(1, Integer.parseInt(id));

            pst.execute();

            String aux = pst.toString();
            String query = aux.substring(aux.indexOf(": ") + 2, aux.length());
            
            st = conexao.con.createStatement();
            rs = st.executeQuery(query);
            
            rs.next();
            
            roteiro.setDestino(rs.getString("destino"));
            roteiro.setDataIda(ConverterTipos.converterDataTela(rs.getString("data_ida")));
            roteiro.setDataVolta(ConverterTipos.converterDataTela(rs.getString("data_volta")));
            roteiro.setPrecoTotal(rs.getDouble("preco_total"));
        }catch(SQLException ex){
            System.out.println("Erro: " + ex.getMessage());
        }finally{
            conexao.encerrarConexao(pst);  
        }
        
        return roteiro;
    }
    
    public Transporte buscarTransporte(int id){
        conexao.conectarBD();
        
        Transporte transporte = new Transporte();
        
        try{
            String sql = "select * from transporte where roteiro_id = ?";
            
            pst = conexao.con.prepareStatement(sql);

            pst.setInt(1, id);

            pst.execute();

            String aux = pst.toString();
            String query = aux.substring(aux.indexOf(": ") + 2, aux.length());
            
            st = conexao.con.createStatement();
            rs = st.executeQuery(query);
            
            rs.next();
            
            int idTipo = Integer.parseInt(rs.getString("tipo_transporte_id"));
            
            transporte.setHorarioIda(rs.getString("horario_ida"));
            transporte.setHorarioVolta(rs.getString("horario_volta"));
            transporte.setPreco(rs.getString("preco"));
            
            String nomeTransporte = "select nome from tipo_transporte where id = ?;";
            
            pst = conexao.con.prepareStatement(nomeTransporte);
            
            pst.setInt(1, idTipo);
            
            pst.execute();
            
            aux = pst.toString();
            query = aux.substring(aux.indexOf(": ") + 2, aux.length());
            
            st = conexao.con.createStatement();
            rs = st.executeQuery(query);
            
            rs.next();
            
            transporte.setTipo(rs.getString("nome"));
        }catch(SQLException ex){
            System.out.println("Erro: " + ex.getMessage());
        }finally{
            conexao.encerrarConexao(pst);  
        }
        
        return transporte;
    }
    
    public Hospedagem buscarHospedagem(int id){
        conexao.conectarBD();
        
        Hospedagem hospedagem = new Hospedagem();
        
        try{
            String sql = "select * from hospedagem where roteiro_id = ?";
            
            pst = conexao.con.prepareStatement(sql);

            pst.setInt(1, id);

            pst.execute();

            String aux = pst.toString();
            String query = aux.substring(aux.indexOf(": ") + 2, aux.length());
            
            st = conexao.con.createStatement();
            rs = st.executeQuery(query);
            
            rs.next();
            
            hospedagem.setNome(rs.getString("nome"));
            hospedagem.setEndereco(rs.getString("endereco"));
            hospedagem.setCheckIn(rs.getString("checkIn"));
            hospedagem.setCheckOut(rs.getString("checkOut"));
            hospedagem.setPreco(rs.getString("preco"));
        }catch(SQLException ex){
            System.out.println("Erro: " + ex.getMessage());
        }finally{
            conexao.encerrarConexao(pst);  
        }
        
        return hospedagem;
    }
    
    public DefaultTableModel buscarRestaurante(String id){
        conexao.conectarBD();
        
        DefaultTableModel tabela = new DefaultTableModel();

        tabela.setColumnIdentifiers(new String[]{"ID", "Nome", "Endereço"});
        
        int idRoteiro = Integer.parseInt(id);

        String sql = "select * from restaurante, roteiro_has_restaurante where roteiro_id = ? and restaurante_id = restaurante.id order by nome asc";
        
        try{
            pst = conexao.con.prepareStatement(sql);

            pst.setInt(1, idRoteiro);

            pst.execute();

            String aux = pst.toString();
            String query = aux.substring(aux.indexOf(": ") + 2, aux.length());

            st = conexao.con.createStatement();
            rs = st.executeQuery(query);
            
            while (rs.next()) {
                tabela.addRow(new String[]{
                    String.valueOf(rs.getInt("id")), rs.getString("nome"), rs.getString("endereco")
                });
            }
        }catch(SQLException ex){
            System.out.println("Erro: " + ex.getMessage());
        }finally{
            conexao.encerrarConexao(pst);  
        }
        
        return tabela;
    }
    
    public DefaultTableModel buscarPontoTuristico(String id){
        conexao.conectarBD();
        
        DefaultTableModel tabela = new DefaultTableModel();

        tabela.setColumnIdentifiers(new String[]{"ID", "Nome", "Endereço", "Preço"});
        
        int idRoteiro = Integer.parseInt(id);

        String sql = "select * from ponto_turistico, roteiro_has_ponto_turistico where roteiro_id = ? and ponto_turistico_id = ponto_turistico.id order by nome asc";
        
        try{
            pst = conexao.con.prepareStatement(sql);

            pst.setInt(1, idRoteiro);

            pst.execute();

            String aux = pst.toString();
            String query = aux.substring(aux.indexOf(": ") + 2, aux.length());

            st = conexao.con.createStatement();
            rs = st.executeQuery(query);
            
            while (rs.next()) {
                tabela.addRow(new String[]{
                    String.valueOf(rs.getInt("id")), rs.getString("nome"), rs.getString("endereco"), df.format(Double.parseDouble(rs.getString("preco")))
                });
            }
        }catch(SQLException ex){
            System.out.println("Erro: " + ex.getMessage());
        }finally{
            conexao.encerrarConexao(pst);  
        }
        
        return tabela;
    }
    
    //**************************************************REMOÇÕES************************************************************
    
    public boolean removerRoteiro(int id){
        conexao.conectarBD();
        
        sucesso = true;
        
        String remocao = "call removerRoteiro(?);";
        
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
    
    public boolean removerRestaurante(int id){
        conexao.conectarBD();
        
        sucesso = true;
        
        String remocao = "delete from restaurante where id = ?";
        
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
    
    public boolean removerPontoTuristico(int id){
        conexao.conectarBD();
        
        sucesso = true;
        
        String remocao = "delete from ponto_turistico where id = ?";
        
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
    
    //**************************************************EDIÇÕES************************************************************
    
    public boolean editarRoteiro(int id, Roteiro roteiro, Transporte transporte, Hospedagem hospedagem){
        conexao.conectarBD();
        
        sucesso = true;
        
        double auxPreco;
        
        String editar;
        
        try{
            editar = "update transporte set tipo_transporte_id = ?, horario_ida = ?, horario_volta = ?, preco = ? where roteiro_id = ?;";
            
            pst = conexao.con.prepareStatement(editar);
            
            pst.setInt(1, Integer.parseInt(transporte.getTipo()) + 1);
            pst.setString(2, transporte.getHorarioIda());
            pst.setString(3, transporte.getHorarioVolta());
            
            try{
                auxPreco = Double.parseDouble(transporte.getPreco().replace(',', '.'));

                pst.setDouble(4, auxPreco);
            }catch(NumberFormatException ex){
                JOptionPane.showMessageDialog(null, "Preço Inválido!");
                
                sucesso = false;
            }
            
            pst.setInt(5, id);
            
            pst.execute();
            
            editar = "update hospedagem set nome = ?, endereco = ?, checkIn = ?, checkOut = ?, preco = ? where roteiro_id = ?;";
            
            pst = conexao.con.prepareStatement(editar);
            
            pst.setString(1, hospedagem.getNome());
            pst.setString(2, hospedagem.getEndereco());
            pst.setString(3, hospedagem.getCheckIn());
            pst.setString(4, hospedagem.getCheckOut());
            
            try{
                auxPreco = Double.parseDouble(hospedagem.getPreco().replace(',', '.'));

                pst.setDouble(5, auxPreco);
            }catch(NumberFormatException ex){
                JOptionPane.showMessageDialog(null, "Preço Inválido!");
                
                sucesso = false;
            }
            
            pst.setInt(6, id);
            
            pst.execute();
            
            editar = "update roteiro set destino = ?, data_ida = ?, data_volta = ? where id = ?;";
            
            pst = conexao.con.prepareStatement(editar);
            
            pst.setString(1, roteiro.getDestino());
            pst.setString(2, ConverterTipos.converterDataBD(roteiro.getDataIda()));
            pst.setString(3, ConverterTipos.converterDataBD(roteiro.getDataVolta()));
            pst.setInt(4, id);
            
            pst.execute();
        }catch(SQLException ex){
            System.out.println("Erro: " + ex.getMessage());
            
            sucesso = false;
        }finally{
            conexao.encerrarConexao(pst);
        }
        
        return sucesso;
    }
    
    public boolean editarRestaurante(Restaurante restaurante){
        conexao.conectarBD();
        
        sucesso = true;
        
        String editar = "update restaurante set nome = ?, endereco = ? where id = ?;";
        
        try{
            pst = conexao.con.prepareStatement(editar);
            
            pst.setString(1, restaurante.getNome());
            pst.setString(2, restaurante.getEndereco());
            pst.setInt(3, restaurante.getId());
            
            pst.execute();
        }catch(SQLException ex){
            System.out.println("Erro: " + ex.getMessage());
            
            sucesso = false;
        }finally{
            conexao.encerrarConexao(pst);
        }
        
        return sucesso;
    }
    
    public boolean editarPontoTuristico(PontoTuristico pontoTuristico){
        conexao.conectarBD();
        
        sucesso = true;
        
        String editar = "update ponto_turistico set nome = ?, endereco = ?, preco = ? where id = ?;";
        
        try{
            pst = conexao.con.prepareStatement(editar);
            
            pst.setString(1, pontoTuristico.getNome());
            pst.setString(2, pontoTuristico.getEndereco());
            
            try{
                pst.setDouble(3, Double.parseDouble(pontoTuristico.getPreco().replace(',', '.')));
            }catch(NumberFormatException ex){
                JOptionPane.showMessageDialog(null, "Preço Inválido!");
                
                sucesso = false;
            }
            
            pst.setInt(4, pontoTuristico.getId());
            
            pst.execute();
        }catch(SQLException ex){
            System.out.println("Erro: " + ex.getMessage());
        }finally{
            conexao.encerrarConexao(pst);
        }
        
        return sucesso;
    }
}