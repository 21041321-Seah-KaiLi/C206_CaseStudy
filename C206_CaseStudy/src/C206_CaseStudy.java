import java.util.ArrayList;

public class C206_CaseStudy {

	private static final int OPTION_VIEW = 1;
	private static final int OPTION_ADD = 2;
	private static final int OPTION_DELETE = 3;
	private static final int OPTION_QUIT = 4;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<User> userList = new ArrayList<User>();
		ArrayList<Category> catList = new ArrayList<Category>();
		ArrayList<Item> itemList = new ArrayList<Item>();
		ArrayList<Bid> bidList = new ArrayList<Bid>();
		ArrayList<Deal> dealList = new ArrayList<Deal>();
		
		userList.add(new User("Tester", "Admin", "tester@gmail.com", "ezpswrd"));
		catList.add(new Category("Books"));
		itemList.add(new Item("book1","textbook",0.1,"01/01/22","31/12/22",0.5));
		bidList.add(new Bid(1,"Test","sell@gmail.com","buy@gmail.com",5.0));
		dealList.add(new Deal(1, "toy", "test@gmail.com", "test2@gmail.com", 0.0, "August 1st 2022"));
		
		int option = 0;
		
		while (option != OPTION_QUIT) {
			C206_CaseStudy.menu();
			option = Helper.readInt("Enter option > ");
			if(option == OPTION_VIEW) {
				C206_CaseStudy.setHeader("VIEW");
				objMenu();
				
				int choice = Helper.readInt("Enter option to select object > ");
				
				if(choice == 1) {
					C206_CaseStudy.viewAllUser(userList);
				}
				else if (choice == 2) {
					C206_CaseStudy.viewAllCategory(catList);
				}
				else if (choice == 3) {
					C206_CaseStudy.viewAllItem(itemList);
				}
				else if (choice == 4) {
					C206_CaseStudy.viewAllBid(bidList);
				}
				else if (choice == 5) {
					C206_CaseStudy.viewAllDeal(dealList);
				}
			}
			else if(option == OPTION_ADD) {
				C206_CaseStudy.setHeader("ADD");
				objMenu();
				
				int choice = Helper.readInt("Enter option to select object > ");
				
				if(choice == 1) {
					User newUser = inputUser();
					C206_CaseStudy.addUser(userList, newUser);
					System.out.println("User added");
				}
				else if (choice == 2) {
					Category newCat = inputCat();
					C206_CaseStudy.addCategory(catList, newCat);
					System.out.println("Category added");
				}
				else if (choice == 3) {
					Item newItem = inputItem();
					C206_CaseStudy.addItem(itemList, newItem);
					System.out.println("Item added");
				}
				else if (choice == 4) {
					Bid newBid = inputBid();
					C206_CaseStudy.addBid(bidList, newBid);
					System.out.println("Bid added");
				}
				else if (choice == 5) {
					Deal newDeal = inputDeal();
					C206_CaseStudy.addDeal(dealList, newDeal);
					System.out.println("Deal added");
				}
			}
			else if(option == OPTION_DELETE) {
				C206_CaseStudy.setHeader("DELETE");
				objMenu();
				
				int choice = Helper.readInt("Enter option to select object > ");
				
				if(choice == 1) {
					removeUser(userList);
				}
				else if (choice == 2) {
					removeCategory(catList);
				}
				else if (choice == 3) {
					removeItem(itemList);
				}
				else if (choice == 4) {
					removeBid(bidList);
				}
				else if (choice == 5) {
					removeDeal(dealList);
				}
			}
			else if(option == OPTION_QUIT) {
				System.out.println("Bye!");
			}
			else {
				System.out.println("Invalid option");
			}
		}
	}
	public static void menu() {
		C206_CaseStudy.setHeader("Campus Online Auction Shop");
		System.out.println("1. View");
		System.out.println("2. Add");
		System.out.println("3. Delete");
		System.out.println("4. Quit");
		Helper.line(80, "-");
	}
	public static void setHeader(String header) {
		Helper.line(80, "-");
		System.out.println(header);
		Helper.line(80, "-");
	}
	public static void objMenu() {
		C206_CaseStudy.setHeader("OBJECT LIST");
		System.out.println("1. User");
		System.out.println("2. Category");
		System.out.println("3. Item");
		System.out.println("4. Bid");
		System.out.println("5. Deal");
	}
	
	public static String retrieveAllUser(ArrayList<User> userList) {
		String output = "";
		
		for(int i = 0; i < userList.size(); i++) {
			output += String.format("%-25s %-25s %-25s %-25s\n", userList.get(i).getName()
					, userList.get(i).getRole(), userList.get(i).getEmail(), userList.get(i).getPassword());
		}
		return output;
	}
	
	public static String retrieveAllCategory(ArrayList<Category> catList) {
		String output = "";
		
		for(int i = 0; i < catList.size(); i++) {
			output += String.format("%-25s\n", catList.get(i).getName());
		}
		return output;
	}
	
	public static String retrieveAllItem(ArrayList<Item> itemList) {
		String output = "";
		
		for(int i = 0; i < itemList.size(); i++) {
			output += String.format("%-25s %-25s %-25.2f %-25s %-25s %-25.2f\n", itemList.get(i).getName(), 
					itemList.get(i).getDescription(), itemList.get(i).getMinBidPrice(), itemList.get(i).getAuctionStart(),
					itemList.get(i).getEndDate(), itemList.get(i).getBidIncrement());
		}
		return output;
	}
	
	public static String retrieveAllBid(ArrayList<Bid> bidList) {
		String output = "";
		
		for(int i = 0; i < bidList.size(); i++) {
			output += String.format("%-25d %-25s %-25s %-25s %-25.2f\n", bidList.get(i).getId(),
					bidList.get(i).getName(), bidList.get(i).getSellEmail(), bidList.get(i).getBuyEmail(),
					bidList.get(i).getBidPrice());
		}
		return output;
	}
	
	public static String retrieveAllDeal(ArrayList<Deal> dealList) {
		String output = "";
		
		for(int i = 0; i < dealList.size(); i++) {
			output += String.format("%-25d %-25s %-25s %-25s %-25.2f %-25s\n", dealList.get(i).getID(),
					dealList.get(i).getName(), dealList.get(i).getSellEmail(), dealList.get(i).getBuyEmail(),
					dealList.get(i).getPrice(), dealList.get(i).getCloseDate());
		}
		return output;
	}
	
	public static void viewAllUser(ArrayList<User> userList) {
		String output = String.format("%-25s %-25s %-25s %-25s\n", "Name", "Role", "Email","Password");
		output += retrieveAllUser(userList);
		System.out.println(output);
	}
	
	public static void viewAllCategory(ArrayList<Category> catList) {
		String output = String.format("%-25s\n", "Name");
		output += retrieveAllCategory(catList);
		System.out.println(output);
	}
	
	public static void viewAllItem(ArrayList<Item> itemList) {
		String output = String.format("%-25s %-25s %-25s %-25s %-25s %-25s\n", "Name", "Description", "MinBid","Start", "End", "Increment");
		output += retrieveAllItem(itemList);
		System.out.println(output);
	}
	
	public static void viewAllBid(ArrayList<Bid> bidList) {
		String output = String.format("%-25s %-25s %-25s %-25s %-25s\n", "ID", "Name", "Seller","Buyer", "Price");
		output += retrieveAllBid(bidList);
		System.out.println(output);
	}
	
	public static void viewAllDeal(ArrayList<Deal> dealList) {
		String output = String.format("%-25s %-25s %-25s %-25s %-25s %-25s\n", "ID", "Name", "Seller","Buyer", "Price", "Close");
		output += retrieveAllDeal(dealList);
		System.out.println(output);
	}
	
	public static User inputUser() {
		
		String username = Helper.readString("Enter name : ");
		String userrole = Helper.readString("Enter role : ");
		String useremail = Helper.readString("Enter email : ");
		String userpassword = Helper.readString("Enter password : ");
		
		User newuser = new User(username, userrole, useremail, userpassword);
		return newuser;
	}
	
	public static Category inputCat() {
		
		String name = Helper.readString("Enter name : ");
		
		Category newCat = new Category(name);
		return newCat;
	}

	public static Item inputItem() {
	
		String name = Helper.readString("Enter name : ");
		String desc = Helper.readString("Enter description : ");
		double minBid = Helper.readDouble("Enter minBid : ");
		String Start = Helper.readString("Enter start : ");
		String End = Helper.readString("Enter end date : ");
		double Increment = Helper.readDouble("Enter increment : ");
	
		Item newItem = new Item(name, desc, minBid, Start, End, Increment);
		return newItem;
	}

	public static Bid inputBid() {
	
		int id = Helper.readInt("Enter ID : ");
		String name = Helper.readString("Enter name : ");
		String sellEmail = Helper.readString("Enter seller email : ");
		String buyEmail = Helper.readString("Enter buyer email : ");
		double bidPrice = Helper.readDouble("Enter bid price : ");
	
		Bid newBid = new Bid(id, name, sellEmail, buyEmail, bidPrice);
		return newBid;
	}

	public static Deal inputDeal() {
	
		int id = Helper.readInt("Enter ID : ");
		String name = Helper.readString("Enter name : ");
		String sellEmail = Helper.readString("Enter seller email : ");
		String buyEmail = Helper.readString("Enter buyer email : ");
		double bidPrice = Helper.readDouble("Enter bid price : ");
		String close = Helper.readString("Enter close date : ");
	
		Deal newDeal = new Deal(id, name, sellEmail, buyEmail, bidPrice, close);
		return newDeal;
	}

	public static void addUser(ArrayList<User> userList, User newUser) {
		userList.add(newUser);
	}
	
	public static void addCategory(ArrayList<Category> catList, Category newCat) {
		catList.add(newCat);
	}
	
	public static void addItem(ArrayList<Item> itemList, Item newItem) {
		itemList.add(newItem);
	}
	
	public static void addBid(ArrayList<Bid> bidList, Bid newBid) {
		bidList.add(newBid);
	}
	
	public static void addDeal(ArrayList<Deal> dealList, Deal newDeal) {
		dealList.add(newDeal);
	}

	public static void removeUser(ArrayList<User> userList) {
		
		String userName = Helper.readString("Enter name : ");
		for (int i = 0; i < userList.size(); i++) {
			if (userList.get(i).getName().equalsIgnoreCase(userName)) {
				userList.remove(i);
				System.out.println("User Removed");
			}
		}
	}
	
	public static void removeCategory(ArrayList<Category> catList) {
		
		String catName = Helper.readString("Enter Category : ");
		for (int i = 0; i < catList.size(); i++) {
			if (catList.get(i).getName().equalsIgnoreCase(catName)) {
				catList.remove(i);
				System.out.println("Category Removed");
			}
		}
	}

	public static void removeItem(ArrayList<Item> itemList) {
		
		String itemName = Helper.readString("Enter item name : ");
		for (int i = 0; i < itemList.size(); i++) {
			if (itemList.get(i).getName().equalsIgnoreCase(itemName)) {
				itemList.remove(i);
				System.out.println("Item Removed");
			}
		}
	}
	
	public static void removeBid(ArrayList<Bid> bidList) {
		
		int bidID = Helper.readInt("Enter bid ID : ");
		for (int i = 0; i < bidList.size(); i++) {
			if (bidList.get(i).getId() == bidID) {
				bidList.remove(i);
				System.out.println("Bid Removed");
			}
		}
	}
	
	public static void removeDeal(ArrayList<Deal> dealList) {
		
		int dealID = Helper.readInt("Enter deal ID : ");
		for (int i = 0; i < dealList.size(); i++) {
			if (dealList.get(i).getID() == dealID) {
				dealList.remove(i);
				System.out.println("Deal Removed");
			}
		}
	}
}
