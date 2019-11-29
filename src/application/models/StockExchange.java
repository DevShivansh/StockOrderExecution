package application.models;

import java.util.ArrayList;
import java.util.List;

public class StockExchange {

	private List<Order> orderRequest;
	
	private OrderExecutor executor;
	
	public StockExchange() {
		orderRequest = new ArrayList<Order>();
		executor = new OrderExecutor();
	}
	
	public void addOrderRequest(List<Order> orders ) {
		orderRequest.addAll(orders);
	}
	
	public List<Order> processOrders() {
		return executor.executeOrders(orderRequest);
	}
	
	
}
