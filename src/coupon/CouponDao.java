/*
 * 
 */
package coupon;

import java.util.Map;

/**
 * The Interface CouponDao.
 */
public interface CouponDao {

	/**
	 * Insert coupon.
	 *
	 * @param coupon
	 *            the coupon
	 * @return true, if successful
	 * @throws Exception
	 *             the exception
	 */
	boolean insertCoupon(Coupon coupon) throws Exception;

	/**
	 * Removes the coupon.
	 *
	 * @param id
	 *            the id
	 * @throws Exception
	 *             the exception
	 */
	void removeCoupon(long id) throws Exception;

	/**
	 * Update coupon.
	 *
	 * @param coupon
	 *            the coupon
	 * @throws Exception
	 *             the exception
	 */
	void updateCoupon(Coupon coupon) throws Exception;

	/**
	 * Gets the coupon.
	 *
	 * @param id
	 *            the id
	 * @return the coupon
	 * @throws Exception
	 *             the exception
	 */
	Coupon getCoupon(long id) throws Exception;

	/**
	 * Gets the all coupons.
	 *
	 * @return the all coupons
	 * @throws Exception
	 *             the exception
	 */
	Map<Long, Coupon> getAllCoupons() throws Exception;

	/**
	 * Gets the coupon by type.
	 *
	 * @param couponType
	 *            the coupon type
	 * @return the coupon by type
	 * @throws Exception
	 *             the exception
	 */

	/**
	 * @param type
	 * @return coupons of asked type
	 * @throws Exception
	 */
	Map<Long, Coupon> getCouponByType(String type) throws Exception;

	// void removeCoupon(Coupon coupon) throws Exception;

}
