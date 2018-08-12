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

import java.nio.charset.Charset;
import java.nio.file.Path;
import static java.nio.charset.StandardCharsets.UTF_8;

import java.io.IOException;
import java.security.MessageDigest;

import javax.xml.bind.DatatypeConverter;

import net.cactusthorn.utils.IHash;

public final class CRC32 implements IHash {

    private CRC32() {
        throw new UnsupportedOperationException("No chance to instantiate me.");
    }

    private static MessageDigest getMessageDigest() {
        return new CRC32MessageDigest();
    }

    public static byte[] from(byte[] input) {
        return getMessageDigest().digest(input);
    }

    public static byte[] from(String input, Charset charset) {
        return from(input.getBytes(charset));
    }

    public static byte[] from(String input) {
        return from(input.getBytes(UTF_8));
    }

    public static byte[] from(final Path path) throws IOException {
        return IHash.from(path, getMessageDigest());
    }

    public static String asHEXFrom(byte[] input) {
        return DatatypeConverter.printHexBinary(from(input));
    }

    public static String asHEXFrom(String input, Charset charset) {
        return DatatypeConverter.printHexBinary(from(input, charset));
    }

    public static String asHEXFrom(String input) {
        return DatatypeConverter.printHexBinary(from(input));
    }

    public static String asHEXFrom(final Path path) throws IOException {
        return DatatypeConverter.printHexBinary(from(path));
    }
}
