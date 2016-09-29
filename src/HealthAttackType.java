public enum HealthAttackType {
	PUNCH, KICK;
	
	public String tellType(){
		return this.name();
	}
	
	public String[] listNames(){
		String[] nameList = {"PUNCH", "KICK"};
		return nameList;
	}
}
