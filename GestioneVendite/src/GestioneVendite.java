import java.util.*;

public class GestioneVendite {
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int us, choice=10;
		//boolean end=false;
		//int clientId=0, indexId=0;sg
		System.out.println("APPLICATION FOR SELLING MANAGMENT"
						+ "VERSION 2.0");
		
		//SELECT THE USER TYPE
		System.out.println("\nSELECT YOUR STATUS:"
				+ "\n1)EMPLOYEE"
				+ "\n2)ADMINISTRATOR");
		us = scan.nextInt();
		Impiegato employee =  new Impiegato();
		Administrator admin =  new Administrator();
		if (us==2) {
			System.out.println("Enter username and password");
			while(!admin.isAdmin(scan.next(), scan.next())){
				System.out.println("SOMETHING WRONG");
			}
			System.out.println("ACCESSED WITH ADMINISTRATOR RIGTH");
		}
		else {
			System.out.println("Enter username and password");
			while(!employee.isClient(scan.next(), scan.next())) {
				System.out.println("SOMETHING WRONG");
			}
			System.out.println("ACCESSED WITH EMPLOYEE RIGTH");
		}
		
		
		//CALL THE SELECTED FEATURE
		if (us==2) {
			
			while (choice!=0) {
				admin.showFeatures();
				choice = admin.selectFeatures();
			}
		}
		else {
			
			while (choice!=0) {
				employee.showFeatures();
				employee.selectFeatures();
			}
		}
		scan.close();
	}
	
	
//	//CREATE A NEW CLIENT
//	private static void newClient(Impiegato user) {
//		String n, s, f, a;
//		Scanner scan = new Scanner(System.in);
//		
//		System.out.print("name: ");
//		n = scan.next();
//		System.out.print("surname: ");
//		s = scan.next();
//		System.out.print("fiscal code: ");
//		f = scan.next();
//		System.out.print("addres: ");
//		a = scan.next();
//		
//		user.newClient(n,s,f,a);
//		System.out.println("NEW CLIENT ADDED CORRECTLY");
//	}
//	
//	
//	//CHANGE CLIENT DATA
//	private static void modifyClient(Impiegato user, int client) {
//		int choice=0;
//		String value;
//		Scanner scan = new Scanner(System.in);
//		
//		System.out.println("PRESS * TO CHANGE:"
//						+ "\n1)NAME"
//						+ "\n2)SURNAME"
//						+ "\n3)FISCAL CODE"
//						+ "\n4)ADDRES");
//		System.out.print("Enter your choice: ");
//		choice = scan.nextInt();
//		System.out.print("Enter the new value: ");
//		value = scan.next();
//		switch (choice) {
//		case 1 -> user.setName(value, client);
//		case 2 -> user.setSurname(value, client);
//		case 3 -> user.setFisCode(value, client);
//		case 4 -> user.setAddres(value, client);
//		}
//	}
//	
//	
//	//REGISTER A NEW PURCHASE
//	private static void newPurchase(Impiegato user, int client) {
//		String n, s, d;
//		int p;
//		Scanner scan = new Scanner(System.in);
//		
//		System.out.print("name: ");
//		n = scan.next();
//		System.out.print("supplier: ");
//		s = scan.next();
//		System.out.print("price: ");
//		p = scan.nextInt();
//		System.out.print("date: ");
//		d = scan.next();
//		
//		user.newPurch(client, n, s, p, d);
//		System.out.println("NEW PURCHASE ADDED CORRECTLY");
//	}
//	
//	
//	//DELETE PURCHASE
//	private static void deletePurchase(Administrator user) {
//		int client, purchId;
//		Scanner scan = new Scanner(System.in);
//		System.out.print("enter the client id: ");
//		client = scan.nextInt();
//		System.out.print("enter the purchase id: ");
//		purchId = scan.nextInt();
//		user.remove(client, purchId);
//	}
//	
//	
//	//SHOW THE CLIENT LIST
//	private static void showClients(Impiegato user) {
//		user.showClients();
//	}
//	
//	
//	//SHOW THE CLIENT LIST
//		private static void showPurch(Impiegato user, int clientId) {
//			user.showPurchases(clientId);
//		}
}

