package at.edu.hti.shop.domain;

public class Product {
	private final String name;
	private final long id;
	private final double prize;
	private final double weight;
	private final int deliveryTime;

	public Product(long id, String name, double prize, double weight,
			int deliverytime) {
		super();
		this.name = name;
		this.id = id;
		this.prize = prize;
		this.weight = weight;
		this.deliveryTime = deliverytime;
	}

	public String getName() {
		return name;
	}

	public long getId() {
		return id;
	}

	public double getPrize() {
		return prize;
	}

	public double getWeight() {
		return weight;
	}

	public int getDeliveryTime() {
		return deliveryTime;
	}

	@Override
	public String toString() {
		return "Product [" + name + ", " + id + ", " + prize + "]";
	}

}
