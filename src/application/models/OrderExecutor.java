package application.models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrderExecutor {
	
	private Map<String, Company> companyMap;
	
	public OrderExecutor() {
		companyMap = new HashMap<String, Company>();
	}
	
	public List<Order> executeOrders(List<Order> orders) {
		List<Order> orderqueue = new ArrayList<Order>(orders);
		List<Order> executedOrders = new ArrayList<Order>();
		orders.clear();
		
		for(Order requestOrder : orderqueue ) {
			String companyName = requestOrder.getCompany();
			Company orderReqCompany = checkCompanyRegistered(companyName);
			Order executedOrder = orderReqCompany.executeOrder(requestOrder);
			executedOrders.add(executedOrder);
		}
		return executedOrders;
	}

	private Company registerCompany(String companyName) {
		Company company = new Company(companyName);
		companyMap.put(companyName, company);
		return company;
	}

	private Company checkCompanyRegistered(String companyName) {
		if(companyMap.containsKey(companyName)) {
			return companyMap.get(companyName);
		}else {
			return registerCompany(companyName);
		}
	}

}
