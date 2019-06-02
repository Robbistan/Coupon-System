package facades;

import java.sql.SQLException;
import java.util.Set;

import company.Company;
import company.CompanyDBDAO;
import customer.Customer;
import customer.CustomerDBDAO;

public class AdminFacade implements CouponClientFacade {

	private CompanyDBDAO companyDBDAO = new CompanyDBDAO();
	private CustomerDBDAO customerDBDAO = new CustomerDBDAO();

	public AdminFacade(CompanyDBDAO companyDBDAO) {
		this.companyDBDAO = companyDBDAO;
	}

	public AdminFacade() {
	}

	public void createCompany(Company company) throws SQLException  {
		companyDBDAO.createCompany(company);
	}

	public void removeCompany(Company company) throws Exception {
		companyDBDAO.removeCompany(company);
	}

	public void updateCompany(Company company) throws Exception {
		companyDBDAO.updateCompany(company);
	}

	public Company getCompany(int id) throws Exception {
		return companyDBDAO.getCompany(id);
	}

	public Set<Company> getAllCompanies() throws Exception {
		return companyDBDAO.getAllCompanies();
	}

	public void createCustomer(Customer customer) throws Exception {
		customerDBDAO.createCustomer(customer);
	}

	public void removeCustomer(Customer customer) throws Exception {
		customerDBDAO.removeCustomer(customer);
	}

	public void updateCustomer(Customer customer) throws Exception {
		customerDBDAO.updateCustomer(customer);
	}

	public Customer getCustomer(int id) throws Exception {
		return customerDBDAO.getCustomer(id);
	}

	public Set<Customer> getAllCustomers() throws Exception {
		return customerDBDAO.getAllCustomers();
	}

	@Override
	public CouponClientFacade login(String name, String password, String clientType) {
		return null;
	}

}
