import java.util.ArrayList;

public class PlayerCharacter extends GameCharacter {
	private int money, fame;
	ArrayList<HealthAttackType> specials = new ArrayList<HealthAttackType>(){{}};;

	public PlayerCharacter(String nam, CharBuild bld, CharGender gen, CharSpecies spcs, int high, int pSz, int bSz,
			int brSz) {
		super(nam, bld, gen, spcs, high, pSz, bSz, brSz);
	}
	
	public PlayerCharacter(String nam){
		super(nam);
	}
	
	public void setPlayerMoney(int money_amount){
		money = money_amount;
	}
	
	public void setPlayerFame(int fame_amount){
		fame = fame_amount;
	}
	
	public int getPlayerMoney(){
		return money;
	}
	
	public int getPlayerFame(){
		return fame;
	}

}
