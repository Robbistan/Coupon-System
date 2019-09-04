/*
 * 
 */
package facades;

import java.util.Iterator;
import java.util.Map.Entry;

import coupon.Coupon;
import coupon.CouponDBDAO;
import coupon.CouponType;
import customer.Customer;
import customer.CustomerDBDAO;
import customerCoupon.CustomerCouponDBDAO;
import main.ClientType;

// TODO: Auto-generated Javadoc
/**
 * The Class CustomerFacade.
 */
public class CustomerFacade implements CouponClientFacade {

	/** The customer DBDAO. */
	private CustomerDBDAO customerDBDAO = new CustomerDBDAO();
	
	/** The coupon DBDAO. */
	private CouponDBDAO couponDBDAO = new CouponDBDAO();
	
	/** The customer coupon DBDAO. */
	private CustomerCouponDBDAO customerCouponDBDAO = new CustomerCouponDBDAO();
	
	/** The customer. */
	private Customer customer = new Customer();

	/**
	 * Instantiates a new customer facade.
	 */
	public CustomerFacade() {
	}

	/**
	 * Purchase coupon.
	 *
	 * @param coupon the coupon
	 * @throws Exception the exception
	 */
	public void purchaseCoupon(long id, Coupon coupon) throws Exception {
//		Coupon c = couponDBDAO.getCoupon(coupon.getId());
		if (coupon != null) {
//			if (couponDBDAO.updateCouponAmount(1, coupon.getId())) {
				customerCouponDBDAO.insertCoupon(id, coupon.getCouponId());
				couponDBDAO.updateCouponAmount(1);
				System.out.println("Coupon has been purchased successfully");

			}
		}
//	}

	/**
	 * Gets the purchased history.
	 *
	 * @return the purchased history
	 */
	public void getPurchasedHistory() {
		System.out.println("Searching ...");
		if (customer.getCoupons().size() > 0 && customer.getCoupons() != null) {
			System.out.println(customer.getCoupons().values());
		}
	}

	/**
	 * Gets the all purchased coupons by type.
	 *
	 * @param type the type
	 * @return the all purchased coupons by type
	 */
	public void getAllPurchasedCouponsByType(CouponType type) {
		System.out.println("Searching for coupons with type " + type);
		Iterator<Entry<Long, Coupon>> iterator = customer.getCoupons().entrySet().iterator();
		int count = 0;
		while (iterator.hasNext()) {
			Entry<Long, Coupon> entry = iterator.next();
			Coupon coupon = entry.getValue();
			if (coupon.getType().equals(type)) {
				count++;
				System.out.println(coupon);
			}
		}
	}

	/**
	 * Gets the all purchased coupons by price.
	 *
	 * @param price the price
	 * @return the all purchased coupons by price
	 */
	public void getAllPurchasedCouponsByPrice(double price) {
		System.out.println("Searching for coupons with price " + price);
		Iterator<Entry<Long, Coupon>> iterator = customer.getCoupons().entrySet().iterator();
		int count = 0;
		while (iterator.hasNext()) {
			Entry<Long, Coupon> entry = iterator.next();
			Coupon coupon = entry.getValue();
			if (coupon.getPrice() == price) {
				count++;
				System.out.println(coupon);
			}
		}
		if (count == 0) {
			System.out.println("There are no coupons with price " + price);
		}
	}

	/* (non-Javadoc)
	 * @see facades.CouponClientFacade#login(java.lang.String, java.lang.String, main.ClientType)
	 */
	@Override
	public CouponClientFacade login(String name, String password, ClientType clientType) {

		return null;
	}
}
