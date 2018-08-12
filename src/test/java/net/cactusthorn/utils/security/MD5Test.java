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

public class MD5Test {

    private String testStr = "sdvnlkhv \u042b 3949 \u00df 8585___djf5885";

    @Test
    public void testString() throws NoSuchAlgorithmException {

        assertEquals("902C12CC3BADE6497375026CC7C42BA4", MD5.asHEXFrom(testStr));

        assertEquals("902C12CC3BADE6497375026CC7C42BA4", MD5.asHEXFrom(testStr, UTF_8));
    }

    @Test
    public void testFile() throws NoSuchAlgorithmException, URISyntaxException, IOException {

        Path path = Paths.get(getClass().getClassLoader().getResource("1280px-Ritsa.jpg").toURI());

        assertEquals("3ADBE2055056F8CCF37C6258F4C45269", MD5.asHEXFrom(path));
    }
}
