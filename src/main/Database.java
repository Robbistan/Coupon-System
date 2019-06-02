package main;

import java.sql.*;

public class Database {

	Connection con = null;
	 
	private static final String URL = "jdbc:mysql://localhost:3306/couponsystem?"+ 
									  "useUnicode=true&useJDBCCompliantTimezoneShift=true&"+ 
									  "useLegacyDatetimeCode=false&serverTimezone=GMT";

	private static final String userName = "root";

	private static final String password = "1234";

	private String sqlCompany = "CREATE TABLE Company (" + 
						    	"id INT NOT NULL, " + 
						 	    "compName VARCHAR(30) NOT NULL, " + 
						 	    "password VARCHAR(12) NOT NULL, " + 
							    "email TEXT NOT NULL, " +
								"PRIMARY KEY (id), " +
								"UNIQUE (compName))";

	private String sqlCustomer = "CREATE TABLE Customer (" + 
			    						"id INT NOT NULL, " + 
			    						"custName VARCHAR(50) NOT NULL, " + 
			    						"password VARCHAR(12) NOT NULL, " +
			    						"PRIMARY KEY (id), " +	
			    						"UNIQUE (custName))";

	public String sqlCoupon = "CREATE TABLE Coupon (" + 
							  "id INT NOT NULL, " + 
							  "title VARCHAR(50) NOT NULL, " + 
							  "startDate DATE NOT NULL, " + 
							  "endDate DATE NOT NULL, " + 
							  "amount INT, " + 
							  "couponType ENUM ('CAMPING', 'ELECTRICITY', 'FOOD', 'HEALTH', " + 
			  				  "'RESTAURANTS', 'SPORTS', 'TRAVELLING') NOT NULL, " + 
							  "message TEXT, " + 
							  "price DOUBLE, " + 
							  "image TEXT, " +
							  "PRIMARY KEY (id), " +
						      "UNIQUE (title))";

	public static String sqlCompanyCoupon = "CREATE TABLE CompanyCoupon (" + 
											"CompanyId INT NOT NULL, "+ 
											"CouponId INT NOT NULL, "+ 
											"FOREIGN KEY (CompanyId) REFERENCES Company (id) on delete cascade,"+ 
											"FOREIGN KEY (CouponId) REFERENCES Coupon (id) on delete cascade, "+ 
											"PRIMARY KEY (CompanyId , CouponId) )";

	public static String sqlCustomerCoupon = "CREATE TABLE CustomerCoupon (" + 
											 "CustId INT NOT NULL, " + 
											 "CouponId INT NOT NULL, " + 
											 "FOREIGN KEY (CustId) references Customer (id) on delete cascade, " + 
											 "FOREIGN KEY (CouponId) references Coupon (id) on delete cascade, " + 
											 "PRIMARY KEY (CustId , CouponId) )";

	public String sqlDropTableCompany = "DROP TABLE Company";
	public String sqlDropTableCustomer = "DROP TABLE Customer";
	public String sqlDropTableCoupon = "DROP TABLE Coupon";
	public String sqlDropTableCustomerCoupon = "DROP TABLE customerCoupon";
	public String sqlDropTableCompanyCoupon = "DROP TABLE companyCoupon";


	public static String getUserName() {
		return userName;
	}

	public static String getPassword() {
		return password;
	}
	
	public static String getUrl() {
		return "jdbc:mysql://localhost:3306/couponsystem?"+ 
				"useUnicode=true&useJDBCCompliantTimezoneShift=true&"+ 
				"useLegacyDatetimeCode=false&serverTimezone=GMT";
	}	
	
	public void createTable(String sql) throws SQLException {
		try {
			con = DriverManager.getConnection(URL, userName, password);
			PreparedStatement p = con.prepareStatement(sql);
			p.executeUpdate();
			System.out.println("Table created " + sql);
		} 
		catch (SQLException e) {
			System.out.println(e.getMessage());
		} 
		finally {
			if (con != null) {
				con.close();
			}
		}
	}

	public void dropTable(String sql) throws SQLException {
		try {
			con = DriverManager.getConnection(URL, userName, password);
			PreparedStatement p = con.prepareStatement(sql);
			p.executeUpdate();
			System.out.println("Table dropped");
		} 
		catch (Exception e) {
			e.getMessage();
		} 
		finally {
			if (con != null) {
				con.close();
			}
		}
	}
	
	public void createDatabase() throws SQLException {
		System.out.println("Starting Database..");
		try {
			createTable(sqlCompany);
			createTable(sqlCoupon);
			createTable(sqlCustomer);
		}
		catch (Exception e) {
			e.getMessage();
		}
		finally {
			if (con != null) {
				con.close();
			}
		}
		System.out.println("Database ready");
	}
}