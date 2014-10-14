import java.awt.*;
import java.awt.event.*;
import java.sql.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class DisplayDB extends Frame
{
	private static PreparedStatement pstmt; 
	static Connection con = null;
	
	public DisplayDB(String app) {
    	super(app);
    	setup();
    }

private void setup() {
			
			setSize(400, 150);
			setLocationRelativeTo(null);
			setBackground(Color.GREEN);
			setVisible(true);
			
			Panel info    = new Panel();   // panel for the text and labels
		    info.setLayout(null);
			
		    Label	team = new Label("Choose Team"); team.setBounds(10,5,150,25); team.setFont(new Font("Arial", Font.BOLD, 18)); info.add(team);      
		    Label	player = new Label("Choose Player "); player.setBounds(215,5,150,25); player.setFont(new Font("Arial", Font.BOLD, 18)); info.add(player);
		    
		    final TextField	teamTextfield = new TextField(); teamTextfield.setBounds(10,35,100,23); info.add(teamTextfield);
		    final TextField	player1Textfield = new TextField(); player1Textfield.setBounds(215,35,100,23); info.add(player1Textfield);
		      
			Button displayTeam = new Button("Display Team Information"); info.add(displayTeam); displayTeam.setBounds(10, 65, 160, 35); displayTeam.setFont(new Font("Arial", Font.BOLD, 12));
		    Button displayPlayer = new Button("Display Player Information"); info.add(displayPlayer); displayPlayer.setBounds(215, 65, 160, 35); displayPlayer.setFont(new Font("Arial", Font.BOLD, 12));

		    setLayout(new BorderLayout());
		    add(info); 

		    displayTeam.addActionListener(new java.awt.event.ActionListener() {
		          public void actionPerformed(java.awt.event.ActionEvent displayTeam) {
		        	  showTableData();
		          }
		      });
		    displayPlayer.addActionListener(new java.awt.event.ActionListener() {
		          public void actionPerformed(java.awt.event.ActionEvent displayPlayer) {
		        	  showTableData();
		          }
		      });
		    
		    addWindowListener(new WindowAdapter() {
		         public void windowClosing(WindowEvent windowEvent){
			        dispose();
		         }
		      }); 
		   }  
   public void showTableData()
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
	   

		  JFrame frame = new JFrame("Team Information Database");
		  setLayout(new BorderLayout()); 
		   
		  addWindowListener(new WindowAdapter() {
		         public void windowClosing(WindowEvent windowEvent){
			        dispose();
		         }
		      }); 
		  
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
	   	
		  frame.add(scroll);
		  frame.setVisible(true);
		  frame.setLocationRelativeTo(null);
		  frame.setSize(500,400);
	   
	   try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/CSC3610_Connection","localhost", "");
			
			if(!con.isClosed())
				System.out.println("CSC3610 Class, you have successfully connected to " +
						"MySql Server using a Java Application");
			
			//Test database
			PreparedStatement pstmt = con.prepareStatement("SELECT * FROM csc3610_connection.test");
			
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
   
}