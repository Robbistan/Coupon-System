package main;

import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.Properties;

import company.Company;
import coupon.Coupon;
import facades.AdminFacade;
import facades.CompanyFacade;

public class Test {

	public static void main(String[] args) throws Exception {

		Database db = new Database();
//		db.createTable(db.sqlCustomerCoupon);
//		db.createTable(db.sqlCompanyCoupon);
		
		
		
		
//		AdminFacade af = new AdminFacade();
		CompanyFacade cf = new CompanyFacade();
//		db.createDatabase();

		// db.createTable(db.sqlCoupon);
		// db.dropTable(db.sqlDropTableCompany);
		// db.dropTable(db.sqlDropTableCoupon);
		// db.dropTable(db.sqlDropTableCustomer);
//		 Company c = new Company(124, "TATATT", "shinjan", "email", null);
//		 af.createCompany(c);
		// System.out.println(c.getCoupons());
		// database.createTable(database.sqlCompanyCoupon);
		// Database.createTable(Database.sqlCoupon);
		// Database.createTable(Database.sqlCompany);
		// Database.createTable(Database.sqlCustomerCoupon);
		 Coupon c = new Coupon(5, "INDICA", "2020-01-01", "2021-01-01", 3, "HEALTH","WA", 200, "green");
		 cf.insertCoupon(c);

		// cf.getAllCoupons();
		// adminFacade.getAllCompanies();

		// adminFacade.getCompany(1);

		// Company c = new Company(2L, "Robert ltd.", "1234", "gmail@gmail.com");
		// Company d = new Company(3L, "Trump ltd.", "1234", "gmail@gmail.com");
		//
		// adminFacade.createCompany(c);
		// adminFacade.createCompany(d);

		// adminFacade.updateCompany(c);
		//
		// System.out.println(c);
		// database.createTable(database.sqlCompany);

		// database.createTable(Database.sqlCompany);

	}

}
