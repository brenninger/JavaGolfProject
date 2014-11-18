import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;


public class CreatePlayer extends Buttons{
	private JTextField txtFName;
	private JTextField txtLName;
	JFrame frmPlayer;
	private JButton btnSubmit;
	private JButton btnClear;
	static Component frame = null;
	static Player newPlayer;// = new Player();
	private JButton btnClose;

	/**Launch the application.*/
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CreatePlayer window = new CreatePlayer();
					window.frmPlayer.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public CreatePlayer() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmPlayer = new JFrame();
		frmPlayer.setBounds(100, 100, 268, 220);
		frmPlayer.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmPlayer.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Create Player");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setBounds(65, 11, 132, 35);
		frmPlayer.getContentPane().add(lblNewLabel);
		
		JLabel lblFirstName = new JLabel("First Name:");
		lblFirstName.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblFirstName.setBounds(27, 48, 76, 23);
		frmPlayer.getContentPane().add(lblFirstName);

		// player first name text field
		txtFName = new JTextField();
		txtFName.setBounds(94, 49, 136, 20);
		frmPlayer.getContentPane().add(txtFName);
		txtFName.setColumns(10);

		JLabel lblLastName = new JLabel("Last Name:");
		lblLastName.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblLastName.setBounds(27, 80, 76, 21);
		frmPlayer.getContentPane().add(lblLastName);

		// player last name text field
		txtLName = new JTextField();
		txtLName.setBounds(94, 80, 136, 20);
		frmPlayer.getContentPane().add(txtLName);
		txtLName.setColumns(10);
		
		btnSubmit = new JButton("Submit");
		btnSubmit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				submit();
			}
		});
		btnSubmit.setBounds(27, 112, 89, 23);
		frmPlayer.getContentPane().add(btnSubmit);
		
		btnClear = new JButton("Clear");
		btnClear.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				clear();
			}
		});
		btnClear.setBounds(140, 112, 89, 23);
		frmPlayer.getContentPane().add(btnClear);
		
		btnClose = new JButton("Close");
		btnClose.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setFrame(frmPlayer);
				closeFrame();
			}
		});
		btnClose.setBounds(82, 146, 89, 23);
		frmPlayer.getContentPane().add(btnClose);
	}

	@Override
	public void submit() {
		// TODO Auto-generated method stub
//		newPlayer.setFName(txtFName.getText());//USED
//		newPlayer.setLName(txtLName.getText());//USED
		newPlayer = new Player(txtFName.getText(), txtLName.getText());
//		System.out.println(newPlayer.getFName());
//		if ((/newPlayer.getFName()!="") && (newPlayer.getLName() != "")){
			DBConnect db = new DBConnect();
		
			String query = "INSERT INTO `player`(`FName`, `LName`) VALUES ('"
				+ newPlayer.getFName() + "', '" + newPlayer.getLName() + "');";
			String ID = "SELECT `playerID` FROM `player` WHERE `FName`='" + newPlayer.getFName() + "' && LName='" +
				newPlayer.getLName() + "';";
			try {
				db.dbConnection();
				db.getStatement().executeUpdate(query);
				ResultSet rs = db.getStatement().executeQuery(ID);
				while (rs.next()){//while there is a result
					newPlayer.setPlayerID(Integer.parseInt(rs.getString("playerID")));
				}
				JOptionPane.showMessageDialog(null, "First Name: " + newPlayer.getFName() + "\nLast Name: " +
				newPlayer.getLName() + "\nPlayer ID: " + newPlayer.getPlayerID());
				clear();
			} catch (ClassNotFoundException | InstantiationException
				| IllegalAccessException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
//		}else if ((newPlayer.getFName()) != ""){
//			JOptionPane.showMessageDialog(frame, "Must enter the player's first name!");
//		}else if ((newPlayer.getLName()) != null){
//			JOptionPane.showMessageDialog(frame, "Must enter the player's last name!");
//		}
		
	}

	

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		txtFName.setText("");
		txtLName.setText("");
	}


}
