
public abstract class team {
	Integer teamID;
	String teamName;
	Integer player1;
	Integer player2;
	Integer player3;
	Integer player4;
	Integer tRank;
	
	public team() {
		// TODO Auto-generated constructor stub
	}
	
	public abstract void tRank();

	public Integer getTeamID(){
		return teamID;
	}
	
	void setTeamID(Integer newTeamID){
		teamID = newTeamID;
	}
	
	public String getTeamName(){
		return teamName;
	}
	
	void setTeamName(String newTeamName){
		teamName = newTeamName;
	}
	
	public Integer getPlayer1(){
		return player1;
	}
	
	void setPlayer1(Integer newPlayer1){
		player1 = newPlayer1;
	}
	
	public Integer getPlayer2(){
		return player2;
	}
	
	void setPlayer2(Integer newPlayer2){
		player2 = newPlayer2;
	}
	
	public Integer getPlayer3(){
		return player3;
	}
	
	void setPlayer3(Integer  newPlayer3){
		player3 = newPlayer3;
	}
	
	public Integer getPlayer4(){
		return player4;
	}
	
	void setPlayer4(Integer newPlayer4){
		player4 = newPlayer4;
	}
	
	public Integer getTRank(){
		return tRank;
	}
	
	void setRank(Integer newTRank){
		tRank = newTRank;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
