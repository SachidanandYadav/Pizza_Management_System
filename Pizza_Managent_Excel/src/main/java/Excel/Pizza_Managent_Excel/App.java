package Excel.Pizza_Managent_Excel;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) throws IOException, EncryptedDocumentException, InvalidFormatException {
		Scanner sc = new Scanner(System.in);
		List<Customer1> customer =  new ArrayList<>();
		Event evet1 = new Event();
		int Choice;
		do {
			System.out.println("========Pizza MANAGEMENT SYSTEM========");
			System.out.println("1.Take Order\n" + "2.View Order\n" + "3.Delete Order\n"
					+ "4.Search Order as per date \n"+ "0.Exit");
			System.out.print("Enter your Choice : ");

			Choice = sc.nextInt();
			switch (Choice) {
			case 1:
				Customer1 obj = evet1.take_order();
				customer.add(obj);
				evet1.write(customer);
				break;
			case 2:
				evet1.display(customer);
				break;
			case 3:
				System.out.println("Ente the customer id");
				int id1 = sc.nextInt();
				evet1.search(id1,customer);
				break;
			case 4:
				System.out.println("Ente the customer id");
				int id2 = sc.nextInt();
				evet1.delete(id2,customer);
				break;
			case 0:// Exit
				System.out.println("Thank You for with us");
				System.exit(0);
				break;
			default:
				throw new IllegalArgumentException("Unexpected value: " + Choice);
			}

		} while (Choice <= 7);
	}
}
