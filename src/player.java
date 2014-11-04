public class Player {
	int playerID;
	String FName;
	String LName;
	int pRank;
	int handicap;
//	String[] p;
	
	public Player() {
		// TODO Auto-generated constructor stub
		
	}
	
//	public abstract void handicap();

	
	
	public int getPlayerID() {
		return playerID;
	}

	public void setPlayerID(int playerID) {
		this.playerID = playerID;
	}

	public String getFName() {
		return FName;
	}

	public void setFName(String fName) {
		FName = fName;
	}

	public String getLName() {
		return LName;
	}

	public void setLName(String lName) {
		LName = lName;
	}

	public int getpRank() {
		return pRank;
	}

	public void setpRank(int pRank) {
		this.pRank = pRank;
	}

	public int getHandicap() {
		return handicap;
	}

	public void setHandicap(int handicap) {
		this.handicap = handicap;
	}

}
