
public class Item {
	private String name;
	private String description;
	private double minBidPrice;
	private String auctionStart;
	private String endDate;
	private double bidIncrement;
	
	public Item(String name, String description, double minBidPrice, String auctionStart, String endDate,
			double bidIncrement) {
		this.name = name;
		this.description = description;
		this.minBidPrice = minBidPrice;
		this.auctionStart = auctionStart;
		this.endDate = endDate;
		this.bidIncrement = bidIncrement;
	}

	public String getName() {
		return name;
	}


	public String getDescription() {
		return description;
	}


	public double getMinBidPrice() {
		return minBidPrice;
	}


	public String getAuctionStart() {
		return auctionStart;
	}


	public String getEndDate() {
		return endDate;
	}


	public double getBidIncrement() {
		return bidIncrement;
	}


	public void setName(String name) {
		this.name = name;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setMinBidPrice(double minBidPrice) {
		this.minBidPrice = minBidPrice;
	}

	public void setAuctionStart(String auctionStart) {
		this.auctionStart = auctionStart;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public void setBidIncrement(double bidIncrement) {
		this.bidIncrement = bidIncrement;
	}

}
