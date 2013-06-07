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

public class AndSpecification<T> extends AbstractSpecification<T> {

	private final ISpecification<T> specification1;
	private final ISpecification<T> specification2;

	public AndSpecification(ISpecification<T> speci1, ISpecification<T> speci2) {
		if (speci1 == null) {
			throw new NullPointerException("'spec1' must not be null");
		}
		if (speci2 == null) {
			throw new NullPointerException("'spec2' must not be null");
		}
		this.specification1 = speci1;
		this.specification2 = speci2;
	}

	@Override
	public boolean isSatisfiedBy(T candidate) {
		if (candidate == null) {
			throw new NullPointerException("'candidate' must not be null");
		}
		return specification1.isSatisfiedBy(candidate)
				&& specification2.isSatisfiedBy(candidate);
	}

}

// ---------------------------- Revision History ----------------------------
// $Log$
//
