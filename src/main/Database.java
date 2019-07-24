/*
 * 
 */
package main;

import java.sql.*;

// TODO: Auto-generated Javadoc
/**
 * The Class Database.
 */
public class Database {

	/** The con. */
	static Connection con = null;

	/** The Constant URL. */
	private static final String URL = "jdbc:mysql://localhost:3306/couponsystem?" +
			"useUnicode=true&useJDBCCompliantTimezoneShift=true&" +
			"useLegacyDatetimeCode=false&serverTimezone=GMT";

	/** The Constant userName. */
	private static final String userName = "root";

	/** The Constant password. */
	private static final String password = "1234";

	/** The sql company. */
	private String sqlCompany = 
			"CREATE TABLE Company (" +
			"id INT NOT NULL, " +
			"compName VARCHAR(30) NOT NULL, " +
			"password VARCHAR(12) NOT NULL, " +
			"email TEXT NOT NULL, " +
			"PRIMARY KEY (id), " +
			"UNIQUE (compName))";

	/** The sql customer. */
	private String sqlCustomer = "CREATE TABLE Customer (" +
			"id INT NOT NULL, " +
			"custName VARCHAR(50) NOT NULL, " +
			"password VARCHAR(12) NOT NULL, " +
			"PRIMARY KEY (id), " +
			"UNIQUE (custName))";

	/** The sql coupon. */
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

	/** The sql company coupon. */
	public static String sqlCompanyCoupon = "CREATE TABLE CompanyCoupon (" +
			"CompanyId INT NOT NULL, " +
			"CouponId INT NOT NULL, " +
//			"PRIMARY KEY (CompanyId, CouponId), " +
			"FOREIGN KEY (CompanyId) REFERENCES Company (id) ON UPDATE CASCADE, " +
			"FOREIGN KEY (CouponId) REFERENCES Coupon (id) ON UPDATE CASCADE)";

	/** The sql customer coupon. */
	public static String sqlCustomerCoupon = "CREATE TABLE CustomerCoupon (" +
			"CustId INT NOT NULL, " +
			"CouponId INT NOT NULL, " +
//			"PRIMARY KEY (CustId, CouponId), " +
			"FOREIGN KEY (CustId) REFERENCES Customer (id), " +
			"FOREIGN KEY (CouponId) REFERENCES Coupon (id))";

	/** The sql drop table company. */
	public String sqlDropTableCompany = "DROP TABLE Company";

	/** The sql drop table customer. */
	public String sqlDropTableCustomer = "DROP TABLE Customer";

	/** The sql drop table coupon. */
	public String sqlDropTableCoupon = "DROP TABLE Coupon";

	/** The sql drop table customer coupon. */
	public String sqlDropTableCustomerCoupon = "DROP TABLE customerCoupon";

	/** The sql drop table company coupon. */
	public String sqlDropTableCompanyCoupon = "DROP TABLE companyCoupon";

	/**
	 * Gets the user name.
	 *
	 * @return the user name
	 */
	public static String getUserName() {
		return userName;
	}

	/**
	 * Gets the password.
	 *
	 * @return the password
	 */
	public static String getPassword() {
		return password;
	}

	/**
	 * Gets the url.
	 *
	 * @return the url
	 */
	public static String getUrl() {
		return "jdbc:mysql://localhost:3306/couponsystem?" +
				"useUnicode=true&useJDBCCompliantTimezoneShift=true&" +
				"useLegacyDatetimeCode=false&serverTimezone=GMT";
	}

	/**
	 * Creates the table.
	 *
	 * @param sql
	 *            the sql
	 * @throws SQLException
	 *             the SQL exception
	 */
	public void createTable(String sql) throws SQLException {
		try {
			con = DriverManager.getConnection(URL, userName, password);
			PreparedStatement p = con.prepareStatement(sql);
			p.executeUpdate();
			System.out.println("Table created " + sql.toString());

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			if (con != null) {
				con.close();
			}
		}
	}

	/**
	 * Drop table.
	 *
	 * @param sql
	 *            the sql
	 * @throws SQLException
	 *             the SQL exception
	 */
	public void dropTable(String sql) throws SQLException {
		try {
			con = DriverManager.getConnection(URL, userName, password);
			PreparedStatement p = con.prepareStatement(sql);
			p.executeUpdate();
			System.out.println("Table dropped");

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			if (con != null) {
				con.close();
			}
		}
	}

	/**
	 * Creates the database.
	 *
	 * @throws SQLException
	 *             the SQL exception
	 */
	public void createDatabase() throws SQLException {
		System.out.println("Starting Database..");
		try {
			createTable(sqlCompany);
			createTable(sqlCoupon);
			createTable(sqlCustomer);
			createTable(sqlCompanyCoupon);
			createTable(sqlCustomerCoupon);
			System.out.println("Database ready");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			if (con != null) {
				con.close();
			}
		}
	}

	public void dropDatabase() throws SQLException {
		System.out.println("Starting..");
		dropTable(sqlDropTableCompanyCoupon);
		dropTable(sqlDropTableCustomerCoupon);
		dropTable(sqlDropTableCompany);
		dropTable(sqlDropTableCoupon);
		dropTable(sqlDropTableCustomer);

	}
}
