/*
 * 
 */
package customer;

import java.util.Map;
import java.util.Set;

import company.Company;
import coupon.Coupon;

// TODO: Auto-generated Javadoc
/**
 * The Interface CustomerDao.
 */
public interface CustomerDao {

	/**
	 * Creates the customer.
	 *
	 * @param customer the customer
	 * @throws Exception the exception
	 */
	void createCustomer(Customer customer) throws Exception;

	/**
	 * Removes the customer.
	 *
	 * @param customer the customer
	 * @throws Exception the exception
	 */
	void removeCustomer(Customer customer) throws Exception;

	/**
	 * Update customer.
	 *
	 * @param customer the customer
	 * @throws Exception the exception
	 */
	void updateCustomer(Customer customer) throws Exception;

	/**
	 * Update coupon amount.
	 *
	 * @param amount the amount
	 * @param id the id
	 * @return true, if successful
	 * @throws Exception the exception
	 */
	boolean updateCouponAmount(int amount, long id) throws Exception;

	/**
	 * Gets the customer.
	 *
	 * @param id the id
	 * @return the customer
	 * @throws Exception the exception
	 */
	Customer getCustomer(long id) throws Exception;

	/**
	 * Gets the all customers.
	 *
	 * @return the all customers
	 * @throws Exception the exception
	 */
	Map<Long,Customer> getAllCustomers() throws Exception;

	/**
	 * Gets the coupons.
	 *
	 * @param customer the customer
	 * @return the coupons
	 */
	Map<Long,Coupon> getCoupons(Customer customer);

	/**
	 * Login.
	 *
	 * @param custName the customer name
	 * @param password the password
	 * @return true, if successful
	 * @throws Exception the exception
	 */
	boolean login(String custName, String password) throws Exception;


}
