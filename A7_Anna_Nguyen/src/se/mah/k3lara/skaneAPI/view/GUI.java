package se.mah.k3lara.skaneAPI.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.table.DefaultTableModel;

import se.mah.k3lara.skaneAPI.model.Line;
import se.mah.k3lara.skaneAPI.model.Lines;
import se.mah.k3lara.skaneAPI.model.Station;
import se.mah.k3lara.skaneAPI.xmlparser.Parser;

import java.awt.Font;
import java.awt.Color;
import java.util.Calendar;

import javax.swing.JTextArea;

public class GUI extends JFrame {
	GUI g = this;
	private Parser parser = new Parser();
	
	Thread search = new SearchThread(this, parser);
	private JPanel contentPane;

	public JTextArea textAreaLinje = new JTextArea();
	public JTextArea textAreaDestination = new JTextArea();
	public JTextArea textAreaAvgang = new JTextArea();
	public JTextArea textAreaDelayed = new JTextArea();


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
		Thread search = new SearchThread(this, parser);
		search.start();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 724, 455);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		panel.setBounds(0, 0, 724, 433);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblUbtshallen = new JLabel("Ubåtshallen");
		lblUbtshallen.setForeground(Color.ORANGE);
		lblUbtshallen.setFont(new Font("Lucida Grande", Font.PLAIN, 24));
		lblUbtshallen.setBounds(289, 6, 145, 30);
		panel.add(lblUbtshallen);
		
		JLabel lblLinje = new JLabel("Linje");
		lblLinje.setForeground(Color.ORANGE);
		lblLinje.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		lblLinje.setBounds(29, 56, 75, 30);
		panel.add(lblLinje);
		
		JLabel lblDestination = new JLabel("Destination");
		lblDestination.setForeground(Color.ORANGE);
		lblDestination.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		lblDestination.setBounds(202, 56, 113, 30);
		panel.add(lblDestination);
		
		JLabel lblAvgr = new JLabel("Avgår");
		lblAvgr.setForeground(Color.ORANGE);
		lblAvgr.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		lblAvgr.setBounds(422, 56, 68, 30);
		panel.add(lblAvgr);
		
		JLabel lblFrsenad = new JLabel("Försenad");
		lblFrsenad.setForeground(Color.ORANGE);
		lblFrsenad.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		lblFrsenad.setBounds(566, 56, 107, 30);
		panel.add(lblFrsenad);
		textAreaLinje.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
		
		textAreaLinje.setEditable(false);
		textAreaLinje.setBackground(Color.BLACK);
		textAreaLinje.setForeground(new Color(255, 215, 0));
		textAreaLinje.setBounds(4, 83, 123, 344);
		panel.add(textAreaLinje);
		textAreaDestination.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
		
		textAreaDestination.setEditable(false);
		textAreaDestination.setBackground(Color.BLACK);
		textAreaDestination.setForeground(new Color(255, 215, 0));
		textAreaDestination.setBounds(128, 83, 262, 344);
		panel.add(textAreaDestination);
		textAreaAvgang.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
		
		textAreaAvgang.setEditable(false);
		textAreaAvgang.setBackground(Color.BLACK);
		textAreaAvgang.setForeground(new Color(255, 215, 0));
		textAreaAvgang.setBounds(391, 83, 169, 344);
		panel.add(textAreaAvgang);
		textAreaDelayed.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
		
		textAreaDelayed.setEditable(false);
		textAreaDelayed.setBackground(new Color(0, 0, 0));
		textAreaDelayed.setForeground(new Color(255, 215, 0));
		textAreaDelayed.setBounds(561, 83, 160, 344);
		panel.add(textAreaDelayed);
			
		}

}
