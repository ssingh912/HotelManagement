package com.hotel.royalgardens;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.Toolkit;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Vector;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Cancel extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private static Vector<String> headers;
	private static Vector<Vector<String>> data;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CustomerList frame = new CustomerList();
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
	public Cancel() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("assets/images/fav_icon.png"));
		setTitle("Cancellations | Royal Garden");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 474, 358);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 0, 0, 0);
		contentPane.add(panel_1);

		headers = new Vector<String>();
		headers.add("Room Number ");
		headers.add("Tariff ");
		headers.add("Name ");
		headers.add("Address ");
		headers.add("City ");
		headers.add("State ");
		headers.add("Country ");
		headers.add("Phone No. ");
		headers.add("Nationality ");
		headers.add("ID Proof ");
		headers.add("ID No. ");
		headers.add("People ");
		headers.add("Mode Of Pay ");
		headers.add("CheckIn ");
		headers.add("CheckOut ");

		data = new Vector<Vector<String>>();

		try {
			File f = new File("assets/data/customer.dat");

			if (f.exists()) {
				Scanner scanner = new Scanner(f);
				while (scanner.hasNext()) {
					Vector<String> row = new Vector<>();

					String line = scanner.nextLine();
					String[] fields = line.split("[|]");
					for (int i = 0; i < fields.length; i++) {
						row.add(fields[i]);
					}

					data.add(row);
				}

				scanner.close();
			}
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		}

		JTable table = new JTable();

		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {

				int rowindex = table.getSelectedRow();
				//System.out.println(table.getModel().getValueAt(rowindex, 0));
				//System.out.println(table.getModel().getValueAt(rowindex, 1));
				//System.out.println(table.getModel().getValueAt(rowindex, 2));

			}
		});
		DefaultTableModel model = new DefaultTableModel(data, headers);
		table.setModel(model);
		table.setAutoCreateRowSorter(true);
		model = new DefaultTableModel(data, headers);
		table.setModel(model);
		JScrollPane scroll = new JScrollPane(table);
		scroll.setBounds(5, 5, 1352, 471);

		getContentPane().add(scroll);

		JButton btnGoBack = new JButton("Go back");
		btnGoBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Operations op = new Operations();
				op.setVisible(true);
				dispose();
			}
		});
		btnGoBack.setBounds(15, 490, 89, 23);
		contentPane.add(btnGoBack);

		JButton btnDeleteRow = new JButton("Delete Row");
		btnDeleteRow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				int rowindex = table.getSelectedRow();

				data.remove(rowindex);

				//System.out.println(data.size());

				customerDeleteFromFile(data);
				File f1 = new File("assets/data/customer.dat");

				if (f1.exists()) {
					Scanner scanner;
					try {
						scanner = new Scanner(f1);

						while (scanner.hasNext()) {
							Vector<String> row = new Vector<>();

							String line = scanner.nextLine();
							String[] fields = line.split("[|]");
							for (int i = 0; i < fields.length; i++) {
								row.add(fields[i]);
							}

							data.add(row);
						}

						scanner.close();
					} catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (Exception e2) {
						e2.printStackTrace();
					}

					DefaultTableModel model = new DefaultTableModel(data, headers);
					table.setModel(model);
					table.setRowSelectionAllowed(true);
					table.setAutoCreateRowSorter(true);
					model = new DefaultTableModel(data, headers);
					table.setModel(model);
					JScrollPane scroll = new JScrollPane(table);
					scroll.setBounds(5, 5, 1352, 471);

					getContentPane().add(scroll);

				}
			}
		});
		btnDeleteRow.setBounds(143, 490, 131, 23);
		contentPane.add(btnDeleteRow);
		setSize(1378, 563);
		setResizable(true);
		setVisible(true);
	}

	public void customerDeleteFromFile(Vector<Vector<String>> data) {

		try {
			File f = new File("assets/data/customer.dat");

			if (f.exists()) {
				FileWriter fileWriter = new FileWriter(f);
				BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
				for (int i = 0; i < data.size(); i++) {
					Vector<String> vector = (Vector<String>) data.get(i);

					String line = "";
					for (int j = 0; j < vector.size(); j++) {
						line += vector.get(j) + "|";
					}
					line = line.substring(0, line.length() - 1);
					bufferedWriter.write(line + "\n");
				}

				bufferedWriter.flush();
				bufferedWriter.close();
			}
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
