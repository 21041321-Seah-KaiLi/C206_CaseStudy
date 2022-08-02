
public class Bid {
	private int id;
	private String name;
	private String sellEmail;
	private String buyEmail;
	private double bidPrice;
	
	public Bid(int id, String name, String sellEmail, String buyEmail, double bidPrice) {
		this.id = id;
		this.name = name;
		this.sellEmail = sellEmail;
		this.buyEmail = buyEmail;
		this.bidPrice = bidPrice;
	}

	public int getId() {
		return id;
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

	public double getBidPrice() {
		return bidPrice;
	}
}
