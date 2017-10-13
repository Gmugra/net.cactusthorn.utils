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

import net.cactusthorn.utils.security.SHA1;

import static org.junit.Assert.*;

import static java.nio.charset.StandardCharsets.UTF_8;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.NoSuchAlgorithmException;

public class SHA1Test {

	String testStr = "sdvnlkhv \u042b 3949 \u00df 8585___djf5885";
	
	@Test
	public void testString() throws NoSuchAlgorithmException {
		
		assertEquals("ABD4F98BD00176209F887A571AAA26CB52C8A58E", SHA1.asHEXFrom(testStr));
		
		assertEquals("ABD4F98BD00176209F887A571AAA26CB52C8A58E", SHA1.asHEXFrom(testStr, UTF_8));
	}
	
	@Test
	public void testFile() throws NoSuchAlgorithmException, URISyntaxException, IOException {
		
		Path path = Paths.get(getClass().getClassLoader().getResource("1280px-Ritsa.jpg").toURI());
		
		assertEquals("BD3AA10701374BDA33434C9317F0F6ABE32759D8", SHA1.asHEXFrom(path));
	}
}
