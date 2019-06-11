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

	@Override
	public void removeCompany(long id) throws SQLException {
		con = DriverManager.getConnection(Database.getUrl(), Database.getUserName(), Database.getPassword());
		String sql = "DELETE FROM Company WHERE id = ?";

		try {
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
			e.printStackTrace();
			// System.out.println(e.getMessage());
		} finally {
			if (con != null) {
				con.close();
			}
		}
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
