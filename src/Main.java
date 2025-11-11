
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Retailers retailers = new Retailers();

		Warehouse ups = new Warehouse("United Postal Service", 10000);
		
		retailers.createRetailer("Brilliant Plungers", 490);
		retailers.createRetailer("Super Chess Boards", 1000);
		retailers.createRetailer("Comfy Chairs USA", 100);
		retailers.createRetailer("Comfy Chairs UK", 100);
		
		retailers.testMonthly(ups);
		
		ups.addVehicle(3000, 60);
		ups.hireDriver("Abdul Patel", 10.0);
		
		ups.shipAll();
		ups.deliverItems();
	}

}
