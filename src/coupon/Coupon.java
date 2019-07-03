/** Basic Coupon Class 
 * 
 */

package coupon;

// TODO: Auto-generated Javadoc
/**
 * The Class Coupon.
 */
public class Coupon {

	/** The id. */
	private long id;
	
	/** The title. */
	private String title;
	
	/** The start date. */
	private String startDate;
	
	/** The end date. */
	private String endDate;
	
	/** The amount. */
	private int amount;
	
	/** The type. */
	private String type;
	
	/** The message. */
	private String message;
	
	/** The price. */
	private double price;
	
	/** The image. */
	private String image;

	/**
	 * Instantiates a new coupon.
	 *
	 * @param id
	 *            is the coupon id
	 * @param title
	 *            the title
	 * @param startDate
	 *            the start date
	 * @param endDate
	 *            the end date
	 * @param amount
	 *            the amount
	 * @param type
	 *            the type
	 * @param message
	 *            the message
	 * @param price
	 *            the price
	 * @param image
	 *            the image
	 */
	// CTor
	public Coupon(long id, String title, String startDate, String endDate, int amount, String type, String message,
			double price, String image) {
		setId(id);
		setTitle(title);
		setStartDate(startDate);
		setEndDate(endDate);
		setAmount(amount);
		setType(type);
		setMessage(message);
		setPrice(price);
		setImage(image);
	}

	/**
	 * Instantiates a new coupon.
	 */
	public Coupon() {
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
	 * Gets the title.
	 *
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * Sets the title.
	 *
	 * @param title
	 *            the new title
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * Gets the start date.
	 *
	 * @return the start date
	 */
	public String getStartDate() {
		return startDate;
	}

	/**
	 * Sets the start date.
	 *
	 * @param startDate the new start date
	 */
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	/**
	 * Gets the end date.
	 *
	 * @return the end date
	 */
	public String getEndDate() {
		return endDate;
	}

	/**
	 * Sets the end date.
	 *
	 * @param endDate
	 *            the new end date
	 */
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	/**
	 * Gets the amount.
	 *
	 * @return the amount
	 */
	public int getAmount() {
		return amount;
	}

	/**
	 * Sets the amount.
	 *
	 * @param amount
	 *            the new amount
	 */
	public void setAmount(int amount) {
		this.amount = amount;
	}

	/**
	 * Gets the type.
	 *
	 * @return the type
	 */
	public String getType() {
		return CouponType.valueOf(type).toString();
	}

	/**
	 * Sets the type.
	 *
	 * @param type
	 *            the new type
	 */
	public void setType(String type) {
		this.type = CouponType.valueOf(type).toString();
	}

	/**
	 * Gets the message.
	 *
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * Sets the message.
	 *
	 * @param message
	 *            the new message
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * Gets the price.
	 *
	 * @return the price
	 */
	public double getPrice() {
		return price;
	}

	/**
	 * Sets the price.
	 *
	 * @param price
	 *            the new price
	 */
	public void setPrice(double price) {
		this.price = price;
	}

	/**
	 * Gets the image.
	 *
	 * @return the image
	 */
	public String getImage() {
		return image;
	}

	/**
	 * Sets the image.
	 *
	 * @param image
	 *            the new image
	 */
	public void setImage(String image) {
		this.image = image;
	}
	

	/**
	 * To string.
	 *
	 * @return the string
	 * @see java.lang.Object#toString()
	 */
	// toString
	@Override
	public String toString() {
		return "\n[id = " + id + "\ntitle = " + title + "\nstartDate=" + startDate + "\nendDate=" + endDate
				+ "\namount=" + amount + "\ntype=" + type + "\nmessage=" + message + "\nprice=" + price + "\nimage="
				+ image + "]\n\n";
	}

}