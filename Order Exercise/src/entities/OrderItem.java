package entities;

public class OrderItem {

	private Integer quantity;
	private Double price;
	
	private Product product;

	public OrderItem() {

	}

	public OrderItem(Integer quantity, Double price, String name) {
		setQuantity(quantity);
		product = new Product(name, price);
		setPrice(product.getPrice());
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Double getPrice() {
		return product.getPrice();
	}

	public void setPrice(Double price) {
		this.price = price;
	}
	
	public Product getProduct(){
		return product;
	}
	
	public Double subTotal() {
		return getQuantity()*getPrice();
	}
}
