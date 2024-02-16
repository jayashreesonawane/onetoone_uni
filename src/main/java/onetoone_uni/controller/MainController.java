	package onetoone_uni.controller;

import java.util.Scanner;

import onetoone_uni.dao.AadharCardDao;
import onetoone_uni.dao.PersonDao;
import onetoone_uni.dto.AadharCard;
import onetoone_uni.dto.Person;

public class MainController {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		Person person = new Person();
		PersonDao dao = new PersonDao();
		AadharCard aadharCard = new AadharCard();
		AadharCardDao aadharCardDao = new AadharCardDao();

		System.out.println(
				"Enter your choice : \n1.Save Person \n2.Get Person by ID \n3.Get All Persons \n4.Delete Student \n5.Update Person \n6.Update both Person and Aadhar Card \n7.Exit");

		int choice = scanner.nextInt();

		switch (choice) {

		case 1: {
			try {
				System.out.println("Enter Aadhar Id : ");
				int id = scanner.nextInt();
				System.out.println("Enter Aadhar Name : ");
				String name = scanner.next();
				System.out.println("Enter Aadhar Address : ");
				String address = scanner.next();

				aadharCard.setId(id);
				aadharCard.setName(name);
				aadharCard.setAddress(address);

				System.out.println("Enter Person Id : ");
				int pid = scanner.nextInt();
				System.out.println("Enter Person Name : ");
				String p_name = scanner.next();
				System.out.println("Enter Person phone : ");
				long phone = scanner.nextLong();
				System.out.println("Enter Aadhar Address : ");
				String p_address = scanner.next();

				person.setId(pid);
				person.setName(p_name);
				person.setPhone(phone);
				person.setAddress(p_address);
				person.setAadharCard(aadharCard);

				dao.savePerson(person);
				System.out.println("Data Saved Successfully");
			} catch (Exception e) {
				System.out.println("Person is not saved successfully");
			}
		}
			break;

		case 2: {
			System.out.println("Enter your Id : ");
			int id = scanner.nextInt();
			dao.getPerson(id);
		}
			break;

		case 3: {
			dao.getAllPersons();
		}
			break;

		case 4: {
			System.out.println("Enter id of a Person : ");
			int id = scanner.nextInt();
			dao.deletePerson(id);
			System.out.println("Data Deleted Successfully");
//			aadharCardDao.deleteAadharCard(101); // we can't delete aadhar card
		}
			break;

		case 5: {
			scanner = new Scanner(System.in);
			System.out.println("Enter Id : ");
			int id = scanner.nextInt();
			person.setId(id);
			System.out.println("Enter name : ");
			person.setName(scanner.next());
			System.out.println("Enter phone : ");
			person.setPhone(scanner.nextLong());
			System.out.println("Enter Address : ");
			person.setAddress(scanner.next());

			dao.updatePerson(id, person);
		}
			break;

		case 6: {
			System.out.println("Enter Person id");
			int id = scanner.nextInt();
			System.out.println("Enter aadhar name : ");
			String name = scanner.next();
			aadharCard.setName(name);
			System.out.println("Enter aadhar address : ");
			String address = scanner.next();
			aadharCard.setAddress(address);

			System.out.println("Enter person name : ");
			String p_name = scanner.next();
			person.setName(p_name);
			System.out.println("Enter person phone : ");
			long phone = scanner.nextLong();
			person.setPhone(phone);
			System.out.println("Enter person address : ");
			String p_address = scanner.next();
			person.setAddress(p_address);
			
			person.setAadharCard(aadharCard);
			dao.updateBoth(id, person);

		}
			break;

		case 7: {
			
			System.out.println("Enter aadhar id : ");
			int a_id = scanner.nextInt();
			aadharCard.setId(a_id);
			System.out.println("Enter aadhar name : ");
			String name = scanner.next();
			aadharCard.setName(name);
			System.out.println("Enter aadhar address : ");
			String address = scanner.next();
			aadharCard.setAddress(address);

			System.out.println("Enter person id : ");
			int p_id = scanner.nextInt();
			person.setId(p_id);
			System.out.println("Enter person name : ");
			String p_name = scanner.next();
			person.setName(p_name);
			System.out.println("Enter person phone : ");
			long phone = scanner.nextLong();
			person.setPhone(phone);
			System.out.println("Enter person address : ");
			String p_address = scanner.next();
			person.setAddress(p_address);
			
			person.setAadharCard(aadharCard);
			dao.updatePersonWithAadharCard(p_id, a_id);
		}
			break;
			
		default:
			break;
		}

	}
}
