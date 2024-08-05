package com.wenxu;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author zhaowenxu
 * @version 1.0
 */
public class JwtTest {

    @Test
    public void testGen() {
        Map<String, Object> claims = new HashMap<>();
        claims.put("id", 1);
        claims.put("username", "张三");

        // 生成jwt的代码
        String token = JWT.create()
                .withClaim("user", claims) //添加载荷
                .withExpiresAt(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 12)) // 添加过期时间12h
                .sign(Algorithm.HMAC256("itheima"));

        // 头部（记录令牌类型和签名算法等）+有效载荷（携带自定义信息）+数字签名（对头部和载荷进行加密计算，防止篡改）
        // eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJleHAiOjE3MjI4NzMyNjksInVzZXIiOnsiaWQiOjEsInVzZXJuYW1lIjoi5byg5LiJIn19.9nOl22cRjyRf23sJvR1L54tVjBhCZ0wGePVxpGhf420
        System.out.println(token);
    }

    @Test
    public void parseToken() {
        String token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9" +
                ".eyJleHAiOjE3MjI4NzMyNjksInVzZXIiOnsiaWQiOjEsInVzZXJuYW1lIjoi5byg5LiJIn19" +
                ".9nOl22cRjyRf23sJvR1L54tVjBhCZ0wGePVxpGhf420";
        JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256("itheima")).build();
        // 验证Token，生成一个解析后的JWT对象
        DecodedJWT decodedJWT = jwtVerifier.verify(token);
        Map<String, Claim> claims = decodedJWT.getClaims();
        System.out.println(claims.get("user"));

        // 验证失败的情况：
        // 1. 篡改了头部和有效载荷
        // 2. 修改了密钥
        // 3. JWT令牌过期
    }
}
