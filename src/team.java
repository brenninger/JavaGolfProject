
public abstract class team {
	int teamID;
	String teamName;
	int player1;
	int player2;
	int player3;
	int player4;
	int tRank;
	
	public team() {
		// TODO Auto-generated constructor stub
	}
	
	public abstract void tRank();

	public int getTeamID(){
		return teamID;
	}
	
	void setTeamID(int newTeamID){
		teamID = newTeamID;
	}
	
	public String getTeamName(){
		return teamName;
	}
	
	void setTeamName(String newTeamName){
		teamName = newTeamName;
	}
	
	public int getPlayer1(){
		return player1;
	}
	
	void setPlayer1(int newPlayer1){
		player1 = newPlayer1;
	}
	
	public int getPlayer2(){
		return player2;
	}
	
	void setPlayer2(int newPlayer2){
		player2 = newPlayer2;
	}
	
	public int getPlayer3(){
		return player3;
	}
	
	void setPlayer3(int newPlayer3){
		player3 = newPlayer3;
	}
	
	public int getPlayer4(){
		return player4;
	}
	
	void setPlayer4(int newPlayer4){
		player4 = newPlayer4;
	}
	
	public int getTRank(){
		return tRank;
	}
	
	void setRank(int newTRank){
		tRank = newTRank;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
