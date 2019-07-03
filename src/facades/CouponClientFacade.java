/*
 * 
 */
package facades;

import main.ClientType;

// TODO: Auto-generated Javadoc
/**
 * The Interface CouponClientFacade.
 */
public interface CouponClientFacade {


	/**
	 * Login.
	 *
	 * @param name the name
	 * @param password the password
	 * @param clientType the client type
	 * @return the coupon client facade
	 * @throws Exception the exception
	 */
	CouponClientFacade login(String name, String password, ClientType clientType) throws Exception;
}