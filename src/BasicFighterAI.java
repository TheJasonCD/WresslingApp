import java.util.Random;

public class BasicFighterAI {	
		AttackLocation[] highPlayerHealthAttackLocations = {AttackLocation.CHEST, AttackLocation.STOMACH};
		AttackLocation[] mediumPlayerHealthAttackLocations = {AttackLocation.CHEST, AttackLocation.STOMACH, AttackLocation.LEG, AttackLocation.ARM};
		AttackLocation[] lowPlayerHealthAttackLocations = {AttackLocation.CHEST, AttackLocation.STOMACH, AttackLocation.LEG, AttackLocation.ARM, AttackLocation.HEAD, AttackLocation.FOOT};
		String[] combatMove = new String[10];
		Random rand = new Random();
	
	public String[] opponentAttack(GameCharacter currentOpponent, GameCharacter currentPlayer){
		if(currentOpponent.getStrength() > currentOpponent.getAgility()){
			combatMove[0] = HealthAttackType.PUNCH.name();
			int attackLocation;
			if((currentPlayer.getCurrentHealth()/currentPlayer.getMaxHealth())>=0.85){
				attackLocation = rand.nextInt(2);
				combatMove[1] = highPlayerHealthAttackLocations[attackLocation].name();
				return combatMove;
			}
			else if((currentPlayer.getCurrentHealth()/currentPlayer.getMaxHealth())>0.50){
				attackLocation = rand.nextInt(4);
				combatMove[1] = mediumPlayerHealthAttackLocations[attackLocation].name();	
				return combatMove;		
			}
			else{
				attackLocation = rand.nextInt(5);
				combatMove[1] = lowPlayerHealthAttackLocations[attackLocation].name();
				return combatMove;
			}
		}
		else{
			combatMove[0] = HealthAttackType.KICK.name();
			int attackLocation;
			if((currentPlayer.getCurrentHealth()/currentPlayer.getMaxHealth())>=0.85){
				attackLocation = rand.nextInt(2);
				combatMove[1] = highPlayerHealthAttackLocations[attackLocation].name();
				return combatMove;
			}
			else if((currentPlayer.getCurrentHealth()/currentPlayer.getMaxHealth())>0.50){
				attackLocation = rand.nextInt(4);
				combatMove[1] = mediumPlayerHealthAttackLocations[attackLocation].name();	
				return combatMove;		
			}
			else{
				attackLocation = rand.nextInt(6);
				combatMove[1] = lowPlayerHealthAttackLocations[attackLocation].name();
				return combatMove;
			}
		}
	}
	
	public String opponentDefense(GameCharacter currentOpponent){
		if(currentOpponent.getStrength() > currentOpponent.getAgility())
			return DefenseType.BLOCK.name();
		else
			return DefenseType.DODGE.name();
	}
	
	public AttackLocation opponentAttackLocationChoice(GameCharacter currentOpponent, GameCharacter currentPlayer, HealthAttackType attackChoice){
		int attackLocation;
		if((currentPlayer.getCurrentHealth()/currentPlayer.getMaxHealth())>=0.85){
			attackLocation = rand.nextInt(2);
			return highPlayerHealthAttackLocations[attackLocation];
		}
		else if((currentPlayer.getCurrentHealth()/currentPlayer.getMaxHealth())>0.50){
			attackLocation = rand.nextInt(4);
			return mediumPlayerHealthAttackLocations[attackLocation];			
		}
		else if((currentPlayer.getCurrentHealth()/currentPlayer.getMaxHealth())<=0.50 && attackChoice.name() == "PUNCH"){
			attackLocation = rand.nextInt(5);
			return lowPlayerHealthAttackLocations[attackLocation];		
		}
		else{
			attackLocation = rand.nextInt(6);
			return lowPlayerHealthAttackLocations[attackLocation];		
		}
	}

}
