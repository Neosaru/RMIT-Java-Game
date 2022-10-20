public class Fight {

  Player player = null; //access to players health
  String npc = null; // Non-Playable Character

  public Fight(Player player, String npc){
    this.player = player;
    this.npc = npc;
  } 
  
  public int run() {
    int status = 0;
    String answer = null;
    char c = 'n';
    if(player.currentScene.item == null)
      player.health += 10;
    else {
      answer = Game.input("Do you wish to fight the " + npc + "? (n/y):");
      c = Character.toLowerCase(answer.charAt(0));
      if(c == 'n')
        status = 5;
      else
        status = doFight();
    }
    return status;
  }


  public int doFight() {
    int status = 0;
    int npcHealth = 80;
    double factor = 30.;
    while(player.health > 0 && npcHealth > 0){
      System.out.println("Your health: " + player.health + 
                   ", " + npc + " health: " + npcHealth);
      npcHealth -= 1 + (int)(factor * (Math.random()));
      player.health -= 1 + (int)(factor * (Math.random()));
    }
    System.out.println("Your health: " + player.health + 
                  ", " + npc + " health: " + npcHealth);
    if(npcHealth <= 0){
      System.out.println("Congratulations, you killed the " + npc);
      player.currentScene.item = null;
    }else{
      status = 4;
    }
    return status;
  }
}
