package application;

import java.util.List;

import application.models.Order;
import application.models.StockExchange;
import application.utils.Utils;

public class StockOrderRunner {

	public static void main(String[] args) {
		List<Order> orders = Utils.getSampleOrders();
		printOrders(orders, false);
		System.out.println();
		StockExchange exchange = new StockExchange();
		exchange.addOrderRequest(orders);
		List<Order> executedOrders = exchange.processOrders();
		printOrders(executedOrders, true);
	}
	
	public static void printOrders(List<Order> orders, boolean executed) {
		if(!executed) {
			System.out.println("Stock Id\tSide\tCompany\tQuantity");
		}else {
			System.out.println("Stock Id\tSide\tCompany\tQuantity\tStatus");
		}
		for( Order order : orders ) {
			System.out.println(order.toString());
		}
		
	}
}
