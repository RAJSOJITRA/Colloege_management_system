package project;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.table.*;

import com.toedter.calendar.JDateChooser;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.awt.event.*;
import java.util.*;
import java.util.Date;

public class Teacher extends JFrame 
{
	private JPanel contentPane;
	static String usr;
	private JTable table;
	static private String fld;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;

	public static void main(String u) 
	{
		usr=u;
		EventQueue.invokeLater(new Runnable() 
		{
			public void run() 
			{
				try 
				{
					Teacher frame = new Teacher();
					frame.setVisible(true);
				} 
				catch (Exception e) 
				{
					e.printStackTrace();
				}
			}
		});
	}

	public Teacher() throws ClassNotFoundException, SQLException 
	{
		Class.forName("com.mysql.jdbc.Driver");
		Connection c=DriverManager.getConnection("jdbc:mysql://localhost/college", "root", "root");

		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(369, 180, 709, 456);
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
		lblX.setBounds(647, 7, 55, 51);
		contentPane.add(lblX);

		JLabel lblStudentsPortal = new JLabel("Functions:");
		lblStudentsPortal.setForeground(Color.WHITE);
		lblStudentsPortal.setFont(new Font("Sitka Small", Font.BOLD, 22));
		lblStudentsPortal.setHorizontalAlignment(SwingConstants.CENTER);
		lblStudentsPortal.setBounds(371, 11, 266, 46);
		contentPane.add(lblStudentsPortal);
		
		JLabel label = new JLabel(" ");
		label.setIcon(new ImageIcon(this.getClass().getResource("/images/teacherBackground.png")));
		label.setBounds(0, 0, 700, 450);
		
		JLabel label_1 = new JLabel("");
		label_1.addMouseListener(new MouseAdapter() 
		{
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				EventQueue.invokeLater(new Runnable() 
				{
					public void run() 
					{
						try 
						{
							Teacher teacher=new Teacher();
							teacher.checkTimetable();
							teacher.setVisible(true);
						} 
						catch (Exception e) 
						{
							e.printStackTrace();
						}
					}
				});
			}
		});
		label_1.setBackground(Color.BLACK);
		label_1.setIcon(new ImageIcon(this.getClass().getResource("/images/schedule.png")));
		label_1.setBounds(90, 62, 75, 73);
	
		contentPane.add(label_1);
		
		JLabel lblTimeTable = new JLabel("TIME TABLE");
		lblTimeTable.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		lblTimeTable.setBounds(75, 137, 101, 14);
		contentPane.add(lblTimeTable);
		
		JLabel label_2 = new JLabel("");
		label_2.addMouseListener(new MouseAdapter() 
		{
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				EventQueue.invokeLater(new Runnable() 
				{
					public void run() 
					{
						try 
						{
							Teacher teacher=new Teacher();
							teacher.enterStudentMarks();
							teacher.setVisible(true);
						} 
						catch (Exception e) 
						{
							e.printStackTrace();
						}
					}
				});
			}
		});
		label_2.setIcon(new ImageIcon(this.getClass().getResource("/images/response.png")));
		label_2.setBounds(361, 62, 75, 73);
		contentPane.add(label_2);
		
		JLabel lblStudentMarks = new JLabel("STUDENT MARKS");
		lblStudentMarks.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		lblStudentMarks.setBounds(326, 137, 145, 14);
		contentPane.add(lblStudentMarks);
		
		JLabel label_4 = new JLabel("");
		label_4.addMouseListener(new MouseAdapter() 
		{
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				EventQueue.invokeLater(new Runnable() 
				{
					public void run() 
					{
						try 
						{
							Teacher teacher=new Teacher();
							teacher.enterStudentAttendance();
							teacher.setVisible(true);
						} 
						catch (Exception e) 
						{
							e.printStackTrace();
						}
					}
				});
			}
		});
		label_4.setIcon(new ImageIcon(this.getClass().getResource("/images/classroom.png")));
		label_4.setBounds(190, 218, 75, 67);
		contentPane.add(label_4);
		
		JLabel lblStudentAttendance = new JLabel("STUDENT ");
		lblStudentAttendance.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		lblStudentAttendance.setBounds(178, 297, 90, 14);
		contentPane.add(lblStudentAttendance);

		JLabel lblAttendance = new JLabel("ATTENDANCE");
		lblAttendance.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		lblAttendance.setBounds(167, 322, 128, 14);
		contentPane.add(lblAttendance);
		
		JLabel label_3 = new JLabel("");
		label_3.addMouseListener(new MouseAdapter() 
		{
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				try
				{
					PreparedStatement p1=(PreparedStatement)c.prepareStatement("select * from teacher where uid=?");
					p1.setString(1, usr);
					ResultSet rs=p1.executeQuery();
					if(rs.next())
					{
						fld=rs.getString(3);
						EventQueue.invokeLater(new Runnable() 
						{
							public void run() 
							{
								try 
								{
									Teacher teacher=new Teacher();
									teacher.checkStudentDetails();
									teacher.setVisible(true);
									
								} 
								catch (Exception e) 
								{
									e.printStackTrace();
								}
							}
						});
					}
				}
				catch(Exception e1)
				{
					e1.printStackTrace();
				}
			}
		});
		label_3.setIcon(new ImageIcon(this.getClass().getResource("/images/chair.png")));
		label_3.setBounds(491, 218, 75, 68);
		contentPane.add(label_3);
		
		JLabel lblStudent = new JLabel("STUDENT");
		lblStudent.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		lblStudent.setBounds(480, 297, 108, 14);
		contentPane.add(lblStudent);
		JLabel lblDetails = new JLabel("DETAILS");
		lblDetails.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		lblDetails.setBounds(485, 322, 75, 14);
		contentPane.add(lblDetails);
		
		contentPane.add(label);
	}
	
	public void checkStudentDetails()
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
		
		int seats;
		if(fld.compareTo("Computer")==0 || fld.compareTo("Electrical")==0)
		{
			seats=120;
		}
		else
		{
			seats=60;
		}
		
		String stud[][]=new String[seats][6];
		for(int i=0;i<seats;i++)
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
			PreparedStatement p=(PreparedStatement)c.prepareStatement("select * from student where field=?");
			p.setString(1, fld);
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
		scrollPane.setBounds(59, 64, 520, 292);
		contentPane.add(scrollPane);
		
		JLabel lblList = new JLabel("List:");
		lblList.setBackground(new Color(0, 0, 0));
		lblList.setBounds(371, 11, 246, 42);
		contentPane.add(lblList);
		lblList.setForeground(Color.WHITE);
		lblList.setFont(new Font("Sitka Small", Font.BOLD, 22));
		lblList.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel label = new JLabel(" ");
		label.setIcon(new ImageIcon(this.getClass().getResource("/images/teacherBackground.png")));
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
		lblX.setBounds(662, 0, 38, 47);
		getContentPane().add(lblX);
		
		JButton btnFieldTimetable = new JButton("Field Timetable");
		btnFieldTimetable.setIcon(new ImageIcon(this.getClass().getResource("/images/edit.png")));
		btnFieldTimetable.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnFieldTimetable.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				EventQueue.invokeLater(new Runnable() 
				{
					public void run() 
					{
						try 
						{
							Teacher teacher=new Teacher();
							teacher.checkFieldTimetable();
							teacher.setVisible(true);
						} 
						catch (Exception e) 
						{
							e.printStackTrace();
						}
					}
				});
			}
		});
		btnFieldTimetable.setBounds(180, 110, 354, 82);
		contentPane.add(btnFieldTimetable);
		
		JButton btnYourPersonalTimetable = new JButton("Personal Timetable");
		btnYourPersonalTimetable.setIcon(new ImageIcon(this.getClass().getResource("/images/document.png")));
		btnYourPersonalTimetable.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnYourPersonalTimetable.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				EventQueue.invokeLater(new Runnable() 
				{
					public void run() 
					{
						try 
						{
							Teacher teacher=new Teacher();
							teacher.checkPersonalTimetable();
							teacher.setVisible(true);
						} 
						catch (Exception e) 
						{
							e.printStackTrace();
						}
					}
				});
			}
		});
		btnYourPersonalTimetable.setBounds(180, 233, 354, 82);
		contentPane.add(btnYourPersonalTimetable);
		
		JLabel lblTimetable = new JLabel("Timetable:");
		lblTimetable.setForeground(Color.WHITE);
		lblTimetable.setHorizontalAlignment(SwingConstants.CENTER);
		lblTimetable.setFont(new Font("Sitka Small", Font.BOLD, 22));
		lblTimetable.setBounds(403, 12, 224, 35);
		contentPane.add(lblTimetable);
		
		JLabel lblNewLabel = new JLabel(" ");
		lblNewLabel.setIcon(new ImageIcon(this.getClass().getResource("/images/teacherBackground.png")));
		lblNewLabel.setBounds(0, 0, 700, 450);
		contentPane.add(lblNewLabel);
	}
	
	public void checkPersonalTimetable()
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
		lblX.setBounds(656, 11, 44, 40);
		contentPane.add(lblX);

		JLabel lblStudentsPortal = new JLabel("Timetable");
		lblStudentsPortal.setForeground(Color.WHITE);
		lblStudentsPortal.setFont(new Font("Sitka Small", Font.BOLD, 22));
		lblStudentsPortal.setHorizontalAlignment(SwingConstants.CENTER);
		lblStudentsPortal.setBounds(334, 11, 356, 40);
		contentPane.add(lblStudentsPortal);
		String a[][]=new String[5][9];
		String b[]= {"Day","Lecture 1","Lecture 2","Lecture 3","Lecture 4","Lecture 5","Lecture 6"};
		int i=0;
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection c=DriverManager.getConnection("jdbc:mysql://localhost/college", "root", "root");
			PreparedStatement p1=(PreparedStatement)c.prepareStatement("select * from tt"+usr);
			ResultSet rs=p1.executeQuery();
			while(rs.next())
			{
				for(int j=0;j<7;j++)
				{
					a[i][j]= rs.getString(j+1);
				}
				i++;
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

		table = new JTable(a,b);
		table.setRowSelectionAllowed(false);
		table.setBounds(32, 137, 618, 150);
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
		
		JLabel label = new JLabel(" ");
		label.setIcon(new ImageIcon(this.getClass().getResource("/images/teacherBackground.png")));
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
	
	public void checkFieldTimetable()
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
		lblX.setBounds(656, 11, 44, 40);
		contentPane.add(lblX);

		JLabel lblStudentsPortal = new JLabel("Timetable");
		lblStudentsPortal.setForeground(Color.WHITE);
		lblStudentsPortal.setFont(new Font("Sitka Small", Font.BOLD, 22));
		lblStudentsPortal.setHorizontalAlignment(SwingConstants.CENTER);
		lblStudentsPortal.setBounds(360, 11, 340, 40);
		contentPane.add(lblStudentsPortal);
		String a[][]=new String[5][9];
		String b[]= {"Day","Lecture 1","Lecture 2","Lecture 3","Lecture 4","Lecture 5","Lecture 6"};
		int i=0;
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection c=DriverManager.getConnection("jdbc:mysql://localhost/college", "root", "root");
			PreparedStatement p=(PreparedStatement)c.prepareStatement("select * from teacher where uid=?");
			p.setString(1, usr);
			ResultSet r=p.executeQuery();
			String query="";
			if(r.next())
			{
				String field=r.getString(3);
				if(field.compareTo("Computer")==0)
				{
					query="select * from ttcs";
				}
				if(field.compareTo("IT")==0)
				{
					query="select * from ttit";
				}
				if(field.compareTo("Electrical")==0)
				{
					query="select * from ttee";
				}
				if(field.compareTo("Mechanical")==0)
				{
					query="select * from ttme";
				}
				if(field.compareTo("Civil")==0)
				{
					query="select * from ttce";
				}
				PreparedStatement p1=(PreparedStatement)c.prepareStatement(query);
				ResultSet rs=p1.executeQuery();
				while(rs.next())
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
		table.setBounds(34, 137, 617, 150);
		contentPane.add(table);
		table.setRowHeight(30);
		
		JLabel lblDay = new JLabel("Day:");
		lblDay.setFont(new Font("Tahoma", Font.BOLD, 12));
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
		
		JLabel label = new JLabel(" ");
		label.setIcon(new ImageIcon(this.getClass().getResource("/images/teacherBackground.png")));
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
	
	public void enterStudentMarks()
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
		lblX.setBounds(647, 11, 53, 47);
		getContentPane().add(lblX);
		
		ArrayList x=new ArrayList();
		
		String fld="";
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection c=DriverManager.getConnection("jdbc:mysql://localhost/college", "root", "root");
			PreparedStatement p1=(PreparedStatement)c.prepareStatement("select * from teacher where uid = ?");
			p1.setString(1, usr);
			ResultSet rs1=p1.executeQuery();
			if(rs1.next())
			{
				fld=rs1.getString(3);
			}
			PreparedStatement p=(PreparedStatement)c.prepareStatement("select * from student where field = ?");
			p.setString(1, fld);
			ResultSet rs=p.executeQuery();
			while(rs.next()) 
			{
				x.add("("+rs.getString(1)+") "+rs.getString(2));
			}
		}
		catch(Exception ze)
		{
			ze.printStackTrace();
		}
		
		String[] cs = (String[]) x.toArray(new String[x.size()]);
		
		JComboBox comboBox = new JComboBox(cs);
		comboBox.setBounds(266, 79, 313, 24);
		getContentPane().add(comboBox);
		
		JLabel lblEnterMarksFor = new JLabel("Enter Marks For Subject (Out Of 100) :");
		lblEnterMarksFor.setBounds(73, 113, 307, 24);
		lblEnterMarksFor.setFont(new Font("Tahoma", Font.BOLD, 13));
		getContentPane().add(lblEnterMarksFor);
		
		JLabel label = new JLabel("ADA:");
		label.setFont(new Font("Tahoma", Font.PLAIN, 12));
		label.setBounds(145, 169, 46, 14);
		getContentPane().add(label);
		
		textField = new JTextField();
		textField.setBounds(249, 166, 86, 20);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel label_1 = new JLabel("SP:");
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		label_1.setBounds(145, 206, 46, 14);
		getContentPane().add(label_1);
		
		textField_1 = new JTextField();
		textField_1.setBounds(249, 203, 86, 20);
		getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JLabel label_2 = new JLabel("OOPJ:");
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		label_2.setBounds(145, 237, 46, 14);
		getContentPane().add(label_2);
		
		textField_2 = new JTextField();
		textField_2.setBounds(249, 234, 86, 20);
		getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		JLabel label_3 = new JLabel("MPI:");
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 12));
		label_3.setBounds(425, 169, 46, 14);
		getContentPane().add(label_3);
		
		textField_3 = new JTextField();
		textField_3.setBounds(493, 166, 86, 20);
		getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		JLabel label_4 = new JLabel("CS:");
		label_4.setFont(new Font("Tahoma", Font.PLAIN, 12));
		label_4.setBounds(425, 200, 46, 14);
		getContentPane().add(label_4);
		
		textField_4 = new JTextField();
		textField_4.setBounds(493, 197, 86, 20);
		getContentPane().add(textField_4);
		textField_4.setColumns(10);
		
		JLabel label_5 = new JLabel("DE2A:");
		label_5.setFont(new Font("Tahoma", Font.PLAIN, 12));
		label_5.setBounds(425, 237, 46, 14);
		getContentPane().add(label_5);
		
		textField_5 = new JTextField();
		textField_5.setBounds(493, 234, 86, 20);
		getContentPane().add(textField_5);
		textField_5.setColumns(10);
		
		JButton btnSave = new JButton("Confirm");
		btnSave.setIcon(new ImageIcon(this.getClass().getResource("/images/confirm.png")));
		btnSave.setFont(new Font("Sitka Small", Font.BOLD, 16));
		btnSave.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				double avg=(Double.parseDouble(textField.getText())+Double.parseDouble(textField_1.getText())+Double.parseDouble(textField_2.getText())+Double.parseDouble(textField_3.getText())+Double.parseDouble(textField_4.getText())+Double.parseDouble(textField_5.getText()))/6.0;
				int j=comboBox.getSelectedIndex();
				String str=cs[j].substring(1,4);
				try
				{
					Class.forName("com.mysql.jdbc.Driver");
					Connection c=DriverManager.getConnection("jdbc:mysql://localhost/college", "root", "root");
					PreparedStatement p=(PreparedStatement)c.prepareStatement("select * from student where uid = ?");
					p.setString(1,str);
					ResultSet rs=p.executeQuery();
					if(rs.next()) 
					{
						p=(PreparedStatement)c.prepareStatement("update student set marks=? where uid=?");
						p.setDouble(1,avg);
						p.setString(2,str);
						boolean b=p.execute();
						JOptionPane.showMessageDialog(null,"Student Marks Stored!");
					}
					else 
					{
						JOptionPane.showMessageDialog(null,"ERROR : Student Does Not Exist");
					}
				}
				catch(Exception ze)
				{
					ze.printStackTrace();
				}
				finally
				{
					dispose();
				}
			}
		});
		btnSave.setBounds(249, 287, 237, 68);
		getContentPane().add(btnSave);
		
		JLabel lblEnterStudentName = new JLabel("Select Student :");
		lblEnterStudentName.setBounds(73, 79, 183, 26);
		lblEnterStudentName.setFont(new Font("Tahoma", Font.BOLD, 13));
		getContentPane().add(lblEnterStudentName);
		
		JLabel lblEnterMarks = new JLabel("Enter Marks:");
		lblEnterMarks.setBounds(377, 15, 313, 36);
		lblEnterMarks.setForeground(Color.WHITE);
		lblEnterMarks.setFont(new Font("Sitka Small", Font.BOLD, 22));
		lblEnterMarks.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(lblEnterMarks);
		
		JLabel label_6 = new JLabel(" ");
		label_6.setIcon(new ImageIcon(this.getClass().getResource("/images/teacherBackground.png")));
		label_6.setBounds(0, 2, 700, 450);
		getContentPane().add(label_6);
	}
	
	public void enterStudentAttendance() throws ClassNotFoundException, SQLException
	{
		getContentPane().setBackground(Color.WHITE);
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(369, 180, 700, 450);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(192, 192, 192));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		Class.forName("com.mysql.jdbc.Driver");
		Connection c=DriverManager.getConnection("jdbc:mysql://localhost/college", "root", "root");

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
		lblX.setBounds(660, 0, 40, 44);
		getContentPane().add(lblX);

		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(324, 125, 145, 32);
		getContentPane().add(dateChooser);

		JLabel lblChooseDate = new JLabel("Choose Date : ");
		lblChooseDate.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblChooseDate.setBounds(63, 125, 163, 32);
		getContentPane().add(lblChooseDate);

		JLabel lblEnterPresentStudent = new JLabel("Enter Absent Student UIDs");
		lblEnterPresentStudent.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblEnterPresentStudent.setBounds(63, 198, 232, 32);
		getContentPane().add(lblEnterPresentStudent);

		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField.setBounds(324, 198, 259, 32);
		getContentPane().add(textField);
		textField.setColumns(10);

		JLabel lblSeperateEachUid = new JLabel("Seperate Each UID With A Space");
		lblSeperateEachUid.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblSeperateEachUid.setForeground(Color.RED);
		lblSeperateEachUid.setBounds(241, 254, 232, 14);
		getContentPane().add(lblSeperateEachUid);

		JButton btnMakeChanges = new JButton("Confirm");
		btnMakeChanges.setIcon(new ImageIcon(this.getClass().getResource("/images/confirm.png")));
		btnMakeChanges.setFont(new Font("Sitka Small", Font.BOLD, 16));
		btnMakeChanges.setBorder(BorderFactory.createLineBorder(Color.black,1));
		btnMakeChanges.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				String date="";
				String uids=textField.getText();
				String uid[]=uids.split(" ");
				int i = 0;
				try
				{
					Date d = dateChooser.getDate();
					SimpleDateFormat dateFormat = new SimpleDateFormat("ddMMyyyy");
					date = dateFormat.format(dateChooser.getDate());
					PreparedStatement p=(PreparedStatement)c.prepareStatement("select d"+date+" from attendance");
					boolean b=p.execute();
					while(i<uid.length)
					{
						String a=uid[i];
						p=(PreparedStatement)c.prepareStatement("update attendance set d"+date+"=? where uid=?");
						p.setString(1, "A");
						p.setString(2, a);
						b=p.execute();
						i++;
					}					
				}
				catch(SQLException ze)
				{
					try
					{
						PreparedStatement p=(PreparedStatement)c.prepareStatement("alter table attendance add d"+date+" varchar(2)");
						boolean b=p.execute();
						p=(PreparedStatement)c.prepareStatement("update attendance set d"+date+"='P'");
						b=p.execute();
						while(i<uid.length)
						{
							String a=uid[i];
							p=(PreparedStatement)c.prepareStatement("update attendance set d"+date+"=? where uid=?");
							p.setString(1, "A");
							p.setString(2, a);
							b=p.execute();
							i++;
						}
					}
					catch(Exception e)
					{
						e.printStackTrace();
					}
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
				try
				{
					PreparedStatement p=(PreparedStatement)c.prepareStatement("select * from attendance");
					ResultSet rs=p.executeQuery();
					float atten,abs=0,pres=0;
					while(rs.next())
					{
						abs=0;pres=0;
						String uid1=rs.getString(1);
						int f=2;
						while(true)
						{
							try
							{
								String test=rs.getString(f);
								if(test==null)
								{
									
								}
								else
								{
									if(test.equals("A"))
										abs++;
									if(test.equals("P"))
										pres++;
								}
							}
							catch(SQLException e)
							{
								try
								{
									atten=pres/(abs+pres)*100;
								}
								catch(ArithmeticException ex)
								{
									atten=-1;
								}
								PreparedStatement p3=(PreparedStatement)c.prepareStatement("update student set attendance=? where uid=?");
								p3.setFloat(1, atten);
								p3.setString(2, uid1);
								boolean b3=p3.execute();
								break;
							}
							f++;
						}

					}

				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
				dispose();

			}
		});
		btnMakeChanges.setBounds(222, 295, 215, 55);
		getContentPane().add(btnMakeChanges);

		JLabel lblAttendance = new JLabel("Attendance");
		lblAttendance.setHorizontalAlignment(SwingConstants.CENTER);
		lblAttendance.setForeground(Color.WHITE);
		lblAttendance.setFont(new Font("Sitka Small", Font.BOLD, 22));
		lblAttendance.setBounds(401, 16, 247, 28);
		getContentPane().add(lblAttendance);

		JLabel label = new JLabel(" ");
		label.setIcon(new ImageIcon(this.getClass().getResource("/images/teacherBackground.png")));
		label.setBounds(0, 0, 700, 450);
		getContentPane().add(label);
	}
}