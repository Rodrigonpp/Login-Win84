/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.login.controller;

import br.com.login.dao.Conexao;
import br.com.login.dao.LoginDAO;
import br.com.login.view.CadastroView;
import br.com.login.view.LoginView;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author rodri
 */
public class LoginController {
    public void cadastroUsuario(CadastroView view) throws SQLException {
        String nome = view.getjTextFieldNome().getText();
        String email = view.getjTextFieldEmail().getText();
        String senha = view.getjPasswordFieldSenha().getText();
        
        Connection conexao = new Conexao().getConexao();
        LoginDAO cadastro = new LoginDAO();
        cadastro.cadastrarUsuario(nome, email, senha);
    }
    
    public void loginUsuario(LoginView view) throws SQLException {
        String email = view.getjTextFieldLogin().getText();
        String senha = view.getjPasswordFieldSenha().getText();
        
        Connection conexao = new Conexao().getConexao();
        LoginDAO login = new LoginDAO();
        login.login(email, senha);
    }
}
