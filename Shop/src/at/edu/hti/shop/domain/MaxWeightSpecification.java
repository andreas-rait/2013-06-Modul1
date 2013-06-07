/** 
 * Copyright 2013 SSI Schaefer PEEM GmbH. All Rights reserved. 
 * <br /> <br />
 * 
 * $Id$
 * <br /> <br />
 *
 */

package at.edu.hti.shop.domain;

/**
 * This is the class header. The first sentence (ending with "."+SPACE) is
 * important, because it is used summary in the package overview pages.<br />
 * <br />
 * 
 * 
 * @author ara
 * @version $Revision$
 * 
 */

public class MaxWeightSpecification extends AbstractSpecification<Order> {

	private int maxWeight;

	public MaxWeightSpecification(int maxWeight) {
		this.maxWeight = maxWeight;
	}

	@Override
	public boolean isSatisfiedBy(Order o) {
		
		return o.getWeight() <= maxWeight;
	}

}

// ---------------------------- Revision History ----------------------------
// $Log$
//
