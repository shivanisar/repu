package csed_data;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.ButtonGroup;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;

public class details {

	private JFrame frame;
	private JTextField tn;
	private JTextField te;
	private JTextField tp;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					details window = new details();
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
	public details() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 528, 332);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Name");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(29, 41, 58, 14);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Email");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1.setBounds(29, 85, 46, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Fav Programming");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_2.setBounds(29, 122, 131, 24);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Gender");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_3.setBounds(29, 170, 85, 14);
		frame.getContentPane().add(lblNewLabel_3);
		
		tn = new JTextField();
		tn.setBounds(180, 40, 176, 20);
		frame.getContentPane().add(tn);
		tn.setColumns(10);
		
		te = new JTextField();
		te.setBounds(180, 84, 176, 20);
		frame.getContentPane().add(te);
		te.setColumns(10);
		
		JComboBox cp = new JComboBox();
		cp.setModel(new DefaultComboBoxModel(new String[] {"Select", "C", "C++", "JAVA", "PYTHON", "C#"}));
		cp.setBounds(180, 125, 176, 22);
		frame.getContentPane().add(cp);
		
		JLabel lblNewLabel_4 = new JLabel("Phn no");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_4.setBounds(29, 213, 85, 14);
		frame.getContentPane().add(lblNewLabel_4);
		
		JRadioButton r1 = new JRadioButton("Male");
		r1.setFont(new Font("Tahoma", Font.BOLD, 12));
		r1.setBounds(180, 167, 65, 23);
		frame.getContentPane().add(r1);
		
		JRadioButton r2 = new JRadioButton("Female");
		r2.setFont(new Font("Tahoma", Font.BOLD, 13));
		r2.setBounds(247, 167, 109, 23);
		frame.getContentPane().add(r2);
		
		ButtonGroup bg=new ButtonGroup();
		bg.add(r1);
		bg.add(r2);
		
		tp = new JTextField();
		tp.setBounds(180, 212, 176, 20);
		frame.getContentPane().add(tp);
		tp.setColumns(10);
		
		JButton btnNewButton = new JButton("Submit");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name=tn.getText();
				String email=te.getText();
				String favpl=(String) cp.getSelectedItem();
				String gender;
				if(r1.isSelected())
				{
					gender="Male";
					
				}
				else if(r2.isSelected())
				{
					gender="Female";
				}
				else
				{
					gender="Invalid";
				}
				String ph=tp.getText();
				int phno=Integer.parseInt(ph);
				JOptionPane.showMessageDialog(btnNewButton, "Hello \n"+name+"\n"+"Registration Done");
				try {
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/csed","root","mrec");
					String q="Insert into student value('"+name+"','"+email+"','"+favpl+"','"+gender+"','"+phno+"')";
					Statement sta=con.createStatement();
					sta.execute(q);
					con.close();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton.setBounds(87, 259, 89, 23);
		frame.getContentPane().add(btnNewButton);
	}
}
