/*
 * 
 */
package companyCoupon;

import java.util.Map;
import java.util.Set;

import company.Company;
import coupon.Coupon;

// TODO: Auto-generated Javadoc
/**
 * The Interface CompanyCouponDAO.
 */
public interface CompanyCouponDAO {

	/**
	 * Gets the all company coupons.
	 *
	 * @param id the id
	 * @return the all company coupons
	 * @throws Exception the exception
	 */
	Map<Long, Coupon> getAllCompanyCoupons(long id) throws Exception;

	/**
	 * Insert company.
	 *
	 * @param couponId the coupon id
	 * @param companyId the company id
	 * @throws Exception the exception
	 */
	void insertCompany(long couponId, long companyId) throws Exception;

}
