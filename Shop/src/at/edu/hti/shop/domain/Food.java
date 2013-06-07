
/** 
 * Copyright 2013 SSI Schaefer PEEM GmbH. All Rights reserved. 
 * <br /> <br />
 * 
 * $Id$
 * <br /> <br />
 *
 */

package at.edu.hti.shop.domain;

import java.util.Date;


/**
 * This is the class header. The first sentence (ending with "."+SPACE) is important,
 * because it is used summary in the package overview pages.<br />
 * <br />
 *
 *
 * @author  ara
 * @version $Revision$
 */

public class Food extends Product {

	private final Date expiryDate;
	public Food(long id, String name, double prize, double weight,
			int deliverytime,Date expiryDate) {
		super(id, name, prize, weight, deliverytime);
		this.expiryDate=expiryDate;
	}
	public Date getExpiryDate() {
		return expiryDate;
	}

}


//---------------------------- Revision History ----------------------------
//$Log$
//
