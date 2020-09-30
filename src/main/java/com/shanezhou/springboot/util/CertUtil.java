package com.shanezhou.springboot.util;


import java.io.*;
import java.security.*;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.util.Base64;

/**
 * @Author ZhouWX
 * @CreateDate 2020/8/13 星期四
 */
public class CertUtil {

    private String keyStoreType;
    private String alias;
    private char[] password;
    private File exportFile;
    private File keyStoreFile;

    public KeyPair getPrivateKey(KeyStore keyStore, String alias, char[] password) {
        try {
            Key key = keyStore.getKey(alias, password);
            if (key instanceof PrivateKey) {
                Certificate cert = keyStore.getCertificate(alias);
                PublicKey publicKey = cert.getPublicKey();
                return new KeyPair(publicKey, (PrivateKey)key);
            }

        } catch (KeyStoreException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (UnrecoverableKeyException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void export() throws KeyStoreException, IOException, CertificateException, NoSuchAlgorithmException {
        KeyStore keyStore = KeyStore.getInstance(keyStoreType);
        Base64.Encoder encoder = Base64.getEncoder();
        keyStore.load(new FileInputStream(keyStoreFile), password);
        KeyPair keyPair = getPrivateKey(keyStore, alias, password);
        PrivateKey privateKey = keyPair.getPrivate();
        String encode = encoder.encodeToString(privateKey.getEncoded());
        FileWriter writer = new FileWriter(exportFile);
        writer.write("----BEGIN PRIVATE KEY----\n");
        writer.write(encode);
        writer.write("\n");
        writer.write("----END PRIVATE KEY----\n");

        Certificate cert = keyStore.getCertificate(alias);
        PublicKey publicKey = cert.getPublicKey();
        String encode1 = encoder.encodeToString(publicKey.getEncoded());
        writer.write("----BEGIN PUBLIC KEY----\n");
        writer.write(encode1);
        writer.write("\n");
        writer.write("----END PUBLIC KEY----\n");
        writer.close();
    }

    public static void main(String[] args) throws CertificateException, NoSuchAlgorithmException, KeyStoreException, IOException {
        CertUtil certUtil = new CertUtil();
        String url = "C:\\Users\\shanezhou\\Desktop\\rsa-key.jks";
        certUtil.keyStoreFile = new File(url);
        certUtil.exportFile = new File(url + ".txt");
        certUtil.keyStoreType = "JKS";
        certUtil.password = "123456".toCharArray();
        certUtil.alias = "rsa-key";
        certUtil.export();
        System.out.println("publi key 提取成功！");
    }
}
