package coupon;

import java.util.Set;

public interface CouponDao {

	void insertCoupon(Coupon coupon) throws Exception;

	void removeCoupon(Coupon coupon) throws Exception;

	void updateCoupon(Coupon coupon) throws Exception;

	Coupon getCoupon(int id) throws Exception;

	Set<Coupon> getAllCoupons() throws Exception;

	Set<Coupon> getCouponByType(CouponType couponType) throws Exception;

}
