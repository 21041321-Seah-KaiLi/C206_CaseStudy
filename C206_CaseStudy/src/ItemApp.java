import java.util.ArrayList;

public class ItemApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Item> itemList = new ArrayList<Item>();
		
		itemList.add(new Item("AirPods", "The latest version", 250.00, "2022-04-22", "2022-11-24", 40.00));
		itemList.add(new Item("Powerbank", "The capacity is 3000mAh", 20.00, "2022-05-12", "2022-12-17", 5.00));
		itemList.add(new Item("Apple Watch", "The latest version", 400.00, "2022-08-22", "2022-10-24", 20.00));
	
		int option = 3;
		
		
		while (option != 5) {
			
			ItemApp.menu();
			option = Helper.readInt("Enter an option : ");
			
			if (option == 1) {
				Item newItem = inputItem();
				ItemApp.addItem(itemList, newItem);
				System.out.println("Item added");
				
			} else if (option == 2) {
				ItemApp.viewAllItem(itemList);
			} else if (option == 3) {
				removeItem(itemList);
				boolean remove = true;
				if (remove = true) {
					System.out.println("Item removed");
				} else {
					System.out.println("Fail removed");
				}
			}
		}
	}
	public static void menu() {
		Helper.line(80, "=");
		System.out.println("Item App Management");
		System.out.println("1. Add item");
		System.out.println("2. View item");
		System.out.println("3. Delete item");
		Helper.line(80, "=");
		}
		
	public static Item inputItem() {
		String name = Helper.readString("Enter item name > ");
		String description = Helper.readString("Enter description > ");
		double minBidPrice = Helper.readInt("Enter minimum bid price > ");
		String startDate = Helper.readString("Enter auction start date > ");
		String endDate = Helper.readString("Enter auction end date > ");
		double bidIncrement = Helper.readDouble("Enter bid increment > ");

		Item im = new Item(name, description, minBidPrice, startDate, endDate, bidIncrement);
		return im;
		}
	
	public static void addItem(ArrayList<Item> itemList, Item im) {
		itemList.add(im);
		}
		
	public static String retrieveAllItem(ArrayList<Item> itemList) {
		String output = "";

		for (int i = 0; i < itemList.size(); i++) {
			output += String.format("%-20s %-30s %-20s %-20s %-20s %-20s\n", itemList.get(i).getName(), itemList.get(i).getDescription(),
					itemList.get(i).getMinBidPrice(), itemList.get(i).getAuctionStart(), itemList.get(i).getEndDate(), itemList.get(i).getBidIncrement());
			}
		return output;
		}

	public static void viewAllItem(ArrayList<Item> itemList) {
		String output = String.format("%-20s %-30s %-20s %-20s %-20s %-20s\n", "NAME", "DESCRIPTION",
				"MIN BID PRICE", "START DATE","END DATE", "BID INCREMENT");
		output += retrieveAllItem(itemList);
		System.out.println(output);
		}
		
		
	public static void removeItem(ArrayList<Item> itemList) {
		String name = Helper.readString("Enter item name > ");
		
		for (int i = 0; i < itemList.size(); i++) {
			if (itemList.get(i).getName().equals(name)) {
				itemList.remove(i);
				}
			}
		}
	}
