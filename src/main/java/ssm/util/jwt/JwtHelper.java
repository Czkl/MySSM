package ssm.util.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import ssm.dao.base.Dao;
import ssm.entity.jwt.AccessToken;

import javax.annotation.Resource;
import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;
import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * 构造jwt及解析jwt
 */
public class JwtHelper {

    public static final String SecretKey = "63d61c57b312464ab8837646788544b804d187a967264125bf42acecec7de8ee";

    private static Claims parseJWT(String jsonWebToken,String base64Security){
        Claims claims = Jwts.parser().setSigningKey(base64Security).parseClaimsJws(jsonWebToken).getBody();
        return claims;
    }




    /**
     * 构造一个jwt
     * 标准中注册的声明 (建议但不强制使用) ：

         iss: jwt签发者
         sub: jwt所面向的用户
         aud: 接收jwt的一方
         exp: jwt的过期时间，这个过期时间必须要大于签发时间
         nbf: 定义在什么时间之前，该jwt都是不可用的.
         iat: jwt的签发时间
         jti: jwt的唯一身份标识，主要用来作为一次性token,从而回避重放攻击。
     * @param base64Security   // service 自定义密钥
     * @return
     */
    public static String createJWT(Map<String,Object> claims,String audience, String issuer, long expMillis, String base64Security){

        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;


        //生成签名密钥
        byte[] apiKeySecretBytes = DatatypeConverter.parseBase64Binary(base64Security);
        Key signKey = new SecretKeySpec(apiKeySecretBytes,signatureAlgorithm.getJcaName());


        // 添加构成JWT的参数
        JwtBuilder builder = Jwts.builder().setHeaderParam("typ","JWT")
                .setClaims(claims)
                .setIssuer(issuer) //签发人
                .setAudience(audience) //接收人
                .signWith(signatureAlgorithm,signKey);

        //添加Token过期时间  定义 exp, nbf
        if(expMillis >= 0){
            Date exp = new Date(expMillis);
            builder.setExpiration(exp);
        }

        //生成JWT
        return builder.compact();
    }

    public static String createSimpleJWT(String userId,String nickName ,long expMillis, String base64Security) {
        Map<String, Object> claims = new HashMap<String, Object>();

        claims.put("sub", userId);
        claims.put("name", nickName);

        return createJWT(claims, null, null,  expMillis, base64Security);


    }


    public static int isLegalToken(String token){
        Claims claims = null;
        try {
             claims = parseJWT(token,SecretKey);
        }catch (Exception e){
            System.err.println("该Token被修改过");
            return -1; // 该Token被修改过
        }
        Object expirationDate = claims.get("exp");

        if(System.currentTimeMillis() <= Long.parseLong(expirationDate.toString())){
            // 有效期失效 拒绝访问
            System.err.println("有效期失效");
            return -2;
        }

        return 200;

    }

}
