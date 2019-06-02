package customer;

import java.util.Set;

import company.Company;
import coupon.Coupon;

public interface CustomerDao {

	void createCustomer(Customer customer) throws Exception;

	void removeCustomer(Customer customer) throws Exception;

	void updateCustomer(Customer customer) throws Exception;

	Customer getCustomer(int id) throws Exception;

	Set<Customer> getAllCustomers() throws Exception;

	Set<Coupon> getCoupons(Customer customer);

	boolean login(String custName, String password);


}
