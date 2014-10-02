import java.awt.*;
import java.awt.event.*;
import java.sql.*;

import javax.swing.*;

public class DisplayDB extends Frame
{
	private static Statement stmt; 
	static Connection con = null;
	
    public DisplayDB(String app) {
    	super(app);
    	setup();
    	show(); //Shows GUI
    }
    
   private void setup() {
			
			setSize(400, 150);
			setLocationRelativeTo(null);
			setBackground(Color.GREEN);
			
			Panel info    = new Panel();   // panel for the text and labels
		    info.setLayout(null);
			
			Button displayTeam = new Button("Display Team Information"); info.add(displayTeam); displayTeam.setBounds(10, 65, 160, 35); displayTeam.setFont(new Font("Arial", Font.BOLD, 12));
		    Button displayPlayer = new Button("Display Player Information"); info.add(displayPlayer); displayPlayer.setBounds(215, 65, 160, 35); displayPlayer.setFont(new Font("Arial", Font.BOLD, 12));

		    setLayout(new BorderLayout());       // methods of the frame   
		    add(info);     // methods of the frame   

		    displayTeam.addActionListener(new java.awt.event.ActionListener() {
		          public void actionPerformed(java.awt.event.ActionEvent displayTeam) {

		  			try {
		  				Class.forName("com.mysql.jdbc.Driver").newInstance();
		  				
		  				con = DriverManager.getConnection("jdbc:mysql://localhost:3306/CSC3610_Connection","localhost", "");
		  					
		  				stmt = con.createStatement();
		  				ResultSet rset = stmt.executeQuery("SELECT * FROM csc3610_connection.mapweights");
		  				
		  				dispose();
		  				
		  				while (rset.next()) {
		  					JOptionPane.showMessageDialog(null, rset.getString("e0_1"));
		  				}
		  				
		  			} catch(SQLException e) {
		  				e.printStackTrace();
		  				
		  			}
		  			catch(Exception e) {
		  				JOptionPane.showMessageDialog(null, e.getMessage());
		  			} finally {
		  				try {
		  					if(con != null)
		  						con.close();
		  				} catch(SQLException e) {}
		  			}
		          }
		      });
		    displayPlayer.addActionListener(new java.awt.event.ActionListener() {
		          public void actionPerformed(java.awt.event.ActionEvent displayPlayer) {

		  			try {
		  				Class.forName("com.mysql.jdbc.Driver").newInstance();
		  				
		  				con = DriverManager.getConnection("jdbc:mysql://localhost:3306/CSC3610_Connection","localhost", "");
		  					
		  				stmt = con.createStatement();
		  				ResultSet rset = stmt.executeQuery("SELECT * FROM csc3610_connection.mapweights");
		  				
		  				dispose();
		  				
		  				while (rset.next()) {
		  					JOptionPane.showMessageDialog(null, rset.getString("e0_1"));
		  				}
		  				
		  			} catch(SQLException e) {
		  				e.printStackTrace();
		  				
		  			}
		  			catch(Exception e) {
		  				JOptionPane.showMessageDialog(null, e.getMessage());
		  			} finally {
		  				try {
		  					if(con != null)
		  						con.close();
		  				} catch(SQLException e) {}
		  			}
		        	  dispose();
		          }
		      });
		    addWindowListener(new WindowAdapter() {
		         public void windowClosing(WindowEvent windowEvent){
			        dispose();
		         }
		      }); 
		   }     
}