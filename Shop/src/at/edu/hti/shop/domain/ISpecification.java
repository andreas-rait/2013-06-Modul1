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

public interface ISpecification<T> {

	boolean isSatisfiedBy(T candidate);

	ISpecification<T> and(ISpecification<T> specification);

	ISpecification<T> or(ISpecification<T> specification);

	ISpecification<T> not(ISpecification<T> specification);

}

// ---------------------------- Revision History ----------------------------
// $Log$
//
