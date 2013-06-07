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
 */

public class ProductCategorySpecification extends
		AbstractSpecification<Product> {

	private final Class<? extends Product> category;

	public ProductCategorySpecification(Class<? extends Product> category) {
		this.category = category;
	}

	@Override
	public boolean isSatisfiedBy(Product product) {
		if (category.isInstance(product)) {
			return true;
		}
		return false;
	}

}

// ---------------------------- Revision History ----------------------------
// $Log$
//
