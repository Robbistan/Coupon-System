package main;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

import coupon.Coupon;
import coupon.CouponDBDAO;

public class DailyTask implements Runnable {

	private CouponDBDAO CouponDBDAO = new CouponDBDAO();
	Set<Coupon> couponSet = new HashSet<>();
	private boolean quit = false;
	private final long SLEEP_time = 24 * 60 * 60 * 1000;

	@Override
	public void run() {
		while (!quit) {
			try {
				couponSet = CouponDBDAO.getAllCoupons();
				Iterator<Coupon> iterator = couponSet.iterator();
				int count = 0;
				while (iterator.hasNext()) {
					Coupon coupon = iterator.next();
					String endDate = coupon.getEndDate();
					if (endDate.equals(DateEvents.format())) {
						System.out.println(coupon);
						CouponDBDAO.removeCoupon(coupon);
						count++;
					}
				}
				if (count == 0) {
					System.out.println("There are no expired coupons");
				} else {
					System.out.println(count + " coupons deleted");
				}

			} catch (Exception e) {

				e.printStackTrace();
			}
		}

	}

	public void stopTask() {
		quit = true;
	}
}