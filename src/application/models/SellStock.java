package application.models;

import application.utils.Constants;

public class SellStock extends Order{

	public SellStock(Integer stockId, Integer quantity, String company) {
		super(stockId, Constants.SELL, quantity, company);
	}

	
}
