package br.inatel.viagens.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @author natha
 * 
 */

public class ConexaoBD {
    public Connection con;  //Objeto responsável pela conexão com o banco de dados
    
    public String database = "viagens";
    public String url = "jdbc:mysql://localhost:3307/" + database + "?useTimezone=true&serverTimezone=America/Sao_Paulo&useSSL=false";
    public String user = "root";
    public String password = "vertrigo";
    
    public boolean sucesso;
    
    //Conectando ao banco de dados
    public void conectarBD(){
        try{
            con = DriverManager.getConnection(url, user, password);
        }catch(SQLException ex){
            System.out.println("Erro: " + ex.getMessage());
        }
    }   
    
    public void encerrarConexao(PreparedStatement pst){
        try{
            //Encerrando a conexão
            if(con != null)
                con.close();
            if(pst != null)
                pst.close();
        }catch(SQLException ex){
            System.out.println("Erro ao fechar a conexão: " + ex.getMessage());
        }
    }
}