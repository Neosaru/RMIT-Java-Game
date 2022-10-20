public class Item {
	
  public String title = null; // name of item
 
  public Item (String title){ // coordinates of the scene (x,y)
    this.title = title;
  }
  
  @Override
  public String toString(){
    return title;  
  }

   
}
