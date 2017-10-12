package net.cactusthorn.utils;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.security.DigestInputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public interface IHash {

	static byte[] from(final Path path, final MessageDigest md) throws IOException, NoSuchAlgorithmException {

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
