import java.util.Scanner;

//Rename file to "Application"

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner scnr = new Scanner(System.in);
		
		Retailers retailers = new Retailers();
		
		System.out.println("Would you like to use the program as a \"manager\" or \"consumer\"?");
		
		String userInput;
		boolean inMenu = true;
		
		Manager manager;
		Consumer consumer;
		
		//user selects which mode the program will run in
		while(inMenu == true)
		{
			userInput = scnr.next();
			userInput = userInput.toLowerCase();
			
			if (userInput.compareTo("manager") == 0)
			{
				System.out.println("Entered program as a manager\n");
				manager = new Manager();
				
				inMenu = false;
			}
			else if (userInput.compareTo("consumer") == 0)
			{
				System.out.println("Entered program as a consumer\n");
				consumer = new Consumer();
				
				inMenu = false;
			}
			
			else
			{
				System.out.println("Please enter either \"manager\" or \"consumer\"");
			}
			
		}
		
	}

}
