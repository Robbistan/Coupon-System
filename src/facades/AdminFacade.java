/*
 * 
 */
package facades;

import java.sql.SQLException;
import java.util.Map;
import company.Company;
import company.CompanyDBDAO;
import customer.Customer;
import customer.CustomerDBDAO;
import main.ClientType;

// TODO: Auto-generated Javadoc
/**
 * The Class AdminFacade.
 */
public class AdminFacade implements CouponClientFacade {

	
	/** The company DBDAO. */
	private CompanyDBDAO companyDBDAO = new CompanyDBDAO();
	
	/** The customer DBDAO. */
	private CustomerDBDAO customerDBDAO = new CustomerDBDAO();

	
	/**
	 * Instantiates a new admin facade.
	 *
	 * @param companyDBDAO the company DBDAO
	 */
	public AdminFacade(CompanyDBDAO companyDBDAO) {
		this.companyDBDAO = companyDBDAO;
	}

	/**
	 * Instantiates a new admin facade.
	 */
	public AdminFacade() {
	}

	/**
	 * Creates the company.
	 *
	 * @param company the company
	 * @throws Exception the exception
	 */
	public void createCompany(Company company) throws Exception {
		companyDBDAO.createCompany(company);
	}

	/**
	 * Removes the company.
	 *
	 * @param id the id
	 * @throws Exception the exception
	 */
	public void removeCompany(long id) throws Exception {
		companyDBDAO.removeCompany(id);
	}

	/**
	 * Update company.
	 *
	 * @param idOld the id old
	 * @param idNew the id new
	 * @throws SQLException the SQL exception
	 */
	public void updateCompany(long idOld, long idNew) throws SQLException {
		companyDBDAO.updateCompany(idOld, idNew);
	}

	/**
	 * Gets the company.
	 *
	 * @param id the id
	 * @return the company
	 * @throws Exception the exception
	 */
	public Company getCompany(long id) throws Exception {
		return companyDBDAO.getCompany(id);
	}

	/**
	 * Gets the all companies.
	 *
	 * @return the all companies
	 * @throws Exception the exception
	 */
	public Map<Long, Company> getAllCompanies() throws Exception {
		return companyDBDAO.getAllCompanies();
	}

	/**
	 * Creates the customer.
	 *
	 * @param customer the customer
	 * @throws Exception the exception
	 */
	public void createCustomer(Customer customer) throws Exception {
		customerDBDAO.createCustomer(customer);
	}

	/**
	 * Removes the customer.
	 *
	 * @param customer the customer
	 * @throws Exception the exception
	 */
	public void removeCustomer(Customer customer) throws Exception {
		customerDBDAO.removeCustomer(customer);
	}

	/**
	 * Update customer.
	 *
	 * @param customer the customer
	 * @throws Exception the exception
	 */
	public void updateCustomer(Customer customer) throws Exception {
		customerDBDAO.updateCustomer(customer);
	}

	/**
	 * Gets the customer.
	 *
	 * @param id the id
	 * @return the customer
	 * @throws Exception the exception
	 */
	public Customer getCustomer(long id) throws Exception {
		return customerDBDAO.getCustomer(id);
	}

	/**
	 * Gets the all customers.
	 *
	 * @return the all customers
	 * @throws Exception the exception
	 */
	public Map<Long, Customer> getAllCustomers() throws Exception {
		return customerDBDAO.getAllCustomers();
	}

	/* (non-Javadoc)
	 * @see facades.CouponClientFacade#login(java.lang.String, java.lang.String, main.ClientType)
	 */
	@Override
	public CouponClientFacade login(String name, String password, ClientType clientType) {
		if (name.equalsIgnoreCase("admin") && password.equalsIgnoreCase("1234")) {
			System.out.println("Welcome " + name);
			return this;
		} else {
			System.out.println("username or password incorrect");
			return null;
		}

	}

}
