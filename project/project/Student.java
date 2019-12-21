package project;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.table.*;
import java.sql.*;
import java.awt.event.*;

public class Student extends JFrame 
{
	private JPanel contentPane;
	static String usr;
	private JTable table;
	public static String fee;
	public static String a;
	private JTextField textField;
	private JPasswordField passwordField;
	private JTextField textField_1;

	public static void main(String u) 
	{
		usr=u;
		EventQueue.invokeLater(new Runnable() 
		{
			public void run() 
			{
				try 
				{
					Student frame = new Student();
					frame.setVisible(true);
				} 
				catch (Exception e) 
				{
					e.printStackTrace();
				}
			}
		});
	}

	public Student() throws ClassNotFoundException, SQLException 
	{
		Class.forName("com.mysql.jdbc.Driver");
		Connection c=DriverManager.getConnection("jdbc:mysql://localhost/college", "root", "root");

		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(369, 180, 700, 450);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(192, 192, 192));
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
		lblX.setBounds(646, 8, 54, 51);
		contentPane.add(lblX);

		JLabel lblStudentsPortal = new JLabel("Functions:");
		lblStudentsPortal.setForeground(Color.WHITE);
		lblStudentsPortal.setFont(new Font("Sitka Small", Font.BOLD, 22));
		lblStudentsPortal.setHorizontalAlignment(SwingConstants.CENTER);
		lblStudentsPortal.setBounds(385, 8, 239, 51);
		contentPane.add(lblStudentsPortal);

		JLabel label = new JLabel(" ");
		label.setIcon(new ImageIcon(this.getClass().getResource("/images/studentBackground.png")));
		label.setBounds(0, 0, 700, 450);

		JLabel label_1 = new JLabel("");
		label_1.addMouseListener(new MouseAdapter() 
		{
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				try
				{
					PreparedStatement p1=(PreparedStatement)c.prepareStatement("select * from student where uid=?");
					p1.setString(1, usr);
					ResultSet rs=p1.executeQuery();
					if(rs.next())
					{
						String s=rs.getString(5);
						if(s.equals(""))
						{
							JOptionPane.showMessageDialog(null,"Please Select A Course First");
						}
						else
						{
							EventQueue.invokeLater(new Runnable() 
							{
								public void run() 
								{
									try 
									{
										Student student=new Student();
										student.checkTimetable();
										student.setVisible(true);
									} 
									catch (Exception e) 
									{
										e.printStackTrace();
									}
								}
							});
						}
					}
				}
				catch(Exception err)
				{
					err.printStackTrace();
				}
			}
		});
		label_1.setIcon(new ImageIcon(this.getClass().getResource("/images/schedule.png")));
		label_1.setBounds(87, 62, 83, 88);
		contentPane.add(label_1);

		JLabel lblTimeTable = new JLabel("TIME TABLE");
		lblTimeTable.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		lblTimeTable.setBounds(67, 143, 121, 14);
		contentPane.add(lblTimeTable);

		JLabel label_2 = new JLabel("");
		label_2.addMouseListener(new MouseAdapter() 
		{
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				try
				{
					PreparedStatement p1=(PreparedStatement)c.prepareStatement("select * from student where uid=?");
					p1.setString(1, usr);
					ResultSet rs=p1.executeQuery();
					if(rs.next())
					{
						float attendance=rs.getFloat(4);
						if(attendance!=0)
						{
							JOptionPane.showMessageDialog(null,"Your Attendance Is : "+attendance+"%");
						}
						else
						{
							JOptionPane.showMessageDialog(null,"Your Attendance Is Not Yet Entered By The Teacher");
						}
					}
				}
				catch(Exception err)
				{
					err.printStackTrace();
				}
			}
		});
		label_2.setIcon(new ImageIcon(this.getClass().getResource("/images/classroom.png")));
		label_2.setBounds(327, 62, 92, 88);
		contentPane.add(label_2);


		JLabel lblAttendance = new JLabel("ATTENDANCE");
		lblAttendance.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		lblAttendance.setBounds(301, 145, 118, 14);
		contentPane.add(lblAttendance);

		JLabel label_3 = new JLabel("");
		label_3.addMouseListener(new MouseAdapter() 
		{
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				try
				{
					PreparedStatement p1=(PreparedStatement)c.prepareStatement("select * from student where uid=?");
					p1.setString(1, usr);
					ResultSet rs=p1.executeQuery();
					if(rs.next())
					{
						double a=rs.getDouble(3);
						if(a==0)
						{
							JOptionPane.showMessageDialog(null,"Your Result Is Not Yet Available");
						}
						else
						{
							JOptionPane.showMessageDialog(null,"Your Marks Are : "+a+"%");
						}
					}
				}
				catch(Exception err)
				{
					err.printStackTrace();
				}
			}
		});
		label_3.setIcon(new ImageIcon(this.getClass().getResource("/images/test.png")));
		label_3.setBounds(475, 235, 70, 75);
		contentPane.add(label_3);

		JLabel lblTestResults = new JLabel("TEST RESULTS");
		lblTestResults.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		lblTestResults.setBounds(433, 313, 135, 14);
		contentPane.add(lblTestResults);

		JLabel label_4 = new JLabel("");
		label_4.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				try
				{
					PreparedStatement p1=(PreparedStatement)c.prepareStatement("select * from student where uid=?");
					p1.setString(1, usr);
					ResultSet rs=p1.executeQuery();
					if(rs.next())
					{
						String a=rs.getString(5);
						if(a.equals(""))
						{
							JOptionPane.showMessageDialog(null,"Please Select Course First");
						}
						else
						{
							Student.fee="Rs. 1,500";
							Student.a=a.toUpperCase();
							EventQueue.invokeLater(new Runnable() 
							{
								public void run() 
								{
									try 
									{
										Student student=new Student();
										student.payFees();
										student.setVisible(true);
									} 
									catch (Exception e) 
									{
										e.printStackTrace();
									}
								}
							});
						}
					}
				}
				catch(Exception err)
				{
					err.printStackTrace();
				}
			}
		});
		label_4.setIcon(new ImageIcon(this.getClass().getResource("/images/cash.png")));
		label_4.setBounds(190, 235, 92, 75);
		contentPane.add(label_4);

		JLabel lblPayFees = new JLabel("PAY FEES");
		lblPayFees.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		lblPayFees.setBounds(178, 313, 92, 14);
		contentPane.add(lblPayFees);

		contentPane.add(label);
	}
	
	public void checkTimetable()
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
		lblX.setForeground(Color.WHITE);
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
		lblX.setBounds(656, 17, 44, 40);
		contentPane.add(lblX);

		JLabel lblStudentsPortal = new JLabel("Timetable");
		lblStudentsPortal.setForeground(Color.WHITE);
		lblStudentsPortal.setFont(new Font("Sitka Small", Font.BOLD, 22));
		lblStudentsPortal.setHorizontalAlignment(SwingConstants.CENTER);
		lblStudentsPortal.setBounds(356, 11, 334, 42);
		contentPane.add(lblStudentsPortal);
		String a[][]=new String[5][7];
		String b[]= {"Day","Lecture 1","Lecture 2","Lecture 3","Lecture 4","Lecture 5","Lecture 6"};
		int i=0;
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection c=DriverManager.getConnection("jdbc:mysql://localhost/college", "root", "root");
			PreparedStatement p=(PreparedStatement)c.prepareStatement("select * from student where uid=?");
			p.setString(1, usr);
			ResultSet r=p.executeQuery();
			String query="";
			if(r.next())
			{
				String field=r.getString(5);
				if(field.compareTo("computer")==0)
				{
					query="select * from ttcs";
				}
				if(field.compareTo("it")==0)
				{
					query="select * from ttit";
				}
				if(field.compareTo("civil")==0)
				{
					query="select * from ttce";
				}
				if(field.compareTo("electrical")==0)
				{
					query="select * from ttee";
				}
				if(field.compareTo("mechanical")==0)
				{
					query="select * from ttme";
				}
				PreparedStatement p1=(PreparedStatement)c.prepareStatement(query);
				ResultSet rs=p1.executeQuery();
				while(rs.next() && i<=4)
				{
					for(int j=0;j<7;j++)
					{
						a[i][j]= rs.getString(j+1);
					}
					i++;
				}
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

		table = new JTable(a,b);
		table.setRowSelectionAllowed(false);
		table.setBounds(31, 137, 619, 150);
		contentPane.add(table);
		table.setRowHeight(30);

		JLabel lblDay = new JLabel("Day:");
		lblDay.setHorizontalAlignment(SwingConstants.CENTER);
		lblDay.setBounds(35, 112, 73, 14);
		contentPane.add(lblDay);

		JLabel lblLecture = new JLabel("Lecture 1:");
		lblLecture.setHorizontalAlignment(SwingConstants.CENTER);
		lblLecture.setBounds(125, 112, 73, 14);
		contentPane.add(lblLecture);

		JLabel lblLecture_1 = new JLabel("Lecture 2:");
		lblLecture_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblLecture_1.setBounds(215, 112, 73, 14);
		contentPane.add(lblLecture_1);

		JLabel lblLecture_2 = new JLabel("Lecture 3:");
		lblLecture_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblLecture_2.setBounds(305, 112, 73, 14);
		contentPane.add(lblLecture_2);

		JLabel lblLecture_3 = new JLabel("Lecture 4:");
		lblLecture_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblLecture_3.setBounds(395, 112, 73, 14);
		contentPane.add(lblLecture_3);

		JLabel lblLecture_4 = new JLabel("Lecture 5:");
		lblLecture_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblLecture_4.setBounds(485, 112, 73, 14);
		contentPane.add(lblLecture_4);

		JLabel lblLecture_5 = new JLabel("Lecture 6:");
		lblLecture_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblLecture_5.setBounds(575, 112, 73, 14);
		contentPane.add(lblLecture_5);

		JButton btnClose = new JButton("Close");
		btnClose.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnClose.setBorder(BorderFactory.createLineBorder(Color.black,1));
		btnClose.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				dispose();
			}
		});
		btnClose.setBounds(41, 298, 120, 40);
		contentPane.add(btnClose);
		
		JLabel label = new JLabel(" ");
		label.setIcon(new ImageIcon(this.getClass().getResource("/images/studentBackground.png")));
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
		table.getColumnModel().getColumn(6).setCellRenderer( centerRenderer );
	}
	
	public void payFees() throws ClassNotFoundException, SQLException
	{
		getContentPane().setBackground(new Color(192, 192, 192));
		Class.forName("com.mysql.jdbc.Driver");
		Connection c=DriverManager.getConnection("jdbc:mysql://localhost/college", "root", "root");

		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(369, 180, 700, 450);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(192, 192, 192));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblX = new JLabel("X");
		lblX.setForeground(Color.WHITE);
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
		lblX.setBounds(635, 5, 65, 48);
		getContentPane().add(lblX);
		
		JLabel lblStudentName = new JLabel("USER ID :");
		lblStudentName.setBounds(68, 124, 214, 25);
		lblStudentName.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		getContentPane().add(lblStudentName);
		
		JLabel lblNewLabel = new JLabel(usr);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel.setBounds(200, 124, 235, 25);
		getContentPane().add(lblNewLabel);
		
		JLabel lblField = new JLabel("FIELD : ");
		lblField.setBounds(68, 187, 83, 25);
		lblField.setFont(new Font("Tahoma", Font.BOLD, 14));
		getContentPane().add(lblField);
		
		JLabel lblFld = new JLabel(a);
		lblFld.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblFld.setBounds(200, 187, 235, 25);
		getContentPane().add(lblFld);
		
		JLabel lblFees = new JLabel("FEES : ");
		lblFees.setBounds(68, 242, 83, 25);
		lblFees.setFont(new Font("Tahoma", Font.BOLD, 14));
		getContentPane().add(lblFees);
		
		JLabel lblFes = new JLabel(fee);
		lblFes.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblFes.setBounds(200, 242, 173, 25);
		getContentPane().add(lblFes);
		
		JLabel lblFees_1 = new JLabel("Fees Portal:");
		lblFees_1.setForeground(Color.WHITE);
		lblFees_1.setFont(new Font("Sitka Small", Font.BOLD, 22));
		lblFees_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblFees_1.setBounds(388, 11, 237, 46);
		getContentPane().add(lblFees_1);
		
		JLabel label = new JLabel(" ");
		label.setIcon(new ImageIcon(this.getClass().getResource("/images/studentBackground.png")));
		label.setBounds(0, 0, 700, 450);
		
		JLabel label_1 = new JLabel("");
		label_1.addMouseListener(new MouseAdapter() 
		{
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				try
				{
					PreparedStatement p1=(PreparedStatement)c.prepareStatement("select * from student where uid=?");
					p1.setString(1, usr);
					ResultSet rs=p1.executeQuery();
					if(rs.next())
					{
						String z=rs.getString(6);
						if(z.compareTo("U")==0)
						{
							EventQueue.invokeLater(new Runnable() 
							{
								public void run() 
								{
									try 
									{
										Student student=new Student();
										student.performTransaction();
									student.setVisible(true);
									} 
									catch (Exception e) 
									{
										e.printStackTrace();
									}
								}
							});
							dispose();
						}
						else
						{
							JOptionPane.showMessageDialog(null,"Fees are already paid.");
							dispose();
						}
					}
				}
				catch(Exception err)
				{
					err.printStackTrace();
				}
			}
		});
		label_1.setIcon(new ImageIcon(this.getClass().getResource("/images/payment.png")));
		label_1.setBounds(294, 278, 83, 80);
		getContentPane().add(label_1);
		
		JLabel lblNewLabel_1 = new JLabel("PAY NOW");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(285, 358, 104, 14);
		getContentPane().add(lblNewLabel_1);
		
		getContentPane().add(label);
	}
	
	public void performTransaction()
	{
		getContentPane().setBackground(new Color(192, 192, 192));
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(369, 180, 700, 450);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(192, 192, 192));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblX = new JLabel("X");
		lblX.setForeground(Color.WHITE);
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
		lblX.setBounds(638, 4, 62, 73);
		getContentPane().add(lblX);

		JLabel lblPayNow = new JLabel("Pay Now");
		lblPayNow.setForeground(Color.WHITE);
		lblPayNow.setFont(new Font("Sitka Small", Font.BOLD, 22));
		lblPayNow.setHorizontalAlignment(SwingConstants.CENTER);
		lblPayNow.setBounds(389, 14, 311, 35);
		getContentPane().add(lblPayNow);

		JLabel lblCreditCardNumber = new JLabel("Credit Card Number :");
		lblCreditCardNumber.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		lblCreditCardNumber.setBounds(43, 170, 206, 14);
		getContentPane().add(lblCreditCardNumber);

		textField = new JTextField();
		textField.setBounds(207, 169, 250, 20);
		getContentPane().add(textField);
		textField.setColumns(10);

		JSpinner spinner = new JSpinner();
		spinner.setModel(new SpinnerNumberModel(1, 1, 12, 1));
		spinner.setBounds(256, 120, 39, 20);
		getContentPane().add(spinner);
		
		JSpinner spinner_1 = new JSpinner();
		spinner_1.setModel(new SpinnerNumberModel(2018, 2018, 2022, 1));
		spinner_1.setBounds(395, 120, 62, 20);
		getContentPane().add(spinner_1);
		
		JLabel lblCvv = new JLabel("CVV : ");
		lblCvv.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		lblCvv.setBounds(43, 220, 128, 14);
		getContentPane().add(lblCvv);

		passwordField = new JPasswordField();
		passwordField.setBounds(207, 218, 62, 20);
		getContentPane().add(passwordField);

		JLabel lblAmount = new JLabel("Amount : ");
		lblAmount.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		lblAmount.setBounds(43, 249, 128, 14);
		getContentPane().add(lblAmount);

		JLabel lblFee = new JLabel(fee);
		lblFee.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblFee.setBounds(207, 249, 227, 14);
		getContentPane().add(lblFee);

		JLabel lblNameOnCard = new JLabel("Name On Card : ");
		lblNameOnCard.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		lblNameOnCard.setBounds(43, 82, 128, 14);
		getContentPane().add(lblNameOnCard);

		textField_1 = new JTextField();
		textField_1.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		textField_1.setBounds(207, 79, 250, 20);
		getContentPane().add(textField_1);
		textField_1.setColumns(10);

		JLabel lblExpiryDate = new JLabel("Expiry Date :");
		lblExpiryDate.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		lblExpiryDate.setBounds(43, 118, 128, 20);
		getContentPane().add(lblExpiryDate);

		JLabel lblMonth = new JLabel("Month:");
		lblMonth.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		lblMonth.setBounds(207, 123, 58, 14);
		getContentPane().add(lblMonth);

		JLabel lblYear = new JLabel("Year:");
		lblYear.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		lblYear.setBounds(339, 123, 46, 14);
		getContentPane().add(lblYear);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(this.getClass().getResource("/images/cardLogo.png")));
		lblNewLabel.setBounds(481, 79, 140, 35);
		getContentPane().add(lblNewLabel);
		
		JLabel label = new JLabel(" ");
		label.setFont(new Font("Tahoma", Font.PLAIN, 12));
		label.setIcon(new ImageIcon(this.getClass().getResource("/images/studentBackground.png")));
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
					boolean flag=true;
					
					int len=textField.getText().length();
					int plen=passwordField.getText().length();
					if(textField.getText().matches("[a-zA-Z]" ))
					{
						JOptionPane.showMessageDialog(null,"ERROR : Invalid Credit Card Number");
						flag=false;
					}
					else if(len != 16)
					{
						JOptionPane.showMessageDialog(null,"ERROR : Invalid Credit Card Number");
						flag=false;
					}
					else if(plen != 3)
					{
						JOptionPane.showMessageDialog(null,"ERROR : Invalid CVV Number");
						flag=false;
					}
					else if((Integer)spinner.getValue()<=10 && (Integer)spinner_1.getValue()==2018)
					{
						JOptionPane.showMessageDialog(null,"ERROR : Card has Expired");
						flag=false;
					}
					if(flag)
					{
						PreparedStatement p1=(PreparedStatement)c.prepareStatement("update student set fee=? where uid=?");
						p1.setString(1,"P");
						p1.setString(2, usr);
						boolean b=p1.execute();
						JOptionPane.showMessageDialog(null,"Payment Successful");
					}
				}
				catch(Exception ze)
				{
					ze.printStackTrace();
					JOptionPane.showMessageDialog(null,"Input Error");
				}
				finally
				{
					dispose();
				}
			}
		});
		label_1.setIcon(new ImageIcon(this.getClass().getResource("/images/debitCard.png")));
		label_1.setBounds(283, 269, 105, 96);
		getContentPane().add(label_1);
		
		JLabel lblConfirmPayment = new JLabel("CONFIRM PAYMENT");
		lblConfirmPayment.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		lblConfirmPayment.setBounds(256, 351, 163, 14);
		getContentPane().add(lblConfirmPayment);
		
		getContentPane().add(label);
	}
}