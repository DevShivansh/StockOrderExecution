package application.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import application.models.BuyStock;
import application.models.Order;
import application.models.SellStock;

public class Utils {

	public static List<Order> getInputOrders(List<String> inputs){
		List<Order> orders = new ArrayList<Order>();
		for(String input : inputs ) {
			String[] inputComponents = input.split(" ");
			Integer stockId = Integer.parseInt(inputComponents[0]);
			String side = inputComponents[1];
			String companyName  = inputComponents[2];
			Integer quantity = Integer.parseInt(inputComponents[3]);
			if(side.equalsIgnoreCase(Constants.BUY))
				orders.add(new BuyStock(stockId, quantity, companyName));
			else
				orders.add(new SellStock(stockId, quantity, companyName));
		}
		return orders;
	}
	
	public static List<Order> getSampleOrders(){
		List<String> inputs = Arrays.asList("1 Buy ABC 10", 
				"2 Sell XYZ 15", 
				"3 Sell ABC 13", 
				"4 Buy XYZ 10", 
				"5 Buy XYZ 8");
		return getInputOrders(inputs);
	}
}
