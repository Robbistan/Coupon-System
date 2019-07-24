/*
 * 
 */
package companyCoupon;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.Set;

import company.Company;
import coupon.Coupon;
import coupon.CouponDBDAO;
import main.Database;

// TODO: Auto-generated Javadoc
/**
 * The Class CompanyCouponDBDAO.
 */
public class CompanyCouponDBDAO implements CompanyCouponDAO {

	/** The coupon DBDAO. */
	private CouponDBDAO couponDBDAO = new CouponDBDAO();

	/*
	 * (non-Javadoc)
	 * 
	 * @see companyCoupon.CompanyCouponDAO#insertCompany(long, long)
	 */
	@Override
	public void createCoupon(long companyId, long couponId) throws Exception {
		Connection con = DriverManager.getConnection(Database.getUrl(), Database.getUserName(), Database.getPassword());
		String sql = "INSERT INTO CompanyCoupon (CompanyId, CouponId)  VALUES (?,?)";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setLong(1, companyId);
			pstmt.setLong(2, couponId);
			pstmt.executeUpdate();
			System.out.println("Company coupon created");
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see companyCoupon.CompanyCouponDAO#getAllCompanyCoupons(long)
	 */
	@Override
	public Map<Long, Coupon> getAllCompanyCoupons(long id) throws Exception {
		Map<Long, Coupon> m = new Hashtable<>();
		Connection con = DriverManager.getConnection(Database.getUrl(), Database.getUserName(), Database.getPassword());
		String sql = "SELECT * FROM companycoupon WHERE CompanyId = ?";
		try {
			PreparedStatement p = con.prepareStatement(sql);
			p.setLong(1, id);
			ResultSet rs = p.executeQuery();
			if (rs.next()) {
				do {
					long couponId = rs.getLong(2);
					Coupon c = couponDBDAO.getCoupon(couponId);
					m.put(couponId, c);
				} while (rs.next());
			} else {
				throw new Exception("No coupons");
			}
		} catch (SQLException e) {
			e.getMessage();
		} finally {
			if (con != null) {
				con.close();
			}
		}
		System.out.println(m);
		return m;
	}
}
