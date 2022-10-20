public class Action {
  public static final int NO_ACTION      = 1;
  public static final int PICKUP_ACTION  = 2;
  public static final int DEADEND_ACTION = 3;
  public static final int FIGHT_ACTION   = 4;
  public static final int WIN_ACTION     = 5;

  /*
   * 1) Will do nothing
   * 2) Will add or subtract points from the item
   * 3) dead-end meaning player can only go back
   * 4) fight with non-playable character
   * 5) displays win to player
   */
  
   private int action = 0;
   //associated scene
   Scene scene = null;

  public Action(int action, Scene scene) {
    this.action = action;
    this.scene  = scene;
  } // carries out "action" on entry to scene

  public int doAction(Player player) {
    int status = 0;
    switch(action) {
        case NO_ACTION:      status = doNoAction(player);    break;
        case PICKUP_ACTION:  status = doPickup(player);      break;
        case DEADEND_ACTION: status = doDeadEnd(player);     break;
        case FIGHT_ACTION:   status = doFight(player);       break;
        case WIN_ACTION:     status = doWin(player);         break;
        default:
            System.out.println("Action " + action + " Error");
    } 
    return status;  
  }
  
  private int doPickup(Player player){
    //System.out.println("Diagnostic doPickup -todo");
    Item item = scene.item;
    scene.item = null;
    if(item != null){
       player.addItem(item);
       player.health+=20;
    }
    return 0;
  
  }
  
  private int doDeadEnd(Player player){
     //System.out.println("diagnostic doDeadEnd");
     player.health -= 20;
    return 0;
      
      
  }
  
  private int doFight(Player player){
    //System.out.println("diagnostic doFight");
    int status = 0;
    Fight fight = null;
    Item item = scene.item;//enemy
    if(item != null){
      fight = new Fight(player, item.title);
      status = fight.run();
    }
    return status;
  }


  private int doWin(Player player){
    return 3;
  }
    
  private int doNoAction(Player player){
	 //System.out.println("diagnostic doNoAction-todo")
     player.health+=10;     
     return 0;
  }
}
