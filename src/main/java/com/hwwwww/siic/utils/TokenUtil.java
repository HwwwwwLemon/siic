package com.hwwwww.siic.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.hwwwww.siic.vo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author Hwwwww
 */
@Component
public class TokenUtil {
    @Autowired
    private RSAUtil rsa;
    /**
     * Token时间,单位为毫秒
     */
    private final long EXPIRE_TIME = 5 * 60 * 1000;
    private final long REFRESH_EXPIRE_TIME = EXPIRE_TIME * 2;
    /**
     * 密钥盐
     */
    private final String TOKEN_SECRET = "Hwwwww";

    /**
     * 签名生成
     *
     * @param user token
     * @return token
     */
    public String sign(User user, int key) {

        String token = null;
        try {
            Date expiresAt = new Date(System.currentTimeMillis() + getExpiresTimeType(key));
            if (key == 1) {
                token = JWT.create()
                        .withIssuer("auth0")
                        .withClaim("username", user.getUsername())
                        .withClaim("type", "token")
                        .withExpiresAt(expiresAt)
                        // 使用了HMAC256加密算法。
                        .sign(Algorithm.HMAC256(TOKEN_SECRET));
            } else if (key == 2) {
                token = JWT.create()
                        .withIssuer("auth0")
                        .withClaim("username", user.getUsername())
                        .withClaim("type", "refresh_token")
                        .withClaim("sss", rsa.publicKeyEncrypt(user.getUsername()))
                        .withExpiresAt(expiresAt)
                        // 使用了HMAC256加密算法。
                        .sign(Algorithm.HMAC256(TOKEN_SECRET));
            } else {
                throw new IllegalArgumentException("");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return token;
    }

    /**
     * 签名生成
     *
     * @param claim token
     * @return token
     */
    public String sign(String claim, int key) {

        String token = null;
        try {
            Date expiresAt = new Date(System.currentTimeMillis() + getExpiresTimeType(key));
            if (key == 1) {
                token = JWT.create()
                        .withIssuer("auth0")
                        .withClaim("username", claim)
                        .withClaim("type", "token")
                        .withExpiresAt(expiresAt)
                        // 使用了HMAC256加密算法。
                        .sign(Algorithm.HMAC256(TOKEN_SECRET));
            } else if (key == 2) {
                token = JWT.create()
                        .withIssuer("auth0")
                        .withClaim("username", claim)
                        .withClaim("type", "refresh_token")
                        .withClaim("sss", rsa.publicKeyEncrypt(claim))
                        .withExpiresAt(expiresAt)
                        // 使用了HMAC256加密算法。
                        .sign(Algorithm.HMAC256(TOKEN_SECRET));
            } else {
                throw new IllegalArgumentException("");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return token;
    }

    private long getExpiresTimeType(int key) {
        if (key == 1) {
            return EXPIRE_TIME;
        } else if (key == 2) {
            return REFRESH_EXPIRE_TIME;
        }
        return 0;
    }

    public String getInfo(String token) {
        if (token != null && token.length() > 0) {
            JWTVerifier verifier = JWT.require(Algorithm.HMAC256(TOKEN_SECRET)).withIssuer("auth0").build();
            try {
                DecodedJWT jwt = verifier.verify(token);
                return jwt.getClaim("username").asString();
            } catch (Exception e) {
                return null;
            }
        } else {
            return null;
        }
    }


    /**
     * 签名验证
     *
     * @param token token
     * @return boolean
     */
    public boolean verify(String token) throws Exception {

        JWTVerifier verifier = JWT.require(Algorithm.HMAC256(TOKEN_SECRET)).withIssuer("auth0").build();
        DecodedJWT jwt = verifier.verify(token);
        String type = jwt.getClaim("type").asString();
        if ("refresh_token".equals(type)) {
            String username = jwt.getClaim("username").asString();
            String sss = jwt.getClaim("sss").asString();
            return rsa.privateKeyDecrypt(sss).equals(username);
        }
        MyLogger.info("Token过期时间：" + jwt.getExpiresAt());
        return true;
    }
}