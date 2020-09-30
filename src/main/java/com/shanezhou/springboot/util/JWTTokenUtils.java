//package com.shanezhou.springboot.util;
//
//import com.auth0.jwt.JWT;
//import com.auth0.jwt.JWTCreator;
//import com.auth0.jwt.algorithms.Algorithm;
//import com.auth0.jwt.interfaces.Claim;
//import com.auth0.jwt.interfaces.DecodedJWT;
//
//import java.util.Calendar;
//import java.util.HashMap;
//import java.util.Map;
//
///**
// * @Author ZhouWX
// * @CreateDate 2020/8/13 星期四
// */
//public class JWTTokenUtils {
//
//    private static final String SECRET = "sommelier";
//    private static Algorithm algorithm;
//    public static final int EXPIRE_SECOND = 60;
//
//
//    public static String createToken(Map<String, String> map) {
//        algorithm = Algorithm.HMAC256(SECRET);
//        Calendar calendar = Calendar.getInstance();
//        calendar.add(Calendar.SECOND, EXPIRE_SECOND);
//
//        JWTCreator.Builder builder = JWT.create();
//        map.forEach((k, v) -> {
//            builder.withClaim(k, v);
//        });
//        String token = builder.withHeader(new HashMap<>())    // head
//                .withExpiresAt(calendar.getTime())    // 令牌过期时间
//                .sign(algorithm);// 签名
//
//        return token;
//    }
//
//    public static DecodedJWT getToken(String token) {
//        return JWT.require(algorithm).build().verify(token);
//    }
//
//    public static void main(String[] args) {
//        Map<String, String> map = new HashMap(){
//            {
//                put("username", "shane");
//                put("id", "1");
//            }
//        };
//        String token = createToken(map);
//        System.out.println(token);
//
//        DecodedJWT jwt = getToken(token);
//        Map<String, Claim> claims = jwt.getClaims();
//        claims.forEach((k, v) -> {
//            System.out.println(k + "\t " + v.asString());
//        });
//
//
//    }
//}
