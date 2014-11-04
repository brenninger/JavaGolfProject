import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import javax.swing.JButton;
import javax.swing.JFrame;

public class Menu{

	private JFrame frmGolfMain;
	static Connection con = null;

	/**Launch the application.*/
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu window = new Menu();
					window.frmGolfMain.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**Create the application.*/
	public Menu() {
		initialize();
	}

	/**Initialize the contents of the frame.*/
	private void initialize() {
		frmGolfMain = new JFrame();
		frmGolfMain.setTitle("Golf - Main Menu");
		frmGolfMain.setBounds(100, 100, 264, 153);
		frmGolfMain.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmGolfMain.getContentPane().setLayout(null);

		JButton btnCreateTeam = new JButton("Create Team");

		btnCreateTeam.setBounds(10, 75, 117, 23);
		frmGolfMain.getContentPane().add(btnCreateTeam);
		btnCreateTeam.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CreateTeam createTeam = new CreateTeam();
				createTeam.frmTeam.setVisible(true);
			}
		});

		JButton btnPlayer = new JButton("Player Data");
		btnPlayer.setToolTipText("");
		btnPlayer.addActionListener(new ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent displayPlayer) {
//				showPlayerData();
				Data d = new Data();
				d.showPlayerData();
			}
		});
		btnPlayer.setBounds(137, 11, 100, 23);
		frmGolfMain.getContentPane().add(btnPlayer);

		JButton btnTeam = new JButton("Team Data");
		btnTeam.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Data d = new Data();
				d.showTeamData();
			}
		});
		btnTeam.setBounds(137, 45, 100, 23);
		frmGolfMain.getContentPane().add(btnTeam);

		JButton btnEnter = new JButton("Enter Score");
		btnEnter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EnterScore score = new EnterScore();
				score.frmGolfScore.setVisible(true);
			}
		});
		btnEnter.setBounds(10, 11, 117, 23);
		frmGolfMain.getContentPane().add(btnEnter);

		JButton btnClose = new JButton("Close");
		btnClose.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
//				 frmGolfMain.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				System.exit(0);
				
			}
		});
		btnClose.setBounds(137, 75, 100, 23);
		frmGolfMain.getContentPane().add(btnClose);
		
		JButton btnCreatePlayer = new JButton("Create Player");
		btnCreatePlayer.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				CreatePlayer createPlayer = new CreatePlayer();
				createPlayer.frmPlayer.setVisible(true);
			}
		});
		btnCreatePlayer.setBounds(10, 45, 117, 23);
		frmGolfMain.getContentPane().add(btnCreatePlayer);
	}
	
}
