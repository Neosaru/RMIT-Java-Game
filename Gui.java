import javax.swing.*;
import java.awt.*;  
import javax.swing.event.*;
import java.awt.event.*;  
// added text field

public class Gui extends JFrame{
  public GuiPanel[][] panels = 
     new GuiPanel[Game.ROWS][Game.COLS]; 


  public Gui(Scene[][] map){
    super(Game.banner);
    setUpWindow(map);
    GuiPanel.setFonts();
  }

private void setUpWindow(Scene[][] map) {
    setLayout(new GridLayout(Game.ROWS,Game.COLS));
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setSize(1300,800);
 
    GuiPanel gp = null;
    for(int r = 0; r < Game.ROWS; r++)
      for(int c = 0; c < Game.COLS; c++){
        Scene s = map[r][c];
        gp = new GuiPanel(s);
        s.guiPanel = gp;
        panels[r][c] = (GuiPanel)gp;
        add(gp);
      }
    setVisible(true);
  }

 
}