import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner scnr = new Scanner(System.in);
		
		Retailers retailers = new Retailers();
		
		System.out.println("Would you like to use the program as a \"Manager\" or \"Consumer\"?");
		
		String userInput;
		boolean inMenu = true;
		
		Manager manager;
		Consumer consumer;
		
		//user selects which mode the program will run in
		while(inMenu == true)
		{
			userInput = scnr.next();
			
			if (userInput.compareTo("Manager") == 0)
			{
				System.out.println("Entered program as a manager\n");
				manager = new Manager();
				
				inMenu = false;
			}
			else if (userInput.compareTo("Consumer") == 0)
			{
				System.out.println("Entered program as a consumer\n");
				consumer = new Consumer();
				
				inMenu = false;
			}
			
			else
			{
				System.out.println("Please enter either \"Manager\" or \"Consumer\"");
			}
			
		}

		
		
		
		
		
		/*Warehouse ups = new Warehouse("United Postal Service", 10000);
		
		retailers.createRetailer("Brilliant Plungers", 49);
		retailers.createRetailer("Super Chess Boards", 10);
		retailers.createRetailer("Comfy Chairs USA", 1);
		retailers.createRetailer("Comfy Chairs UK", 1);
		
		retailers.testMonthly(ups);
		
		ups.addVehicle(3000, 60);
		ups.hireDriver("Abdul Patel", 10.0);
		
		ups.shipAll();
		ups.deliverItems();
		*/
		
		
	}

}
