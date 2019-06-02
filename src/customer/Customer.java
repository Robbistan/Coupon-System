package customer;

import java.util.Set;

import coupon.Coupon;

public class Customer {

	private long id;
	private String custName;
	private String password;
	private Set<Coupon> coupons;

	public Customer(long id, String custName, String password, Set<Coupon> coupons) {
		setId(id);
		setCustName(custName);
		setPassword(password);
		setCoupons(coupons);
	}

	public Customer() {
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Set<Coupon> getCoupons() {
		return coupons;
	}

	public void setCoupons(Set<Coupon> coupons) {
		this.coupons = coupons;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", custName=" + custName + ", password=" + password + ", coupons=" + coupons
				+ "]";
	}

}
