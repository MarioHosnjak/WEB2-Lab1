package com.WEB2.backend;

import org.bouncycastle.jcajce.provider.digest.SHA3.DigestSHA3;
import org.bouncycastle.util.encoders.Hex;

public class HashingUtil {
    public static String hashTo10Chars(String input) {
        DigestSHA3 digestSHA3 = new DigestSHA3(256); // Use SHA-256
        byte[] digest = digestSHA3.digest(input.getBytes());
        String hash = new String(Hex.encode(digest));
        return hash.substring(0, 10); // Truncate to 10 characters
    }
}