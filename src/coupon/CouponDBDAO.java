/*
 * 
 */
package coupon;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.SQLWarning;
import java.sql.Statement;
import java.util.*;

import main.Database;

// TODO: Auto-generated Javadoc
/**
 * The Class CouponDBDAO.
 */
public class CouponDBDAO implements CouponDao {

	/** The connection. */
	Connection con;

	/*
	 * (non-Javadoc)
	 * 
	 * @see coupon.CouponDao#insertCoupon(coupon.Coupon)
	 */
	@Override
	public boolean createCoupon(Coupon coupon) throws Exception {
		boolean flag = false;
		String sql = "INSERT INTO Coupon (id, title, startDate, endDate, amount, couponType, message, price, image) "
				+ "VALUES(?,?,?,?,?,?,?,?,?)";
		try {
			con = DriverManager.getConnection(Database.getUrl(), Database.getUserName(), Database.getPassword());
			PreparedStatement p = con.prepareStatement(sql);
			p.setLong(1, coupon.getCouponId());
			p.setString(2, coupon.getTitle());
			p.setString(3, coupon.getStartDate());
			p.setString(4, coupon.getEndDate());
			p.setLong(5, coupon.getAmount());
			p.setString(6, coupon.getType().toString());
			p.setString(7, coupon.getMessage());
			p.setDouble(8, coupon.getPrice());
			p.setString(9, coupon.getImage());
			p.executeUpdate();
			flag = true;
			System.out.println("Coupon created : " + coupon);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			if (con != null) {
				con.close();
			}
		}
		return flag;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see coupon.CouponDao#removeCoupon(long)
	 */
	@Override
	public void removeCoupon(long couponId) throws Exception {
		String sql = "DELETE FROM Coupon WHERE id=?";
		try {
			con = DriverManager.getConnection(Database.getUrl(), Database.getUserName(), Database.getPassword());
			PreparedStatement p = con.prepareStatement(sql);
			p.setLong(1, couponId);
			int result = p.executeUpdate();
			if (result == 0) {
				System.out.println("Delete failed - Coupon doesn't exist");
			} else {
				System.out.println("Coupon deleted");
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			if (con != null) {
				con.close();
			}
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see coupon.CouponDao#updateCoupon(coupon.Coupon)
	 */
	@Override
	public void updateCoupon(Coupon coupon) throws Exception {
		String sql = "UPDATE Coupon " + " SET couponName ='" + coupon.getTitle() + "', startDate = '"
				+ coupon.getStartDate() + "', endDate = " + coupon.getEndDate() + "', amount = '" + coupon.getAmount()
				+ "', type = '" + coupon.getType() + "', message = '" + coupon.getMessage() + "', price = '"
				+ coupon.getPrice() + "', image = '" + coupon.getImage() + "' WHERE ID = " + coupon.getCouponId();
		try {
			PreparedStatement p = con.prepareStatement(sql);
			con = DriverManager.getConnection(Database.getUrl(), Database.getUserName(), Database.getPassword());
			p.executeUpdate();
		} catch (SQLException e) {
			throw new Exception("update Company failed");
		} finally {
			if (con != null) {
				con.close();
			}
		}
	}

	/**
	 * Update coupon amount.
	 *
	 * @param amount
	 *            the amount
	 * @param id
	 *            the id
	 * @return true, if successful
	 * @throws Exception
	 *             the exception
	 */
	public boolean updateCouponAmount(long couponId) throws Exception {
		boolean flag = false;
		try {
			con = DriverManager.getConnection(Database.getUrl(), Database.getUserName(), Database.getPassword());
			String sql = "UPDATE Coupon SET amount = amount - 1 WHERE id = ? AND amount > 0";
			PreparedStatement p = con.prepareStatement(sql);
			// p.setInt(1, amount);
			p.setLong(1, couponId);
			int count = p.executeUpdate();
			if (count > 0) {
				flag = true;
			} else {
				throw new Exception("Cannot purchase coupon");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (con != null) {
				con.close();
			}
		}
		return flag;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see coupon.CouponDao#getCoupon(long)
	 */
	@Override
	public Coupon getCoupon(long id) throws Exception {
		Coupon coupon = new Coupon();
		String sql = "SELECT * FROM Coupon WHERE ID = " + id;
		try {
			con = DriverManager.getConnection(Database.getUrl(), Database.getUserName(), Database.getPassword());
			PreparedStatement p = con.prepareStatement(sql);
			ResultSet rs = p.executeQuery(sql);
			rs.next();
			coupon.setId(rs.getLong(1));
			coupon.setTitle(rs.getString(2));
			coupon.setStartDate(rs.getString(3));
			coupon.setEndDate(rs.getString(4));
			coupon.setAmount(rs.getInt(5));
			coupon.setType(rs.getString(6));

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			if (con != null) {
				con.close();
			}
		}
		return coupon;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see coupon.CouponDao#getAllCoupons()
	 */
	@Override
	public Map<Long, Coupon> getAllCoupons() throws Exception {
		Map<Long, Coupon> m = new Hashtable<>();
		String sql = "SELECT * FROM Coupon";
		try {
			con = DriverManager.getConnection(Database.getUrl(), Database.getUserName(), Database.getPassword());
			PreparedStatement p = con.prepareStatement(sql);
			ResultSet rs = p.executeQuery();
			while (rs.next()) {
				long counter = 0;
				Coupon coupon = new Coupon();
				coupon.setId(rs.getLong(1));
				coupon.setTitle(rs.getString(2));
				coupon.setStartDate(rs.getString(3));
				coupon.setEndDate(rs.getString(4));
				coupon.setAmount(rs.getInt(5));
				coupon.setType(rs.getString(6));
				m.put(++counter, coupon);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			if (con != null) {
				con.close();
			}
		}
		System.out.println(m);
		return m;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see coupon.CouponDao#getCouponByType(coupon.CouponType)
	 */
	@Override
	public Map<Long, Coupon> getCouponByType(String type) throws Exception {
		Map<Long, Coupon> m = new Hashtable<>();
		String sql = "SELECT * FROM Coupon WHERE couponType =" + type;
		try {
			con = DriverManager.getConnection(Database.getUrl(), Database.getUserName(), Database.getPassword());
			PreparedStatement p = con.prepareStatement(sql);
			ResultSet rs = p.executeQuery();
			while (rs.next()) {
				long counter = 0;
				Coupon coupon = new Coupon();
				coupon.setId(rs.getLong(1));
				coupon.setTitle(rs.getString(2));
				coupon.setStartDate(rs.getString(3));
				coupon.setEndDate(rs.getString(4));
				coupon.setAmount(rs.getInt(5));
				coupon.setType(rs.getString(6));
				m.put(++counter, coupon);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			if (con != null) {
				con.close();
			}
		}
		System.out.println(m);
		return m;

	}

	public void insertCouponIntoCompanyCouponTable(long companyId, long couponId) throws Exception {
		String sql = "INSERT INTO CompanyCoupon (CompanyId, CouponId)  VALUES(?,?)";
		try {
			con = DriverManager.getConnection(Database.getUrl(), "root", "1234");
			PreparedStatement p = con.prepareStatement(sql);
			p.setLong(1, companyId);
			p.setLong(2, couponId);
			p.executeUpdate();
			System.out.println("Company coupon added");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			con.close();
		}
	}

	public void insertCouponIntoCustomerCouponTable(long custId, long couponId) throws Exception {
		String sql = "INSERT INTO CustomerCoupon (CustId, CouponId)  VALUES(?,?)";
		try {
			con = DriverManager.getConnection(Database.getUrl(), "root", "1234");
			PreparedStatement p = con.prepareStatement(sql);
			p.setLong(1, custId);
			p.setLong(2, couponId);
			p.executeUpdate();
			System.out.println("Customer coupon added");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			con.close();
		}
	}
}