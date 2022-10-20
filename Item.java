public class Item {
	
  public String title = null;
 
  public Item (String title){
    this.title = title;
  }
  
  @Override
  public String toString(){
    return title;  
  }

   
}
