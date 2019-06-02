package facades;

import java.util.Set;

import company.Company;
import company.CompanyDBDAO;
import coupon.Coupon;
import coupon.CouponDBDAO;
import coupon.CouponType;

public class CompanyFacade implements CouponClientFacade {

	private CompanyDBDAO companyDBDAO = new CompanyDBDAO();
	private CouponDBDAO couponDBDAO = new CouponDBDAO();

	public CompanyFacade(CompanyDBDAO companyDBDAO, CouponDBDAO couponDBDAO) {
		super();
		this.companyDBDAO = companyDBDAO;
		this.couponDBDAO = couponDBDAO;
	}

	public CompanyFacade() {
		super();
	}

	public void insertCoupon(Coupon coupon) throws Exception {
		couponDBDAO.insertCoupon(coupon);
	}

	public void removeCoupon(Coupon coupon) throws Exception {
		couponDBDAO.removeCoupon(coupon);
	}

	public void updateCoupon(Coupon coupon) throws Exception {
		couponDBDAO.updateCoupon(coupon);
	}

	public Coupon getCoupon(int id) throws Exception {
		return couponDBDAO.getCoupon(id);
	}

	public Set<Coupon> getAllCoupons() throws Exception {
		return couponDBDAO.getAllCoupons();
	}

	public Set<Coupon> getCouponByType(CouponType type) throws Exception {
		return couponDBDAO.getCouponByType(type);
	}

	@Override
	public CouponClientFacade login(String name, String password, String clientType) {
		// TODO Auto-generated method stub
		return null;
	}

}
