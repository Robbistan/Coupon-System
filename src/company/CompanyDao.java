/** DAO ( Data Access Object ) Interface for the Company class
 * 
 */

package company;

import java.sql.SQLException;
import java.util.Set;
import coupon.Coupon;

public interface CompanyDao {

	void createCompany(Company company) throws Exception;

	void removeCompany(long id) throws SQLException;

	void updateCompany(long idOld, long idNew) throws SQLException ;

	Company getCompany(long id) throws SQLException;

	Set<Company> getAllCompanies() throws Exception;

	Set<Coupon> getCouponsByCompName(String compName) throws Exception;

	boolean login(String compName, String password);




}
