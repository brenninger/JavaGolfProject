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
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class CreateTeam extends Buttons {

	JFrame frmTeam;
	private static JTextField txtTName;
	private static JTextField txtP2;
	private static JTextField txtP1;
	private static JTextField txtP3;
	private static JTextField txtP4;
	// Connection con = null;
	static Component frame = null;
	static Player newPlayer = new Player();
	static Team newTeam;// = new Team();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CreateTeam window = new CreateTeam();
					window.frmTeam.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public CreateTeam() {
		initialize();
	}

	/** Initialize the contents of the frame. */
	private void initialize() {
		// Create team / player GUI
		frmTeam = new JFrame();
		frmTeam.setTitle("Golf - Create Team");
		frmTeam.setBounds(100, 100, 385, 234);
		frmTeam.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmTeam.getContentPane().setLayout(null);

		JLabel Team = new JLabel("Create Team");
		Team.setHorizontalAlignment(SwingConstants.CENTER);
		Team.setFont(new Font("Tahoma", Font.BOLD, 18));
		Team.setBounds(120, 11, 129, 35);
		frmTeam.getContentPane().add(Team);

		JLabel lblTeamName = new JLabel("Team Name:");
		lblTeamName.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblTeamName.setBounds(158, 71, 72, 23);
		frmTeam.getContentPane().add(lblTeamName);

		JLabel lblNewLabel_1 = new JLabel("Player ID");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1.setBounds(25, 57, 107, 29);
		frmTeam.getContentPane().add(lblNewLabel_1);

		JLabel lblPlayer = new JLabel("Player 1:");
		lblPlayer.setBounds(25, 84, 50, 23);
		frmTeam.getContentPane().add(lblPlayer);

		JLabel lblPlayer_1 = new JLabel("Player 2:");
		lblPlayer_1.setBounds(25, 108, 50, 23);
		frmTeam.getContentPane().add(lblPlayer_1);

		JLabel lblPlayer_2 = new JLabel("Player 3:");
		lblPlayer_2.setBounds(25, 134, 50, 23);
		frmTeam.getContentPane().add(lblPlayer_2);

		JLabel lblPlayer_3 = new JLabel("Player 4:");
		lblPlayer_3.setBounds(25, 158, 50, 23);
		frmTeam.getContentPane().add(lblPlayer_3);

		// team name text field
		txtTName = new JTextField();
		txtTName.setBounds(238, 73, 121, 20);
		frmTeam.getContentPane().add(txtTName);
		txtTName.setColumns(10);

		// insert the team into the database
		JButton teamSubmit = new JButton("Submit");
		teamSubmit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				submit();

			}
		});
		teamSubmit.setBounds(168, 111, 89, 23);
		frmTeam.getContentPane().add(teamSubmit);

		// clear the team text fields
		JButton teamClear = new JButton("Clear");
		teamClear.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				clear();
			}
		});
		teamClear.setBounds(268, 111, 89, 23);
		frmTeam.getContentPane().add(teamClear);


		// player1 text field
		txtP1 = new JTextField();
		txtP1.setBounds(82, 85, 50, 20);
		frmTeam.getContentPane().add(txtP1);
		txtP1.setColumns(10);

		// player2 text field
		txtP2 = new JTextField();
		txtP2.setBounds(82, 109, 50, 20);
		frmTeam.getContentPane().add(txtP2);
		txtP2.setColumns(10);

		// player3 text field
		txtP3 = new JTextField();
		txtP3.setBounds(82, 135, 50, 20);
		frmTeam.getContentPane().add(txtP3);
		txtP3.setColumns(10);

		// player4 text field
		txtP4 = new JTextField();
		txtP4.setBounds(82, 159, 50, 20);
		frmTeam.getContentPane().add(txtP4);
		txtP4.setColumns(10);

		JButton btnClose = new JButton("Close");
		btnClose.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setFrame(frmTeam);
				closeFrame();
			}
		});
		btnClose.setBounds(221, 145, 89, 23);
		frmTeam.getContentPane().add(btnClose);

	}

	public static void teamSubmit() throws SQLException,
			ClassNotFoundException, InstantiationException,
			IllegalAccessException {
		DBConnect db = new DBConnect();
		db.dbConnection();

		System.out.println("here " + newTeam.getPlayer1());
		ResultSet p1 = db.getStatement().executeQuery(
				"SELECT `playerID` FROM `player` WHERE `playerID` = "
						+ newTeam.getPlayer1() + ";");
		boolean rSet1 = p1.next();

		ResultSet p2 = db.getStatement().executeQuery(
				"SELECT `playerID` FROM `player` WHERE `playerID` = "
						+ newTeam.getPlayer2() + ";");
		boolean rSet2 = p2.next();

		ResultSet p3 = db.getStatement().executeQuery(
				"SELECT `playerID` FROM `player` WHERE `playerID` = "
						+ newTeam.getPlayer3() + ";");
		boolean rSet3 = p3.next();

		ResultSet p4 = db.getStatement().executeQuery(
				"SELECT `playerID` FROM `player` WHERE `playerID` = "
						+ newTeam.getPlayer4() + ";");
		boolean rSet4 = p4.next();

		if ((rSet1 && rSet2 && rSet3 && rSet4 == true)
				&& newTeam.getTeamName() != "") {
			String query = "INSERT INTO `team`(`teamName`, `player1`, `player2`, `player3`, `player4`) VALUES ('"
					+ newTeam.getTeamName()
					+ "', "
					+ newTeam.getPlayer1()
					+ ", "
					+ newTeam.getPlayer2()
					+ ", "
					+ newTeam.getPlayer3()
					+ ", " + newTeam.getPlayer4() + ");";
			db.getStatement().executeUpdate(query);
		} else if (newTeam.getTeamName() == "") {
			JOptionPane.showMessageDialog(frame, "You must enter a team name!");
		} else if (rSet1 == false) {
			JOptionPane.showMessageDialog(frame,
					"Player ID " + newTeam.getPlayer1() + " doesn't exist! p1");
		} else if (rSet2 == false) {
			JOptionPane.showMessageDialog(frame,
					"Player ID " + newTeam.getPlayer2() + " doesn't exist!");
		} else if (rSet3 == false) {
			JOptionPane.showMessageDialog(frame,
					"Player ID " + newTeam.getPlayer3() + " doesn't exist!");
		} else if (rSet4 == false) {
			JOptionPane.showMessageDialog(frame,
					"Player ID " + newTeam.getPlayer4() + " doesn't exist!");
		}
		
	}


	@Override
	public void submit() {
		// TODO Auto-generated method stub
//		newTeam.setTeamName(txtTName.getText());
//		newTeam.setPlayer1(Integer.parseInt(txtP1.getText()));
//		newTeam.setPlayer2(Integer.parseInt(txtP2.getText()));
//		newTeam.setPlayer3(Integer.parseInt(txtP3.getText()));
//		newTeam.setPlayer4(Integer.parseInt(txtP4.getText()));
		newTeam = new Team(txtTName.getText(), Integer.parseInt(txtP1.getText()), Integer.parseInt(txtP2.getText()),
				Integer.parseInt(txtP3.getText()), Integer.parseInt(txtP4.getText()));
		
		try {
			teamSubmit();
		} catch (ClassNotFoundException | InstantiationException
				| IllegalAccessException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		txtTName.setText("");
		txtP1.setText("");
		txtP2.setText("");
		txtP3.setText("");
		txtP4.setText("");
	}


}
