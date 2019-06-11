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

	public void createCompany(Company company) throws SQLException {
		companyDBDAO.createCompany(company);
	}

	public void removeCompany(long id) throws Exception {
		companyDBDAO.removeCompany(id);
	}

	public void updateCompany(long idOld, long idNew) throws SQLException {
		companyDBDAO.updateCompany(idOld, idNew);
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
	public void login(String name, String password, String clientType) {
		if(name.equalsIgnoreCase("admin") && password.equalsIgnoreCase("1234")) {
			System.out.println("Welcome " + name);
			AdminFacade af = new AdminFacade();
		}else {
		System.out.println("username or password incorrect");
		} 
		
	}

}
