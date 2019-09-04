/*
 * 
 */
package main;

import company.Company;
import coupon.Coupon;
import coupon.CouponDBDAO;
import coupon.CouponType;
import customer.Customer;
import facades.AdminFacade;
import facades.CompanyFacade;
import facades.CustomerFacade;
import facades.CouponClientFacade;

// TODO: Auto-generated Javadoc
/**
 * The Class Test.
 */
public class Test {

	/**
	 * The main method.
	 *
	 * @param args
	 *            the arguments
	 * @throws Exception
	 *             the exception
	 */
	public static void main(String[] args) throws Exception {

//		Database db = new Database();
//		 CouponSystem.getInstance().login("admin", "12345", null);

		 db.createDatabase();
		 String Sergey;
//		 db.dropDatabase();	
//		 db.createDatabase();
//		 db.dropDatabase();

//		AdminFacade af = new AdminFacade();
		// af.getCompany(11);
		// af.updateCompany(1L, 10L);
//		 Company c = new Company(123L, "Toyota", "password", "email");
//		 Company d = new Company(3L, "Trump ltd.", "1234", "gmail@gmail.com");
//		 af.createCompany(c);
//		  af.createCompany(d);
//		 af.removeCompany(0, 0, 123L);
//		  af.getCompany(123);
		  af.getAllCompanies();
//		  af.getCompanyByName("Toyota");
		  
		  
		  
		  
		  
		  
//		 CompanyFacade cf = new CompanyFacade();

//		Coupon coupon = new Coupon(2L, "A", "2020-01-01", "2021-01-01", 3,
//				"HEALTH", "WA", 200, "green");

//		 cf.createCoupon(123L, coupon);
//		 cf.removeCoupon(1L ,2L);
//		 cf.removeCouponCompany(2L);
//		CustomerFacade custf = new CustomerFacade();
//		Customer f = new Customer(1, "Jinji", "wawa", null);
//		 af.createCustomer(f);
//		custf.purchaseCoupon(1, coupon);

		// System.out.println(c.getCoupons());

		// cf.getAllCoupons();
		// adminFacade.getAllCompanies();


		// Company c1 = new Company(2L, "Robert ltd.", "1234", "gmail@gmail.com");
		//

		// adminFacade.updateCompany(c);
		//
		// System.out.println(c);


//		  db.createTable(db.sqlCompany);
//		  db.createTable(db.sqlCompany);
		 // database.createTable(database.sqlCompanyCoupon);
		 // Database.createTable(Database.sqlCoupon);
		 // Database.createTable(Database.sqlCompany);
		 // Database.createTable(Database.sqlCustomerCoupon);
	}

}
