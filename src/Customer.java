
class Customer {
	private String cusDl;
	private String cusName;

	Customer(String cusDl, String cusName) {
		this.cusDl = cusDl;
		this.cusName = cusName;
	}

	public String getCusId() {
		return cusDl;
	}

	public String getCusName() {
		return cusName;
	}
}
