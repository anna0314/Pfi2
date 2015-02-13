import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JLabel;

import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class HumansAndDogsGUI extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JButton btnNewHuman;
	private JButton btnBuyDog;
	private JButton btnPrintInfo;

	private Human human;
	private Dog dog;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HumansAndDogsGUI frame = new HumansAndDogsGUI();
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
	public HumansAndDogsGUI() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 525, 430);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 102, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		textField = new JTextField();
		textField.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
		textField.setBounds(72, 58, 170, 35);
		contentPane.add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
		textField_1.setBounds(72, 105, 170, 35);
		contentPane.add(textField_1);
		textField_1.setColumns(10);

		JTextArea textArea = new JTextArea();
		textArea.setBounds(72, 241, 376, 57);
		contentPane.add(textArea);

		JTextArea textArea_1 = new JTextArea();
		textArea_1.setBounds(72, 330, 377, 57);
		contentPane.add(textArea_1);



		btnNewHuman = new JButton("New Human");
		btnNewHuman.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if(textField.getText().length()<3){
					textArea_1.setText("Too Short");

				}else{
					human = new Human(textField.getText()); 
					System.out.println(textField.getText());


				}
			}});
		btnNewHuman.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
		btnNewHuman.setBounds(289, 59, 141, 35);
		contentPane.add(btnNewHuman);



		btnBuyDog = new JButton("Buy Dog");
		btnBuyDog.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if(human != null){
					dog = new Dog(textField_1.getText()); 	
					human.buyDog(dog);
					textArea.setText("");
				}else{
					textArea_1.setText("Dog does not exist");

				}


			}
		});
		btnBuyDog.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
		btnBuyDog.setBounds(289, 106, 141, 35);
		contentPane.add(btnBuyDog);

		btnPrintInfo = new JButton("Print Info");
		btnPrintInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if(human != null){
					textArea.setText(null);
					textArea.setText(human.getInfo());

				}else{
					textArea.setText(human.getInfo());
				}


			}
		});
		btnPrintInfo.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
		btnPrintInfo.setBounds(289, 169, 141, 35);
		contentPane.add(btnPrintInfo);

		JLabel lblHumansAndDogs = new JLabel("Humans and Dogs");
		lblHumansAndDogs.setFont(new Font("Lucida Grande", Font.BOLD, 16));
		lblHumansAndDogs.setBounds(187, 6, 157, 28);
		contentPane.add(lblHumansAndDogs);

		JLabel lblInfo = new JLabel("Info");
		lblInfo.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
		lblInfo.setBounds(72, 221, 61, 16);
		contentPane.add(lblInfo);

		JLabel lblErrormessage = new JLabel("ErrorMessage");
		lblErrormessage.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
		lblErrormessage.setBounds(71, 310, 113, 16);
		contentPane.add(lblErrormessage);
	}
}
