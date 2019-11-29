package application.models;

import application.utils.Constants;

public class Company {
	
	private String companyName;
	private Integer buyStockCount = 0;
	private Integer sellStockCount = 0;
	private Integer remainingQuantity = 0;
	private String status;
	private String firstOrderType = null;
	
	public Company() {

	}
	
	public Company(String companyName) {
		
		this.companyName = companyName;
		this.status = Constants.CLOSED;
	}
	
	public Order executeOrder(Order order) {
		
		
		if(order instanceof BuyStock) {
			this.buyStockCount += order.getQuantity();
		}else {
			this.sellStockCount += order.getQuantity();
		}
		if( firstOrderType == null ) {
			firstOrderType = order.getSide();
		}
		evaluateStatus();
		return new ExecutedOrder(order, status, remainingQuantity);
	}
	
	private void evaluateStatus() {

		remainingQuantity = Math.abs(buyStockCount - sellStockCount);

		if ((firstOrderType.equals(Constants.BUY) && buyStockCount < sellStockCount)
				|| (firstOrderType.contentEquals(Constants.SELL) && sellStockCount < buyStockCount)) {
			status = Constants.OPEN;
		}

	}
	
	public String getCompanyName() {
		return companyName;
	}
	

}
