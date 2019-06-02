/** Company DbDAO - unfinished ! methods with Collections are not 
 * complete
 */

package company;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Set;

import coupon.Coupon;
import main.Database;

public class CompanyDBDAO implements CompanyDao {

	Connection con;

	@Override
	public void createCompany(Company company) throws SQLException {
		String sql = "INSERT INTO Company (id, compName, password, email)  VALUES(?,?,?,?)";
		try {
			con = DriverManager.getConnection(Database.getUrl(), Database.getUserName(), Database.getPassword());
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setLong(1, company.getId());
			pstmt.setString(2, company.getCompName());
			pstmt.setString(3, company.getPassword());
			pstmt.setString(4, company.getEmail());

			pstmt.executeUpdate();
			System.out.println("Company created : " + company);
		} catch (SQLException e) {
			if (e instanceof SQLIntegrityConstraintViolationException) {
				System.out.println("duplicate company name");
			} else {
				System.out.println(e.getMessage());
			}
		} finally {
			if (con != null) {
				con.close();
			}
		}
	}

	@Override
	public void removeCompany(Company company) throws Exception {
		con = DriverManager.getConnection(Database.getUrl(), Database.getUserName(), Database.getPassword());
		String sql = "DELETE FROM Company WHERE id = ?";

		try (PreparedStatement pstm1 = con.prepareStatement(sql)) {
			// con.setAutoCommit(false);
			pstm1.setLong(1, company.getId());
			pstm1.executeUpdate();
			// con.commit();
		} catch (SQLException e) {
			e.getMessage();
			// try {
			// con.rollback();
			// } catch (SQLException e1) {
			// throw new Exception("Database error");
			// }
			throw new Exception("failed to remove company");
		} finally {
			if (con != null) {
				con.close();
			}
		}
	}

	@Override
	public void updateCompany(Company company) throws Exception {
		String sql = "UPDATE Company" + " SET compName ='" + company.getCompName() + "', password = '"
				+ company.getPassword() + "', email = '" + company.getEmail() + "' WHERE ID = " + company.getId();
		try {
			con = DriverManager.getConnection(Database.getUrl(), Database.getUserName(), Database.getPassword());
			Statement stm = con.createStatement();
			stm.executeUpdate(sql);
		} catch (SQLException e) {
			System.out.println(e);
			throw new Exception("update Company failed");
		} finally {
			con.close();
		}
		System.out.println("Company updated successfuly");
	}

	@Override
	public Company getCompany(int id) throws Exception {
		con = DriverManager.getConnection(Database.getUrl(), Database.getUserName(), Database.getPassword());
		Company company = new Company();
		try {
			Statement stm = con.createStatement(); 
			String sql = "SELECT * FROM Company WHERE id = " + id;
			ResultSet rs = stm.executeQuery(sql);
			rs.next();
			company.setId(rs.getLong(1));
			company.setCompName(rs.getString(2));
			company.setPassword(rs.getString(3));
			company.setEmail(rs.getString(4));

		} catch (SQLException e) {
			throw new Exception("unable to get Company data");
		} finally {
			con.close();
		}
		System.out.println(company);
		return company;
	}

	@Override
	public synchronized Set<Company> getAllCompanies() throws Exception {
		con = DriverManager.getConnection(Database.getUrl(), Database.getUserName(), Database.getPassword());
		Set<Company> set = new HashSet<>();
		String sql = "SELECT * FROM Company ";
		try (Statement stm = con.createStatement(); ResultSet rs = stm.executeQuery(sql)) {
			while (rs.next()) {
				long id = rs.getLong(1);
				String compName = rs.getString(2);
				String password = rs.getString(3);
				String email = rs.getString(4);
				set.add(new Company(id, compName, password, email, null));
			}
			System.out.println(set);
		} catch (SQLException e) {
			System.out.println(e);
			throw new Exception("cannot get Company data");
		} finally {
			if (con != null) {
				con.close();
			}
		}
		System.out.println();
		return set;
	}

	@Override
	public Set<Coupon> getCouponsByCompName(String compName) throws Exception {

		con = DriverManager.getConnection(Database.getUrl(), Database.getUserName(), Database.getPassword());
		Set<Coupon> set = new HashSet<>();
		try (Statement stm = con.createStatement()) {
			String sql = "SELECT * FROM Company WHERE compName = " + compName;
			ResultSet rs = stm.executeQuery(sql);
			while (rs.next()) {
				Coupon coupon = new Coupon();
				coupon.setId(rs.getLong(1));
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
			con.close();
		}
		System.out.println(set);
		return set;

	}

	@Override
	public boolean login(String compName, String password) {

		return false;
	}

}
