
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
 * This is the class header. The first sentence (ending with "."+SPACE) is important,
 * because it is used summary in the package overview pages.<br />
 * <br />
 *
 *
 * @author  ara
 * @version $Revision$
 */

public class Tool extends Product {
	
	private final String toolBrand;

	public Tool(long id, String name, double prize, double weight,
			int deliverytime,String toolBrand) {
		super(id, name, prize, weight, deliverytime);
		this.toolBrand=toolBrand;
	}

	public String getToolBrand() {
		return toolBrand;
	}
	

}


//---------------------------- Revision History ----------------------------
//$Log$
//
