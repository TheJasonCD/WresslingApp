public enum AttackLocation {
	HEAD, CHEST, STOMACH, LEG, ARM, FOOT;
	
	public String tellType(){
		return this.name();
	}
	
	public String[] listNames(){
		String[] nameList = {"HEAD", "CHEST", "STOMACH", "LEG", "ARM", "FOOT"};
		return nameList;
	}
}
