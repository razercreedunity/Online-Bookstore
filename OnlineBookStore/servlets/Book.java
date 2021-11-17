package servlets;

/**
 * Book.java
 * This is a model class represents a book entity
 * @author www.codejava.net
 *
 */
public class Book {
	protected String barcode;
	protected String name;
	protected String author;
	protected int price;
	protected int quantity;

	public Book() {
	}

	public Book(String barcode) {
		this.barcode = barcode;
	}

	public Book(String barcode, String name, String author, int price, int quantity) {
		this(name, author, price, quantity);
		this.barcode = barcode;

	}
	
	public Book(String name, String author, int price, int quantity) {
		this.name = name;
		this.author = author;
		this.price = price;
		this.quantity = quantity;
	}

	public String getBarcode() {
		return barcode;
	}

	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	
	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

}
