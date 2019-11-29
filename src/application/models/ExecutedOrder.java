package application.models;

import application.utils.Constants;

public class ExecutedOrder extends Order {
	
	private String status;
	private Integer remainingQuantity;

	public ExecutedOrder(Order requestOrder, String status, Integer remainingQuantity) {
		super(requestOrder.getStockId(), requestOrder.getSide(), requestOrder.getQuantity(), requestOrder.getCompany());
		this.status = status;
		this.remainingQuantity = status.equals(Constants.CLOSED) ? 0 : remainingQuantity;

	}

	@Override
	public String toString() {
		return getStockId() + "\t\t" + getSide() + "\t" + getCompany() + "\t" + getQuantity() + "," + remainingQuantity
				+ "\t\t" + status;
	}
}
