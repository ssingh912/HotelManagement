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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Vector;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JButton;

public class Rooms extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private static Vector<String> headers;
	private static Vector<String> headers1;
	private static Vector<Vector<String>> data;
	private static Vector<Vector<String>> dataRoomsAvailable;
	private JTextField roomNo;
	private JTextField roomType;
	private JTextField bedType;
	private JTextField tariff;
	public String a, b, c, d;
	public String roomNotxt, roomTypetxt, bedTypetxt, tarifftxt;
	private JButton btnNewButton;
	private JTable table_available;
	private JScrollPane scrollPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Rooms frame = new Rooms();
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
	public Rooms() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("assets\\images\\fav_icon.png"));
		setTitle("Rooms | Royal Garden");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 474, 358);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		roomType = new JTextField();
		roomType.setEditable(false);
		roomType.setBounds(227, 388, -10, 20);
		contentPane.add(roomType);
		roomType.setColumns(10);

		tariff = new JTextField();
		tariff.setEditable(false);
		tariff.setBounds(652, 388, 0, 20);
		contentPane.add(tariff);
		tariff.setColumns(10);

		bedType = new JTextField();
		bedType.setEditable(false);
		bedType.setBounds(422, 388, 0, 20);
		contentPane.add(bedType);
		bedType.setColumns(10);

		roomNo = new JTextField();
		roomNo.setEditable(false);
		roomNo.setBounds(38, 388, 0, 20);
		contentPane.add(roomNo);
		roomNo.setColumns(10);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 0, 0, 0);
		contentPane.add(panel_1);

		headers = new Vector<String>();
		headers.add("Room Number ");
		headers.add("Room Type ");
		headers.add("Bed Type ");
		headers.add("Tariff ");
		
		headers1 = new Vector<String>();
		headers1.add("Available Rooms ");
		headers1.add("Room Type ");

		data = new Vector<Vector<String>>();

		try {
			File f = new File("assets/data/rooms.dat");

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
			}
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		}

		JTable table = new JTable();

		table.setAutoCreateRowSorter(true);
		DefaultTableModel model = new DefaultTableModel(data, headers);
		table.setModel(model);
		JScrollPane scroll = new JScrollPane(table);
		scroll.setBounds(5, 5, 581, 274);

		getContentPane().add(scroll);

		btnNewButton = new JButton("Next");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Customer cw = new Customer();
				cw.NewScreen(true);
				dispose();
			}
		});

		btnNewButton.setBounds(735, 344, 89, 23);
		contentPane.add(btnNewButton);

		JPanel panel = new JPanel();
		panel.setBounds(0, 346, 54, 46);
		contentPane.add(panel);

		HashSet<String> bookedroomsnos = new HashSet<String>();
		
		try {

			File f = new File("assets/data/bookedrooms.dat");

			if (f.exists()) {
				Scanner scanner = new Scanner(f);
				while (scanner.hasNext()) {

					String line = scanner.nextLine();
					String[] fields = line.split("[|]");

					String roomno = fields[0];
					bookedroomsnos.add(roomno);

				}
			}
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		}
		dataRoomsAvailable = new Vector<Vector<String>>();
		try {
			File f = new File("assets/data/rooms.dat");

			if (f.exists()) {
				Scanner scanner = new Scanner(f);
				while (scanner.hasNext()) {
					Vector<String> row = new Vector<>();

					String line = scanner.nextLine();
					String[] fields = line.split("[|]");
					String roomno = fields[0];
					if (!bookedroomsnos.contains(roomno)) {

						for (int i = 0; i < fields.length; i++) {
							row.add(fields[i]);
						}

						dataRoomsAvailable.add(row);
					}
				}
			}
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		}

		DefaultTableModel model1 = new DefaultTableModel(dataRoomsAvailable, headers1);
		
		scrollPane = new JScrollPane();
		scrollPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
			}
		});
		scrollPane.setBounds(617, 5, 268, 274);
		contentPane.add(scrollPane);
		
		table_available = new JTable();
				scrollPane.setViewportView(table_available);
				
						table_available.setAutoCreateRowSorter(true);
						table_available.setModel(model1);
						
						JButton btnBack = new JButton("Back");
						btnBack.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent arg0) {
								
								Operations op = new Operations();
								op.setVisible(true);
								dispose();
							}
						});
						btnBack.setBounds(64, 344, 89, 23);
						contentPane.add(btnBack);

		table.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {

				// i = the index of the selected row
				int i = table.getSelectedRow();

				roomNo.setText(model.getValueAt(i, 0).toString());
				roomType.setText(model.getValueAt(i, 1).toString());
				bedType.setText(model.getValueAt(i, 2).toString());
				tariff.setText(model.getValueAt(i, 3).toString());

				File f = new File("assets/data/bookedrooms.dat");

				String rName = roomNo.getText().toString();
				String rType = roomType.getText().toString();
				String bType = bedType.getText().toString();
				String tRff = tariff.getText().toString();

				if (f.exists()) {
					String dataToWrite = rName + "|" + rType + "|" + bType + "|" + tRff + "\n";

					try {
						FileWriter fileWriter = new FileWriter(f,true);
						BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

						bufferedWriter.write(dataToWrite);
						bufferedWriter.flush();
						bufferedWriter.close();

					} catch (IOException ei) {
						ei.printStackTrace();
						JOptionPane.showMessageDialog(contentPane, "Unable to save data.", "Save Error",
								JOptionPane.ERROR_MESSAGE);
					} catch (Exception ej) {
						JOptionPane.showMessageDialog(contentPane, "Unable to save  data.", "Save Error",
								JOptionPane.ERROR_MESSAGE);
					}
				} else {
					JOptionPane.showMessageDialog(contentPane, "Unable to save  data.", "Save Error",
							JOptionPane.ERROR_MESSAGE);
				}

			}

		});

		setSize(911, 458);
		setResizable(true);
		setVisible(true);

	}
}
