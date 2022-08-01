
public class Deal {

	private int ID;
	private String name;
	private String sellEmail;
	private String buyEmail;
	private double price;
	private String closeDate;
	
	public Deal(int iD, String name, String sellEmail, String buyEmail, double price, String closeDate) {
		this.ID = iD;
		this.name = name;
		this.sellEmail = sellEmail;
		this.buyEmail = buyEmail;
		this.price = price;
		this.closeDate = closeDate;
	}

	public int getID() {
		return ID;
	}

	public String getName() {
		return name;
	}

	public String getSellEmail() {
		return sellEmail;
	}

	public String getBuyEmail() {
		return buyEmail;
	}

	public double getPrice() {
		return price;
	}

	public String getCloseDate() {
		return closeDate;
	}
	
}
