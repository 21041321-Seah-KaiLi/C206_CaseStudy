import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class ItemTest {
	
	private Item im1;
	private Item im2;
	private Item im3;
	
	private ArrayList<Item> itemList;

	@Before
	public void setUp() throws Exception {
		// prepare test data
		im1 = new Item("AirPods", "The latest version", 250.00, "2022-04-22", "2022-11-24", 40.00);
		im2 = new Item("Powerbank", "The capacity is 3000mAh", 20.00, "2022-05-12", "2022-12-17", 5.00);
		im3 = new Item("Apple Watch", "The latest version", 400.00, "2022-08-22", "2022-10-24", 20.00);

		itemList= new ArrayList<Item>();
	}
	
	@Test
	public void testAddItem() {
		
		// Item list is not null, so that can add a new item - boundary
		assertNotNull("Check if there is valid Item arraylist to add to", itemList);
		
		//Given an empty list, after adding 1 item, the size of the list is 1 - normal
		//The item just added is as same as the first item of the list
		ItemApp.addItem(itemList, im1);
		assertEquals("Check that Item arraylist size is 1", 1, itemList.size());
		assertSame("Check that Item is added", im1, itemList.get(0));
		
		//Add another item. test The size of the list is 2? -normal
		//The item just added is as same as the second item of the list
		ItemApp.addItem(itemList, im2);
		assertEquals("Check that Item arraylist size is 2", 2, itemList.size());
		assertSame("Check that Item is added", im2, itemList.get(1));
	}
	
	@Test
	public void testRetrieveAllItem() {
		
		//itemList exist, so that the users can view the list of items
		assertNotNull("Test that there is valid itemList to view", itemList);
		
		//Test if the list of item retrieved from the ItemApp is empty
		String allItems = ItemApp.retrieveAllItem(itemList);
		String testOutput = "";
		assertEquals("Check that ViewAllItemlist", testOutput, allItems);
		
		//Given an empty list, after adding 3 items, test if the size of the list is 3
		ItemApp.addItem(itemList, im1);
		ItemApp.addItem(itemList, im2);
		assertEquals("Test that itemList arraylist size is 2?", 2, itemList.size());
		
		//test if the expected output string same as the list of items retrieved from the ItemApp
		allItems = ItemApp.retrieveAllItem(itemList);
		testOutput = String.format("%-20s %-30s %-20s %-20s %-20s %-20s\n" , "AirPods", "The latest version", 250.00, "2022-04-22", "2022-11-24", 40.00);
		testOutput += String.format("%-20s %-30s %-20s %-20s %-20s %-20s\n", "Powerbank", "The capacity is 3000mAh", 20.00, "2022-05-12", "2022-12-17", 5.00);	
		assertEquals("Test that ViewAllitemlist", testOutput, allItems);
	}
	
	@Test
	public void testDeleteItem() {
		
		//itemList exist, so that the users can view the list of items
		assertNotNull("Test that there is valid itemList to view", itemList);
		
		//Test if the list of item retrieved from the ItemApp is empty
		String allItems = ItemApp.retrieveAllItem(itemList);
		String testOutput = "";
		assertEquals("Check that ViewAllItemlist", testOutput, allItems);
		
		//Given an empty list, after adding 2 items, test if the size of the list is 2
		ItemApp.addItem(itemList, im1);
		ItemApp.addItem(itemList, im2);
		assertEquals("Test that itemList arraylist size is 2?", 2, itemList.size());
		
		//After removing an item, then test the size of the list becomes 1
		itemList.remove(0);
		assertEquals(1, itemList.size());
		
		//Remove another item, then test the list is empty
		itemList.remove(0);
		assertEquals(0, itemList.size());
	}
	

}
