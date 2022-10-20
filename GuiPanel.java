

import javax.swing.*;
import java.awt.*;

public class GuiPanel extends JPanel{

  Scene scene = null; // what the panel is connected to
  JLabel title = null; // title of scene
  JLabel needs = null; // name of treasure required
  JLabel treasure = null; // name of treasure
   JLabel comment = null; //comment
   
   public GuiPanel(Scene scene) {
     this.scene = scene; 
     title = new JLabel(scene.title);
     Font font1 = title.getFont();
     Font font2 = new Font(font1.getName(), Font.BOLD, 20);
     title.setFont(font2);
     add(title);
   } 
   
   
   
  public static void setFonts(){
    JComponent btnReset = null;
    Font font1 = btnReset.getFont();
    Font font2 = new Font(font1.getName(), Font.BOLD, 40);
    JComponent jtf1 = null;
	jtf1.setFont(font2);
    JComponent jtf2 = null;
	jtf2.setFont(font2);
    JComponent btnTemp = null;
	btnTemp.setFont(font2);
    btnReset.setFont(font2);
  }

}
