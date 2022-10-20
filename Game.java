import java.util.*;
import java.io.InputStreamReader;
import java.io.BufferedReader;

public class Game {
  public static final int ROWS = 0;
public static final int COLS = 0;
public static String banner = "Text-Based Adventure Game!\n"
		+ "Made By: Carlo, Nick, Nguyen\n\n"
		+ "\\_________________/\r\n"
		+ "|       | |       |\r\n"
		+ "|       | |       |\r\n"
		+ "|       | |       |\r\n"
		+ "|_______| |_______|\r\n"
		+ "|_______   _______|\r\n"
		+ "|       | |       |\r\n"
		+ "|       | |       |\r\n"
		+ " \\      | |      /\r\n"
		+ "  \\     | |     /\r\n"
		+ "   \\    | |    /\r\n"
		+ "    \\   | |   /\r\n"
		+ "     \\  | |  /\r\n"
		+ "      \\ | | /\r\n"
		+ "       \\| |/\r\n"
		+ "        \\_/\n";
  public static Player player = null;
  
  public Game(){
    Scene.setScenes();
    player = new Player(Scene.map[2][2]);  
  }
  
  public void run() {
    System.out.println(banner); 
    int status = 0;
    while(status == 0)
      status = player.move();
    switch(status){
      case 1: System.out.println("In an attempt to leave the country, you were shot by an arrow to the knee. You have died of embarrassment"); 
              break;
      case 2: System.out.println("Your body ran out of vitality. Truly unfortunate."); 
              break;
      case 3: System.out.println("Adventurer, by reaching your Maiden's abode you have awakened forces that cannot be explained and have been marked. Watch Out... For now."); 
              break;
      case 4: System.out.println("You have been killed by the enemy, your ancestors is seething with rage."); 
              break;
      case 5: System.out.println("Your cowardice led to untimely death. Be Braver next time.");
              break;
      case 6: System.out.println("By not having the required Item, unknown forces are now watching you. You have died.");
              break;
      default: System.out.println("Your celectial body has been consumed by unknown forces, status: " + status);
    }
    System.out.println("Thank you for playing!");
    System.exit(0);
  }
     
  public static void main(String[] args) {
    Game game = new Game();
    game.run();
  }
   
  public static int inputInt(String prompt){
    int answer = -1;
    String strInt = input(prompt);
    try{
       answer = Integer.parseInt(strInt);
    }
    catch(Exception e ){
      System.out.println("Conversion to int problem: " + e.toString());        
    }
    return answer;
  }
  static InputStreamReader isr = new InputStreamReader(System.in);
  static BufferedReader reader = new BufferedReader(isr);

  public static String input(String prompt){
    int diagnosticCount = 0;
    String answer = "";
    try {
      System.out.print(prompt);
      while(answer.length() == 0){
        diagnosticCount++;  
        answer = reader.readLine();
        diagnosticCount++;  
      }
    }
    catch(Exception e){
      System.out.println("answer: " + answer + ", diagnosticCount: " + diagnosticCount);
      System.out.println("input problem: " + e.toString());
      System.exit(0);
    }
    return answer;
  }
}
