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

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class SimpleFileCheckSumTest {

	@Test
	public void testIt() throws URISyntaxException, IOException  {
		
		Path path = Paths.get(getClass().getClassLoader().getResource("1280px-Ritsa.jpg").toURI());
		
		assertEquals("95C0C3200000000000045344", SimpleFileCheckSum.asHEXFrom(path));
	}
}
