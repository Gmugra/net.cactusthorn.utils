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

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import net.cactusthorn.utils.security.*;
import net.cactusthorn.utils.encode.*;
import net.cactusthorn.utils.crc32.*;

@RunWith(Suite.class)
@SuiteClasses({
    MD5Test.class,
    SHA1Test.class,
    SHA256Test.class,
    SHA512Test.class,
    Base58Test.class,
    CRC32Test.class,
    SimpleFileCheckSumTest.class })
public class AllTests {
}
