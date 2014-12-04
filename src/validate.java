import javax.swing.JOptionPane;


public class validate {
	String player;
	String team;
	String errors = "";
	boolean error = false;
	
	
	public Boolean isType(String testStr, String type) 
	{
		try {
			if (type.equalsIgnoreCase("float")) {
				Float.parseFloat(testStr);
			} else if (type.equalsIgnoreCase("int")) {
				Integer.parseInt(testStr);
			} else if (type.equalsIgnoreCase("double")) {
				Double.parseDouble(testStr);
			}
			return true;
		} catch(Exception e) {
			return false;
		}
 
	}
	public void checkErrors()
	{
		if (error = true)
		{
			JOptionPane.showMessageDialog(null, errors);
			errors = "";
		}
	}
}

