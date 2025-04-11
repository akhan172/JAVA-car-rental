
class Customer {
	private String cusId;
	private String cusName;

	Customer(String cusId, String cusName) {
		this.cusId = cusId;
		this.cusName = cusName;
	}

	public String getCusId() {
		return cusId;
	}

	public String getCusName() {
		return cusName;
	}
}
