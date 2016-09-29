
public enum GameType {
	CAMPAIGN, SANDBOX, TOURNAMENT, TOURNAMENT_SEX, SINGLE_FIGHT, SINGLE_FIGHT_SEX;
	
	public String tellType(){
		return this.name();
	}
}
