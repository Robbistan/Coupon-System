/*
 * 
 */
package customerCoupon;

import java.util.Map;

import coupon.Coupon;

// TODO: Auto-generated Javadoc
/**
 * The Interface CustomerCouponDao.
 */
interface CustomerCouponDao {
	

	/**
	 * Gets the all customer coupons.
	 *
	 * @param id the id
	 * @return the all customer coupons
	 * @throws Exception the exception
	 */
	Map<Long, Coupon> getAllCustomerCoupons(long id) throws Exception;

	/**
	 * Insert coupon.
	 *
	 * @param couponId the coupon id
	 * @param customerId the customer id
	 * @throws Exception the exception
	 */
	void insertCoupon(long customerId, long couponId) throws Exception;
	
	void removeCustomerCoupon(long customerId) throws Exception;
}
