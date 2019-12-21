package project;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.table.*;
import java.sql.*;
import java.awt.event.*;
import java.util.*;

public class Admin extends JFrame 
{
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField1;
	private JPasswordField passwordField;
	private JTable table;
	static private String fld;

	public static void main() 
	{
		Admin frame = new Admin();
		frame.setVisible(true);
	}

	public Admin() 
	{
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(369, 180,700,450);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblX = new JLabel("");
	
		lblX.setIcon(new ImageIcon(this.getClass().getResource("/images/back.png")));
		lblX.addMouseListener(new MouseAdapter() 
		{
			@Override
			public void mouseClicked(MouseEvent arg0) 
			{
				dispose();
			}
		});
		lblX.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblX.setHorizontalAlignment(SwingConstants.CENTER);
		lblX.setBounds(633, 1, 67, 61);
		getContentPane().add(lblX);
		
		JLabel lblWlecomeAdministrator = new JLabel("Functions");
		lblWlecomeAdministrator.setForeground(Color.WHITE);
		lblWlecomeAdministrator.setFont(new Font("Sitka small", Font.BOLD, 28));
		lblWlecomeAdministrator.setHorizontalAlignment(SwingConstants.CENTER);
		lblWlecomeAdministrator.setBounds(402, 11, 228, 42);
	
		contentPane.add(lblWlecomeAdministrator);
		
		JLabel label = new JLabel("");
		label.addMouseListener(new MouseAdapter() 
		{
			@Override
			public void mouseClicked(MouseEvent arg0) 
			{
				Admin admin=new Admin();
				admin.addTeacher();
				admin.setVisible(true);
			}
		});
		label.setIcon(new ImageIcon(this.getClass().getResource("/images/addTeacher.png")));
		label.setBounds(223, 155, 64, 64);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("");
		label_1.addMouseListener(new MouseAdapter() 
		{
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				Admin admin=new Admin();
				admin.deleteTeacher();
				admin.setVisible(true);
			}
		});
		label_1.setIcon(new ImageIcon(this.getClass().getResource("/images/removeTeacher.png")));
		label_1.setBounds(365, 155, 64, 64);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("");
		label_2.addMouseListener(new MouseAdapter() 
		{
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				Admin admin=new Admin();
				admin.addStudent();
				admin.setVisible(true);
			}
		});
		label_2.setIcon(new ImageIcon(this.getClass().getResource("/images/addStudent.png")));
		label_2.setBounds(105, 64, 64, 64);
		contentPane.add(label_2);
		
		JLabel label_3 = new JLabel("");
		label_3.addMouseListener(new MouseAdapter() 
		{
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				Admin admin=new Admin();
				admin.deleteStudent();
				admin.setVisible(true);
			}
		});
		label_3.setIcon(new ImageIcon(this.getClass().getResource("/images/removeStudent.png")));
		label_3.setBounds(502, 64, 64, 64);
		contentPane.add(label_3);
		
		JLabel lblAdd = new JLabel("ADD");
		lblAdd.setFont(new Font("Sitka Small", Font.BOLD, 12));
		lblAdd.setHorizontalAlignment(SwingConstants.CENTER);
		lblAdd.setBackground(Color.BLACK);
		lblAdd.setBounds(94, 139, 94, 20);
		contentPane.add(lblAdd);
		
		JLabel lblStudent = new JLabel("STUDENT");
		lblStudent.setFont(new Font("Sitka Small", Font.BOLD, 12));
		lblStudent.setHorizontalAlignment(SwingConstants.CENTER);
		lblStudent.setBounds(94, 155, 94, 20);
		contentPane.add(lblStudent);
		
		JLabel lblDelete = new JLabel("DELETE");
		lblDelete.setHorizontalAlignment(SwingConstants.CENTER);
		lblDelete.setFont(new Font("Sitka Small", Font.BOLD, 12));
		lblDelete.setBackground(Color.BLACK);
		lblDelete.setBounds(485, 139, 110, 20);
		contentPane.add(lblDelete);
		
		JLabel label_5 = new JLabel("STUDENT");
		label_5.setHorizontalAlignment(SwingConstants.CENTER);
		label_5.setFont(new Font("Sitka Small", Font.BOLD, 12));
		label_5.setBounds(485, 157, 110, 20);
		contentPane.add(label_5);
		
		JLabel label_4 = new JLabel("ADD");
		label_4.setHorizontalAlignment(SwingConstants.CENTER);
		label_4.setFont(new Font("Sitka Small", Font.BOLD, 12));
		label_4.setBackground(Color.BLACK);
		label_4.setBounds(223, 230, 64, 20);
		contentPane.add(label_4);
		
		JLabel label_6 = new JLabel("DELETE");
		label_6.setHorizontalAlignment(SwingConstants.CENTER);
		label_6.setFont(new Font("Sitka Small", Font.BOLD, 12));
		label_6.setBackground(Color.BLACK);
		label_6.setBounds(347, 230, 99, 20);
		contentPane.add(label_6);
		
		JLabel lblTeacher = new JLabel("TEACHER");
		lblTeacher.setHorizontalAlignment(SwingConstants.CENTER);
		lblTeacher.setFont(new Font("Sitka Small", Font.BOLD, 12));
		lblTeacher.setBounds(206, 250, 99, 20);
		contentPane.add(lblTeacher);
		
		JLabel lblTeacher_1 = new JLabel("TEACHER");
		lblTeacher_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblTeacher_1.setFont(new Font("Sitka Small", Font.BOLD, 12));
		lblTeacher_1.setBounds(347, 252, 99, 20);
		contentPane.add(lblTeacher_1);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.addMouseListener(new MouseAdapter() 
		{
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				Admin admin=new Admin();
				admin.getTeacherReport();
				admin.setVisible(true);
			}
		});
		lblNewLabel.setIcon(new ImageIcon(this.getClass().getResource("/images/reportTeacher.png")));
		lblNewLabel.setBounds(83, 200, 64, 64);
		contentPane.add(lblNewLabel);
		
		JLabel label_8 = new JLabel("");
		label_8.addMouseListener(new MouseAdapter() 
		{
			@Override
			public void mouseClicked(MouseEvent arg0) 
			{
				Admin admin=new Admin();
				admin.getStudentReport();
				admin.setVisible(true);
			}
		});
		label_8.setIcon(new ImageIcon(this.getClass().getResource("/images/reportStudent.png")));
		label_8.setBounds(542, 200, 64, 64);
		contentPane.add(label_8);
		
		JLabel label_9 = new JLabel("TEACHER");
		label_9.setHorizontalAlignment(SwingConstants.CENTER);
		label_9.setFont(new Font("Sitka Small", Font.BOLD, 12));
		label_9.setBounds(70, 273, 99, 20);
		contentPane.add(label_9);
		
		JLabel lblReport = new JLabel("REPORT");
		lblReport.setHorizontalAlignment(SwingConstants.CENTER);
		lblReport.setFont(new Font("Sitka Small", Font.BOLD, 12));
		lblReport.setBounds(70, 296, 99, 20);
		contentPane.add(lblReport);
		
		JLabel label_10 = new JLabel("STUDENT");
		label_10.setHorizontalAlignment(SwingConstants.CENTER);
		label_10.setFont(new Font("Sitka Small", Font.BOLD, 12));
		label_10.setBounds(524, 275, 94, 20);
		contentPane.add(label_10);
		
		JLabel label_11 = new JLabel("REPORT");
		label_11.setHorizontalAlignment(SwingConstants.CENTER);
		label_11.setFont(new Font("Sitka Small", Font.BOLD, 12));
		label_11.setBounds(519, 298, 99, 20);
		contentPane.add(label_11);
		
		JLabel label1 = new JLabel(" ");
		label1.setIcon(new ImageIcon(this.getClass().getResource("/images/adminBackground.jpg")));
		label1.setBounds(0, 1, 700, 450);
		
		contentPane.add(label1);
	}
	
	public void addStudent()
	{
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(369, 180, 700, 450);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(192, 192, 192));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblX = new JLabel("X");
		lblX.setForeground(new Color(255, 255, 255));
		lblX.addMouseListener(new MouseAdapter() 
		{
			@Override
			public void mouseClicked(MouseEvent arg0) 
			{
				dispose();
			}
		});
		lblX.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblX.setHorizontalAlignment(SwingConstants.CENTER);
		lblX.setBounds(654, 3, 46, 55);
		getContentPane().add(lblX);
		
		JLabel lblEnterStudentNumberid = new JLabel("Enter Student Enrollment Number:");
		lblEnterStudentNumberid.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblEnterStudentNumberid.setBounds(95, 91, 276, 39);
		contentPane.add(lblEnterStudentNumberid);

		textField1 = new JTextField();
		textField1.setBounds(352, 91, 177, 39);
		contentPane.add(textField1);
		textField1.setColumns(10);

		JLabel lblEnterStudentNameid = new JLabel("Enter Student Name:");
		lblEnterStudentNameid.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblEnterStudentNameid.setBounds(95, 151, 276, 39);
		contentPane.add(lblEnterStudentNameid);

		textField = new JTextField();
		textField.setBounds(352, 151, 177, 39);
		contentPane.add(textField);
		textField.setColumns(10);

		JButton btnCreate = new JButton("   Create");
		btnCreate.setBorder(BorderFactory.createLineBorder(Color.black,2));
		btnCreate.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnCreate.setIcon(new ImageIcon(this.getClass().getResource("/images/add.png")));
		btnCreate.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				String eno=textField1.getText();
				String s=textField.getText();
				String branch=eno.substring(7,9);
				int i=new Random().nextInt(9999-1000)+1000;
				int uid=1;
				boolean w=true;
				try
				{
					Class.forName("com.mysql.jdbc.Driver");
					Connection c=DriverManager.getConnection("jdbc:mysql://localhost/college", "root", "root");
					while(w)
					{
						String a=String.format("%03d", uid);
						PreparedStatement p1=(PreparedStatement)c.prepareStatement("select * from student where uid=?");
						p1.setString(1, a);
						ResultSet rs=p1.executeQuery();
						if(rs.next())
						{
							uid++;
						}
						else
						{
							w=false;
						}
					}
					String a=String.format("%03d", uid);
					PreparedStatement p=(PreparedStatement)c.prepareStatement("insert into student values(?,?,?,?,?,?)");
					p.setString(1,a);
					p.setString(2,s);
					p.setDouble(3,0);
					p.setFloat(4,0);
					
					if(branch.equals("07"))
					{
						p.setString(5,"computer");
					}
					else if(branch.equals("16"))
					{
						p.setString(5,"it");
					}
					else if(branch.equals("09"))
					{
						p.setString(5,"electrical");
					}
					else if(branch.equals("19"))
					{
						p.setString(5,"mechanical");
					}
					else
					{
						p.setString(5,"civil");
					}
					
					p.setString(6,"U");
					boolean b=p.execute();
					p=(PreparedStatement)c.prepareStatement("insert into login values(?,?,?)");
					p.setString(1,a);
					p.setString(2,Integer.toString(i));
					p.setString(3,"Student");
					b=p.execute();
					p=(PreparedStatement)c.prepareStatement("insert into attendance (uid) values (?)");
					p.setString(1,a);
					b=p.execute();
					JOptionPane.showMessageDialog(null,"Your UID = "+a+"\nYour Password = "+i);
				}
				catch(Exception err)
				{
					err.printStackTrace();
				}
				finally
				{
					dispose();
				}
			}
		});
		btnCreate.setBounds(228, 249, 245, 55);
		contentPane.add(btnCreate);
		
		JLabel lblAddStudent = new JLabel("Add Student:");
		lblAddStudent.setBounds(365, 12, 279, 46);
		lblAddStudent.setForeground(Color.WHITE);
		lblAddStudent.setFont(new Font("Sitka Small", Font.BOLD, 22));
		lblAddStudent.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblAddStudent);
		
		JLabel label = new JLabel(" ");
		label.setIcon(new ImageIcon(this.getClass().getResource("/images/adminBackground.jpg")));
		label.setBounds(0, 0, 700, 450);
		contentPane.add(label);
	}
	
	public void deleteStudent()
	{
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(369, 180, 700, 450);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(192, 192, 192));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JLabel lblX = new JLabel("X");
		lblX.setForeground(new Color(255, 255, 255));
		lblX.setBounds(649, 10, 51, 39);
		lblX.addMouseListener(new MouseAdapter() 
		{
			@Override
			public void mouseClicked(MouseEvent arg0) 
			{
				dispose();
			}
		});
		contentPane.setLayout(null);
		lblX.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblX.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(lblX);

		JLabel lblEnterStudentNameid = new JLabel("Enter Student UID :");
		lblEnterStudentNameid.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblEnterStudentNameid.setBounds(123, 94, 192, 39);
		contentPane.add(lblEnterStudentNameid);

		textField = new JTextField();
		textField.setBounds(325, 96, 171, 39);
		contentPane.add(textField);
		textField.setColumns(10);

		JLabel lblWarningThis = new JLabel("Warning : This is permanent and non-reversible");
		lblWarningThis.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblWarningThis.setHorizontalAlignment(SwingConstants.CENTER);
		lblWarningThis.setForeground(Color.RED);
		lblWarningThis.setBounds(155, 154, 328, 32);
		contentPane.add(lblWarningThis);
		
		JLabel lblDeleteStudent = new JLabel("Delete Student:");
		lblDeleteStudent.setForeground(new Color(255, 255, 255));
		lblDeleteStudent.setBounds(350, 12, 328, 32);
		lblDeleteStudent.setFont(new Font("Sitka Small", Font.BOLD, 22));
		lblDeleteStudent.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblDeleteStudent);
		
		JLabel label = new JLabel(" ");
		label.setIcon(new ImageIcon(this.getClass().getResource("/images/adminBackground.jpg")));
		label.setBounds(0, 0, 700, 450);
		
		JLabel label_1 = new JLabel("");
		label_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try
				{
					Class.forName("com.mysql.jdbc.Driver");
					Connection c=DriverManager.getConnection("jdbc:mysql://localhost/college", "root", "root");
					PreparedStatement p=(PreparedStatement)c.prepareStatement("select * from student where uid=?");
					p.setString(1, textField.getText());
					ResultSet rs=p.executeQuery();
					if(rs.next())
					{
						PreparedStatement p1=(PreparedStatement)c.prepareStatement("delete from student where uid=?");
						p1.setString(1,textField.getText());
						boolean b=p1.execute();
						p1=(PreparedStatement)c.prepareStatement("delete from login where uid=?");
						p1.setString(1,textField.getText());
						b=p1.execute();
						p1=(PreparedStatement)c.prepareStatement("delete from attendance where uid=?");
						p1.setString(1,textField.getText());
						b=p1.execute();
						JOptionPane.showMessageDialog(null,"Student Account Deleted");
					}
					else
					{
						JOptionPane.showMessageDialog(null,"ERROR: UID Does Not Exist");
					}
				}
				catch(Exception e2)
				{
					e2.printStackTrace();
				}
				finally
				{
					dispose();
				}
			}
		});
		label_1.setIcon(new ImageIcon(this.getClass().getResource("/images/unfriend.png")));
		label_1.setBounds(266, 211, 161, 128);
		contentPane.add(label_1);

		JLabel lblDeleteStudentAccount = new JLabel("DELETE STUDENT ACCOUNT");
		lblDeleteStudentAccount.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		lblDeleteStudentAccount.setBounds(223, 335, 228, 20);
		contentPane.add(lblDeleteStudentAccount);
		
		contentPane.add(label);
	}
	
	public void addTeacher()
	{
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(369, 180, 700, 450);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(192, 192, 192));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblX = new JLabel("X");
		lblX.setForeground(new Color(255, 255, 255));
		lblX.addMouseListener(new MouseAdapter() 
		{
			@Override
			public void mouseClicked(MouseEvent arg0) 
			{
				dispose();
			}
		});
		lblX.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblX.setHorizontalAlignment(SwingConstants.CENTER);
		lblX.setBounds(652, 0, 48, 58);
		getContentPane().add(lblX);

		JLabel lblEnterStudentNameid = new JLabel("Enter Staff Name :");
		lblEnterStudentNameid.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblEnterStudentNameid.setBounds(69, 69, 178, 39);
		contentPane.add(lblEnterStudentNameid);
		
		String field[]= {"Computer","IT","Electrical","Mechanical","Civil"};
		
		JComboBox comboBox = new JComboBox(field);
		comboBox.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		comboBox.setBounds(257, 179, 109, 20);
		contentPane.add(comboBox);

		textField = new JTextField();
		textField.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		textField.setBounds(257, 79, 232, 20);
		contentPane.add(textField);
		textField.setColumns(10);

		JLabel lblEnterPassword = new JLabel("Enter Password :");
		lblEnterPassword.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblEnterPassword.setBounds(69, 119, 178, 28);
		contentPane.add(lblEnterPassword);

		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		passwordField.setBounds(257, 124, 232, 20);
		contentPane.add(passwordField);
		
		JLabel lblSelectCourse = new JLabel("Select Course:");
		lblSelectCourse.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblSelectCourse.setBounds(69, 174, 178, 28);
		contentPane.add(lblSelectCourse);
		
		JLabel lblAddTeacher = new JLabel("Add Teacher:");
		lblAddTeacher.setForeground(new Color(255, 255, 255));
		lblAddTeacher.setBounds(370, 11, 293, 41);
		lblAddTeacher.setFont(new Font("Sitka Small", Font.BOLD, 22));
		lblAddTeacher.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblAddTeacher);
		
		JLabel label = new JLabel(" ");
		label.setIcon(new ImageIcon(this.getClass().getResource("/images/adminBackground.jpg")));
		label.setBounds(0, 0, 700, 450);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.addMouseListener(new MouseAdapter() 
		{
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				String s=textField.getText();
				String pass=passwordField.getText();
				int uid=001;
				boolean w=true;
				try
				{
					Class.forName("com.mysql.jdbc.Driver");
					Connection c=DriverManager.getConnection("jdbc:mysql://localhost/college", "root", "root");
					while(w)
					{
						String a=String.format("%03d", uid);
						PreparedStatement p1=(PreparedStatement)c.prepareStatement("select * from teacher where uid=?");
						p1.setString(1, a);
						ResultSet rs=p1.executeQuery();
						if(rs.next())
						{
							uid++;
						}
						else
						{
							w=false;
						}
					}
					String a=String.format("%03d", uid);
					PreparedStatement p=(PreparedStatement)c.prepareStatement("insert into login values(?,?,?)");
					p.setString(1,a);
					p.setString(2,pass);
					p.setString(3, "Teacher");
					boolean b=p.execute();
					int z=comboBox.getSelectedIndex();
					p=(PreparedStatement)c.prepareStatement("insert into teacher values(?,?,?)");
					p.setString(1,a);
					p.setString(2,s);
					p.setString(3, field[z]);
					b=p.execute();
					p=(PreparedStatement)c.prepareStatement("create table tt"+a+"(day varchar(10),l1 varchar(20),l2 varchar(20),l3 varchar(20),l4 varchar(20),l5 varchar(20),l6 varchar(20))");
					b=p.execute();
					if(Integer.parseInt(a)%2==1)
					{
						p=(PreparedStatement)c.prepareStatement("insert into tt"+a+"  values(?,?,?,?,?,?,?)");
						p.setString(1,"Monday");
						p.setString(2, "5H2-OOPJ");
						p.setString(3, "5H2-OOPJ");
						p.setString(4, "5H-OOPJ");
						p.setString(5, "5H-OOPJ");
						p.setString(6, "");
						p.setString(7, "");
						b=p.execute();
						p=(PreparedStatement)c.prepareStatement("insert into tt"+a+"  values(?,?,?,?,?,?,?)");
						p.setString(1,"Tuesday");
						p.setString(2, "5H1-OOPJ");
						p.setString(3, "5H1-OOPJ");
						p.setString(4, "");
						p.setString(5, "");
						p.setString(6, "5G-OOPJ");
						p.setString(7, "");
						b=p.execute();
						p=(PreparedStatement)c.prepareStatement("insert into tt"+a+"  values(?,?,?,?,?,?,?)");
						p.setString(1,"Wednesday");
						p.setString(2, "5H-CS");
						p.setString(3, "5H-CS");
						p.setString(4, "5G4-OOPJ");
						p.setString(5, "5G4-OOPJ");
						p.setString(6, "5G-OOPJ");
						p.setString(7, "");
						b=p.execute();
						p=(PreparedStatement)c.prepareStatement("insert into tt"+a+"  values(?,?,?,?,?,?,?)");
						p.setString(1,"Thursday");
						p.setString(2, "5H3-OOPJ");
						p.setString(3, "5H3-OOPJ");
						p.setString(4, "5H-CS");
						p.setString(5, "3H-IC");
						p.setString(6, "");
						p.setString(7, "");
						b=p.execute();
						p=(PreparedStatement)c.prepareStatement("insert into tt"+a+"  values(?,?,?,?,?,?,?)");
						p.setString(1,"Friday");
						p.setString(2, "5G-CS");
						p.setString(3, "5G-CS");
						p.setString(4, "");
						p.setString(5, "");
						p.setString(6, "3G-IC");
						p.setString(7, "");
						b=p.execute();
					}
					else
					{
						p=(PreparedStatement)c.prepareStatement("insert into tt"+a+"  values(?,?,?,?,?,?,?)");
						p.setString(1,"Monday");
						p.setString(2, "3H-DBMS");
						p.setString(3, "");
						p.setString(4, "");
						p.setString(5, "");
						p.setString(6, "3H3-DBMS");
						p.setString(7, "3H3-DBMS");
						b=p.execute();
						p=(PreparedStatement)c.prepareStatement("insert into tt"+a+"  values(?,?,?,?,?,?,?)");
						p.setString(1,"Tuesday");
						p.setString(2, "3G3-DBMS");
						p.setString(3, "3G3-DBMS");
						p.setString(4, "7H-INS");
						p.setString(5, "");
						p.setString(6, "3H1-DBMS");
						p.setString(7, "3H1-DBMS");
						b=p.execute();
						p=(PreparedStatement)c.prepareStatement("insert into tt"+a+"  values(?,?,?,?,?,?,?)");
						p.setString(1,"Wednesday");
						p.setString(2, "3G2-DBMS");
						p.setString(3, "3G2-DBMS");
						p.setString(4, "3G-DBMS");
						p.setString(5, "");
						p.setString(6, "7G-INS");
						p.setString(7, "");
						b=p.execute();
						p=(PreparedStatement)c.prepareStatement("insert into tt"+a+"  values(?,?,?,?,?,?,?)");
						p.setString(1,"Thursday");
						p.setString(2, "3G1-DBMS");
						p.setString(3, "3G1-DBMS");
						p.setString(4, "3G-DBMS");
						p.setString(5, "");
						p.setString(6, "");
						p.setString(7, "");
						b=p.execute();
						p=(PreparedStatement)c.prepareStatement("insert into tt"+a+"  values(?,?,?,?,?,?,?)");
						p.setString(1,"Friday");
						p.setString(2, "");
						p.setString(3, "3H-DBMS");
						p.setString(4, "7G-INS");
						p.setString(5, "7G-INS");
						p.setString(6, "3H2-DBMS");
						p.setString(7, "3H2-DBMS");
						b=p.execute();
					}
					JOptionPane.showMessageDialog(null,"Your UID = "+a);
				}
				catch(Exception err)
				{
					err.printStackTrace();
				}
				finally
				{
					dispose();
				}
			}
		});
		lblNewLabel.setIcon(new ImageIcon(this.getClass().getResource("/images/group.png")));
		lblNewLabel.setBounds(277, 255, 153, 96);
		contentPane.add(lblNewLabel);
		
		JLabel lblAddTeacher_1 = new JLabel("ADD TEACHER");
		lblAddTeacher_1.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		lblAddTeacher_1.setBounds(287, 349, 122, 14);
		contentPane.add(lblAddTeacher_1);
		
		contentPane.add(label);
	}
	
	public void deleteTeacher()
	{
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(369, 180, 700, 450);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(192, 192, 192));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JLabel lblX = new JLabel("X");
		lblX.setForeground(new Color(255, 255, 255));
		lblX.setBounds(646, 5, 54, 52);
		lblX.addMouseListener(new MouseAdapter() 
		{
			@Override
			public void mouseClicked(MouseEvent arg0) 
			{
				dispose();
			}
		});
		contentPane.setLayout(null);
		lblX.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblX.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(lblX);

		JLabel lblEnterStudentNameid = new JLabel("Enter Staff Uid :");
		lblEnterStudentNameid.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblEnterStudentNameid.setBounds(146, 93, 164, 39);
		contentPane.add(lblEnterStudentNameid);

		JLabel lblWarningThis = new JLabel("Warning! : This is permanent and non-reversible");
		lblWarningThis.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblWarningThis.setHorizontalAlignment(SwingConstants.CENTER);
		lblWarningThis.setForeground(Color.RED);
		lblWarningThis.setBounds(146, 153, 380, 28);
		contentPane.add(lblWarningThis);
		
		textField = new JTextField();
		textField.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		textField.setBounds(320, 104, 193, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblDeleteTeachersAccount = new JLabel("Delete Teacher's Account");
		lblDeleteTeachersAccount.setBounds(374, 12, 282, 39);
		lblDeleteTeachersAccount.setForeground(Color.WHITE);
		lblDeleteTeachersAccount.setFont(new Font("Sitka Small", Font.BOLD, 19));
		lblDeleteTeachersAccount.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblDeleteTeachersAccount);
		
		JLabel label = new JLabel(" ");
		label.setIcon(new ImageIcon(this.getClass().getResource("/images/adminBackground.jpg")));
		label.setBounds(0, 0, 700, 450);
		JLabel label_1 = new JLabel("");
		label_1.addMouseListener(new MouseAdapter() 
		{
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				try
				{
					Class.forName("com.mysql.jdbc.Driver");
					Connection c=DriverManager.getConnection("jdbc:mysql://localhost/college", "root", "root");
					PreparedStatement p=(PreparedStatement)c.prepareStatement("select * from teacher where uid=?");
					p.setString(1, textField.getText());
					ResultSet rs=p.executeQuery();
					if(rs.next())
					{
						PreparedStatement p1=(PreparedStatement)c.prepareStatement("delete from teacher where uid=?");
						p1.setString(1,textField.getText());
						boolean b=p1.execute();
						p1=(PreparedStatement)c.prepareStatement("delete from login where uid=?");
						p1.setString(1,textField.getText());
						b=p1.execute();
						p1=(PreparedStatement)c.prepareStatement("drop table tt"+textField.getText());
						b=p1.execute();
						JOptionPane.showMessageDialog(null,"Teacher Account Deleted");
					}
					else
					{
						JOptionPane.showMessageDialog(null,"ERROR: UID Does Not Exist");
					}
				}
				catch(Exception e2)
				{
					e2.printStackTrace();
				}
				finally
				{
					dispose();
				}	
			}
		});
		label_1.setIcon(new ImageIcon(this.getClass().getResource("/images/unfriend.png")));
		label_1.setBounds(260, 225, 128, 115);
		contentPane.add(label_1);
		
		JLabel lblDeleteTeacherAccount = new JLabel("DELETE TEACHER ACCOUNT");
		lblDeleteTeacherAccount.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		lblDeleteTeacherAccount.setBounds(217, 351, 230, 14);
		contentPane.add(lblDeleteTeacherAccount);
		
		contentPane.add(label);
	}
	
	public void getStudentReport()
	{
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(369, 180, 700, 450);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(192, 192, 192));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblX = new JLabel("X");
		lblX.setForeground(new Color(255, 255, 255));
		lblX.addMouseListener(new MouseAdapter() 
		{
			@Override
			public void mouseClicked(MouseEvent arg0) 
			{
				dispose();
			}
		});
		lblX.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblX.setHorizontalAlignment(SwingConstants.CENTER);
		lblX.setBounds(653, 6, 47, 42);
		contentPane.add(lblX);
		
		int total=420;
		
		String stud[][]=new String[total][6];
		for(int i=0;i<total;i++)
		{
			for(int j=0;j<6;j++)
			{
				stud[i][j]=" ";
			}
		}
		int i=0;
		int j=0;
		String head[]= {"UID","Name","Marks","Attendance","Field","Fee Status"};
		
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection c=DriverManager.getConnection("jdbc:mysql://localhost/college", "root", "root");
			PreparedStatement p=(PreparedStatement)c.prepareStatement("select * from student");
			ResultSet rs=p.executeQuery();
			while(rs.next()) 
			{
				j=0;
				stud[i][j]=rs.getString(1);
				j=1;
				stud[i][j]=rs.getString(2);
				j=2;
				double a=rs.getDouble(3);
				if(a==-1)
				{
					stud[i][j]="NA";
				}
				else
				{
					stud[i][j]=Double.toString(a);
				}
				j=3;
				float f=rs.getFloat(4);
				if(f==-1)
				{
					stud[i][j]="NA";
				}
				else
				{
					stud[i][j]=Float.toString(f);
				}
				j=4;
				stud[i][j]=rs.getString(5);
				j=5;
				String str=rs.getString(6);
				if(str.compareTo("P")==0)
				{
					stud[i][j]="Paid";
				}
				else
				{
					stud[i][j]="Unpaid";
				}
				i++;
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		table = new JTable(stud,head);
		table.setRowSelectionAllowed(false);
		table.setBounds(33, 21, 550, 419);
		contentPane.add(table);
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(59, 64, 520, 244);
		contentPane.add(scrollPane);
		
		JLabel lblList = new JLabel("Student Report :");
		lblList.setBackground(new Color(0, 0, 0));
		lblList.setBounds(371, 11, 291, 42);
		contentPane.add(lblList);
		lblList.setForeground(Color.WHITE);
		lblList.setFont(new Font("Sitka Small", Font.BOLD, 22));
		lblList.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel label = new JLabel(" ");
		label.setIcon(new ImageIcon(this.getClass().getResource("/images/adminBackground.jpg")));
		label.setBounds(0, 0, 700, 450);
		contentPane.add(label);
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment( JLabel.CENTER );
		table.getColumnModel().getColumn(0).setCellRenderer( centerRenderer );
		table.getColumnModel().getColumn(1).setCellRenderer( centerRenderer );
		table.getColumnModel().getColumn(2).setCellRenderer( centerRenderer );
		table.getColumnModel().getColumn(3).setCellRenderer( centerRenderer );
		table.getColumnModel().getColumn(4).setCellRenderer( centerRenderer );
		table.getColumnModel().getColumn(5).setCellRenderer( centerRenderer );
	}
	
	public void getTeacherReport()
	{
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(369, 180, 700, 450);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(192, 192, 192));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblX = new JLabel("X");
		lblX.setForeground(new Color(255, 255, 255));
		lblX.addMouseListener(new MouseAdapter() 
		{
			@Override
			public void mouseClicked(MouseEvent arg0) 
			{
				dispose();
			}
		});
		lblX.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblX.setHorizontalAlignment(SwingConstants.CENTER);
		lblX.setBounds(653, 6, 47, 42);
		contentPane.add(lblX);
		
		int blah=50;
		
		String stud[][]=new String[blah][3];
		for(int i=0;i<blah;i++)
		{
			for(int j=0;j<3;j++)
			{
				stud[i][j]=" ";
			}
		}
		int i=0;
		int j=0;
		String head[]= {"UID","Name","Field"};
		
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection c=DriverManager.getConnection("jdbc:mysql://localhost/college", "root", "root");
			PreparedStatement p=(PreparedStatement)c.prepareStatement("select * from teacher");
			ResultSet rs=p.executeQuery();
			while(rs.next()) 
			{
				j=0;
				stud[i][j]=rs.getString(1);
				j=1;
				stud[i][j]=rs.getString(2);
				j=2;
				stud[i][j]=rs.getString(3);
				i++;
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		table = new JTable(stud,head);
		table.setRowSelectionAllowed(false);
		table.setBounds(33, 21, 550, 419);
		contentPane.add(table);
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(59, 64, 520, 244);
		contentPane.add(scrollPane);
		
		JLabel lblList = new JLabel("Teacher Report :");
		lblList.setBackground(new Color(0, 0, 0));
		lblList.setBounds(371, 11, 291, 42);
		contentPane.add(lblList);
		lblList.setForeground(Color.WHITE);
		lblList.setFont(new Font("Sitka Small", Font.BOLD, 22));
		lblList.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel label = new JLabel(" ");
		label.setIcon(new ImageIcon(this.getClass().getResource("/images/adminBackground.jpg")));
		label.setBounds(0, 0, 700, 450);
		contentPane.add(label);
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment( JLabel.CENTER );
		table.getColumnModel().getColumn(0).setCellRenderer( centerRenderer );
		table.getColumnModel().getColumn(1).setCellRenderer( centerRenderer );
		table.getColumnModel().getColumn(2).setCellRenderer( centerRenderer );
	}
}