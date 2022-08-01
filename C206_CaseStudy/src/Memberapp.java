import java.util.ArrayList;

/*
 * I declare that this code was written by me. 
 * I do not copy or allow others to copy my code. 
 * I understand that copying code is considered as plagiarism.
 * 
 * Student Name: Darren Tan Wai Chong
 * Student ID: 21043721
 * Class: W64E
 * Date/Time created: Monday 01-08-2022 11:56
 */

/**
 * @author kd241
 *
 */
public class Memberapp {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ArrayList<Member> memberList = new ArrayList<Member>();
		
		memberList.add(new Member("Dave", "Student", "Ken9010@gmail.com","zz09122"));
		memberList.add(new Member("zea", "Student", "zweaddw@gmail.com","wdwd9122"));
		memberList.add(new Member("ken", "Student", "kwddwk@gmail.com","zaceff"));
		
		int option = 3;
		
		while (option != 5) {
			
			Memberapp.menu();
			option = Helper.readInt("Enter an option : ");
			
			if (option == 1) {
				
				
				Member newuser = inputMember();
				Memberapp.addMember(memberList, newuser);
				System.out.println("User added");
				
			} else if (option == 2) {
				Memberapp.viewAllUser(memberList);
			} else if (option == 3) {
				removeMember(memberList);
				boolean remove = true;
				if (remove = true) {
					System.out.println("User removed");
				} else {
					System.out.println("Fail removed");
				}
			}
		}
		}
	
	public static void menu() {
		Helper.line(80, "=");
		System.out.println(" Member App Management");
		System.out.println("1. Add user");
		System.out.println("2. View user");
		System.out.println("3. Delete user");
		Helper.line(80, "=");
	}
	public static Member inputMember() {
		
		String username = Helper.readString("Enter name : ");
		String userrole = Helper.readString("Enter role : ");
		String useremail = Helper.readString("Enter email : ");
		String userpassword = Helper.readString("Enter password: ");
		
		Member newuser = new Member(username, userrole, useremail, userpassword);
		return newuser;
	}

	public static void addMember(ArrayList<Member> memberList, Member newuser) {
		memberList.add(newuser);
	}
	
	public static String retrieveAllusers(ArrayList<Member> memberList) {
		String output = "";
		
		for (int i = 0; i < memberList.size(); i++) {
			
			output += String.format("%-15s %-10s %-25s %-10s\n", memberList.get(i).getName()
					, memberList.get(i).getRole(), memberList.get(i).getEmail(), memberList.get(i).getPassword());
		}
		return output;
	}
	
	public static void viewAllUser(ArrayList<Member> memberList) {
		String output = String.format("%-15s %-10s %-25s %-10s\n", "Student", "Role", "Email","Password");
		output += retrieveAllusers(memberList);
		System.out.println(output);
	}
	
	public static void removeMember(ArrayList<Member> memberList) {
		
		String useremail = Helper.readString("Enter email : ");
		for (int i = 0; i < memberList.size(); i++) {
			if (memberList.get(i).getEmail().equals(useremail)) {
				memberList.remove(i);
			}
		}
	}
}
