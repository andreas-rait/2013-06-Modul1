package at.edu.hti.shop.domain;

public class PriceStrategyFactory {
	
	public static IPriceStrategy getStrategy(String id){
		if(id==null || id.isEmpty()){
			throw new NullPointerException("id is null");
		}
		
		if("DefaultShipping".equals(id)){
			return new PriceStrategy();
		}
		
		throw new IllegalArgumentException("id not supported");
	}
}
