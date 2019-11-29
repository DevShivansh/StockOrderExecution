package application.models;

import application.utils.Constants;

public class BuyStock extends Order{

	public BuyStock(Integer stockId,Integer quantity, String company) {
		super(stockId ,Constants.BUY, quantity, company);
	}

}
