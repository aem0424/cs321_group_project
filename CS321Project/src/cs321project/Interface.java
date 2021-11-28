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
        window = new JFrame("Panera Bread");
        int X = 800; int Y = 500;
        window.setSize(X, Y);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        layout = new CardLayout();
        panes = new JPanel(layout);
        panes.add(loginPanel());
        panes.add(credentialsApproved());
        panes.add(credentialsDenied());
        panes.add(orderPanel());
        
        window.add(panes);
        
        window.setVisible(true);
    }
    
    private JPanel loginPanel() {
        // Make new panel.
        JPanel login = new JPanel();
        login.setLayout(null);
        login.setBackground(Color.LIGHT_GRAY);
        
        // Make username field
        JLabel usernameText = new JLabel("Username");
        usernameText.setBounds(200, 200, 80, 25);
        JTextField usernameField = new JTextField(15);
        usernameField.setBounds(300, 200, 265, 25);
        login.add(usernameText); login.add(usernameField);
        
        // Make password field
        JLabel passwordText = new JLabel("Password");
        passwordText.setBounds(200, 250, 265, 25);
        JPasswordField passwordField = new JPasswordField(18);
        passwordField.setBounds(300, 250, 265, 25);
        login.add(passwordText); login.add(passwordField);
        
        // Make login button.
        JButton loginButton = new JButton("login");
        loginButton.setBounds(375, 300, 80, 25);
        loginButton.addActionListener(
            new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    switchPanel("next");
                    currentUsername = usernameField.getText();
                    currentPassword = String.valueOf(passwordField.getPassword());
                    //c.setState(CHECK_LOGIN);
                }
            });
        login.add(loginButton);
        
        // Make dynamic text.
        //JLabel confirmationText = new JLabel();
        
        
        return login;
    }
    
    private JPanel credentialsApproved() {
        JPanel credentials = new JPanel();
        credentials.setLayout(null);
        credentials.setBackground(Color.LIGHT_GRAY);
        
        JLabel credentialsLabel = new JLabel("Sign-In Approved.");
        credentialsLabel.setBounds(350, 200, 200, 25);
        credentials.add(credentialsLabel);
        
        return credentials;        
    }
    
    private JPanel credentialsDenied() {
        JPanel credentials = new JPanel();
        credentials.setLayout(null);
        credentials.setBackground(Color.LIGHT_GRAY);
        
        JLabel credentialsLabel = new JLabel("Sign-In Denied.");
        credentialsLabel.setBounds(350, 200, 200, 25);
        credentials.add(credentialsLabel);
        
        return credentials;        
    }
    
    private JPanel employeePanel() {
        JPanel employeePanel = new JPanel();
        employeePanel.setLayout(null);
        employeePanel.setBackground(Color.LIGHT_GRAY);
        
        return employeePanel;
    }
    
    private JPanel managerPanel() {
        JPanel managerPanel = new JPanel();
        managerPanel.setLayout(null);
        managerPanel.setBackground(Color.LIGHT_GRAY);
        
        return managerPanel;
    }
    
    private JPanel orderPanel(){
        // Make new panel.
        JPanel order = new JPanel();
        order.setBackground(Color.DARK_GRAY);
        
        return order;
    }
    
    private JPanel itemSpecifics() {
        JPanel itemSpecs = new JPanel();
        itemSpecs.setLayout(null);
        itemSpecs.setBackground(Color.LIGHT_GRAY);
        
        return itemSpecs;
    }
    
    private JPanel paymentPanel() {
        JPanel paymentPanel = new JPanel();
        paymentPanel.setLayout(null);
        paymentPanel.setBackground(Color.LIGHT_GRAY);
        
        return paymentPanel;
    }
    
    private JPanel orderApproved() {
        JPanel orderAppr = new JPanel();
        orderAppr.setLayout(null);
        orderAppr.setBackground(Color.LIGHT_GRAY);
        
        return orderAppr;
    }
    
    private JPanel orderDenied() {
        JPanel orderDen = new JPanel();
        orderDen.setLayout(null);
        orderDen.setBackground(Color.LIGHT_GRAY);
        
        return orderDen;
    }
    
    private JPanel logoutPanel() {
        JPanel logout = new JPanel();
        logout.setLayout(null);
        logout.setBackground(Color.LIGHT_GRAY);
        
        return logout;
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
            
    private String currentUsername;
    private String currentPassword;
    //public void run (connection c) {
        
    //}
    
    //private Connection connect;
}
