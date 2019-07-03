/** DAO ( Data Access Object ) Interface for the Company class
 * 
 */

package company;

import java.sql.SQLException;
import java.util.Map;
import coupon.Coupon;

/**
 * The Interface CompanyDao.
 */
public interface CompanyDao {

	/**
	 * Creates the company.
	 *
	 * @param company
	 *            the company
	 * @throws Exception
	 *             the exception
	 */
	void createCompany(Company company) throws Exception;

	/**
	 * Removes the company.
	 *
	 * @param id
	 *            the id
	 * @throws SQLException
	 *             the SQL exception
	 */
	void removeCompany(long id) throws SQLException;

	/**
	 * Update company.
	 *
	 * @param idOld
	 *            the old id
	 * @param idNew
	 *            the new id
	 * @throws SQLException
	 *             the SQL exception
	 */
	void updateCompany(long idOld, long idNew) throws SQLException;

	/**
	 * Gets the company.
	 *
	 * @param id
	 *            the id
	 * @return the company
	 * @throws SQLException
	 *             the SQL exception
	 */
	Company getCompany(long id) throws SQLException;

	/**
	 * Gets the company by name.
	 *
	 * @param name
	 *            the name
	 * @return the company by name
	 * @throws SQLException
	 *             the SQL exception
	 */
	Company getCompanyByName(String compName) throws SQLException;

	/**
	 * Gets the all companies.
	 *
	 * @return the all companies
	 * @throws Exception
	 *             the exception
	 */
	Map<Long, Company> getAllCompanies() throws Exception;

	/**
	 * Gets the coupons by company name.
	 *
	 * @param compName
	 *            the company name
	 * @return the coupons by company name
	 * @throws Exception
	 *             the exception
	 */
	Map<Long, Coupon> getCouponsByCompName(String compName) throws Exception;

	/**
	 * Login.
	 *
	 * @param compName
	 *            the company name
	 * @param password
	 *            the password
	 * @return true, if successful
	 */
	boolean login(String compName, String password);

}
