import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
import java.sql.ResultSet;
//import java.sql.SQLException;

import java.sql.SQLException;
//import java.sql.Statement;

import javax.swing.JFrame;
//import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Data {

	Connection con = null;
//	Statement statement;
	DBConnect connect = new DBConnect();
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

//	class pData{
		public void showPlayerData() {
			Player curPlayer = new Player(){};

//				@Override
//				public void handicap() {
//					// TODO Auto-generated method stub
//					
//				}};

			String[] playerColumnNames = { "Player ID", "First Name",
					"Last Name", "Handicap" };
			JTable table = new JTable();
			DefaultTableModel model = new DefaultTableModel();

			JFrame frame = new JFrame("Player Data");

			// Creates Table
			model.setColumnIdentifiers(playerColumnNames);
			table = new JTable(model);
			table = new JTable();
			table.setModel(model);
			table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
			table.setFillsViewportHeight(true);
			JScrollPane scroll = new JScrollPane(table);
			scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
			scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

			frame.getContentPane().add(scroll);
			frame.setVisible(true);
			frame.setLocationRelativeTo(null);
			frame.setSize(500, 400);

			try {

				connect.dbConnection();
//				statement = con.createStatement();
				// Test database
//				statement = connect.getStatement();
//				String pstmt = "SELECT * FROM player";
				ResultSet rset = connect.getStatement().executeQuery("SELECT * FROM player");
//				ResultSet rset = pstmt.executeUpdate(pstmt);
				while (rset.next()) {
					curPlayer.setPlayerID(Integer.parseInt(rset.getString("playerID")));
//					newPlayer.setPlayerID(3);
					System.out.println(rset.getString("playerID"));
					curPlayer.setFName(rset.getString("FName"));
					curPlayer.setLName(rset.getString("LName"));
//					curPlayer.setHandicap(Integer.parseInt(rset.getString("handicap")));
//					System.out.println(rset.getString("handicap"));
					model.addRow(new Object[] { curPlayer.getPlayerID(), curPlayer.getFName(), curPlayer.getLName(),
							curPlayer.getHandicap() });
				}
			}  catch (ClassNotFoundException | InstantiationException
					| IllegalAccessException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
//			catch (Exception ex) {
//				JOptionPane.showMessageDialog(null, ex.getMessage(), "Error",
//						JOptionPane.ERROR_MESSAGE);
//			}
		}

//	}

		public void showTeamData() {
			Team curTeam = new Team(){};

//				@Override
//				public void tRank() {
//					// TODO Auto-generated method stub
//					
//				}};
			String[] teamColumnNames = { "Team Name", "Player 1", "Player 2",
					"Player 3", "Player 4", "Team Rank" };
			JTable table = new JTable();
			DefaultTableModel model = new DefaultTableModel();

			JFrame frame = new JFrame("Team Data");

			// Creates Table
			model.setColumnIdentifiers(teamColumnNames);
			table = new JTable(model);
			table = new JTable();
			table.setModel(model);
			table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
			table.setFillsViewportHeight(true);
			JScrollPane scroll = new JScrollPane(table);
			scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
			scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

			frame.getContentPane().add(scroll);
			frame.setVisible(true);
			frame.setLocationRelativeTo(null);
			frame.setSize(500, 400);

			try {
				connect.dbConnection();

				ResultSet rset = connect.getStatement().executeQuery("SELECT * FROM team");
				while (rset.next()) {
					
					curTeam.setTeamName(rset.getString("TeamName"));
					curTeam.setPlayer1(Integer.parseInt(rset.getString("player1")));
					curTeam.setPlayer2(Integer.parseInt(rset.getString("player2")));
					curTeam.setPlayer3(Integer.parseInt(rset.getString("player3")));
					curTeam.setPlayer4(Integer.parseInt(rset.getString("player4")));
//					curTeam.settRank(Integer.parseInt(rset.getString("teamRank")));
//					model.addRow(new Object[] { curTeam.getTeamName(), curTeam.getPlayer1(), curTeam.getPlayer2(),
//							curTeam.getPlayer3(), curTeam.getPlayer4(), curTeam.gettRank()});
					model.addRow(new Object[] { curTeam.getTeamName(), curTeam.getPlayer1(), curTeam.getPlayer2(),
							curTeam.getPlayer3(), curTeam.getPlayer4()});
				}
			}  catch (ClassNotFoundException | InstantiationException
					| IllegalAccessException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
//			catch (Exception ex) {
//				JOptionPane.showMessageDialog(null, ex.getMessage(), "Error",
//						JOptionPane.ERROR_MESSAGE);
//			}
		}

}
