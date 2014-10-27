public abstract class player {
	int playerID;
	String FName;
	String LName;
	int pRank;
	int handicap;
//	String[] p;
	
	public player() {
		// TODO Auto-generated constructor stub
		
	}
	
	public abstract void handicap();

	public int getPlayerID(){
//		System.out.println(playerID);
		return playerID;
	}
	
	void setPlayerID(int newplayerID){
		playerID = newplayerID;
		System.out.println(playerID);
	}
	
	public String getFName(){
		return FName;
	}
	
	void setFName(String newFName){
		FName = newFName;
	}
	
	public String getLName(){
		return LName;
	}
	
	void setLName(String newLName){
		LName = newLName;
	}
	
	public int getRank(){
		return pRank;
	}
	
	void setRank(int newPRank){
		pRank = newPRank;
	}
	
	public int getHandicap(){
		return handicap;
	}
	
	void setHandicap(int newHandicap){
		handicap = newHandicap;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
