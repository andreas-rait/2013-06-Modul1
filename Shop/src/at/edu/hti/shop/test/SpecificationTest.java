
/** 
 * Copyright 2013 SSI Schaefer PEEM GmbH. All Rights reserved. 
 * <br /> <br />
 * 
 * $Id$
 * <br /> <br />
 *
 */

package at.edu.hti.shop.test;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import at.edu.hti.shop.domain.AndSpecification;
import at.edu.hti.shop.domain.Food;
import at.edu.hti.shop.domain.MaxWeightSpecification;
import at.edu.hti.shop.domain.Order;
import at.edu.hti.shop.domain.OrderLine;
import at.edu.hti.shop.domain.Product;
import at.edu.hti.shop.domain.ProductCategorySpecification;
import at.edu.hti.shop.domain.Tool;


/**
 * This is the class header. The first sentence (ending with "."+SPACE) is important,
 * because it is used summary in the package overview pages.<br />
 * <br />
 *
 *
 * @author  ara
 * @version $Revision$
 */

public class SpecificationTest {

	private Order order;
	
	@SuppressWarnings("deprecation")
	@Before
	public void setUp() throws Exception {
		order = new Order();

		OrderLine line1 = new OrderLine(new Food(1, "Äpfel", 1.2, 2.434, 3, new Date(2013, 6, 10)), 4);
		OrderLine line2 = new OrderLine(new Food(2, "Birnen", 1.5, 23.2, 2, new Date(2013, 6, 10)), 2);
		OrderLine line3 = new OrderLine(new Food(3, "Pfirsich", 2.2, 12.2, 2, new Date(2013, 6, 2)), 5);
		OrderLine line4 = new OrderLine(new Food(4, "Kiwi", 3.5, 121, 13, new Date(2013, 6, 5)), 6);
		
		order.add(line1, 2);
		order.add(line2, 3);
		order.add(line3, 2);
		order.add(line4, 2);
	} 
	
	@Test
	public void testMaxWeightTest() {
		new MaxWeightSpecification(30).isSatisfiedBy(order);
	}

}


//---------------------------- Revision History ----------------------------
//$Log$
//
