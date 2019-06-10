package br.inatel.viagens.model.dao;

import br.inatel.viagens.model.entities.Usuario;
import br.inatel.viagens.controller.ConexaoBD;
import br.inatel.viagens.model.entities.Conta;
import br.inatel.viagens.util.Validador;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 * @author Nathalya
 * 
 */

public class ContaDAO {
    ConexaoBD conexao = new ConexaoBD();
    
    public PreparedStatement pst;   //Objeto para manipular comandos SQL dinamicos
    public Statement st;            //Obejtos para manipular comandos SQL estaticos
    public ResultSet rs;            //Objeto que referencia a tabela gerada em busca
    
    public boolean sucesso;
    
    //Cadastro do novo usuário
    public boolean cadastrarUsuario(Usuario novoUsuario, Conta novaConta){
        conexao.conectarBD();
    
        sucesso = false;
        
        //Verificar se as senhas são iguais
        if(novaConta.getSenha().equals(novaConta.getConfirmarSenha())){  
            //Verificação do email e de senha
            boolean verificacao = true;
            
            //Validação do email através do regex
            if(!Validador.validarEmail(novaConta.getEmail())){
                JOptionPane.showMessageDialog(null, "Email inválido!");

                verificacao = false;
            }
            else{
                //Verificar se já existe o email
                //Seleciona todos os emails cadastrados
                String busca = "select email from conta;";

                try{
                    st = conexao.con.createStatement();
                    rs = st.executeQuery(busca);  //Executa o sql e salva no rs

                    //Roda cada uma das triplas selecionadas para ver se existe o email digitado
                    while(rs.next()){
                        //Criação de uma conta temporária para guardar o valor do email 
                        Conta contaTemp = new Conta();

                        //Pega o email da busca e coloca na variável temporária
                        contaTemp.setEmail(rs.getString("email"));

                        if(contaTemp.getEmail().equals(novaConta.getEmail())){
                            JOptionPane.showMessageDialog(null, "Já existe esse email!");

                            verificacao = false;

                            break;
                        }
                    }
                    
                    //Ver se a senha tem no min 6 e no max 15 caracteres
                    if(!Validador.validarSenha(novaConta.getSenha())){
                        JOptionPane.showMessageDialog(null, "Senha inválida! Digite uma senha entre 6 e 15 caracteres");

                        verificacao = false;
                    }
                }catch(SQLException ex){
                    System.out.println("Erro: " + ex.getMessage());
                }

                if(verificacao){
                    if(!(novoUsuario.getNome().equals("") || novoUsuario.getNome().equals("Nome") || novaConta.getEmail().equals("") || novaConta.getSenha().equals(""))){
                        sucesso = true;

                        //Comando de inserção
                        String insercaoConta = "insert into conta values(?, ?);";

                        String insercaoUsuario = "insert into usuario(nome, conta_email) values(?, ?);";

                        try{

                            //Inserindo dados da conta
                            pst = conexao.con.prepareStatement(insercaoConta);

                            //Adicionando os dados da inserção(no lugar do "?")   
                            pst.setString(1, novaConta.getEmail());
                            pst.setString(2, novaConta.getSenha());

                            pst.execute();
                            
                            //Inserindo dados do usuário
                            pst = conexao.con.prepareStatement(insercaoUsuario);

                            //Adicionando os dados da inserção(no lugar do "?")   
                            pst.setString(1, novoUsuario.getNome());
                            pst.setString(2, novaConta.getEmail());

                            pst.execute();

                            JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso!");
                        }catch(SQLException ex){
                            System.out.println("Erro: " + ex.getMessage());
                            
                            sucesso = false;
                        }finally{
                            conexao.encerrarConexao(pst);
                        }
                    }
                    else
                        JOptionPane.showMessageDialog(null, "Preencha todos os campos!");
                }
            }
        }
        else
            JOptionPane.showMessageDialog(null, "Senhas diferentes!");
        
        return sucesso;
    }
    
    //Checar usuario para logar
    public boolean loginUsuario(Conta conta){
        conexao.conectarBD();
         
        boolean verifEmail = false;
        boolean verifSenha = false;
        
        sucesso = false;
            
        String usuario = "select email, senha from conta;";
        
        try{
            st = conexao.con.createStatement();
            rs = st.executeQuery(usuario);

            //Rodando todos os usuarios que tem na tabela usuario para verficar se existe o login que está entrando
            while(rs.next()){
                Conta contaTemp = new Conta();

                contaTemp.setEmail(rs.getString("email"));
                
                contaTemp.setSenha(rs.getString("senha"));

                if(contaTemp.getEmail().equals(conta.getEmail())){
                    verifEmail = true;
                    
                    if(contaTemp.getSenha().equals(conta.getSenha()))
                        verifSenha = true;
                    else
                        JOptionPane.showMessageDialog(null, "Senha incorreta!");
                    
                    break;
                }
            }
        }catch(SQLException ex){
            System.out.println("Erro: " + ex.getMessage());
        }finally{
            conexao.encerrarConexao(pst);
        }

        if(!verifEmail)
            JOptionPane.showMessageDialog(null, "Email não existe!");
        
        else if(verifEmail && verifSenha){
            sucesso = true;
            
            Usuario.usuarioLogado = conta.getEmail();
        }
        
        return sucesso;
    }
}
