import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.*;
import javax.swing.ImageIcon;
public class SignUp {

	public JFrame frame;
	private JTextField txtUser;
	private JTextField txtPswd;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the application.
	 */
	public SignUp() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 729, 498);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Username");
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(28, 190, 93, 33);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPassword.setBounds(28, 234, 93, 33);
		frame.getContentPane().add(lblPassword);
		
		txtUser = new JTextField();
		txtUser.setColumns(10);
		txtUser.setBounds(118, 198, 127, 20);
		frame.getContentPane().add(txtUser);
		
		txtPswd = new JTextField();
		txtPswd.setColumns(10);
		txtPswd.setBounds(118, 242, 127, 20);
		frame.getContentPane().add(txtPswd);
		
		JButton btnSignup = new JButton("SignUp");
		btnSignup.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String user = txtUser.getText();
				String pswd = txtPswd.getText();
				
				try {
					
					Class.forName("com.mysql.cj.jdbc.Driver");
					 Connection con = DriverManager.getConnection("jdbc:mysql://localhost/book_store","root","");
					 PreparedStatement pst = con.prepareStatement("insert into user (username,password) values(?,?)");
					 pst.setString(1, user);
					 pst.setString(2, pswd);
					 int p = pst.executeUpdate();
					 JOptionPane.showMessageDialog(null, "Registered...");
					 Login window = new Login();
					window.frame.setVisible(true);
					
				}
				catch(Exception ex) {
					System.out.println(ex);
				}

				
			}
		});
		btnSignup.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnSignup.setBounds(81, 295, 92, 33);
		frame.getContentPane().add(btnSignup);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\ajay\\Downloads\\download.png"));
		lblNewLabel_1.setBounds(0, 0, 713, 459);
		frame.getContentPane().add(lblNewLabel_1);
	}

}
