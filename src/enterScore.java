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


public class EnterScore extends Buttons{

	JFrame frmGolfScore;
	private JTextField txtID;
	private JTextField txtStrokes;
	
	private JButton btnSubmit;
	private JButton btnClear;
	private JButton btnClose;
	private JTextField txtRate;
	private JTextField txtSlope;
	static Connection con = null;
//	private static Statement statement;
	private static int playerID;
	private static int strokes;
	private static double courseRate;
	private static int slope;
	private static double differential;
	validate valid = new validate();
	

	/**Launch the application.*/
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EnterScore window = new EnterScore();
					window.frmGolfScore.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**Create the application.*/
	public EnterScore() {
		initialize();
	}

	/**Initialize the contents of the frame.*/
	private void initialize() {
		frmGolfScore = new JFrame();
		frmGolfScore.setTitle("Golf - Score");
		frmGolfScore.setBounds(100, 100, 234, 262);
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
		
		JLabel lblCourseRating = new JLabel("Course Rating:");
		lblCourseRating.setBounds(17, 98, 83, 22);
		frmGolfScore.getContentPane().add(lblCourseRating);
		
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
		
		//submit the score to the database
		btnSubmit = new JButton("Submit");
		btnSubmit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				submit();
				
			}
		});
		btnSubmit.setBounds(10, 153, 89, 23);
		frmGolfScore.getContentPane().add(btnSubmit);
		
		btnClear = new JButton("Clear");
		btnClear.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				clear();
			}
		});
		btnClear.setBounds(114, 153, 89, 23);
		frmGolfScore.getContentPane().add(btnClear);
		
		btnClose = new JButton("Close");
		btnClose.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setFrame(frmGolfScore);
				closeFrame();
			}
		});
		btnClose.setBounds(64, 187, 89, 23);
		frmGolfScore.getContentPane().add(btnClose);
		
		txtRate = new JTextField();
		txtRate.setBounds(106, 99, 65, 20);
		frmGolfScore.getContentPane().add(txtRate);
		txtRate.setColumns(10);
		
		JLabel lblSlope = new JLabel("Slope:");
		lblSlope.setBounds(64, 128, 46, 14);
		frmGolfScore.getContentPane().add(lblSlope);
		
		txtSlope = new JTextField();
		txtSlope.setBounds(106, 125, 65, 20);
		frmGolfScore.getContentPane().add(txtSlope);
		txtSlope.setColumns(10);
		
		
	}
	

	@Override
	public void submit() {
		if(txtStrokes.getText().trim().isEmpty() || txtRate.getText().trim().isEmpty() || txtSlope.getText().trim().isEmpty() || txtID.getText().trim().isEmpty())
		{
			valid.error = true;
			valid.errors += "You must enter a value for all areas. \n";
			valid.checkErrors();
			return;
		}
		
		if(!valid.isType(txtStrokes.getText(), "int"))
		{
			valid.error = true;
			valid.errors += "Your strokes must be a whole number. \n";
			valid.checkErrors();
			return;
		}
		
		if(!valid.isType(txtRate.getText(), "int"))
		{
			valid.error = true;
			valid.errors += "Your course Rating must be a whole number. \n";
			valid.checkErrors();
			return;
		}
		
		if(!valid.isType(txtSlope.getText(), "int"))
		{
			valid.error = true;
			valid.errors += "Your slope must be a whole number. \n";
			valid.checkErrors();
			System.out.println("AAAA" + txtSlope.getText() + "PPPP");
			return;
		}
		
		
		
		playerID = Integer.parseInt(txtID.getText());
		strokes = Integer.parseInt(txtStrokes.getText());
		courseRate = Double.parseDouble(txtRate.getText());
		
		if(courseRate < 67 || courseRate > 77)
		{
			valid.error = true;
			valid.errors += "Your course rating must be between 67 and 77. \n";
			valid.checkErrors();
			return;
		}
		slope = Integer.parseInt(txtSlope.getText());
		
		if(slope < 55 || slope > 155)
		{
			valid.error = true;
			valid.errors += "Your slope must be between 55 and 155. \n";
			valid.checkErrors();
			return;
		}
		calcHandicap calc = new calcHandicap(strokes, courseRate, slope);
		System.out.println(calc);
		
		
		DBConnect db = new DBConnect();
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
				String insert = "INSERT into `score` (`playerID`, `strokes`, `courseRate`, `slope`, `differential`) VALUES(" + playerID + ", " +
						strokes + ", " + courseRate + ", " + slope + ", " + calc +");";
				db.getStatement().executeUpdate(insert);
			}
		} catch (ClassNotFoundException | InstantiationException
				| IllegalAccessException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void clear() {
		txtID.setText("");
		txtStrokes.setText("");
		txtRate.setText("");
		txtSlope.setText("");
		
	}
	
}
