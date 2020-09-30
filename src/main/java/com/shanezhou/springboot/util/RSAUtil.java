//package com.shanezhou.springboot.util;
//
//import org.apache.poi.util.IOUtils;
//import org.springframework.core.io.ClassPathResource;
//import org.springframework.core.io.Resource;
//import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
//
//import java.io.IOException;
//import java.security.*;
//import java.util.HashMap;
//import java.util.Map;
//
///**
// * @Author ZhouWX
// * @CreateDate 2020/8/13 星期四
// */
//public class RSAUtil {
//
//    public static final String KEY_ALGORITHM = "RSA";
//
//    public static final int KEY_SIZE = 1024;
//
//    public static final String KEY_PUBLIC = "RSAPublicKey";
//
//    public static final String KEY_PRIVATE = "RSAPrivateKey";
//
//    public static Map<String, Object> init() throws NoSuchAlgorithmException {
//        // 实例化密钥生成器
//        //KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance(KEY_ALGORITHM);
//        //keyPairGenerator.initialize(KEY_SIZE);
//        //
//        //KeyPair keyPair = keyPairGenerator.generateKeyPair();
//        //PrivateKey privateKey = keyPair.getPrivate();
//        //PublicKey publicKey = keyPair.getPublic();
//        JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
//        Resource resourcePublic = new ClassPathResource("publicKey.txt");
//        Resource resourcePrivate = new ClassPathResource("privateKey.txt");
//
//        byte[] bytesPrivate = new byte[0];
//        byte[] bytesPublic = new byte[0];
//        //String privateKey = "";
//        //String publicKey = "";
//        try {
//            bytesPublic = IOUtils.toByteArray(resourcePublic.getInputStream());
//            bytesPrivate = IOUtils.toByteArray(resourcePrivate.getInputStream());
//            //privateKey = new String(bytesPrivate);
//            //publicKey = new String(bytesPublic);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        //String finalPrivateKey = privateKey;
//        //String finalPublicKey = publicKey;
//        byte[] finalBytesPrivate = bytesPrivate;
//        byte[] finalBytesPublic = bytesPublic;
//        Map<String, Object> keyMap = new HashMap<>(2){
//            {
//                put(KEY_PRIVATE, finalBytesPrivate);
//                put(KEY_PUBLIC, finalBytesPublic);
//            }
//        };
//        return keyMap;
//    }
//}
