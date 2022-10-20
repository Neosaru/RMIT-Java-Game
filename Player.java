import java.util.*;

public class Player {

  ArrayList<Item>inventory;
  int health = 100;
  Scene currentScene = null;
  
  public Player (Scene scene){
    inventory = new ArrayList<Item>();
    this.currentScene = scene;
  }
  
  public void addItem(Item item){
    inventory.add(item);
  }
  
  public boolean checkForItem(Item item){
    return inventory.contains(item);
  }
  
  public int move(){
    int status = 0;
    printMiniMap (currentScene.x, currentScene.y);
    if(health > 0) {
      System.out.println("\n<=-=-=-=-=-=-=-=-=-=-=-=-=-=>");
      System.out.println("<===(Health: " + health + "|100)===> ");
      System.out.println("<====(Inventory: " + inventory + ")====>");
      System.out.println("<=-=-=-=-=-=-=-=-=-=-=-=-=-=>\n");
      int input = Game.inputInt("What path will the Adventure take? (1-4): ");
      switch (input){
          case 1: status = goNorth(status);  break; 
          case 2: status = goEast(status);   break;   
          case 3: status = goSouth(status);  break;   
          case 4: status = goWest(status);   break;   
          default: System.out.println("Bad Direction number: " + input);
      }
    } else {
      status = 2;
    }
    return status;
  }   
      
  private int goNorth(int status){
    int newX = currentScene.x;
    int newY = currentScene.y;
    newY--; 
    if(newY < 0)
      status = 1;
    else
      status = enterScene(status, newX, newY); 
    return status;
  }
  private int goEast(int status){
    int newX = currentScene.x;
    int newY = currentScene.y;
    newX++; 
    if(Scene.COLS > newX)
      status = enterScene(status, newX, newY);
    else
      status = 1;
    return status;
  }
  private int goSouth(int status){
    int newX = currentScene.x;
    int newY = currentScene.y;
    newY++; 
    if(Scene.ROWS > newY)
      status = enterScene(status, newX, newY); 
    else
      status = 1;
    return status;
  }
  private int goWest(int status){
    int newX = currentScene.x;
    int newY = currentScene.y;
    newX--; 
    if(newX < 0)
      status = 1;
    else
      status = enterScene(status, newX, newY);  
    return status;
  }
  
  private int enterScene(int status, int x, int y){
    currentScene = Scene.map[y][x];
    health += 10;
    status = currentScene.enterScene(this);
    return status;
  }
  
  
  void printMiniMap(int x, int y){
    System.out.println(); 
    printRow1(x,y);
    printRow2(x,y);
    printRow3(x,y);
  }
  void printRow1(int x, int y){
	System.out.println("<=---=(NW)=----------------=(N)=------------------=(NE)=---=>");
    printSection("   ", x-1, y-1, 1);
    printSection("<(1)> ", x  , y-1, 1);
    printSection("   ", x+1, y-1, 1);
    System.out.println(); 
    printSection("   ", x-1, y-1, 2);
    printSection("   ", x  , y-1, 2);
    printSection("   ", x+1, y-1, 2);
    System.out.println();

    printSection("   ", x-1, y-1, 3);
    printSection("   ", x  , y-1, 3);
    printSection("   ", x+1, y-1, 3);
    System.out.println("\n");
    System.out.println("<=----=(W)=----------------=(0)=------------------=(E)=----=>");

  }
    
  void printRow2(int x, int y){
    printSection("<(4)>", x-1, y  , 1);
    printSection(" <(*)> ", x  , y  , 1);
    printSection("<(2)> ", x+1, y  , 1);
    System.out.println(); 
    printSection("   ", x-1, y  , 2);
    printSection(" * ", x  , y  , 2);
    printSection("   ", x+1, y  , 2);
    System.out.println(); 
    printSection("   ", x-1, y  , 3);
    printSection(" * ", x  , y  , 3);
    printSection("   ", x+1, y  , 3);
    System.out.println("\n"); 
    System.out.println("<=---=(SW)=----------------=(S)=------------------=(SE)=---=>");
  }
  void printRow3(int x, int y){
    printSection("   ", x-1, y+1, 1);
    printSection("<(3)> ", x  , y+1, 1);
    printSection("   ", x+1, y+1, 1);
    System.out.println(); 
    printSection("   ", x-1, y+1, 2);
    printSection("   ", x  , y+1, 2);
    printSection("   ", x+1, y+1, 2);
    System.out.println(); 
    printSection("   ", x-1, y+1, 3);
    printSection("   ", x  , y+1, 3);
    printSection("   ", x+1, y+1, 3);
    System.out.println("\n"); 
    System.out.println("<=---------------------------------------------------------=>");
  }
  
  void printSection(String prefix, int c, int r, int ln){
    String s = null;
    if (r >= 0 && Scene.ROWS > r &&
        c >= 0 && Scene.COLS > c){
      s = printInsideArea(prefix, r, c, ln);
    } else {
      s = printOutsideArea(prefix, r, c, ln);
    }
    printFixedWidth(s, 20);
  }// end printSection

  String printInsideArea(String prefix, int r, int c, int ln){
    String s = null;
      switch(ln){
        case 1: s = prefix + Scene.map[r][c].title;      break;
        case 2: 
          Item item = Scene.map[r][c].item;
          if(item == null)
            s = "                  ";
          else
            s = prefix + "(" + item.title + ")"; 
          break;
        case 3: 
          Item need = Scene.map[r][c].need;
          if(need == null)
            s = " ";
          else
            s = prefix + "Required: " + need.title; 
          break;
      }
    return s;
  }

  
  String printOutsideArea(String prefix, int r, int c, int ln){
    String s = null;
      switch(ln){
        case 1: s = prefix + "No Mans Land     "; break;
        case 2: s = " "; break;
        case 3: s = " "; break;
      }
    return s;
  }
  
  public void printFixedWidth(String s, int width){
      StringBuilder sb = new StringBuilder();
      sb.append(s);
      while(sb.length() < width)
        sb.append(' ');
      System.out.print(sb.toString());
  }
}