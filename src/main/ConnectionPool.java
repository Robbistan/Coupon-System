/*
 * 
 */
package main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

// TODO: Auto-generated Javadoc
/**
 * The Class ConnectionPool.
 */
public class ConnectionPool {

	/** The instance. */
	private static ConnectionPool instance = new ConnectionPool();

	/** The Constant URL. */
	private static final String URL = "jdbc:mysql://localhost:3306/couponsystem?" +
			"useUnicode=true&useJDBCCompliantTimezoneShift=true&" +
			"useLegacyDatetimeCode=false&serverTimezone=GMT";

	/** The Constant userName. */
	private static final String userName = "root";

	/** The Constant password. */
	private static final String password = "1234";
	
	/** The Constant MAX_CONNECTIONS. */
	public final static int MAX_CONNECTIONS = 10;
	
	/** The blocking queue. */
	private BlockingQueue<Connection> blockingQueue;

	
	/**
	 * Instantiates a new connection pool.
	 */
	private ConnectionPool() {
		blockingQueue=createConnections();
		
	}
	
	/**
	 * Creates the connections.
	 *
	 * @return the blocking queue
	 */
	private BlockingQueue<Connection>createConnections(){
		BlockingQueue<Connection>connect = new ArrayBlockingQueue <Connection>(MAX_CONNECTIONS);
		while(connect.size()<MAX_CONNECTIONS) {
			try {
				Connection connection = DriverManager.getConnection(URL, userName, password);
			connect.offer(connection);
			}catch(SQLException e) {
				e.getMessage();
			}
		}
		return connect;
	}
	
	/**
	 * Gets the connection.
	 *
	 * @return the connection
	 */
	public Connection getConnection() {
		synchronized (blockingQueue) {
			if(blockingQueue.isEmpty()) {
				System.out.println("Waiting for connection...");
			try {
				blockingQueue.wait();
			}catch(InterruptedException e) {
				e.getMessage();
			}
			}else {
				try {
					return blockingQueue.take();
				}catch(InterruptedException e) {
					e.getMessage();
				}
			}
			return null;
		}
	}
	
	/**
	 * Return connection.
	 *
	 * @param connection the connection
	 * @throws SQLException the SQL exception
	 * @throws InterruptedException the interrupted exception
	 */
	public void returnConnection(Connection connection) throws SQLException, InterruptedException {
		synchronized (blockingQueue) {
			connection  = DriverManager.getConnection(URL, userName, password);
			blockingQueue.put(connection);
			blockingQueue.notify();
		}
	}
	
	/**
	 * Close all connections.
	 */
	public void closeAllConnections() {
		synchronized (blockingQueue) {
			while(!blockingQueue.isEmpty()) {
				try {
					blockingQueue.element().close();
					blockingQueue.remove();
				}catch(SQLException e) {
					e.getMessage();
				}
			}
		}
	}
	
	
	/**
	 * Gets the single instance of ConnectionPool.
	 *
	 * @return single instance of ConnectionPool
	 */
	public static ConnectionPool getInstance() {
		return instance;
	}
	
}
