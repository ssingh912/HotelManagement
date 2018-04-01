package com.hotel.royalgardens;

import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.awt.event.*;
import java.awt.*;
import java.util.Scanner;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField txtEnterAdminId;
	private JPasswordField passwordField;
	protected Component temporaryLostComponent;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
				// System.out.println("Working dir: " +
				// System.getProperty("user.dir"));
			}
		});
	}

	public void close() {

		WindowEvent winClosingEvent = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
		Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(winClosingEvent);

	}

	/**
	 * Create the frame.
	 */
	public Login() {
		setTitle("Login | Royal Garden");
		setIconImage(Toolkit.getDefaultToolkit().getImage("assets/images/fav_icon.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 471);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		txtEnterAdminId = new JTextField();
		txtEnterAdminId.setToolTipText("Enter Admin ID");
		txtEnterAdminId.setForeground(Color.BLACK);
		txtEnterAdminId.setBackground(Color.WHITE);
		txtEnterAdminId.setBounds(549, 142, 157, 20);
		contentPane.add(txtEnterAdminId);
		txtEnterAdminId.setColumns(10);

		JLabel lblId = new JLabel("ID:");
		lblId.setFont(new Font("Monotype Corsiva", Font.PLAIN, 18));
		lblId.setForeground(Color.ORANGE);
		lblId.setBounds(478, 138, 44, 26);
		contentPane.add(lblId);

		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setFont(new Font("Monotype Corsiva", Font.PLAIN, 18));
		lblPassword.setForeground(Color.ORANGE);
		lblPassword.setBounds(438, 199, 73, 31);
		contentPane.add(lblPassword);

		JLabel NoMatch = new JLabel("");
		NoMatch.setForeground(Color.RED);
		NoMatch.setFont(new Font("Tahoma", Font.PLAIN, 13));
		NoMatch.setBounds(561, 111, 157, 36);
		contentPane.add(NoMatch);

		passwordField = new JPasswordField();
		passwordField.setToolTipText("Enter Admin Password");
		passwordField.setForeground(Color.BLACK);
		passwordField.setFont(new Font("Tahoma", Font.PLAIN, 11));
		passwordField.setBackground(Color.WHITE);
		passwordField.setBounds(549, 205, 157, 20);
		contentPane.add(passwordField);

		JButton btnLogin = new JButton("Login");
		
		contentPane.getRootPane().setDefaultButton(btnLogin);
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				String username = txtEnterAdminId.getText();
				@SuppressWarnings("deprecation")
				String password = passwordField.getText();

				if (username == null || "".equalsIgnoreCase(username))
				{	
					JOptionPane.showMessageDialog(getContentPane(), "Please enter your user id. " );
				}else if(password == null ||  "".equals(password)) {
					
					JOptionPane.showMessageDialog(getContentPane(), "Please enter your password. " );
				}else{
					String record = null;
					FileReader in = null;
					try {
						in = new FileReader("assets/data/info.dat");
						@SuppressWarnings("resource")
						BufferedReader br = new BufferedReader(in);

						Operations menu = null;

						while ((record = br.readLine()) != null) {

							String[] split = record.split("\\s");

							if (username.equals(split[0]) && password.equals(split[1])) {

								JOptionPane.showMessageDialog(null, "Welcome " + split[0]);
								Operations nw = new Operations();
								nw.setVisible(true);
								dispose();

								break;
							}

						}

						if (menu == null) {
							NoMatch.setText("**Incorrect Credentials**");
						}
					} catch (IOException e) {
						e.getCause();
					}
				} 
			}
		});
		btnLogin.setIcon(null);
		btnLogin.setForeground(new Color(255, 200, 0));
		btnLogin.setFont(new Font("Monotype Corsiva", Font.PLAIN, 18));
		btnLogin.setBackground(Color.BLACK);
		btnLogin.setBounds(549, 263, 91, 31);
		contentPane.add(btnLogin);

		JButton btnNewButton = new JButton("Reset");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txtEnterAdminId.setText("");
				passwordField.setText("");
				NoMatch.setText("");
			}
		});
		btnNewButton.setBackground(Color.BLACK);
		btnNewButton.setFont(new Font("Monotype Corsiva", Font.PLAIN, 18));
		btnNewButton.setForeground(Color.ORANGE);
		btnNewButton.setBounds(438, 263, 91, 31);
		contentPane.add(btnNewButton);

		JButton btnNewUser = new JButton("New User");
		btnNewUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NewUser nuser = new NewUser();
				nuser.setVisible(true);
				dispose();
			}
		});
		btnNewUser.setBackground(Color.BLACK);
		btnNewUser.setForeground(Color.ORANGE);
		btnNewUser.setFont(new Font("Monotype Corsiva", Font.PLAIN, 16));
		btnNewUser.setBounds(661, 263, 101, 31);
		contentPane.add(btnNewUser);

		JLabel lblNewLabel = new JLabel("BackGround");
		lblNewLabel.setFont(new Font("Monotype Corsiva", Font.PLAIN, 11));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setIcon(new ImageIcon("assets/images/Img_5_withlogo.2.jpg"));
		lblNewLabel.setBounds(0, 0, 784, 432);
		contentPane.add(lblNewLabel);
	}
}
