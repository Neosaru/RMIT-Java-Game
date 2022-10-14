
public class Player {
	private int HP;
	private int maxHp;
	private int atk;
	
	public Player() {
		HP = maxHp;
		atk = 1;
	}
	
	//=-----------------------=//
	public boolean isAlive() {
		return HP > 0;
	}
	
	public int getHp() {
		return HP;
	}
	
	public void setHp(int hp) {
		HP = hp;
	}
	
	public int getAtk() {
		return atk;
	}
	
	public void setAtk(int Atk) {
		atk = Atk;
	}
	
}
