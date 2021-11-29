/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cs321project;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
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
        
        window.setResizable(false);
        window.setVisible(true);
    }
    
    public JPanel loginPanel() {
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
                    user = usernameField.getText();
                    pass = String.valueOf(passwordField.getPassword());
                    connect.dial("1");
                }
            });
        login.add(loginButton);
        
        // Make dynamic text.
        //JLabel confirmationText = new JLabel();
        
        
        return login;
    }
    
    public  JPanel credentialsPanel(Boolean bool) {
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
        
        JButton continueButton = new JButton("Continue");
        continueButton.setBounds(340, 250, 100, 25);
        continueButton.addActionListener(
            new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    connect.dial("1");
                }
            });
        credentials.add(continueButton);
        
        return credentials;        
    }
    
    public  JPanel employeePanel(Boolean bool) {
        JPanel employeePanel = new JPanel();
        employeePanel.setLayout(null);
        employeePanel.setBackground(Color.LIGHT_GRAY);
        
        return employeePanel;
    }
    
    public  JPanel managerPanel() {
        JPanel managerPanel = new JPanel();
        managerPanel.setLayout(null);
        managerPanel.setBackground(Color.LIGHT_GRAY);
        
        return managerPanel;
    }
    
    public  JPanel orderPanel(){
        // Make new panel.
        JPanel order = new JPanel();
        order.setLayout(new BorderLayout());
        order.setBackground(Color.LIGHT_GRAY);
        
        JPanel oNumberPanel = new JPanel();
        oNumberPanel.setBackground(Color.LIGHT_GRAY);
        JLabel oNumberLabel = new JLabel("Order #" + connect.getOrderNumber());
        oNumberLabel.setBounds(350,50,100,50);
        oNumberPanel.add(oNumberLabel);
        oNumberPanel.setSize(800, 300);
        order.add(oNumberPanel, BorderLayout.NORTH);
        
        String[] keyLabels = {"Sandwich","Soup","Mac'N'Cheese","Salad","Grain Bowl"};
        JPanel keyPanel = new JPanel();
        keyPanel.setLayout(new GridLayout(4, 3));
        keyPanel.setBackground(Color.LIGHT_GRAY);
        for (int i = 0; i < 5; i++)
        {
            final String label = keyLabels[i];
            int j = i+1;
            JButton keyButton = new JButton(label);
            keyPanel.add(keyButton);
            keyButton.addActionListener(new
                ActionListener()
                {
                    public void actionPerformed(ActionEvent event)
                    {
                        connect.dial(String.valueOf(j));
                    }
                });
        }
        order.add(keyPanel, BorderLayout.CENTER);
        
        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(Color.LIGHT_GRAY);
        JButton clearCartButton = new JButton("Clear Cart");
        clearCartButton.setBounds(210, 100, 140, 25);
        clearCartButton.addActionListener(
            new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    connect.dial("6");
                }
            });
        buttonPanel.add(clearCartButton);
        JButton finalizeButton = new JButton("Finalize Cart");
        finalizeButton.setBounds(360, 100, 190, 25);
        finalizeButton.addActionListener(
            new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    connect.dial("7");
                }
            });
        buttonPanel.add(finalizeButton);
        order.add(buttonPanel, BorderLayout.SOUTH);
        
        return order;
    }
    
    public  JPanel itemSpecificsPanel(int i) {
        JPanel itemSpecs = new JPanel();
        itemSpecs.setLayout(null);
        itemSpecs.setBackground(Color.LIGHT_GRAY);
        
        if (i==1){
                        
            JLabel itemText = new JLabel("What temp would you like your Sandwich?");
            itemText.setBounds(250, 175, 300, 25);
            itemSpecs.add(itemText);
            
            JButton hotButton = new JButton("Large");
            hotButton.setBounds(225, 250, 100, 50);
            hotButton.addActionListener(
            new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    connect.dial("3");
                }
            });
            itemSpecs.add(hotButton);
            
            JButton coldButton = new JButton("Small");
            coldButton.setBounds(425, 250, 100, 50);
            coldButton.addActionListener(
            new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    connect.dial("4");
                }
            });
            itemSpecs.add(coldButton);
            

        } 
        else {
            if (i==2){
                JLabel itemText = new JLabel("What size would you like your Soup?");
                itemText.setBounds(250, 175, 300, 25);
                itemSpecs.add(itemText);
            }
            else if (i==3){
                JLabel itemText = new JLabel("What size would you like your Mac'N'Cheese?");
                itemText.setBounds(250, 175, 300, 25);
                itemSpecs.add(itemText);
            }
            else if (i==4){
                JLabel itemText = new JLabel("What size would you like your Salad?");
                itemText.setBounds(250, 175, 300, 25);
                itemSpecs.add(itemText);
            }
            
            JButton hotButton = new JButton("Large");
            hotButton.setBounds(225, 250, 100, 50);
            hotButton.addActionListener(
            new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    connect.dial("1");
                }
            });
            itemSpecs.add(hotButton);
            
            JButton coldButton = new JButton("Small");
            coldButton.setBounds(425, 250, 100, 50);
            coldButton.addActionListener(
            new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    connect.dial("2");
                }
            });
            itemSpecs.add(coldButton);
        }
        
        return itemSpecs;
    }
    
    public  JPanel deliveryOptionsPanel(){
        JPanel deliveryOptions = new JPanel();
        deliveryOptions.setLayout(null);
        deliveryOptions.setBackground(Color.LIGHT_GRAY);
        
        JLabel addressText = new JLabel("Address:");
        addressText.setBounds(125, 350, 75, 25);
        addressText.setVisible(false);
        deliveryOptions.add(addressText);
        
        JTextField addressField = new JTextField(30);
        addressField.setBounds(200, 350, 300, 25);
        addressField.setVisible(false);
        deliveryOptions.add(addressField);
        
        JButton submitButton = new JButton("Submit");
        submitButton.setBounds(525, 350, 100, 25);
        submitButton.addActionListener(
        new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                address = addressField.getText();
                connect.dial("1");
            }
        });
        submitButton.setVisible(false);
        deliveryOptions.add(submitButton);
        
        JLabel promptText = new JLabel("How would you like your food delivered?");
        promptText.setBounds(250, 175, 300, 25);
        deliveryOptions.add(promptText);
        
        JButton pickupButton = new JButton("Pickup");
        pickupButton.setBounds(425, 250, 100, 50);
        pickupButton.addActionListener(
        new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                connect.dial("2");
            }
        });
        deliveryOptions.add(pickupButton);
        
        JButton deliveryButton = new JButton("Delivery");
        deliveryButton.setBounds(225, 250, 100, 50);
        deliveryButton.addActionListener(
        new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                addressText.setVisible(true);
                addressField.setVisible(true);
                submitButton.setVisible(true);
            }
        });
        deliveryOptions.add(deliveryButton);
            
        return deliveryOptions;
    }
    
    public  JPanel paymentPanel() {
        JPanel pay = new JPanel();
        pay.setLayout(null);
        pay.setBackground(Color.LIGHT_GRAY);
        
        JLabel paymentText = new JLabel("Payment Information");
        paymentText.setBounds(325, 200, 200, 25);
        pay.add(paymentText);
        
        JLabel ccnumText = new JLabel("Card #:");
        ccnumText.setBounds(150, 250, 80, 25);
        JTextField ccnumPrompt = new JTextField(16);
        ccnumPrompt.setBounds(200, 250, 200, 25);
        pay.add(ccnumText); pay.add(ccnumPrompt);
        
        JLabel cvcText = new JLabel("CVC:");
        cvcText.setBounds(425, 250, 80, 25);
        JTextField cvcPrompt = new JTextField(3);
        cvcPrompt.setBounds(475, 250, 80, 25);
        pay.add(cvcText); pay.add(cvcPrompt);
        
        JLabel expText = new JLabel("Exp. Date:");
        expText.setBounds(150, 300, 80, 25);
        JTextField expField = new JTextField(4);
        expField.setBounds(225, 300, 80, 25);
        pay.add(expText); pay.add(expField);
        
        JLabel zipText = new JLabel("Zip Code:");
        zipText.setBounds(425, 300, 80, 25);
        JTextField zipPrompt = new JTextField(5);
        zipPrompt.setBounds(500, 300, 80, 25);
        pay.add(zipText); pay.add(zipPrompt);
        
        JButton confButton = new JButton("Confirm");
        confButton.setBounds(325, 350, 100, 50);
        confButton.addActionListener(
        new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ccnum = Long.parseLong(ccnumPrompt.getText());
                cvc = Integer.parseInt(cvcPrompt.getText());
                exp = Integer.parseInt(expField.getText());
                zip = Integer.parseInt(zipPrompt.getText());
                connect.dial("1");
            }
        });
        pay.add(confButton);
        
        return pay;
    }
    
    public  JPanel orderStatusPanel(Boolean bool) {
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
                    //
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
                    connect.dial("0");
                }
            });
            orderStatus.add(retryPaymentButton);
            
            JButton cancelOrderButton = new JButton("Cancel Order and Logout");
            cancelOrderButton.setBounds(360, 250, 190, 25);
            cancelOrderButton.addActionListener(
            new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    connect.dial("5");
                }
            });
            orderStatus.add(cancelOrderButton);
        }
        
        return orderStatus;
    }
    
    public  JPanel logoutPanel() {
        JPanel logout = new JPanel();
        logout.setLayout(null);
        logout.setBackground(Color.LIGHT_GRAY);
        
        return logout;
    }
    
    
    public void addPanel(JPanel panel) {
        panes.add(panel);
        window.add(panes);
    }
    
    public  void setPanel(String s){
        if (s.equals("first"))
            layout.first(panes);
        if (s.equals("next"))
            layout.next(panes);
        if (s.equals("prev"))
            layout.previous(panes);
        if (s.equals("last"))
            layout.last(panes);
    }
    
    public String getUsername() {
        return user;
    }
    
    public String getPassword() {
        return pass;
    }
    
    public String getAddress() {
        return address;
    }
    
    public ArrayList<Object> getPaymentInfo() {
        ArrayList<Object> info = new ArrayList<Object>();
        info.add(ccnum); info.add(cvc); info.add(exp); info.add(zip);
        
        return info;
    }
    
    public void run (Connection c) {
        connect = c;
    }
    
    private JFrame window;
    private JPanel panes;
    private CardLayout layout;

    private int orderNumber;
    private String user;
    private String pass;
    
    private String address;
    
    private long ccnum;
    private int cvc; 
    private int exp;
    private int zip;
    
    private Connection connect;
}
