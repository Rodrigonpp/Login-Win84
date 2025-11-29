/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.login.dao;

import br.com.login.view.LoginSucedidoView;
import br.com.login.view.LoginView;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author rodri
 */
public class LoginDAO {
    
    public void cadastrarUsuario(String nome, String email, String senha) throws SQLException {
        Connection conexao = new Conexao().getConexao();
        
        String sql = "INSERT INTO login (nome, email, senha) VALUES (?, ?, ?)";
        
        try (PreparedStatement statement = conexao.prepareStatement(sql)) {
            statement.setString(1, nome);
            statement.setString(2, email);
            statement.setString(3, senha);
            
            statement.execute();
            statement.close();
        }
        
    }
    
    public void login(String email, String senha) throws SQLException {
        Connection conexao = new Conexao().getConexao();
        
        String sql = "SELECT email, senha FROM login WHERE email = ? AND senha = ?;";
        
        try (PreparedStatement statement = conexao.prepareStatement(sql)) {
            statement.setString(1, email);
            statement.setString(2, senha);
            
            ResultSet rs = statement.executeQuery();
            
            LoginView loginView = new LoginView();
            
            if (rs.next()) {
                LoginSucedidoView loginSucedido = new LoginSucedidoView();
                loginSucedido.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(loginView, "Üsuário ou senha não cadastrados. Clique em cadastrar para adicionar novo usuário.");
            }
                    
            statement.close();
        }
    }
}
