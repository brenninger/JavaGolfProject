import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnect {
	Connection con = null;
	Statement statement;
	public DBConnect() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public Statement getStatement(){
		return statement;
	}
//	void setStatement(Statement newStatement){
//		statement = newStatement;
//	}
	void dbConnection() throws ClassNotFoundException, SQLException,
			InstantiationException, IllegalAccessException {
		// Connection con = null;
		Class.forName("com.mysql.jdbc.Driver").newInstance();

		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/golf",
				"user", "pass");
		statement = con.createStatement();
	}

}
