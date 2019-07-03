/*
 * 
 */
package main;

import facades.AdminFacade;
import facades.CompanyFacade;
import facades.CouponClientFacade;
import facades.CustomerFacade;

// TODO: Auto-generated Javadoc
/**
 * The Class CouponSystem.
 */
public class CouponSystem implements CouponClientFacade{
	
	/** The instance. */
	private static CouponSystem instance = new CouponSystem();
	
	/** The admin facade. */
	private AdminFacade adminFacade;
	
	/** The company facade. */
	private CompanyFacade companyFacade;
	
	/** The customer facade. */
	private CustomerFacade customerFacade;
	
	/** The connection pool. */
	private ConnectionPool connectionPool;
	
	/** The daily task. */
	private DailyTask dailyTask;
	
	/** The thread. */
	private Thread thread;
	
	/**
	 * Instantiates a new coupon system.
	 */
	private CouponSystem() {
		adminFacade = new AdminFacade();
		companyFacade = new CompanyFacade();
		customerFacade = new CustomerFacade();
		connectionPool = ConnectionPool.getInstance();
		dailyTask = new DailyTask();
		thread = new Thread(dailyTask);
		thread.start();
	}
	
	
	/**
	 * Gets the single instance of CouponSystem.
	 *
	 * @return single instance of CouponSystem
	 */
	public static CouponSystem getInstance() {
		return instance;
	}

	/* (non-Javadoc)
	 * @see facades.CouponClientFacade#login(java.lang.String, java.lang.String, main.ClientType)
	 */
	@Override
	public CouponClientFacade login(String name, String password, ClientType clientType) throws Exception {
		switch(clientType) {
		case ADMIN:
			return adminFacade.login(name, password, clientType);
		case COMPANY:
			return companyFacade.login(name, password, clientType);
		case CUSTOMER:
			return customerFacade.login(name, password, clientType);
		}
		return null;
		
	}
		
		/**
		 * Shut down.
		 */
		public void shutDown() {
			connectionPool.closeAllConnections();
			dailyTask.stopTask();
		}
	


}
