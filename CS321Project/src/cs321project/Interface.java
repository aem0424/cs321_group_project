/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cs321project;

import java.awt.*;
import java.awt.event.*;
import java.lang.System.*;
import java.lang.System.Logger.Level;
import javax.swing.*;

/**
 *
 * @author matth
 */
public class Interface {
    
    public Interface() {
        
        // -----------------------------Window---------------------------- 
        window = new JFrame("Panera Bread");
        int X = 800; int Y = 500;
        window.setSize(X, Y);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        layout = new CardLayout();
        panes = new JPanel(layout);
        panes.add(loginPanel());
        panes.add(orderPanel());
        
        window.add(panes);
        
        window.setVisible(true);
    }
    
    private JPanel loginPanel() {
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
                    layout.next(panes);
                    currentUsername = usernameField.getText();
                    currentPassword = String.valueOf(passwordField.getPassword());
                    //c.setState(CHECK_LOGIN);
                }
            });
        login.add(loginButton);
        
        return login;
    }
    
    private JPanel orderPanel(){
        JPanel order = new JPanel();
        order.setBackground(Color.DARK_GRAY);
        
        return order;
    }
    
    private void switchPanel(String s) {
        if (s.equals("login"))
            layout.first(panes);
        if (s.equals("next"))
            layout.next(panes);
        if (s.equals("prev"))
            layout.previous(panes);
    }
    
    private String getUsername() {
        return currentUsername;
    }
    
    private String getPassword() {
        return currentPassword;
    }
    
    private JFrame window;
    private JPanel panes;
    private CardLayout layout;
            
    String currentUsername;
    String currentPassword;
    //public void run (connection c) {
        
    //}
    
    //private Connection connect;
}
