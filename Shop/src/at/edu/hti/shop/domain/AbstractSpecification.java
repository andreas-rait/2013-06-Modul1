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

public abstract class AbstractSpecification<T> implements ISpecification<T> {

	public ISpecification<T> and(ISpecification<T> specification) {
		if (specification == null) {
			throw new NullPointerException("'specification' must not be null");
		}
		return new AndSpecification<T>(this, specification);
	}

	public ISpecification<T> or(ISpecification<T> specification) {
		if (specification == null) {
			throw new NullPointerException("'specification' must not be null");
		}
		return new OrSpecification<T>(this, specification);
	}

	public ISpecification<T> not(ISpecification<T> specification) {
		if (specification == null) {
			throw new NullPointerException("'specification' must not be null");
		}
		return new NotSpecification<T>(specification);
	}

}





// ---------------------------- Revision History ----------------------------
// $Log$
//
