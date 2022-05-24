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
import javax.swing.ImageIcon;

public class Adminlogin {

	public JFrame frame;
	private JTextField txtUser;
	private JTextField txtPswd;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the application.
	 */
	public Adminlogin() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 740, 507);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Username");
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(21, 211, 93, 33);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPassword.setBounds(21, 251, 93, 33);
		frame.getContentPane().add(lblPassword);
		
		txtUser = new JTextField();
		txtUser.setColumns(10);
		txtUser.setBounds(114, 219, 127, 20);
		frame.getContentPane().add(txtUser);
		
		txtPswd = new JTextField();
		txtPswd.setColumns(10);
		txtPswd.setBounds(114, 259, 127, 20);
		frame.getContentPane().add(txtPswd);
		
		JButton btnLog = new JButton("Login");
		btnLog.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String user="anki";
				String pswd="1211";
				
				String u1=txtUser.getText();
				String p1=txtPswd.getText();
				
				if (user.equals(u1) && pswd.equals(p1)) {
					BookStore window = new BookStore();
					window.frame.setVisible(true);
				}
				else {
					JOptionPane.showMessageDialog(null, "Invalid");
				}
				
			}
		});
		btnLog.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnLog.setBounds(80, 302, 81, 33);
		frame.getContentPane().add(btnLog);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\ajay\\Downloads\\download.png"));
		lblNewLabel_1.setBounds(0, 0, 724, 468);
		frame.getContentPane().add(lblNewLabel_1);
	}
}
