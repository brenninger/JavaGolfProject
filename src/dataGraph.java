//Graph of the player's scores

import java.awt.*;
import java.awt.geom.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.*;
 
public class dataGraph extends JPanel {
	int x = 0;
	ArrayList<Integer> data = new ArrayList<Integer>(); //Initialize the ArrayList

    final int PAD = 20;
 
    public void countNumberOfScores() {
    	DBConnect connect = new DBConnect();
    	try {
			connect.dbConnection();
			ResultSet rset = connect.getStatement().executeQuery("SELECT * FROM score");
			while (rset.next()) {
					data.add(x, Integer.parseInt(rset.getString("strokes"))); //Add to the ArrayList each score
					x++;
			}
    	}
    		//May have to change this code to something more appropriate
				catch (ClassNotFoundException | InstantiationException
				| IllegalAccessException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    protected void paintComponent(Graphics g) {
    	countNumberOfScores();
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                            RenderingHints.VALUE_ANTIALIAS_ON);
        int w = getWidth();
        int h = getHeight();
        // Draw the y-axis
        g2.draw(new Line2D.Double(PAD, PAD, PAD, h-PAD));
        // Draw the x-axis
        g2.draw(new Line2D.Double(PAD, h-PAD, w-PAD, h-PAD));
        double xInc = (double)(w - 2*PAD)/(data.size()-1);
        double scale = (double)(h - 2*PAD)/getMax();
        // Mark data points.
        g2.setPaint(Color.red);
        for(int i = 0; i < data.size(); i++) {
            double x = PAD + i*xInc;
            double y = h - PAD - scale*data.get(i);
            g2.fill(new Ellipse2D.Double(x-2, y-2, 4, 4));
        }
    }
 
    private int getMax() {
        int max = -Integer.MAX_VALUE;
        for(int i = 0; i < data.size(); i++) {
            if(data.get(i) > max)
                max = data.get(i);
        }
        return max;
    }
 
    public static void main(String[] args) {
        JFrame f = new JFrame();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.add(new dataGraph());
        f.setSize(400,400);
        f.setLocation(200,200);
        f.setVisible(true);
    }
}