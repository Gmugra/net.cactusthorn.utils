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
package net.cactusthorn.utils.crc32;

import org.junit.Test;

import net.cactusthorn.utils.crc32.CRC32;

import static org.junit.Assert.*;

import static java.nio.charset.StandardCharsets.UTF_8;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class CRC32Test {

	String testStr = "sdvnlkhv 3949 8585___djf5885";
	
	@Test
	public void testString() {
		
		assertEquals("3DDA0435", CRC32.asHEXFrom(testStr));
		
		assertEquals("3DDA0435", CRC32.asHEXFrom(testStr, UTF_8));
	}
	
	@Test
	public void testFile() throws URISyntaxException, IOException {
		
		Path path = Paths.get(getClass().getClassLoader().getResource("1280px-Ritsa.jpg").toURI());
		
		assertEquals("95C0C320", CRC32.asHEXFrom(path));
	}
}
