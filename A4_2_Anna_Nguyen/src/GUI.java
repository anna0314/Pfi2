import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;


public class GUI extends JFrame {

	private JPanel contentPane;

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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 615, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(6, 0, 603, 272);
		contentPane.add(textArea);
		
		//Skapar ArrayList med olika djur
		ArrayList<Animal> myAnimals = new ArrayList<Animal>();
		
		//Kallar på FriendlyName från klassen Animal
			Cat cat = new Cat("Lynx lynx", 9, 3);
			cat.setFriendlyName("Misse");
			
			Snake snake = new Snake("Sean", false);
			snake.setFriendlyName("QWERT");
			
			Cat cat1 = new Cat("Lynx lynx", 7, 4);
			cat1.setFriendlyName("Mustard");
			
			Snake snake1 = new Snake("Vipera aspis", true);
			snake1.setFriendlyName("My");
			
			Cat cat2 = new Cat("Lynx lynx", 4, 5);
			cat2.setFriendlyName("Bubbles");

			myAnimals.add(cat);
			myAnimals.add(snake);
			myAnimals.add(cat1);
			myAnimals.add(cat2);
			myAnimals.add(snake1);
			myAnimals.add(new Dog ("Jack","Canis adustus",5,false));
			myAnimals.add(new Dog ("Chuck","Canis lupus",8,false));
			myAnimals.add(new Dog ("Charlie", "Canis rufus",2,true));

				for (Animal myList : myAnimals) {
					textArea.append(myList.getInfo() + "\n");
	
				}
		}
}
