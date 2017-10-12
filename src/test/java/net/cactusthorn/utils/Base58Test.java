/*******************************************************************************
 * Copyright (C) 2017, Alexei Khatskevich
 * All rights reserved.
 * 
 * Licensed under the BSD 2-clause (Simplified) License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 * http://opensource.org/licenses/BSD-2-Clause
 ******************************************************************************/
package net.cactusthorn.utils;

import org.junit.Test;
import static org.junit.Assert.*;

public class Base58Test {

	String testStr = "sdvnlkhv 3949 8585___djf5885";
	
	@Test
	public void testString()  {
		
		assertEquals("2BqXyLxP4jK5GiUXaFtdBm6GU9h9C7NhxEwA5P2", Base58.encodeString(testStr));
	}
}
