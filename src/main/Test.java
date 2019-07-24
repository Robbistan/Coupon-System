/*
 * 
 */
package main;

import company.Company;
import coupon.Coupon;
import coupon.CouponType;
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

		Database db = new Database();
		// CouponSystem.getInstance().login("admin", "12345", null);

//		 db.createDatabase();
//		 db.dropDatabase();	

		AdminFacade af = new AdminFacade();
		// af.getCompany(11);
		// af.updateCompany(1L, 10L);
		Company c = new Company(123, "Toyota", "password", "email");
//		 af.createCompany(c);
		 
		CompanyFacade cf = new CompanyFacade();
		
		Coupon coupon = new Coupon(1, "l", "2020-01-01", "2021-01-01", 3, "HEALTH","WA", 200, "green");

		cf.createCoupon(1L, coupon);
//		 cf.removeCoupon(1);

		// af.getAllCompanies();
		// af.removeCompany(10L);

		// cf.removeCoupon(5);
		// CustomerFacade custf = new CustomerFacade();
		// System.out.println(c.getCoupons());
		// database.createTable(database.sqlCompanyCoupon);
		// Database.createTable(Database.sqlCoupon);
		// Database.createTable(Database.sqlCompany);
		// Database.createTable(Database.sqlCustomerCoupon);

		// cf.getAllCoupons();
		// adminFacade.getAllCompanies();

		// adminFacade.getCompany(1);

		// Company c1 = new Company(2L, "Robert ltd.", "1234", "gmail@gmail.com");
		// Company d = new Company(3L, "Trump ltd.", "1234", "gmail@gmail.com");
		//
		// adminFacade.createCompany(d);

		// adminFacade.updateCompany(c);
		//
		// System.out.println(c);
		// database.createTable(database.sqlCompany);

		// database.createTable(Database.sqlCompany);

	}

}
