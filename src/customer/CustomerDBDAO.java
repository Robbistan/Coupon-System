/** Customer DbDAO - unfinished ! missing methods where collections are 
 * concerned.
 */

package customer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Map;
import java.util.Set;

import company.Company;
import coupon.Coupon;
import main.Database;

// TODO: Auto-generated Javadoc
/**
 * The Class CustomerDBDAO.
 */
public class CustomerDBDAO implements CustomerDao {

	/** The connection */
	Connection con;

	/* (non-Javadoc)
	 * @see customer.CustomerDao#createCustomer(customer.Customer)
	 */
	@Override
	public void createCustomer(Customer customer) throws Exception {
		con = DriverManager.getConnection(Database.getUrl(), Database.getUserName(), Database.getPassword());
		String sql = "INSERT INTO Customer (id, custName, password)  VALUES(?,?,?)";
		try (PreparedStatement pstmt = con.prepareStatement(sql)) {

			pstmt.setLong(1, customer.getId());
			pstmt.setString(2, customer.getCustName());
			pstmt.setString(3, customer.getPassword());

			pstmt.executeUpdate();
			System.out.println("customer created : " + customer.toString());
		} catch (SQLException e) {
			throw new Exception("customer creation failed");
		} finally {
			con.close();
		}
	}

	/* (non-Javadoc)
	 * @see customer.CustomerDao#removeCustomer(customer.Customer)
	 */
	@Override
	public void removeCustomer(Customer customer) throws Exception {
		con = DriverManager.getConnection(Database.getUrl(), Database.getUserName(), Database.getPassword());
		String sql = "DELETE FROM Customer WHERE id = ?";

		try (PreparedStatement pstm1 = con.prepareStatement(sql);) {
			con.setAutoCommit(false);
			pstm1.setLong(1, customer.getId());
			pstm1.executeUpdate();
			con.commit();
		} catch (SQLException e) {
			try {
				con.rollback();
			} catch (SQLException e1) {
				throw new Exception("Database error");
			}
			throw new Exception("failed to remove customer");
		} finally {
			con.close();
		}
	}

	/* (non-Javadoc)
	 * @see customer.CustomerDao#updateCustomer(customer.Customer)
	 */
	@Override
	public void updateCustomer(Customer customer) throws Exception {
		con = DriverManager.getConnection(Database.getUrl(), Database.getUserName(), Database.getPassword());
		try (Statement stm = con.createStatement()) {
			String sql = "UPDATE customer " + " SET compName ='" + customer.getCustName() + "', password = '"
					+ customer.getPassword() + "', email = " + "' WHERE ID = " + customer.getId();
			stm.executeUpdate(sql);
		} catch (SQLException e) {
			throw new Exception("update Company failed");
		}
	}

	/* (non-Javadoc)
	 * @see customer.CustomerDao#getCustomer(long)
	 */
	@Override
	public Customer getCustomer(long id) throws Exception {
		con = DriverManager.getConnection(Database.getUrl(), Database.getUserName(), Database.getPassword());
		Customer customer = new Customer();
		try (Statement stm = con.createStatement()) {
			String sql = "SELECT * FROM Customer WHERE ID=" + id;
			ResultSet rs = stm.executeQuery(sql);
			rs.next();
			customer.setId(rs.getLong(1));
			customer.setCustName(rs.getString(2));
			customer.setPassword(rs.getString(3));

		} catch (SQLException e) {
			throw new Exception("unable to get Customer data");
		} finally {
			con.close();
		}
		return customer;
	}

	/* (non-Javadoc)
	 * @see customer.CustomerDao#getAllCustomers()
	 */
	@Override
	public Map<Long,Customer> getAllCustomers() throws Exception {
		con = DriverManager.getConnection(Database.getUrl(), Database.getUserName(), Database.getPassword());
		Map<Long,Customer> m = new Hashtable<>();
		String sql = "SELECT * FROM Customer ";
		try (Statement stm = con.createStatement(); ResultSet rs = stm.executeQuery(sql)) {
			while (rs.next()) {
				Customer customer = new Customer();
				customer.setId(rs.getLong(1));
				customer.setCustName(rs.getString(2));
				customer.setPassword(rs.getString(3));

				m.put(rs.getLong(1),customer);
			}
		} catch (SQLException e) {
			System.out.println(e);
			throw new Exception("cannot get Customer data");
		} finally {
			con.close();
		}
		return m;
	}

	/* (non-Javadoc)
	 * @see customer.CustomerDao#login(java.lang.String, java.lang.String)
	 */
	@Override
	public boolean login(String custName, String password) throws Exception {
		boolean flag=false;
		con = DriverManager.getConnection(Database.getUrl(), Database.getUserName(), Database.getPassword());
		String sql = "SELECT * FROM Customer WHERE custName = ?";
		try { 
			PreparedStatement p = con.prepareStatement(sql);
			p.setString(1, custName);			
			ResultSet rs = p.executeQuery() ;
			if(rs.next()) {
				String custPassword=rs.getString(3);
				if (custPassword.equals(password));
				flag=true;
			} else {
				throw new Exception("name or password incorrect");
			}
		}
		catch (Exception e) {
			e.getMessage();
		}
		finally {
			if(con != null) {
				con.close();
			}
		}
		return flag;
	}

	/* (non-Javadoc)
	 * @see customer.CustomerDao#getCoupons(customer.Customer)
	 */
	@Override
	public Map<Long,Coupon> getCoupons(Customer customer) {

		return null;
	}

	@Override
	public boolean updateCouponAmount(int amount, long id) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

}
