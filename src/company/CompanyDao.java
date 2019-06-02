/** DAO ( Data Access Object ) Interface for the Company class
 * 
 */

package company;

import java.util.Set;
import coupon.Coupon;

public interface CompanyDao {

	void createCompany(Company company) throws Exception;

	void removeCompany(Company company) throws Exception;

	void updateCompany(Company company) throws Exception;

	Company getCompany(int id) throws Exception;

	Set<Company> getAllCompanies() throws Exception;

	Set<Coupon> getCouponsByCompName(String compName) throws Exception;

	boolean login(String compName, String password);

}
