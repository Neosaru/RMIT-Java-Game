public class items {
	private String weapon;
	private int dmg;
  private String HPotion;
  private int heal;
	private String treasure;
	
	//set method
	public void setWeapon(String i) {
		weapon = i;
  }
  public void setDmg(int i) {
		dmg = i;
  } 
  public void setPotionName(String i) {
		HPotion = i;
  } 
  public void setHeal(int i) {
		heal = i;
  }
  public void setTreasure(String i) {
		treasure = i;
  }
  
  
	//get method
	public String getWeapon() {
		return weapon;
  } 
   public int getDmg() {
		return dmg;
	}
  public String getPotionName() {
		return HPotion;
	}
  public int getHeal() {
		return heal;
	}
  public String getTreasure() {
    return treasure;
  }
}
