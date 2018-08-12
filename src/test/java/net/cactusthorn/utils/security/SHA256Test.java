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

import static org.junit.Assert.*;

import static java.nio.charset.StandardCharsets.UTF_8;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.NoSuchAlgorithmException;

public class SHA256Test {

    private String testStr = "sdvnlkhv \u042b 3949 \u00df 8585___djf5885";

    @Test
    public void testString() throws NoSuchAlgorithmException {

        assertEquals("2BD2D0EC881672A29F2848D07C42FF05BA8ECC60BCB46E053492A36BD1004180", SHA256.asHEXFrom(testStr));

        assertEquals("2BD2D0EC881672A29F2848D07C42FF05BA8ECC60BCB46E053492A36BD1004180",
                SHA256.asHEXFrom(testStr, UTF_8));
    }

    @Test
    public void testFile() throws NoSuchAlgorithmException, URISyntaxException, IOException {

        Path path = Paths.get(getClass().getClassLoader().getResource("1280px-Ritsa.jpg").toURI());

        assertEquals("A2B5F6CE3217A4109A2EBE18C6195702DD667CBA0999693D995AB2E167B73C6C", SHA256.asHEXFrom(path));
    }
}
