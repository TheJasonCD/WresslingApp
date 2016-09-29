import java.util.Random;

public class GameCharacter {
	
	private double strength, agility, stamina, technique, luck, weight;
	private int health, lust, height, penisSize, ballSize, breastSize, buttSize, hipSize;
	private int attackCore, defenseCore, attackExt, defenseExt, lustStam, lustTop, lustBottom;
	private CharBuild build;
	private CharGender gender;
	private CharSpecies species;
	private String name;
	boolean pinned = false;
	
	public GameCharacter(String nam, CharBuild bld, CharGender gen, CharSpecies spcs, int high, int pSz, int bSz, int brSz) {
		name = nam;
		height = high;
		build = bld;
		gender = gen;
		species = spcs;
		penisSize = pSz;
		ballSize = bSz;
		breastSize = brSz;
		strength = agility = stamina = 3.0;
		attackCore = defenseCore = attackExt = defenseExt = lustStam = lustTop = lustBottom = 0;
		technique = 1.0;
		luck = 1.0;
		setStats(bld);
		setHealth(stamina, weight);
		heightBonus(height);
	}
	
	public GameCharacter(String specialName){
		
	}
	
	private void heightBonus(int charHeight){
		if(height == 84)
			strength += 2;
		else if(height >= 72)
			strength += 1;
		else if(height < 60)
			strength -= 1;
	}
	
	private void setStats(CharBuild bld){
		switch(bld.name()){
		case "SKINNY":
			strength-=2.5;
			stamina+=0.5;
			agility+=1.5;
			luck+=0.5;
			weight = 1.0;
			break;
		case "AVERAGE":
			luck+=0.5;
			weight = 2.5;
			break;
		case "CURVY":
			stamina-=0.5;
			strength+=0.5;
			weight = 3.0;
			break;
		case "LITHE":
			stamina+=0.25;
			luck+=0.25;
			agility+=1.0;
			strength-=1.5;
			weight = 1.5;
			break;
		case "CHUBBY":
			stamina-=1.0;
			agility-=0.5;
			strength+=1.5;
			weight = 4.0;
			break;
		case "FAT":
			stamina-=1.0;
			agility-=1.0;
			strength+=2.0;
			weight = 4.5;
			break;
		case "OBESE":
			stamina-=1.5;
			agility-=1.5;
			strength+=3.0;
			weight = 5.0;
			break;
		case "TONED":
			luck-=0.25;
			agility-=0.25;
			strength+=0.5;
			weight = 3.0;
			break;
		case "MUSCULAR":
			luck-=0.75;
			agility-=0.75;
			strength+=1.5;
			weight = 3.5;
			break;
		case "HERCULEAN":
			luck-=1.5;
			agility-=1.5;
			strength+=3.0;
			weight = 4.5;
			break;
		}
	}
	
	public boolean hasPenis(){
		if(gender.name() == "MALE" || gender.name() == "SHEMALE" || gender.name() == "HERM" || gender.name() == "MALE_HERM")
			return true;
		else
			return false;
	}
	
	public boolean hasBreasts(){
		if(gender.name() == "FEMALE" || gender.name() == "SHEMALE" || gender.name() == "HERM")
			return true;
		else
			return false;
	}
	
	public boolean hasVagina(){
		if(gender.name() == "FEMALE" || gender.name() == "CUNTBOY" || gender.name() == "HERM" || gender.name() == "MALE_HERM")
			return true;
		else
			return false;
	}
	
	public void setHealth(double sta, double wgt){
		health = (int) ((20*wgt)+(5*sta));
	}
	
	public void takeHealthDamage(int damageValue){
		health -= damageValue;
		if(health < 0)
			health = 0;
	}
	
	public void takeLustDamage(int damageValue){
		lust += damageValue;
		if(lust > 100)
			lust = 100;
	}
	
	public int getCurrentHealth(){
		return health;
	}
	
	public int getMaxHealth(){
		return (int) ((20*weight)+(5*stamina));
	}
	
	public int getCurrentLust(){
		return lust;
	}
	
	public int getMaxLust(){
		return lust;
	}
	
	public double getAgility(){
		return agility;
	}
	
	public double getStrength(){
		return strength;
	}
	
	public double getStamina(){
		return stamina;
	}
	
	public double getLuck(){
		return luck;
	}
	
	public int getAttackCore(){
		return attackCore;
	}
	
	public int getDefenseCore(){
		return defenseCore;
	}
	
	public int getAttackExtended(){
		return attackExt;
	}
	
	public int getDefenseExtended(){
		return defenseExt;
	}
	
	public String getName(){
		return name;
	}
}

