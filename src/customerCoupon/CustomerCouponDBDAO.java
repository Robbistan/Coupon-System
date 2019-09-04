/*
 * 
 */
package customerCoupon;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Map;

import coupon.Coupon;
import main.Database;

// TODO: Auto-generated Javadoc
/**
 * The Class CustomerCouponDBDAO.
 */
public class CustomerCouponDBDAO implements CustomerCouponDao {

	/*
	 * (non-Javadoc)
	 * 
	 * @see customerCoupon.CustomerCouponDao#getAllCustomerCoupons(long)
	 */
	@Override
	public Map<Long, Coupon> getAllCustomerCoupons(long id) throws Exception {
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see customerCoupon.CustomerCouponDao#insertCoupon(long, long)
	 */
	@Override
	public void insertCoupon(long customerId, long couponId) throws Exception {
		boolean flag = false;
		String sql = "INSERT INTO customerCoupon (CustId, CouponId) VALUES (?,?)";
		Connection con = null;
		try {
			con = DriverManager.getConnection(Database.getUrl(), Database.getUserName(), Database
					.getPassword());
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setLong(1, customerId);
			pstmt.setLong(2, couponId);
			pstmt.executeUpdate();
			System.out.println("Customer coupon created");
		} catch (SQLException e) {
			System.out.println(e.getSQLState());
			System.out.println(e.getLocalizedMessage());
			System.out.println(e.fillInStackTrace());
			System.out.println(e.getCause());
			System.out.println(e.getMessage());
		}
		if (con != null) {
			con.close();
		}
	}

	@Override
	public void removeCustomerCoupon(long customerId) throws Exception {
		Connection con = null;
		String sql = "DELETE FROM CustomerCoupon WHERE CustId= ?";
		try {
			con = DriverManager.getConnection(Database.getUrl(), Database.getUserName(), Database.getPassword());
			PreparedStatement p = con.prepareStatement(sql);
			p.setLong(1, customerId);
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

}
