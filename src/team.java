public class Team {
	int teamID;
	String teamName;
	int player1;
	int player2;
	int player3;
	int player4;
	int tRank;

	/**
	 * @param teamID
	 * @param teamName
	 * @param player1
	 * @param player2
	 * @param player3
	 * @param player4
	 * @param tRank
	 */
	public Team(String teamName, int player1, int player2,
			int player3, int player4) {
		super();
//		this.teamID = teamID;
		this.teamName = teamName;
		this.player1 = player1;
		this.player2 = player2;
		this.player3 = player3;
		this.player4 = player4;
//		this.tRank = tRank;
	}

	/**
 * 
 */
	public Team() {
		super();
	}

	// public abstract void tRank();

	public int getTeamID() {
		return teamID;
	}

	public void setTeamID(int teamID) {
		this.teamID = teamID;
	}

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	public int getPlayer1() {
		return player1;
	}

	public void setPlayer1(int player1) {
		this.player1 = player1;
	}

	public int getPlayer2() {
		return player2;
	}

	public void setPlayer2(int player2) {
		this.player2 = player2;
	}

	public int getPlayer3() {
		return player3;
	}

	public void setPlayer3(int player3) {
		this.player3 = player3;
	}

	public int getPlayer4() {
		return player4;
	}

	public void setPlayer4(int player4) {
		this.player4 = player4;
	}

//	public int gettRank() {
//		return tRank;
//	}
//
//	public void settRank(int tRank) {
//		this.tRank = tRank;
//	}

}
