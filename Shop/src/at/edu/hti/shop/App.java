package at.edu.hti.shop;

import java.util.Date;

import at.edu.hti.shop.domain.Food;
import at.edu.hti.shop.domain.Order;
import at.edu.hti.shop.domain.OrderLine;

public class App {
	@SuppressWarnings("deprecation")
	public static void main(String[] args) {

		Order shopOrder = new Order();

		OrderLine line1 = new OrderLine(new Food(1, "Äpfel", 1.2, 2.434, 3,
				new Date(2013, 6, 10)), 4);
		OrderLine line2 = new OrderLine(new Food(2, "Birnen", 1.5, 23.2, 2,
				new Date(2013, 6, 10)), 2);
		OrderLine line3 = new OrderLine(new Food(3, "Pfirsich", 2.2, 12.2, 2,
				new Date(2013, 6, 2)), 5);
		OrderLine line4 = new OrderLine(new Food(4, "Kiwi", 3.5, 121, 13,
				new Date(2013, 6, 5)), 6);

		shopOrder.add(line1, 2);
		shopOrder.add(line2, 3);

		shopOrder.add(line3, 2);
		shopOrder.add(line4, 3);
		
	}
}
