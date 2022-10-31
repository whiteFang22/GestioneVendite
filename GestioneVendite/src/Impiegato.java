import java.io.File;
import java.util.*;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Impiegato {
	
	//RECORDs
	//public record Purchase(String name, String supplier, double price, String data, int identifier) {}
	//public record Client(String name,String surname, String fisCode, String addres, LinkedList<Purchase> purch, int identifier) {}
	
	//FIELDS
	protected ArrayList<Client> clients = new ArrayList<Client>();  //store all the clients
	protected LinkedList<Purchase> purch = new LinkedList<Purchase>(); //array di appogio per estrazione acquisti da cliente
	protected Map<String, String> userPasswords = new HashMap<>();
	protected Map<String, Integer> products = new HashMap<>();
	private int clientsNum = 0; //count the number of clients
	protected int clientIdentifier = 0; //identify a specific client
	ArrayList<Integer> pindex = new ArrayList<>(); //used to track the clients's purchase number 
	protected String n;	//name
	protected String s;	//surname
	protected String f;	//fiscal code
	protected String a;	//address
	protected String d;	//date
	protected int p; 	//prize
	protected int choice, cnt=0;
	protected String userEmployee; //used to associate a particular (user,password) pair to the current employee object
	Scanner scan = new Scanner(System.in); //used to catch user input
	
	
	//MEMORIZE EMPLOYEE PASSWORDS FROM FILE
	public void readFiles() {
		File myObj1 = new File("passwords.txt");
		File myObj2 = new File("products.txt");
		String user, password, product;
		int quantity; 
		Scanner myReader = null;
		try{
			//READ PASSWORDS
			myReader = new Scanner(myObj1);
			while (myReader.hasNextLine()) {
				user = myReader.next();
				password = myReader.next();
				userPasswords.put(user,password);
			}
			
			//RmyReader = new Scanner(myObj);
			myReader = new Scanner(myObj2);
			while (myReader.hasNextLine()) {
				product = myReader.next();
				quantity = myReader.nextInt();
				products.put(product,quantity);
			}
		}
		catch(FileNotFoundException e) {
			System.out.println("ERROR: Passwords file not found.");
		}
	}
	
	
	//EMPOLYEE CONSTRUCTOR
	public Impiegato() {
		readFiles();
	}
	
	
	//IS EMPLOYEE?
	public boolean isClient(String username, String password) {
		cnt=0;
		if (userPasswords.containsKey(username) && userPasswords.get(username).equals(password)) {
			userEmployee = username;
			return true;
		}
		return false;
	}
	
	
	//EXTRACT CLIENT DATA
//	private int extract(int i) {
//		int tempIdentifier;
//		
//		this.n = clients.get(i).name;
//		this.s = clients.get(i).surname;
//		this.f = clients.get(i).fisCode;
//		this.a = clients.get(i).addres;
//		this.purch = clients.get(i).purch();
//		tempIdentifier = clients.get(i).identifier;
//		return tempIdentifier;
//	}
	
	
	//MODIFY WORKER DATA
	public void setName(String ni, int i) {
		
		//Client c = new Client(ni,s,f,a,purch, extract(i));
		clients.get(i).setName(ni);
		//clients.set(i,c);
		
	}
	public void setSurname(String si, int i) {
		//extract(i);
		//Client c = new Client(n,si,f,a,purch, extract(i));
		//clients.set(i,c);
		clients.get(i).setSurname(si);
	}
	public void setFisCode(String fi, int i) {
		//extract(i);
		//Client c = new Client(n,s,fi,a,purch, extract(i));
		//clients.set(i,c);
		clients.get(i).setFisCode(fi);
	}
	public void setAddres(String ai, int i) {
//		extract(i);
//		Client c = new Client(n,s,f,ai,purch, extract(i));
//		clients.set(i,c);
		clients.get(i).setAddres(ai);
	}
	
	
	//SHOW & SELECT FEATURES
	public void showFeatures() {
		System.out.println("\n\n\nSELECT AN OPERATION:"
				+ "\n0)EXIT"
				+ "\n1)ADD A NEW CLIENT"
				+ "\n2)CHANGE CLIENT DATA"
				+ "\n3)ADD A NEW PURCHASE"
				+ "\n4)SHOW CLIENTS"
				+ "\n5)SHOW CLIENT PURCHASE"
				+ "\n6)CHANGE YOUR PASSWORD"
				+ "\n7)ADD NEW PRODUCTS"
				+ "\n8)SHOW ALL PRODUCTS");
	}
	public int selectFeatures() {
		System.out.print("\n\nEnter your choice: ");
		choice = scan.nextInt();
		
		switch(choice) {
		case 0 -> System.out.println("APPLICATION CLOSED");
		case 1 -> newClient();
		case 2 -> changeClient();
		case 3 -> newPurch();
		case 4 -> showClients();
		case 5 -> showPurchases();
		case 6 -> changePassword();
		case 7 -> addProduct();
		case 8 -> showProducts();
		}
		return choice;
	}
	
	//NEW CLIENT
	public void newClient() {
		System.out.print("name: ");
		n = scan.next();
		System.out.print("surname: ");
		s = scan.next();
		System.out.print("fiscal code: ");
		f = scan.next();
		System.out.print("addres: ");
		a = scan.next();
		
		//LinkedList<Purchase> newPurch = new LinkedList<Purchase>();
		
		//Client c = new Client(n,s,f,a, newPurch, clientIdentifier);
		Client c = new Client(n,s,f,a, clientIdentifier);
		clients.add(c);
		clientIdentifier++;
		clientsNum++;
		pindex.add(clientIdentifier);

		System.out.println("NEW CLIENT ADDED CORRECTLY");
	}
	

	//SELECT THE CHANGE
	private void changeClient() {
		String value;
		System.out.print("Which is the client id: ");
		clientIdentifier = scan.nextInt();
		
		System.out.println("PRESS * TO CHANGE:"
				+ "\n1)NAME"
				+ "\n2)SURNAME"
				+ "\n3)FISCAL CODE"
				+ "\n4)ADDRES");
		System.out.print("Enter your choice: ");
		choice = scan.nextInt();
		
		switch (choice) {
		case 1 -> {
			System.out.print("Enter new name: ");
			value = scan.next();
			setName(value,clientIdentifier);
		}
		case 2 -> {
			System.out.print("Enter new surname: ");
			value = scan.next();
			setSurname(value,clientIdentifier);
		}
		case 3 -> {
			System.out.print("Enter new fiscal code: ");
			value = scan.next();
			setFisCode(value,clientIdentifier);
		}
		case 4 -> {
			System.out.print("Enter new addres: ");
			value = scan.next();
			setAddres(value,clientIdentifier);
		}
		}
		System.out.println("CLIENT MODIFIED CORRECTLY");
	}
	
	
	//APPEND A PURCHASE
	public void newPurch() {
		//int temp;
		System.out.print("Which client has done the purchase? ");
		clientIdentifier = scan.nextInt();
		System.out.print("name: ");
		n = scan.next();
		System.out.print("supplier: ");
		s = scan.next();
		System.out.print("price: ");
		p = scan.nextInt();
		System.out.print("date: ");
		d = scan.next();
		
		//temp = pindex.get(clientIdentifier);
		Purchase purchase = new Purchase(n, s, p, d, clientIdentifier);
//		clients.get(clientIdentifier).purch().add(purch);
		clients.get(clientIdentifier).addPurchase(purchase);
		//System.out.println(temp);
//		temp += 1;
//		pindex.set(clientIdentifier, temp);
		
		System.out.println("NEW PURCHASE ADDED CORRECTLY");
	}
	
	
	//SHOW CLIENTS
	public void showClients() {
		System.out.println("\nCLIENTS:");
		cnt=0;
		for (Client i : clients) {
			if (cnt>clientsNum-1) 
				break;
			System.out.println(i.toString());
//			System.out.println("client id "+cnt+": [name: "+i.name()+", surname: "+i.surname() 
//								+", fisCode: "+i.fisCode()+ ", addres: "+i.addres()+ ", identifier: "+i.identifier()+"]");
			cnt++;
		}
	}
	
	
	//SHOW CLIENT PURCHES
	public void showPurchases() {
		System.out.print("Of which client do you want see the purchases? ");
		clientIdentifier = scan.nextInt();
		System.out.println("\n"+clients.get(clientIdentifier).getName()+"'s purchases: ");
		//clients.get(clientIdentifier).showPurchases();
		cnt=0;
		for ( Purchase i : (clients.get(clientIdentifier).getPurchases()) ) {
//			if (i==null) 
//				break;
			System.out.println("id "+cnt+": "+i.toString());
			cnt++;
		}
	}
	
	
	//CHANGE EMPLOYEE PASSWORD
	public void changePassword() {
		String newPassword;
		System.out.print("What is your new password? ");
		newPassword=scan.next();
		userPasswords.replace(userEmployee, newPassword);
		System.out.println("PASSWORD CHANGED CORRECTLY");
	}
	
	
	//ADD A NEW PRODUCT TO THE SISTEM
	public void addProduct() {
		String product;
		int amount;
		
		System.out.print("New product: ");
		product=scan.next();
		System.out.print("Amount: ");
		amount=scan.nextInt();
		
		products.put(product,amount);
	}
	
	
	//SHOW ALL PRODUCTS
	public void showProducts() {
		products.forEach(
				(key, value) -> System.out.println("- product:"+key +"\t amount:"+ value));	
	}
}