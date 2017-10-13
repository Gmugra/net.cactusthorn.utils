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

import java.nio.charset.Charset;
import java.nio.file.Path;
import static java.nio.charset.StandardCharsets.UTF_8;

import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.xml.bind.DatatypeConverter;

import net.cactusthorn.utils.IHash;

public class MD5 implements IHash {
	
	private MD5() {
		throw new UnsupportedOperationException("No chance to instantiate me.");
	}
	
	private static MessageDigest getMessageDigest() throws NoSuchAlgorithmException {
		return MessageDigest.getInstance("MD5" );
	}

	public static byte[] from(byte[] input) throws NoSuchAlgorithmException {
		return getMessageDigest().digest(input );
	}
	
	public static byte[] from(String input, Charset charset) throws NoSuchAlgorithmException {
		return from(input.getBytes(charset ) );
	}
	
	public static byte[] from(String input ) throws NoSuchAlgorithmException {
		return from(input.getBytes(UTF_8 ) );
	}
	
	public static byte[] from(final Path path) throws IOException, NoSuchAlgorithmException {
		return IHash.from(path, getMessageDigest() );
	}
	
	public static String asHEXFrom(byte[] input) throws NoSuchAlgorithmException {
		return DatatypeConverter.printHexBinary(from(input ) );
	}
	
	public static String asHEXFrom(String input, Charset charset) throws NoSuchAlgorithmException {
		return DatatypeConverter.printHexBinary(from(input, charset ) );
	}
	
	public static String asHEXFrom(String input) throws NoSuchAlgorithmException {
		return DatatypeConverter.printHexBinary(from(input ) );
	}
	
	public static String asHEXFrom(final Path path) throws IOException, NoSuchAlgorithmException {
		return DatatypeConverter.printHexBinary(from(path ) );
	}
}
