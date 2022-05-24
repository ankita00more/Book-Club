import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.border.MatteBorder;

import net.proteanit.sql.DbUtils;

import java.awt.Color;
import java.sql.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import javax.swing.UIManager;

public class BookStore {

	public JFrame frame;
	private JTextField txtName;
	private JTextField txtEdition;
	private JTextField txtPrice;
	public JTable table;
	private JTextField txtSearch;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the application.
	 */
	public BookStore() {
		initialize();
		connect();
		table();
	}
	
	Connection con;
	PreparedStatement pst;
	Statement st;
	ResultSet rs;

	public void connect() {
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			 con = DriverManager.getConnection("jdbc:mysql://localhost/book_store","root","");
			
			
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
	
	public void table() {
	try {
		st=con.createStatement();
		rs=st.executeQuery("select * from book");
		table.setModel(DbUtils.resultSetToTableModel(rs));
		
		
	}
	catch(Exception es) {
		System.out.println(es);
	}
	}
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 745, 522);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(UIManager.getColor("Slider.tickColor"));
		panel.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		panel.setBounds(10, 37, 363, 231);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Registration");
		lblNewLabel_1.setForeground(UIManager.getColor("Slider.highlight"));
		lblNewLabel_1.setFont(new Font("Yu Gothic", Font.BOLD, 18));
		lblNewLabel_1.setBounds(110, 28, 120, 35);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Book Name");
		lblNewLabel_2.setForeground(UIManager.getColor("Slider.highlight"));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel_2.setBounds(32, 97, 110, 21);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("Edition");
		lblNewLabel_2_1.setForeground(UIManager.getColor("Slider.highlight"));
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel_2_1.setBounds(32, 142, 110, 21);
		panel.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_2 = new JLabel("Price");
		lblNewLabel_2_2.setForeground(UIManager.getColor("Slider.highlight"));
		lblNewLabel_2_2.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel_2_2.setBounds(32, 193, 110, 21);
		panel.add(lblNewLabel_2_2);
		
		txtName = new JTextField();
		txtName.setBounds(183, 97, 159, 20);
		panel.add(txtName);
		txtName.setColumns(10);
		
		txtEdition = new JTextField();
		txtEdition.setBounds(183, 143, 159, 20);
		panel.add(txtEdition);
		txtEdition.setColumns(10);
		
		txtPrice = new JTextField();
		txtPrice.setColumns(10);
		txtPrice.setBounds(183, 183, 159, 20);
		panel.add(txtPrice);
		
		JButton btnSave = new JButton("SAVE");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String bname,edition,price;
				bname=txtName.getText();
				edition=txtEdition.getText();
				price=txtPrice.getText();
				
				try {
					pst = con.prepareStatement("insert into book (name,edition,price) values(?,?,?)");
					pst.setString(1, bname);
					pst.setString(2, edition);
					pst.setString(3, price);
					int p=pst.executeUpdate();
					JOptionPane.showMessageDialog(null, "Record Added...");
					table();
					txtName.setText("");
					txtEdition.setText("");
					txtPrice.setText("");
					txtName.requestFocus();
				}
				catch(Exception ex) {
					System.out.println(ex);
				}
				
				
				
				
				
				
			}
		});
		btnSave.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		btnSave.setBounds(37, 279, 75, 35);
		frame.getContentPane().add(btnSave);
		
		JButton btnExit = new JButton("Logout");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				System.exit(0);
				
			}
		});
		btnExit.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		btnExit.setBounds(509, 430, 99, 35);
		frame.getContentPane().add(btnExit);
		
		JButton btnClear = new JButton("CLEAR");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				txtName.setText("");
				txtEdition.setText("");
				txtPrice.setText("");
				txtName.requestFocus();
			
			}
		});
		btnClear.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		btnClear.setBounds(152, 279, 85, 35);
		frame.getContentPane().add(btnClear);
		
		JScrollPane Scrollp = new JScrollPane();
		Scrollp.setBounds(389, 37, 330, 323);
		frame.getContentPane().add(Scrollp);
		
		table = new JTable();
		Scrollp.setViewportView(table);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(UIManager.getColor("Slider.tickColor"));
		panel_1.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		panel_1.setBounds(10, 357, 363, 96);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_2_2_1 = new JLabel("Book Id");
		lblNewLabel_2_2_1.setForeground(UIManager.getColor("Slider.highlight"));
		lblNewLabel_2_2_1.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel_2_2_1.setBounds(28, 57, 110, 21);
		panel_1.add(lblNewLabel_2_2_1);
		
		txtSearch = new JTextField();
		txtSearch.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				try {
					String id1 = txtSearch.getText();
					pst=con.prepareStatement("select name, edition, price from book where id = ?");
					pst.setString(1, id1);
					rs=pst.executeQuery();
					
					if(rs.next() == true) {
						String name= rs.getString(1);
						String edition= rs.getString(2);
						String price= rs.getString(3);
						
						txtName.setText(name);
						txtEdition.setText(edition);
						txtPrice.setText(price);
						
					}
					else {
						txtName.setText("");
						txtEdition.setText("");
						txtPrice.setText("");
						
					}
				}
				catch(Exception e1) {
					System.out.println(e1);
				}
			}
		});
		txtSearch.setColumns(10);
		txtSearch.setBounds(174, 60, 159, 20);
		panel_1.add(txtSearch);
		
		JLabel lblNewLabel_1_1 = new JLabel("Search");
		lblNewLabel_1_1.setForeground(UIManager.getColor("Slider.highlight"));
		lblNewLabel_1_1.setFont(new Font("Yu Gothic", Font.BOLD, 18));
		lblNewLabel_1_1.setBounds(140, 11, 77, 35);
		panel_1.add(lblNewLabel_1_1);
		
		JButton btnUpdate = new JButton("UPDATE");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String bname,edition,price,bid;
				bname=txtName.getText();
				edition=txtEdition.getText();
				price=txtPrice.getText();
				bid=txtSearch.getText();
				
				try {
					pst = con.prepareStatement("update book set name=?, edition=?, price=? where id=?");
					pst.setString(1, bname);
					pst.setString(2, edition);
					pst.setString(3, price);
					pst.setString(4, bid);
					int p=pst.executeUpdate();
					JOptionPane.showMessageDialog(null, "Record Updated...");
					table();
					txtName.setText("");
					txtEdition.setText("");
					txtPrice.setText("");
					txtName.requestFocus();
				}
				catch(Exception ex) {
					System.out.println(ex);
				}
				
				
				
			}
		});
		btnUpdate.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		btnUpdate.setBounds(429, 384, 99, 35);
		frame.getContentPane().add(btnUpdate);
		
		JButton btnDelete = new JButton("DELETE");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				String bid=txtSearch.getText();
				
				pst=con.prepareStatement("delete from book where id=?");
				pst.setString(1, bid);
				pst.executeUpdate();
				JOptionPane.showMessageDialog(null,"Record deleted");
				table();
				txtName.setText("");
				txtEdition.setText("");
				txtPrice.setText("");
				}
				catch(Exception e2){
					System.out.println(e2);
				}
			}
		});
		btnDelete.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		btnDelete.setBounds(566, 384, 106, 35);
		frame.getContentPane().add(btnDelete);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon("C:\\Users\\ajay\\Downloads\\Flores secas_.jpg"));
		lblNewLabel_3.setBounds(0, 0, 729, 483);
		frame.getContentPane().add(lblNewLabel_3);
	}
}
