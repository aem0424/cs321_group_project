/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cs321project;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 *
 * @author matth
 */
public class Interface {
    
    public Interface() {
        
        // -----------------------------Window---------------------------- 
        JFrame window = new JFrame("Panera Bread");
        int X = 800; int Y = 500;
        window.setSize(X, Y);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setVisible(true);
        
        // -----------------------------Login Screen---------------------------- 
        JPanel login = new JPanel();
        login.setLayout(null);
        login.setBackground(Color.LIGHT_GRAY);
        
        JLabel usernameText = new JLabel("Username");
        usernameText.setBounds(200, 200, 80, 25);
        JTextField usernameField = new JTextField(15);
        usernameField.setBounds(300, 200, 265, 25);
        login.add(usernameText); login.add(usernameField);
        
        JLabel passwordText = new JLabel("Password");
        passwordText.setBounds(200, 250, 265, 25);
        JPasswordField passwordField = new JPasswordField(18);
        passwordField.setBounds(300, 250, 265, 25);
        login.add(passwordText); login.add(passwordField);
        
        JButton loginButton = new JButton("login");
        loginButton.setBounds(375, 300, 80, 25);
        loginButton.addActionListener(
            new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    login.setVisible(false);
                }
            });
        login.add(loginButton);
        
        // ----------------------------Order Screen-----------------------------
        JPanel order = new JPanel();
        order.setBackground(Color.DARK_GRAY);
        
        //----------------------------Add Panel------------------------------------
        
        window.add(login);
    }
    
    //public void run (connection c) {
        
    //}
    
    //private Connection connect;
}
