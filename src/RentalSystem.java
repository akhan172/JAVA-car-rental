import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

class RentalSystem {
	private List<Car> cars;
	private List<Customer> customers;
	private List<Rental> rentals;
	
	RentalSystem(){
		cars = new ArrayList<>();
		customers = new ArrayList<>();
		rentals = new ArrayList<>();
			
	}

	public void addCar(Car car) {
		cars.add(car);
	}
	
	public void addCustomer(Customer cus) {
		customers.add(cus);
	}
	
	public void rentCar(Car car, Customer cus, int days) {
		if(car.isAvailable()) {
			car.rent();
			rentals.add(new Rental(car, cus, days));
		}else {
			System.out.println("Selected Car is Not Available");
		}
	}
	
	public void returnCar(Car car) {
		car.returnCar();
		Rental rentalToRemove = null;
		for(Rental rental:rentals) {
			if(rental.getCar() == car) {
				rentalToRemove=rental;
				break;
			}
			if(rentalToRemove != null) {
				rentals.remove(rentalToRemove);
			}
			else {
				System.out.println("Car was not rented");
			}
		}
		
		
	}
	
	public void menu() {
		Scanner sc = new Scanner(System.in);
		while(true) {
			System.out.println("========== CAR RENTAL SYSTEM ==========");
			System.out.println("1. Rent a car");
			System.out.println("2. Return a car");
			System.out.println("3. Exit");
			System.out.println("Enter your choice");
			
			int choice = sc.nextInt();
			sc.nextLine();
			
			if(choice == 1) {
				System.out.println("========== Rent a car ==========");
				System.out.print("Enter the name of renter");
				String name = sc.nextLine();
				
				System.out.println("\nAvailable Cars\n");
				for(Car car: cars) {
					if(car.isAvailable()) {
						System.out.println(car.getCarId()+" - "+car.getBrand()+" - "+car.getModel());
					}
				}
				System.out.print("Enter the Car Id you want to rent");
				int carId=sc.nextInt();
				System.out.println("Enter the number of days to rent");
				int rentday=sc.nextInt();
				sc.nextLine();
				System.out.println("Enter the Customer ID");
				String cusId=sc.nextLine();
				
				Customer newCustomer = new Customer(cusId, name);
				addCustomer(newCustomer);
				
				Car selectedCar=null;
				for(Car car:cars) {
					if(car.getCarId()==carId && car.isAvailable()) {
						selectedCar=car;
						break;
					}
				}
				if(selectedCar != null) {
					double price=selectedCar.getPrice(rentday);
					System.out.println("\n===== Rental Informaion =====\n");
					System.out.println("Customer ID = "+ newCustomer.getCusId());
					System.out.println("Customer Name = "+ newCustomer.getCusName());
					System.out.println("Car :-"+ selectedCar.getModel()+" Brand "+ selectedCar.getBrand());
					System.out.println("Rent Days "+ rentday);
					System.out.printf(" Total price is $%.2f%n", price);
					System.out.println("\n=================================\n");
					System.out.println("Enter Y to confirm");
					String confirm=sc.nextLine();
					if(confirm.equals("Y")) {
						rentCar(selectedCar, newCustomer, rentday);
						
					}else {
						System.out.println("Car rental cancelled");
					}
				}else {
					System.out.println("Invalid input or car is not available");
				}	
			}else if(choice == 2) {
				System.out.println("====== Return the car");
				System.out.println("Enter the car Id you want to return");
				int carId=sc.nextInt();
				
				Car returnCar=null;
				for(Car car:cars) {
					if(car.getCarId()==carId) {
						returnCar=car;
						break;
					}
				}
				if(returnCar != null) {
					Customer cust=null;
					for(Rental rental:rentals) {
						if(rental.getCar() == returnCar) {
							cust=rental.getCus();
							break;
						}
					}
					if(cust!=null) {
						returnCar(returnCar);
						System.out.println("Car returned sucessfully");
					}else {
						System.out.println("Missing rental information");
					}
				}else {
					System.out.println("Invalid input, Enter the correct output");
				}
				
			}else if(choice == 3) {
				break;
			}else {
				System.out.println("Invalid input, recheck your input");
			}
		}
	}
	
}
