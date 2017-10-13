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

import java.security.MessageDigest;
import java.util.zip.CRC32;

public class CRC32MessageDigest extends MessageDigest {

	private CRC32 crc;

	public CRC32MessageDigest() {
		super("CRC32");
		crc = new CRC32();
	}

	@Override
	protected void engineReset() {
		crc.reset();
	}

	@Override
	protected void engineUpdate(byte input) {
		crc.update(input);
	}

	@Override
	protected void engineUpdate(byte[] input, int offset, int len) {
		crc.update(input, offset, len);
	}

	@Override
	protected byte[] engineDigest() {
		long l = crc.getValue();
		byte[] bytes = new byte[4];
		bytes[0] = (byte) ((l & 0xFF000000) >> 24);
		bytes[1] = (byte) ((l & 0x00FF0000) >> 16);
		bytes[2] = (byte) ((l & 0x0000FF00) >> 8);
		bytes[3] = (byte) ((l & 0x000000FF) >> 0);
		return bytes;
	}
}
