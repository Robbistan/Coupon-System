/*
 * 
 */
package customer;

import java.util.Hashtable;
import java.util.Map;
import java.util.Set;

import coupon.Coupon;

// TODO: Auto-generated Javadoc
/**
 * The Class Customer.
 */
public class Customer {

	/** The id. */
	private long id;
	
	/** The cust name. */
	private String custName;
	
	/** The password. */
	private String password;
	
	/** The coupons. */
	private Map<Long,Coupon> coupons= new Hashtable<>();

	/**
	 * Instantiates a new customer.
	 *
	 * @param id the id
	 * @param custName the cust name
	 * @param password the password
	 * @param coupons the coupons
	 */
	public Customer(long id, String custName, String password, Map<Long,Coupon> coupons) {
		setId(id);
		setCustName(custName);
		setPassword(password);
		setCoupons(coupons);
	}

	/**
	 * Instantiates a new customer.
	 */
	public Customer() {
	}

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * Sets the id.
	 *
	 * @param id the new id
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * Gets the cust name.
	 *
	 * @return the cust name
	 */
	public String getCustName() {
		return custName;
	}

	/**
	 * Sets the cust name.
	 *
	 * @param custName the new cust name
	 */
	public void setCustName(String custName) {
		this.custName = custName;
	}

	/**
	 * Gets the password.
	 *
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Sets the password.
	 *
	 * @param password the new password
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * Gets the coupons.
	 *
	 * @return the coupons
	 */
	public Map<Long,Coupon> getCoupons() {
		return coupons;
	}

	/**
	 * Sets the coupons.
	 *
	 * @param coupons the coupons
	 */
	public void setCoupons(Map<Long,Coupon> coupons) {
		this.coupons = coupons;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Customer : \nid=" + id + "\ncustName=" + custName + "\npassword=" + password + "\ncoupons=" + coupons;
	}

}
