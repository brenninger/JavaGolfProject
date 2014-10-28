import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
//import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;


public class Create_GUI {

	JFrame frmGolfCreate;
	private static JTextField txtTName;
	private JTextField txtFName;
	private JTextField txtLName;
	private static JTextField txtP2;
	private static JTextField txtP1;
	private static JTextField txtP3;
	private static JTextField txtP4;
//	Connection con = null;
	static Component frame = null;
//	static dbConnect db = new dbConnect();
//	static team newTeam = new team(){};
	static player newPlayer = new player(){};
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Create_GUI window = new Create_GUI();
					window.frmGolfCreate.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Create_GUI() {
		initialize();
	}

	/**Initialize the contents of the frame.*/
	private void initialize() {
		//Create team / player GUI
		frmGolfCreate = new JFrame();
		frmGolfCreate.setTitle("Golf - Create Team / Player");
		frmGolfCreate.setBounds(100, 100, 385, 379);
		frmGolfCreate.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmGolfCreate.getContentPane().setLayout(null);
		
		JLabel Team = new JLabel("Create Team");
		Team.setHorizontalAlignment(SwingConstants.CENTER);
		Team.setFont(new Font("Tahoma", Font.BOLD, 18));
		Team.setBounds(120, 11, 129, 35);
		frmGolfCreate.getContentPane().add(Team);
		
		JLabel lblNewLabel = new JLabel("Create Player");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setBounds(118, 191, 132, 35);
		frmGolfCreate.getContentPane().add(lblNewLabel);
		
		JLabel lblTeamName = new JLabel("Team Name:");
		lblTeamName.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblTeamName.setBounds(12, 77, 72, 23);
		frmGolfCreate.getContentPane().add(lblTeamName);
		
		JLabel lblNewLabel_1 = new JLabel("Player Numbers");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1.setBounds(238, 50, 107, 29);
		frmGolfCreate.getContentPane().add(lblNewLabel_1);
		
		JLabel lblPlayer = new JLabel("Player 1:");
		lblPlayer.setBounds(238, 77, 50, 23);
		frmGolfCreate.getContentPane().add(lblPlayer);
		
		JLabel lblPlayer_1 = new JLabel("Player 2:");
		lblPlayer_1.setBounds(238, 101, 50, 23);
		frmGolfCreate.getContentPane().add(lblPlayer_1);
		
		JLabel lblPlayer_2 = new JLabel("Player 3:");
		lblPlayer_2.setBounds(238, 127, 50, 23);
		frmGolfCreate.getContentPane().add(lblPlayer_2);
		
		JLabel lblPlayer_3 = new JLabel("Player 4:");
		lblPlayer_3.setBounds(238, 151, 50, 23);
		frmGolfCreate.getContentPane().add(lblPlayer_3);
		
		//team name text field
		txtTName = new JTextField();
		txtTName.setBounds(92, 79, 121, 20);
		frmGolfCreate.getContentPane().add(txtTName);
		txtTName.setColumns(10);
		
		//insert the team into the database
		JButton teamSubmit = new JButton("Submit");
		teamSubmit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
//				newTeam.setTeamName(txtTName.getText());
//				newTeam.setPlayer1(Integer.parseInt(txtP1.getText()));
//				newTeam.setPlayer2(Integer.parseInt(txtP2.getText()));
//				newTeam.setPlayer3(Integer.parseInt(txtP3.getText()));
//				newTeam.setPlayer4(Integer.parseInt(txtP4.getText()));
//				System.out.println();
//				System.out.println(newTeam.getPlayer1());
				
					try {
						teamSubmit();
					} catch (SQLException | ClassNotFoundException | InstantiationException | IllegalAccessException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				
				
			}
		});
		teamSubmit.setBounds(23, 127, 89, 23);
		frmGolfCreate.getContentPane().add(teamSubmit);
		
		//clear the team text fields
		JButton teamClear = new JButton("Clear");
		teamClear.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtTName.setText("");
				txtP1.setText("");
				txtP2.setText("");
				txtP3.setText("");
				txtP4.setText("");
			}
		});
		teamClear.setBounds(122, 127, 89, 23);
		frmGolfCreate.getContentPane().add(teamClear);
		
		JLabel lblFirstName = new JLabel("First Name:");
		lblFirstName.setBounds(36, 248, 76, 23);
		frmGolfCreate.getContentPane().add(lblFirstName);
		
		//player first name text field
		txtFName = new JTextField();
		txtFName.setBounds(103, 249, 136, 20);
		frmGolfCreate.getContentPane().add(txtFName);
		txtFName.setColumns(10);
		
		JLabel lblLastName = new JLabel("Last Name:");
		lblLastName.setBounds(36, 280, 76, 21);
		frmGolfCreate.getContentPane().add(lblLastName);
		
		//player last name text field
		txtLName = new JTextField();
		txtLName.setBounds(103, 280, 136, 20);
		frmGolfCreate.getContentPane().add(txtLName);
		txtLName.setColumns(10);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(Color.BLACK);
		separator.setBackground(Color.BLACK);
		separator.setBounds(12, 185, 348, 2);
		frmGolfCreate.getContentPane().add(separator);
		
		//player1 text field
		txtP1 = new JTextField();
		txtP1.setBounds(295, 78, 50, 20);
		frmGolfCreate.getContentPane().add(txtP1);
		txtP1.setColumns(10);
		
		//player2 text field
		txtP2 = new JTextField();
		txtP2.setBounds(295, 102, 50, 20);
		frmGolfCreate.getContentPane().add(txtP2);
		txtP2.setColumns(10);
		
		//player3 text field
		txtP3 = new JTextField();
		txtP3.setBounds(295, 128, 50, 20);
		frmGolfCreate.getContentPane().add(txtP3);
		txtP3.setColumns(10);
		
		//player4 text field
		txtP4 = new JTextField();
		txtP4.setBounds(295, 152, 50, 20);
		frmGolfCreate.getContentPane().add(txtP4);
		txtP4.setColumns(10);
		
		//clear the player text fields
		JButton playerClear = new JButton("Clear");
		playerClear.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtFName.setText("");
				txtLName.setText("");
			
			}
		});
		playerClear.setBounds(249, 260, 89, 23);
		frmGolfCreate.getContentPane().add(playerClear);
		
		//insert the player into the database
		JButton playerSubmit = new JButton("Submit");
		playerSubmit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				newPlayer.setFName(txtFName.getText());
				newPlayer.setLName(txtLName.getText());
				
				
//					dbConnection();
					try {
						playerSubmit();
					} catch (SQLException | ClassNotFoundException | InstantiationException | IllegalAccessException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
			
				
			}
		});
		playerSubmit.setBounds(249, 227, 89, 23);
		frmGolfCreate.getContentPane().add(playerSubmit);
		
		JButton btnClose = new JButton("Close");
		btnClose.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
//				System.exit(0);
//				frmGolfCreate.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				frmGolfCreate.setVisible(false);
			}
		});
		btnClose.setBounds(249, 293, 89, 23);
		frmGolfCreate.getContentPane().add(btnClose);
		
		
	}
	
	public static void teamSubmit() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException{
		dbConnect db = new dbConnect();
		db.dbConnection();
		
		team newTeam = new team(){};
		newTeam.setTeamName(txtTName.getText());
		newTeam.setPlayer1(Integer.parseInt(txtP1.getText()));
		newTeam.setPlayer2(Integer.parseInt(txtP2.getText()));
		newTeam.setPlayer3(Integer.parseInt(txtP3.getText()));
		newTeam.setPlayer4(Integer.parseInt(txtP4.getText()));
		System.out.println("here " + newTeam.getPlayer1());
		ResultSet p1 = db.getStatement().executeQuery("SELECT `playerID` FROM `player` WHERE `playerID` = " +
				newTeam.getPlayer1() + ";");
		boolean rSet1 = p1.next();
		
		ResultSet p2 = db.getStatement().executeQuery("SELECT `playerID` FROM `player` WHERE `playerID` = " +
				newTeam.getPlayer2() + ";");
		boolean rSet2 = p2.next();
		
		ResultSet p3 = db.getStatement().executeQuery("SELECT `playerID` FROM `player` WHERE `playerID` = " +
				newTeam.getPlayer3() + ";");
		boolean rSet3 = p3.next();
		
		ResultSet p4 = db.getStatement().executeQuery("SELECT `playerID` FROM `player` WHERE `playerID` = " +
				newTeam.getPlayer4() + ";");
		boolean rSet4 = p4.next();
		
		if ((rSet1 && rSet2 && rSet3 && rSet4 == true) && newTeam.getTeamName() != ""){
			String query = "INSERT INTO `team`(`teamName`, `player1`, `player2`, `player3`, `player4`) VALUES ('" +
					newTeam.getTeamName() + "', " + newTeam.getPlayer1() + ", " + newTeam.getPlayer2() + ", " +
					newTeam.getPlayer3() + ", " + newTeam.getPlayer4() + ");";
			db.getStatement().executeUpdate(query);
		}else if (newTeam.getTeamName() == ""){
			JOptionPane.showMessageDialog(frame, "You must enter a team name!");
		}else if(p1.next() == false){
			JOptionPane.showMessageDialog(frame, "Player ID " + newTeam.getPlayer1() +" doesn't exist!");
		}else if(p2.next() == false){
			JOptionPane.showMessageDialog(frame, "Player ID " + newTeam.getPlayer2() +" doesn't exist!");
		}else if(p3.next() == false){
			JOptionPane.showMessageDialog(frame, "Player ID " + newTeam.getPlayer3() +" doesn't exist!");
		}else if(p4.next() == false){
			JOptionPane.showMessageDialog(frame, "Player ID " + newTeam.getPlayer4() +" doesn't exist!");
		}
		
	}
	
	public static void playerSubmit() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException{
		dbConnect db = new dbConnect();
		db.dbConnection();
		String query = "INSERT INTO `player`(`FName`, `LName`) VALUES ('" + newPlayer.getFName() +
				"', '" + newPlayer.getLName() + "');";
		db.getStatement().executeUpdate(query);
	}
	
	
}
