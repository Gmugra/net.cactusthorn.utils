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

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.security.DigestInputStream;
import java.security.MessageDigest;

public interface IHash {

	static byte[] from(final Path path, final MessageDigest md) throws IOException {

		try (	InputStream is = Files.newInputStream(path);
				DigestInputStream dis = new DigestInputStream(is, md ) ) {
			
			byte[] in = new byte[8192];
			while (dis.read(in) != -1) {
				//read stream till the end
			}
		}
		return md.digest();
	}
}
