import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
//import javax.swing.JOptionPane;
//import javax.swing.JScrollPane;
//import javax.swing.JTable;
//import javax.swing.table.DefaultTableModel;

public class menu{

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

	/**Create the application.*/
	public menu() {
		initialize();
	}

	/**Initialize the contents of the frame.*/
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
//				showPlayerData();
				data d = new data();
				d.showPlayerData();
			}
		});
		btnPlayer.setBounds(10, 45, 100, 23);
		frmGolfMain.getContentPane().add(btnPlayer);

		JButton btnTeam = new JButton("Team Data");
		btnTeam.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				data d = new data();
				d.showTeamData();
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
//				 frmGolfMain.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				System.exit(0);
				
			}
		});
		btnClose.setBounds(225, 45, 89, 23);
		frmGolfMain.getContentPane().add(btnClose);
	}
	
}
