import java.util.Calendar;
import java.util.Timer;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

import javax.swing.SwingConstants;

import java.awt.Color;

import javax.swing.UIManager;
import java.awt.Toolkit;

public class DigitalClockGUI extends JFrame {
	ClockLogic clockLogic;
	
	private JTextField textField_hour;
	private JTextField textField_minutes;
	
	private int alarmH;
	private int alarmM;
	
	private JPanel contentPane;
	JLabel labelClock = new JLabel("");
	 JLabel labelAlarmTime = new JLabel("00:00");


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DigitalClockGUI frame = new DigitalClockGUI();
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
	public DigitalClockGUI() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(DigitalClockGUI.class.getResource("/Images/alarm.png")));
		setTitle("Alarm Clock");
		
		//initiates the ClockLogic class
		clockLogic = new ClockLogic(DigitalClockGUI.this);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 460);
		contentPane = new JPanel();
		contentPane.setBackground(Color.GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		labelClock.setHorizontalAlignment(SwingConstants.CENTER);
		labelClock.setFont(new Font("Lucida Grande", Font.PLAIN, 50));
		labelClock.setBackground(Color.WHITE);
		labelClock.setBounds(36, 41, 305, 81);
		contentPane.add(labelClock);
				
	
		labelAlarmTime.setForeground(Color.WHITE);
		labelAlarmTime.setFont(new Font("Lucida Grande", Font.PLAIN, 44));
		labelAlarmTime.setBackground(Color.WHITE);
		labelAlarmTime.setHorizontalAlignment(SwingConstants.CENTER);
		labelAlarmTime.setBounds(21, 163, 329, 61);
		contentPane.add(labelAlarmTime);
		
		final JLabel lblpic = new JLabel("");
		lblpic.setIcon(new ImageIcon(DigitalClockGUI.class.getResource("/Images/Retro-Mushroom-1UP-3-icon.png")));
		lblpic.setBounds(300, 163, 53, 65);
		contentPane.add(lblpic);
		
		textField_hour = new JTextField();
		textField_hour.setFont(new Font("Lucida Grande", Font.PLAIN, 24));
		textField_hour.setHorizontalAlignment(SwingConstants.CENTER);
		textField_hour.setBounds(99, 254, 77, 56);
		contentPane.add(textField_hour);
		textField_hour.setColumns(10);
		
		textField_minutes = new JTextField();
		textField_minutes.setFont(new Font("Lucida Grande", Font.PLAIN, 24));
		textField_minutes.setHorizontalAlignment(SwingConstants.CENTER);
		textField_minutes.setBounds(199, 254, 77, 56);
		contentPane.add(textField_minutes);
		textField_minutes.setColumns(10);
	
		JButton btnSetAlarm = new JButton("Set Alarm");
		btnSetAlarm.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		btnSetAlarm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				alarmH = Integer.parseInt(textField_hour.getText());
				alarmM = Integer.parseInt(textField_minutes.getText());
				
				String zero = "";
				String zero2 = "";
				
				if(alarmH<10){
					zero = "0";
				}
				
				if(alarmM<10){
					zero2 = "0";
				}	
				
				lblpic.setIcon(new ImageIcon(DigitalClockGUI.class.getResource("/Images/retro_mushroom_super_3.png")));
				//contentPane.setBackground(Color.BLACK);
				clockLogic.setAlarm(alarmH, alarmM);
				labelAlarmTime.setText(zero+alarmH+":" + zero2 + alarmM);

			}
		});
		btnSetAlarm.setBounds(99, 322, 179, 42);
		contentPane.add(btnSetAlarm);

		JButton btnClearAlarm = new JButton("Clear Alarm");
		btnClearAlarm.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		btnClearAlarm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					labelAlarmTime.setText("00:00");
					textField_hour.setText("");
					textField_minutes.setText("");
					lblpic.setIcon(new ImageIcon(DigitalClockGUI.class.getResource("/Images/Retro-Mushroom-1UP-3-icon.png")));
					contentPane.setBackground(Color.GRAY);
					clockLogic.clearAlarm();
			}
			
		});
		btnClearAlarm.setBounds(99, 376, 179, 42);
		contentPane.add(btnClearAlarm);
		
		JLabel lblHours = new JLabel("Hour");
		lblHours.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
		lblHours.setForeground(Color.WHITE);
		lblHours.setHorizontalAlignment(SwingConstants.CENTER);
		lblHours.setBounds(99, 240, 77, 16);
		contentPane.add(lblHours);
		
		JLabel lblMinutes = new JLabel("Minutes");
		lblMinutes.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
		lblMinutes.setForeground(Color.WHITE);
		lblMinutes.setHorizontalAlignment(SwingConstants.CENTER);
		lblMinutes.setBounds(199, 240, 77, 16);
		contentPane.add(lblMinutes);
		
		JLabel label = new JLabel(":");
		label.setForeground(Color.WHITE);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
		label.setBounds(165, 250, 46, 61);
		contentPane.add(label);
		
		JLabel lblAlarm = new JLabel("Alarm at:");
		lblAlarm.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lblAlarm.setForeground(Color.WHITE);
		lblAlarm.setHorizontalAlignment(SwingConstants.CENTER);
		lblAlarm.setBounds(132, 144, 104, 16);
		contentPane.add(lblAlarm);
		
		JLabel lblTime = new JLabel("Time:");
		lblTime.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
		lblTime.setForeground(new Color(255, 255, 255));
		lblTime.setBounds(165, 6, 61, 16);
		contentPane.add(lblTime);
	}

	public void setTimeOnLabel(String time){
		labelClock.setText(time);

		}
	
	public void alarm(boolean activate){
		if(true){
			labelAlarmTime.setText("WAKE UP");
			contentPane.setBackground(Color.RED);

		}
		
	}
}
