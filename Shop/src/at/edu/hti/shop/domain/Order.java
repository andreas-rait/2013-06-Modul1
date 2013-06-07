package at.edu.hti.shop.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Order {

	private static final long serialVersionUID = 1L;

	private ArrayList<OrderLine> orderLines;

	private IPriceStrategy strat = PriceStrategyFactory
			.getStrategy("DefaultShipping");

	public boolean add(OrderLine e, int amount) {

		if (e == null) {
			return false;
		}

		return updateOrderLine(e, amount);
	}

	private boolean add(OrderLine e) {
		return orderLines.add(e);
	}

	public Order() {
	}

	public Order(IPriceStrategy strat) {
		this.strat = strat;
	}

	public double calcPrize() {
		return strat.calcPrice(orderLines);
	}

	public void removeOrderLine(OrderLine o) {
		orderLines.remove(o);
	}

	public IPriceStrategy getStrat() {
		return strat;
	}

	public void setStrat(IPriceStrategy strat) {
		this.strat = strat;
	}

	public int getWeight() {
		int weight = 0;
		for (OrderLine ol : orderLines) {
			weight += ol.getAmount() * ol.getProduct().getWeight();
		}
		return weight;
	}

	public boolean updateOrderLine(OrderLine o, int amount) {
		if (orderLines.contains(o)) {
			if (amount == 0) {
				return orderLines.remove(o);
			} else {
				int indx = orderLines.indexOf(o);
				Integer cnt = orderLines.get(indx).getAmount();
				orderLines.get(indx).setAmount(amount + cnt);
				return true;
			}
		} else {
			if (amount > 0) {
				orderLines.add(o);
			} else {
				return false;
			}
		}
		return false;
	}

	public List<Order> split(AbstractSpecification<Product> spec) {
		Order satified = new Order();
		Order notSatified = new Order();
		for (OrderLine ol : orderLines) {
			if (spec.isSatisfiedBy(ol.getProduct())) {
				satified.add(ol);
			} else {
				notSatified.add(ol);
			}
		}

		return Arrays.asList(satified, notSatified);
	}

	public static Order merge(List<Order> orders) {
		Order total = new Order();
		for (Order o : orders) {
			for (OrderLine ol : o.orderLines) {
				total.add(ol, ol.getAmount());
			}
		}
		return total;
	}

	public void removeOrderlineAmount(OrderLine ol, int amount) {
		int index = orderLines.indexOf(ol);
		int currAmount = orderLines.get(index).getAmount();
		if (currAmount - amount <= 0) {
			orderLines.remove(ol);

		} else {
			orderLines.get(index).setAmount(currAmount - amount);
		}
	}

	public static List<Order> splitForWeight(Order o, int maxWeight) {
		ISpecification<Order> spec = new MaxWeightSpecification(maxWeight);
		List<Order> resultOrders = new ArrayList<>();
		Order tmpOrder = new Order();
		for (OrderLine ol : o.orderLines) {
			for (int i = 0; i < ol.getAmount(); i++) {
				OrderLine tmpOl = new OrderLine(ol.getProduct(), 1);
				tmpOrder.add(tmpOl);
				if (spec.isSatisfiedBy(tmpOrder)) {

				} else {
					tmpOrder.removeOrderlineAmount(ol, 1);
					resultOrders.add(tmpOrder);
					tmpOrder = new Order();
				}
			}

		}
		return resultOrders;
	}

	public static Order splitForCategory(Order o,
			Class<? extends Product> category) {
		ISpecification<Product> spec = new ProductCategorySpecification(
				category);
		Order tmp = new Order();
		for (OrderLine ol : o.orderLines) {
			if (spec.isSatisfiedBy(ol.getProduct())) {
				tmp.add(ol);
			}
		}
		return tmp;
	}

	@Override
	public String toString() {

		return super.toString() + " \n =>" + calcPrize();
	}
}
