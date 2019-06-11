/** Basic Coupon Class 
 * 
 */

package coupon;

/**
 * The Class Coupon.
 */
public class Coupon {

	private int id;
	private String title;
	private String startDate;
	private String endDate;
	private int amount;
	private String type;
	private String message;
	private double price;
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
	public Coupon(int id, String title, String startDate, String endDate, int amount, String type, String message,
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
		// TODO Auto-generated constructor stub
	}

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	// getters and setters
	public int getId() {
		return id;
	}

	/**
	 * Sets the id.
	 *
	 * @param id
	 *            the new id
	 */
	public void setId(int id) {
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
		return type;
	}

	/**
	 * Sets the type.
	 *
	 * @param type
	 *            the new type
	 */
	public void setType(String type) {
		this.type = type;
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