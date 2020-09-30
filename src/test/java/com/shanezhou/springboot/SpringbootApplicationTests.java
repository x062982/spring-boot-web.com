//package com.shanezhou.springboot;
//
//import com.auth0.jwt.JWT;
//import com.auth0.jwt.JWTVerifier;
//import com.auth0.jwt.algorithms.Algorithm;
//import com.auth0.jwt.interfaces.DecodedJWT;
//import com.auth0.jwt.interfaces.RSAKeyProvider;
//import com.baomidou.dynamic.datasource.annotation.DS;
//import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
//import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
//import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
//import com.nimbusds.jose.crypto.impl.RSAKeyUtils;
//import com.shanezhou.springboot.dao.EmployeeMPMapper;
//import com.shanezhou.springboot.entity.Employee;
//import com.shanezhou.springboot.util.RSAUtil;
//import io.jsonwebtoken.Claims;
//import io.jsonwebtoken.Jws;
//import io.jsonwebtoken.Jwts;
//import org.apache.poi.util.IOUtils;
//import org.junit.jupiter.api.Test;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.core.io.ClassPathResource;
//import org.springframework.core.io.Resource;
//import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
//import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;
//
//import java.io.FileInputStream;
//import java.io.IOException;
//import java.io.InputStream;
//import java.security.*;
//import java.security.cert.Certificate;
//import java.security.cert.CertificateException;
//import java.security.cert.CertificateFactory;
//import java.security.cert.X509Certificate;
//import java.security.interfaces.RSAPrivateKey;
//import java.security.interfaces.RSAPublicKey;
//import java.security.spec.InvalidKeySpecException;
//import java.security.spec.RSAPublicKeySpec;
//import java.security.spec.X509EncodedKeySpec;
//import java.util.*;
//
////@SpringBootTest
//class SpringbootApplicationTests {
//
//	@Test
//	void contextLoads() {
//		//List<Employee> employees = mapper.selectList(null);
//		//for (Employee e : employees) {
//		//	System.out.println(e);
//		//}
//
//		//QueryWrapper<Employee> wrapper = new QueryWrapper<>();
//		//wrapper.eq(true, "username", "admin")
//		//		//.ge(true, "age", 0)
//		//.gt("age", 0);
//		////List<Employee> employees = mapper.selectList(wrapper);
//		//List<Employee> employees = mapper.selectPage(
//		//		new Page<Employee>(2, 3), null).getRecords();
//		//for (Employee e : employees) {
//		//	System.out.println(e);
//		//}
//
//		//Employee employee = new Employee("shane1");
//		//employee.setVersion(1);
//		//UpdateWrapper<Employee> wrapper = new UpdateWrapper<>();
//		//Map map = new HashMap();
//		//map.put("username", "shane");
//		//map.put("age", 0);
//		//wrapper.allEq(map);
//		//int update = mapper.update(employee, wrapper);
//		//for (int i = 1; i < 100; i++) {
//		//	mapper.insert(new Employee("user" + i));
//		//}
//
//		Calendar calendar = Calendar.getInstance();
//		calendar.add(Calendar.MINUTE, 1);
//		//calendar.set(Calendar.MINUTE, 1);
//
//		Date date = new Date();
//		date.setSeconds(10);
//
//		String token = JWT.create().withHeader(new HashMap<>())    // head
//				.withClaim("username", "xiaohei")    //	payload
//				.withClaim("userId", 1)
//				.withExpiresAt(calendar.getTime())    // 令牌过期时间
//				.sign(Algorithm.HMAC256("密钥"));// 签名
//
//		System.out.println(token);
//	}
//
//	@Test
//	public void test01() {
//
//		String token = "eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCJ9.eyJleHAiOjE1OTc1OTkxNzksInVzZXJfbmFtZSI6InNoYW5lIiwiYXV0aG9yaXRpZXMiOlsiVVNFUiJdLCJqdGkiOiJmOWNlNjQ0Yy03NDE4LTQ2ZWMtOTlhYy1lMDBkZGY1ZmFhN2MiLCJjbGllbnRfaWQiOiJpZC1zaGFuZSIsInNjb3BlIjpbImRlZmF1bHQtc2NvcGUiXX0.Y4nBYsaI2WblzatwvB1iVy4Ao0UTsSdV3PyjGg95bYdrtF5ucawrN71FuVQY6VEQYwhnfBWaoQ9eeS7vkKXA-429M8oaOsSkAVAEhfBnv5nQvOwNkzDUj6aSdZjWte3BLFFqynjMySqrCfRS9rf0hCXXXMtJIPolJYo5j061n7wpPsbRSrsG4ioUAg1F3ZBPicrv1Dy0tUrxJ9NbGXNSGQDaxh0LQMqwTclPSw3CJI-HljjWW2h2d59wlz5tVKi04IX_aeF5Fv7NrUleiTb9lzAxrljNKO87V3zicO6bOXlcukeJ1ZdFqUnwkNTXc4MlcZVW8FB6NVqlqhCd1SQ4FA";
//
//		try {
//
//			Resource resourcePublic = new ClassPathResource("public-key.txt");
//			InputStream is = new FileInputStream("C:\\Users\\shanezhou\\Desktop\\public-key.cert");
//			Resource resourcePrivate = new ClassPathResource("privateKey.txt");
//			byte[] bytesPublic = new byte[0];
//			byte[] bytesPrivate = new byte[0];
//			//String privateKey = "";
//			//String publicKey = "";
//
//			bytesPublic = IOUtils.toByteArray(resourcePublic.getInputStream());
//			bytesPrivate = IOUtils.toByteArray(resourcePrivate.getInputStream());
//
//			//Map<String, Object> map = RSAUtil.init();
//
//			//RSAPublicKey publicKey = map.get(RSAUtil.KEY_PUBLIC);
//			//RSAPrivateKey privateKey = (RSAPrivateKey)map.get(RSAUtil.KEY_PRIVATE);
//
//			//X509EncodedKeySpec spec = new X509EncodedKeySpec((byte[])map.get(RSAUtil.KEY_PUBLIC));
//			//X509EncodedKeySpec spec = new X509EncodedKeySpec(bytesPublic);
//			//X509EncodedKeySpec spec2 = new X509EncodedKeySpec(bytesPrivate);
//			//KeyFactory keyFactory = KeyFactory.getInstance("RSA");
//			////PrivateKey privateKey = keyFactory.generatePrivate(spec2);
//			//PublicKey publicKey = keyFactory.generatePublic(spec);
//
//			CertificateFactory cf = CertificateFactory.getInstance("X509", "SUN");
//			X509Certificate certificate = (X509Certificate)cf.generateCertificate
//					(is);
//			is.close();
//			RSAPublicKey publicKey = (RSAPublicKey)certificate.getPublicKey();
//			Jws<Claims> claimsJws = Jwts.parser().setSigningKey(publicKey).parseClaimsJws(token);
//			Claims body = claimsJws.getBody();
//			body.forEach((k, v) -> {
//				System.out.println(k + " : \t" + v);
//			});
//
//			//JWTVerifier verifier = JWT.require(
//			//		Algorithm.RSA256(publicKey, privateKey))
//			//		.build();
//
//			//DecodedJWT verify = verifier.verify(token);
//			//
//			//verify.getClaims().forEach((k, v) -> {
//			//	System.out.println(k + " : \t" + v);
//			//});
//
//		} catch (IOException e) {
//			e.printStackTrace();
//		//} catch (CertificateException e) {
//		//	e.printStackTrace();
//		//} catch (NoSuchProviderException e) {
//		//	e.printStackTrace();
//		//} catch (IOException e) {
//		//	e.printStackTrace();
//		} catch (CertificateException e) {
//			e.printStackTrace();
//		} catch (NoSuchProviderException e) {
//			e.printStackTrace();
//		}
//
//
//		//converter.setVerifierKey(publicKey);
//		//
//		//JwtTokenStore jwtTokenStore = new JwtTokenStore(converter);
//		//
//		//System.out.println(jwtTokenStore);
//	}
//
//}
