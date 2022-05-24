import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.*;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.UIManager;

public class Login {

	public JFrame frame;
	private JTextField txtUser;
	private JTextField txtPswd;
	private JLabel lblNewLabel_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 734, 498);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Username");
		lblNewLabel.setForeground(UIManager.getColor("Slider.tickColor"));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(23, 224, 93, 33);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPassword.setBounds(23, 283, 93, 33);
		frame.getContentPane().add(lblPassword);
		
		txtUser = new JTextField();
		txtUser.setBounds(114, 232, 127, 20);
		frame.getContentPane().add(txtUser);
		txtUser.setColumns(10);
		
		txtPswd = new JTextField();
		txtPswd.setColumns(10);
		txtPswd.setBounds(114, 291, 127, 20);
		frame.getContentPane().add(txtPswd);
		
		JButton btnLog = new JButton("Login");
		btnLog.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnLog.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String user = txtUser.getText();
				String pswd = txtPswd.getText();
				
				try {
				 Class.forName("com.mysql.cj.jdbc.Driver");
				 Connection con = DriverManager.getConnection("jdbc:mysql://localhost/book_store","root","");
				 PreparedStatement pst=con.prepareStatement("select * from user where username=? and password=?");
					pst.setString(1, user);
					pst.setString(2,pswd);
					ResultSet rs=pst.executeQuery();
					
					
				 if (rs.next()==true) {
					 String tname = rs.getString(2);
					 String tpswd = rs.getString(3);
					 
					 if(tname.equals(user) & tpswd.equals(pswd)) {
					 
						 UserLog window = new UserLog();
						 window.frame.setVisible(true);
					 }
					 
				 }
				 else {
					 JOptionPane.showMessageDialog(null,  "You are not register");
				 }
				
				 }
				catch(Exception ex1) {
					System.out.println(ex1);
				}
				
			}
		});
		btnLog.setBounds(70, 340, 81, 33);
		frame.getContentPane().add(btnLog);
		
		lblNewLabel_1 = new JLabel("Welcome to BookClub");
		lblNewLabel_1.setForeground(UIManager.getColor("Slider.tickColor"));
		lblNewLabel_1.setBackground(Color.CYAN);
		lblNewLabel_1.setFont(new Font("Poor Richard", Font.BOLD, 55));
		lblNewLabel_1.setBounds(108, 62, 526, 71);
		frame.getContentPane().add(lblNewLabel_1);
		
		JButton btnSignup = new JButton("SignUp");
		btnSignup.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SignUp window = new SignUp();
				window.frame.setVisible(true);
			
			}
		});
		btnSignup.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnSignup.setBounds(604, 11, 92, 33);
		frame.getContentPane().add(btnSignup);
		
		JButton btnAdminLogin = new JButton("Admin Login");
		btnAdminLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Adminlogin window = new Adminlogin();
				window.frame.setVisible(true);
			
			}
		});
		btnAdminLogin.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnAdminLogin.setBounds(51, 395, 133, 33);
		frame.getContentPane().add(btnAdminLogin);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\ajay\\Downloads\\download.png"));
		lblNewLabel_2.setBounds(0, 0, 718, 459);
		frame.getContentPane().add(lblNewLabel_2);
	}
}
