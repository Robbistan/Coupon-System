/** Company DbDAO - unfinished ! methods with Collections are not 
 * complete
 */

package company;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Hashtable;
import java.util.Map;

import coupon.Coupon;
import main.Database;

/**
 * The Class CompanyDBDAO.
 */
public class CompanyDBDAO implements CompanyDao {

	/** The connection. */
	Connection con;

	/*
	 * (non-Javadoc)
	 * 
	 * @see company.CompanyDao#createCompany(company.Company)
	 */
	@Override
	public void createCompany(Company company) throws Exception {
		String sql = "INSERT INTO Company (id, compName, password, email)" +
					 "VALUES(?,?,?,?)";
		try {
			con = DriverManager.getConnection(Database.getUrl(), Database.getUserName(), Database.getPassword());
			PreparedStatement p = con.prepareStatement(sql);

			p.setLong(1, company.getId());
			p.setString(2, company.getCompName());
			p.setString(3, company.getPassword());
			p.setString(4, company.getEmail());
			p.executeUpdate();

			System.out.println("Company created : " + company);

		} catch (SQLException e) {
			System.out.print("Company already exists : ");
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
	 * @see company.CompanyDao#removeCompany(long)
	 */
	@Override
	public void removeCompany(long id) throws SQLException {
		String sql = "DELETE FROM Company WHERE id = ?";

		try {
			con = DriverManager.getConnection(Database.getUrl(), Database.getUserName(), Database.getPassword());
			PreparedStatement p = con.prepareStatement(sql);
			// con.setAutoCommit(false);
			p.setLong(1, id);
			int result = p.executeUpdate();
			if (result == 0) {
				System.out.println("Delete failed - Company doesn't exist");
			} else {
				System.out.println("Company deleted");
			}
		}
		// con.commit();
		catch (SQLException e) {
			System.out.println(e.getMessage());
			// try {
			// con.rollback();
			// } catch (SQLException e1) {
			// throw new Exception("Database error");
			// }
			// throw new Exception("failed to remove company");
		} finally {
			if (con != null) {
				con.close();
			}
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see company.CompanyDao#updateCompany(long, long)
	 */
	@Override
	public void updateCompany(long idOld, long idNew) throws SQLException {
		String sql = "UPDATE Company SET id = ? WHERE id = ?";
		try {
			con = DriverManager.getConnection(Database.getUrl(), Database.getUserName(), Database.getPassword());
			PreparedStatement p = con.prepareStatement(sql);

			p.setLong(1, idNew);
			p.setLong(2, idOld);
			int result = p.executeUpdate();

			if (result == 0) {
				System.out.println("Update failed - id not found");
			} else {
				System.out.println("Company updated successfuly");
			}
		} catch (SQLException e) {
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
	 * @see company.CompanyDao#getCompany(long)
	 */
	@Override
	public Company getCompany(long id) throws SQLException {
		String sql = "SELECT * FROM Company WHERE id = ?";
		Company company = new Company();

		try {
			con = DriverManager.getConnection(Database.getUrl(), Database.getUserName(), Database.getPassword());
			PreparedStatement p = con.prepareStatement(sql);

			p.setLong(1, id);
			ResultSet rs = p.executeQuery();
			rs.next();
			company.setId(rs.getLong(1));
			company.setCompName(rs.getString(2));
			company.setPassword(rs.getString(3));
			company.setEmail(rs.getString(4));
			System.out.print("Company details : " + company);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			if (con != null) {
				con.close();
			}
		}
		return company;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see company.CompanyDao#getAllCompanies()
	 */
	@Override
	public Map<Long, Company> getAllCompanies() throws Exception {
		Map<Long, Company> m = new Hashtable<>();
		String sql = "SELECT * FROM Company ";

		try {
			con = DriverManager.getConnection(Database.getUrl(), Database.getUserName(), Database.getPassword());
			PreparedStatement p = con.prepareStatement(sql);
			ResultSet rs = p.executeQuery();
			while (rs.next()) {
				long id = rs.getLong(1);
				String compName = rs.getString(2);
				String password = rs.getString(3);
				String email = rs.getString(4);
				Company aa = new Company(id, compName, password, email);
				long counter = 0;
				m.put(++counter, aa);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			throw new Exception("cannot get Company data");
		} finally {
			if (con != null) {
				con.close();
			}
		}
		System.out.print(m);
		return m;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see company.CompanyDao#getCouponsByCompName(java.lang.String)
	 */
	@Override
	public Map<Long, Coupon> getCouponsByCompName(String compName) throws Exception {

		con = DriverManager.getConnection(Database.getUrl(), Database.getUserName(), Database.getPassword());
		Map<Long, Coupon> m = new Hashtable<>();
		String sql = "SELECT * FROM Company WHERE compName = " + compName;

		try {
			PreparedStatement p = con.prepareStatement(sql);
			ResultSet rs = p.executeQuery(sql);
			while (rs.next()) {
				Coupon coupon = new Coupon();
				coupon.setId(rs.getLong(1));
				coupon.setTitle(rs.getString(2));
				coupon.setStartDate(rs.getString(3));
				coupon.setEndDate(rs.getString(4));
				coupon.setAmount(rs.getInt(5));
				coupon.setType(rs.getString(6));

				m.put(rs.getLong(1), coupon);
			}
		} catch (SQLException e) {
			System.out.println(e);
			throw new Exception("cannot get Coupon data");
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
	 * @see company.CompanyDao#login(java.lang.String, java.lang.String)
	 */
	@Override
	public boolean login(String compName, String password) {

		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see company.CompanyDao#getCompanyByName(java.lang.String)
	 */
	@Override
	public Company getCompanyByName(String name) throws SQLException {
		String sql = "SELECT * FROM Company WHERE compName = ?";
		Company company = new Company();

		try {
			con = DriverManager.getConnection(Database.getUrl(), Database.getUserName(), Database.getPassword());
			PreparedStatement p = con.prepareStatement(sql);
			p.setString(1, name);
			ResultSet rs = p.executeQuery();
			while (rs.next()) {
				company.setId(rs.getLong(1));
				company.setCompName(rs.getString(2));
				company.setPassword(rs.getString(3));
				company.setEmail(rs.getString(4));
				System.out.print("Company details : " + company);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			if (con != null) {
				con.close();
			}
		}
		return company;
	}
	
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


}
