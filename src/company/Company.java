/** Company Class
 * 
 */

package company;

import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.omg.Messaging.SyncScopeHelper;

import coupon.Coupon;

/**
 * The Class Company.
 *
 * @author ESRE
 */
public class Company {

	/** The id. */
	private long id;

	/** The company name. */
	private String compName;

	/** The password. */
	private String password;

	/** The email. */
	private String email;

	/** The coupons. */
	private Map<Long, Coupon> coupons = new Hashtable<>();

	/**
	 * Instantiates a new company.
	 *
	 * @param id
	 *            the id
	 * @param compName
	 *            the company name
	 * @param password
	 *            the password
	 * @param email
	 *            the email
	 * @param coupons
	 *            the coupons
	 */
	public Company(long id, String compName, String password, String email, Map<Long, Coupon> coupons) {
		setId(id);
		setCompName(compName);
		setPassword(password);
		setEmail(email);
		setCoupons(coupons);
	}

	/**
	 * Instantiates a new company.
	 */
	public Company() {
	}

	/**
	 * Instantiates a new company.
	 *
	 * @param id
	 *            the id
	 * @param compName
	 *            the company name
	 * @param password
	 *            the password
	 * @param email
	 *            the email
	 */
	public Company(long id, String compName, String password, String email) {
		setId(id);
		setCompName(compName);
		setPassword(password);
		setEmail(email);
	}

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	// getters and setters
	public long getId() {
		return id;
	}

	/**
	 * Sets the id.
	 *
	 * @param id
	 *            the new id
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * Gets the company name.
	 *
	 * @return the company name
	 */
	public String getCompName() {
		return compName;
	}

	/**
	 * Sets the company name.
	 *
	 * @param compName
	 *            the new company name
	 */
	public void setCompName(String compName) {
		this.compName = compName;
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
	 * @param password
	 *            the new password
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * Gets the email.
	 *
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Sets the email.
	 *
	 * @param email
	 *            the new email
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * Gets the coupons.
	 *
	 * @return the coupons
	 */
	public Map<Long, Coupon> getCoupons() {
		return coupons;
	}

	/**
	 * Sets the coupons.
	 *
	 * @param coupons
	 *            the coupons
	 */
	public void setCoupons(Map<Long, Coupon> coupons) {
		this.coupons = coupons;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	// toString
	@Override
	public String toString() {
		return "\nid = " + id + "\ncompName = " + compName +
				"\npassword = " + password + "\nemail = " + email +
				"\ncoupons = " + coupons + "\n\n";
	}

}
