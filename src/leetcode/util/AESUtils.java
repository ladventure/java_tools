package leetcode.util;//package Leecode;
//
////
//// Source code recreated from a .class file by IntelliJ IDEA
//// (powered by Fernflower decompiler)
////
//
//
//import javax.crypto.Cipher;
//import javax.crypto.spec.IvParameterSpec;
//import javax.crypto.spec.SecretKeySpec;
//import org.apache.commons.codec.binary.Base64;
//import org.apache.commons.codec.binary.Hex;
//
//public class AESUtils {
//    public static final String ALGORITHM_AES = "AES";
//    private static final String ALGORITHM_CIPHER_AES_PKCS5 = "AES/CBC/PKCS5Padding";
//    private static final String CHARSET = "UTF-8";
//
//    public AESUtils() {
//    }
//
//    public static String encrypt(String data, String key, String iv) {
//        if (data != null && data != "") {
//            try {
//                byte[] e = key.getBytes();
//                SecretKeySpec skeySpec = new SecretKeySpec(e, "AES");
//                Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
//                byte[] bytes = iv.getBytes();
//                cipher.init(1, skeySpec, new IvParameterSpec(bytes));
//                byte[] encrypted = cipher.doFinal(data.getBytes());
//                return Base64.encodeBase64String(encrypted);
//            } catch (Exception var8) {
//                throw new RuntimeException("加密字符串[" + data + "]时遇到异常", var8);
//            }
//        } else {
//            return null;
//        }
//    }
//
//    public static String encryptAESMysql(String data, String key) {
//        try {
//            byte[] raw = key.getBytes("UTF-8");
//            SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");
//            Cipher cipher = Cipher.getInstance("AES");
//            cipher.init(1, skeySpec);
//            byte[] encrypted = cipher.doFinal(data.getBytes("UTF-8"));
//            return (new String(Hex.encodeHex(encrypted))).toUpperCase();
//        } catch (Exception var6) {
//            throw new RuntimeException("加密字符串[" + data + "]时遇到异常", var6);
//        }
//    }
//
//    public static String decrypt(String data, String key, String iv) {
//        if (data != null && data != "") {
//            try {
//                byte[] enc = Base64.decodeBase64(data);
//                byte[] e = key.getBytes();
//                SecretKeySpec skeySpec = new SecretKeySpec(e, "AES");
//                Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
//                byte[] bytes = iv.getBytes();
//                cipher.init(2, skeySpec, new IvParameterSpec(bytes));
//                byte[] decrypted = cipher.doFinal(enc);
//                return new String(decrypted);
//            } catch (Exception var9) {
//                throw new RuntimeException("解密字符串[" + data + "]时遇到异常", var9);
//            }
//        } else {
//            return null;
//        }
//    }
//
//    public static String decryptAESMysql(String data, String key) {
//        try {
//            byte[] raw = key.getBytes("UTF-8");
//            SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");
//            Cipher cipher = Cipher.getInstance("AES");
//            cipher.init(2, skeySpec);
//            byte[] encrypted1 = Hex.decodeHex(data.toCharArray());
//            byte[] original = cipher.doFinal(encrypted1);
//            String originalString = new String(original, "UTF-8");
//            return originalString;
//        } catch (Exception var8) {
//            throw new RuntimeException("解密字符串[" + data + "]时遇到异常", var8);
//        }
//    }
//}
