package com.hotel.royalgardens;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.io.*;
import java.io.FileWriter;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class NewUser extends JFrame {

	private JPanel contentPane;
	private JTextField userName;
	private JTextField passWord;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NewUser frame = new NewUser();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public NewUser() {
		setTitle("New User | Royal Garden");
		setIconImage(Toolkit.getDefaultToolkit().getImage("assets/images/fav_icon.png"));
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 394, 320);
		contentPane = new JPanel();
		contentPane.setBackground(Color.GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		userName = new JTextField();
		userName.setBounds(209, 70, 122, 20);
		contentPane.add(userName);
		userName.setColumns(10);
		
		passWord = new JTextField();
		passWord.setBounds(209, 121, 122, 20);
		contentPane.add(passWord);
		passWord.setColumns(10);
		
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String path = "assets/data/info.dat";
				File f = new File(path);
				FileWriter fw = null;
				
			    String username = userName.getText();
				 String pass = passWord.getText();
				 
				 
					try {
						fw = new FileWriter(f,true);
					} catch (IOException e1) {
						
						e1.printStackTrace();
					} 
			         
			    BufferedWriter bw = new BufferedWriter(fw);
			         
			         
			        	 try {
							bw.write("\n" +""+username +" " +""+pass);
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
			      
			         try {
						bw.close();
					} catch (IOException e1) {
						
						e1.printStackTrace();
					}
			         JOptionPane.showMessageDialog(null, "Data is Saved!!");
					 Login ln = new Login();
				ln.setVisible(true);
				dispose();
			}
			   

	});
		btnSave.setBounds(242, 170, 89, 23);
		contentPane.add(btnSave);
		
		JButton btnGoBack = new JButton("Go Back");
		btnGoBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Login ln = new Login();
				ln.setVisible(true);
				dispose();
			}
		});
		btnGoBack.setBounds(58, 170, 89, 23);
		contentPane.add(btnGoBack);
		
		JLabel lblNewLabel = new JLabel("Enter User Name:");
		lblNewLabel.setFont(new Font("Monotype Corsiva", Font.PLAIN, 18));
		lblNewLabel.setForeground(Color.ORANGE);
		lblNewLabel.setBounds(55, 73, 122, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Enter Password:");
		lblNewLabel_1.setForeground(Color.ORANGE);
		lblNewLabel_1.setFont(new Font("Monotype Corsiva", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(55, 124, 122, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblBg = new JLabel("");
		lblBg.setIcon(new ImageIcon("assets/images/amazing wallpaper (83).jpg"));
		lblBg.setBounds(0, 0, 388, 291);
		contentPane.add(lblBg);
	}
}
