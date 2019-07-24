/*
 * 
 */
package facades;

import java.sql.SQLException;
import java.util.Map;
import java.util.Set;

import company.Company;
import company.CompanyDBDAO;
import companyCoupon.CompanyCouponDBDAO;
import coupon.Coupon;
import coupon.CouponDBDAO;
import coupon.CouponType;
import main.ClientType;

// TODO: Auto-generated Javadoc
/**
 * The Class CompanyFacade.
 */
public class CompanyFacade implements CouponClientFacade {

	/** The company DBDAO. */
	private CompanyDBDAO companyDBDAO = new CompanyDBDAO();

	/** The coupon DBDAO. */
	private CouponDBDAO couponDBDAO = new CouponDBDAO();

	/** The company coupon DBDAO. */
	private CompanyCouponDBDAO companyCouponDBDAO = new CompanyCouponDBDAO();

	/**
	 * Instantiates a new company facade.
	 */
	public CompanyFacade() {
	}

	/**
	 * Insert coupon.
	 *
	 * @param coupon
	 *            the coupon
	 * @throws Exception
	 *             the exception
	 */
	public void createCoupon(Long companyId, Coupon coupon) throws Exception {
		try {
			couponDBDAO.createCoupon(coupon);
			companyCouponDBDAO.createCoupon(companyId, coupon.getId());
//			System.out.println(coupon.getId());
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	/**
	 * Removes the coupon.
	 *
	 * @param id
	 *            the id
	 * @throws Exception
	 *             the exception
	 */
	public void removeCoupon(long id) throws Exception {
		couponDBDAO.removeCoupon(id);
	}

	/**
	 * Update coupon.
	 *
	 * @param coupon
	 *            the coupon
	 * @throws Exception
	 *             the exception
	 */
	public void updateCoupon(Coupon coupon) throws Exception {
		couponDBDAO.updateCoupon(coupon);
	}

	/**
	 * Gets the coupon.
	 *
	 * @param id
	 *            the id
	 * @return the coupon
	 * @throws Exception
	 *             the exception
	 */
	public Coupon getCoupon(long id) throws Exception {
		return couponDBDAO.getCoupon(id);
	}

	/**
	 * Gets the all coupons.
	 *
	 * @return the all coupons
	 * @throws Exception
	 *             the exception
	 */
	public Map<Long, Coupon> getAllCoupons() throws Exception {
		return couponDBDAO.getAllCoupons();
	}

	/**
	 * Gets the coupon by type.
	 *
	 * @param type
	 *            the type
	 * @return the coupon by type
	 * @throws Exception
	 *             the exception
	 */
	public Map<Long, Coupon> getCouponByType(String type) throws Exception {
		return couponDBDAO.getCouponByType(type);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see facades.CouponClientFacade#login(java.lang.String, java.lang.String,
	 * main.ClientType)
	 */
	@Override
	public CouponClientFacade login(String name, String password, ClientType clientType) throws Exception {
		if (companyDBDAO.login(name, password)) {

			return this;
		}
		return null;

	}

}
