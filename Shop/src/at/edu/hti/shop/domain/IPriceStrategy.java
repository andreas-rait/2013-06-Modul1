package at.edu.hti.shop.domain;

import java.util.List;

interface IPriceStrategy {

	public float calcPrice(List<OrderLine> lines);
}
