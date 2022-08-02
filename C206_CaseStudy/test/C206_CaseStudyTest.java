import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class C206_CaseStudyTest {
	private User u1;
	private User u2;
	private Category c1;
	private Category c2;
	private Item i1;
	private Item i2;
	private Bid b1;
	private Bid b2;
	private Deal d1;
	private Deal d2;	
	
	private ArrayList<User> userList;
	private ArrayList<Category> catList;
	private ArrayList<Item> itemList;
	private ArrayList<Bid> bidList;
	private ArrayList<Deal> dealList;
	
	public C206_CaseStudyTest() {
		super();
	}
	@Before
	public void setUp() throws Exception {
		u1 = new User("Tester", "Admin", "tester@gmail.com", "ezpswrd");
		u2 = new User("Tester2", "Admin2", "tester2@gmail.com", "ezpswrd2");
		c1 = new Category("Books");
		c2 = new Category("Files");
		i1 = new Item("book1","textbook",0.1,"01/01/22","31/12/22",0.5);
		i2 = new Item("book2","textbook",0.1,"01/01/22","31/12/22",0.5);
		b1 = new Bid(1,"Test","sell@gmail.com","buy@gmail.com",5.0);
		b1 = new Bid(1,"Test2","sell2@gmail.com","buy2@gmail.com",5.0);
		d1 = new Deal(1, "toy", "test@gmail.com", "test2@gmail.com", 0.0, "August 1st 2022");
		d2 = new Deal(1, "toy2", "test3@gmail.com", "test4@gmail.com", 0.0, "August 1st 2022");
		
		userList = new ArrayList<User>();
		catList = new ArrayList<Category>();
		itemList = new ArrayList<Item>();
		bidList = new ArrayList<Bid>();
		dealList = new ArrayList<Deal>();
	}

	@Test
	public void testRetrieveAllUser() {
		//Test if user list is not null but empty -boundary
		assertNotNull("Test that there is valid userList to view",userList);
				
		//Test if the list of users retrieved from the CaseStudy is empty - boundary
		String allUsers = C206_CaseStudy.retrieveAllUser(userList);
		String testOutput = "";
		assertEquals("Check that ViewAllUserlist", testOutput, allUsers);
				
		//Given an empty list, after adding 2 items, test if the size of the list is 2 - normal
		C206_CaseStudy.addUser(userList, u1);
		C206_CaseStudy.addUser(userList, u2);
		assertEquals("Test that userList arraylist size is 2?", 2, userList.size());
		
		//Test if the expected output string same as the list of users retrieved from the case study	
		allUsers= C206_CaseStudy.retrieveAllUser(userList);
		testOutput = String.format("%-25s %-25s %-25s %-25s\n","Tester", "Admin", "tester@gmail.com", "ezpswrd");
		testOutput += String.format("%-25s %-25s %-25s %-25s\n","Tester2", "Admin2", "tester2@gmail.com", "ezpswrd2");
			
		assertEquals("Test that viewAllUserlist", testOutput, allUsers);
	}
	
	@Test
	public void testRetrieveAllCategory() {
		//Test if category list is not null but empty -boundary
		assertNotNull("Test that there is valid catList to view",catList);
				
		//Test if the list of categories retrieved from the CaseStudy is empty - boundary
		String allCats = C206_CaseStudy.retrieveAllCategory(catList);
		String testOutput = "";
		assertEquals("Check that viewAllCategorylist", testOutput, allCats);
				
		//Given an empty list, after adding 2 items, test if the size of the list is 2 - normal
		C206_CaseStudy.addCategory(catList, c1);
		C206_CaseStudy.addCategory(catList, c2);
		assertEquals("Test that userList arraylist size is 2?", 2, catList.size());
		
		//Test if the expected output string same as the list of categories retrieved from the Case study	
		allCats= C206_CaseStudy.retrieveAllCategory(catList);
		testOutput = String.format("%-25s\n","Books");
		testOutput += String.format("%-25s\n","Files");
			
		assertEquals("Test that viewAllCategorylist", testOutput, allCats);
	}
	
	@Test
	public void testRetrieveAllItem() {
		//Test if item list is not null but empty -boundary
		assertNotNull("Test that there is valid itemList to view", itemList);
				
		//Test if the list of items retrieved from the CaseStudy is empty - boundary
		String allItems = C206_CaseStudy.retrieveAllItem(itemList);
		String testOutput = "";
		assertEquals("Check that ViewAllItemlist", testOutput, allItems);
				
		//Given an empty list, after adding 2 items, test if the size of the list is 2 - normal
		C206_CaseStudy.addItem(itemList, i1);
		C206_CaseStudy.addItem(itemList, i2);
		assertEquals("Test that itemList arraylist size is 2?", 2, itemList.size());
				
		//Test if the expected output string same as the list of items retrieved from the Case study
		allItems = C206_CaseStudy.retrieveAllItem(itemList);
		testOutput = String.format("%-25s %-25s %-25.2f %-25s %-25s %-25.2f\n" , "book1","textbook",0.1,"01/01/22","31/12/22",0.5);
		testOutput += String.format("%-25s %-25s %-25.2f %-25s %-25s %-25.2f\n", "book2","textbook",0.1,"01/01/22","31/12/22",0.5);	
		assertEquals("Test that ViewAllitemlist", testOutput, allItems);
	}
	
	@Test
	public void testRetrieveAllBid() {
		//Test if bid list is not null but empty -boundary
		assertNotNull("Test that there is valid bidList to view", bidList);
				
		//Test if the list of items retrieved from the CaseStudy is empty - boundary
		String allBids = C206_CaseStudy.retrieveAllBid(bidList);
		String testOutput = "";
		assertEquals("Check that ViewAllItemlist", testOutput, allBids);
				
		//Given an empty list, after adding 2 items, test if the size of the list is 2 - normal
		C206_CaseStudy.addBid(bidList, b1);
		C206_CaseStudy.addBid(bidList, b2);
		assertEquals("Test that bidList arraylist size is 2?", 2, bidList.size());
				
		//Test if the expected output string same as the list of items retrieved from the Case study
		allBids = C206_CaseStudy.retrieveAllBid(bidList);
		testOutput = String.format("%-25d %-25s %-25s %-25s %-25.2f\n" , 1,"Test","sell@gmail.com","buy@gmail.com",5.0);
		testOutput += String.format("%-25d %-25s %-25s %-25s %-25.2f\n", 1,"Test2","sell2@gmail.com","buy2@gmail.com",5.0);	
		assertEquals("Test that ViewAllBidlist", testOutput, allBids);
	}
	
	@Test
	public void testRetrieveAllDeal() {
		//Test if bid list is not null but empty -boundary
		assertNotNull("Test that there is valid dealList to view", dealList);
				
		//Test if the list of items retrieved from the CaseStudy is empty - boundary
		String allDeals = C206_CaseStudy.retrieveAllDeal(dealList);
		String testOutput = "";
		assertEquals("Check that ViewAllDeallist", testOutput, allDeals);
				
		//Given an empty list, after adding 2 items, test if the size of the list is 2 - normal
		C206_CaseStudy.addDeal(dealList, d1);
		C206_CaseStudy.addDeal(dealList, d2);
		assertEquals("Test that dealList arraylist size is 2?", 2, dealList.size());
				
		//Test if the expected output string same as the list of items retrieved from the Case study
		allDeals = C206_CaseStudy.retrieveAllDeal(dealList);
		testOutput = String.format("%-25d %-25s %-25s %-25s %-25.2f %-25s\n" , 1, "toy", "test@gmail.com", "test2@gmail.com", 0.0, "August 1st 2022");
		testOutput += String.format("%-25d %-25s %-25s %-25s %-25.2f %-25s\n", 1, "toy2", "test3@gmail.com", "test4@gmail.com", 0.0, "August 1st 2022");	
		assertEquals("Test that ViewAllBidlist", testOutput, allDeals);
	}
	
	@Test
	public void testAddUser() {
		// Item list is not null, so that can add a new item
		assertNotNull("Test if there is valid User arraylist to add to", userList);
		
		//Given an empty list, after adding 1 item, the size of the list is 1
		C206_CaseStudy.addUser(userList, u1);		
		assertEquals("Test if that User arraylist size is 1?", 1, userList.size());
		
		//The item just added is as same as the first item of the list
		assertSame("Test that User is added same as 1st item of the list?", u1, userList.get(0));
		
		//Add another item. test The size of the list is 2?
		C206_CaseStudy.addUser(userList, u2);
		assertEquals("Test that User arraylist size is 2?", 2, userList.size());
		assertSame("Test that User is added same as 2nd item of the list?", u2, userList.get(1));
	}
	
	@Test
	public void testAddCategory() {
		// Item list is not null, so that can add a new item
		assertNotNull("Test if there is valid Category arraylist to add to", catList);
		
		//Given an empty list, after adding 1 item, the size of the list is 1
		C206_CaseStudy.addCategory(catList, c1);		
		assertEquals("Test if that Category arraylist size is 1?", 1, catList.size());
		
		//The item just added is as same as the first item of the list
		assertSame("Test that Category is added same as 1st item of the list?", c1, catList.get(0));
		
		//Add another item. test The size of the list is 2?
		C206_CaseStudy.addCategory(catList, c2);
		assertEquals("Test that Category arraylist size is 2?", 2, catList.size());
		assertSame("Test that Category is added same as 2nd item of the list?", c2, catList.get(1));
	}
	
	@Test
	public void testAddItem() {
		// Item list is not null, so that can add a new item
		assertNotNull("Test if there is valid Item arraylist to add to", itemList);
		
		//Given an empty list, after adding 1 item, the size of the list is 1
		C206_CaseStudy.addItem(itemList, i1);		
		assertEquals("Test if that Item arraylist size is 1?", 1, itemList.size());
		
		//The item just added is as same as the first item of the list
		assertSame("Test that Item is added same as 1st item of the list?", i1, itemList.get(0));
		
		//Add another item. test The size of the list is 2?
		C206_CaseStudy.addItem(itemList, i2);
		assertEquals("Test that Item arraylist size is 2?", 2, itemList.size());
		assertSame("Test that Item is added same as 2nd item of the list?", i2, itemList.get(1));
	}
	
	@Test
	public void testAddBid() {
		// Item list is not null, so that can add a new item
		assertNotNull("Test if there is valid Bid arraylist to add to", bidList);
		
		//Given an empty list, after adding 1 item, the size of the list is 1
		C206_CaseStudy.addBid(bidList, b1);		
		assertEquals("Test if that Bid arraylist size is 1?", 1, bidList.size());
		
		//The item just added is as same as the first item of the list
		assertSame("Test that Bid is added same as 1st item of the list?", b1, bidList.get(0));
		
		//Add another item. test The size of the list is 2?
		C206_CaseStudy.addBid(bidList, b2);
		assertEquals("Test that Bid arraylist size is 2?", 2, bidList.size());
		assertSame("Test that Bid is added same as 2nd item of the list?", b2, bidList.get(1));
	}
	
	@Test
	public void testAddDeal() {
		// Item list is not null, so that can add a new item
		assertNotNull("Test if there is valid Deal arraylist to add to", dealList);
		
		//Given an empty list, after adding 1 item, the size of the list is 1
		C206_CaseStudy.addDeal(dealList, d1);		
		assertEquals("Test if that Deal arraylist size is 1?", 1, dealList.size());
		
		//The item just added is as same as the first item of the list
		assertSame("Test that Deal is added same as 1st item of the list?", d1, dealList.get(0));
		
		//Add another item. test The size of the list is 2?
		C206_CaseStudy.addDeal(dealList, d2);
		assertEquals("Test that Deal arraylist size is 2?", 2, dealList.size());
		assertSame("Test that Deal is added same as 2nd item of the list?", d2, dealList.get(1));
	}
	
	@After
	public void tearDown() throws Exception {
		u1 = null;
		u2 = null;
		c1 = null;
		c2 = null;
		i1 = null;
		i2 = null;
		b1 = null;
		b2 = null;
		d1 = null;
		d2 = null;
		
		userList = null;
		catList = null;
		itemList = null;
		bidList = null;
		dealList = null;
	}

}
