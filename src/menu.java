import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


public class menu {

	private JFrame frmGolfMain;
	static Connection con = null;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					menu window = new menu();
					window.frmGolfMain.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public menu() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmGolfMain = new JFrame();
		frmGolfMain.setTitle("Golf - Main Menu");
		frmGolfMain.setBounds(100, 100, 343, 118);
		frmGolfMain.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmGolfMain.getContentPane().setLayout(null);
		
		JButton btnCreate = new JButton("Create Team / Player");
		
		
		btnCreate.setBounds(26, 11, 161, 23);
		frmGolfMain.getContentPane().add(btnCreate);
		btnCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Create_GUI create = new Create_GUI();
				create.frmGolfCreate.setVisible(true);
			}
		});
		
		JButton btnPlayer = new JButton("Player Data");
		btnPlayer.setToolTipText("");
		btnPlayer.addActionListener(new ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent displayPlayer) {
	        	  showPlayerData();
	          }
		});
		btnPlayer.setBounds(10, 45, 100, 23);
		frmGolfMain.getContentPane().add(btnPlayer);
		
		JButton btnTeam = new JButton("Team Data");
		btnTeam.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showTeamData();
			}
		});
		btnTeam.setBounds(120, 45, 95, 23);
		frmGolfMain.getContentPane().add(btnTeam);
		
		JButton btnEnter = new JButton("Enter Score");
		btnEnter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				enterScore score = new enterScore();
				score.frmGolfScore.setVisible(true);
			}
		});
		btnEnter.setBounds(194, 11, 108, 23);
		frmGolfMain.getContentPane().add(btnEnter);
		
		JButton btnClose = new JButton("Close");
		btnClose.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
//				frmGolfMain.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				System.exit(0);
			}
		});
		btnClose.setBounds(225, 45, 89, 23);
		frmGolfMain.getContentPane().add(btnClose);
	}
	
	public void showPlayerData(){
		   String playerId;
		   String FName;
		   String LName;
		   String handicap;
		   String[] teamColumnNames = {"Player ID", "First Name", "Last Name", "Handicap"};
		   JTable table = new JTable();
		   DefaultTableModel model = new DefaultTableModel();
		   

			  JFrame frame = new JFrame("Player Data");
			  
			  //Creates Table
			  model.setColumnIdentifiers(teamColumnNames);
			  table = new JTable(model);
			  table = new JTable();
			  table.setModel(model); 
			  table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
			  table.setFillsViewportHeight(true);
			  JScrollPane scroll = new JScrollPane(table);
			  scroll.setHorizontalScrollBarPolicy(
			  JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
			  scroll.setVerticalScrollBarPolicy(
			  JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		   	
			  frame.getContentPane().add(scroll);
			  frame.setVisible(true);
			  frame.setLocationRelativeTo(null);
			  frame.setSize(500,400);
		   
		   try {
				
				dbConnection();
				//Test database
				PreparedStatement pstmt = con.prepareStatement("SELECT * FROM player");
				
				ResultSet rset = pstmt.executeQuery();
				while(rset.next())	{
					playerId = rset.getString("playerID");
					FName = rset.getString("FName");
					LName = rset.getString("LName");
					handicap = rset.getString("handicap");
					model.addRow(new Object[]{playerId, FName, LName, handicap});
				}
		   }	catch(Exception ex)
		   		{
			   		JOptionPane.showMessageDialog(null, ex.getMessage(),"Error",
			   				JOptionPane.ERROR_MESSAGE);
		   		}
	   }
	
	 public void showTeamData()
	   { 
		   String teamName;
		   String player1;
		   String player2;
		   String player3;
		   String player4;
		   String teamRank;
		   String[] teamColumnNames = {"Team Name", "Player 1", "Player 2", "Player 3", "Player 4", "Team Rank"};
		   JTable table = new JTable();
		   DefaultTableModel model = new DefaultTableModel();
		   
		   JFrame frame = new JFrame("Team Data");
			  
			  //Creates Table
			  model.setColumnIdentifiers(teamColumnNames);
			  table = new JTable(model);
			  table = new JTable();
			  table.setModel(model); 
			  table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
			  table.setFillsViewportHeight(true);
			  JScrollPane scroll = new JScrollPane(table);
			  scroll.setHorizontalScrollBarPolicy(
			  JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
			  scroll.setVerticalScrollBarPolicy(
			  JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		   	
			  frame.getContentPane().add(scroll);
			  frame.setVisible(true);
			  frame.setLocationRelativeTo(null);
			  frame.setSize(500,400);
		   
		   try {
			   dbConnection();
				
				//Test database
				PreparedStatement pstmt = con.prepareStatement("SELECT * FROM team");
				
				ResultSet rset = pstmt.executeQuery();
				while(rset.next())	{
					teamName = rset.getString("TeamName");
					player1 = rset.getString("player1");
					player2 = rset.getString("player2");
					player3 = rset.getString("player3"); 
					player4 = rset.getString("player4"); 
					teamRank = rset.getString("teamRank"); 
					model.addRow(new Object[]{teamName, player1, player2, player3, player4, teamRank});
				}
		   }	catch(Exception ex)
		   		{
			   		JOptionPane.showMessageDialog(null, ex.getMessage(),"Error",
			   				JOptionPane.ERROR_MESSAGE);
		   		}
	   }
	 
	private void dbConnection() throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
//		Connection con = null;
		Class.forName("com.mysql.jdbc.Driver").newInstance();
		
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/golf","user", "pass");
		
//		statement = con.createStatement();
//		stmt = con.createStatement();
//		con.close();
	}
}
