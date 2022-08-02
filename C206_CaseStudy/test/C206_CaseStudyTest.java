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
