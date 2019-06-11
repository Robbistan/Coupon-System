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
import java.util.HashSet;
import java.util.Set;
import java.util.*;

import main.Database;

public class CouponDBDAO implements CouponDao {

	Connection con;

	@Override
	public void insertCoupon(Coupon coupon) throws Exception {
		String sql = "INSERT INTO Coupon (id, title, startDate, endDate, amount, couponType, message, price, image)  VALUES(?,?,?,?,?,?,?,?,?)";
		try {
			con = DriverManager.getConnection(Database.getUrl(), Database.getUserName(), Database.getPassword());
			PreparedStatement p = con.prepareStatement(sql);
			p.setLong(1, coupon.getId());
			p.setString(2, coupon.getTitle());
			p.setString(3, coupon.getStartDate());
			p.setString(4, coupon.getEndDate());
			p.setLong(5, coupon.getAmount());
			p.setString(6, coupon.getType());
			p.setString(7, coupon.getMessage());
			p.setDouble(8, coupon.getPrice());
			p.setString(9, coupon.getImage());
			p.executeUpdate();
			System.out.println("Coupon created : " + coupon);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			if (con != null) {
				con.close();
			}
		}
	}

	@Override
	public void removeCoupon(int id) throws Exception {
		String sql = "DELETE FROM Coupon WHERE id=?";
		try {
			con = DriverManager.getConnection(Database.getUrl(), Database.getUserName(), Database.getPassword());
			PreparedStatement p = con.prepareStatement(sql);
			p.setInt(1, id);
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

	@Override
	public void updateCoupon(Coupon coupon) throws Exception {
		String sql = "UPDATE Coupon " + " SET couponName ='" + coupon.getTitle() + "', startDate = '"
				+ coupon.getStartDate() + "', endDate = " + coupon.getEndDate() + "', amount = '" + coupon.getAmount()
				+ "', type = '" + coupon.getType() + "', message = '" + coupon.getMessage() + "', price = '"
				+ coupon.getPrice() + "', image = '" + coupon.getImage() + "' WHERE ID = " + coupon.getId();
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

	@Override
	public Coupon getCoupon(int id) throws Exception {
		con = DriverManager.getConnection(Database.getUrl(), Database.getUserName(), Database.getPassword());
		Coupon coupon = new Coupon();
		try (PreparedStatement pstmt = (PreparedStatement) con.createStatement()) {
			String sql = "SELECT * FROM Coupon WHERE ID = " + id;
			ResultSet rs = pstmt.executeQuery(sql);
			rs.next();
			coupon.setId(rs.getInt(1));
			coupon.setTitle(rs.getString(2));
			coupon.setStartDate(rs.getString(3));
			coupon.setEndDate(rs.getString(4));
			coupon.setAmount(rs.getInt(5));
			coupon.setType(rs.getString(6));

		} catch (SQLException e) {
			throw new Exception("unable to get product data");
		} finally {
			if (con != null) {
				con.close();
			}
		}
		return coupon;
	}

	@Override
	public Set<Coupon> getAllCoupons() throws Exception {
		con = DriverManager.getConnection(Database.getUrl(), Database.getUserName(), Database.getPassword());
		Set<Coupon> set = new HashSet<>();
		String sql = "SELECT * FROM Coupon";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				Coupon coupon = new Coupon();
				coupon.setId(rs.getInt(1));
				coupon.setTitle(rs.getString(2));
				coupon.setStartDate(rs.getString(3));
				coupon.setEndDate(rs.getString(4));
				coupon.setAmount(rs.getInt(5));
				coupon.setType(rs.getString(6));

				set.add(coupon);
			}
		} catch (SQLException e) {
			System.out.println(e);
			throw new Exception("cannot get Coupon data");
		} finally {
			if (con != null) {
				con.close();
			}
		}
		System.out.println(set);
		return set;

	}

	@Override
	public Set<Coupon> getCouponByType(CouponType couponType) throws Exception {
		con = DriverManager.getConnection(Database.getUrl(), Database.getUserName(), Database.getPassword());
		Set<Coupon> set = new HashSet<>();
		String sql = "SELECT * FROM Coupon WHERE couponType =" + couponType;
		try (PreparedStatement pstmt = (PreparedStatement) con.createStatement();
				ResultSet rs = pstmt.executeQuery(sql)) {
			while (rs.next()) {
				Coupon coupon = new Coupon();
				coupon.setId(rs.getInt(1));
				coupon.setTitle(rs.getString(2));
				coupon.setStartDate(rs.getString(3));
				coupon.setEndDate(rs.getString(4));
				coupon.setAmount(rs.getInt(5));
				coupon.setType(rs.getString(6));

				set.add(coupon);
			}
		} catch (SQLException e) {
			System.out.println(e);
			throw new Exception("cannot get Coupon data");
		} finally {
			if (con != null) {
				con.close();
			}
		}
		System.out.println(set);
		return set;

	}
}
