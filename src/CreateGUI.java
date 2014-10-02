// Josh Haugen CSC 3610 Student Information Application
// 9-9-14
// Creates GUI to enter student info to mySQL database

import java.awt.*;

import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class CreateGUI extends Frame
{
    public CreateGUI(String app) {
    	super(app);
    	setup();
    	show(); //Shows GUI
    }
    
   private void setup() {

	  setSize(600, 500);
	  setLocationRelativeTo(null);
	  setBackground(Color.GREEN);

      Panel info    = new Panel();   // panel for the text and labels
      info.setLayout(null);
      
      Button saveTeam = new Button("Save Team Information"); info.add(saveTeam); saveTeam.setBounds(5, 350, 160, 35); saveTeam.setFont(new Font("Arial", Font.BOLD, 13));
      Button display = new Button("Display");
      Button clearTeam  = new Button("Clear Team Information"); info.add(clearTeam); clearTeam.setBounds(5, 400, 160, 35); clearTeam.setFont(new Font("Arial", Font.BOLD, 13));
      Button quit   = new Button("Quit");
      
      Label	title1 = new Label("Team Information"); title1.setBounds(5,0,250,50); title1.setFont(new Font("Arial", Font.BOLD, 24)); info.add(title1);      
      Label	teamName = new Label("Team Name "); teamName.setBounds(5,50,250,25); teamName.setFont(new Font("Arial", Font.BOLD, 15)); info.add(teamName);
      Label	teamPlayers = new Label("Team Players"); teamPlayers.setBounds(5,125,250,25); teamPlayers.setFont(new Font("Arial", Font.BOLD, 15)); info.add(teamPlayers);
      Label	teamPlayer1 = new Label("Player 1: "); teamPlayer1.setBounds(5,150,65,25); teamPlayer1.setFont(new Font("Arial", Font.PLAIN, 14)); info.add(teamPlayer1);
      Label	teamPlayer2 = new Label("Player 2: "); teamPlayer2.setBounds(5,175,65,25); teamPlayer2.setFont(new Font("Arial", Font.PLAIN, 14)); info.add(teamPlayer2);
      Label	teamPlayer3 = new Label("Player 3: "); teamPlayer3.setBounds(5,200,65,25); teamPlayer3.setFont(new Font("Arial", Font.PLAIN, 14)); info.add(teamPlayer3);
      Label	teamPlayer4 = new Label("Player 4: "); teamPlayer4.setBounds(5,225,65,25); teamPlayer4.setFont(new Font("Arial", Font.PLAIN, 14)); info.add(teamPlayer4);
      Label	teamSR = new Label("Team Scoring Rank"); teamSR.setBounds(5,275,250,25); teamSR.setFont(new Font("Arial", Font.BOLD, 15)); info.add(teamSR);     
      
      final TextField	teamTextfield = new TextField(); teamTextfield.setBounds(5,80,195,23); info.add(teamTextfield);
      final TextField	player1Textfield = new TextField(); player1Textfield.setBounds(75,150,125,23); info.add(player1Textfield);
      final TextField	player2Textfield = new TextField(); player2Textfield.setBounds(75,175,125,23); info.add(player2Textfield);
      final TextField	player3Textfield = new TextField(); player3Textfield.setBounds(75,200,125,23); info.add(player3Textfield);
      final TextField	player4Textfield = new TextField(); player4Textfield.setBounds(75,225,125,23); info.add(player4Textfield);
      final TextField	teamSRTextfield = new TextField(); teamSRTextfield.setBounds(5,305,50,23); info.add(teamSRTextfield);
      
      Label title2 = new Label("Player Information"); title2.setBounds(300,0,250,50); title2.setFont(new Font("Arial", Font.BOLD, 24)); info.add(title2); 
      Label	firstName = new Label("First Name: "); firstName.setBounds(300,50,90,25); firstName.setFont(new Font("Arial", Font.BOLD, 15)); info.add(firstName);
      Label	lastName = new Label("Last Name: "); lastName.setBounds(300,80,90,25); lastName.setFont(new Font("Arial", Font.BOLD, 15)); info.add(lastName);
      Label	handicap = new Label("Handicap: "); handicap.setBounds(300,110,90,25); handicap.setFont(new Font("Arial", Font.BOLD, 15)); info.add(handicap);
      Label	lgScore = new Label("Score Last Game: "); lgScore.setBounds(300,140,140,25); lgScore.setFont(new Font("Arial", Font.BOLD, 15)); info.add(lgScore);
      Label	teamRank = new Label("Rank On Team: "); teamRank.setBounds(300,170,125,25); teamRank.setFont(new Font("Arial", Font.BOLD, 15)); info.add(teamRank);
      
      final TextField	firstNameTextfield = new TextField(); firstNameTextfield.setBounds(450,50,100,23); info.add(firstNameTextfield);
      final TextField	lastNameTextfield = new TextField(); lastNameTextfield.setBounds(450,80,100,23); info.add(lastNameTextfield);
      final TextField	handicapTextfield = new TextField(); handicapTextfield.setBounds(450,110,50,23); info.add(handicapTextfield);
      final TextField	scoreTextfield = new TextField(); scoreTextfield.setBounds(450,140,50,23); info.add(scoreTextfield);
      final TextField	rankTextfield = new TextField(); rankTextfield.setBounds(450,170,50,23); info.add(rankTextfield);   

      setLayout(new BorderLayout());       // methods of the frame   
      add(info);
      
      saveTeam.addActionListener(new java.awt.event.ActionListener() {
          public void actionPerformed(java.awt.event.ActionEvent saveTeam) {

          }
      });
      
      display.addActionListener(new java.awt.event.ActionListener() {
          public void actionPerformed(java.awt.event.ActionEvent display) {
          }
      });
      
      clearTeam.addActionListener(new java.awt.event.ActionListener() {
          public void actionPerformed(java.awt.event.ActionEvent clear) {
        	  teamTextfield.setText(""); player1Textfield.setText(""); player2Textfield.setText(""); player3Textfield.setText(""); player4Textfield.setText(""); 
        	  teamSRTextfield.setText("");
          }
      });
      
      quit.addActionListener(new java.awt.event.ActionListener() {
          public void actionPerformed(java.awt.event.ActionEvent quit) {
       	   System.exit(0);
          }
      });

      addWindowListener(new WindowAdapter() {
	         public void windowClosing(WindowEvent windowEvent){
		        System.exit(0);
	         }
	      });     
   }  
}