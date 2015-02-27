package se.mah.k3lara.skaneAPI.view;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JLabel;

import se.mah.k3lara.skaneAPI.xmlparser.Parser;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;


public class GUI extends JFrame {

	private JPanel contentPane;
	public JTextField textField_hallplats;
	public JTextField textField_from;
	public JTextField textField_till;
	JTextArea textArea_result = new JTextArea();
	JTextArea textArea_result2 = new JTextArea();
	GUI gui = this;
	private Parser parser = new Parser();
	Thread t1 = new StationsThread(parser, this);
	Thread t2 = new JourneyThread(parser, this);

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI frame = new GUI();
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
	public GUI() {
		setTitle("Skånetrafiken");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 720, 450);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 192, 203));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(220, 20, 60));
		panel.setBounds(6, 6, 708, 200);
		contentPane.add(panel);
		panel.setLayout(null);
		
		textField_hallplats = new JTextField();
		textField_hallplats.setBounds(21, 77, 145, 28);
		panel.add(textField_hallplats);
		textField_hallplats.setColumns(10);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(193, 36, 509, 158);
		panel.add(scrollPane_1);
		
		textArea_result = new JTextArea();
		scrollPane_1.setViewportView(textArea_result);
		
		JLabel lblHllplats = new JLabel("Hållplats");
		lblHllplats.setFont(new Font("Lao Sangam MN", Font.PLAIN, 14));
		lblHllplats.setForeground(Color.WHITE);
		lblHllplats.setBounds(21, 60, 61, 16);
		panel.add(lblHllplats);
		
		JLabel lblResultat = new JLabel("Resultat");
		lblResultat.setFont(new Font("Lao Sangam MN", Font.PLAIN, 14));
		lblResultat.setForeground(Color.WHITE);
		lblResultat.setBounds(192, 16, 61, 16);
		panel.add(lblResultat);
		
		JButton btnNewButton = new JButton("Sök");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Thread t1 = new StationsThread(parser,gui);
				t1.start();
			}
		});
		btnNewButton.setFont(new Font("Lao Sangam MN", Font.PLAIN, 14));
		btnNewButton.setBounds(99, 117, 67, 34);
		panel.add(btnNewButton);
		
		JLabel lblStation = new JLabel("Station");
		lblStation.setForeground(Color.WHITE);
		lblStation.setFont(new Font("Lao Sangam MN", Font.BOLD, 20));
		lblStation.setBounds(6, 6, 90, 29);
		panel.add(lblStation);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(220, 20, 60));
		panel_1.setBounds(6, 215, 708, 207);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		textField_till = new JTextField();
		textField_till.setBounds(17, 116, 149, 28);
		panel_1.add(textField_till);
		textField_till.setColumns(10);
		
		textField_from = new JTextField();
		textField_from.setBounds(17, 60, 149, 28);
		panel_1.add(textField_from);
		textField_from.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(191, 35, 511, 166);
		panel_1.add(scrollPane);
		
		textArea_result2 = new JTextArea();
		scrollPane.setViewportView(textArea_result2);
		
		JLabel lblFrn = new JLabel("Från");
		lblFrn.setFont(new Font("Lao Sangam MN", Font.PLAIN, 14));
		lblFrn.setForeground(Color.WHITE);
		lblFrn.setBounds(17, 37, 61, 16);
		panel_1.add(lblFrn);
		
		JLabel lblTill = new JLabel("Till");
		lblTill.setFont(new Font("Lao Sangam MN", Font.PLAIN, 14));
		lblTill.setForeground(Color.WHITE);
		lblTill.setBounds(17, 100, 61, 16);
		panel_1.add(lblTill);
		
		JLabel lblResultat_1 = new JLabel("Resultat");
		lblResultat_1.setFont(new Font("Lao Sangam MN", Font.PLAIN, 14));
		lblResultat_1.setForeground(Color.WHITE);
		lblResultat_1.setBounds(191, 18, 61, 16);
		panel_1.add(lblResultat_1);
		
		JButton btnSkResa = new JButton("Sök Resa");
		btnSkResa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Thread t2 = new JourneyThread(parser,gui);
				t2.start();
				
			}
		});
		btnSkResa.setFont(new Font("Lao Sangam MN", Font.PLAIN, 14));
		btnSkResa.setBounds(66, 154, 100, 35);
		panel_1.add(btnSkResa);
		
		JLabel lblResa = new JLabel("Resa");
		lblResa.setForeground(Color.WHITE);
		lblResa.setFont(new Font("Lao Sangam MN", Font.BOLD, 20));
		lblResa.setBounds(6, 0, 90, 28);
		panel_1.add(lblResa);
	}
}
