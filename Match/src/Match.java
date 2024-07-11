class Match {
	Team home;
	Team away;
	boolean played;
	int goalsHome;

	int goalsAway;

	public Match(Team h, Team a) {
		this.home = h;
		this.away = a;

	}

	public String toString() {
		String matchDesc = "Heimmannschaft: " + home.name + "Auswärtsmannschaft: " + away.name + "haben gespielt: " + played + "Tore: " + goalsHome + " " + goalsAway;
		return matchDesc;
	}

	public Team winner() {
		if (played && goalsAway != goalsHome) return goalsHome > goalsAway ? home : away;
		return null;
	}
}