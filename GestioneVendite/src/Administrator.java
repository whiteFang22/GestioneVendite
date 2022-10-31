
public class Administrator extends Impiegato{
	private int clientId, purchId;
	private String username = "mario", password = "gigino";
	//FEATURESh
	public void showFeatures() {
		super.showFeatures();
		System.out.println("9)DELETE A CLIENT'S PURCHASE"
						+ "\n10)MODIFY EMPLOYEE");
	}
	
	
	public int selectFeatures() {
		super.selectFeatures();
		switch(choice) {
		case 9 -> remove();
		case 10 -> modifyEmployee();
		}
		return choice;
	}
	
	//IS ADMIN?
	public boolean isAdmin(String us, String psw) {
		if (this.username.equals(us) && this.password.equals(psw)) return true;
		else return false;
	}
	
	//REMOVE CLIENT PURCHASE
	public void remove() {
		int temp;
		System.out.print("enter the client id: ");
		clientId = scan.nextInt();
		System.out.print("enter the purchase id: ");
		purchId = scan.nextInt();
		
		clients.get(clientId).removePurch(purchId);
		temp = pindex.get(clientIdentifier);
		temp -= 1;
		pindex.set(clientIdentifier, temp);
		
//		clients.get(clientId).purch()[purchId] = null;
//		pindex[clientId] -= 1;
//		int x = 0;
//		Purchase prec = null;
//		for (Purchase i : clients.get(clientId).purch()) {
//			if (x>purchId) {
//				prec = clients.get(clientId).purch()[x];
//				clients.get(clientId).purch()[x-1] = prec;
//				
//				if (x == pindex[clientId]+1) {
//					break;
//				}
//			}
//			x++;
//		}
	}
	
	
	//CHANGE ADMIN PASSWORD
	public void changePassword() {
		System.out.print("Insert the new passord: ");
		password = scan.next();
		System.out.print("PASSWORD CHANGED CORRECTLY");
	}
	
	
	//SHOW EMPLOYEE
	public void showEmployee() {
		userPasswords.forEach(
				(key, value) -> System.out.println("- user:"+key +" password:"+ value));	
	}
	
	//MODIFY EMPLOYEE
	public void modifyEmployee() {
		showEmployee();
		String name;
		int n;
		System.out.print("Which employee do you want to modify? ");
		name = scan.next();
		if (userPasswords.containsKey(name)) {
			System.out.print("OPTIONS:"
					+ "\n1)CHANGE USERNAME"
					+ "\n2)CHANGE PASSWORD"
					+ "\n3)DELETE USER");
			System.out.print("What is your choice? ");
			n=scan.nextInt();
			switch(n) {
			case 1 -> {
				String psw = userPasswords.remove(name);
				userPasswords.put(scan.next(), psw);
			}
			case 2 -> userPasswords.replace(name, scan.next());
			case 3 -> userPasswords.remove(name);
			default -> System.out.println("USER NOT FOUND");
			}
		}
		System.out.println("USER MODIFIED CORRECTLY");
		showEmployee();
	}
}
