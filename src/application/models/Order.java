package application.models;

public class Order {

	private Integer stockId;
	private String side;
	private Integer quantity;
	private String company;
	
	public Order(String side, Integer quantity) {
		this.side = side;
		this.quantity = quantity;
	}
	
	public Order(Integer stockId,String side, Integer quantity, String company) {
		this(side, quantity);
		this.company = company;
		this.stockId = stockId;
	}
	
	
	public String getCompany() {
		return company;
	}
	
	public Integer getQuantity() {
		return quantity;
	}
	
	public String getSide() {
		return side;
	}
	
	public Integer getStockId() {
		return stockId;
	}
	
	@Override
	public String toString() {
		return stockId + "\t\t" + side + "\t" + company + "\t" + quantity;
	}
}
