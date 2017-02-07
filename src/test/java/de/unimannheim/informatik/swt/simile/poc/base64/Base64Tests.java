package de.unimannheim.informatik.swt.simile.poc.base64;

import de.unimannheim.informatik.swt.simile.poc.de.unimannheim.informatik.swt.simile.poc.base64.Base64;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class Base64Tests {

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

    /*
    @Test
    public void test_rfc4648_decode() throws Exception{
        Base64 base64 = new Base64();

        assertArrayEquals(bytes(""), (byte[]) base64.decode(chars("")));
        assertArrayEquals(bytes("f"), (byte[]) base64.decode(chars("Zg==")));
        assertArrayEquals(bytes("fo"), (byte[]) base64.decode(chars("Zm8=")));
        assertArrayEquals(bytes("foo"), (byte[]) base64.decode(chars("Zm9v")));
        assertArrayEquals(bytes("foob"), (byte[]) base64.decode(chars("Zm9vYg==")));
        assertArrayEquals(bytes("fooba"), (byte[]) base64.decode(chars("Zm9vYmE=")));
        assertArrayEquals(bytes("foobar"), (byte[]) base64.decode(chars("Zm9vYmFy")));
    }
    */

    protected byte[] bytes(String s) throws Exception {
        return s.getBytes("ASCII");
    }

    protected char[] chars(String s) throws Exception {
        return s.toCharArray();
    }
}
