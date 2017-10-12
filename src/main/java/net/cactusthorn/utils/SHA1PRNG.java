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

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

import javax.xml.bind.DatatypeConverter;

public class SHA1PRNG {
	
	private SHA1PRNG() {
		throw new UnsupportedOperationException("No chance to instantiate me.");
	}

	public static byte[] generate(int size) throws NoSuchAlgorithmException {

		SecureRandom secureRandom = SecureRandom.getInstance("SHA1PRNG");
		byte[] salt = new byte[size];
		secureRandom.nextBytes(salt);
		return salt;
	}

	public static String asHEXGenerate(int size) throws NoSuchAlgorithmException {
		return DatatypeConverter.printHexBinary(generate(size) );
	}
}
