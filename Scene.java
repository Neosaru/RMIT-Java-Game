import javax.swing.*;

public class Scene {

  Action action = null;  //scene action
  String title = null;	// scene title
  Item item = null;	// scene's item
  Item need = null;	// scene's required item
  String announcement = null; // scene announcement

  public int x = 0,
             y = 0; // scene x,y coordinates
  
public GuiPanel guiPanel;

  public Scene (String title, int action){// title and action of the scene
    this.title = title;
    this.action = new Action(action, this);
  }
  public Scene (int row, int col, String title, String ann, 
               int action, Item item, Item need){
    this(title, action);
    this.announcement = ann;
    this.y = row;
    this.x = col;
    this.item = item;
    this.need = need;
    map[row][col] = this;
  }
 
  public void setAnnouncement(String announcement){ // setting the announcements of the scene
    this.announcement = announcement;
  }

  public void setCoordinates(int x, int y){ // setting the coordinates of the scene
    this.x = x;
    this.y = y;
  }
  
  public int enterScene(Player player){
    int status = 0;
    boolean ok = true;
    if(null != announcement) 
      System.out.println("\n" + announcement);
    if(null != need)
        ok = player.checkForItem(need);
    if(ok)
      status = action.doAction(player);
    else
      status = 6;
    return status;
  }
  
  public void setItem(Item item){
    this.item = item;
  }
  
  public boolean checkForItem(Item item){
    return this.item == item;
  }
  
  public void setNeed(Item item){
    this.need = item;
  }
  
  public boolean checkForNeed(Item item){
    return this.need == item;
  }
  
  public String toString(){
    return title;  
  }

  public static void setScenes(){ // setting the scenes
	  
    Item torch        = new Item("Torch");
    Item Bleach       = new Item("Bleach");
    Item sword       = new Item("Sword");
    Item Honey_Badger        = new Item("Honey Badger");
    Item Street_Pharmacist      = new Item("Street Pharmacist");

    String strCamp = "'the fire is fresh' you use the campfire to craft a torch and run away quickly.";
    new Scene (0, 0, "Campfire",strCamp, Action.PICKUP_ACTION, torch, null);
    
    String strCPath  = "An ordinary path that may change your life";    
    new Scene (0, 1, "Cobblestone Path",strCPath, Action.NO_ACTION, null, null);

    String strDungeon = "You have reached a Dungeon, the sign says 'Waffle House'. You shrug and enter anyway.";
    new Scene (0, 2, "Dark Dungeon",strDungeon, Action.NO_ACTION, null, torch);

    String strStreetPharmacist = "A suspiscious individual appears in front of you, he wants you to buy his skooma. You refuse to buy.";
    new Scene (0, 3, "Dark Dungeon",strStreetPharmacist, Action.FIGHT_ACTION, Street_Pharmacist, sword);

    String strHouse = "It seems that your Maiden is home alone, but something does not feel right.";
    new Scene (0, 4, "Maiden's House",strHouse, Action.WIN_ACTION, null, null);

    String strGRoads = "Walking barefoot on the gravel somehow hurts your feet.";
    new Scene (1, 1, "Gravel Roads",strGRoads, Action.NO_ACTION, null, null);

    String strRiver = "An uncanny stench enters your nose. You must cleanse the water first to pass the river.";
    new Scene (1, 2, "Contaminated River",strRiver, Action.NO_ACTION, null, Bleach);

    String strTavern = "'Strange things happen in this Taven' The Old Man looks at you longingly. You felt something.";
    new Scene (2, 2, "Strange Tavern",strTavern, Action.NO_ACTION, null, null);

    String strRoads = "While walking in the country road, you encounter a Honeybadger.";
    new Scene (2, 3, "Country Road",strRoads, Action.FIGHT_ACTION, Honey_Badger, null);
   
    String strTomb = "You approach an old tomb. Inside you see a sword stuck in a stone. You break the stone with a pickaxe. Something is wrong.";
    new Scene (3, 3, "Ancient Tomb",strTomb, Action.PICKUP_ACTION, sword, null);

    String strOldShack = "An old shack, some sort of storage for cleaning equipment. You take the perfectly preserved Bleach in the corner of the shack.";
    new Scene (4, 2, "Ol' Shack",strOldShack, Action.PICKUP_ACTION, Bleach, null);

    String strCrevasse = "You enter a tight crevasse. You feel a strong wind on the end of the crevasse.";
    new Scene (4, 3, "Crevasse",strCrevasse, Action.NO_ACTION, null, null);

    String strRange = "A metal wall is blocking you from passing. It seems that people on the other side wants to be here than there. You should turn back.";
    new Scene (4, 4, "Mountain Range",strRange, Action.DEADEND_ACTION, null, null);

    for(int y = 0; y < ROWS; y++)
      for(int x = 0; x < COLS; x++)
        if(map[y][x] == null){
           String str = "You have been shot by an arrow";
           new Scene(y, x, "Off Limits", str, Action.DEADEND_ACTION, null, null);
        }
    
  }
 
  public static final int ROWS = 5,
                          COLS = 5; // setting game dimension

  public static Scene[][] map = new Scene[ROWS][COLS];

}
