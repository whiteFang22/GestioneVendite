import java.util.*;

public class Client {
	private String name, surname,  fisCode,  addres;
	private LinkedList<Purchase> purchases = new LinkedList<Purchase>();; 
	private int clientIdentifier;
	//private int clientNumber=0;
	//private int purchaseNumber=0;hg
	
	//COSTRUTTORE
	public Client(String n, String s, String f,String a,int id) {
		name = n;
		surname = s;
		fisCode = f;
		addres = a;
		clientIdentifier = id;
	}
	
	//SETTERS
	public void setName(String n){
		name = n;
	}
	public void setSurname(String s) {
		surname = s;
	}
	public void setFisCode(String f) {
		fisCode = f;
	}
	public void setAddres(String a) {
		addres = a;
	}
	
	//GETTERS
	public LinkedList<Purchase> getPurchases(){
		return purchases;
	}
	public String getName() {
		return name;
	}
	
	//TO STRING
	public String toString() {
		return "client id "+clientIdentifier+": [name: "+name+", surname: "+surname
				+", fisCode: "+fisCode+ ", addres: "+addres+"]";
		
	}
	
	//ADD A NEW PURCHASE
	public void addPurchase(Purchase purchase) {
		purchases.add(purchase);
		//purchaseNumber++;
	}
	
	//REMOVE A PURCHASE
	public void removePurch(int purchId) {
		purchases.remove(purchId);
		//purchaseNumber--;
	}
	
	//SHOW PURCHASES
	public void showPurchases() {
		int cnt=0;
		for ( Purchase i : (purchases) ) {
//			if (i==null) 
//				break;
			System.out.println("id "+cnt+": "+i.toString());
			cnt++;
		}
	}

}
