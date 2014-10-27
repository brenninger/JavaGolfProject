import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
//import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
//import java.sql.Statement;


public class enterScore {

	JFrame frmGolfScore;
	private JTextField txtID;
	private JTextField txtStrokes;
	private JTextField txtPar;
	private JButton btnSubmit;
	private JButton btnClear;
	private JButton btnClose;
	static Connection con = null;
//	private static Statement statement;
	private static int playerID;
	private static int strokes;
	private static int par;

	/**Launch the application.*/
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					enterScore window = new enterScore();
					window.frmGolfScore.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**Create the application.*/
	public enterScore() {
		initialize();
	}

	/**Initialize the contents of the frame.*/
	private void initialize() {
		frmGolfScore = new JFrame();
		frmGolfScore.setTitle("Golf - Score");
		frmGolfScore.setBounds(100, 100, 234, 234);
		frmGolfScore.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmGolfScore.getContentPane().setLayout(null);
		
		JLabel lblEnterPlayerScore = new JLabel("Enter Player Score");
		lblEnterPlayerScore.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblEnterPlayerScore.setBounds(21, 11, 175, 31);
		frmGolfScore.getContentPane().add(lblEnterPlayerScore);
		
		JLabel lblPlayerId = new JLabel("Player ID:");
		lblPlayerId.setBounds(45, 42, 65, 22);
		frmGolfScore.getContentPane().add(lblPlayerId);
		
		JLabel lblStrokes = new JLabel("Strokes:");
		lblStrokes.setHorizontalAlignment(SwingConstants.RIGHT);
		lblStrokes.setBounds(51, 70, 48, 22);
		frmGolfScore.getContentPane().add(lblStrokes);
		
		JLabel lblCoursePar = new JLabel("Course Par:");
		lblCoursePar.setBounds(31, 98, 82, 22);
		frmGolfScore.getContentPane().add(lblCoursePar);
		
		//playerID text field
		txtID = new JTextField();
		txtID.setBounds(106, 42, 65, 22);
		frmGolfScore.getContentPane().add(txtID);
		txtID.setColumns(10);
		
		//score text field
		txtStrokes = new JTextField();
		txtStrokes.setBounds(106, 70, 65, 22);
		frmGolfScore.getContentPane().add(txtStrokes);
		txtStrokes.setColumns(10);
		
		//course par text field
		txtPar = new JTextField();
		txtPar.setBounds(106, 98, 65, 22);
		frmGolfScore.getContentPane().add(txtPar);
		txtPar.setColumns(10);
		
		//submit the score to the database
		btnSubmit = new JButton("Submit");
		btnSubmit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				playerID = Integer.parseInt(txtID.getText());
				strokes = Integer.parseInt(txtStrokes.getText());
				par = Integer.parseInt(txtPar.getText());
				
				insert();
			}
		});
		btnSubmit.setBounds(10, 131, 89, 23);
		frmGolfScore.getContentPane().add(btnSubmit);
		
		btnClear = new JButton("Clear");
		btnClear.setBounds(114, 131, 89, 23);
		frmGolfScore.getContentPane().add(btnClear);
		
		btnClose = new JButton("Close");
		btnClose.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
//				System.exit(0);
//				frmGolfScore.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				frmGolfScore.setVisible(false);
			}
		});
		btnClose.setBounds(64, 165, 89, 23);
		frmGolfScore.getContentPane().add(btnClose);
	}
	
	public void insert(){
		dbConnect db = new dbConnect();
		try {
			db.dbConnection();
			ResultSet query = db.getStatement().executeQuery("SELECT `playerID` FROM `player` WHERE `playerID`=" + playerID + ";");
			if (!query.next()){
				System.out.println("empty");
				Component frame = null;
				JOptionPane.showMessageDialog(frame, "Player ID doesn't exist!");
			}else{
//				System.out.println(query.next());
//				System.out.println("not empty");
				String insert = "INSERT into `score` (`playerID`, `strokes`, `par`) VALUES(" + playerID + ", " +
						strokes + ", " + par + ");";
				db.getStatement().executeUpdate(insert);
			}
		} catch (ClassNotFoundException | InstantiationException
				| IllegalAccessException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
