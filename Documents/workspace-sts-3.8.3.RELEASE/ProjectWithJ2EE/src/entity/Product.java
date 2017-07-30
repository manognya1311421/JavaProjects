package entity;

public class Product {

	
	String productName;
	int productCost;
	int quantity;
	int total;
	public int getTotal() {
		return total;
	}
	public void setTotal(int productId) {
		this.total = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public int getProductCost() {
		return productCost;
	}
	public void setProductCost(int productCost) {
		this.productCost = productCost;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	
}
