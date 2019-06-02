package companyCoupon;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Set;

import company.Company;
import main.Database;

public class CompanyCouponDBDAO implements CompanyCouponDAO {

	@Override
	public void insertCompany(long couponId, long companyId) throws Exception {
		Connection con = DriverManager.getConnection(Database.getUrl(), Database.getUserName(), Database.getPassword());
		String sql = "INSERT INTO CompanyCoupon (CompanyId, CompanyCouponId)  VALUES (?,?)";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setLong(1, companyId);
			pstmt.setLong(2, couponId);

			pstmt.executeUpdate();
			System.out.println("Company coupon created");
		} catch (SQLException e) {
			e.getMessage();
		} finally {
			if (con != null) {
				con.close();
			}
		}
	}

	@Override
	public Set<Company> getAllCompanies() throws Exception {
		return null;
	}

}
