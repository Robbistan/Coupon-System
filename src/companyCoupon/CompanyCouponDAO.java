package companyCoupon;

import java.util.Set;

import company.Company;

public interface CompanyCouponDAO {

	Set<Company> getAllCompanies() throws Exception;

	void insertCompany(long couponId, long companyId) throws Exception;

}
