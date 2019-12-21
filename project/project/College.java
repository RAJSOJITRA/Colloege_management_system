package project;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import java.sql.*;
import java.awt.event.*;

public class College extends JFrame 
{
	private JTextField textField;
	private JPasswordField passwordField;
	private JPanel contentPane;

	public static void main(String[] args) 
	{
		College frame = new College();
		frame.setVisible(true);		
	}

	public College() 
	{
		getContentPane().setBackground(Color.WHITE);
		setBackground(Color.WHITE);
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(369, 180,629,408);

		JLabel lblX = new JLabel("X");
		lblX.setBounds(600, 0, 29, 29);
		lblX.setForeground(Color.WHITE);
		lblX.addMouseListener(new MouseAdapter() 
		{
			@Override
			public void mouseClicked(MouseEvent arg0) 
			{
				System.exit(0);
			}
		});
		
		getContentPane().setLayout(null);
		lblX.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblX.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(lblX);

		JLabel lblLogin = new JLabel("USER NAME:");
		lblLogin.setBounds(452, 236, 68, 20);
		lblLogin.setForeground(Color.BLACK);
		lblLogin.setFont(new Font("Tahoma", Font.BOLD, 11));
		getContentPane().add(lblLogin);

		textField = new JTextField();
		textField.setBounds(520, 236, 86, 20);
		getContentPane().add(textField);
		textField.setColumns(10);

		JLabel lblPassword = new JLabel("PASSWORD:");
		lblPassword.setBounds(452, 267, 68,20);
		lblPassword.setForeground(Color.BLACK);
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 11));
		getContentPane().add(lblPassword);

		passwordField = new JPasswordField();
		passwordField.setBounds(520, 267, 86, 20);
		getContentPane().add(passwordField);

		JButton btnLogin = new JButton("Login");
		btnLogin.setBounds(452, 290, 143, 15);
		btnLogin.setBackground(new Color(192, 192, 192));
		
		btnLogin.setIcon(new ImageIcon(this.getClass().getResource("/images/login.png")));
		btnLogin.addMouseListener(new MouseAdapter() 
		{
			@Override
			public void mouseClicked(MouseEvent arg0) 
			{
				String usr=textField.getText();
				String pswd=passwordField.getText();
				if(usr.compareTo("admin")==0 && pswd.compareTo("admin")==0)
				{
					Admin.main();
				}
				else
				{
					try
					{
						Class.forName("com.mysql.jdbc.Driver");
						Connection c=DriverManager.getConnection("jdbc:mysql://localhost/college","root","root");
						PreparedStatement p=(PreparedStatement)c.prepareStatement("select * from login where uid = ? and pass = ?");
						p.setString(1,usr);
						p.setString(2,pswd);
						ResultSet rs=p.executeQuery();
						if(rs.next()) 
						{
							String s=rs.getString(3);
							if(s.compareTo("Student")==0)
							{
								Student.main(usr);
							}
							else
							{
								Teacher.main(usr);
							}
						}
						else 
						{
							JOptionPane.showMessageDialog(null,"ERROR: Invalid Credentials");
						}
					}
					catch(Exception e)
					{
						e.printStackTrace();
					}
				}
			}
		});
		
		getContentPane().add(btnLogin);

		JPanel panel = new JPanel();
		panel.setBounds(433, 225, 179, 85);
		panel.setBackground(Color.WHITE);
		panel.setBorder(BorderFactory.createLineBorder(Color.black,2));
		getContentPane().add(panel);

		JButton btnContactUs = new JButton("Contact Us!");
		btnContactUs.setBounds(456, 112, 129, 29);
		btnContactUs.setBackground(new Color(192, 192, 192));
		btnContactUs.setIcon(new ImageIcon(this.getClass().getResource("/images/telephone.png")));
		btnContactUs.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				College home=new College();
				home.contactUs();
				home.setVisible(true);
			}
		});
		getContentPane().add(btnContactUs);

		JLabel lblintro = new JLabel("");
		lblintro.setBounds(43, 59, 358, 250);
		lblintro.setIcon(new ImageIcon(this.getClass().getResource("/images/college.jpeg")));
		lblintro.setHorizontalAlignment(SwingConstants.CENTER);
		lblintro.setBorder(BorderFactory.createLineBorder(Color.black,2));
		getContentPane().add(lblintro);

		JButton btnAboutUs = new JButton("About Us!");
		btnAboutUs.setBounds(456, 164, 129, 29);
		btnAboutUs.setBackground(new Color(192, 192, 192));
		btnAboutUs.setIcon(new ImageIcon(this.getClass().getResource("/images/info.png")));
		btnAboutUs.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				College home=new College();
				home.aboutUs();
				home.setVisible(true);
			}
		});
		
		JLabel lblWelcomed = new JLabel("WELCOME");
		lblWelcomed.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
		lblWelcomed.setHorizontalAlignment(SwingConstants.CENTER);
		lblWelcomed.setForeground(Color.WHITE);
		lblWelcomed.setBounds(369, 8, 203, 40);
		getContentPane().add(lblWelcomed);
		getContentPane().add(btnAboutUs);

		JPanel panel_2 = new JPanel();
		panel_2.setBounds(433, 59, 179, 155);
		panel_2.setBackground(Color.WHITE);
		getContentPane().add(panel_2);
		panel_2.setBorder(BorderFactory.createLineBorder(Color.black,2));
		panel_2.setLayout(null);

		JLabel lblNewHere = new JLabel("New Here?");
		lblNewHere.setBounds(0, 0, 180, 50);
		panel_2.add(lblNewHere);
		lblNewHere.setForeground(new Color(0, 0, 0));
		lblNewHere.setFont(new Font("Sitka small", Font.PLAIN, 16));
		lblNewHere.setHorizontalAlignment(SwingConstants.CENTER);

		JLabel lblNewLabel = new JLabel("Welcome :D");
		lblNewLabel.setBounds(-72, 0, 210, 37);
		panel_2.add(lblNewLabel);
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Sitika small", Font.BOLD, 24));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);

		JLabel label_3 = new JLabel(" ");
		label_3.setIcon(new ImageIcon(this.getClass().getResource("/images/background.jpg")));
		label_3.setBounds(0, 0, 629,408);
		getContentPane().add(label_3);

		JLabel label_2 = new JLabel(" ");
		label_2.setBounds(0, 0, 46, 14);
		getContentPane().add(label_2);

	}
	
	public void aboutUs()
	{
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(369, 180, 629, 412);
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
		lblX.setBounds(589, 0, 40, 40);
		contentPane.add(lblX);
		
		String intro="Vishwakarma Government Engineering College (VGEC), also known as Government Engineering College, Chandkheda is one of the Government Engineering College situated at Chandkheda, in Ahmedabad city, India. VGEC is affiliated to Gujarat Technological University. The college was established in August 1994, with an objective of imparting higher education in various fields of engineering and technology. This institute is recognized by All India Council of Technical Education (AICTE), New Delhi and is administrated by Commissionerate of Technical Education, Gujarat State, Gandhinagar.";
		JLabel lblIntro = new JLabel("<html>"+intro+"</html>");
		lblIntro.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblIntro.setBounds(28, 30, 578, 314);
		contentPane.add(lblIntro);
		
		JLabel lblAboutUs = new JLabel("About Us :");
		lblAboutUs.setForeground(Color.WHITE);
		lblAboutUs.setFont(new Font("", Font.BOLD, 24));
		lblAboutUs.setHorizontalAlignment(SwingConstants.CENTER);
		lblAboutUs.setBounds(299, 0, 295, 59);
		contentPane.add(lblAboutUs);
		
		JLabel label = new JLabel(" ");
		label.setIcon(new ImageIcon(this.getClass().getResource("/images/background.jpg")));
		label.setBounds(0, 0, 629, 412);
		contentPane.add(label);
	}
	
	public void contactUs()
	{
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(369, 180, 629, 408);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
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
		lblX.setBounds(595, 11, 34, 34);
		contentPane.add(lblX);
		
		JLabel lblContactUs = new JLabel("Contact Us!");
		lblContactUs.setForeground(Color.WHITE);
		lblContactUs.setFont(new Font("Sitka Small", Font.BOLD, 22));
		lblContactUs.setHorizontalAlignment(SwingConstants.CENTER);
		lblContactUs.setBounds(333, 11, 252, 34);
		contentPane.add(lblContactUs);
		
		JLabel lblMap = new JLabel("");
		lblMap.setHorizontalAlignment(SwingConstants.CENTER);
		lblMap.setIcon(new ImageIcon(this.getClass().getResource("/images/map.jpg")));
		lblMap.setBounds(181, 56, 427, 176);
		contentPane.add(lblMap);
		
		JLabel lblMap_1 = new JLabel("MAP:");
		lblMap_1.setIcon(new ImageIcon(this.getClass().getResource("/images/map.png")));
		lblMap_1.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblMap_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblMap_1.setBounds(32, 63, 194, 116);
		contentPane.add(lblMap_1);
		
		JLabel lblAddress = new JLabel("Address :");
		lblAddress.setHorizontalAlignment(SwingConstants.LEFT);
		lblAddress.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblAddress.setForeground(Color.GRAY);
		lblAddress.setBounds(95, 244, 91, 14);
		contentPane.add(lblAddress);
		
		String add= "Nr. Visat Three Roads, Sabarmati-Koba Highway, Chandkheda Rd, Nigam Nagar, Chandkheda, Ahmedabad, Gujarat 382424";
		JLabel lblAdd = new JLabel("<html>"+add+"</html>");
		lblAdd.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblAdd.setVerticalAlignment(SwingConstants.TOP);
		lblAdd.setBounds(252, 243, 333, 45);
		contentPane.add(lblAdd);
		
		JLabel lblEmail = new JLabel("Email :");
		lblEmail.setForeground(Color.GRAY);
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblEmail.setHorizontalAlignment(SwingConstants.LEFT);
		lblEmail.setBounds(95, 288, 71, 20);
		contentPane.add(lblEmail);
		
		JLabel lblMail = new JLabel("principal@vgecg.ac.in");
		lblMail.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblMail.setBounds(252, 290, 140, 18);
		contentPane.add(lblMail);
		
		JLabel lblPhoneNo = new JLabel("Phone :");
		lblPhoneNo.setForeground(Color.GRAY);
		lblPhoneNo.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblPhoneNo.setBounds(95, 308, 105, 28);
		contentPane.add(lblPhoneNo);
		
		JLabel label = new JLabel("(079) 23293866");
		label.setFont(new Font("Tahoma", Font.PLAIN, 12));
		label.setBounds(252, 315, 145, 21);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel(" ");
		label_1.setIcon(new ImageIcon(this.getClass().getResource("/images/background.jpg")));
		label_1.setBounds(0, 0, 629, 408);
		contentPane.add(label_1);
	}
}