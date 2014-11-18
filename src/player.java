public class Player {
	int playerID;
	String FName;
	String LName;
	int pRank;
	int handicap;

	/**
	 * @param playerID
	 * @param fName
	 * @param lName
	 * @param pRank
	 * @param handicap
	 */
//	public Player(int playerID, String fName, String lName, int pRank,
//			int handicap) {
//		super();
//		this.playerID = playerID;
//		FName = fName;
//		LName = lName;
//		this.pRank = pRank;
//		this.handicap = handicap;
//	}
	public Player(String fName, String lName) {
		super();
		FName = fName;
		LName = lName;
	}

	// String[] p;

	// public abstract void handicap();

	/**
 * 
 */
	public Player() {
		super();
	}

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
