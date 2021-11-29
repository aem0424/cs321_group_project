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
        window = new JFrame("Pantera Bread");
        int X = 800; int Y = 500;
        window.setSize(X, Y);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        layout = new CardLayout();
        panes = new JPanel(layout);
        panes.add(orderStatusPanel(false));
//        panes.add(credentialsApproved());
//        panes.add(credentialsDenied());
//        panes.add(orderPanel());
        
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
                    //panes.add(credentialsPanel(false));
                    //window.add(panes);
                    //addPanel(credentialsPanel(false));
                    //layout.next(panes);
                    currentUsername = usernameField.getText();
                    currentPassword = String.valueOf(passwordField.getPassword());
                    //c.setState(c.CHECK_LOGIN);
                }
            });
        login.add(loginButton);
        
        // Make dynamic text.
        //JLabel confirmationText = new JLabel();
        
        
        return login;
    }
    
    private JPanel credentialsPanel(Boolean bool) {
        JPanel credentials = new JPanel();
        credentials.setLayout(null);
        credentials.setBackground(Color.LIGHT_GRAY);
        if (bool.equals(true)) {
            JLabel credentialsLabel = new JLabel("Sign-In Approved.");
            credentialsLabel.setBounds(350, 200, 200, 25);
            credentials.add(credentialsLabel); 
        }
        else {
            JLabel credentialsLabel = new JLabel("Sign-In Denied.");
            credentialsLabel.setBounds(350, 200, 200, 25);
            credentials.add(credentialsLabel);
        }
        
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
    
    private JPanel itemSpecificsPanel() {
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
    
    private JPanel orderStatusPanel(Boolean bool) {
        JPanel orderStatus = new JPanel();
        orderStatus.setLayout(null);
        orderStatus.setBackground(Color.LIGHT_GRAY);
        
        if (bool.equals(true)){
            JLabel paymentLabel = new JLabel("Payment information accepted. Order approved.");
            paymentLabel.setBounds(250, 200, 350, 25);
            orderStatus.add(paymentLabel); 
            
            JButton completeOrderButton = new JButton("Complete Order and Logout");
            completeOrderButton.setBounds(285, 250, 200, 25);
            completeOrderButton.addActionListener(
            new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    //c.setState(c.LOGOUT)
                }
            });
            orderStatus.add(completeOrderButton);
        }
        else {
            JLabel paymentLabel = new JLabel("Payment information invalid.");
            paymentLabel.setBounds(310, 200, 200, 25);
            orderStatus.add(paymentLabel); 
            
            JButton retryPaymentButton = new JButton("Retry Payment");
            retryPaymentButton.setBounds(210, 250, 140, 25);
            retryPaymentButton.addActionListener(
            new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    //c.setState(c.PAYMENT)
                }
            });
            orderStatus.add(retryPaymentButton);
            
            JButton cancelOrderButton = new JButton("Cancel Order and Logout");
            cancelOrderButton.setBounds(360, 250, 190, 25);
            cancelOrderButton.addActionListener(
            new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    //c.setState(c.LOGOUT)
                }
            });
            orderStatus.add(cancelOrderButton);
        }
        
        return orderStatus;
    }
    
    private JPanel logoutPanel() {
        JPanel logout = new JPanel();
        logout.setLayout(null);
        logout.setBackground(Color.LIGHT_GRAY);
        
        return logout;
    }
    
    
    public void addPanel(JPanel panel) {
        panes.add(panel);
        window.add(panes);
    }
    
    private String getUsername() {
        return currentUsername;
    }
    
    private String getPassword() {
        return currentPassword;
    }
    
    public void run (Connection c) {
        connect = c;
    }
    
    private JFrame window;
    private JPanel panes;
    private CardLayout layout;
            
    private String currentUsername;
    private String currentPassword;
    private int orderNumber;
    
    private Connection connect;
}
