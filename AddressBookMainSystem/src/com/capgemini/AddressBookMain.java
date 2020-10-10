package com.capgemini;

import java.util.*;

public class AddressBookMain {
	static Scanner sc = new Scanner(System.in);
	private LinkedList<ContactDetails> contactDetailsList;
	

	private AddressBookMain() {
		contactDetailsList = new LinkedList<>();
	}


	private void addContact(int addressBookNum) {
		System.out.println("How many entries you want to make in Address Book " + addressBookNum);
		int numOfEntries = sc.nextInt();
		sc.nextLine();
		for (int i = 0; i < numOfEntries; i++) {
			String firstName, lastName;
			int flag = 0;
			do {
				int counter = 0;
				System.out.println("First Name: ");
				firstName = sc.nextLine();
				System.out.println("Last Name: ");
				lastName = sc.nextLine();
				for (int j = 0; i < i; j++)
					if (contactDetailsList.get(j).firstName.equals(firstName)
							&& contactDetailsList.get(j).lastName.equals(lastName)) {
						counter++;
					}
				if (counter != 0) {
					System.out.println("This name already exists! Please enter again");
					flag = 0;
				} else
					flag = 1;
			} while (flag == 0);
			System.out.println("Address: ");
			String address = sc.nextLine();
			System.out.println("City: ");
			String city = sc.nextLine();
			System.out.println("State: ");
			String state = sc.nextLine();
			System.out.println("ZIP: ");
			int zip = sc.nextInt();
			System.out.println("Phone No: ");
			long phoneNo = sc.nextLong();
			sc.nextLine();
			System.out.println("Email ID: ");
			String emailId = sc.nextLine();
			ContactDetails contactDetail = new ContactDetails(firstName, lastName, address, state, city, zip, phoneNo,
					emailId);
			contactDetailsList.add(contactDetail);
		}
	}

	private static void editContact(Map<String, AddressBookMain> addressBookMap) {
		System.out.println("First Name of the person whose record is to be edited: ");
		String firstName = sc.nextLine();
		System.out.println("Last Name of the person whose record is to be edited: ");
		String lastName = sc.nextLine();
		System.out.println("New Address: ");
		String address = sc.nextLine();
		System.out.println("New City: ");
		String city = sc.nextLine();
		System.out.println("New State: ");
		String state = sc.nextLine();
		System.out.println("New ZIP: ");
		int zip = sc.nextInt();
		System.out.println("New Phone No: ");
		long phoneNo = sc.nextLong();
		sc.nextLine();
		System.out.println("Edited Email ID: ");
		String emailId = sc.nextLine();
		for (Map.Entry<String, AddressBookMain> entry : addressBookMap.entrySet()) {
			AddressBookMain value = entry.getValue();
			for (int i = 0; i < value.contactDetailsList.size(); i++)
				if (value.contactDetailsList.get(i).firstName.contains(firstName)
						&& value.contactDetailsList.get(i).lastName.contains(lastName)) {
					ContactDetails contactDetails = new ContactDetails(firstName, lastName, address, city, state, zip,
							phoneNo, emailId);
					value.contactDetailsList.set(i, contactDetails);
					System.out.println("Edited the contact");
				}
		}
	}

	private static void searchContactDetails(Map<String, AddressBookMain> addressBookMap) {
		System.out.println("Enter First Name of person whose record is to be searched: ");
		String firstName = sc.nextLine();
		System.out.println("Enter Last Name of person whose record is to be searched: ");
		String lastName = sc.nextLine();
		int flag = 0;
		for (Map.Entry<String, AddressBookMain> entry : addressBookMap.entrySet()) {
			AddressBookMain value = entry.getValue();
			for (int i = 0; i < value.contactDetailsList.size(); i++)
				if (value.contactDetailsList.get(i).firstName.contains(firstName)
						&& value.contactDetailsList.get(i).lastName.contains(lastName)) {
					System.out.println(value.contactDetailsList.get(i));
					flag = 1;
					break;
				}
		}
		if (flag == 0) {
			System.out.println("No such record found");
		}
	}

	public static void deleteContactDetails(Map<String, AddressBookMain> addressBookMap) {
		System.out.println("Enter First Name of person whose record is to be deleted: ");
		String firstName = sc.nextLine();
		System.out.println("Enter Last Name of person whose record is to be deleted: ");
		String lastName = sc.nextLine();
		int flag = 0;
		for (Map.Entry<String, AddressBookMain> entry : addressBookMap.entrySet()) {
			AddressBookMain value = entry.getValue();
			for (int i = 0; i < value.contactDetailsList.size(); i++)
				if (value.contactDetailsList.get(i).firstName.contains(firstName)
						&& value.contactDetailsList.get(i).lastName.contains(lastName)) {
					value.contactDetailsList.remove(i);
					System.out.println("Deleted Contact");
					flag = 1;
				}
		}
		if (flag == 0) {
			System.out.println("No such record found");
		}

	}

	private static void displayContactDetails(Map<String, AddressBookMain> addressBookMap) {
		for (Map.Entry<String, AddressBookMain> entry : addressBookMap.entrySet()) {
			AddressBookMain value = entry.getValue();
			for (int i = 0; i < value.contactDetailsList.size(); i++)
				System.out.println(value.contactDetailsList.get(i));
		}
	}
	
	private static void contactCity(Map<String, AddressBookMain> addressBookMap) {
		System.out.println("Enter city of person whose record is to be searched: ");
		String city = sc.nextLine();
		int flag = 0;
		for (Map.Entry<String, AddressBookMain> entry : addressBookMap.entrySet()) {
			AddressBookMain value = entry.getValue();
			for (int i = 0; i < value.contactDetailsList.size(); i++)
				if (value.contactDetailsList.get(i).city.contains(city)) {
					System.out.println(value.contactDetailsList.get(i));
					flag = 1;
				}
		}
		if(flag==0)
			System.out.println("No persons in that city");
	}

	private static void contactState(Map<String, AddressBookMain> addressBookMap) {
		System.out.println("Enter state of person whose record is to be searched: ");
		String state = sc.nextLine();
		int flag = 0;
		for (Map.Entry<String, AddressBookMain> entry : addressBookMap.entrySet()) {
			AddressBookMain value = entry.getValue();
			for (int i = 0; i < value.contactDetailsList.size(); i++)
				if (value.contactDetailsList.get(i).state.contains(state)) {
					System.out.println(value.contactDetailsList.get(i));
					flag = 1;
				}
		}
		if(flag==0)
			System.out.println("No persons in that state");
	}


	public static void main(String[] args) {
		Map<String, AddressBookMain> addressBookMap = new HashMap<>();
		System.out.println("How many address books should be created? ");
		int noOfAddressBooks = sc.nextInt();
		sc.nextLine();
		AddressBookMain[] addressBookArray = new AddressBookMain[noOfAddressBooks];
		for (int i = 0; i < noOfAddressBooks; i++) {
			System.out.println("Enter name for Address Book " + (i + 1) + ": ");
			String addressBookName = sc.nextLine();
			addressBookArray[i] = new AddressBookMain();
			addressBookArray[i].addContact(i + 1);
			addressBookMap.put(addressBookName, addressBookArray[i]);
		}
		int i = 1;
		while (i == 1) {
			System.out.println("Choose an option ");
			System.out.println("1. Edit Contact ");
			System.out.println("2. Delete Contact ");
			System.out.println("3. Search Contact ");
			System.out.println("4. Display Contact ");
			System.out.println("5. Search Contact by city ");
			System.out.println("6. Exit ");
			int option = sc.nextInt();
			switch (option) {
			case 1:
				editContact(addressBookMap);
				break;
			case 2:
				deleteContactDetails(addressBookMap);
				break;
			case 3:
				searchContactDetails(addressBookMap);
				break;
			case 4:
				displayContactDetails(addressBookMap);
				break;
			case 5:
				contactCity(addressBookMap);
				break;
			case 6:
				contactState(addressBookMap);
				break;
			default:
				i = 0;
			}
		}

	}
}