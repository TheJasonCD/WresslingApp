public enum DefenseType {
	BLOCK, DODGE, TUMBLE, PARRY, FEIGN;
	
	public String tellType(){
		return this.name();
	}
	
	public String[] listNames(){
		String[] nameList = {"BLOCK", "DODGE", "TUMBLE", "PARRY", "FEIGN"};
		return nameList;
	}
}
