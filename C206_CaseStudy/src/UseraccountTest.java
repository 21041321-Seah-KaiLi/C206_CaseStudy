import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/*
 * I declare that this code was written by me. 
 * I do not copy or allow others to copy my code. 
 * I understand that copying code is considered as plagiarism.
 * 
 * Student Name: Darren Tan Wai Chong
 * Student ID: 21043721
 * Class: W64E
 * Date/Time created: Monday 01-08-2022 14:49
 */

/**
 * @author kd241
 *
 */
public class UseraccountTest {

	private Member newuser1;
	private Member newuser2;
	private Member newuser3;
	
	private ArrayList<Member> memberList;
	
	@Before
	public void setUp() throws Exception {
		
		newuser1 = new Member("Dave", "Student", "Ken9010@gmail.com","zz09122");
		newuser2 = new Member("zea", "Student", "zweaddw@gmail.com","wdwd9122");
		newuser3 = new Member("ken", "Student", "kwddwk@gmail.com","zaceff");
		
		memberList = new ArrayList<Member>();
	}

	
	@After
	public void tearDown() throws Exception {
		
		
	}

	@Test
	public void testaddAccout() {
		
		//MemberList is not null, so that the admin can a new member
		assertNotNull("Test that if there is a valid memberList to add to", memberList);
		
		//after adding 1 item. the size of the list is 1
		Memberapp.addMember(memberList, newuser1);
		assertEquals("Test if memberList arraylist size is 1?", 1, memberList.size());
		
		//Add another item, test that the size of the list is 2?
		Memberapp.addMember(memberList, newuser2);
		assertEquals("Test that MemberList arraylist size is 2?", 2, memberList.size());
		
	}
	
	@Test
	public void testretrieveallUser() {
		
		//MemberList exist, so that the admin can view the list of members
		assertNotNull("Test that there is valid memberList to view", memberList);
		
		//Test if the list of member retrieved from the Memberapp is empty
		String allUsers = Memberapp.retrieveAllusers(memberList);
		String testOutput = "";
		assertEquals("Check that ViewAllMemberlist", testOutput, allUsers);
		
		//Given an empty list, after adding 2 items, test if the size of the list is 2
		Memberapp.addMember(memberList, newuser2);
		Memberapp.addMember(memberList, newuser3);
		assertEquals("Test that MemberList arraylist size is 2?", 2, memberList.size());
	}
	
	@Test
	public void testdeleteUser() {
		
		//MemberList exist, so that the admin can delete a members in the list
		assertNotNull("Test that there is valid memberList to view", memberList);
		
		//Test if the list of member retrieved from the Memberapp is empty
		String allUsers = Memberapp.retrieveAllusers(memberList);
		String testOutput = "";
		assertEquals("Check that ViewAllMemberlist", testOutput, allUsers);
		
		//Given an empty list, after adding 3 items, test if the size of the list is 3
		Memberapp.addMember(memberList, newuser1);
		Memberapp.addMember(memberList, newuser2);
		Memberapp.addMember(memberList, newuser3);
		assertEquals("Test that MemberList arraylist size is 3?", 3, memberList.size());
		
		//After removing an member, then test the size of the list becomes 2
		memberList.remove(0);
		assertEquals(2, memberList.size());
				
		//Remove another member, then test the size of the list becomes 1
		memberList.remove(0);
		assertEquals(1, memberList.size());
		
		//Remove another member, then test the list is empty
		memberList.remove(0);
		assertEquals(0, memberList.size());
	}


}
