package at.edu.hti.shop.domain;

import java.util.List;

public class PriceStrategy implements IPriceStrategy {

	
	@Override
	public float calcPrice(List<OrderLine> lines) {
		float sum = 0;

		for (OrderLine line : lines) {
			sum += line.calcPrize();
		}

		if (sum > 10) {
			return sum;
		} else {
			sum = sum + 5;
		}

		return sum;
	}

}
