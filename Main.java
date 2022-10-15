import java.util.*;

// --------------------------------------- Main
public class Main {

	public static void main(String[] args) {
		String username;
		Scanner sc = new Scanner(System.in);
		//=------=setup
		
		Message("Welcome to the Game World!\n");
		Shield();
		Message("\nWhat is thy name Adventurer?");
		
		username = sc.nextLine();
		while(username.length() > 25) {
			username = "";
			Message("Username must be maximum of 25 characters long!");
			Message("Please try again");
			
			username = sc.nextLine();
		}
		
		if(username.length() <= 25) {
			Message("Welcome " + username + "!");
		}
		
		
		
	}
	
	//=----------------------------------------=//
	
	// This makes it that you don't have to type out System.out.println()
	//so just type in Message()
	//string only
	 static void Message(String s) {
		System.out.println(s);
	}
	
	 
	static void Shield() {
		Message("\\_________________/\r\n"
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
				+ "        \\_/");
	}
	//=--------------------------------------=//
	
}
// --------------------------------------- Main
