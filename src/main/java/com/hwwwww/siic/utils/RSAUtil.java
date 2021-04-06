package com.hwwwww.siic.utils;

import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.security.*;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Hwwwww
 */
@Slf4j
@Component
public class RSAUtil {
    private static final int MAX_ENCRYPT_BLOCK = 117;
    private static final int MAX_DECRYPT_BLOCK = 128;
    /**
     * 从配置文件中获取私钥
     */
    @Value("${key.privateKey}")
    private String privateKey;
     /**
     * 从配置文件中获取公钥
     */
    @Value("${key.publicKey}")
    private String publicKey;

    /**
     * 随机生成密钥对
     *
     * @throws NoSuchAlgorithmException d
     */
    public static Map<String, String> genKeyPair() throws NoSuchAlgorithmException {
        log.info("开始生成公私钥");
        // KeyPairGenerator类用于生成公钥和私钥对，基于RSA算法生成对象
        KeyPairGenerator keyPairGen = KeyPairGenerator.getInstance("RSA");
        // 初始化密钥对生成器，密钥大小为96-1024位
        keyPairGen.initialize(2048, new SecureRandom());
        // 生成一个密钥对，保存在keyPair中
        KeyPair keyPair = keyPairGen.generateKeyPair();
        // 得到私钥
        RSAPrivateKey privateKey = (RSAPrivateKey) keyPair.getPrivate();
        // 得到公钥
        RSAPublicKey publicKey = (RSAPublicKey) keyPair.getPublic();
        String publicKeyString = new String(Base64.encodeBase64(publicKey.getEncoded()));
        // 得到私钥字符串
        String privateKeyString = new String(Base64.encodeBase64((privateKey.getEncoded())));
        // 将公钥和私钥保存到Map
        Map<String, String> map = new HashMap<>(2);
        map.put("publicKey", publicKeyString);
        map.put("privateKey", privateKeyString);
        log.info("|生成的公私钥|map:{}", map);
        return map;
    }


    /**
     * RSA私钥加密
     *
     * @param str        需要加密的字符串
     * @return 密文
     * @throws Exception 加密过程中的异常信息
     */
    public String privateKeyEncrypt(String str) throws Exception {
        byte[] decoded = Base64.decodeBase64(privateKey);
        PrivateKey priKey = KeyFactory.getInstance("RSA").
                generatePrivate(new PKCS8EncodedKeySpec(decoded));

        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.ENCRYPT_MODE, priKey);
        byte[] resultBytes = getMaxResultDecryptEncrypt(str, cipher, MAX_ENCRYPT_BLOCK);
        String outStr = Base64.encodeBase64String(resultBytes);
        //log.info("RSA私钥加密后的数据|outStr:{}", outStr);
        return outStr;
    }

    /**
     * RSA私钥解密
     *
     * @param str        需要解密的字符串
     * @return 铭文
     * @throws Exception 解密过程中的异常信息
     */
    public String privateKeyDecrypt(String str) throws Exception {
        byte[] decoded = Base64.decodeBase64(privateKey);
        PrivateKey priKey = KeyFactory.getInstance("RSA")
                .generatePrivate(new PKCS8EncodedKeySpec(decoded));
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.DECRYPT_MODE, priKey);
        String outStr = new String(getMaxResultDecryptEncrypt(str, cipher, MAX_DECRYPT_BLOCK));
        //log.info("|RSA私钥解密后的数据|outStr:{}", outStr);
        return outStr;
    }

    /**
     * RSA公钥加密
     *
     * @param str       加密字符串
     * @return 密文
     * @throws Exception 加密过程中的异常信息
     */
    public String publicKeyEncrypt(String str) throws Exception {
        byte[] decoded = Base64.decodeBase64(publicKey);
        PublicKey pubKey = KeyFactory.getInstance("RSA").
                generatePublic(new X509EncodedKeySpec(decoded));
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.ENCRYPT_MODE, pubKey);
        String outStr = Base64.encodeBase64String(getMaxResultDecryptEncrypt(str, cipher, MAX_ENCRYPT_BLOCK));
        //log.info("|公钥加密后的数据|outStr:{}", outStr);
        return outStr;
    }

    /**
     * RSA公钥解密
     *
     * @param str       需要解密的字符串
     * @return 密文
     * @throws Exception 解密过程中的异常信息
     */
    public String publicKeyDecrypt(String str) throws Exception {
        byte[] decoded = Base64.decodeBase64(publicKey);
        PublicKey pubKey = KeyFactory.getInstance("RSA")
                .generatePublic(new X509EncodedKeySpec(decoded));
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.DECRYPT_MODE, pubKey);
        String outStr = new String(getMaxResultDecryptEncrypt(str, cipher, MAX_DECRYPT_BLOCK));
        //log.info("|RSA公钥解密后的数据|outStr:{}", outStr);
        return outStr;
    }


    private byte[] getMaxResultDecryptEncrypt(String str, Cipher cipher, int blockSize) throws IllegalBlockSizeException, BadPaddingException {

        byte[] inputArray = blockSize == 128 ? Base64.decodeBase64(str.getBytes(StandardCharsets.UTF_8)) : str.getBytes();
        int inputLength = inputArray.length;
        int offSet = 0;
        byte[] resultBytes = {};
        byte[] cache;
        while (inputLength - offSet > 0) {
            if (inputLength - offSet > blockSize) {
                cache = cipher.doFinal(inputArray, offSet, blockSize);
                offSet += blockSize;
            } else {
                cache = cipher.doFinal(inputArray, offSet, inputLength - offSet);
                offSet = inputLength;
            }
            resultBytes = Arrays.copyOf(resultBytes, resultBytes.length + cache.length);
            System.arraycopy(cache, 0, resultBytes, resultBytes.length - cache.length, cache.length);
        }
        return resultBytes;
    }
}
