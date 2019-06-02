/** Company Class
 * 
 */

package company;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.omg.Messaging.SyncScopeHelper;

import coupon.Coupon;

public class Company {

	// variable declaration
	private long id;
	private String compName;
	private String password;
	private String email;
	private List<Coupon> coupons;

	// CTor
	public Company(long id, String compName, String password, String email, List<Coupon> coupons) {
		setId(id);
		setCompName(compName);
		setPassword(password);
		setEmail(email);
		setCoupons(coupons);
	}

	public Company() {
	}

	// getters and setters
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCompName() {
		return compName;
	}

	public void setCompName(String compName) {
		this.compName = compName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Coupon> getCoupons() {
		return coupons;
	}

	public void setCoupons(List<Coupon> coupons) {
		this.coupons = coupons;
	}

	// toString
	@Override
	public String toString() {
		return "Company : id = " + id + "\ncompName = " + compName + "\npassword = " + 
				password + "\nemail = " + email+ 
				"\ncoupons = " + coupons + "\n\n";
	}

}
