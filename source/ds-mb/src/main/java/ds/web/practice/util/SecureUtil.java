package ds.web.practice.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.apache.commons.codec.binary.Hex;

public class SecureUtil {    
    public static String hash(String algorithm, String data) throws NoSuchAlgorithmException {
        return hash(algorithm, data.getBytes());
    }
    public static String hash(String algorithm, byte[] data) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance(algorithm);
        md.update(data);
        return new String(Hex.encodeHex(md.digest()));
    }
}
