package Excel.Pizza_Managent_Excel;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.*;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;



public class Event {
	int id = 01, quantity;
	String name;
	private double price, total;
	boolean flag;
	Scanner sc = new Scanner(System.in);

	public void write(List<Customer1> customer) throws IOException {
		String[] columns = { "Order ID", "Pizza Name", "Quantity", "Price", "Total Price" };
		Workbook workbook = new XSSFWorkbook();
		Sheet sheet = workbook.createSheet("Customer");
		Row headerRow = sheet.createRow(0);

		for (int i = 0; i < columns.length; i++) {
			Cell cell = headerRow.createCell(i);
			cell.setCellValue(columns[i]);
		}

		int rowNum = 1;
		for (Customer1 cust : customer) {
			Row row = sheet.createRow(rowNum++);

			row.createCell(0).setCellValue(cust.getId());
			row.createCell(1).setCellValue(cust.getName());
			row.createCell(2).setCellValue(cust.getQuantity());
			row.createCell(3).setCellValue(cust.getPrice());
			row.createCell(4).setCellValue(cust.getTotal());
		}

		for (int i = 0; i < columns.length; i++) {
			sheet.autoSizeColumn(i);
		}
		FileOutputStream fileOut = new FileOutputStream("Customer_Detail.xlsx");
		workbook.write(fileOut);
		fileOut.close();
		workbook.close();

	}

	public Customer1 take_order() {
		System.out.println("Enter Pizza name :");
		name = sc.next();
		System.out.println("Enter Pizza Quantity :");
		quantity = sc.nextInt();
		System.out.println("Enter Pizza Price :");
		price = sc.nextDouble();

		Customer1 data = new Customer1();
		data.setId(id);
		data.setName(name);
		data.setQuantity(quantity);
		data.setPrice(price);
		data.setTotal(quantity * price);
		id++;
		return data;
	}
	
	public void display(List<Customer1> customer)  {
		System.out.println("All Customer Data.");
		System.out.println("Cust_Id\tCust_Name");
		for (Customer1 user : customer) 
			System.out.println(user.getId()+"\t"+user.getName()+"\t"+user.getQuantity()+"\t"+user.getPrice()+"\t"+user.getTotal());
		}	
//		String path = ("/home/v2stech/Documents/Tranning/CoreJava/Examples/February/Pizza_Managent_Excel/Customer_Detail.xlsx");
//		Workbook workbook = WorkbookFactory.create(new File(path));
//		Sheet sheet = workbook.getSheetAt(0);
//		DataFormatter dataFormatter = new DataFormatter();
//		System.out.println("\n\nIterating over Rows and Columns using for-each loop\n");
//        for (Row row: sheet) 
//        {
//            for(Cell cell: row) 
//            {
//                String cellValue = dataFormatter.formatCellValue(cell);
//                System.out.print(cellValue + "\t");
//            }
//            System.out.println();
//        }
//        workbook.close();

//	}
	
	public void search(int id1, List<Customer1> customer) {
		System.out.println("Cust_Id\tCust_Name");
		for (Customer1 u : customer) {
			if (u.getId() == id1)
				System.out.println(u.getId()+"\t"+u.getName()+"\t"+u.getQuantity()+"\t"+u.getPrice()+"\t"+u.getTotal());
			flag = true;
		}	
		if(flag = false)
			System.out.println(id1+" Not found.");

	}
	public void delete(int id2, List<Customer1> customer) {
		System.out.println("Cust_Id\tCust_Name");
		for (Customer1 u : customer) {
			if (u.getId() == id2)
				customer.remove(id2);
			flag = true;
		}	
		if(flag = false)
			System.out.println(id2+" Not found.");

	}

}
