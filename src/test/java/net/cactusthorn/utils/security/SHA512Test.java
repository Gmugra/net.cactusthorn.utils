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
package net.cactusthorn.utils.security;

import org.junit.Test;

import net.cactusthorn.utils.security.SHA512;

import static org.junit.Assert.*;

import static java.nio.charset.StandardCharsets.UTF_8;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.NoSuchAlgorithmException;

public class SHA512Test {

	String testStr = "sdvnlkhv \u042b 3949 \u00df 8585___djf5885";
	
	@Test
	public void testString() throws NoSuchAlgorithmException {
		
		assertEquals("621A3E6BAA4C08EE1A1980D61888984D968E86335F20591F5340EB8016ECB35B844F196235B76AA14692EDCA6CEEB83B838F1FB45A4A957EE5AD1D42200C1E89", SHA512.asHEXFrom(testStr));
		
		assertEquals("621A3E6BAA4C08EE1A1980D61888984D968E86335F20591F5340EB8016ECB35B844F196235B76AA14692EDCA6CEEB83B838F1FB45A4A957EE5AD1D42200C1E89", SHA512.asHEXFrom(testStr, UTF_8));
	}
	
	@Test
	public void testFile() throws NoSuchAlgorithmException, URISyntaxException, IOException {
		
		Path path = Paths.get(getClass().getClassLoader().getResource("1280px-Ritsa.jpg").toURI());
		
		assertEquals("3B57EE2748B245C01007DEC318D582DF63404B99588F5BB1993E5828E8473637D83360FBFE577ADA24D7E2C8B88C27D4A503F9C34D1BD335DA8CA4D46579D801", SHA512.asHEXFrom(path));
	}
}
