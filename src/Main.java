
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RentalSystem carRentalSys = new RentalSystem();
		 	Car car1 = new Car(001, "Toyota", "Camry", 60.0); // Different base price per day for each car
	        Car car2 = new Car(002, "Honda", "Accord", 70.0);
	        Car car3 = new Car(003, "Mahindra", "Thar", 150.0);
	        carRentalSys.addCar(car1);
	        carRentalSys.addCar(car2);
	        carRentalSys.addCar(car3);
	        carRentalSys.menu();
	}

}
