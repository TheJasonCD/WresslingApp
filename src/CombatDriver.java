import java.util.Random;
import java.util.HashMap;
import java.util.Map;

public class CombatDriver {
	GameCharacter player, enemy;
	public GameCharacter[] roundOrder;
	String[] hitAttributes = {"AGILITY","STRENGTH"};
	String[] attacks = {"PUNCH*","KICK"};
	String[] defenses = {"BLOCK*","DODGE"};
	public String[]hitLocations = {"CHEST","ARM","LEG","STOMACH","HEAD","FEET"};
	public int[] baseHitPercentages = {75,60,60,80,50,40};
	Map<String, Integer> baseHitTable = new HashMap<String, Integer>();
	Map<String, String> hitAttributeTable = new HashMap<String, String>();
	public int roundCounter;

	public CombatDriver(PlayerCharacter newPlayer, GameCharacter newOpponent) {
		player = newPlayer;
		enemy = newOpponent;
		roundOrder = new GameCharacter[2];
		roundCounter = 1;
		for(int i = 0; i < hitLocations.length; i++)
			baseHitTable.put(hitLocations[i], baseHitPercentages[i]);
		for(int i = 0; i < attacks.length; i++){
			if (attacks[i].contains("*"))
				hitAttributeTable.put(attacks[i].replace("*", ""), hitAttributes[1]);
			else
				hitAttributeTable.put(attacks[i], hitAttributes[0]);
		}
	}	
	
	public int getRound(){
		return roundCounter;
	}

	public double characterAttack(AttackLocation loc, HealthAttackType atk){
		if (hitAttributeTable.get(atk.name()) == "AGILITY"){
			if (loc.name().contains("CHEST") || loc.name().contains("STOMACH"))
				if((baseHitTable.get(loc.name()) + (player.getAgility()*10)/2 + (player.getAttackCore()*.2)%10) > 95)
					return 95;
				else
					return (baseHitTable.get(loc.name()) + (player.getAgility()*10)/2 + (player.getAttackCore()*.2)%10);
			else
				if((baseHitTable.get(loc.name()) + (player.getAgility()*10)/2 + (player.getAttackExtended()*.2)%10) > 95)
					return 95;
				else
					return (baseHitTable.get(loc.name()) + (player.getAgility()*10)/2 + (player.getAttackExtended()*.2)%10);				
		}
		else{
			if (loc.name().contains("CHEST") || loc.name().contains("STOMACH"))
				if((baseHitTable.get(loc.name()) + (player.getAgility()*10)/2 + (player.getAttackCore()*.2)%10) > 95)
					return 95;
				else
					return (baseHitTable.get(loc.name()) + (player.getAgility()*10)/2 + (player.getAttackCore()*.2)%10);
			else
				if((baseHitTable.get(loc.name()) + (player.getAgility()*10)/2 + (player.getAttackExtended()*.2)%10) > 95)
					return 95;
				else
					return (baseHitTable.get(loc.name()) + (player.getAgility()*10)/2 + (player.getAttackExtended()*.2)%10);					
		}
	}
	
	public int characterDefense(DefenseType def)
	
	public int healthAttackDamage(GameCharacter attacker, HealthAttackType attackType){
		int damageValue = 0;
		Random randRoll = new Random();
		switch(attackType.name()){
		case "PUNCH":
			if(randRoll.nextInt(100)+1<=(attacker.getLuck()*1))
				damageValue = (int) (5*(attacker.getStrength()/2))+((randRoll.nextInt((int) (attacker.getLuck() + attacker.getAgility())/3)+1)*3);
			else
				damageValue = (int) (5*(attacker.getStrength()/2));
		case "KICK":
			if(randRoll.nextInt(100)+1<=(attacker.getLuck()*1))
				damageValue = (int) (7*(attacker.getAgility()/2))+((randRoll.nextInt((int) (attacker.getLuck() + attacker.getAgility())/3)+1)*3);
			else
				damageValue = (int) (7*(attacker.getAgility()/2));
		}
		return damageValue;
	}

}
