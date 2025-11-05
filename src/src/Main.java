import Box;
import OnlineRetailer;
import Retailers;
import Warehouses;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Retailers retailers = new Retailers();

		Warehouse ups = new Warehouse("United Postal Service", 10000);
		
		retailers.createRetailer("Brilliant Plungers", 4);
		retailers.createRetailer("Super Chess Boards", 4);
		retailers.createRetailer("Comfy Chairs USA", 2);
		
		retailers.testMonthly(ups);
		
		ups.printInventory();
		
	}

}
