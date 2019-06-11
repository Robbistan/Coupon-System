package main;

import facades.AdminFacade;
import facades.CompanyFacade;
import facades.CustomerFacade;

public class CouponSystem {
	
	private static CouponSystem instance = new CouponSystem();
	
	public static CouponSystem getInstance() {
		return instance;
	}
		
	
	public void login(String name, String password, String clientType) {
		if(name.equalsIgnoreCase("admin") && password.equalsIgnoreCase("1234")) {
			System.out.println("Welcome " + name);
			AdminFacade af = new AdminFacade();
		}
		else if (name.equalsIgnoreCase("Company") && password.equalsIgnoreCase("12345")) {
			System.out.println("welcome Company");
			CompanyFacade cf = new CompanyFacade();
		}
		else if (name.equalsIgnoreCase("Customer") && password.equalsIgnoreCase("123456")) {
			System.out.println("Welcome Customer");
			CustomerFacade csf = new CustomerFacade();
			
		}
		System.out.println("username or password incorrect");
		
	}


}
