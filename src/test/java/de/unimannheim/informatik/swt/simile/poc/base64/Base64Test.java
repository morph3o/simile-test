/*
 * Copyright (c) 2017, Chair of Software Technology
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without modification,
 * are permitted provided that the following conditions are met:
 * •	Redistributions of source code must retain the above copyright notice,
 * 	this list of conditions and the following disclaimer.
 * •	Redistributions in binary form must reproduce the above copyright notice,
 * 	this list of conditions and the following disclaimer in the documentation
 * 	and/or other materials provided with the distribution.
 * •	Neither the name of the University Mannheim nor the names of its
 * 	contributors may be used to endorse or promote products derived from
 * 	this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED.
 * IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT,
 * INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING,
 * BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA,
 * OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY,
 * WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
 * POSSIBILITY OF SUCH DAMAGE.
 */

package de.unimannheim.informatik.swt.simile.poc.base64;

import de.unimannheim.informatik.swt.simile.poc.de.unimannheim.informatik.swt.simile.poc.base64.Base64;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class Base64Test {

    @Test
    public void test_rfc4648() throws Exception{
        Base64 base64 = new Base64();

        assertArrayEquals(chars(""), (char[]) base64.encode(bytes("")));
        assertArrayEquals(chars("Zg=="), (char[]) base64.encode(bytes("f")));
        assertArrayEquals(chars("Zm8="), (char[]) base64.encode(bytes("fo")));
        assertArrayEquals(chars("Zm9v"), (char[]) base64.encode(bytes("foo")));
        assertArrayEquals(chars("Zm9vYg=="), (char[]) base64.encode(bytes("foob")));
        assertArrayEquals(chars("Zm9vYmE="), (char[]) base64.encode(bytes("fooba")));
        assertArrayEquals(chars("Zm9vYmFy"), (char[]) base64.encode(bytes("foobar")));

        assertArrayEquals(bytes(""), (byte[]) base64.decode(chars("")));
        assertArrayEquals(bytes("f"), (byte[]) base64.decode(chars("Zg==")));
        assertArrayEquals(bytes("fo"), (byte[]) base64.decode(chars("Zm8=")));
        assertArrayEquals(bytes("foo"), (byte[]) base64.decode(chars("Zm9v")));
        assertArrayEquals(bytes("foob"), (byte[]) base64.decode(chars("Zm9vYg==")));
        assertArrayEquals(bytes("fooba"), (byte[]) base64.decode(chars("Zm9vYmE=")));
        assertArrayEquals(bytes("foobar"), (byte[]) base64.decode(chars("Zm9vYmFy")));
    }

    protected byte[] bytes(String s) throws Exception {
        return s.getBytes("ASCII");
    }

    protected char[] chars(String s) throws Exception {
        return s.toCharArray();
    }
}
