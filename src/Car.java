class Car {
	private int carId;
	private String model;
	private String brand;
	private double price;
	private boolean available;
	
	Car(int id, String model, String brand, double price){
		this.carId=id;
		this.model=model;
		this.brand=brand;
		this.price=price;
		this.available=true;
	}

	public int getCarId() {
		return carId;
	}

	public String getModel() {
		return model;
	}

	public String getBrand() {
		return brand;
	}

	public double getPrice(int rentDays) {
		return price*rentDays;
	}

	public boolean isAvailable() {
		return available;
	}
 
	public void rent() {
		available=false;
	}
	public void returnCar() {
		available=true;
	}
}
