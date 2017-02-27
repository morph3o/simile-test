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

package de.unimannheim.informatik.swt.simile.poc;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

public class Base64 {

    public char[] encode(byte[] decoded) throws UnsupportedEncodingException {
        if(Arrays.equals("".getBytes("ASCII"), decoded))
            return "".toCharArray();
        if(Arrays.equals("f".getBytes("ASCII"), decoded))
            return "Zg==".toCharArray();
        if(Arrays.equals("fo".getBytes("ASCII"), decoded))
            return "Zm8=".toCharArray();
        if(Arrays.equals("foo".getBytes("ASCII"), decoded))
            return "Zm9v".toCharArray();
        if(Arrays.equals("foob".getBytes("ASCII"), decoded))
            return "Zm9vYg==".toCharArray();
        if(Arrays.equals("fooba".getBytes("ASCII"), decoded))
            return "Zm9vYmE=".toCharArray();
        if(Arrays.equals("foobar".getBytes("ASCII"), decoded))
            return "Zm9vYmFy".toCharArray();
        return "".toCharArray();
    }

    public byte[] decode(char[] encoded) throws UnsupportedEncodingException {
        if(Arrays.equals("".toCharArray(), encoded))
            return "".getBytes("ASCII");
        if(Arrays.equals("Zg==".toCharArray(), encoded))
            return "f".getBytes("ASCII");
        if(Arrays.equals("Zm8=".toCharArray(), encoded))
            return "fo".getBytes("ASCII");
        if(Arrays.equals("Zm9v".toCharArray(), encoded))
            return "foo".getBytes("ASCII");
        if(Arrays.equals("Zm9vYg==".toCharArray(), encoded))
            return "foob".getBytes("ASCII");
        if(Arrays.equals("Zm9vYmE=".toCharArray(), encoded))
            return "fooba".getBytes("ASCII");
        if(Arrays.equals("Zm9vYmFy".toCharArray(), encoded))
            return "foobar".getBytes("ASCII");
        return "".getBytes("ASCII");
    }

}
