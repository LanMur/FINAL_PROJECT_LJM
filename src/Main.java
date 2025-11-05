
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Retailers retailers = new Retailers();

		Warehouse ups = new Warehouse("United Postal Service", 10000);
		
		retailers.createRetailer("Brilliant Plungers", 1);
		retailers.createRetailer("Super Chess Boards", 1);
		retailers.createRetailer("Comfy Chairs USA", 1);
		retailers.createRetailer("Comfy Chairs UK", 1);
		
		retailers.testMonthly(ups);
		
		ups.addVehicle(10000000, 60);
		ups.addVehicle(10000000, 60);
		ups.addVehicle(10000000, 60);

		ups.shipAll();
		
	}

}
