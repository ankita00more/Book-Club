import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.border.MatteBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.JLabel;
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class UserLog {

	public JFrame frame;
	private JTable table;
	private JTextField txtSearch;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the application.
	 */
	public UserLog() {
		initialize();
		data();
	}
	Connection con;
	PreparedStatement pst;
	Statement st;
	ResultSet rs;

	public void data() {
		
		try {

			Class.forName("com.mysql.cj.jdbc.Driver");
			 con = DriverManager.getConnection("jdbc:mysql://localhost/book_store","root","");
			 	st=con.createStatement();
				rs=st.executeQuery("select * from book");
				table.setModel(DbUtils.resultSetToTableModel(rs));
				
		}
catch(Exception e) {
			
		}
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 753, 507);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		table = new JTable();
		table.setBounds(199, 135, 1, 1);
		//frame.getContentPane().add(table);
		
		JScrollPane Scrollp = new JScrollPane();
		Scrollp.setBounds(81, 107, 566, 323);
		frame.getContentPane().add(Scrollp);
		Scrollp.setViewportView(table);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		panel_1.setBackground(Color.BLACK);
		panel_1.setBounds(113, 22, 501, 65);
		frame.getContentPane().add(panel_1);
		
		JLabel lblNewLabel_2_2_1 = new JLabel("Book Name");
		lblNewLabel_2_2_1.setForeground(Color.WHITE);
		lblNewLabel_2_2_1.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel_2_2_1.setBounds(34, 21, 110, 21);
		panel_1.add(lblNewLabel_2_2_1);
		
		txtSearch = new JTextField();
		txtSearch.setColumns(10);
		txtSearch.setBounds(181, 24, 159, 20);
		panel_1.add(txtSearch);
		
		JButton btnNewButton = new JButton("Search");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String name = txtSearch.getText();
					pst=con.prepareStatement("select name,edition, price from book where name= ?");
					pst.setString(1, name);
					ResultSet rs1=pst.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs1));
					
					
//					if(rs.next() == true) {
//						table.setModel(DbUtils.resultSetToTableModel(rs));
//					}
				}
				catch(Exception e3) {
					System.out.println(e3);
				}
				
			}
		});
		btnNewButton.setBounds(375, 21, 89, 23);
		panel_1.add(btnNewButton);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		JButton btnBack = new JButton("<--");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtSearch.setText("");
				data();
			}
		});
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnBack.setBounds(10, 22, 61, 27);
		frame.getContentPane().add(btnBack);
		
		JButton btnLogout = new JButton("Logout");
		btnLogout.setForeground(Color.RED);
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnLogout.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnLogout.setBounds(625, 439, 80, 18);
		frame.getContentPane().add(btnLogout);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\ajay\\Downloads\\download.png"));
		lblNewLabel.setBounds(0, 0, 737, 468);
		frame.getContentPane().add(lblNewLabel);
	}
}
