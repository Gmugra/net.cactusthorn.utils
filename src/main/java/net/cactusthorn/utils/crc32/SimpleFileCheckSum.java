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

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.file.Path;

import javax.xml.bind.DatatypeConverter;

public final class SimpleFileCheckSum {

    private SimpleFileCheckSum() {
        throw new UnsupportedOperationException("No chance to instantiate me.");
    }

    public static byte[] from(final Path path) throws IOException {

        byte[] size = ByteBuffer.allocate(Long.BYTES).putLong(path.toFile().length()).array();
        byte[] crc32 = CRC32.from(path);
        byte[] combined = new byte[crc32.length + size.length];

        System.arraycopy(crc32, 0, combined, 0, crc32.length);
        System.arraycopy(size, 0, combined, crc32.length, size.length);

        return combined;
    }

    public static String asHEXFrom(final Path path) throws IOException {
        return DatatypeConverter.printHexBinary(from(path));
    }
}
